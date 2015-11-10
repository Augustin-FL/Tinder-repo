package com.facebook.stetho;

import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.dumpapp.Dumper;
import com.facebook.stetho.dumpapp.DumperPlugin;
import com.facebook.stetho.dumpapp.RawDumpappHandler;
import com.facebook.stetho.dumpapp.StreamingDumpappHandler;
import com.facebook.stetho.dumpapp.plugins.CrashDumperPlugin;
import com.facebook.stetho.dumpapp.plugins.HprofDumperPlugin;
import com.facebook.stetho.dumpapp.plugins.SharedPreferencesDumperPlugin;
import com.facebook.stetho.inspector.ChromeDevtoolsServer;
import com.facebook.stetho.inspector.ChromeDiscoveryHandler;
import com.facebook.stetho.inspector.database.DefaultDatabaseFilesProvider;
import com.facebook.stetho.inspector.elements.android.AndroidDOMProviderFactory;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.module.CSS;
import com.facebook.stetho.inspector.protocol.module.Console;
import com.facebook.stetho.inspector.protocol.module.DOM;
import com.facebook.stetho.inspector.protocol.module.DOMStorage;
import com.facebook.stetho.inspector.protocol.module.Database;
import com.facebook.stetho.inspector.protocol.module.Debugger;
import com.facebook.stetho.inspector.protocol.module.HeapProfiler;
import com.facebook.stetho.inspector.protocol.module.Inspector;
import com.facebook.stetho.inspector.protocol.module.Network;
import com.facebook.stetho.inspector.protocol.module.Page;
import com.facebook.stetho.inspector.protocol.module.Profiler;
import com.facebook.stetho.inspector.protocol.module.Runtime;
import com.facebook.stetho.inspector.protocol.module.Worker;
import com.facebook.stetho.server.LocalSocketHttpServer;
import com.facebook.stetho.server.RegistryInitializer;
import com.facebook.stetho.websocket.WebSocketHandler;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;
import org.apache.http.protocol.HttpRequestHandlerRegistry;

public class Stetho {
    private static final String LISTENER_THREAD_NAME = "Stetho-Listener";

    /* renamed from: com.facebook.stetho.Stetho.1 */
    static class C06571 extends Thread {
        final /* synthetic */ Initializer val$initializer;

        C06571(String str, Initializer initializer) {
            this.val$initializer = initializer;
            super(str);
        }

        public void run() {
            try {
                new LocalSocketHttpServer(this.val$initializer).run();
            } catch (Throwable e) {
                LogUtil.m937e(e, "Could not start Stetho");
            }
        }
    }

    /* renamed from: com.facebook.stetho.Stetho.2 */
    static class C06582 implements DumperPluginsProvider {
        final /* synthetic */ Context val$context;

        C06582(Context context) {
            this.val$context = context;
        }

        public Iterable<DumperPlugin> get() {
            Iterable arrayList = new ArrayList();
            arrayList.add(new HprofDumperPlugin(this.val$context));
            arrayList.add(new SharedPreferencesDumperPlugin(this.val$context));
            arrayList.add(new CrashDumperPlugin());
            return arrayList;
        }
    }

    /* renamed from: com.facebook.stetho.Stetho.3 */
    static class C06593 implements InspectorModulesProvider {
        final /* synthetic */ Context val$context;

        C06593(Context context) {
            this.val$context = context;
        }

        public Iterable<ChromeDevtoolsDomain> get() {
            Iterable arrayList = new ArrayList();
            arrayList.add(new Console());
            arrayList.add(new CSS());
            arrayList.add(new Debugger());
            if (VERSION.SDK_INT >= 14) {
                arrayList.add(new DOM(new AndroidDOMProviderFactory((Application) this.val$context.getApplicationContext())));
            }
            arrayList.add(new DOMStorage(this.val$context));
            arrayList.add(new HeapProfiler());
            arrayList.add(new Inspector());
            arrayList.add(new Network(this.val$context));
            arrayList.add(new Page(this.val$context));
            arrayList.add(new Profiler());
            arrayList.add(new Runtime());
            arrayList.add(new Worker());
            if (VERSION.SDK_INT >= 11) {
                arrayList.add(new Database(this.val$context, new DefaultDatabaseFilesProvider(this.val$context)));
            }
            return arrayList;
        }
    }

    public static abstract class Initializer implements RegistryInitializer {
        private final Context mContext;

        private static class LoggingCatchAllHandler implements HttpRequestHandler {
            private LoggingCatchAllHandler() {
            }

            public void handle(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
                LogUtil.m947w("Unsupported request received: " + httpRequest.getRequestLine());
                httpResponse.setStatusCode(HttpStatus.SC_NOT_FOUND);
                httpResponse.setReasonPhrase("Not Found");
                httpResponse.setEntity(new StringEntity("Endpoint not implemented\n", HTTP.UTF_8));
            }
        }

        protected abstract Iterable<DumperPlugin> getDumperPlugins();

        protected abstract Iterable<ChromeDevtoolsDomain> getInspectorModules();

        protected Initializer(Context context) {
            this.mContext = context.getApplicationContext();
        }

        public final HttpRequestHandlerRegistry getRegistry() {
            HttpRequestHandlerRegistry httpRequestHandlerRegistry = new HttpRequestHandlerRegistry();
            Iterable dumperPlugins = getDumperPlugins();
            if (dumperPlugins != null) {
                Dumper dumper = new Dumper(dumperPlugins);
                httpRequestHandlerRegistry.register("/dumpapp", new StreamingDumpappHandler(this.mContext, dumper));
                httpRequestHandlerRegistry.register("/dumpapp-raw", new RawDumpappHandler(this.mContext, dumper));
            }
            dumperPlugins = getInspectorModules();
            if (dumperPlugins != null) {
                new ChromeDiscoveryHandler(this.mContext, ChromeDevtoolsServer.PATH).register(httpRequestHandlerRegistry);
                httpRequestHandlerRegistry.register(ChromeDevtoolsServer.PATH, new WebSocketHandler(this.mContext, new ChromeDevtoolsServer(dumperPlugins)));
            }
            addCustomEntries(httpRequestHandlerRegistry);
            httpRequestHandlerRegistry.register("/*", new LoggingCatchAllHandler());
            return httpRequestHandlerRegistry;
        }

        protected void addCustomEntries(HttpRequestHandlerRegistry httpRequestHandlerRegistry) {
        }
    }

    private static class BuilderBasedInitializer extends Initializer {
        private final DumperPluginsProvider mDumperPlugins;
        private final InspectorModulesProvider mInspectorModules;

        private BuilderBasedInitializer(InitializerBuilder initializerBuilder) {
            super(initializerBuilder.mContext);
            this.mDumperPlugins = initializerBuilder.mDumperPlugins;
            this.mInspectorModules = initializerBuilder.mInspectorModules;
        }

        protected Iterable<DumperPlugin> getDumperPlugins() {
            return this.mDumperPlugins != null ? this.mDumperPlugins.get() : null;
        }

        protected Iterable<ChromeDevtoolsDomain> getInspectorModules() {
            return this.mInspectorModules != null ? this.mInspectorModules.get() : null;
        }
    }

    public static class InitializerBuilder {
        final Context mContext;
        DumperPluginsProvider mDumperPlugins;
        InspectorModulesProvider mInspectorModules;

        private InitializerBuilder(Context context) {
            this.mContext = context.getApplicationContext();
        }

        public InitializerBuilder enableDumpapp(DumperPluginsProvider dumperPluginsProvider) {
            this.mDumperPlugins = (DumperPluginsProvider) Util.throwIfNull(dumperPluginsProvider);
            return this;
        }

        public InitializerBuilder enableWebKitInspector(InspectorModulesProvider inspectorModulesProvider) {
            this.mInspectorModules = inspectorModulesProvider;
            return this;
        }

        public Initializer build() {
            return new BuilderBasedInitializer();
        }
    }

    private Stetho() {
    }

    public static InitializerBuilder newInitializerBuilder(Context context) {
        return new InitializerBuilder(null);
    }

    public static void initialize(Initializer initializer) {
        new C06571(LISTENER_THREAD_NAME, initializer).start();
    }

    public static DumperPluginsProvider defaultDumperPluginsProvider(Context context) {
        return new C06582(context);
    }

    public static InspectorModulesProvider defaultInspectorModulesProvider(Context context) {
        return new C06593(context);
    }
}

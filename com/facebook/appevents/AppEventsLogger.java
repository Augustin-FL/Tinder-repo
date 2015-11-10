package com.facebook.appevents;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.internal.AppEventsLoggerUtility;
import com.facebook.internal.AppEventsLoggerUtility.GraphAPIActivityType;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Logger;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.FetchedAppSettings;
import com.facebook.internal.Validate;
import com.google.android.gms.location.LocationStatusCodes;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.C0005c;

public class AppEventsLogger {
    public static final String ACTION_APP_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_FLUSHED";
    public static final String APP_EVENTS_EXTRA_FLUSH_RESULT = "com.facebook.sdk.APP_EVENTS_FLUSH_RESULT";
    public static final String APP_EVENTS_EXTRA_NUM_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED";
    public static final String APP_EVENT_PREFERENCES = "com.facebook.sdk.appEventPreferences";
    private static final int APP_SUPPORTS_ATTRIBUTION_ID_RECHECK_PERIOD_IN_SECONDS = 86400;
    private static final int FLUSH_APP_SESSION_INFO_IN_SECONDS = 30;
    private static final int FLUSH_PERIOD_IN_SECONDS = 15;
    private static final int NUM_LOG_EVENTS_TO_TRY_TO_FLUSH_AFTER = 100;
    private static final String SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT = "_fbSourceApplicationHasBeenSet";
    private static final String TAG;
    private static String anonymousAppDeviceGUID;
    private static Context applicationContext;
    private static ScheduledThreadPoolExecutor backgroundExecutor;
    private static FlushBehavior flushBehavior;
    private static boolean isOpenedByApplink;
    private static boolean requestInFlight;
    private static String sourceApplication;
    private static Map<AccessTokenAppIdPair, SessionEventsState> stateMap;
    private static Object staticLock;
    private final AccessTokenAppIdPair accessTokenAppId;
    private final String contextName;

    /* renamed from: com.facebook.appevents.AppEventsLogger.1 */
    static class C05101 implements Runnable {
        final /* synthetic */ long val$eventTime;
        final /* synthetic */ AppEventsLogger val$logger;
        final /* synthetic */ String val$sourceApplicationInfo;

        C05101(AppEventsLogger appEventsLogger, long j, String str) {
            this.val$logger = appEventsLogger;
            this.val$eventTime = j;
            this.val$sourceApplicationInfo = str;
        }

        public void run() {
            this.val$logger.logAppSessionResumeEvent(this.val$eventTime, this.val$sourceApplicationInfo);
        }
    }

    /* renamed from: com.facebook.appevents.AppEventsLogger.2 */
    static class C05112 implements Runnable {
        final /* synthetic */ long val$eventTime;
        final /* synthetic */ AppEventsLogger val$logger;

        C05112(AppEventsLogger appEventsLogger, long j) {
            this.val$logger = appEventsLogger;
            this.val$eventTime = j;
        }

        public void run() {
            this.val$logger.logAppSessionSuspendEvent(this.val$eventTime);
        }
    }

    /* renamed from: com.facebook.appevents.AppEventsLogger.3 */
    static class C05123 implements Runnable {
        C05123() {
        }

        public void run() {
            if (AppEventsLogger.getFlushBehavior() != FlushBehavior.EXPLICIT_ONLY) {
                AppEventsLogger.flushAndWait(FlushReason.TIMER);
            }
        }
    }

    /* renamed from: com.facebook.appevents.AppEventsLogger.4 */
    static class C05134 implements Runnable {
        C05134() {
        }

        public void run() {
            Set<String> hashSet = new HashSet();
            synchronized (AppEventsLogger.staticLock) {
                for (AccessTokenAppIdPair applicationId : AppEventsLogger.stateMap.keySet()) {
                    hashSet.add(applicationId.getApplicationId());
                }
            }
            for (String queryAppSettings : hashSet) {
                Utility.queryAppSettings(queryAppSettings, true);
            }
        }
    }

    /* renamed from: com.facebook.appevents.AppEventsLogger.5 */
    static class C05145 implements Runnable {
        final /* synthetic */ AccessTokenAppIdPair val$accessTokenAppId;
        final /* synthetic */ Context val$context;
        final /* synthetic */ AppEvent val$event;

        C05145(Context context, AccessTokenAppIdPair accessTokenAppIdPair, AppEvent appEvent) {
            this.val$context = context;
            this.val$accessTokenAppId = accessTokenAppIdPair;
            this.val$event = appEvent;
        }

        public void run() {
            AppEventsLogger.getSessionEventsState(this.val$context, this.val$accessTokenAppId).addEvent(this.val$event);
            AppEventsLogger.flushIfNecessary();
        }
    }

    /* renamed from: com.facebook.appevents.AppEventsLogger.6 */
    static class C05156 implements Runnable {
        final /* synthetic */ FlushReason val$reason;

        C05156(FlushReason flushReason) {
            this.val$reason = flushReason;
        }

        public void run() {
            AppEventsLogger.flushAndWait(this.val$reason);
        }
    }

    /* renamed from: com.facebook.appevents.AppEventsLogger.7 */
    static class C05167 implements Callback {
        final /* synthetic */ AccessTokenAppIdPair val$accessTokenAppId;
        final /* synthetic */ FlushStatistics val$flushState;
        final /* synthetic */ GraphRequest val$postRequest;
        final /* synthetic */ SessionEventsState val$sessionEventsState;

        C05167(AccessTokenAppIdPair accessTokenAppIdPair, GraphRequest graphRequest, SessionEventsState sessionEventsState, FlushStatistics flushStatistics) {
            this.val$accessTokenAppId = accessTokenAppIdPair;
            this.val$postRequest = graphRequest;
            this.val$sessionEventsState = sessionEventsState;
            this.val$flushState = flushStatistics;
        }

        public void onCompleted(GraphResponse graphResponse) {
            AppEventsLogger.handleResponse(this.val$accessTokenAppId, this.val$postRequest, graphResponse, this.val$sessionEventsState, this.val$flushState);
        }
    }

    private static class AccessTokenAppIdPair implements Serializable {
        private static final long serialVersionUID = 1;
        private final String accessTokenString;
        private final String applicationId;

        private static class SerializationProxyV1 implements Serializable {
            private static final long serialVersionUID = -2488473066578201069L;
            private final String accessTokenString;
            private final String appId;

            private SerializationProxyV1(String str, String str2) {
                this.accessTokenString = str;
                this.appId = str2;
            }

            private Object readResolve() {
                return new AccessTokenAppIdPair(this.accessTokenString, this.appId);
            }
        }

        AccessTokenAppIdPair(AccessToken accessToken) {
            this(accessToken.getToken(), FacebookSdk.getApplicationId());
        }

        AccessTokenAppIdPair(String str, String str2) {
            if (Utility.isNullOrEmpty(str)) {
                str = null;
            }
            this.accessTokenString = str;
            this.applicationId = str2;
        }

        String getAccessTokenString() {
            return this.accessTokenString;
        }

        String getApplicationId() {
            return this.applicationId;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = this.accessTokenString == null ? 0 : this.accessTokenString.hashCode();
            if (this.applicationId != null) {
                i = this.applicationId.hashCode();
            }
            return hashCode ^ i;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof AccessTokenAppIdPair)) {
                return false;
            }
            AccessTokenAppIdPair accessTokenAppIdPair = (AccessTokenAppIdPair) obj;
            if (Utility.areObjectsEqual(accessTokenAppIdPair.accessTokenString, this.accessTokenString) && Utility.areObjectsEqual(accessTokenAppIdPair.applicationId, this.applicationId)) {
                return true;
            }
            return false;
        }

        private Object writeReplace() {
            return new SerializationProxyV1(this.applicationId, null);
        }
    }

    static class AppEvent implements Serializable {
        private static final long serialVersionUID = 1;
        private static final HashSet<String> validatedIdentifiers;
        private boolean isImplicit;
        private JSONObject jsonObject;
        private String name;

        private static class SerializationProxyV1 implements Serializable {
            private static final long serialVersionUID = -2488473066578201069L;
            private final boolean isImplicit;
            private final String jsonString;

            private SerializationProxyV1(String str, boolean z) {
                this.jsonString = str;
                this.isImplicit = z;
            }

            private Object readResolve() throws JSONException {
                return new AppEvent(this.isImplicit, null);
            }
        }

        static {
            validatedIdentifiers = new HashSet();
        }

        public AppEvent(String str, String str2, Double d, Bundle bundle, boolean z) {
            try {
                validateIdentifier(str2);
                this.name = str2;
                this.isImplicit = z;
                this.jsonObject = new JSONObject();
                this.jsonObject.put("_eventName", str2);
                this.jsonObject.put("_logTime", System.currentTimeMillis() / 1000);
                this.jsonObject.put("_ui", str);
                if (d != null) {
                    this.jsonObject.put("_valueToSum", d.doubleValue());
                }
                if (this.isImplicit) {
                    this.jsonObject.put("_implicitlyLogged", AppEventsConstants.EVENT_PARAM_VALUE_YES);
                }
                if (bundle != null) {
                    for (String str3 : bundle.keySet()) {
                        validateIdentifier(str3);
                        Object obj = bundle.get(str3);
                        if ((obj instanceof String) || (obj instanceof Number)) {
                            this.jsonObject.put(str3, obj.toString());
                        } else {
                            throw new FacebookException(String.format("Parameter value '%s' for key '%s' should be a string or a numeric type.", new Object[]{obj, str3}));
                        }
                    }
                }
                if (!this.isImplicit) {
                    Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Created app event '%s'", this.jsonObject.toString());
                }
            } catch (JSONException e) {
                Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "JSON encoding for app event failed: '%s'", e.toString());
                this.jsonObject = null;
            } catch (FacebookException e2) {
                Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Invalid app event name or parameter:", e2.toString());
                this.jsonObject = null;
            }
        }

        public String getName() {
            return this.name;
        }

        private AppEvent(String str, boolean z) throws JSONException {
            this.jsonObject = new JSONObject(str);
            this.isImplicit = z;
        }

        public boolean getIsImplicit() {
            return this.isImplicit;
        }

        public JSONObject getJSONObject() {
            return this.jsonObject;
        }

        private void validateIdentifier(String str) throws FacebookException {
            String str2 = "^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$";
            if (str == null || str.length() == 0 || str.length() > 40) {
                if (str == null) {
                    str = "<None Provided>";
                }
                throw new FacebookException(String.format(Locale.ROOT, "Identifier '%s' must be less than %d characters", new Object[]{str, Integer.valueOf(40)}));
            }
            synchronized (validatedIdentifiers) {
                boolean contains = validatedIdentifiers.contains(str);
            }
            if (!contains) {
                if (str.matches("^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$")) {
                    synchronized (validatedIdentifiers) {
                        validatedIdentifiers.add(str);
                    }
                    return;
                }
                throw new FacebookException(String.format("Skipping event named '%s' due to illegal name - must be under 40 chars and alphanumeric, _, - or space, and not start with a space or hyphen.", new Object[]{str}));
            }
        }

        private Object writeReplace() {
            return new SerializationProxyV1(this.isImplicit, null);
        }

        public String toString() {
            return String.format("\"%s\", implicit: %b, json: %s", new Object[]{this.jsonObject.optString("_eventName"), Boolean.valueOf(this.isImplicit), this.jsonObject.toString()});
        }
    }

    public enum FlushBehavior {
        AUTO,
        EXPLICIT_ONLY
    }

    private enum FlushReason {
        EXPLICIT,
        TIMER,
        SESSION_CHANGE,
        PERSISTED_EVENTS,
        EVENT_THRESHOLD,
        EAGER_FLUSHING_EVENT
    }

    private enum FlushResult {
        SUCCESS,
        SERVER_ERROR,
        NO_CONNECTIVITY,
        UNKNOWN_ERROR
    }

    private static class FlushStatistics {
        public int numEvents;
        public FlushResult result;

        private FlushStatistics() {
            this.numEvents = 0;
            this.result = FlushResult.SUCCESS;
        }
    }

    static class PersistedAppSessionInfo {
        private static final String PERSISTED_SESSION_INFO_FILENAME = "AppEventsLogger.persistedsessioninfo";
        private static final Runnable appSessionInfoFlushRunnable;
        private static Map<AccessTokenAppIdPair, FacebookTimeSpentData> appSessionInfoMap;
        private static boolean hasChanges;
        private static boolean isLoaded;
        private static final Object staticLock;

        /* renamed from: com.facebook.appevents.AppEventsLogger.PersistedAppSessionInfo.1 */
        static class C05171 implements Runnable {
            C05171() {
            }

            public void run() {
                PersistedAppSessionInfo.saveAppSessionInformation(AppEventsLogger.applicationContext);
            }
        }

        PersistedAppSessionInfo() {
        }

        static {
            staticLock = new Object();
            hasChanges = false;
            isLoaded = false;
            appSessionInfoFlushRunnable = new C05171();
        }

        private static void restoreAppSessionInformation(Context context) {
            Exception e;
            Closeable closeable = null;
            synchronized (staticLock) {
                if (!isLoaded) {
                    Closeable objectInputStream;
                    try {
                        objectInputStream = new ObjectInputStream(context.openFileInput(PERSISTED_SESSION_INFO_FILENAME));
                        try {
                            appSessionInfoMap = (HashMap) objectInputStream.readObject();
                            Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "App session info loaded");
                            Utility.closeQuietly(objectInputStream);
                            context.deleteFile(PERSISTED_SESSION_INFO_FILENAME);
                            if (appSessionInfoMap == null) {
                                appSessionInfoMap = new HashMap();
                            }
                            isLoaded = true;
                            hasChanges = false;
                        } catch (FileNotFoundException e2) {
                            closeable = objectInputStream;
                            Utility.closeQuietly(closeable);
                            context.deleteFile(PERSISTED_SESSION_INFO_FILENAME);
                            if (appSessionInfoMap == null) {
                                appSessionInfoMap = new HashMap();
                            }
                            isLoaded = true;
                            hasChanges = false;
                        } catch (Exception e3) {
                            e = e3;
                            try {
                                Log.d(AppEventsLogger.TAG, "Got unexpected exception: " + e.toString());
                                Utility.closeQuietly(objectInputStream);
                                context.deleteFile(PERSISTED_SESSION_INFO_FILENAME);
                                if (appSessionInfoMap == null) {
                                    appSessionInfoMap = new HashMap();
                                }
                                isLoaded = true;
                                hasChanges = false;
                            } catch (Throwable th) {
                                Throwable th2 = th;
                                Utility.closeQuietly(objectInputStream);
                                context.deleteFile(PERSISTED_SESSION_INFO_FILENAME);
                                if (appSessionInfoMap == null) {
                                    appSessionInfoMap = new HashMap();
                                }
                                isLoaded = true;
                                hasChanges = false;
                                throw th2;
                            }
                        }
                    } catch (FileNotFoundException e4) {
                        Utility.closeQuietly(closeable);
                        context.deleteFile(PERSISTED_SESSION_INFO_FILENAME);
                        if (appSessionInfoMap == null) {
                            appSessionInfoMap = new HashMap();
                        }
                        isLoaded = true;
                        hasChanges = false;
                    } catch (Exception e5) {
                        Exception exception = e5;
                        objectInputStream = null;
                        e = exception;
                        Log.d(AppEventsLogger.TAG, "Got unexpected exception: " + e.toString());
                        Utility.closeQuietly(objectInputStream);
                        context.deleteFile(PERSISTED_SESSION_INFO_FILENAME);
                        if (appSessionInfoMap == null) {
                            appSessionInfoMap = new HashMap();
                        }
                        isLoaded = true;
                        hasChanges = false;
                    } catch (Throwable th3) {
                        Throwable th4 = th3;
                        objectInputStream = null;
                        th2 = th4;
                        Utility.closeQuietly(objectInputStream);
                        context.deleteFile(PERSISTED_SESSION_INFO_FILENAME);
                        if (appSessionInfoMap == null) {
                            appSessionInfoMap = new HashMap();
                        }
                        isLoaded = true;
                        hasChanges = false;
                        throw th2;
                    }
                }
            }
        }

        static void saveAppSessionInformation(Context context) {
            Exception e;
            Throwable th;
            synchronized (staticLock) {
                if (hasChanges) {
                    Closeable objectOutputStream;
                    try {
                        objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(context.openFileOutput(PERSISTED_SESSION_INFO_FILENAME, 0)));
                        try {
                            objectOutputStream.writeObject(appSessionInfoMap);
                            hasChanges = false;
                            Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "App session info saved");
                            Utility.closeQuietly(objectOutputStream);
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                Log.d(AppEventsLogger.TAG, "Got unexpected exception: " + e.toString());
                                Utility.closeQuietly(objectOutputStream);
                            } catch (Throwable th2) {
                                th = th2;
                                Utility.closeQuietly(objectOutputStream);
                                throw th;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        objectOutputStream = null;
                        Log.d(AppEventsLogger.TAG, "Got unexpected exception: " + e.toString());
                        Utility.closeQuietly(objectOutputStream);
                    } catch (Throwable th3) {
                        th = th3;
                        objectOutputStream = null;
                        Utility.closeQuietly(objectOutputStream);
                        throw th;
                    }
                }
            }
        }

        static void onResume(Context context, AccessTokenAppIdPair accessTokenAppIdPair, AppEventsLogger appEventsLogger, long j, String str) {
            synchronized (staticLock) {
                getTimeSpentData(context, accessTokenAppIdPair).onResume(appEventsLogger, j, str);
                onTimeSpentDataUpdate();
            }
        }

        static void onSuspend(Context context, AccessTokenAppIdPair accessTokenAppIdPair, AppEventsLogger appEventsLogger, long j) {
            synchronized (staticLock) {
                getTimeSpentData(context, accessTokenAppIdPair).onSuspend(appEventsLogger, j);
                onTimeSpentDataUpdate();
            }
        }

        private static FacebookTimeSpentData getTimeSpentData(Context context, AccessTokenAppIdPair accessTokenAppIdPair) {
            restoreAppSessionInformation(context);
            FacebookTimeSpentData facebookTimeSpentData = (FacebookTimeSpentData) appSessionInfoMap.get(accessTokenAppIdPair);
            if (facebookTimeSpentData != null) {
                return facebookTimeSpentData;
            }
            facebookTimeSpentData = new FacebookTimeSpentData();
            appSessionInfoMap.put(accessTokenAppIdPair, facebookTimeSpentData);
            return facebookTimeSpentData;
        }

        private static void onTimeSpentDataUpdate() {
            if (!hasChanges) {
                hasChanges = true;
                AppEventsLogger.backgroundExecutor.schedule(appSessionInfoFlushRunnable, 30, TimeUnit.SECONDS);
            }
        }
    }

    static class PersistedEvents {
        static final String PERSISTED_EVENTS_FILENAME = "AppEventsLogger.persistedevents";
        private static Object staticLock;
        private Context context;
        private HashMap<AccessTokenAppIdPair, List<AppEvent>> persistedEvents;

        static {
            staticLock = new Object();
        }

        private PersistedEvents(Context context) {
            this.persistedEvents = new HashMap();
            this.context = context;
        }

        public static PersistedEvents readAndClearStore(Context context) {
            PersistedEvents persistedEvents;
            synchronized (staticLock) {
                persistedEvents = new PersistedEvents(context);
                persistedEvents.readAndClearStore();
            }
            return persistedEvents;
        }

        public static void persistEvents(Context context, AccessTokenAppIdPair accessTokenAppIdPair, SessionEventsState sessionEventsState) {
            Map hashMap = new HashMap();
            hashMap.put(accessTokenAppIdPair, sessionEventsState);
            persistEvents(context, hashMap);
        }

        public static void persistEvents(Context context, Map<AccessTokenAppIdPair, SessionEventsState> map) {
            synchronized (staticLock) {
                PersistedEvents readAndClearStore = readAndClearStore(context);
                for (Entry entry : map.entrySet()) {
                    List eventsToPersist = ((SessionEventsState) entry.getValue()).getEventsToPersist();
                    if (eventsToPersist.size() != 0) {
                        readAndClearStore.addEvents((AccessTokenAppIdPair) entry.getKey(), eventsToPersist);
                    }
                }
                readAndClearStore.write();
            }
        }

        public Set<AccessTokenAppIdPair> keySet() {
            return this.persistedEvents.keySet();
        }

        public List<AppEvent> getEvents(AccessTokenAppIdPair accessTokenAppIdPair) {
            return (List) this.persistedEvents.get(accessTokenAppIdPair);
        }

        private void write() {
            Exception e;
            Throwable th;
            Closeable objectOutputStream;
            try {
                objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(this.context.openFileOutput(PERSISTED_EVENTS_FILENAME, 0)));
                try {
                    objectOutputStream.writeObject(this.persistedEvents);
                    Utility.closeQuietly(objectOutputStream);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        Log.d(AppEventsLogger.TAG, "Got unexpected exception: " + e.toString());
                        Utility.closeQuietly(objectOutputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        Utility.closeQuietly(objectOutputStream);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                objectOutputStream = null;
                Log.d(AppEventsLogger.TAG, "Got unexpected exception: " + e.toString());
                Utility.closeQuietly(objectOutputStream);
            } catch (Throwable th3) {
                th = th3;
                objectOutputStream = null;
                Utility.closeQuietly(objectOutputStream);
                throw th;
            }
        }

        private void readAndClearStore() {
            Closeable objectInputStream;
            Exception e;
            Throwable th;
            Closeable closeable = null;
            try {
                objectInputStream = new ObjectInputStream(new BufferedInputStream(this.context.openFileInput(PERSISTED_EVENTS_FILENAME)));
                try {
                    HashMap hashMap = (HashMap) objectInputStream.readObject();
                    this.context.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                    this.persistedEvents = hashMap;
                    Utility.closeQuietly(objectInputStream);
                } catch (FileNotFoundException e2) {
                    closeable = objectInputStream;
                    Utility.closeQuietly(closeable);
                } catch (Exception e3) {
                    e = e3;
                    try {
                        Log.d(AppEventsLogger.TAG, "Got unexpected exception: " + e.toString());
                        Utility.closeQuietly(objectInputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        Utility.closeQuietly(objectInputStream);
                        throw th;
                    }
                }
            } catch (FileNotFoundException e4) {
                Utility.closeQuietly(closeable);
            } catch (Exception e5) {
                Exception exception = e5;
                objectInputStream = null;
                e = exception;
                Log.d(AppEventsLogger.TAG, "Got unexpected exception: " + e.toString());
                Utility.closeQuietly(objectInputStream);
            } catch (Throwable th3) {
                Throwable th4 = th3;
                objectInputStream = null;
                th = th4;
                Utility.closeQuietly(objectInputStream);
                throw th;
            }
        }

        public void addEvents(AccessTokenAppIdPair accessTokenAppIdPair, List<AppEvent> list) {
            if (!this.persistedEvents.containsKey(accessTokenAppIdPair)) {
                this.persistedEvents.put(accessTokenAppIdPair, new ArrayList());
            }
            ((List) this.persistedEvents.get(accessTokenAppIdPair)).addAll(list);
        }
    }

    static class SessionEventsState {
        public static final String ENCODED_EVENTS_KEY = "encoded_events";
        public static final String EVENT_COUNT_KEY = "event_count";
        public static final String NUM_SKIPPED_KEY = "num_skipped";
        private final int MAX_ACCUMULATED_LOG_EVENTS;
        private List<AppEvent> accumulatedEvents;
        private String anonymousAppDeviceGUID;
        private AttributionIdentifiers attributionIdentifiers;
        private List<AppEvent> inFlightEvents;
        private int numSkippedEventsDueToFullBuffer;
        private String packageName;

        public SessionEventsState(AttributionIdentifiers attributionIdentifiers, String str, String str2) {
            this.accumulatedEvents = new ArrayList();
            this.inFlightEvents = new ArrayList();
            this.MAX_ACCUMULATED_LOG_EVENTS = LocationStatusCodes.GEOFENCE_NOT_AVAILABLE;
            this.attributionIdentifiers = attributionIdentifiers;
            this.packageName = str;
            this.anonymousAppDeviceGUID = str2;
        }

        public synchronized void addEvent(AppEvent appEvent) {
            if (this.accumulatedEvents.size() + this.inFlightEvents.size() >= LocationStatusCodes.GEOFENCE_NOT_AVAILABLE) {
                this.numSkippedEventsDueToFullBuffer++;
            } else {
                this.accumulatedEvents.add(appEvent);
            }
        }

        public synchronized int getAccumulatedEventCount() {
            return this.accumulatedEvents.size();
        }

        public synchronized void clearInFlightAndStats(boolean z) {
            if (z) {
                this.accumulatedEvents.addAll(this.inFlightEvents);
            }
            this.inFlightEvents.clear();
            this.numSkippedEventsDueToFullBuffer = 0;
        }

        public int populateRequest(GraphRequest graphRequest, boolean z, boolean z2) {
            synchronized (this) {
                int i = this.numSkippedEventsDueToFullBuffer;
                this.inFlightEvents.addAll(this.accumulatedEvents);
                this.accumulatedEvents.clear();
                JSONArray jSONArray = new JSONArray();
                for (AppEvent appEvent : this.inFlightEvents) {
                    if (z || !appEvent.getIsImplicit()) {
                        jSONArray.put(appEvent.getJSONObject());
                    }
                }
                if (jSONArray.length() == 0) {
                    return 0;
                }
                populateRequest(graphRequest, i, jSONArray, z2);
                return jSONArray.length();
            }
        }

        public synchronized List<AppEvent> getEventsToPersist() {
            List<AppEvent> list;
            list = this.accumulatedEvents;
            this.accumulatedEvents = new ArrayList();
            return list;
        }

        public synchronized void accumulatePersistedEvents(List<AppEvent> list) {
            this.accumulatedEvents.addAll(list);
        }

        private void populateRequest(GraphRequest graphRequest, int i, JSONArray jSONArray, boolean z) {
            JSONObject jSONObjectForGraphAPICall;
            try {
                jSONObjectForGraphAPICall = AppEventsLoggerUtility.getJSONObjectForGraphAPICall(GraphAPIActivityType.CUSTOM_APP_EVENTS, this.attributionIdentifiers, this.anonymousAppDeviceGUID, z, AppEventsLogger.applicationContext);
                if (this.numSkippedEventsDueToFullBuffer > 0) {
                    jSONObjectForGraphAPICall.put("num_skipped_events", i);
                }
            } catch (JSONException e) {
                jSONObjectForGraphAPICall = new JSONObject();
            }
            graphRequest.setGraphObject(jSONObjectForGraphAPICall);
            Bundle parameters = graphRequest.getParameters();
            if (parameters == null) {
                parameters = new Bundle();
            }
            String jSONArray2 = jSONArray.toString();
            if (jSONArray2 != null) {
                parameters.putByteArray("custom_events_file", getStringAsByteArray(jSONArray2));
                graphRequest.setTag(jSONArray2);
            }
            graphRequest.setParameters(parameters);
        }

        private byte[] getStringAsByteArray(String str) {
            byte[] bArr = null;
            try {
                bArr = str.getBytes(HTTP.UTF_8);
            } catch (Exception e) {
                Utility.logd("Encoding exception: ", e);
            }
            return bArr;
        }
    }

    static {
        TAG = AppEventsLogger.class.getCanonicalName();
        stateMap = new ConcurrentHashMap();
        flushBehavior = FlushBehavior.AUTO;
        staticLock = new Object();
    }

    public static void activateApp(Context context) {
        FacebookSdk.sdkInitialize(context);
        activateApp(context, Utility.getMetadataApplicationId(context));
    }

    public static void activateApp(Context context, String str) {
        if (context == null || str == null) {
            throw new IllegalArgumentException("Both context and applicationId must be non-null");
        }
        if (context instanceof Activity) {
            setSourceApplication((Activity) context);
        } else {
            resetSourceApplication();
            Log.d(AppEventsLogger.class.getName(), "To set source application the context of activateApp must be an instance of Activity");
        }
        FacebookSdk.publishInstallAsync(context, str);
        backgroundExecutor.execute(new C05101(new AppEventsLogger(context, str, null), System.currentTimeMillis(), getSourceApplication()));
    }

    public static void deactivateApp(Context context) {
        deactivateApp(context, Utility.getMetadataApplicationId(context));
    }

    public static void deactivateApp(Context context, String str) {
        if (context == null || str == null) {
            throw new IllegalArgumentException("Both context and applicationId must be non-null");
        }
        resetSourceApplication();
        backgroundExecutor.execute(new C05112(new AppEventsLogger(context, str, null), System.currentTimeMillis()));
    }

    private void logAppSessionResumeEvent(long j, String str) {
        PersistedAppSessionInfo.onResume(applicationContext, this.accessTokenAppId, this, j, str);
    }

    private void logAppSessionSuspendEvent(long j) {
        PersistedAppSessionInfo.onSuspend(applicationContext, this.accessTokenAppId, this, j);
    }

    public static AppEventsLogger newLogger(Context context) {
        return new AppEventsLogger(context, null, null);
    }

    public static AppEventsLogger newLogger(Context context, AccessToken accessToken) {
        return new AppEventsLogger(context, null, accessToken);
    }

    public static AppEventsLogger newLogger(Context context, String str, AccessToken accessToken) {
        return new AppEventsLogger(context, str, accessToken);
    }

    public static AppEventsLogger newLogger(Context context, String str) {
        return new AppEventsLogger(context, str, null);
    }

    public static FlushBehavior getFlushBehavior() {
        FlushBehavior flushBehavior;
        synchronized (staticLock) {
            flushBehavior = flushBehavior;
        }
        return flushBehavior;
    }

    public static void setFlushBehavior(FlushBehavior flushBehavior) {
        synchronized (staticLock) {
            flushBehavior = flushBehavior;
        }
    }

    public void logEvent(String str) {
        logEvent(str, null);
    }

    public void logEvent(String str, double d) {
        logEvent(str, d, null);
    }

    public void logEvent(String str, Bundle bundle) {
        logEvent(str, null, bundle, false);
    }

    public void logEvent(String str, double d, Bundle bundle) {
        logEvent(str, Double.valueOf(d), bundle, false);
    }

    public void logPurchase(BigDecimal bigDecimal, Currency currency) {
        logPurchase(bigDecimal, currency, null);
    }

    public void logPurchase(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        if (bigDecimal == null) {
            notifyDeveloperError("purchaseAmount cannot be null");
        } else if (currency == null) {
            notifyDeveloperError("currency cannot be null");
        } else {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString(AppEventsConstants.EVENT_PARAM_CURRENCY, currency.getCurrencyCode());
            logEvent(AppEventsConstants.EVENT_NAME_PURCHASED, bigDecimal.doubleValue(), bundle);
            eagerFlush();
        }
    }

    public void flush() {
        flush(FlushReason.EXPLICIT);
    }

    public static void onContextStop() {
        PersistedEvents.persistEvents(applicationContext, stateMap);
    }

    public boolean isValidForAccessToken(AccessToken accessToken) {
        return this.accessTokenAppId.equals(new AccessTokenAppIdPair(accessToken));
    }

    public void logSdkEvent(String str, Double d, Bundle bundle) {
        logEvent(str, d, bundle, true);
    }

    public String getApplicationId() {
        return this.accessTokenAppId.getApplicationId();
    }

    private AppEventsLogger(Context context, String str, AccessToken accessToken) {
        Validate.notNull(context, "context");
        this.contextName = Utility.getActivityName(context);
        if (accessToken == null) {
            accessToken = AccessToken.getCurrentAccessToken();
        }
        if (accessToken == null || !(str == null || str.equals(accessToken.getApplicationId()))) {
            if (str == null) {
                str = Utility.getMetadataApplicationId(context);
            }
            this.accessTokenAppId = new AccessTokenAppIdPair(null, str);
        } else {
            this.accessTokenAppId = new AccessTokenAppIdPair(accessToken);
        }
        synchronized (staticLock) {
            if (applicationContext == null) {
                applicationContext = context.getApplicationContext();
            }
        }
        initializeTimersIfNeeded();
    }

    private static void initializeTimersIfNeeded() {
        synchronized (staticLock) {
            if (backgroundExecutor != null) {
                return;
            }
            backgroundExecutor = new ScheduledThreadPoolExecutor(1);
            backgroundExecutor.scheduleAtFixedRate(new C05123(), 0, 15, TimeUnit.SECONDS);
            backgroundExecutor.scheduleAtFixedRate(new C05134(), 0, 86400, TimeUnit.SECONDS);
        }
    }

    private void logEvent(String str, Double d, Bundle bundle, boolean z) {
        logEvent(applicationContext, new AppEvent(this.contextName, str, d, bundle, z), this.accessTokenAppId);
    }

    private static void logEvent(Context context, AppEvent appEvent, AccessTokenAppIdPair accessTokenAppIdPair) {
        FacebookSdk.getExecutor().execute(new C05145(context, accessTokenAppIdPair, appEvent));
    }

    static void eagerFlush() {
        if (getFlushBehavior() != FlushBehavior.EXPLICIT_ONLY) {
            flush(FlushReason.EAGER_FLUSHING_EVENT);
        }
    }

    private static void flushIfNecessary() {
        synchronized (staticLock) {
            if (getFlushBehavior() != FlushBehavior.EXPLICIT_ONLY && getAccumulatedEventCount() > NUM_LOG_EVENTS_TO_TRY_TO_FLUSH_AFTER) {
                flush(FlushReason.EVENT_THRESHOLD);
            }
        }
    }

    private static int getAccumulatedEventCount() {
        int i;
        synchronized (staticLock) {
            i = 0;
            for (SessionEventsState accumulatedEventCount : stateMap.values()) {
                i = accumulatedEventCount.getAccumulatedEventCount() + i;
            }
        }
        return i;
    }

    private static SessionEventsState getSessionEventsState(Context context, AccessTokenAppIdPair accessTokenAppIdPair) {
        SessionEventsState sessionEventsState;
        AttributionIdentifiers attributionIdentifiers = null;
        if (((SessionEventsState) stateMap.get(accessTokenAppIdPair)) == null) {
            attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(context);
        }
        synchronized (staticLock) {
            sessionEventsState = (SessionEventsState) stateMap.get(accessTokenAppIdPair);
            if (sessionEventsState == null) {
                sessionEventsState = new SessionEventsState(attributionIdentifiers, context.getPackageName(), getAnonymousAppDeviceGUID(context));
                stateMap.put(accessTokenAppIdPair, sessionEventsState);
            }
        }
        return sessionEventsState;
    }

    private static SessionEventsState getSessionEventsState(AccessTokenAppIdPair accessTokenAppIdPair) {
        SessionEventsState sessionEventsState;
        synchronized (staticLock) {
            sessionEventsState = (SessionEventsState) stateMap.get(accessTokenAppIdPair);
        }
        return sessionEventsState;
    }

    private static void flush(FlushReason flushReason) {
        FacebookSdk.getExecutor().execute(new C05156(flushReason));
    }

    private static void flushAndWait(FlushReason flushReason) {
        synchronized (staticLock) {
            if (requestInFlight) {
                return;
            }
            requestInFlight = true;
            Set hashSet = new HashSet(stateMap.keySet());
            accumulatePersistedEvents();
            FlushStatistics flushStatistics = null;
            try {
                flushStatistics = buildAndExecuteRequests(flushReason, hashSet);
            } catch (Throwable e) {
                Utility.logd(TAG, "Caught unexpected exception while flushing: ", e);
            }
            synchronized (staticLock) {
                requestInFlight = false;
            }
            if (flushStatistics != null) {
                Intent intent = new Intent(ACTION_APP_EVENTS_FLUSHED);
                intent.putExtra(APP_EVENTS_EXTRA_NUM_EVENTS_FLUSHED, flushStatistics.numEvents);
                intent.putExtra(APP_EVENTS_EXTRA_FLUSH_RESULT, flushStatistics.result);
                LocalBroadcastManager.getInstance(applicationContext).sendBroadcast(intent);
            }
        }
    }

    private static FlushStatistics buildAndExecuteRequests(FlushReason flushReason, Set<AccessTokenAppIdPair> set) {
        FlushStatistics flushStatistics = new FlushStatistics();
        boolean limitEventAndDataUsage = FacebookSdk.getLimitEventAndDataUsage(applicationContext);
        List<GraphRequest> arrayList = new ArrayList();
        for (AccessTokenAppIdPair accessTokenAppIdPair : set) {
            GraphRequest buildRequestForSession;
            SessionEventsState sessionEventsState = getSessionEventsState(accessTokenAppIdPair);
            if (sessionEventsState != null) {
                buildRequestForSession = buildRequestForSession(accessTokenAppIdPair, sessionEventsState, limitEventAndDataUsage, flushStatistics);
                if (buildRequestForSession != null) {
                    arrayList.add(buildRequestForSession);
                }
            }
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Flushing %d events due to %s.", Integer.valueOf(flushStatistics.numEvents), flushReason.toString());
        for (GraphRequest buildRequestForSession2 : arrayList) {
            buildRequestForSession2.executeAndWait();
        }
        return flushStatistics;
    }

    private static GraphRequest buildRequestForSession(AccessTokenAppIdPair accessTokenAppIdPair, SessionEventsState sessionEventsState, boolean z, FlushStatistics flushStatistics) {
        FetchedAppSettings queryAppSettings = Utility.queryAppSettings(accessTokenAppIdPair.getApplicationId(), false);
        GraphRequest newPostRequest = GraphRequest.newPostRequest(null, String.format("%s/activities", new Object[]{r0}), null, null);
        Bundle parameters = newPostRequest.getParameters();
        if (parameters == null) {
            parameters = new Bundle();
        }
        parameters.putString(ServerProtocol.DIALOG_PARAM_ACCESS_TOKEN, accessTokenAppIdPair.getAccessTokenString());
        newPostRequest.setParameters(parameters);
        if (queryAppSettings == null) {
            return null;
        }
        int populateRequest = sessionEventsState.populateRequest(newPostRequest, queryAppSettings.supportsImplicitLogging(), z);
        if (populateRequest == 0) {
            return null;
        }
        flushStatistics.numEvents = populateRequest + flushStatistics.numEvents;
        newPostRequest.setCallback(new C05167(accessTokenAppIdPair, newPostRequest, sessionEventsState, flushStatistics));
        return newPostRequest;
    }

    private static void handleResponse(AccessTokenAppIdPair accessTokenAppIdPair, GraphRequest graphRequest, GraphResponse graphResponse, SessionEventsState sessionEventsState, FlushStatistics flushStatistics) {
        FlushResult flushResult;
        FacebookRequestError error = graphResponse.getError();
        String str = "Success";
        FlushResult flushResult2 = FlushResult.SUCCESS;
        String str2;
        if (error == null) {
            str2 = str;
            flushResult = flushResult2;
        } else if (error.getErrorCode() == -1) {
            Object obj = "Failed: No Connectivity";
            flushResult = FlushResult.NO_CONNECTIVITY;
        } else {
            str2 = String.format("Failed:\n  Response: %s\n  Error %s", new Object[]{graphResponse.toString(), error.toString()});
            flushResult = FlushResult.SERVER_ERROR;
        }
        if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.APP_EVENTS)) {
            String jSONArray;
            try {
                jSONArray = new JSONArray((String) graphRequest.getTag()).toString(2);
            } catch (JSONException e) {
                jSONArray = "<Can't encode events for debug logging>";
            }
            Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Flush completed\nParams: %s\n  Result: %s\n  Events JSON: %s", graphRequest.getGraphObject().toString(), obj, jSONArray);
        }
        sessionEventsState.clearInFlightAndStats(error != null);
        if (flushResult == FlushResult.NO_CONNECTIVITY) {
            PersistedEvents.persistEvents(applicationContext, accessTokenAppIdPair, sessionEventsState);
        }
        if (flushResult != FlushResult.SUCCESS && flushStatistics.result != FlushResult.NO_CONNECTIVITY) {
            flushStatistics.result = flushResult;
        }
    }

    private static int accumulatePersistedEvents() {
        PersistedEvents readAndClearStore = PersistedEvents.readAndClearStore(applicationContext);
        int i = 0;
        for (AccessTokenAppIdPair accessTokenAppIdPair : readAndClearStore.keySet()) {
            SessionEventsState sessionEventsState = getSessionEventsState(applicationContext, accessTokenAppIdPair);
            List events = readAndClearStore.getEvents(accessTokenAppIdPair);
            sessionEventsState.accumulatePersistedEvents(events);
            i = events.size() + i;
        }
        return i;
    }

    private static void notifyDeveloperError(String str) {
        Logger.log(LoggingBehavior.DEVELOPER_ERRORS, "AppEvents", str);
    }

    private static void setSourceApplication(Activity activity) {
        ComponentName callingActivity = activity.getCallingActivity();
        if (callingActivity != null) {
            String packageName = callingActivity.getPackageName();
            if (packageName.equals(activity.getPackageName())) {
                resetSourceApplication();
                return;
            }
            sourceApplication = packageName;
        }
        Intent intent = activity.getIntent();
        if (intent == null || intent.getBooleanExtra(SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT, false)) {
            resetSourceApplication();
            return;
        }
        Bundle a = C0005c.m3a(intent);
        if (a == null) {
            resetSourceApplication();
            return;
        }
        isOpenedByApplink = true;
        a = a.getBundle("referer_app_link");
        if (a == null) {
            sourceApplication = null;
            return;
        }
        sourceApplication = a.getString("package");
        intent.putExtra(SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT, true);
    }

    static void setSourceApplication(String str, boolean z) {
        sourceApplication = str;
        isOpenedByApplink = z;
    }

    static String getSourceApplication() {
        String str = "Unclassified";
        if (isOpenedByApplink) {
            str = "Applink";
        }
        if (sourceApplication != null) {
            return str + "(" + sourceApplication + ")";
        }
        return str;
    }

    static void resetSourceApplication() {
        sourceApplication = null;
        isOpenedByApplink = false;
    }

    public static String getAnonymousAppDeviceGUID(Context context) {
        if (anonymousAppDeviceGUID == null) {
            synchronized (staticLock) {
                if (anonymousAppDeviceGUID == null) {
                    anonymousAppDeviceGUID = context.getSharedPreferences(APP_EVENT_PREFERENCES, 0).getString("anonymousAppDeviceGUID", null);
                    if (anonymousAppDeviceGUID == null) {
                        anonymousAppDeviceGUID = "XZ" + UUID.randomUUID().toString();
                        context.getSharedPreferences(APP_EVENT_PREFERENCES, 0).edit().putString("anonymousAppDeviceGUID", anonymousAppDeviceGUID).apply();
                    }
                }
            }
        }
        return anonymousAppDeviceGUID;
    }
}

package io.fabric.sdk.android.services.common;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.facebook.stetho.BuildConfig;
import com.viewpagerindicator.C3169d.C3168f;
import io.fabric.sdk.android.C0347h;
import io.fabric.sdk.android.C3218c;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import org.apache.http.HttpStatus;
import org.json.JSONObject;

public class IdManager {
    private static final Pattern f7051d;
    private static final String f7052e;
    C3243c f7053a;
    C3241b f7054b;
    boolean f7055c;
    private final ReentrantLock f7056f;
    private final C3260m f7057g;
    private final boolean f7058h;
    private final boolean f7059i;
    private final Context f7060j;
    private final String f7061k;
    private final String f7062l;
    private final Collection<C0347h> f7063m;

    public enum DeviceIdentifierType {
        WIFI_MAC_ADDRESS(1),
        BLUETOOTH_MAC_ADDRESS(2),
        FONT_TOKEN(53),
        ANDROID_ID(100),
        ANDROID_DEVICE_ID(HttpStatus.SC_SWITCHING_PROTOCOLS),
        ANDROID_SERIAL(HttpStatus.SC_PROCESSING),
        ANDROID_ADVERTISING_ID(C3168f.Theme_radioButtonStyle);
        
        public final int f7050h;

        private DeviceIdentifierType(int i) {
            this.f7050h = i;
        }
    }

    static {
        f7051d = Pattern.compile("[^\\p{Alnum}]");
        f7052e = Pattern.quote("/");
    }

    public IdManager(Context context, String str, String str2, Collection<C0347h> collection) {
        this.f7056f = new ReentrantLock();
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        } else if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        } else if (collection == null) {
            throw new IllegalArgumentException("kits must not be null");
        } else {
            this.f7060j = context;
            this.f7061k = str;
            this.f7062l = str2;
            this.f7063m = collection;
            this.f7057g = new C3260m();
            this.f7053a = new C3243c(context);
            this.f7058h = CommonUtils.m9858a(context, "com.crashlytics.CollectDeviceIdentifiers", true);
            if (!this.f7058h) {
                C3218c.m9728h().m9687a("Fabric", "Device ID collection disabled for " + context.getPackageName());
            }
            this.f7059i = CommonUtils.m9858a(context, "com.crashlytics.CollectUserIdentifiers", true);
            if (!this.f7059i) {
                C3218c.m9728h().m9687a("Fabric", "User information collection disabled for " + context.getPackageName());
            }
        }
    }

    public String m9891a(String str, String str2) {
        try {
            Cipher a = CommonUtils.m9850a(1, CommonUtils.m9845a(str + str2.replaceAll("\\.", new StringBuilder(new String(new char[]{'s', 'l', 'c'})).reverse().toString())));
            JSONObject jSONObject = new JSONObject();
            m9884a(jSONObject);
            m9887b(jSONObject);
            m9889c(jSONObject);
            m9890d(jSONObject);
            String str3 = BuildConfig.FLAVOR;
            if (jSONObject.length() <= 0) {
                return str3;
            }
            try {
                return CommonUtils.m9847a(a.doFinal(jSONObject.toString().getBytes()));
            } catch (Throwable e) {
                C3218c.m9728h().m9695e("Fabric", "Could not encrypt IDs", e);
                return str3;
            }
        } catch (Throwable e2) {
            C3218c.m9728h().m9695e("Fabric", "Could not create cipher to encrypt headers.", e2);
            return BuildConfig.FLAVOR;
        }
    }

    private void m9884a(JSONObject jSONObject) {
        try {
            jSONObject.put("APPLICATION_INSTALLATION_UUID".toLowerCase(Locale.US), m9893b());
        } catch (Throwable e) {
            C3218c.m9728h().m9695e("Fabric", "Could not write application id to JSON", e);
        }
    }

    private void m9887b(JSONObject jSONObject) {
        for (Entry entry : m9898g().entrySet()) {
            try {
                jSONObject.put(((DeviceIdentifierType) entry.getKey()).name().toLowerCase(Locale.US), entry.getValue());
            } catch (Throwable e) {
                C3218c.m9728h().m9695e("Fabric", "Could not write value to JSON: " + ((DeviceIdentifierType) entry.getKey()).name(), e);
            }
        }
    }

    private void m9889c(JSONObject jSONObject) {
        try {
            jSONObject.put("os_version", m9895d());
        } catch (Throwable e) {
            C3218c.m9728h().m9695e("Fabric", "Could not write OS version to JSON", e);
        }
    }

    private void m9890d(JSONObject jSONObject) {
        try {
            jSONObject.put("model", m9896e());
        } catch (Throwable e) {
            C3218c.m9728h().m9695e("Fabric", "Could not write model to JSON", e);
        }
    }

    public boolean m9892a() {
        return this.f7059i;
    }

    private boolean m9885a(String str) {
        return this.f7060j.checkCallingPermission(str) == 0;
    }

    private String m9886b(String str) {
        return str == null ? null : f7051d.matcher(str).replaceAll(BuildConfig.FLAVOR).toLowerCase(Locale.US);
    }

    public String m9893b() {
        String str = this.f7062l;
        if (str != null) {
            return str;
        }
        SharedPreferences a = CommonUtils.m9840a(this.f7060j);
        str = a.getString("crashlytics.installation.id", null);
        if (str == null) {
            return m9882a(a);
        }
        return str;
    }

    public String m9894c() {
        return this.f7061k;
    }

    public String m9895d() {
        return String.format(Locale.US, "%s/%s", new Object[]{m9888c(VERSION.RELEASE), m9888c(VERSION.INCREMENTAL)});
    }

    public String m9896e() {
        return String.format(Locale.US, "%s/%s", new Object[]{m9888c(Build.MANUFACTURER), m9888c(Build.MODEL)});
    }

    private String m9888c(String str) {
        return str.replaceAll(f7052e, BuildConfig.FLAVOR);
    }

    public String m9897f() {
        String str = BuildConfig.FLAVOR;
        if (!this.f7058h) {
            return str;
        }
        str = m9903l();
        if (str != null) {
            return str;
        }
        SharedPreferences a = CommonUtils.m9840a(this.f7060j);
        str = a.getString("crashlytics.installation.id", null);
        if (str == null) {
            return m9882a(a);
        }
        return str;
    }

    private String m9882a(SharedPreferences sharedPreferences) {
        this.f7056f.lock();
        try {
            String string = sharedPreferences.getString("crashlytics.installation.id", null);
            if (string == null) {
                string = m9886b(UUID.randomUUID().toString());
                sharedPreferences.edit().putString("crashlytics.installation.id", string).commit();
            }
            this.f7056f.unlock();
            return string;
        } catch (Throwable th) {
            this.f7056f.unlock();
        }
    }

    public Map<DeviceIdentifierType, String> m9898g() {
        Map hashMap = new HashMap();
        for (C0347h c0347h : this.f7063m) {
            if (c0347h instanceof C0348k) {
                for (Entry entry : ((C0348k) c0347h).m416e().entrySet()) {
                    m9883a(hashMap, (DeviceIdentifierType) entry.getKey(), (String) entry.getValue());
                }
            }
        }
        m9883a(hashMap, DeviceIdentifierType.ANDROID_ID, m9903l());
        m9883a(hashMap, DeviceIdentifierType.ANDROID_DEVICE_ID, m9904m());
        m9883a(hashMap, DeviceIdentifierType.ANDROID_SERIAL, m9907p());
        m9883a(hashMap, DeviceIdentifierType.WIFI_MAC_ADDRESS, m9905n());
        m9883a(hashMap, DeviceIdentifierType.BLUETOOTH_MAC_ADDRESS, m9906o());
        m9883a(hashMap, DeviceIdentifierType.ANDROID_ADVERTISING_ID, m9902k());
        return Collections.unmodifiableMap(hashMap);
    }

    public String m9899h() {
        return this.f7057g.m9945a(this.f7060j);
    }

    synchronized C3241b m9900i() {
        if (!this.f7055c) {
            this.f7054b = this.f7053a.m9915a();
            this.f7055c = true;
        }
        return this.f7054b;
    }

    public Boolean m9901j() {
        if (!this.f7058h) {
            return null;
        }
        C3241b i = m9900i();
        if (i != null) {
            return Boolean.valueOf(i.f7065b);
        }
        return null;
    }

    public String m9902k() {
        if (!this.f7058h) {
            return null;
        }
        C3241b i = m9900i();
        if (i != null) {
            return i.f7064a;
        }
        return null;
    }

    private void m9883a(Map<DeviceIdentifierType, String> map, DeviceIdentifierType deviceIdentifierType, String str) {
        if (str != null) {
            map.put(deviceIdentifierType, str);
        }
    }

    public String m9903l() {
        if (!this.f7058h) {
            return null;
        }
        String string = Secure.getString(this.f7060j.getContentResolver(), "android_id");
        if ("9774d56d682e549c".equals(string)) {
            return null;
        }
        return m9886b(string);
    }

    public String m9904m() {
        if (this.f7058h && m9885a("android.permission.READ_PHONE_STATE")) {
            TelephonyManager telephonyManager = (TelephonyManager) this.f7060j.getSystemService("phone");
            if (telephonyManager != null) {
                return m9886b(telephonyManager.getDeviceId());
            }
        }
        return null;
    }

    public String m9905n() {
        if (this.f7058h && m9885a("android.permission.ACCESS_WIFI_STATE")) {
            WifiManager wifiManager = (WifiManager) this.f7060j.getSystemService("wifi");
            if (wifiManager != null) {
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                if (connectionInfo != null) {
                    return m9886b(connectionInfo.getMacAddress());
                }
            }
        }
        return null;
    }

    public String m9906o() {
        if (this.f7058h && m9885a("android.permission.BLUETOOTH")) {
            try {
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                if (defaultAdapter != null) {
                    m9886b(defaultAdapter.getAddress());
                }
            } catch (Throwable e) {
                C3218c.m9728h().m9695e("Fabric", "Utils#getBluetoothMacAddress failed, returning null. Requires prior call to BluetoothAdatpter.getDefaultAdapter() on thread that has called Looper.prepare()", e);
            }
        }
        return null;
    }

    public String m9907p() {
        if (this.f7058h && VERSION.SDK_INT >= 9) {
            try {
                return m9886b((String) Build.class.getField("SERIAL").get(null));
            } catch (Throwable e) {
                C3218c.m9728h().m9695e("Fabric", "Could not retrieve android.os.Build.SERIAL value", e);
            }
        }
        return null;
    }
}

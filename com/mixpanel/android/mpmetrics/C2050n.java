package com.mixpanel.android.mpmetrics;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: com.mixpanel.android.mpmetrics.n */
class C2050n {
    private final Context f2913a;
    private final Boolean f2914b;
    private final Boolean f2915c;
    private final DisplayMetrics f2916d;
    private final String f2917e;
    private final Integer f2918f;

    public C2050n(Context context) {
        String str;
        Integer valueOf;
        Object obj;
        Boolean bool;
        Method method;
        Boolean bool2 = null;
        this.f2913a = context;
        PackageManager packageManager = this.f2913a.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(this.f2913a.getPackageName(), 0);
            str = packageInfo.versionName;
            try {
                valueOf = Integer.valueOf(packageInfo.versionCode);
            } catch (NameNotFoundException e) {
                Object obj2 = str;
                Log.w("MixpanelAPI", "System information constructed with a context that apparently doesn't exist.");
                obj = bool;
                valueOf = null;
                this.f2917e = str;
                this.f2918f = valueOf;
                method = packageManager.getClass().getMethod("hasSystemFeature", new Class[]{String.class});
                if (method != null) {
                    bool = null;
                } else {
                    try {
                        bool = (Boolean) method.invoke(packageManager, new Object[]{"android.hardware.nfc"});
                        try {
                            bool2 = (Boolean) method.invoke(packageManager, new Object[]{"android.hardware.telephony"});
                        } catch (InvocationTargetException e2) {
                            Log.w("MixpanelAPI", "System version appeared to support PackageManager.hasSystemFeature, but we were unable to call it.");
                            this.f2914b = bool;
                            this.f2915c = bool2;
                            this.f2916d = new DisplayMetrics();
                            ((WindowManager) this.f2913a.getSystemService("window")).getDefaultDisplay().getMetrics(this.f2916d);
                        } catch (IllegalAccessException e3) {
                            Log.w("MixpanelAPI", "System version appeared to support PackageManager.hasSystemFeature, but we were unable to call it.");
                            this.f2914b = bool;
                            this.f2915c = bool2;
                            this.f2916d = new DisplayMetrics();
                            ((WindowManager) this.f2913a.getSystemService("window")).getDefaultDisplay().getMetrics(this.f2916d);
                        }
                    } catch (InvocationTargetException e4) {
                        bool = null;
                        Log.w("MixpanelAPI", "System version appeared to support PackageManager.hasSystemFeature, but we were unable to call it.");
                        this.f2914b = bool;
                        this.f2915c = bool2;
                        this.f2916d = new DisplayMetrics();
                        ((WindowManager) this.f2913a.getSystemService("window")).getDefaultDisplay().getMetrics(this.f2916d);
                    } catch (IllegalAccessException e5) {
                        bool = null;
                        Log.w("MixpanelAPI", "System version appeared to support PackageManager.hasSystemFeature, but we were unable to call it.");
                        this.f2914b = bool;
                        this.f2915c = bool2;
                        this.f2916d = new DisplayMetrics();
                        ((WindowManager) this.f2913a.getSystemService("window")).getDefaultDisplay().getMetrics(this.f2916d);
                    }
                }
                this.f2914b = bool;
                this.f2915c = bool2;
                this.f2916d = new DisplayMetrics();
                ((WindowManager) this.f2913a.getSystemService("window")).getDefaultDisplay().getMetrics(this.f2916d);
            }
        } catch (NameNotFoundException e6) {
            bool = null;
            Log.w("MixpanelAPI", "System information constructed with a context that apparently doesn't exist.");
            obj = bool;
            valueOf = null;
            this.f2917e = str;
            this.f2918f = valueOf;
            method = packageManager.getClass().getMethod("hasSystemFeature", new Class[]{String.class});
            if (method != null) {
                bool = (Boolean) method.invoke(packageManager, new Object[]{"android.hardware.nfc"});
                bool2 = (Boolean) method.invoke(packageManager, new Object[]{"android.hardware.telephony"});
            } else {
                bool = null;
            }
            this.f2914b = bool;
            this.f2915c = bool2;
            this.f2916d = new DisplayMetrics();
            ((WindowManager) this.f2913a.getSystemService("window")).getDefaultDisplay().getMetrics(this.f2916d);
        }
        this.f2917e = str;
        this.f2918f = valueOf;
        try {
            method = packageManager.getClass().getMethod("hasSystemFeature", new Class[]{String.class});
        } catch (NoSuchMethodException e7) {
            method = null;
        }
        if (method != null) {
            bool = (Boolean) method.invoke(packageManager, new Object[]{"android.hardware.nfc"});
            bool2 = (Boolean) method.invoke(packageManager, new Object[]{"android.hardware.telephony"});
        } else {
            bool = null;
        }
        this.f2914b = bool;
        this.f2915c = bool2;
        this.f2916d = new DisplayMetrics();
        ((WindowManager) this.f2913a.getSystemService("window")).getDefaultDisplay().getMetrics(this.f2916d);
    }

    public String m4819a() {
        return this.f2917e;
    }

    public boolean m4820b() {
        return this.f2914b.booleanValue();
    }

    public boolean m4821c() {
        return this.f2915c.booleanValue();
    }

    public DisplayMetrics m4822d() {
        return this.f2916d;
    }

    public String m4823e() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f2913a.getSystemService("phone");
        if (telephonyManager != null) {
            return telephonyManager.getNetworkOperatorName();
        }
        return null;
    }

    public Boolean m4824f() {
        if (this.f2913a.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
            return Boolean.valueOf(((ConnectivityManager) this.f2913a.getSystemService("connectivity")).getNetworkInfo(1).isConnected());
        }
        return null;
    }

    public Boolean m4825g() {
        Boolean bool = null;
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null) {
                bool = Boolean.valueOf(defaultAdapter.isEnabled());
            }
        } catch (SecurityException e) {
        }
        return bool;
    }

    public String m4826h() {
        if (VERSION.SDK_INT < 8) {
            return null;
        }
        String str = "none";
        if (VERSION.SDK_INT >= 18 && this.f2913a.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            return "ble";
        }
        if (this.f2913a.getPackageManager().hasSystemFeature("android.hardware.bluetooth")) {
            return "classic";
        }
        return str;
    }
}

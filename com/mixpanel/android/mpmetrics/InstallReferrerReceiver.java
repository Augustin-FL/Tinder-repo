package com.mixpanel.android.mpmetrics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.protocol.HTTP;

public class InstallReferrerReceiver extends BroadcastReceiver {
    private final Pattern f2747a;
    private final Pattern f2748b;
    private final Pattern f2749c;
    private final Pattern f2750d;
    private final Pattern f2751e;

    public InstallReferrerReceiver() {
        this.f2747a = Pattern.compile("(^|&)utm_source=([^&#=]*)([#&]|$)");
        this.f2748b = Pattern.compile("(^|&)utm_medium=([^&#=]*)([#&]|$)");
        this.f2749c = Pattern.compile("(^|&)utm_campaign=([^&#=]*)([#&]|$)");
        this.f2750d = Pattern.compile("(^|&)utm_content=([^&#=]*)([#&]|$)");
        this.f2751e = Pattern.compile("(^|&)utm_term=([^&#=]*)([#&]|$)");
    }

    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            CharSequence string = extras.getString("referrer");
            if (string != null) {
                Map hashMap = new HashMap();
                hashMap.put("referrer", string);
                String a = m4613a(this.f2747a.matcher(string));
                if (a != null) {
                    hashMap.put("utm_source", a);
                }
                a = m4613a(this.f2748b.matcher(string));
                if (a != null) {
                    hashMap.put("utm_medium", a);
                }
                a = m4613a(this.f2749c.matcher(string));
                if (a != null) {
                    hashMap.put("utm_campaign", a);
                }
                a = m4613a(this.f2750d.matcher(string));
                if (a != null) {
                    hashMap.put("utm_content", a);
                }
                String a2 = m4613a(this.f2751e.matcher(string));
                if (a2 != null) {
                    hashMap.put("utm_term", a2);
                }
                C2046k.m4795a(context, "com.mixpanel.android.mpmetrics.ReferralInfo", hashMap);
            }
        }
    }

    private String m4613a(Matcher matcher) {
        if (matcher.find()) {
            String group = matcher.group(2);
            if (group != null) {
                try {
                    return URLDecoder.decode(group, HTTP.UTF_8);
                } catch (UnsupportedEncodingException e) {
                    Log.e("Mixpanel InstallReferrer", "Could not decode a parameter into UTF-8");
                }
            }
        }
        return null;
    }
}

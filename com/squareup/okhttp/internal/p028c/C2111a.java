package com.squareup.okhttp.internal.p028c;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.facebook.stetho.BuildConfig;
import com.viewpagerindicator.C3169d.C3168f;
import javax.security.auth.x500.X500Principal;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.LangUtils;

/* renamed from: com.squareup.okhttp.internal.c.a */
final class C2111a {
    private final String f3205a;
    private final int f3206b;
    private int f3207c;
    private int f3208d;
    private int f3209e;
    private int f3210f;
    private char[] f3211g;

    public C2111a(X500Principal x500Principal) {
        this.f3205a = x500Principal.getName("RFC2253");
        this.f3206b = this.f3205a.length();
    }

    private String m5096a() {
        while (this.f3207c < this.f3206b && this.f3211g[this.f3207c] == ' ') {
            this.f3207c++;
        }
        if (this.f3207c == this.f3206b) {
            return null;
        }
        this.f3208d = this.f3207c;
        this.f3207c++;
        while (this.f3207c < this.f3206b && this.f3211g[this.f3207c] != '=' && this.f3211g[this.f3207c] != ' ') {
            this.f3207c++;
        }
        if (this.f3207c >= this.f3206b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f3205a);
        }
        this.f3209e = this.f3207c;
        if (this.f3211g[this.f3207c] == ' ') {
            while (this.f3207c < this.f3206b && this.f3211g[this.f3207c] != '=' && this.f3211g[this.f3207c] == ' ') {
                this.f3207c++;
            }
            if (this.f3211g[this.f3207c] != '=' || this.f3207c == this.f3206b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f3205a);
            }
        }
        this.f3207c++;
        while (this.f3207c < this.f3206b && this.f3211g[this.f3207c] == ' ') {
            this.f3207c++;
        }
        if (this.f3209e - this.f3208d > 4 && this.f3211g[this.f3208d + 3] == '.' && ((this.f3211g[this.f3208d] == 'O' || this.f3211g[this.f3208d] == 'o') && ((this.f3211g[this.f3208d + 1] == 'I' || this.f3211g[this.f3208d + 1] == 'i') && (this.f3211g[this.f3208d + 2] == 'D' || this.f3211g[this.f3208d + 2] == 'd')))) {
            this.f3208d += 4;
        }
        return new String(this.f3211g, this.f3208d, this.f3209e - this.f3208d);
    }

    private String m5097b() {
        this.f3207c++;
        this.f3208d = this.f3207c;
        this.f3209e = this.f3208d;
        while (this.f3207c != this.f3206b) {
            if (this.f3211g[this.f3207c] == '\"') {
                this.f3207c++;
                while (this.f3207c < this.f3206b && this.f3211g[this.f3207c] == ' ') {
                    this.f3207c++;
                }
                return new String(this.f3211g, this.f3208d, this.f3209e - this.f3208d);
            }
            if (this.f3211g[this.f3207c] == '\\') {
                this.f3211g[this.f3209e] = m5100e();
            } else {
                this.f3211g[this.f3209e] = this.f3211g[this.f3207c];
            }
            this.f3207c++;
            this.f3209e++;
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f3205a);
    }

    private String m5098c() {
        if (this.f3207c + 4 >= this.f3206b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f3205a);
        }
        int i;
        this.f3208d = this.f3207c;
        this.f3207c++;
        while (this.f3207c != this.f3206b && this.f3211g[this.f3207c] != '+' && this.f3211g[this.f3207c] != ',' && this.f3211g[this.f3207c] != ';') {
            int i2;
            if (this.f3211g[this.f3207c] == ' ') {
                this.f3209e = this.f3207c;
                this.f3207c++;
                while (this.f3207c < this.f3206b && this.f3211g[this.f3207c] == ' ') {
                    this.f3207c++;
                }
                i = this.f3209e - this.f3208d;
                if (i >= 5 || (i & 1) == 0) {
                    throw new IllegalStateException("Unexpected end of DN: " + this.f3205a);
                }
                byte[] bArr = new byte[(i / 2)];
                int i3 = this.f3208d + 1;
                for (i2 = 0; i2 < bArr.length; i2++) {
                    bArr[i2] = (byte) m5095a(i3);
                    i3 += 2;
                }
                return new String(this.f3211g, this.f3208d, i);
            }
            if (this.f3211g[this.f3207c] >= 'A' && this.f3211g[this.f3207c] <= 'F') {
                char[] cArr = this.f3211g;
                i2 = this.f3207c;
                cArr[i2] = (char) (cArr[i2] + 32);
            }
            this.f3207c++;
        }
        this.f3209e = this.f3207c;
        i = this.f3209e - this.f3208d;
        if (i >= 5) {
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f3205a);
    }

    private String m5099d() {
        this.f3208d = this.f3207c;
        this.f3209e = this.f3207c;
        while (this.f3207c < this.f3206b) {
            char[] cArr;
            int i;
            switch (this.f3211g[this.f3207c]) {
                case HTTP.SP /*32*/:
                    this.f3210f = this.f3209e;
                    this.f3207c++;
                    cArr = this.f3211g;
                    i = this.f3209e;
                    this.f3209e = i + 1;
                    cArr[i] = ' ';
                    while (this.f3207c < this.f3206b && this.f3211g[this.f3207c] == ' ') {
                        cArr = this.f3211g;
                        i = this.f3209e;
                        this.f3209e = i + 1;
                        cArr[i] = ' ';
                        this.f3207c++;
                    }
                    if (this.f3207c != this.f3206b && this.f3211g[this.f3207c] != ',' && this.f3211g[this.f3207c] != '+' && this.f3211g[this.f3207c] != ';') {
                        break;
                    }
                    return new String(this.f3211g, this.f3208d, this.f3210f - this.f3208d);
                    break;
                case C3168f.Theme_dialogPreferredPadding /*43*/:
                case C3168f.Theme_listDividerAlertDialog /*44*/:
                case C3168f.Theme_toolbarNavigationButtonStyle /*59*/:
                    return new String(this.f3211g, this.f3208d, this.f3209e - this.f3208d);
                case C3168f.Theme_alertDialogTheme /*92*/:
                    cArr = this.f3211g;
                    i = this.f3209e;
                    this.f3209e = i + 1;
                    cArr[i] = m5100e();
                    this.f3207c++;
                    break;
                default:
                    cArr = this.f3211g;
                    i = this.f3209e;
                    this.f3209e = i + 1;
                    cArr[i] = this.f3211g[this.f3207c];
                    this.f3207c++;
                    break;
            }
        }
        return new String(this.f3211g, this.f3208d, this.f3209e - this.f3208d);
    }

    private char m5100e() {
        this.f3207c++;
        if (this.f3207c == this.f3206b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f3205a);
        }
        switch (this.f3211g[this.f3207c]) {
            case HTTP.SP /*32*/:
            case C3168f.Theme_actionModePasteDrawable /*34*/:
            case C3168f.Theme_actionModeSelectAllDrawable /*35*/:
            case LangUtils.HASH_OFFSET /*37*/:
            case C3168f.Theme_dialogTheme /*42*/:
            case C3168f.Theme_dialogPreferredPadding /*43*/:
            case C3168f.Theme_listDividerAlertDialog /*44*/:
            case C3168f.Theme_toolbarNavigationButtonStyle /*59*/:
            case C3168f.Theme_popupMenuStyle /*60*/:
            case C3168f.Theme_popupWindowStyle /*61*/:
            case C3168f.Theme_editTextColor /*62*/:
            case C3168f.Theme_alertDialogTheme /*92*/:
            case C3168f.Theme_buttonBarNegativeButtonStyle /*95*/:
                return this.f3211g[this.f3207c];
            default:
                return m5101f();
        }
    }

    private char m5101f() {
        int a = m5095a(this.f3207c);
        this.f3207c++;
        if (a < AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) {
            return (char) a;
        }
        if (a < 192 || a > 247) {
            return '?';
        }
        int i;
        if (a <= 223) {
            i = 1;
            a &= 31;
        } else if (a <= 239) {
            i = 2;
            a &= 15;
        } else {
            i = 3;
            a &= 7;
        }
        int i2 = a;
        for (a = 0; a < i; a++) {
            this.f3207c++;
            if (this.f3207c == this.f3206b || this.f3211g[this.f3207c] != '\\') {
                return '?';
            }
            this.f3207c++;
            int a2 = m5095a(this.f3207c);
            this.f3207c++;
            if ((a2 & 192) != AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) {
                return '?';
            }
            i2 = (i2 << 6) + (a2 & 63);
        }
        return (char) i2;
    }

    private int m5095a(int i) {
        if (i + 1 >= this.f3206b) {
            throw new IllegalStateException("Malformed DN: " + this.f3205a);
        }
        int i2;
        int i3;
        char c = this.f3211g[i];
        if (c >= '0' && c <= '9') {
            i2 = c - 48;
        } else if (c >= 'a' && c <= 'f') {
            i2 = c - 87;
        } else if (c < 'A' || c > 'F') {
            throw new IllegalStateException("Malformed DN: " + this.f3205a);
        } else {
            i2 = c - 55;
        }
        char c2 = this.f3211g[i + 1];
        if (c2 >= '0' && c2 <= '9') {
            i3 = c2 - 48;
        } else if (c2 >= 'a' && c2 <= 'f') {
            i3 = c2 - 87;
        } else if (c2 < 'A' || c2 > 'F') {
            throw new IllegalStateException("Malformed DN: " + this.f3205a);
        } else {
            i3 = c2 - 55;
        }
        return (i2 << 4) + i3;
    }

    public String m5102a(String str) {
        this.f3207c = 0;
        this.f3208d = 0;
        this.f3209e = 0;
        this.f3210f = 0;
        this.f3211g = this.f3205a.toCharArray();
        String a = m5096a();
        if (a == null) {
            return null;
        }
        do {
            String str2 = BuildConfig.FLAVOR;
            if (this.f3207c == this.f3206b) {
                return null;
            }
            switch (this.f3211g[this.f3207c]) {
                case C3168f.Theme_actionModePasteDrawable /*34*/:
                    str2 = m5097b();
                    break;
                case C3168f.Theme_actionModeSelectAllDrawable /*35*/:
                    str2 = m5098c();
                    break;
                case C3168f.Theme_dialogPreferredPadding /*43*/:
                case C3168f.Theme_listDividerAlertDialog /*44*/:
                case C3168f.Theme_toolbarNavigationButtonStyle /*59*/:
                    break;
                default:
                    str2 = m5099d();
                    break;
            }
            if (str.equalsIgnoreCase(a)) {
                return str2;
            }
            if (this.f3207c >= this.f3206b) {
                return null;
            }
            if (this.f3211g[this.f3207c] == ',' || this.f3211g[this.f3207c] == ';' || this.f3211g[this.f3207c] == '+') {
                this.f3207c++;
                a = m5096a();
            } else {
                throw new IllegalStateException("Malformed DN: " + this.f3205a);
            }
        } while (a != null);
        throw new IllegalStateException("Malformed DN: " + this.f3205a);
    }
}

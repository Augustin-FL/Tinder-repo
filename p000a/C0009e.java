package p000a;

import java.util.Locale;

/* renamed from: a.e */
public class C0009e {
    private final Object f17a;
    private boolean f18b;

    public boolean m10a() {
        boolean z;
        synchronized (this.f17a) {
            z = this.f18b;
        }
        return z;
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", new Object[]{getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(this.f18b)});
    }
}

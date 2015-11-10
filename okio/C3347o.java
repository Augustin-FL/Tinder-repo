package okio;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;

/* renamed from: okio.o */
final class C3347o {
    final byte[] f7308a;
    int f7309b;
    int f7310c;
    boolean f7311d;
    boolean f7312e;
    C3347o f7313f;
    C3347o f7314g;

    C3347o() {
        this.f7308a = new byte[AccessibilityNodeInfoCompat.ACTION_PREVIOUS_HTML_ELEMENT];
        this.f7312e = true;
        this.f7311d = false;
    }

    C3347o(C3347o c3347o) {
        this(c3347o.f7308a, c3347o.f7309b, c3347o.f7310c);
        c3347o.f7311d = true;
    }

    C3347o(byte[] bArr, int i, int i2) {
        this.f7308a = bArr;
        this.f7309b = i;
        this.f7310c = i2;
        this.f7312e = false;
        this.f7311d = true;
    }

    public C3347o m10328a() {
        C3347o c3347o = this.f7313f != this ? this.f7313f : null;
        this.f7314g.f7313f = this.f7313f;
        this.f7313f.f7314g = this.f7314g;
        this.f7313f = null;
        this.f7314g = null;
        return c3347o;
    }

    public C3347o m10330a(C3347o c3347o) {
        c3347o.f7314g = this;
        c3347o.f7313f = this.f7313f;
        this.f7313f.f7314g = c3347o;
        this.f7313f = c3347o;
        return c3347o;
    }

    public C3347o m10329a(int i) {
        if (i <= 0 || i > this.f7310c - this.f7309b) {
            throw new IllegalArgumentException();
        }
        C3347o c3347o = new C3347o(this);
        c3347o.f7310c = c3347o.f7309b + i;
        this.f7309b += i;
        this.f7314g.m10330a(c3347o);
        return c3347o;
    }

    public void m10332b() {
        if (this.f7314g == this) {
            throw new IllegalStateException();
        } else if (this.f7314g.f7312e) {
            int i = this.f7310c - this.f7309b;
            if (i <= (this.f7314g.f7311d ? 0 : this.f7314g.f7309b) + (2048 - this.f7314g.f7310c)) {
                m10331a(this.f7314g, i);
                m10328a();
                C3348p.m10334a(this);
            }
        }
    }

    public void m10331a(C3347o c3347o, int i) {
        if (c3347o.f7312e) {
            if (c3347o.f7310c + i > AccessibilityNodeInfoCompat.ACTION_PREVIOUS_HTML_ELEMENT) {
                if (c3347o.f7311d) {
                    throw new IllegalArgumentException();
                } else if ((c3347o.f7310c + i) - c3347o.f7309b > AccessibilityNodeInfoCompat.ACTION_PREVIOUS_HTML_ELEMENT) {
                    throw new IllegalArgumentException();
                } else {
                    System.arraycopy(c3347o.f7308a, c3347o.f7309b, c3347o.f7308a, 0, c3347o.f7310c - c3347o.f7309b);
                    c3347o.f7310c -= c3347o.f7309b;
                    c3347o.f7309b = 0;
                }
            }
            System.arraycopy(this.f7308a, this.f7309b, c3347o.f7308a, c3347o.f7310c, i);
            c3347o.f7310c += i;
            this.f7309b += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}

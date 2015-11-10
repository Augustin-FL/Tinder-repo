package okio;

import android.support.v4.media.session.PlaybackStateCompat;

/* renamed from: okio.p */
final class C3348p {
    static C3347o f7315a;
    static long f7316b;

    private C3348p() {
    }

    static C3347o m10333a() {
        synchronized (C3348p.class) {
            if (f7315a != null) {
                C3347o c3347o = f7315a;
                f7315a = c3347o.f7313f;
                c3347o.f7313f = null;
                f7316b -= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                return c3347o;
            }
            return new C3347o();
        }
    }

    static void m10334a(C3347o c3347o) {
        if (c3347o.f7313f != null || c3347o.f7314g != null) {
            throw new IllegalArgumentException();
        } else if (!c3347o.f7311d) {
            synchronized (C3348p.class) {
                if (f7316b + PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH > 65536) {
                    return;
                }
                f7316b += PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                c3347o.f7313f = f7315a;
                c3347o.f7310c = 0;
                c3347o.f7309b = 0;
                f7315a = c3347o;
            }
        }
    }
}

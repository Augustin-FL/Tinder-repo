package com.google.common.collect;

import com.google.common.base.C1650g;
import java.util.NoSuchElementException;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public abstract class AbstractIterator<T> extends ac<T> {
    private State f2193a;
    private T f2194b;

    /* renamed from: com.google.common.collect.AbstractIterator.1 */
    static /* synthetic */ class C17371 {
        static final /* synthetic */ int[] f2187a;

        static {
            f2187a = new int[State.values().length];
            try {
                f2187a[State.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2187a[State.READY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private enum State {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    protected abstract T m3562a();

    protected AbstractIterator() {
        this.f2193a = State.NOT_READY;
    }

    protected final T m3563b() {
        this.f2193a = State.DONE;
        return null;
    }

    public final boolean hasNext() {
        C1650g.m3091b(this.f2193a != State.FAILED);
        switch (C17371.f2187a[this.f2193a.ordinal()]) {
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                return false;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                return true;
            default:
                return m3561c();
        }
    }

    private boolean m3561c() {
        this.f2193a = State.FAILED;
        this.f2194b = m3562a();
        if (this.f2193a == State.DONE) {
            return false;
        }
        this.f2193a = State.READY;
        return true;
    }

    public final T next() {
        if (hasNext()) {
            this.f2193a = State.NOT_READY;
            return this.f2194b;
        }
        throw new NoSuchElementException();
    }
}

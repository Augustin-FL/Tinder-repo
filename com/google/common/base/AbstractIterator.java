package com.google.common.base;

import java.util.Iterator;
import java.util.NoSuchElementException;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

abstract class AbstractIterator<T> implements Iterator<T> {
    private State f1908a;
    private T f1909b;

    /* renamed from: com.google.common.base.AbstractIterator.1 */
    static /* synthetic */ class C16181 {
        static final /* synthetic */ int[] f1902a;

        static {
            f1902a = new int[State.values().length];
            try {
                f1902a[State.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1902a[State.READY.ordinal()] = 2;
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

    protected abstract T m2980a();

    protected AbstractIterator() {
        this.f1908a = State.NOT_READY;
    }

    protected final T m2981b() {
        this.f1908a = State.DONE;
        return null;
    }

    public final boolean hasNext() {
        C1650g.m3091b(this.f1908a != State.FAILED);
        switch (C16181.f1902a[this.f1908a.ordinal()]) {
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                return false;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                return true;
            default:
                return m2979c();
        }
    }

    private boolean m2979c() {
        this.f1908a = State.FAILED;
        this.f1909b = m2980a();
        if (this.f1908a == State.DONE) {
            return false;
        }
        this.f1908a = State.READY;
        return true;
    }

    public final T next() {
        if (hasNext()) {
            this.f1908a = State.NOT_READY;
            return this.f1909b;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

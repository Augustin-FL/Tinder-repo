package com.google.android.m4b.maps.av;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.google.android.gms.location.LocationStatusCodes;
import com.tinder.views.RangeSeekBar;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.google.android.m4b.maps.av.g */
public final class C1380g {
    private static final int f924f;
    private static final int f925g;
    private static final int f926h;
    private int f927a;
    private int f928b;
    private int f929c;
    private int f930d;
    private int f931e;
    private final Handler f932i;
    private final OnGestureListener f933j;
    private OnDoubleTapListener f934k;
    private boolean f935l;
    private boolean f936m;
    private boolean f937n;
    private boolean f938o;
    private MotionEvent f939p;
    private MotionEvent f940q;
    private boolean f941r;
    private float f942s;
    private float f943t;
    private float f944u;
    private float f945v;
    private boolean f946w;
    private VelocityTracker f947x;

    /* renamed from: com.google.android.m4b.maps.av.g.a */
    class C1379a extends Handler {
        private /* synthetic */ C1380g f923a;

        C1379a(C1380g c1380g) {
            this.f923a = c1380g;
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case C3374b.SmoothProgressBar_spb_color /*1*/:
                    this.f923a.f933j.onShowPress(this.f923a.f939p);
                case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                    C1380g.m1362c(this.f923a);
                case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                    if (this.f923a.f934k != null && !this.f923a.f935l) {
                        this.f923a.f934k.onSingleTapConfirmed(this.f923a.f939p);
                    }
                default:
                    throw new RuntimeException("Unknown message " + message);
            }
        }
    }

    static /* synthetic */ void m1362c(C1380g c1380g) {
        c1380g.f932i.removeMessages(3);
        c1380g.f936m = true;
        c1380g.f933j.onLongPress(c1380g.f939p);
    }

    static {
        f924f = ViewConfiguration.getLongPressTimeout();
        f925g = ViewConfiguration.getTapTimeout();
        f926h = ViewConfiguration.getDoubleTapTimeout();
    }

    public C1380g(Context context, OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    private C1380g(Context context, OnGestureListener onGestureListener, Handler handler) {
        this.f932i = new C1379a(this);
        this.f933j = onGestureListener;
        if (onGestureListener instanceof OnDoubleTapListener) {
            this.f934k = (OnDoubleTapListener) onGestureListener;
        }
        if (this.f933j == null) {
            throw new NullPointerException("OnGestureListener must not be null");
        }
        int touchSlop;
        int i;
        int i2;
        this.f946w = true;
        if (context == null) {
            touchSlop = ViewConfiguration.getTouchSlop();
            i = touchSlop * 2;
            this.f930d = ViewConfiguration.getMinimumFlingVelocity();
            this.f931e = ViewConfiguration.getMaximumFlingVelocity();
            i2 = touchSlop;
        } else {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            i2 = viewConfiguration.getScaledTouchSlop();
            touchSlop = viewConfiguration.getScaledTouchSlop();
            i = viewConfiguration.getScaledDoubleTapSlop();
            this.f930d = viewConfiguration.getScaledMinimumFlingVelocity();
            this.f931e = viewConfiguration.getScaledMaximumFlingVelocity();
        }
        this.f927a = i2 * i2;
        this.f928b = touchSlop * touchSlop;
        this.f929c = i * i;
    }

    public final void m1365a(OnDoubleTapListener onDoubleTapListener) {
        this.f934k = onDoubleTapListener;
    }

    public final void m1366a(boolean z) {
        this.f946w = true;
    }

    public final boolean m1367a(MotionEvent motionEvent) {
        int i;
        int action = motionEvent.getAction();
        if (this.f947x == null) {
            this.f947x = VelocityTracker.obtain();
        }
        this.f947x.addMovement(motionEvent);
        boolean z = (action & RangeSeekBar.INVALID_POINTER_ID) == 6;
        int actionIndex = z ? motionEvent.getActionIndex() : -1;
        int pointerCount = motionEvent.getPointerCount();
        float f = 0.0f;
        float f2 = 0.0f;
        for (i = 0; i < pointerCount; i++) {
            if (actionIndex != i) {
                f2 += motionEvent.getX(i);
                f += motionEvent.getY(i);
            }
        }
        actionIndex = z ? pointerCount - 1 : pointerCount;
        f2 /= (float) actionIndex;
        f /= (float) actionIndex;
        boolean hasMessages;
        float yVelocity;
        float xVelocity;
        switch (action & RangeSeekBar.INVALID_POINTER_ID) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                if (this.f934k != null) {
                    hasMessages = this.f932i.hasMessages(3);
                    if (hasMessages) {
                        this.f932i.removeMessages(3);
                    }
                    if (!(this.f939p == null || this.f940q == null || !hasMessages)) {
                        MotionEvent motionEvent2 = this.f939p;
                        MotionEvent motionEvent3 = this.f940q;
                        if (this.f938o && motionEvent.getEventTime() - motionEvent3.getEventTime() <= ((long) f926h)) {
                            pointerCount = ((int) motionEvent2.getX()) - ((int) motionEvent.getX());
                            actionIndex = ((int) motionEvent2.getY()) - ((int) motionEvent.getY());
                            if ((actionIndex * actionIndex) + (pointerCount * pointerCount) < this.f929c) {
                                hasMessages = true;
                                if (hasMessages) {
                                    this.f941r = true;
                                    actionIndex = (this.f934k.onDoubleTap(this.f939p) | 0) | this.f934k.onDoubleTapEvent(motionEvent);
                                    this.f942s = f2;
                                    this.f944u = f2;
                                    this.f943t = f;
                                    this.f945v = f;
                                    if (this.f939p != null) {
                                        this.f939p.recycle();
                                    }
                                    this.f939p = MotionEvent.obtain(motionEvent);
                                    this.f937n = true;
                                    this.f938o = true;
                                    this.f935l = true;
                                    this.f936m = false;
                                    if (this.f946w) {
                                        this.f932i.removeMessages(2);
                                        this.f932i.sendEmptyMessageAtTime(2, (this.f939p.getDownTime() + ((long) f925g)) + ((long) f924f));
                                    }
                                    this.f932i.sendEmptyMessageAtTime(1, this.f939p.getDownTime() + ((long) f925g));
                                    return actionIndex | this.f933j.onDown(motionEvent);
                                }
                            }
                        }
                        hasMessages = false;
                        if (hasMessages) {
                            this.f941r = true;
                            actionIndex = (this.f934k.onDoubleTap(this.f939p) | 0) | this.f934k.onDoubleTapEvent(motionEvent);
                            this.f942s = f2;
                            this.f944u = f2;
                            this.f943t = f;
                            this.f945v = f;
                            if (this.f939p != null) {
                                this.f939p.recycle();
                            }
                            this.f939p = MotionEvent.obtain(motionEvent);
                            this.f937n = true;
                            this.f938o = true;
                            this.f935l = true;
                            this.f936m = false;
                            if (this.f946w) {
                                this.f932i.removeMessages(2);
                                this.f932i.sendEmptyMessageAtTime(2, (this.f939p.getDownTime() + ((long) f925g)) + ((long) f924f));
                            }
                            this.f932i.sendEmptyMessageAtTime(1, this.f939p.getDownTime() + ((long) f925g));
                            return actionIndex | this.f933j.onDown(motionEvent);
                        }
                    }
                    this.f932i.sendEmptyMessageDelayed(3, (long) f926h);
                }
                actionIndex = 0;
                this.f942s = f2;
                this.f944u = f2;
                this.f943t = f;
                this.f945v = f;
                if (this.f939p != null) {
                    this.f939p.recycle();
                }
                this.f939p = MotionEvent.obtain(motionEvent);
                this.f937n = true;
                this.f938o = true;
                this.f935l = true;
                this.f936m = false;
                if (this.f946w) {
                    this.f932i.removeMessages(2);
                    this.f932i.sendEmptyMessageAtTime(2, (this.f939p.getDownTime() + ((long) f925g)) + ((long) f924f));
                }
                this.f932i.sendEmptyMessageAtTime(1, this.f939p.getDownTime() + ((long) f925g));
                return actionIndex | this.f933j.onDown(motionEvent);
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                this.f935l = false;
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                if (this.f941r) {
                    hasMessages = this.f934k.onDoubleTapEvent(motionEvent) | 0;
                } else if (this.f936m) {
                    this.f932i.removeMessages(3);
                    this.f936m = false;
                    hasMessages = this.f933j.onSingleTapUp(motionEvent);
                } else if (this.f937n) {
                    hasMessages = this.f933j.onSingleTapUp(motionEvent);
                } else {
                    VelocityTracker velocityTracker = this.f947x;
                    int pointerId = motionEvent.getPointerId(0);
                    velocityTracker.computeCurrentVelocity(LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, (float) this.f931e);
                    yVelocity = velocityTracker.getYVelocity(pointerId);
                    xVelocity = velocityTracker.getXVelocity(pointerId);
                    if (Math.abs(yVelocity) > ((float) this.f930d) || Math.abs(xVelocity) > ((float) this.f930d)) {
                        hasMessages = this.f933j.onFling(this.f939p, motionEvent, xVelocity, yVelocity);
                    } else {
                        hasMessages = false;
                    }
                }
                if (this.f940q != null) {
                    this.f940q.recycle();
                }
                this.f940q = obtain;
                if (this.f947x != null) {
                    this.f947x.recycle();
                    this.f947x = null;
                }
                this.f941r = false;
                this.f932i.removeMessages(1);
                this.f932i.removeMessages(2);
                return hasMessages;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                xVelocity = this.f942s - f2;
                yVelocity = this.f943t - f;
                if (this.f941r) {
                    return this.f934k.onDoubleTapEvent(motionEvent) | 0;
                }
                if (this.f937n) {
                    i = (int) (f2 - this.f944u);
                    int i2 = (int) (f - this.f945v);
                    i = (i * i) + (i2 * i2);
                    if (i > this.f927a) {
                        hasMessages = this.f933j.onScroll(this.f939p, motionEvent, xVelocity, yVelocity);
                        this.f942s = f2;
                        this.f943t = f;
                        this.f937n = false;
                        this.f932i.removeMessages(3);
                        this.f932i.removeMessages(1);
                        this.f932i.removeMessages(2);
                    } else {
                        hasMessages = false;
                    }
                    if (i > this.f928b) {
                        this.f938o = false;
                    }
                    return hasMessages;
                } else if (Math.abs(xVelocity) < 1.0f && Math.abs(yVelocity) < 1.0f) {
                    return false;
                } else {
                    boolean onScroll = this.f933j.onScroll(this.f939p, motionEvent, xVelocity, yVelocity);
                    this.f942s = f2;
                    this.f943t = f;
                    return onScroll;
                }
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                this.f932i.removeMessages(1);
                this.f932i.removeMessages(2);
                this.f932i.removeMessages(3);
                this.f947x.recycle();
                this.f947x = null;
                this.f941r = false;
                this.f935l = false;
                this.f937n = false;
                this.f938o = false;
                if (!this.f936m) {
                    return false;
                }
                this.f936m = false;
                return false;
            case C3374b.SmoothProgressBar_spb_speed /*5*/:
                this.f942s = f2;
                this.f944u = f2;
                this.f943t = f;
                this.f945v = f;
                this.f932i.removeMessages(1);
                this.f932i.removeMessages(2);
                this.f932i.removeMessages(3);
                this.f941r = false;
                this.f937n = false;
                this.f938o = false;
                if (!this.f936m) {
                    return false;
                }
                this.f936m = false;
                return false;
            case C3374b.SmoothProgressBar_spb_progressiveStart_speed /*6*/:
                this.f942s = f2;
                this.f944u = f2;
                this.f943t = f;
                this.f945v = f;
                this.f947x.computeCurrentVelocity(LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, (float) this.f931e);
                int actionIndex2 = motionEvent.getActionIndex();
                actionIndex = motionEvent.getPointerId(actionIndex2);
                f2 = this.f947x.getXVelocity(actionIndex);
                float yVelocity2 = this.f947x.getYVelocity(actionIndex);
                for (actionIndex = 0; actionIndex < pointerCount; actionIndex++) {
                    if (actionIndex != actionIndex2) {
                        i = motionEvent.getPointerId(actionIndex);
                        if ((this.f947x.getYVelocity(i) * yVelocity2) + (this.f947x.getXVelocity(i) * f2) < 0.0f) {
                            this.f947x.clear();
                            return false;
                        }
                    }
                }
                return false;
            default:
                return false;
        }
    }
}

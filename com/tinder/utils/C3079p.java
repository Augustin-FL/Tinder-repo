package com.tinder.utils;

import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import android.view.View.MeasureSpec;
import java.lang.reflect.Field;

/* renamed from: com.tinder.utils.p */
public class C3079p extends LinearLayoutManager {
    private static boolean f6621a;
    private static Field f6622b;
    private final int[] f6623c;
    private final RecyclerView f6624d;
    private int f6625e;
    private boolean f6626f;
    private int f6627g;
    private final Rect f6628h;

    static {
        f6621a = true;
        f6622b = null;
    }

    public C3079p(RecyclerView recyclerView, int i, boolean z) {
        super(recyclerView.getContext(), i, z);
        this.f6623c = new int[2];
        this.f6625e = 100;
        this.f6627g = 0;
        this.f6628h = new Rect();
        this.f6624d = recyclerView;
        this.f6627g = ViewCompat.getOverScrollMode(recyclerView);
    }

    public void m9420a(int i) {
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException("Unknown overscroll mode: " + i);
        } else if (this.f6624d == null) {
            throw new IllegalStateException("view == null");
        } else {
            this.f6627g = i;
            ViewCompat.setOverScrollMode(this.f6624d, i);
        }
    }

    public static int m9414a() {
        return MeasureSpec.makeMeasureSpec(0, 0);
    }

    public void onMeasure(Recycler recycler, State state, int i, int i2) {
        Object obj;
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        Object obj2 = mode != 0 ? 1 : null;
        Object obj3 = mode2 != 0 ? 1 : null;
        Object obj4 = mode == 1073741824 ? 1 : null;
        if (mode2 == 1073741824) {
            obj = 1;
        } else {
            obj = null;
        }
        int a = C3079p.m9414a();
        if (obj4 == null || obj == null) {
            boolean z;
            int i3;
            if (getOrientation() == 1) {
                z = true;
            } else {
                z = false;
            }
            m9415a(size, size2, z);
            int i4 = 0;
            int i5 = 0;
            recycler.clear();
            int itemCount = state.getItemCount();
            int itemCount2 = getItemCount();
            mode2 = 0;
            while (mode2 < itemCount2) {
                if (!z) {
                    if (!this.f6626f) {
                        if (mode2 < itemCount) {
                            m9417a(recycler, mode2, a, size2, this.f6623c);
                        } else {
                            m9419b(mode2);
                        }
                    }
                    mode = i4 + this.f6623c[0];
                    if (mode2 == 0) {
                        i3 = this.f6623c[1];
                    } else {
                        i3 = i5;
                    }
                    if (obj2 != null && mode >= size) {
                        mode2 = i3;
                        break;
                    }
                }
                if (!this.f6626f) {
                    if (mode2 < itemCount) {
                        m9417a(recycler, mode2, size, a, this.f6623c);
                    } else {
                        m9419b(mode2);
                    }
                }
                i3 = this.f6623c[1] + i5;
                if (mode2 == 0) {
                    mode = this.f6623c[0];
                } else {
                    mode = i4;
                }
                if (obj3 != null && i3 >= size2) {
                    mode2 = i3;
                    break;
                }
                mode2++;
                i5 = i3;
                i4 = mode;
            }
            mode2 = i5;
            mode = i4;
            if (obj4 != null) {
                mode = size;
            } else {
                i3 = (getPaddingLeft() + getPaddingRight()) + mode;
                if (obj2 != null) {
                    mode = Math.min(i3, size);
                } else {
                    mode = i3;
                }
            }
            if (obj != null) {
                i3 = size2;
            } else {
                i3 = (getPaddingTop() + getPaddingBottom()) + mode2;
                if (obj3 != null) {
                    i3 = Math.min(i3, size2);
                }
            }
            setMeasuredDimension(mode, i3);
            if (this.f6624d != null && this.f6627g == 1) {
                Object obj5 = ((!z || (obj3 != null && i3 >= size2)) && (z || (obj2 != null && mode >= size))) ? null : 1;
                View view = this.f6624d;
                if (obj5 != null) {
                    i3 = 2;
                } else {
                    i3 = 0;
                }
                ViewCompat.setOverScrollMode(view, i3);
                return;
            }
            return;
        }
        super.onMeasure(recycler, state, i, i2);
    }

    private void m9419b(int i) {
        C3095y.m9472a("LinearLayoutManager", "Can't measure child #" + i + ", previously used dimensions will be reused. To remove this message either use #setChildSize() method or don't run RecyclerView animations");
    }

    private void m9415a(int i, int i2, boolean z) {
        if (this.f6623c[0] != 0 || this.f6623c[1] != 0) {
            return;
        }
        if (z) {
            this.f6623c[0] = i;
            this.f6623c[1] = this.f6625e;
            return;
        }
        this.f6623c[0] = this.f6625e;
        this.f6623c[1] = i2;
    }

    public void setOrientation(int i) {
        if (!(this.f6623c == null || getOrientation() == i)) {
            this.f6623c[0] = 0;
            this.f6623c[1] = 0;
        }
        super.setOrientation(i);
    }

    private void m9417a(Recycler recycler, int i, int i2, int i3, int[] iArr) {
        View viewForPosition = recycler.getViewForPosition(i);
        LayoutParams layoutParams = (LayoutParams) viewForPosition.getLayoutParams();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i4 = layoutParams.leftMargin + layoutParams.rightMargin;
        int i5 = layoutParams.topMargin + layoutParams.bottomMargin;
        C3079p.m9416a(layoutParams);
        calculateItemDecorationsForChild(viewForPosition, this.f6628h);
        viewForPosition.measure(LayoutManager.getChildMeasureSpec(i2, (paddingLeft + i4) + (getRightDecorationWidth(viewForPosition) + getLeftDecorationWidth(viewForPosition)), layoutParams.width, canScrollHorizontally()), LayoutManager.getChildMeasureSpec(i3, (paddingTop + i5) + (getTopDecorationHeight(viewForPosition) + getBottomDecorationHeight(viewForPosition)), layoutParams.height, canScrollVertically()));
        iArr[0] = (getDecoratedMeasuredWidth(viewForPosition) + layoutParams.leftMargin) + layoutParams.rightMargin;
        iArr[1] = (getDecoratedMeasuredHeight(viewForPosition) + layoutParams.bottomMargin) + layoutParams.topMargin;
        C3079p.m9416a(layoutParams);
        recycler.recycleView(viewForPosition);
    }

    private static void m9416a(LayoutParams layoutParams) {
        if (f6621a) {
            try {
                if (f6622b == null) {
                    f6622b = LayoutParams.class.getDeclaredField("mInsetsDirty");
                    f6622b.setAccessible(true);
                }
                f6622b.set(layoutParams, Boolean.valueOf(true));
            } catch (NoSuchFieldException e) {
                C3079p.m9418b();
            } catch (IllegalAccessException e2) {
                C3079p.m9418b();
            }
        }
    }

    private static void m9418b() {
        f6621a = false;
        C3095y.m9476b("Can't make LayoutParams insets dirty, decorations measurements might be incorrect");
    }
}

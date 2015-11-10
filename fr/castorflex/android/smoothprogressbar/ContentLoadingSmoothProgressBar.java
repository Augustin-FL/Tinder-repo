package fr.castorflex.android.smoothprogressbar;

import android.content.Context;
import android.util.AttributeSet;

public class ContentLoadingSmoothProgressBar extends SmoothProgressBar {
    private long f6884a;
    private boolean f6885b;
    private boolean f6886c;
    private boolean f6887d;
    private final Runnable f6888e;
    private final Runnable f6889f;

    /* renamed from: fr.castorflex.android.smoothprogressbar.ContentLoadingSmoothProgressBar.1 */
    class C31931 implements Runnable {
        final /* synthetic */ ContentLoadingSmoothProgressBar f6882a;

        C31931(ContentLoadingSmoothProgressBar contentLoadingSmoothProgressBar) {
            this.f6882a = contentLoadingSmoothProgressBar;
        }

        public void run() {
            this.f6882a.f6885b = false;
            this.f6882a.f6884a = -1;
            this.f6882a.setVisibility(8);
        }
    }

    /* renamed from: fr.castorflex.android.smoothprogressbar.ContentLoadingSmoothProgressBar.2 */
    class C31942 implements Runnable {
        final /* synthetic */ ContentLoadingSmoothProgressBar f6883a;

        C31942(ContentLoadingSmoothProgressBar contentLoadingSmoothProgressBar) {
            this.f6883a = contentLoadingSmoothProgressBar;
        }

        public void run() {
            this.f6883a.f6886c = false;
            if (!this.f6883a.f6887d) {
                this.f6883a.f6884a = System.currentTimeMillis();
                this.f6883a.setVisibility(0);
            }
        }
    }

    public ContentLoadingSmoothProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f6884a = -1;
        this.f6885b = false;
        this.f6886c = false;
        this.f6887d = false;
        this.f6888e = new C31931(this);
        this.f6889f = new C31942(this);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m9623a();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m9623a();
    }

    private void m9623a() {
        removeCallbacks(this.f6888e);
        removeCallbacks(this.f6889f);
    }
}

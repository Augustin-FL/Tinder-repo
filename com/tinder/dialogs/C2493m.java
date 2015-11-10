package com.tinder.dialogs;

import android.content.Context;
import android.content.DialogInterface.OnKeyListener;
import android.support.annotation.NonNull;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import com.tinder.R;
import com.tinder.enums.ConfirmationType;

/* renamed from: com.tinder.dialogs.m */
public class C2493m extends C2472h {
    private OnClickListener f4495a;
    private OnClickListener f4496b;

    /* renamed from: com.tinder.dialogs.m.1 */
    class C24911 implements OnClickListener {
        final /* synthetic */ C2493m f4493a;

        C24911(C2493m c2493m) {
            this.f4493a = c2493m;
        }

        public void onClick(View view) {
            if (this.f4493a.f4495a != null) {
                this.f4493a.f4495a.onClick(view);
            }
            this.f4493a.dismiss();
        }
    }

    /* renamed from: com.tinder.dialogs.m.2 */
    class C24922 implements OnClickListener {
        final /* synthetic */ C2493m f4494a;

        C24922(C2493m c2493m) {
            this.f4494a = c2493m;
        }

        public void onClick(View view) {
            this.f4494a.dismiss();
            if (this.f4494a.f4496b != null) {
                this.f4494a.f4496b.onClick(view);
            }
        }
    }

    public C2493m(@NonNull Context context, @NonNull ConfirmationType confirmationType, String str, OnClickListener onClickListener, OnClickListener onClickListener2, OnKeyListener onKeyListener) {
        super(context, 0, confirmationType.getIdTitle(), String.format(context.getString(confirmationType.getIdPrompt(), new Object[]{str}), new Object[0]));
        Window window = getWindow();
        window.setFlags(32, 32);
        window.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
        this.f4495a = onClickListener2;
        this.f4496b = onClickListener;
        m6872a(R.string.cancel, new C24911(this));
        m6876b(confirmationType.getIdAction(), new C24922(this));
        setOnKeyListener(onKeyListener);
    }

    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (motionEvent.getAction() == 4) {
            m6870a().performClick();
        }
        return false;
    }
}

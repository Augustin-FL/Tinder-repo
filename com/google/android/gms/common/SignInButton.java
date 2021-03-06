package com.google.android.gms.common;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zzg.zza;

public final class SignInButton extends FrameLayout implements OnClickListener {
    public static final int COLOR_DARK = 0;
    public static final int COLOR_LIGHT = 1;
    public static final int SIZE_ICON_ONLY = 2;
    public static final int SIZE_STANDARD = 0;
    public static final int SIZE_WIDE = 1;
    private int mColor;
    private int mSize;
    private View zzYB;
    private OnClickListener zzYC;

    public SignInButton(Context context) {
        this(context, null);
    }

    public SignInButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, SIZE_STANDARD);
    }

    public SignInButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzYC = null;
        setStyle(SIZE_STANDARD, SIZE_STANDARD);
    }

    private static Button zza(Context context, int i, int i2) {
        Button com_google_android_gms_common_internal_zzab = new zzab(context);
        com_google_android_gms_common_internal_zzab.zza(context.getResources(), i, i2);
        return com_google_android_gms_common_internal_zzab;
    }

    private void zzah(Context context) {
        if (this.zzYB != null) {
            removeView(this.zzYB);
        }
        try {
            this.zzYB = zzaa.zzb(context, this.mSize, this.mColor);
        } catch (zza e) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            this.zzYB = zza(context, this.mSize, this.mColor);
        }
        addView(this.zzYB);
        this.zzYB.setEnabled(isEnabled());
        this.zzYB.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (this.zzYC != null && view == this.zzYB) {
            this.zzYC.onClick(this);
        }
    }

    public void setColorScheme(int i) {
        setStyle(this.mSize, i);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.zzYB.setEnabled(z);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.zzYC = onClickListener;
        if (this.zzYB != null) {
            this.zzYB.setOnClickListener(this);
        }
    }

    public void setSize(int i) {
        setStyle(i, this.mColor);
    }

    public void setStyle(int i, int i2) {
        boolean z = i >= 0 && i < 3;
        Object[] objArr = new Object[SIZE_WIDE];
        objArr[SIZE_STANDARD] = Integer.valueOf(i);
        zzx.zza(z, "Unknown button size %d", objArr);
        z = i2 >= 0 && i2 < SIZE_ICON_ONLY;
        Object[] objArr2 = new Object[SIZE_WIDE];
        objArr2[SIZE_STANDARD] = Integer.valueOf(i2);
        zzx.zza(z, "Unknown color scheme %s", objArr2);
        this.mSize = i;
        this.mColor = i2;
        zzah(getContext());
    }
}

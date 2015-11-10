package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;

public final class AdView extends ViewGroup {
    private final zzy zznS;

    public AdView(Context context) {
        super(context);
        this.zznS = new zzy(this);
    }

    public AdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zznS = new zzy(this, attributeSet, false);
    }

    public AdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zznS = new zzy(this, attributeSet, false);
    }

    public void destroy() {
        this.zznS.destroy();
    }

    public AdListener getAdListener() {
        return this.zznS.getAdListener();
    }

    public AdSize getAdSize() {
        return this.zznS.getAdSize();
    }

    public String getAdUnitId() {
        return this.zznS.getAdUnitId();
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.zznS.getInAppPurchaseListener();
    }

    public String getMediationAdapterClassName() {
        return this.zznS.getMediationAdapterClassName();
    }

    public boolean isLoading() {
        return this.zznS.isLoading();
    }

    public void loadAd(AdRequest adRequest) {
        this.zznS.zza(adRequest.zzaF());
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = ((i3 - i) - measuredWidth) / 2;
            int i6 = ((i4 - i2) - measuredHeight) / 2;
            childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
        }
    }

    protected void onMeasure(int i, int i2) {
        int widthInPixels;
        int i3 = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            AdSize adSize = getAdSize();
            if (adSize != null) {
                Context context = getContext();
                widthInPixels = adSize.getWidthInPixels(context);
                i3 = adSize.getHeightInPixels(context);
            } else {
                widthInPixels = 0;
            }
        } else {
            measureChild(childAt, i, i2);
            widthInPixels = childAt.getMeasuredWidth();
            i3 = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(widthInPixels, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i3, getSuggestedMinimumHeight()), i2));
    }

    public void pause() {
        this.zznS.pause();
    }

    public void resume() {
        this.zznS.resume();
    }

    public void setAdListener(AdListener adListener) {
        this.zznS.setAdListener(adListener);
        if (adListener != null && (adListener instanceof zza)) {
            this.zznS.zza((zza) adListener);
        } else if (adListener == null) {
            this.zznS.zza(null);
        }
    }

    public void setAdSize(AdSize adSize) {
        this.zznS.setAdSizes(adSize);
    }

    public void setAdUnitId(String str) {
        this.zznS.setAdUnitId(str);
    }

    public void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        this.zznS.setInAppPurchaseListener(inAppPurchaseListener);
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String str) {
        this.zznS.setPlayStorePurchaseParams(playStorePurchaseListener, str);
    }
}

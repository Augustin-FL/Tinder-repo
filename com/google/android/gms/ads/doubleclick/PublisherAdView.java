package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.zzy;

public final class PublisherAdView extends ViewGroup {
    private final zzy zznS;

    public PublisherAdView(Context context) {
        super(context);
        this.zznS = new zzy(this);
    }

    public PublisherAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zznS = new zzy(this, attributeSet, true);
    }

    public PublisherAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zznS = new zzy(this, attributeSet, true);
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

    public AdSize[] getAdSizes() {
        return this.zznS.getAdSizes();
    }

    public String getAdUnitId() {
        return this.zznS.getAdUnitId();
    }

    public AppEventListener getAppEventListener() {
        return this.zznS.getAppEventListener();
    }

    public String getMediationAdapterClassName() {
        return this.zznS.getMediationAdapterClassName();
    }

    public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zznS.getOnCustomRenderedAdLoadedListener();
    }

    public void loadAd(PublisherAdRequest publisherAdRequest) {
        this.zznS.zza(publisherAdRequest.zzaF());
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

    public void recordManualImpression() {
        this.zznS.recordManualImpression();
    }

    public void resume() {
        this.zznS.resume();
    }

    public void setAdListener(AdListener adListener) {
        this.zznS.setAdListener(adListener);
    }

    public void setAdSizes(AdSize... adSizeArr) {
        if (adSizeArr == null || adSizeArr.length < 1) {
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        }
        this.zznS.zza(adSizeArr);
    }

    public void setAdUnitId(String str) {
        this.zznS.setAdUnitId(str);
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        this.zznS.setAppEventListener(appEventListener);
    }

    public void setManualImpressionsEnabled(boolean z) {
        this.zznS.setManualImpressionsEnabled(z);
    }

    public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zznS.setOnCustomRenderedAdLoadedListener(onCustomRenderedAdLoadedListener);
    }
}

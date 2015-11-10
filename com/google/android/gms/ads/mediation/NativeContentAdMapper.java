package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd.Image;
import java.util.List;

public abstract class NativeContentAdMapper extends NativeAdMapper {
    private Image zzJF;
    private String zzvK;
    private List<Image> zzvL;
    private String zzvM;
    private String zzvO;
    private String zzvV;

    public final String getAdvertiser() {
        return this.zzvV;
    }

    public final String getBody() {
        return this.zzvM;
    }

    public final String getCallToAction() {
        return this.zzvO;
    }

    public final String getHeadline() {
        return this.zzvK;
    }

    public final List<Image> getImages() {
        return this.zzvL;
    }

    public final Image getLogo() {
        return this.zzJF;
    }

    public final void setAdvertiser(String str) {
        this.zzvV = str;
    }

    public final void setBody(String str) {
        this.zzvM = str;
    }

    public final void setCallToAction(String str) {
        this.zzvO = str;
    }

    public final void setHeadline(String str) {
        this.zzvK = str;
    }

    public final void setImages(List<Image> list) {
        this.zzvL = list;
    }

    public final void setLogo(Image image) {
        this.zzJF = image;
    }
}

package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd.Image;
import java.util.List;

public abstract class NativeAppInstallAdMapper extends NativeAdMapper {
    private Image zzJE;
    private String zzvK;
    private List<Image> zzvL;
    private String zzvM;
    private String zzvO;
    private double zzvP;
    private String zzvQ;
    private String zzvR;

    public final String getBody() {
        return this.zzvM;
    }

    public final String getCallToAction() {
        return this.zzvO;
    }

    public final String getHeadline() {
        return this.zzvK;
    }

    public final Image getIcon() {
        return this.zzJE;
    }

    public final List<Image> getImages() {
        return this.zzvL;
    }

    public final String getPrice() {
        return this.zzvR;
    }

    public final double getStarRating() {
        return this.zzvP;
    }

    public final String getStore() {
        return this.zzvQ;
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

    public final void setIcon(Image image) {
        this.zzJE = image;
    }

    public final void setImages(List<Image> list) {
        this.zzvL = list;
    }

    public final void setPrice(String str) {
        this.zzvR = str;
    }

    public final void setStarRating(double d) {
        this.zzvP = d;
    }

    public final void setStore(String str) {
        this.zzvQ = str;
    }
}

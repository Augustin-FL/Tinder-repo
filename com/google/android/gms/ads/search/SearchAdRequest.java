package com.google.android.gms.ads.search;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzx;
import com.google.android.gms.ads.internal.client.zzx.zza;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;

public final class SearchAdRequest {
    public static final int BORDER_TYPE_DASHED = 1;
    public static final int BORDER_TYPE_DOTTED = 2;
    public static final int BORDER_TYPE_NONE = 0;
    public static final int BORDER_TYPE_SOLID = 3;
    public static final int CALL_BUTTON_COLOR_DARK = 2;
    public static final int CALL_BUTTON_COLOR_LIGHT = 0;
    public static final int CALL_BUTTON_COLOR_MEDIUM = 1;
    public static final String DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    private final int zzJN;
    private final int zzJO;
    private final int zzJP;
    private final int zzJQ;
    private final int zzJR;
    private final int zzJS;
    private final int zzJT;
    private final String zzJU;
    private final int zzJV;
    private final String zzJW;
    private final int zzJX;
    private final int zzJY;
    private final String zzJZ;
    private final zzx zznN;
    private final int zzvF;

    public static final class Builder {
        private int zzJN;
        private int zzJO;
        private int zzJP;
        private int zzJQ;
        private int zzJR;
        private int zzJS;
        private int zzJT;
        private String zzJU;
        private int zzJV;
        private String zzJW;
        private int zzJX;
        private int zzJY;
        private String zzJZ;
        private final zza zznO;
        private int zzvF;

        public Builder() {
            this.zznO = new zza();
            this.zzJS = SearchAdRequest.ERROR_CODE_INTERNAL_ERROR;
        }

        public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> cls, Bundle bundle) {
            this.zznO.zzb((Class) cls, bundle);
            return this;
        }

        public Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.zznO.zza(networkExtras);
            return this;
        }

        public Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.zznO.zza(cls, bundle);
            return this;
        }

        public Builder addTestDevice(String str) {
            this.zznO.zzG(str);
            return this;
        }

        public SearchAdRequest build() {
            return new SearchAdRequest();
        }

        public Builder setAnchorTextColor(int i) {
            this.zzJN = i;
            return this;
        }

        public Builder setBackgroundColor(int i) {
            this.zzvF = i;
            this.zzJO = Color.argb(SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR);
            this.zzJP = Color.argb(SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR);
            return this;
        }

        public Builder setBackgroundGradient(int i, int i2) {
            this.zzvF = Color.argb(SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR);
            this.zzJO = i2;
            this.zzJP = i;
            return this;
        }

        public Builder setBorderColor(int i) {
            this.zzJQ = i;
            return this;
        }

        public Builder setBorderThickness(int i) {
            this.zzJR = i;
            return this;
        }

        public Builder setBorderType(int i) {
            this.zzJS = i;
            return this;
        }

        public Builder setCallButtonColor(int i) {
            this.zzJT = i;
            return this;
        }

        public Builder setCustomChannels(String str) {
            this.zzJU = str;
            return this;
        }

        public Builder setDescriptionTextColor(int i) {
            this.zzJV = i;
            return this;
        }

        public Builder setFontFace(String str) {
            this.zzJW = str;
            return this;
        }

        public Builder setHeaderTextColor(int i) {
            this.zzJX = i;
            return this;
        }

        public Builder setHeaderTextSize(int i) {
            this.zzJY = i;
            return this;
        }

        public Builder setLocation(Location location) {
            this.zznO.zza(location);
            return this;
        }

        public Builder setQuery(String str) {
            this.zzJZ = str;
            return this;
        }

        public Builder setRequestAgent(String str) {
            this.zznO.zzK(str);
            return this;
        }

        public Builder tagForChildDirectedTreatment(boolean z) {
            this.zznO.zzj(z);
            return this;
        }
    }

    static {
        DEVICE_ID_EMULATOR = zzx.DEVICE_ID_EMULATOR;
    }

    private SearchAdRequest(Builder builder) {
        this.zzJN = builder.zzJN;
        this.zzvF = builder.zzvF;
        this.zzJO = builder.zzJO;
        this.zzJP = builder.zzJP;
        this.zzJQ = builder.zzJQ;
        this.zzJR = builder.zzJR;
        this.zzJS = builder.zzJS;
        this.zzJT = builder.zzJT;
        this.zzJU = builder.zzJU;
        this.zzJV = builder.zzJV;
        this.zzJW = builder.zzJW;
        this.zzJX = builder.zzJX;
        this.zzJY = builder.zzJY;
        this.zzJZ = builder.zzJZ;
        this.zznN = new zzx(builder.zznO, this);
    }

    public int getAnchorTextColor() {
        return this.zzJN;
    }

    public int getBackgroundColor() {
        return this.zzvF;
    }

    public int getBackgroundGradientBottom() {
        return this.zzJO;
    }

    public int getBackgroundGradientTop() {
        return this.zzJP;
    }

    public int getBorderColor() {
        return this.zzJQ;
    }

    public int getBorderThickness() {
        return this.zzJR;
    }

    public int getBorderType() {
        return this.zzJS;
    }

    public int getCallButtonColor() {
        return this.zzJT;
    }

    public String getCustomChannels() {
        return this.zzJU;
    }

    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> cls) {
        return this.zznN.getCustomEventExtrasBundle(cls);
    }

    public int getDescriptionTextColor() {
        return this.zzJV;
    }

    public String getFontFace() {
        return this.zzJW;
    }

    public int getHeaderTextColor() {
        return this.zzJX;
    }

    public int getHeaderTextSize() {
        return this.zzJY;
    }

    public Location getLocation() {
        return this.zznN.getLocation();
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return this.zznN.getNetworkExtras(cls);
    }

    public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> cls) {
        return this.zznN.getNetworkExtrasBundle(cls);
    }

    public String getQuery() {
        return this.zzJZ;
    }

    public boolean isTestDevice(Context context) {
        return this.zznN.isTestDevice(context);
    }

    zzx zzaF() {
        return this.zznN;
    }
}

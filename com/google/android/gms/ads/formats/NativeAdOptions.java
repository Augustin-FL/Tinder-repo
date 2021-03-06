package com.google.android.gms.ads.formats;

public final class NativeAdOptions {
    public static final int ORIENTATION_ANY = 0;
    public static final int ORIENTATION_LANDSCAPE = 2;
    public static final int ORIENTATION_PORTRAIT = 1;
    private final boolean zznV;
    private final int zznW;
    private final boolean zznX;

    public static final class Builder {
        private boolean zznV;
        private int zznW;
        private boolean zznX;

        public Builder() {
            this.zznV = false;
            this.zznW = NativeAdOptions.ORIENTATION_ANY;
            this.zznX = false;
        }

        public NativeAdOptions build() {
            return new NativeAdOptions();
        }

        public Builder setImageOrientation(int i) {
            this.zznW = i;
            return this;
        }

        public Builder setRequestMultipleImages(boolean z) {
            this.zznX = z;
            return this;
        }

        public Builder setReturnUrlsForImageAssets(boolean z) {
            this.zznV = z;
            return this;
        }
    }

    private NativeAdOptions(Builder builder) {
        this.zznV = builder.zznV;
        this.zznW = builder.zznW;
        this.zznX = builder.zznX;
    }

    public int getImageOrientation() {
        return this.zznW;
    }

    public boolean shouldRequestMultipleImages() {
        return this.zznX;
    }

    public boolean shouldReturnUrlsForImageAssets() {
        return this.zznV;
    }
}

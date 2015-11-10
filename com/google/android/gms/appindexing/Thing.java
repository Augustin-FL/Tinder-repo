package com.google.android.gms.appindexing;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.zzx;

public class Thing {
    final Bundle zzQd;

    public static class Builder {
        final Bundle zzQe;

        public Builder() {
            this.zzQe = new Bundle();
        }

        public Thing build() {
            return new Thing(this.zzQe);
        }

        public Builder put(String str, Thing thing) {
            zzx.zzv(str);
            if (thing != null) {
                this.zzQe.putParcelable(str, thing.zzQd);
            }
            return this;
        }

        public Builder put(String str, String str2) {
            zzx.zzv(str);
            if (str2 != null) {
                this.zzQe.putString(str, str2);
            }
            return this;
        }

        public Builder setDescription(String str) {
            put(ShareConstants.WEB_DIALOG_PARAM_DESCRIPTION, str);
            return this;
        }

        public Builder setId(String str) {
            if (str != null) {
                put(ShareConstants.WEB_DIALOG_PARAM_ID, str);
            }
            return this;
        }

        public Builder setName(String str) {
            zzx.zzv(str);
            put(ShareConstants.WEB_DIALOG_PARAM_NAME, str);
            return this;
        }

        public Builder setType(String str) {
            put("type", str);
            return this;
        }

        public Builder setUrl(Uri uri) {
            zzx.zzv(uri);
            put(NativeProtocol.WEB_DIALOG_URL, uri.toString());
            return this;
        }
    }

    Thing(Bundle bundle) {
        this.zzQd = bundle;
    }

    public Bundle zzlh() {
        return this.zzQd;
    }
}

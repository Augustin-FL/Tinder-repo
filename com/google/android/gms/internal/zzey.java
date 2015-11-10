package com.google.android.gms.internal;

import android.app.AlertDialog.Builder;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.C0708R;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;
import org.apache.http.HttpHeaders;

@zzgk
public class zzey extends zzfb {
    private final Context mContext;
    private final Map<String, String> zzvs;

    /* renamed from: com.google.android.gms.internal.zzey.1 */
    class C10901 implements OnClickListener {
        final /* synthetic */ String zzzF;
        final /* synthetic */ String zzzG;
        final /* synthetic */ zzey zzzH;

        C10901(zzey com_google_android_gms_internal_zzey, String str, String str2) {
            this.zzzH = com_google_android_gms_internal_zzey;
            this.zzzF = str;
            this.zzzG = str2;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                ((DownloadManager) this.zzzH.mContext.getSystemService("download")).enqueue(this.zzzH.zzg(this.zzzF, this.zzzG));
            } catch (IllegalStateException e) {
                this.zzzH.zzah("Could not store picture.");
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzey.2 */
    class C10912 implements OnClickListener {
        final /* synthetic */ zzey zzzH;

        C10912(zzey com_google_android_gms_internal_zzey) {
            this.zzzH = com_google_android_gms_internal_zzey;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.zzzH.zzah("User canceled the download.");
        }
    }

    public zzey(zzip com_google_android_gms_internal_zzip, Map<String, String> map) {
        super(com_google_android_gms_internal_zzip, "storePicture");
        this.zzvs = map;
        this.mContext = com_google_android_gms_internal_zzip.zzgN();
    }

    public void execute() {
        if (this.mContext == null) {
            zzah("Activity context is not available");
        } else if (zzp.zzbx().zzM(this.mContext).zzcX()) {
            String str = (String) this.zzvs.get("iurl");
            if (TextUtils.isEmpty(str)) {
                zzah("Image url cannot be empty.");
            } else if (URLUtil.isValidUrl(str)) {
                String zzag = zzag(str);
                if (zzp.zzbx().zzay(zzag)) {
                    Builder zzL = zzp.zzbx().zzL(this.mContext);
                    zzL.setTitle(zzp.zzbA().zzc(C0708R.string.store_picture_title, "Save image"));
                    zzL.setMessage(zzp.zzbA().zzc(C0708R.string.store_picture_message, "Allow Ad to store image in Picture gallery?"));
                    zzL.setPositiveButton(zzp.zzbA().zzc(C0708R.string.accept, HttpHeaders.ACCEPT), new C10901(this, str, zzag));
                    zzL.setNegativeButton(zzp.zzbA().zzc(C0708R.string.decline, "Decline"), new C10912(this));
                    zzL.create().show();
                    return;
                }
                zzah("Image type not recognized: " + zzag);
            } else {
                zzah("Invalid image url: " + str);
            }
        } else {
            zzah("Feature is not supported by the device.");
        }
    }

    String zzag(String str) {
        return Uri.parse(str).getLastPathSegment();
    }

    Request zzg(String str, String str2) {
        Request request = new Request(Uri.parse(str));
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
        zzp.zzbz().zza(request);
        return request;
    }
}

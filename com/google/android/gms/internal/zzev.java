package com.google.android.gms.internal;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.provider.CalendarContract.Events;
import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import com.facebook.stetho.BuildConfig;
import com.google.android.gms.C0708R;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;
import org.apache.http.HttpHeaders;

@zzgk
public class zzev extends zzfb {
    private final Context mContext;
    private final Map<String, String> zzvs;
    private String zzzi;
    private long zzzj;
    private long zzzk;
    private String zzzl;
    private String zzzm;

    /* renamed from: com.google.android.gms.internal.zzev.1 */
    class C10871 implements OnClickListener {
        final /* synthetic */ zzev zzzn;

        C10871(zzev com_google_android_gms_internal_zzev) {
            this.zzzn = com_google_android_gms_internal_zzev;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.zzzn.mContext.startActivity(this.zzzn.createIntent());
        }
    }

    /* renamed from: com.google.android.gms.internal.zzev.2 */
    class C10882 implements OnClickListener {
        final /* synthetic */ zzev zzzn;

        C10882(zzev com_google_android_gms_internal_zzev) {
            this.zzzn = com_google_android_gms_internal_zzev;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.zzzn.zzah("Operation denied by user.");
        }
    }

    public zzev(zzip com_google_android_gms_internal_zzip, Map<String, String> map) {
        super(com_google_android_gms_internal_zzip, "createCalendarEvent");
        this.zzvs = map;
        this.mContext = com_google_android_gms_internal_zzip.zzgN();
        zzdV();
    }

    private String zzae(String str) {
        return TextUtils.isEmpty((CharSequence) this.zzvs.get(str)) ? BuildConfig.FLAVOR : (String) this.zzvs.get(str);
    }

    private long zzaf(String str) {
        String str2 = (String) this.zzvs.get(str);
        if (str2 == null) {
            return -1;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void zzdV() {
        this.zzzi = zzae(ShareConstants.WEB_DIALOG_PARAM_DESCRIPTION);
        this.zzzl = zzae("summary");
        this.zzzj = zzaf("start_ticks");
        this.zzzk = zzaf("end_ticks");
        this.zzzm = zzae("location");
    }

    Intent createIntent() {
        Intent data = new Intent("android.intent.action.EDIT").setData(Events.CONTENT_URI);
        data.putExtra(ShareConstants.WEB_DIALOG_PARAM_TITLE, this.zzzi);
        data.putExtra("eventLocation", this.zzzm);
        data.putExtra(ShareConstants.WEB_DIALOG_PARAM_DESCRIPTION, this.zzzl);
        if (this.zzzj > -1) {
            data.putExtra("beginTime", this.zzzj);
        }
        if (this.zzzk > -1) {
            data.putExtra("endTime", this.zzzk);
        }
        data.setFlags(268435456);
        return data;
    }

    public void execute() {
        if (this.mContext == null) {
            zzah("Activity context is not available.");
        } else if (zzp.zzbx().zzM(this.mContext).zzda()) {
            Builder zzL = zzp.zzbx().zzL(this.mContext);
            zzL.setTitle(zzp.zzbA().zzc(C0708R.string.create_calendar_title, "Create calendar event"));
            zzL.setMessage(zzp.zzbA().zzc(C0708R.string.create_calendar_message, "Allow Ad to create a calendar event?"));
            zzL.setPositiveButton(zzp.zzbA().zzc(C0708R.string.accept, HttpHeaders.ACCEPT), new C10871(this));
            zzL.setNegativeButton(zzp.zzbA().zzc(C0708R.string.decline, "Decline"), new C10882(this));
            zzL.create().show();
        } else {
            zzah("This feature is not available on the device.");
        }
    }
}

package com.tinder.dialogs;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import com.tinder.R;
import com.tinder.p030d.C2411t;

/* renamed from: com.tinder.dialogs.w */
public class C2533w extends C2472h {
    private C2411t f4613a;

    /* renamed from: com.tinder.dialogs.w.1 */
    class C25311 implements OnClickListener {
        final /* synthetic */ C2533w f4610a;

        C25311(C2533w c2533w) {
            this.f4610a = c2533w;
        }

        public void onClick(View view) {
            this.f4610a.f4613a.m6600b();
            this.f4610a.dismiss();
        }
    }

    /* renamed from: com.tinder.dialogs.w.2 */
    class C25322 implements OnClickListener {
        final /* synthetic */ C2411t f4611a;
        final /* synthetic */ C2533w f4612b;

        C25322(C2533w c2533w, C2411t c2411t) {
            this.f4612b = c2533w;
            this.f4611a = c2411t;
        }

        public void onClick(View view) {
            this.f4611a.m6599a();
            this.f4612b.dismiss();
        }
    }

    public C2533w(@NonNull Context context, @NonNull C2411t c2411t) {
        super(context, 0, (int) R.string.instagram_signed_out_title, (int) R.string.instagram_signed_out_body);
        this.f4613a = c2411t;
        m6872a(R.string.not_now, new C25311(this));
        m6876b(R.string.ok, new C25322(this, c2411t));
    }
}

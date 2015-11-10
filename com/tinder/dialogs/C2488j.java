package com.tinder.dialogs;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import com.tinder.R;

/* renamed from: com.tinder.dialogs.j */
public class C2488j extends C2472h {

    /* renamed from: com.tinder.dialogs.j.1 */
    class C24871 implements OnClickListener {
        final /* synthetic */ C2488j f4489a;

        C24871(C2488j c2488j) {
            this.f4489a = c2488j;
        }

        public void onClick(View view) {
            this.f4489a.dismiss();
        }
    }

    public C2488j(@NonNull Context context) {
        super(context, 0, (int) R.string.missing_permissions, (int) R.string.facebook_missing_permissions);
        m6877c(R.string.ask_me, new C24871(this));
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }
}

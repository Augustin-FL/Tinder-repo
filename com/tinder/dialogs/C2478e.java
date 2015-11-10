package com.tinder.dialogs;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import com.tinder.R;

/* renamed from: com.tinder.dialogs.e */
public class C2478e extends C2472h {

    /* renamed from: com.tinder.dialogs.e.1 */
    class C24771 implements OnClickListener {
        final /* synthetic */ C2478e f4478a;

        C24771(C2478e c2478e) {
            this.f4478a = c2478e;
        }

        public void onClick(View view) {
            this.f4478a.dismiss();
        }
    }

    public C2478e(@NonNull Context context) {
        super(context, 0, (int) R.string.instagram_account_in_use_title, (int) R.string.instagram_account_in_use_body);
        m6872a(R.string.ok, new C24771(this));
    }
}

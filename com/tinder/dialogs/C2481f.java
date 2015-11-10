package com.tinder.dialogs;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import com.tinder.R;
import com.tinder.p032c.C2420b;

/* renamed from: com.tinder.dialogs.f */
public class C2481f extends C2472h {
    C2420b f4481a;

    /* renamed from: com.tinder.dialogs.f.1 */
    class C24791 implements OnClickListener {
        final /* synthetic */ C2481f f4479a;

        C24791(C2481f c2481f) {
            this.f4479a = c2481f;
        }

        public void onClick(View view) {
            this.f4479a.dismiss();
        }
    }

    /* renamed from: com.tinder.dialogs.f.2 */
    class C24802 implements OnClickListener {
        final /* synthetic */ C2481f f4480a;

        C24802(C2481f c2481f) {
            this.f4480a = c2481f;
        }

        public void onClick(View view) {
            this.f4480a.f4481a.m6615a(4);
            this.f4480a.dismiss();
        }
    }

    public C2481f(@NonNull Context context, C2420b c2420b) {
        super(context, 0, (int) R.string.instagram_connect_error_title, (int) R.string.instagram_connect_error_body);
        this.f4481a = c2420b;
        m6872a(R.string.cancel, new C24791(this));
        m6876b(R.string.retry, new C24802(this));
    }
}

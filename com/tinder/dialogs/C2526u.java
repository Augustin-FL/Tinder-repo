package com.tinder.dialogs;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import com.tinder.R;
import com.tinder.p032c.C2420b;

/* renamed from: com.tinder.dialogs.u */
public class C2526u extends C2472h {
    C2420b f4606a;

    /* renamed from: com.tinder.dialogs.u.1 */
    class C25241 implements OnClickListener {
        final /* synthetic */ C2526u f4604a;

        C25241(C2526u c2526u) {
            this.f4604a = c2526u;
        }

        public void onClick(View view) {
            this.f4604a.dismiss();
        }
    }

    /* renamed from: com.tinder.dialogs.u.2 */
    class C25252 implements OnClickListener {
        final /* synthetic */ C2526u f4605a;

        C25252(C2526u c2526u) {
            this.f4605a = c2526u;
        }

        public void onClick(View view) {
            this.f4605a.f4606a.m6617b(4);
            this.f4605a.dismiss();
        }
    }

    public C2526u(@NonNull Context context, C2420b c2420b) {
        super(context, 0, (int) R.string.instagram_disconnect_error_title, (int) R.string.instagram_disconnect_error_body);
        this.f4606a = c2420b;
        m6872a(R.string.cancel, new C25241(this));
        m6876b(R.string.retry, new C25252(this));
    }
}

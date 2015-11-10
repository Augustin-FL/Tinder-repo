package com.tinder.dialogs;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import com.tinder.R;

/* renamed from: com.tinder.dialogs.v */
public class C2530v extends C2472h {
    C2529a f4609a;

    /* renamed from: com.tinder.dialogs.v.1 */
    class C25271 implements OnClickListener {
        final /* synthetic */ C2530v f4607a;

        C25271(C2530v c2530v) {
            this.f4607a = c2530v;
        }

        public void onClick(View view) {
            this.f4607a.dismiss();
        }
    }

    /* renamed from: com.tinder.dialogs.v.2 */
    class C25282 implements OnClickListener {
        final /* synthetic */ C2530v f4608a;

        C25282(C2530v c2530v) {
            this.f4608a = c2530v;
        }

        public void onClick(View view) {
            this.f4608a.f4609a.m6966a();
            this.f4608a.dismiss();
        }
    }

    /* renamed from: com.tinder.dialogs.v.a */
    public interface C2529a {
        void m6966a();
    }

    public C2530v(@NonNull Context context, C2529a c2529a) {
        super(context, 0, (int) R.string.instagram_confirm_disconnect_title, (int) R.string.instagram_confirm_disconnect_body);
        this.f4609a = c2529a;
        m6872a(R.string.cancel, new C25271(this));
        m6876b(R.string.ok, new C25282(this));
    }
}

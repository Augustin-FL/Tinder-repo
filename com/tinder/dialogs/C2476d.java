package com.tinder.dialogs;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import com.tinder.R;

/* renamed from: com.tinder.dialogs.d */
public class C2476d extends C2472h {

    /* renamed from: com.tinder.dialogs.d.1 */
    class C24741 implements OnClickListener {
        final /* synthetic */ C2475a f4476a;
        final /* synthetic */ C2476d f4477b;

        C24741(C2476d c2476d, C2475a c2475a) {
            this.f4477b = c2476d;
            this.f4476a = c2475a;
        }

        public void onClick(View view) {
            this.f4476a.m6878b();
            this.f4477b.dismiss();
        }
    }

    /* renamed from: com.tinder.dialogs.d.a */
    public interface C2475a {
        void m6878b();
    }

    public C2476d(@NonNull Context context, @NonNull C2475a c2475a) {
        super(context, 0, (int) R.string.ask_logout, (int) R.string.logout_confirm);
        m6876b(R.string.logout, new C24741(this, c2475a));
    }
}

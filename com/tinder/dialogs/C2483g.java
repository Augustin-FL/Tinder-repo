package com.tinder.dialogs;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import com.tinder.R;

/* renamed from: com.tinder.dialogs.g */
public class C2483g extends C2472h {

    /* renamed from: com.tinder.dialogs.g.1 */
    class C24821 implements OnClickListener {
        final /* synthetic */ C2483g f4482a;

        C24821(C2483g c2483g) {
            this.f4482a = c2483g;
        }

        public void onClick(View view) {
            this.f4482a.dismiss();
        }
    }

    public C2483g(@NonNull Context context) {
        super(context, 0, (int) R.string.deleted_acct_title, (int) R.string.deleted_acct_text);
        m6877c(R.string.got_it, new C24821(this));
    }
}

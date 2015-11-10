package com.tinder.dialogs;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import com.tinder.R;

/* renamed from: com.tinder.dialogs.c */
public class C2473c extends C2472h {

    /* renamed from: com.tinder.dialogs.c.1 */
    class C24701 implements OnClickListener {
        final /* synthetic */ C2471a f4464a;
        final /* synthetic */ C2473c f4465b;

        C24701(C2473c c2473c, C2471a c2471a) {
            this.f4465b = c2473c;
            this.f4464a = c2471a;
        }

        public void onClick(View view) {
            this.f4464a.m6868a();
            this.f4465b.dismiss();
        }
    }

    /* renamed from: com.tinder.dialogs.c.a */
    public interface C2471a {
        void m6868a();
    }

    public C2473c(@NonNull Context context, @NonNull C2471a c2471a) {
        super(context, 0, (int) R.string.ask_delete_account, (int) R.string.delete_confirm);
        m6876b(R.string.delete, new C24701(this, c2471a));
    }
}

package com.tinder.dialogs;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import com.tinder.R;

/* renamed from: com.tinder.dialogs.p */
public class C2504p extends C2472h {

    /* renamed from: com.tinder.dialogs.p.a */
    public interface C2242a {
        void m5930b();

        void r_();
    }

    /* renamed from: com.tinder.dialogs.p.1 */
    class C25021 implements OnClickListener {
        final /* synthetic */ C2242a f4517a;
        final /* synthetic */ C2504p f4518b;

        C25021(C2504p c2504p, C2242a c2242a) {
            this.f4518b = c2504p;
            this.f4517a = c2242a;
        }

        public void onClick(View view) {
            this.f4517a.r_();
            this.f4518b.dismiss();
        }
    }

    /* renamed from: com.tinder.dialogs.p.2 */
    class C25032 implements OnClickListener {
        final /* synthetic */ C2242a f4519a;
        final /* synthetic */ C2504p f4520b;

        C25032(C2504p c2504p, C2242a c2242a) {
            this.f4520b = c2504p;
            this.f4519a = c2242a;
        }

        public void onClick(View view) {
            this.f4519a.m5930b();
            this.f4520b.dismiss();
        }
    }

    public C2504p(@NonNull Context context, @NonNull C2242a c2242a) {
        super(context, 0, (int) R.string.photo_permissions, (int) R.string.photo_permissions_prompt);
        getWindow().getAttributes().windowAnimations = R.style.dialog_up_down_animation;
        m6872a(R.string.cancel, new C25021(this, c2242a));
        m6876b(R.string.ok, new C25032(this, c2242a));
    }
}

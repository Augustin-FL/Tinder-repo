package com.tinder.p033e;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tinder.managers.C2807a;
import com.tinder.model.InstagramAuthError;
import com.tinder.model.InstagramDataSet;
import com.tinder.model.SparksEvent;
import com.tinder.p030d.C2409u;
import com.tinder.p030d.C2436s;
import com.tinder.p032c.C2419a;
import com.tinder.p032c.C2420b;
import com.tinder.p032c.C2421c;
import com.tinder.utils.C3095y;

/* renamed from: com.tinder.e.a */
public class C2557a implements C2420b {
    private C2421c f4693a;
    private C2419a f4694b;

    /* renamed from: com.tinder.e.a.1 */
    class C25551 implements C2409u {
        final /* synthetic */ C2557a f4691a;

        C25551(C2557a c2557a) {
            this.f4691a = c2557a;
        }

        public void m7039a() {
            C3095y.m9471a("onInstagramLogoutSuccess");
            this.f4691a.f4693a.m6626l();
            this.f4691a.f4693a.m6621g();
        }

        public void m7040b() {
            C3095y.m9479c("onInstagramLogoutFailure");
            this.f4691a.f4693a.m6626l();
            this.f4691a.f4693a.m6623i();
        }
    }

    /* renamed from: com.tinder.e.a.2 */
    class C25562 implements C2436s {
        final /* synthetic */ C2557a f4692a;

        C25562(C2557a c2557a) {
            this.f4692a = c2557a;
        }

        public void m7042a(@NonNull InstagramDataSet instagramDataSet) {
            C3095y.m9471a("authenticateWithAccessCode onInstagramAuthSuccess");
            this.f4692a.f4693a.m6618a(instagramDataSet.getUserName());
            this.f4692a.f4693a.m6619b(!TextUtils.isEmpty(instagramDataSet.getLastFetchTime()));
        }

        public void m7041a(@NonNull InstagramAuthError instagramAuthError) {
            C3095y.m9479c("authenticateWithAccessCode onInstagramAuthFailure");
            CharSequence error = instagramAuthError.getError();
            C3095y.m9471a("error:" + error);
            if (TextUtils.equals("Instagram Account already in use.", error)) {
                this.f4692a.f4693a.m6624j();
            } else {
                this.f4692a.f4693a.m6622h();
            }
        }
    }

    public C2557a(C2421c c2421c, C2419a c2419a) {
        this.f4693a = c2421c;
        this.f4694b = c2419a;
    }

    public void m7044a(int i) {
        C3095y.m9471a("analytics instagram connect from:" + i);
        SparksEvent sparksEvent = new SparksEvent("Account.InstagramConnect");
        sparksEvent.put("from", Integer.valueOf(i));
        C2807a.m8056a(sparksEvent);
        this.f4693a.m6620f();
    }

    public void m7046b(int i) {
        this.f4693a.m6625k();
        this.f4694b.m6613a(i, new C25551(this));
    }

    public void m7045a(String str) {
        if (TextUtils.isEmpty(str)) {
            C3095y.m9479c("authenticateWithAccessCode empty access code.");
            this.f4693a.m6622h();
            return;
        }
        C3095y.m9471a("authenticateWithAccessCode access code:" + str);
        this.f4694b.m6614a(str, new C25562(this));
    }
}

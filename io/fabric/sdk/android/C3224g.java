package io.fabric.sdk.android;

import io.fabric.sdk.android.services.common.C3267q;
import io.fabric.sdk.android.services.concurrency.C3223c;
import io.fabric.sdk.android.services.concurrency.Priority;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;

/* renamed from: io.fabric.sdk.android.g */
class C3224g<Result> extends C3223c<Void, Void, Result> {
    final C0347h<Result> f6985a;

    public C3224g(C0347h<Result> c0347h) {
        this.f6985a = c0347h;
    }

    protected void m9775a() {
        super.m9756a();
        C3267q a = m9772a("onPreExecute");
        try {
            boolean a_ = this.f6985a.a_();
            a.m9978b();
            if (!a_) {
                m9758a(true);
            }
        } catch (UnmetDependencyException e) {
            throw e;
        } catch (Throwable e2) {
            C3218c.m9728h().m9695e("Fabric", "Failure onPreExecute()", e2);
            a.m9978b();
            m9758a(true);
        } catch (Throwable th) {
            a.m9978b();
            m9758a(true);
        }
    }

    protected Result m9774a(Void... voidArr) {
        C3267q a = m9772a("doInBackground");
        Result result = null;
        if (!m9761e()) {
            result = this.f6985a.m414f();
        }
        a.m9978b();
        return result;
    }

    protected void m9776a(Result result) {
        this.f6985a.m410a((Object) result);
        this.f6985a.f355h.m9713a((Object) result);
    }

    protected void m9778b(Result result) {
        this.f6985a.m412b((Object) result);
        this.f6985a.f355h.m9712a(new InitializationException(this.f6985a.m411b() + " Initialization was cancelled"));
    }

    public Priority m9777b() {
        return Priority.HIGH;
    }

    private C3267q m9772a(String str) {
        C3267q c3267q = new C3267q(this.f6985a.m411b() + "." + str, "KitInitialization");
        c3267q.m9977a();
        return c3267q;
    }
}

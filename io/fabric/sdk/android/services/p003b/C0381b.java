package io.fabric.sdk.android.services.p003b;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: io.fabric.sdk.android.services.b.b */
public abstract class C0381b<T> implements C0377h<T> {
    protected final Context f438g;
    protected final C0389d<T> f439h;
    final ScheduledExecutorService f440i;
    final AtomicReference<ScheduledFuture<?>> f441j;
    volatile int f442k;

    public C0381b(Context context, ScheduledExecutorService scheduledExecutorService, C0389d<T> c0389d) {
        this.f442k = -1;
        this.f438g = context;
        this.f440i = scheduledExecutorService;
        this.f439h = c0389d;
        this.f441j = new AtomicReference();
    }

    public void m523f() {
        if ((this.f442k != -1 ? 1 : null) != null) {
            m517a((long) this.f442k, (long) this.f442k);
        }
    }

    public void m519b() {
        m524g();
    }

    public void m521d() {
        if (this.f441j.get() != null) {
            CommonUtils.m9852a(this.f438g, "Cancelling time-based rollover because no events are currently being generated.");
            ((ScheduledFuture) this.f441j.get()).cancel(false);
            this.f441j.set(null);
        }
    }

    public void m520c() {
        this.f439h.m548f();
    }

    public void m518a(T t) {
        CommonUtils.m9852a(this.f438g, t.toString());
        try {
            this.f439h.m542a((Object) t);
        } catch (Throwable e) {
            CommonUtils.m9853a(this.f438g, "Failed to write event.", e);
        }
        m523f();
    }

    public boolean m522e() {
        try {
            return this.f439h.m546d();
        } catch (Throwable e) {
            CommonUtils.m9853a(this.f438g, "Failed to roll file over.", e);
            return false;
        }
    }

    protected void m516a(int i) {
        this.f442k = i;
        m517a(0, (long) this.f442k);
    }

    void m517a(long j, long j2) {
        if ((this.f441j.get() == null ? 1 : null) != null) {
            Runnable c3235m = new C3235m(this.f438g, this);
            CommonUtils.m9852a(this.f438g, "Scheduling time based file roll over every " + j2 + " seconds");
            try {
                this.f441j.set(this.f440i.scheduleAtFixedRate(c3235m, j, j2, TimeUnit.SECONDS));
            } catch (Throwable e) {
                CommonUtils.m9853a(this.f438g, "Failed to schedule time based file roll over", e);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m524g() {
        /*
        r10 = this;
        r1 = 0;
        r3 = r10.m506a();
        if (r3 != 0) goto L_0x000f;
    L_0x0007:
        r0 = r10.f438g;
        r1 = "skipping files send because we don't yet know the target endpoint";
        io.fabric.sdk.android.services.common.CommonUtils.m9852a(r0, r1);
    L_0x000e:
        return;
    L_0x000f:
        r0 = r10.f438g;
        r2 = "Sending all files";
        io.fabric.sdk.android.services.common.CommonUtils.m9852a(r0, r2);
        r0 = r10.f439h;
        r0 = r0.m547e();
        r2 = r0;
        r0 = r1;
    L_0x001e:
        r1 = r2.size();	 Catch:{ Exception -> 0x0062 }
        if (r1 <= 0) goto L_0x0052;
    L_0x0024:
        r1 = r10.f438g;	 Catch:{ Exception -> 0x0062 }
        r4 = java.util.Locale.US;	 Catch:{ Exception -> 0x0062 }
        r5 = "attempt to send batch of %d files";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x0062 }
        r7 = 0;
        r8 = r2.size();	 Catch:{ Exception -> 0x0062 }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x0062 }
        r6[r7] = r8;	 Catch:{ Exception -> 0x0062 }
        r4 = java.lang.String.format(r4, r5, r6);	 Catch:{ Exception -> 0x0062 }
        io.fabric.sdk.android.services.common.CommonUtils.m9852a(r1, r4);	 Catch:{ Exception -> 0x0062 }
        r4 = r3.m499a(r2);	 Catch:{ Exception -> 0x0062 }
        if (r4 == 0) goto L_0x0050;
    L_0x0045:
        r1 = r2.size();	 Catch:{ Exception -> 0x0062 }
        r1 = r1 + r0;
        r0 = r10.f439h;	 Catch:{ Exception -> 0x0084 }
        r0.m543a(r2);	 Catch:{ Exception -> 0x0084 }
        r0 = r1;
    L_0x0050:
        if (r4 != 0) goto L_0x005a;
    L_0x0052:
        if (r0 != 0) goto L_0x000e;
    L_0x0054:
        r0 = r10.f439h;
        r0.m549g();
        goto L_0x000e;
    L_0x005a:
        r1 = r10.f439h;	 Catch:{ Exception -> 0x0062 }
        r1 = r1.m547e();	 Catch:{ Exception -> 0x0062 }
        r2 = r1;
        goto L_0x001e;
    L_0x0062:
        r1 = move-exception;
        r9 = r1;
        r1 = r0;
        r0 = r9;
    L_0x0066:
        r2 = r10.f438g;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Failed to send batch of analytics files to server: ";
        r3 = r3.append(r4);
        r4 = r0.getMessage();
        r3 = r3.append(r4);
        r3 = r3.toString();
        io.fabric.sdk.android.services.common.CommonUtils.m9853a(r2, r3, r0);
        r0 = r1;
        goto L_0x0052;
    L_0x0084:
        r0 = move-exception;
        goto L_0x0066;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.b.b.g():void");
    }
}

package com.crashlytics.android.core;

import android.os.Process;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.IdManager;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.crashlytics.android.core.c */
class C0407c {
    private static final AtomicLong f529a;
    private static String f530b;

    static {
        f529a = new AtomicLong(0);
    }

    public C0407c(IdManager idManager) {
        r0 = new byte[10];
        m625a(r0);
        m627b(r0);
        m629c(r0);
        String a = CommonUtils.m9845a(idManager.m9893b());
        String a2 = CommonUtils.m9847a(r0);
        f530b = String.format(Locale.US, "%s-%s-%s-%s", new Object[]{a2.substring(0, 12), a2.substring(12, 16), a2.subSequence(16, 20), a.substring(0, 12)}).toUpperCase(Locale.US);
    }

    private void m625a(byte[] bArr) {
        long time = new Date().getTime();
        long j = time / 1000;
        time %= 1000;
        byte[] a = C0407c.m626a(j);
        bArr[0] = a[0];
        bArr[1] = a[1];
        bArr[2] = a[2];
        bArr[3] = a[3];
        byte[] b = C0407c.m628b(time);
        bArr[4] = b[0];
        bArr[5] = b[1];
    }

    private void m627b(byte[] bArr) {
        byte[] b = C0407c.m628b(f529a.incrementAndGet());
        bArr[6] = b[0];
        bArr[7] = b[1];
    }

    private void m629c(byte[] bArr) {
        byte[] b = C0407c.m628b((long) Integer.valueOf(Process.myPid()).shortValue());
        bArr[8] = b[0];
        bArr[9] = b[1];
    }

    private static byte[] m626a(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt((int) j);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    private static byte[] m628b(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.putShort((short) ((int) j));
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    public String toString() {
        return f530b;
    }
}

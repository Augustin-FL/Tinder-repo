package io.fabric.sdk.android.services.p003b;

import android.content.Context;
import io.fabric.sdk.android.services.common.C3254j;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: io.fabric.sdk.android.services.b.d */
public abstract class C0389d<T> {
    protected final Context f458a;
    protected final C0394c<T> f459b;
    protected final C3254j f460c;
    protected final C3232f f461d;
    protected volatile long f462e;
    protected final List<C0368g> f463f;
    private final int f464g;

    /* renamed from: io.fabric.sdk.android.services.b.d.1 */
    class C32301 implements Comparator<C3231a> {
        final /* synthetic */ C0389d f7002a;

        C32301(C0389d c0389d) {
            this.f7002a = c0389d;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m9801a((C3231a) obj, (C3231a) obj2);
        }

        public int m9801a(C3231a c3231a, C3231a c3231a2) {
            return (int) (c3231a.f7004b - c3231a2.f7004b);
        }
    }

    /* renamed from: io.fabric.sdk.android.services.b.d.a */
    static class C3231a {
        final File f7003a;
        final long f7004b;

        public C3231a(File file, long j) {
            this.f7003a = file;
            this.f7004b = j;
        }
    }

    protected abstract String m540a();

    public C0389d(Context context, C0394c<T> c0394c, C3254j c3254j, C3232f c3232f, int i) throws IOException {
        this.f463f = new CopyOnWriteArrayList();
        this.f458a = context.getApplicationContext();
        this.f459b = c0394c;
        this.f461d = c3232f;
        this.f460c = c3254j;
        this.f462e = this.f460c.m9935a();
        this.f464g = i;
    }

    public void m542a(T t) throws IOException {
        byte[] a = this.f459b.m561a(t);
        m537a(a.length);
        this.f461d.m9806a(a);
    }

    public void m541a(C0368g c0368g) {
        if (c0368g != null) {
            this.f463f.add(c0368g);
        }
    }

    public boolean m546d() throws IOException {
        boolean z = true;
        String str = null;
        if (this.f461d.m9808b()) {
            z = false;
        } else {
            str = m540a();
            this.f461d.m9804a(str);
            CommonUtils.m9851a(this.f458a, 4, "Fabric", String.format(Locale.US, "generated new file %s", new Object[]{str}));
            this.f462e = this.f460c.m9935a();
        }
        m538b(str);
        return z;
    }

    private void m537a(int i) throws IOException {
        if (!this.f461d.m9807a(i, m545c())) {
            CommonUtils.m9851a(this.f458a, 4, "Fabric", String.format(Locale.US, "session analytics events file is %d bytes, new event is %d bytes, this is over flush limit of %d, rolling it over", new Object[]{Integer.valueOf(this.f461d.m9802a()), Integer.valueOf(i), Integer.valueOf(m545c())}));
            m546d();
        }
    }

    protected int m544b() {
        return this.f464g;
    }

    protected int m545c() {
        return 8000;
    }

    private void m538b(String str) {
        for (C0368g a : this.f463f) {
            try {
                a.m473a(str);
            } catch (Throwable e) {
                CommonUtils.m9853a(this.f458a, "One of the roll over listeners threw an exception", e);
            }
        }
    }

    public List<File> m547e() {
        return this.f461d.m9803a(1);
    }

    public void m543a(List<File> list) {
        this.f461d.m9805a((List) list);
    }

    public void m548f() {
        this.f461d.m9805a(this.f461d.m9809c());
        this.f461d.m9810d();
    }

    public void m549g() {
        List<File> c = this.f461d.m9809c();
        int b = m544b();
        if (c.size() > b) {
            int size = c.size() - b;
            CommonUtils.m9852a(this.f458a, String.format(Locale.US, "Found %d files in  roll over directory, this is greater than %d, deleting %d oldest files", new Object[]{Integer.valueOf(c.size()), Integer.valueOf(b), Integer.valueOf(size)}));
            TreeSet treeSet = new TreeSet(new C32301(this));
            for (File file : c) {
                treeSet.add(new C3231a(file, m539a(file.getName())));
            }
            List arrayList = new ArrayList();
            Iterator it = treeSet.iterator();
            while (it.hasNext()) {
                arrayList.add(((C3231a) it.next()).f7003a);
                if (arrayList.size() == size) {
                    break;
                }
            }
            this.f461d.m9805a(arrayList);
        }
    }

    public long m539a(String str) {
        long j = 0;
        String[] split = str.split("_");
        if (split.length == 3) {
            try {
                j = Long.valueOf(split[2]).longValue();
            } catch (NumberFormatException e) {
            }
        }
        return j;
    }
}

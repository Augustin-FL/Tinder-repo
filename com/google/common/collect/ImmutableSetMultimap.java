package com.google.common.collect;

import com.google.common.base.C1430c;
import com.google.common.base.C1650g;
import com.google.common.collect.ImmutableMap.C1762a;
import com.google.common.collect.ImmutableMultimap.C1777a;
import com.google.common.collect.ImmutableMultimap.C1778b;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

public class ImmutableSetMultimap<K, V> extends ImmutableMultimap<K, V> implements C1759y<K, V> {
    private static final long serialVersionUID = 0;
    private final transient ImmutableSortedSet<V> f2241a;

    private static class BuilderMultimap<K, V> extends AbstractMapBasedMultimap<K, V> {
        private static final long serialVersionUID = 0;

        BuilderMultimap() {
            super(new LinkedHashMap());
        }

        Collection<V> m3838a() {
            return Sets.m4235b();
        }
    }

    /* renamed from: com.google.common.collect.ImmutableSetMultimap.a */
    public static final class C1781a<K, V> extends C1777a<K, V> {

        /* renamed from: com.google.common.collect.ImmutableSetMultimap.a.1 */
        class C17801 implements C1430c<Entry<K, Collection<V>>, K> {
            final /* synthetic */ C1781a f2301a;

            C17801(C1781a c1781a) {
                this.f2301a = c1781a;
            }

            public K m3840a(Entry<K, Collection<V>> entry) {
                return entry.getKey();
            }
        }

        public C1781a() {
            this.a = new BuilderMultimap();
        }

        public C1781a<K, V> m3841a(K k, V v) {
            this.a.m3588a(C1650g.m3080a((Object) k), C1650g.m3080a((Object) v));
            return this;
        }

        public ImmutableSetMultimap<K, V> m3842a() {
            if (this.b != null) {
                C1755r builderMultimap = new BuilderMultimap();
                List<Entry> a = C1872p.m4310a(this.a.m3592h().entrySet());
                Collections.sort(a, C1757u.m3620a(this.b).m3624a(new C17801(this)));
                for (Entry entry : a) {
                    builderMultimap.m3587a(entry.getKey(), (Iterable) entry.getValue());
                }
                this.a = builderMultimap;
            }
            return ImmutableSetMultimap.m3699b(this.a, this.c);
        }
    }

    public /* synthetic */ ImmutableCollection m3702a(Object obj) {
        return m3704c(obj);
    }

    public /* synthetic */ Collection m3703b(Object obj) {
        return m3704c(obj);
    }

    public static <K, V> ImmutableSetMultimap<K, V> m3700j() {
        return EmptyImmutableSetMultimap.f2242a;
    }

    public static <K, V> C1781a<K, V> m3701k() {
        return new C1781a();
    }

    private static <K, V> ImmutableSetMultimap<K, V> m3699b(C1755r<? extends K, ? extends V> c1755r, Comparator<? super V> comparator) {
        C1650g.m3080a((Object) c1755r);
        if (c1755r.m3591f() && comparator == null) {
            return m3700j();
        }
        if (c1755r instanceof ImmutableSetMultimap) {
            ImmutableSetMultimap<K, V> immutableSetMultimap = (ImmutableSetMultimap) c1755r;
            if (!immutableSetMultimap.m3687a()) {
                return immutableSetMultimap;
            }
        }
        C1762a j = ImmutableMap.m3630j();
        int i = 0;
        for (Entry entry : c1755r.m3592h().entrySet()) {
            int i2;
            Object key = entry.getKey();
            Collection collection = (Collection) entry.getValue();
            ImmutableSet a = comparator == null ? ImmutableSet.m3672a(collection) : ImmutableSortedSet.m3734a((Comparator) comparator, collection);
            if (a.isEmpty()) {
                i2 = i;
            } else {
                j.m3765b(key, a);
                i2 = a.size() + i;
            }
            i = i2;
        }
        return new ImmutableSetMultimap(j.m3767b(), i, comparator);
    }

    ImmutableSetMultimap(ImmutableMap<K, ImmutableSet<V>> immutableMap, int i, Comparator<? super V> comparator) {
        super(immutableMap, i);
        this.f2241a = comparator == null ? null : ImmutableSortedSet.m3732a((Comparator) comparator);
    }

    public ImmutableSet<V> m3704c(K k) {
        ImmutableSet<V> immutableSet = (ImmutableSet) this.b.get(k);
        if (immutableSet != null) {
            return immutableSet;
        }
        if (this.f2241a != null) {
            return this.f2241a;
        }
        return ImmutableSet.m3678g();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        C1883x.m4356a((C1755r) this, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt < 0) {
            throw new InvalidObjectException("Invalid key count " + readInt);
        }
        C1762a j = ImmutableMap.m3630j();
        int i = 0;
        for (int i2 = 0; i2 < readInt; i2++) {
            Object readObject = objectInputStream.readObject();
            int readInt2 = objectInputStream.readInt();
            if (readInt2 <= 0) {
                throw new InvalidObjectException("Invalid value count " + readInt2);
            }
            Object[] objArr = new Object[readInt2];
            for (int i3 = 0; i3 < readInt2; i3++) {
                objArr[i3] = objectInputStream.readObject();
            }
            ImmutableSet a = ImmutableSet.m3674a(objArr);
            if (a.size() != objArr.length) {
                throw new InvalidObjectException("Duplicate key-value pairs exist for key " + readObject);
            }
            j.m3765b(readObject, a);
            i += readInt2;
        }
        try {
            C1778b.f2295a.m4354a((Object) this, j.m3767b());
            C1778b.f2296b.m4353a((Object) this, i);
        } catch (Throwable e) {
            throw ((InvalidObjectException) new InvalidObjectException(e.getMessage()).initCause(e));
        }
    }
}

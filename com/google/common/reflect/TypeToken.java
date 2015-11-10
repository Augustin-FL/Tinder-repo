package com.google.common.reflect;

import com.google.common.base.C1620h;
import com.google.common.base.C1650g;
import com.google.common.collect.C1757u;
import com.google.common.collect.C1852g;
import com.google.common.collect.C1855l;
import com.google.common.collect.C1876q;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.C1774a;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.C1779a;
import com.google.common.reflect.C1885b.C1886a;
import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class TypeToken<T> extends C1888c<T> implements Serializable {
    private final Type f2531a;
    private transient C1904d f2532b;

    /* renamed from: com.google.common.reflect.TypeToken.1 */
    class C18871 extends C1886a<T> {
    }

    private static final class SimpleTypeToken<T> extends TypeToken<T> {
        private static final long serialVersionUID = 0;

        SimpleTypeToken(Type type) {
            super(null);
        }
    }

    private enum TypeFilter implements C1620h<TypeToken<?>> {
        IGNORE_TYPE_VARIABLE_OR_WILDCARD {
            public boolean m4374a(TypeToken<?> typeToken) {
                return ((typeToken.f2531a instanceof TypeVariable) || (typeToken.f2531a instanceof WildcardType)) ? false : true;
            }
        },
        INTERFACE_ONLY {
            public boolean m4376a(TypeToken<?> typeToken) {
                return typeToken.m4370b().isInterface();
            }
        };
    }

    public class TypeSet extends C1855l<TypeToken<? super T>> implements Serializable {
        private static final long serialVersionUID = 0;
        final /* synthetic */ TypeToken f2536a;
        private transient ImmutableSet<TypeToken<? super T>> f2537b;

        protected /* synthetic */ Collection m4378a() {
            return m4380c();
        }

        protected /* synthetic */ Object m4379b() {
            return m4380c();
        }

        TypeSet(TypeToken typeToken) {
            this.f2536a = typeToken;
        }

        protected Set<TypeToken<? super T>> m4380c() {
            Set<TypeToken<? super T>> set = this.f2537b;
            if (set != null) {
                return set;
            }
            Set a = C1852g.m4268a(C1891a.f2538a.m4385a(this.f2536a)).m4270a(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).m4269a();
            this.f2537b = a;
            return a;
        }

        public Set<Class<? super T>> m4381d() {
            return ImmutableSet.m3672a(C1891a.f2539b.m4384a(this.f2536a.m4367f()));
        }
    }

    /* renamed from: com.google.common.reflect.TypeToken.a */
    private static abstract class C1891a<K> {
        static final C1891a<TypeToken<?>> f2538a;
        static final C1891a<Class<?>> f2539b;

        /* renamed from: com.google.common.reflect.TypeToken.a.1 */
        static class C18921 extends C1891a<TypeToken<?>> {
            C18921() {
                super();
            }

            /* synthetic */ Class m4390b(Object obj) {
                return m4389a((TypeToken) obj);
            }

            /* synthetic */ Iterable m4393c(Object obj) {
                return m4391b((TypeToken) obj);
            }

            /* synthetic */ Object m4394d(Object obj) {
                return m4392c((TypeToken) obj);
            }

            Class<?> m4389a(TypeToken<?> typeToken) {
                return typeToken.m4370b();
            }

            Iterable<? extends TypeToken<?>> m4391b(TypeToken<?> typeToken) {
                return typeToken.m4372d();
            }

            TypeToken<?> m4392c(TypeToken<?> typeToken) {
                return typeToken.m4371c();
            }
        }

        /* renamed from: com.google.common.reflect.TypeToken.a.2 */
        static class C18932 extends C1891a<Class<?>> {
            C18932() {
                super();
            }

            /* synthetic */ Class m4396b(Object obj) {
                return m4395a((Class) obj);
            }

            /* synthetic */ Iterable m4399c(Object obj) {
                return m4397b((Class) obj);
            }

            /* synthetic */ Object m4400d(Object obj) {
                return m4398c((Class) obj);
            }

            Class<?> m4395a(Class<?> cls) {
                return cls;
            }

            Iterable<? extends Class<?>> m4397b(Class<?> cls) {
                List arrayList = new ArrayList();
                for (Object add : cls.getInterfaces()) {
                    arrayList.add(add);
                }
                return Collections.unmodifiableList(arrayList);
            }

            Class<?> m4398c(Class<?> cls) {
                return cls.getSuperclass();
            }
        }

        /* renamed from: com.google.common.reflect.TypeToken.a.3 */
        static class C18943 extends C1757u<K> {
            final /* synthetic */ Comparator f2540a;
            final /* synthetic */ Map f2541b;

            C18943(Comparator comparator, Map map) {
                this.f2540a = comparator;
                this.f2541b = map;
            }

            public int compare(K k, K k2) {
                return this.f2540a.compare(this.f2541b.get(k), this.f2541b.get(k2));
            }
        }

        abstract Class<?> m4386b(K k);

        abstract Iterable<? extends K> m4387c(K k);

        abstract K m4388d(K k);

        private C1891a() {
        }

        static {
            f2538a = new C18921();
            f2539b = new C18932();
        }

        final ImmutableList<K> m4385a(K k) {
            return m4384a(ImmutableList.m3650a((Object) k));
        }

        ImmutableList<K> m4384a(Iterable<? extends K> iterable) {
            Map a = C1876q.m4328a();
            for (Object a2 : iterable) {
                m4382a(a2, a);
            }
            return C1891a.m4383a(a, C1757u.m3621b().m3623a());
        }

        private int m4382a(K k, Map<? super K, Integer> map) {
            Integer num = (Integer) map.get(this);
            if (num != null) {
                return num.intValue();
            }
            int i = m4386b(k).isInterface() ? 1 : 0;
            for (Object a : m4387c(k)) {
                i = Math.max(i, m4382a(a, (Map) map));
            }
            Object d = m4388d(k);
            if (d != null) {
                i = Math.max(i, m4382a(d, (Map) map));
            }
            map.put(k, Integer.valueOf(i + 1));
            return i + 1;
        }

        private static <K, V> ImmutableList<K> m4383a(Map<K, V> map, Comparator<? super V> comparator) {
            return new C18943(comparator, map).m3622a(map.keySet());
        }
    }

    protected TypeToken() {
        this.f2531a = m4357a();
        C1650g.m3093b(!(this.f2531a instanceof TypeVariable), "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", this.f2531a);
    }

    private TypeToken(Type type) {
        this.f2531a = (Type) C1650g.m3080a((Object) type);
    }

    public static <T> TypeToken<T> m4360a(Class<T> cls) {
        return new SimpleTypeToken(cls);
    }

    public static TypeToken<?> m4361a(Type type) {
        return new SimpleTypeToken(type);
    }

    public final Class<? super T> m4370b() {
        return m4364c(this.f2531a);
    }

    private ImmutableSet<Class<? super T>> m4367f() {
        return m4365d(this.f2531a);
    }

    public final TypeToken<?> m4369b(Type type) {
        C1650g.m3080a((Object) type);
        C1904d c1904d = this.f2532b;
        if (c1904d == null) {
            c1904d = C1904d.m4431a(this.f2531a);
            this.f2532b = c1904d;
        }
        return m4361a(c1904d.m4438b(type));
    }

    private TypeToken<?> m4366e(Type type) {
        TypeToken<?> b = m4369b(type);
        b.f2532b = this.f2532b;
        return b;
    }

    final TypeToken<? super T> m4371c() {
        if (this.f2531a instanceof TypeVariable) {
            return m4368f(((TypeVariable) this.f2531a).getBounds()[0]);
        }
        if (this.f2531a instanceof WildcardType) {
            return m4368f(((WildcardType) this.f2531a).getUpperBounds()[0]);
        }
        Type genericSuperclass = m4370b().getGenericSuperclass();
        if (genericSuperclass == null) {
            return null;
        }
        return m4366e(genericSuperclass);
    }

    private TypeToken<? super T> m4368f(Type type) {
        TypeToken<? super T> a = m4361a(type);
        if (a.m4370b().isInterface()) {
            return null;
        }
        return a;
    }

    final ImmutableList<TypeToken<? super T>> m4372d() {
        if (this.f2531a instanceof TypeVariable) {
            return m4358a(((TypeVariable) this.f2531a).getBounds());
        }
        if (this.f2531a instanceof WildcardType) {
            return m4358a(((WildcardType) this.f2531a).getUpperBounds());
        }
        C1774a h = ImmutableList.m3657h();
        for (Type e : m4370b().getGenericInterfaces()) {
            h.m3815b(m4366e(e));
        }
        return h.m3813a();
    }

    private ImmutableList<TypeToken<? super T>> m4358a(Type[] typeArr) {
        C1774a h = ImmutableList.m3657h();
        for (Type a : typeArr) {
            Object a2 = m4361a(a);
            if (a2.m4370b().isInterface()) {
                h.m3815b(a2);
            }
        }
        return h.m3813a();
    }

    public final TypeSet m4373e() {
        return new TypeSet(this);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TypeToken)) {
            return false;
        }
        return this.f2531a.equals(((TypeToken) obj).f2531a);
    }

    public int hashCode() {
        return this.f2531a.hashCode();
    }

    public String toString() {
        return Types.m4430d(this.f2531a);
    }

    protected Object writeReplace() {
        return m4361a(new C1904d().m4438b(this.f2531a));
    }

    static Class<?> m4364c(Type type) {
        return (Class) m4365d(type).m3680b().next();
    }

    static ImmutableSet<Class<?>> m4365d(Type type) {
        if (type instanceof Class) {
            return ImmutableSet.m3676b((Class) type);
        }
        if (type instanceof ParameterizedType) {
            return ImmutableSet.m3676b((Class) ((ParameterizedType) type).getRawType());
        }
        if (type instanceof GenericArrayType) {
            return ImmutableSet.m3676b(Types.m4416a(m4364c(((GenericArrayType) type).getGenericComponentType())));
        }
        if (type instanceof TypeVariable) {
            return m4362b(((TypeVariable) type).getBounds());
        }
        if (type instanceof WildcardType) {
            return m4362b(((WildcardType) type).getUpperBounds());
        }
        throw new AssertionError(type + " unsupported");
    }

    private static ImmutableSet<Class<?>> m4362b(Type[] typeArr) {
        C1779a h = ImmutableSet.m3679h();
        for (Type d : typeArr) {
            h.m3835b(m4365d(d));
        }
        return h.m3834a();
    }
}

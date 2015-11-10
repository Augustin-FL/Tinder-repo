package com.google.common.reflect;

import com.google.common.base.C1430c;
import com.google.common.base.C1640d;
import com.google.common.base.C1647e;
import com.google.common.base.C1650g;
import com.google.common.base.Predicates;
import com.google.common.collect.C1859n;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.C1774a;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

final class Types {
    private static final C1430c<Type, String> f2559a;
    private static final C1640d f2560b;

    /* renamed from: com.google.common.reflect.Types.1 */
    static class C18951 implements C1430c<Type, String> {
        C18951() {
        }

        public String m4402a(Type type) {
            return Types.m4430d(type);
        }
    }

    private enum ClassOwnership {
        OWNED_BY_ENCLOSING_CLASS {
            Class<?> m4405a(Class<?> cls) {
                return cls.getEnclosingClass();
            }
        },
        LOCAL_CLASS_HAS_NO_OWNER {
            Class<?> m4406a(Class<?> cls) {
                if (cls.isLocalClass()) {
                    return null;
                }
                return cls.getEnclosingClass();
            }
        };
        
        static final ClassOwnership f2544c;

        /* renamed from: com.google.common.reflect.Types.ClassOwnership.a */
        class C1898a<T> {
            C1898a() {
            }
        }

        /* renamed from: com.google.common.reflect.Types.ClassOwnership.3 */
        static class C18993 extends C1898a<String> {
            C18993() {
            }
        }

        abstract Class<?> m4404a(Class<?> cls);

        static {
            f2544c = m4403a();
        }

        private static ClassOwnership m4403a() {
            ParameterizedType parameterizedType = (ParameterizedType) new C18993().getClass().getGenericSuperclass();
            for (ClassOwnership classOwnership : values()) {
                if (classOwnership.m4404a(C1898a.class) == parameterizedType.getOwnerType()) {
                    return classOwnership;
                }
            }
            throw new AssertionError();
        }
    }

    private static final class GenericArrayTypeImpl implements Serializable, GenericArrayType {
        private static final long serialVersionUID = 0;
        private final Type f2546a;

        GenericArrayTypeImpl(Type type) {
            this.f2546a = JavaVersion.f2549c.m4409b(type);
        }

        public Type getGenericComponentType() {
            return this.f2546a;
        }

        public String toString() {
            return Types.m4430d(this.f2546a) + "[]";
        }

        public int hashCode() {
            return this.f2546a.hashCode();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof GenericArrayType)) {
                return false;
            }
            return C1647e.m3074a(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType());
        }
    }

    enum JavaVersion {
        JAVA6 {
            /* synthetic */ Type m4410a(Type type) {
                return m4412c(type);
            }

            GenericArrayType m4412c(Type type) {
                return new GenericArrayTypeImpl(type);
            }

            Type m4411b(Type type) {
                C1650g.m3080a((Object) type);
                if (!(type instanceof Class)) {
                    return type;
                }
                Class cls = (Class) type;
                if (cls.isArray()) {
                    return new GenericArrayTypeImpl(cls.getComponentType());
                }
                return type;
            }
        },
        JAVA7 {
            Type m4413a(Type type) {
                if (type instanceof Class) {
                    return Types.m4416a((Class) type);
                }
                return new GenericArrayTypeImpl(type);
            }

            Type m4414b(Type type) {
                return (Type) C1650g.m3080a((Object) type);
            }
        };
        
        static final JavaVersion f2549c;

        /* renamed from: com.google.common.reflect.Types.JavaVersion.1 */
        static class C19001 extends C1888c<int[]> {
            C19001() {
            }
        }

        abstract Type m4408a(Type type);

        abstract Type m4409b(Type type);

        final ImmutableList<Type> m4407a(Type[] typeArr) {
            C1774a h = ImmutableList.m3657h();
            for (Type b : typeArr) {
                h.m3815b(m4409b(b));
            }
            return h.m3813a();
        }
    }

    private static final class ParameterizedTypeImpl implements Serializable, ParameterizedType {
        private static final long serialVersionUID = 0;
        private final Type f2551a;
        private final ImmutableList<Type> f2552b;
        private final Class<?> f2553c;

        ParameterizedTypeImpl(Type type, Class<?> cls, Type[] typeArr) {
            C1650g.m3080a((Object) cls);
            C1650g.m3085a(typeArr.length == cls.getTypeParameters().length);
            Types.m4427b(typeArr, "type parameter");
            this.f2551a = type;
            this.f2553c = cls;
            this.f2552b = JavaVersion.f2549c.m4407a(typeArr);
        }

        public Type[] getActualTypeArguments() {
            return Types.m4428b(this.f2552b);
        }

        public Type getRawType() {
            return this.f2553c;
        }

        public Type getOwnerType() {
            return this.f2551a;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            if (this.f2551a != null) {
                stringBuilder.append(Types.m4430d(this.f2551a)).append('.');
            }
            stringBuilder.append(this.f2553c.getName()).append('<').append(Types.f2560b.m3048a(C1859n.m4278a(this.f2552b, Types.f2559a))).append('>');
            return stringBuilder.toString();
        }

        public int hashCode() {
            return ((this.f2551a == null ? 0 : this.f2551a.hashCode()) ^ this.f2552b.hashCode()) ^ this.f2553c.hashCode();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            if (getRawType().equals(parameterizedType.getRawType()) && C1647e.m3074a(getOwnerType(), parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments())) {
                return true;
            }
            return false;
        }
    }

    static final class WildcardTypeImpl implements Serializable, WildcardType {
        private static final long serialVersionUID = 0;
        private final ImmutableList<Type> f2554a;
        private final ImmutableList<Type> f2555b;

        WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            Types.m4427b(typeArr, "lower bound for wildcard");
            Types.m4427b(typeArr2, "upper bound for wildcard");
            this.f2554a = JavaVersion.f2549c.m4407a(typeArr);
            this.f2555b = JavaVersion.f2549c.m4407a(typeArr2);
        }

        public Type[] getLowerBounds() {
            return Types.m4428b(this.f2554a);
        }

        public Type[] getUpperBounds() {
            return Types.m4428b(this.f2555b);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) obj;
            if (this.f2554a.equals(Arrays.asList(wildcardType.getLowerBounds())) && this.f2555b.equals(Arrays.asList(wildcardType.getUpperBounds()))) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.f2554a.hashCode() ^ this.f2555b.hashCode();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("?");
            Iterator it = this.f2554a.iterator();
            while (it.hasNext()) {
                stringBuilder.append(" super ").append(Types.m4430d((Type) it.next()));
            }
            for (Type d : Types.m4425b(this.f2555b)) {
                stringBuilder.append(" extends ").append(Types.m4430d(d));
            }
            return stringBuilder.toString();
        }
    }

    /* renamed from: com.google.common.reflect.Types.a */
    private static final class C1903a<D extends GenericDeclaration> implements TypeVariable<D> {
        private final D f2556a;
        private final String f2557b;
        private final ImmutableList<Type> f2558c;

        C1903a(D d, String str, Type[] typeArr) {
            Types.m4427b(typeArr, "bound for type variable");
            this.f2556a = (GenericDeclaration) C1650g.m3080a((Object) d);
            this.f2557b = (String) C1650g.m3080a((Object) str);
            this.f2558c = ImmutableList.m3652a((Object[]) typeArr);
        }

        public Type[] getBounds() {
            return Types.m4428b(this.f2558c);
        }

        public D getGenericDeclaration() {
            return this.f2556a;
        }

        public String getName() {
            return this.f2557b;
        }

        public String toString() {
            return this.f2557b;
        }

        public int hashCode() {
            return this.f2556a.hashCode() ^ this.f2557b.hashCode();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof TypeVariable)) {
                return false;
            }
            TypeVariable typeVariable = (TypeVariable) obj;
            if (this.f2557b.equals(typeVariable.getName()) && this.f2556a.equals(typeVariable.getGenericDeclaration())) {
                return true;
            }
            return false;
        }
    }

    static {
        f2559a = new C18951();
        f2560b = C1640d.m3043a(", ").m3054b("null");
    }

    static Type m4420a(Type type) {
        boolean z = true;
        if (!(type instanceof WildcardType)) {
            return JavaVersion.f2549c.m4408a(type);
        }
        WildcardType wildcardType = (WildcardType) type;
        Type[] lowerBounds = wildcardType.getLowerBounds();
        C1650g.m3086a(lowerBounds.length <= 1, (Object) "Wildcard cannot have more than one lower bounds.");
        if (lowerBounds.length == 1) {
            return m4429c(m4420a(lowerBounds[0]));
        }
        Type[] upperBounds = wildcardType.getUpperBounds();
        if (upperBounds.length != 1) {
            z = false;
        }
        C1650g.m3086a(z, (Object) "Wildcard should have only one upper bound.");
        return m4426b(m4420a(upperBounds[0]));
    }

    static ParameterizedType m4419a(Type type, Class<?> cls, Type... typeArr) {
        if (type == null) {
            return m4418a((Class) cls, typeArr);
        }
        boolean z;
        C1650g.m3080a((Object) typeArr);
        if (cls.getEnclosingClass() != null) {
            z = true;
        } else {
            z = false;
        }
        C1650g.m3087a(z, "Owner type for unenclosed %s", cls);
        return new ParameterizedTypeImpl(type, cls, typeArr);
    }

    static ParameterizedType m4418a(Class<?> cls, Type... typeArr) {
        return new ParameterizedTypeImpl(ClassOwnership.f2544c.m4404a(cls), cls, typeArr);
    }

    static <D extends GenericDeclaration> TypeVariable<D> m4421a(D d, String str, Type... typeArr) {
        if (typeArr.length == 0) {
            typeArr = new Type[]{Object.class};
        }
        return new C1903a(d, str, typeArr);
    }

    static WildcardType m4426b(Type type) {
        return new WildcardTypeImpl(new Type[0], new Type[]{type});
    }

    static WildcardType m4429c(Type type) {
        return new WildcardTypeImpl(new Type[]{type}, new Type[]{Object.class});
    }

    static String m4430d(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    private static Type[] m4428b(Collection<Type> collection) {
        return (Type[]) collection.toArray(new Type[collection.size()]);
    }

    private static Iterable<Type> m4425b(Iterable<Type> iterable) {
        return C1859n.m4279a((Iterable) iterable, Predicates.m3001a(Predicates.m3002a((Object) Object.class)));
    }

    private static void m4427b(Type[] typeArr, String str) {
        for (Type type : typeArr) {
            if (type instanceof Class) {
                boolean z;
                if (((Class) type).isPrimitive()) {
                    z = false;
                } else {
                    z = true;
                }
                C1650g.m3087a(z, "Primitive type '%s' used as %s", (Class) type, str);
            }
        }
    }

    static Class<?> m4416a(Class<?> cls) {
        return Array.newInstance(cls, 0).getClass();
    }
}

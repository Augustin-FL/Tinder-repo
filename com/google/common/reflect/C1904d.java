package com.google.common.reflect;

import com.google.common.base.C1640d;
import com.google.common.base.C1650g;
import com.google.common.collect.C1876q;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.C1762a;
import com.google.common.collect.Sets;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.common.reflect.d */
class C1904d {
    private final ImmutableMap<TypeVariable<?>, Type> f2561a;

    /* renamed from: com.google.common.reflect.d.1 */
    class C19051 extends C1904d {
        final /* synthetic */ TypeVariable f2562a;
        final /* synthetic */ C1904d f2563b;
        final /* synthetic */ C1904d f2564c;

        C19051(C1904d c1904d, ImmutableMap immutableMap, TypeVariable typeVariable, C1904d c1904d2) {
            this.f2564c = c1904d;
            this.f2562a = typeVariable;
            this.f2563b = c1904d2;
            super(null);
        }

        Type m4439a(TypeVariable<?> typeVariable, C1904d c1904d) {
            return typeVariable.getGenericDeclaration().equals(this.f2562a.getGenericDeclaration()) ? typeVariable : this.f2563b.m4437a(typeVariable, c1904d);
        }
    }

    /* renamed from: com.google.common.reflect.d.a */
    private static final class C1906a {
        private static final C1907b f2565a;
        private final Map<TypeVariable<?>, Type> f2566b;
        private final Set<Type> f2567c;

        private C1906a() {
            this.f2566b = C1876q.m4328a();
            this.f2567c = Sets.m4227a();
        }

        static {
            f2565a = new C1907b();
        }

        static ImmutableMap<TypeVariable<?>, Type> m4440a(Type type) {
            C1906a c1906a = new C1906a();
            c1906a.m4444b(f2565a.m4447a(type));
            return ImmutableMap.m3626a(c1906a.f2566b);
        }

        private void m4444b(Type type) {
            int i = 0;
            if (!this.f2567c.add(type)) {
                return;
            }
            if (type instanceof ParameterizedType) {
                m4442a((ParameterizedType) type);
            } else if (type instanceof Class) {
                m4441a((Class) type);
            } else if (type instanceof TypeVariable) {
                r1 = ((TypeVariable) type).getBounds();
                r2 = r1.length;
                while (i < r2) {
                    m4444b(r1[i]);
                    i++;
                }
            } else if (type instanceof WildcardType) {
                r1 = ((WildcardType) type).getUpperBounds();
                r2 = r1.length;
                while (i < r2) {
                    m4444b(r1[i]);
                    i++;
                }
            }
        }

        private void m4441a(Class<?> cls) {
            m4444b(cls.getGenericSuperclass());
            for (Type b : cls.getGenericInterfaces()) {
                m4444b(b);
            }
        }

        private void m4442a(ParameterizedType parameterizedType) {
            boolean z;
            int i = 0;
            Class cls = (Class) parameterizedType.getRawType();
            TypeVariable[] typeParameters = cls.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            if (typeParameters.length == actualTypeArguments.length) {
                z = true;
            } else {
                z = false;
            }
            C1650g.m3091b(z);
            while (i < typeParameters.length) {
                m4443a(typeParameters[i], actualTypeArguments[i]);
                i++;
            }
            m4441a(cls);
            m4444b(parameterizedType.getOwnerType());
        }

        private void m4443a(TypeVariable<?> typeVariable, Type type) {
            if (!this.f2566b.containsKey(typeVariable)) {
                Object obj = type;
                while (obj != null) {
                    if (typeVariable.equals(obj)) {
                        while (type != null) {
                            type = (Type) this.f2566b.remove(type);
                        }
                        return;
                    }
                    Type type2 = (Type) this.f2566b.get(obj);
                }
                this.f2566b.put(typeVariable, type);
            }
        }
    }

    /* renamed from: com.google.common.reflect.d.b */
    private static final class C1907b {
        private final AtomicInteger f2568a;

        private C1907b() {
            this.f2568a = new AtomicInteger();
        }

        Type m4447a(Type type) {
            C1650g.m3080a((Object) type);
            if ((type instanceof Class) || (type instanceof TypeVariable)) {
                return type;
            }
            if (type instanceof GenericArrayType) {
                return Types.m4420a(m4447a(((GenericArrayType) type).getGenericComponentType()));
            }
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                return Types.m4419a(m4446b(parameterizedType.getOwnerType()), (Class) parameterizedType.getRawType(), m4445a(parameterizedType.getActualTypeArguments()));
            } else if (type instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                if (wildcardType.getLowerBounds().length != 0) {
                    return type;
                }
                return Types.m4421a((GenericDeclaration) C1907b.class, "capture#" + this.f2568a.incrementAndGet() + "-of ? extends " + C1640d.m3042a('&').m3051a(wildcardType.getUpperBounds()), wildcardType.getUpperBounds());
            } else {
                throw new AssertionError("must have been one of the known types");
            }
        }

        private Type m4446b(Type type) {
            if (type == null) {
                return null;
            }
            return m4447a(type);
        }

        private Type[] m4445a(Type[] typeArr) {
            Type[] typeArr2 = new Type[typeArr.length];
            for (int i = 0; i < typeArr.length; i++) {
                typeArr2[i] = m4447a(typeArr[i]);
            }
            return typeArr2;
        }
    }

    public C1904d() {
        this.f2561a = ImmutableMap.m3629i();
    }

    private C1904d(ImmutableMap<TypeVariable<?>, Type> immutableMap) {
        this.f2561a = immutableMap;
    }

    static C1904d m4431a(Type type) {
        return new C1904d().m4436a(C1906a.m4440a(type));
    }

    final C1904d m4436a(Map<? extends TypeVariable<?>, ? extends Type> map) {
        C1762a j = ImmutableMap.m3630j();
        j.m3766b(this.f2561a);
        for (Entry entry : map.entrySet()) {
            boolean z;
            TypeVariable typeVariable = (TypeVariable) entry.getKey();
            Type type = (Type) entry.getValue();
            if (typeVariable.equals(type)) {
                z = false;
            } else {
                z = true;
            }
            C1650g.m3087a(z, "Type variable %s bound to itself", typeVariable);
            j.m3765b(typeVariable, type);
        }
        return new C1904d(j.m3767b());
    }

    public final Type m4438b(Type type) {
        C1650g.m3080a((Object) type);
        if (type instanceof TypeVariable) {
            return m4434a((TypeVariable) type);
        }
        if (type instanceof ParameterizedType) {
            return m4432a((ParameterizedType) type);
        }
        if (type instanceof GenericArrayType) {
            return m4433a((GenericArrayType) type);
        }
        if (!(type instanceof WildcardType)) {
            return type;
        }
        WildcardType wildcardType = (WildcardType) type;
        return new WildcardTypeImpl(m4435a(wildcardType.getLowerBounds()), m4435a(wildcardType.getUpperBounds()));
    }

    private Type[] m4435a(Type[] typeArr) {
        Type[] typeArr2 = new Type[typeArr.length];
        for (int i = 0; i < typeArr.length; i++) {
            typeArr2[i] = m4438b(typeArr[i]);
        }
        return typeArr2;
    }

    private Type m4433a(GenericArrayType genericArrayType) {
        return Types.m4420a(m4438b(genericArrayType.getGenericComponentType()));
    }

    private Type m4434a(TypeVariable<?> typeVariable) {
        return m4437a(typeVariable, new C19051(this, this.f2561a, typeVariable, this));
    }

    Type m4437a(TypeVariable<?> typeVariable, C1904d c1904d) {
        C1650g.m3080a((Object) c1904d);
        Type type = (Type) this.f2561a.get(typeVariable);
        if (type != null) {
            return c1904d.m4438b(type);
        }
        Type[] bounds = typeVariable.getBounds();
        if (bounds.length == 0) {
            return typeVariable;
        }
        return Types.m4421a(typeVariable.getGenericDeclaration(), typeVariable.getName(), c1904d.m4435a(bounds));
    }

    private ParameterizedType m4432a(ParameterizedType parameterizedType) {
        Type ownerType = parameterizedType.getOwnerType();
        Type b = ownerType == null ? null : m4438b(ownerType);
        ownerType = m4438b(parameterizedType.getRawType());
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Type[] typeArr = new Type[actualTypeArguments.length];
        for (int i = 0; i < actualTypeArguments.length; i++) {
            typeArr[i] = m4438b(actualTypeArguments[i]);
        }
        return Types.m4419a(b, (Class) ownerType, typeArr);
    }
}

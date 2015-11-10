package com.google.ads.mediation;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

@Deprecated
public abstract class MediationServerParameters {

    public static final class MappingException extends Exception {
        public MappingException(String str) {
            super(str);
        }
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    /* renamed from: com.google.ads.mediation.MediationServerParameters.a */
    protected @interface C0692a {
        String m953a();

        boolean m954b() default true;
    }

    protected void m955a() {
    }

    public void m956a(Map<String, String> map) throws MappingException {
        Map hashMap = new HashMap();
        for (Field field : getClass().getFields()) {
            C0692a c0692a = (C0692a) field.getAnnotation(C0692a.class);
            if (c0692a != null) {
                hashMap.put(c0692a.m953a(), field);
            }
        }
        if (hashMap.isEmpty()) {
            zzb.zzaE("No server options fields detected. To suppress this message either add a field with the @Parameter annotation, or override the load() method.");
        }
        for (Entry entry : map.entrySet()) {
            Field field2 = (Field) hashMap.remove(entry.getKey());
            if (field2 != null) {
                try {
                    field2.set(this, entry.getValue());
                } catch (IllegalAccessException e) {
                    zzb.zzaE("Server option \"" + ((String) entry.getKey()) + "\" could not be set: Illegal Access");
                } catch (IllegalArgumentException e2) {
                    zzb.zzaE("Server option \"" + ((String) entry.getKey()) + "\" could not be set: Bad Type");
                }
            } else {
                zzb.zzaC("Unexpected server option: " + ((String) entry.getKey()) + " = \"" + ((String) entry.getValue()) + "\"");
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Field field22 : hashMap.values()) {
            if (((C0692a) field22.getAnnotation(C0692a.class)).m954b()) {
                zzb.zzaE("Required server option missing: " + ((C0692a) field22.getAnnotation(C0692a.class)).m953a());
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(((C0692a) field22.getAnnotation(C0692a.class)).m953a());
            }
        }
        if (stringBuilder.length() > 0) {
            throw new MappingException("Required server option(s) missing: " + stringBuilder.toString());
        }
        m955a();
    }
}

package com.google.i18n.phonenumbers;

import java.util.LinkedHashMap;
import java.util.regex.Pattern;

/* renamed from: com.google.i18n.phonenumbers.d */
public class C1985d {
    private C1984a<String, Pattern> f2725a;

    /* renamed from: com.google.i18n.phonenumbers.d.a */
    private static class C1984a<K, V> {
        private LinkedHashMap<K, V> f2723a;
        private int f2724b;

        public C1984a(int i) {
            this.f2724b = i;
            this.f2723a = new RegexCache$LRUCache$1(this, ((i * 4) / 3) + 1, 0.75f, true);
        }

        public synchronized V m4579a(K k) {
            return this.f2723a.get(k);
        }

        public synchronized void m4580a(K k, V v) {
            this.f2723a.put(k, v);
        }
    }

    public C1985d(int i) {
        this.f2725a = new C1984a(i);
    }

    public Pattern m4581a(String str) {
        Pattern pattern = (Pattern) this.f2725a.m4579a((Object) str);
        if (pattern != null) {
            return pattern;
        }
        pattern = Pattern.compile(str);
        this.f2725a.m4580a(str, pattern);
        return pattern;
    }
}

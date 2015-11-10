package com.google.i18n.phonenumbers;

import com.google.i18n.phonenumbers.C1985d.C1984a;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

class RegexCache$LRUCache$1 extends LinkedHashMap<K, V> {
    final /* synthetic */ C1984a f2659a;

    RegexCache$LRUCache$1(C1984a c1984a, int i, float f, boolean z) {
        this.a = c1984a;
        super(i, f, z);
    }

    protected boolean removeEldestEntry(Entry<K, V> entry) {
        return size() > this.a.f2724b;
    }
}

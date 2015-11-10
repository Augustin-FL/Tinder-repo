package com.tinder.drawing;

import java.util.LinkedList;

public class DrawRecord extends LinkedList<C2550c> {
    public /* synthetic */ Object getFirst() {
        return m7008a();
    }

    public /* synthetic */ Object getLast() {
        return m7010b();
    }

    public void m7009a(C2550c c2550c) {
        super.add(c2550c);
    }

    public C2550c m7008a() {
        return (C2550c) super.getFirst();
    }

    public C2550c m7010b() {
        return (C2550c) super.getLast();
    }
}

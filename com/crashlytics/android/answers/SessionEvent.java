package com.crashlytics.android.answers;

import android.app.Activity;
import java.util.Collections;
import java.util.Map;

final class SessionEvent {
    public final C0393r f401a;
    public final long f402b;
    public final Type f403c;
    public final Map<String, String> f404d;
    public final String f405e;
    public final Map<String, Object> f406f;
    public final String f407g;
    public final Map<String, Object> f408h;
    private String f409i;

    enum Type {
        CREATE,
        START,
        RESUME,
        SAVE_INSTANCE_STATE,
        PAUSE,
        STOP,
        DESTROY,
        ERROR,
        CRASH,
        INSTALL,
        CUSTOM,
        PREDEFINED
    }

    /* renamed from: com.crashlytics.android.answers.SessionEvent.a */
    static class C0361a {
        final Type f394a;
        final long f395b;
        Map<String, String> f396c;
        String f397d;
        Map<String, Object> f398e;
        String f399f;
        Map<String, Object> f400g;

        public C0361a(Type type) {
            this.f394a = type;
            this.f395b = System.currentTimeMillis();
            this.f396c = Collections.emptyMap();
            this.f397d = null;
            this.f398e = Collections.emptyMap();
            this.f399f = null;
            this.f400g = Collections.emptyMap();
        }

        public C0361a m457a(Map<String, String> map) {
            this.f396c = map;
            return this;
        }

        public SessionEvent m458a(C0393r c0393r) {
            return new SessionEvent(this.f395b, this.f394a, this.f396c, this.f397d, this.f398e, this.f399f, this.f400g, null);
        }
    }

    public static C0361a m460a(Type type, Activity activity) {
        return new C0361a(type).m457a(Collections.singletonMap("activity", activity.getClass().getName()));
    }

    public static C0361a m459a() {
        return new C0361a(Type.INSTALL);
    }

    public static C0361a m461a(String str) {
        return new C0361a(Type.ERROR).m457a(Collections.singletonMap("sessionId", str));
    }

    public static C0361a m462b(String str) {
        return new C0361a(Type.CRASH).m457a(Collections.singletonMap("sessionId", str));
    }

    private SessionEvent(C0393r c0393r, long j, Type type, Map<String, String> map, String str, Map<String, Object> map2, String str2, Map<String, Object> map3) {
        this.f401a = c0393r;
        this.f402b = j;
        this.f403c = type;
        this.f404d = map;
        this.f405e = str;
        this.f406f = map2;
        this.f407g = str2;
        this.f408h = map3;
    }

    public String toString() {
        if (this.f409i == null) {
            this.f409i = "[" + getClass().getSimpleName() + ": " + "timestamp=" + this.f402b + ", type=" + this.f403c + ", details=" + this.f404d.toString() + ", customType=" + this.f405e + ", customAttributes=" + this.f406f.toString() + ", predefinedType=" + this.f407g + ", predefinedAttributes=" + this.f408h.toString() + ", metadata=[" + this.f401a + "]]";
        }
        return this.f409i;
    }
}

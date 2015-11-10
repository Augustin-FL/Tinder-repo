package com.crashlytics.android.answers;

import java.util.HashSet;

class SamplingEventFilter$1 extends HashSet<Type> {
    SamplingEventFilter$1() {
        add(Type.CREATE);
        add(Type.START);
        add(Type.RESUME);
        add(Type.SAVE_INSTANCE_STATE);
        add(Type.PAUSE);
        add(Type.STOP);
        add(Type.DESTROY);
        add(Type.ERROR);
    }
}

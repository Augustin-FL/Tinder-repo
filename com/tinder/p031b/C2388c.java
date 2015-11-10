package com.tinder.p031b;

import android.support.annotation.NonNull;
import com.tinder.utils.C3095y;

/* renamed from: com.tinder.b.c */
public class C2388c {
    protected String f4276a;
    protected C2387a[] f4277b;

    @NonNull
    public String m6497a() {
        C3095y.m9471a("mTableName=" + this.f4276a);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CREATE TABLE IF NOT EXISTS ");
        stringBuffer.append(this.f4276a);
        stringBuffer.append('(');
        for (int i = 0; i < this.f4277b.length; i++) {
            C2387a c2387a = this.f4277b[i];
            stringBuffer.append(c2387a.m6494a());
            stringBuffer.append(' ');
            stringBuffer.append(c2387a.m6495b());
            if (c2387a.m6496c()) {
                stringBuffer.append(" PRIMARY KEY");
            }
            if (i < this.f4277b.length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

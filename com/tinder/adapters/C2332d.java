package com.tinder.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tinder.R;

/* renamed from: com.tinder.adapters.d */
public class C2332d extends BaseAdapter {
    private final String[] f4078a;
    private final String[] f4079b;
    @NonNull
    private final LayoutInflater f4080c;

    /* renamed from: com.tinder.adapters.d.a */
    static class C2331a {
        TextView f4076a;
        TextView f4077b;

        C2331a() {
        }
    }

    public /* synthetic */ Object getItem(int i) {
        return m6374a(i);
    }

    public C2332d(@NonNull Context context) {
        this.f4078a = context.getResources().getStringArray(R.array.country_names);
        this.f4079b = context.getResources().getStringArray(R.array.country_codes);
        this.f4080c = LayoutInflater.from(context);
    }

    public int getCount() {
        return this.f4079b.length;
    }

    public String m6374a(int i) {
        return this.f4078a[i];
    }

    public long getItemId(int i) {
        return (long) i;
    }

    @Nullable
    public View getView(int i, @Nullable View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f4080c.inflate(R.layout.row_view_country, null);
            C2331a c2331a = new C2331a();
            c2331a.f4076a = (TextView) view.findViewById(R.id.textView_country);
            c2331a.f4077b = (TextView) view.findViewById(R.id.textView_code);
            view.setTag(c2331a);
        }
        C2331a c2331a2 = (C2331a) view.getTag();
        c2331a2.f4076a.setText(this.f4078a[i]);
        c2331a2.f4077b.setText('+' + this.f4079b[i]);
        return view;
    }

    public String m6375b(int i) {
        return this.f4079b[i];
    }
}

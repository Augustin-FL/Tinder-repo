package com.tinder.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tinder.fragments.C2668m;
import com.tinder.model.Match;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tinder.adapters.y */
public class C2386y extends BaseAdapter {
    private final Context f4270a;
    private final C2668m f4271b;
    @NonNull
    private List<Match> f4272c;

    public C2386y(Context context, C2668m c2668m) {
        this.f4272c = new ArrayList();
        this.f4270a = context;
        this.f4271b = c2668m;
    }

    public void m6493a(@NonNull List<Match> list) {
        this.f4272c = list;
    }

    public int getCount() {
        return this.f4272c.size();
    }

    @Nullable
    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }

    @Nullable
    public View getView(int i, View view, ViewGroup viewGroup) {
        return C2341g.m6384a(this.f4270a, (Match) this.f4272c.get(i), view, viewGroup, this.f4271b);
    }
}

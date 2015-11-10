package com.tinder.adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.m4b.maps.c.b;
import com.google.android.m4b.maps.model.o;
import com.tinder.R;
import com.tinder.model.TinderLocation;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tinder.adapters.f */
public class C2336f implements b {
    private Context f4085a;
    private Map<o, TinderLocation> f4086b;

    public C2336f(Context context) {
        this.f4085a = context;
        this.f4086b = new HashMap();
    }

    public View m6378a(o oVar) {
        View inflate = View.inflate(this.f4085a, R.layout.view_map_info_window, null);
        TextView textView = (TextView) inflate.findViewById(R.id.map_info_window_text_first);
        TextView textView2 = (TextView) inflate.findViewById(R.id.map_info_window_text_second);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.map_info_chevron);
        TinderLocation tinderLocation = (TinderLocation) this.f4086b.get(oVar);
        if (tinderLocation != null) {
            Pair labels = tinderLocation.getLabels();
            String str = (String) labels.first;
            String str2 = (String) labels.second;
            if (TextUtils.isEmpty(str)) {
                textView.setText(R.string.no_location_found);
                textView2.setVisibility(8);
                imageView.setVisibility(8);
            } else {
                String string = this.f4085a.getResources().getString(R.string.go_to_location, new Object[]{str});
                CharSequence spannableString = new SpannableString(string);
                spannableString.setSpan(new StyleSpan(1), string.indexOf(str), string.length(), 0);
                textView.setText(spannableString);
                if (TextUtils.isEmpty(str2)) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setText(str2);
                }
                imageView.setVisibility(0);
            }
        } else {
            CharSequence spannableString2 = new SpannableString(this.f4085a.getString(R.string.searching));
            spannableString2.setSpan(new StyleSpan(1), 0, spannableString2.length(), 0);
            textView.setText(spannableString2);
            textView2.setVisibility(8);
            imageView.setVisibility(8);
        }
        return inflate;
    }

    @Nullable
    public View m6381b(o oVar) {
        return null;
    }

    public void m6380a(@Nullable o oVar, TinderLocation tinderLocation) {
        if (oVar != null) {
            this.f4086b.put(oVar, tinderLocation);
        }
    }

    public TinderLocation m6382c(o oVar) {
        return (TinderLocation) this.f4086b.get(oVar);
    }

    public boolean m6383d(o oVar) {
        return this.f4086b.remove(oVar) != null;
    }

    public void m6379a() {
        this.f4086b.clear();
    }
}

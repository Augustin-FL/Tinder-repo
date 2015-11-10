package com.tinder.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tinder.R;
import com.tinder.utils.C3095y;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.tinder.fragments.i */
public class C2629i extends Fragment {
    protected TextView f5003a;
    protected ImageView f5004b;
    private int f5005c;

    public C2629i() {
        C3095y.m9469a();
    }

    @NonNull
    public static C2629i m7270a(int i) {
        C3095y.m9471a("pageNumber=" + i);
        C2629i c2629i = new C2629i();
        Bundle bundle = new Bundle();
        bundle.putInt("page", i);
        c2629i.setArguments(bundle);
        return c2629i;
    }

    public void m7271a(int i, int i2) {
        this.f5003a.setText(i);
        try {
            this.f5004b.setImageResource(i2);
        } catch (OutOfMemoryError e) {
            C3095y.m9479c("out of memory :(");
        }
    }

    public void onCreate(Bundle bundle) {
        C3095y.m9469a();
        super.onCreate(bundle);
        this.f5005c = getArguments().getInt("page");
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C3095y.m9469a();
        View inflate = layoutInflater.inflate(R.layout.view_intro_fragment, viewGroup, false);
        this.f5003a = (TextView) inflate.findViewById(R.id.textView_text);
        this.f5004b = (ImageView) inflate.findViewById(R.id.imageView_image);
        switch (this.f5005c) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                m7271a(R.string.intro1, R.drawable.intro_screen1);
                break;
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                m7271a(R.string.intro2, R.drawable.intro_screen2);
                break;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                m7271a(R.string.intro3, R.drawable.intro_screen3);
                break;
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                m7271a(R.string.intro4, R.drawable.intro_screen4);
                break;
            default:
                C3095y.m9471a("Page not recognized");
                m7271a(R.string.intro1, R.drawable.intro_screen1);
                break;
        }
        return inflate;
    }
}

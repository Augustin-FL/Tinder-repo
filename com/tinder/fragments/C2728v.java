package com.tinder.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tinder.R;
import com.tinder.activities.ActivityVerification;
import com.tinder.adapters.C2332d;
import com.tinder.p030d.af;
import com.tinder.utils.C3095y;

/* renamed from: com.tinder.fragments.v */
public class C2728v extends Fragment implements OnClickListener, af {
    private ListView f5389a;
    private C2332d f5390b;

    /* renamed from: com.tinder.fragments.v.1 */
    class C27271 implements OnItemClickListener {
        final /* synthetic */ C2728v f5388a;

        C27271(C2728v c2728v) {
            this.f5388a = c2728v;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            C3095y.m9471a("position=" + i);
            String a = this.f5388a.f5390b.m6374a(i);
            String b = this.f5388a.f5390b.m6375b(i);
            C3095y.m9471a("countryName=" + a + ", countryCode=" + b);
            ((ActivityVerification) this.f5388a.getActivity()).m6278a(a, b);
        }
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.view_verification_country_selection, null);
        this.f5389a = (ListView) inflate.findViewById(R.id.listView_countries);
        return inflate;
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        m7718a();
    }

    public void m7718a() {
        C3095y.m9469a();
        this.f5390b = new C2332d(getActivity());
        this.f5389a.setAdapter(this.f5390b);
        this.f5389a.setOnItemClickListener(new C27271(this));
        ((ActivityVerification) getActivity()).ab().setMenu(this);
    }

    public void onMenuItemClick(int i) {
        C3095y.m9471a("resId=" + i);
        getActivity().onBackPressed();
    }

    public void onClick(View view) {
        C3095y.m9471a("view=" + view);
        getActivity().onBackPressed();
    }
}

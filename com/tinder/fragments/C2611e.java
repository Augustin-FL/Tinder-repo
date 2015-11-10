package com.tinder.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tinder.R;
import com.tinder.managers.C2807a;
import com.tinder.managers.ManagerApp;
import com.tinder.model.SparksEvent;
import com.tinder.p030d.bq;
import com.tinder.utils.al;

/* renamed from: com.tinder.fragments.e */
public class C2611e extends Fragment implements OnClickListener, bq {
    View f4901a;

    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.view_discover_off, null);
        this.f4901a = inflate.findViewById(R.id.view_turn_on_discover_mode);
        m7192a();
        return inflate;
    }

    public void m7192a() {
        al.m9287b(this.f4901a);
        this.f4901a.setOnClickListener(this);
    }

    public void m7190E() {
        SparksEvent sparksEvent = new SparksEvent("Recs.Discovery");
        sparksEvent.put("discoveryOn", Boolean.valueOf(true));
        C2807a.m8056a(sparksEvent);
        ((bq) getActivity()).m6136E();
    }

    public void m7191F() {
        try {
            ((bq) getActivity()).m6137F();
        } catch (NullPointerException e) {
        }
    }

    public void onClick(@NonNull View view) {
        switch (view.getId()) {
            case R.id.view_turn_on_discover_mode:
                ManagerApp.m7922m().m8594a(true, (bq) this);
            default:
        }
    }
}

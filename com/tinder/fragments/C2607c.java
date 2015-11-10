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
import android.widget.ProgressBar;
import android.widget.TextView;
import com.android.volley.C0294c;
import com.android.volley.C0307i.C0305a;
import com.android.volley.C0307i.C0306b;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.C0337j;
import com.crashlytics.android.C0359a;
import com.google.android.gms.search.SearchAuth.StatusCodes;
import com.tinder.R;
import com.tinder.activities.ActivityAddPhoto;
import com.tinder.adapters.C2329b;
import com.tinder.base.ActivitySignedInBase;
import com.tinder.managers.C2828c;
import com.tinder.managers.ManagerApp;
import com.tinder.model.FacebookAlbum;
import com.tinder.p030d.af;
import com.tinder.parse.C2972a;
import com.tinder.utils.C3095y;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tinder.fragments.c */
public class C2607c extends Fragment implements OnClickListener, af {
    private ProgressBar f4869a;
    private ListView f4870b;
    private TextView f4871c;
    private C2329b f4872d;
    private String f4873e;
    @Nullable
    private String f4874f;

    /* renamed from: com.tinder.fragments.c.1 */
    class C26041 implements C0306b<JSONObject> {
        final /* synthetic */ C2607c f4866a;

        C26041(C2607c c2607c) {
            this.f4866a = c2607c;
        }

        public void m7162a(@NonNull JSONObject jSONObject) {
            this.f4866a.m7165a(jSONObject);
        }
    }

    /* renamed from: com.tinder.fragments.c.2 */
    class C26052 implements C0305a {
        final /* synthetic */ C2607c f4867a;

        C26052(C2607c c2607c) {
            this.f4867a = c2607c;
        }

        public void onErrorResponse(@Nullable VolleyError volleyError) {
            if (!(volleyError == null || volleyError.getMessage() == null)) {
                C0359a.m446a(volleyError.toString());
                C3095y.m9479c(volleyError.getMessage());
            }
            this.f4867a.f4869a.setVisibility(8);
            this.f4867a.f4871c.setVisibility(0);
        }
    }

    /* renamed from: com.tinder.fragments.c.3 */
    class C26063 implements OnItemClickListener {
        final /* synthetic */ C2607c f4868a;

        C26063(C2607c c2607c) {
            this.f4868a = c2607c;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ((ActivityAddPhoto) this.f4868a.getActivity()).m5933a(this.f4868a.f4872d.m6365a(i).getId(), this.f4868a.f4872d.m6365a(i).getName());
        }
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C3095y.m9469a();
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.view_albums, null);
        this.f4869a = (ProgressBar) inflate.findViewById(R.id.progress);
        this.f4871c = (TextView) inflate.findViewById(R.id.txt_no_albums);
        this.f4870b = (ListView) inflate.findViewById(R.id.listview_albums);
        if (this.f4872d == null) {
            this.f4872d = new C2329b(getActivity());
        }
        this.f4870b.setAdapter(this.f4872d);
        if (!this.f4872d.isEmpty()) {
            this.f4869a.setVisibility(8);
        }
        ManagerApp.m7912c();
        this.f4874f = C2828c.m8162c();
        this.f4873e = C2828c.m8163c(this.f4874f);
        ((ActivitySignedInBase) getActivity()).ab().setMenu(this);
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m7169a();
    }

    public void onResume() {
        super.onResume();
        ((ActivitySignedInBase) getActivity()).ab().setMenu(this);
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public void m7169a() {
        this.f4871c.setVisibility(8);
        Request c0337j = new C0337j(this.f4873e, null, new C26041(this), new C26052(this));
        c0337j.m219a(new C0294c(StatusCodes.AUTH_DISABLED, 1, 1.0f));
        ManagerApp.m7915f().m5900a(c0337j);
    }

    private void m7165a(@NonNull JSONObject jSONObject) {
        int i = 0;
        FacebookAlbum facebookAlbum = null;
        List arrayList = new ArrayList();
        try {
            arrayList.addAll(C2972a.m8909a(jSONObject, this.f4874f));
            FacebookAlbum a = C2972a.m8908a(jSONObject);
            this.f4872d.m6367a(arrayList);
            if (a.getId() != null) {
                this.f4872d.m6366a(a, 0);
            }
            this.f4869a.setVisibility(8);
            if (this.f4872d.getCount() != 0) {
                i = 8;
            }
            this.f4871c.setVisibility(i);
            m7167b();
        } catch (JSONException e) {
            C3095y.m9479c(e.getMessage());
            this.f4872d.m6367a(arrayList);
            if (facebookAlbum.getId() != null) {
                this.f4872d.m6366a(facebookAlbum, 0);
            }
            this.f4869a.setVisibility(8);
            if (this.f4872d.getCount() != 0) {
                i = 8;
            }
            this.f4871c.setVisibility(i);
            m7167b();
        } catch (Throwable th) {
            this.f4872d.m6367a(arrayList);
            if (facebookAlbum.getId() != null) {
                this.f4872d.m6366a(facebookAlbum, 0);
            }
            this.f4869a.setVisibility(8);
            if (this.f4872d.getCount() != 0) {
                i = 8;
            }
            this.f4871c.setVisibility(i);
            m7167b();
        }
    }

    private void m7167b() {
        this.f4870b.setOnItemClickListener(new C26063(this));
    }

    public void onMenuItemClick(int i) {
        switch (i) {
            case R.drawable.selector_actionbar_back:
                getActivity().onBackPressed();
            default:
        }
    }

    public void onClick(View view) {
        getActivity().onBackPressed();
    }
}

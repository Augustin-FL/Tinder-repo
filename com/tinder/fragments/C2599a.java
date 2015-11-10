package com.tinder.fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.C0294c;
import com.android.volley.C0307i.C0305a;
import com.android.volley.C0307i.C0306b;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.C0337j;
import com.crashlytics.android.C0359a;
import com.facebook.share.internal.ShareConstants;
import com.facebook.stetho.BuildConfig;
import com.google.android.gms.search.SearchAuth.StatusCodes;
import com.tinder.R;
import com.tinder.adapters.C2327a;
import com.tinder.base.ActivitySignedInBase;
import com.tinder.dialogs.C2515r;
import com.tinder.managers.C2828c;
import com.tinder.managers.ManagerApp;
import com.tinder.p030d.af;
import com.tinder.parse.C2972a;
import com.tinder.picassowebp.picasso.C2281x;
import com.tinder.picassowebp.picasso.Picasso;
import com.tinder.picassowebp.picasso.Picasso.LoadedFrom;
import com.tinder.utils.C3064c;
import com.tinder.utils.C3064c.C2316c;
import com.tinder.utils.C3064c.C2318a;
import com.tinder.utils.C3095y;
import com.tinder.utils.al;
import eu.janmuller.android.simplecropimage.CropImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tinder.fragments.a */
public class C2599a extends Fragment implements OnClickListener, af, C2281x {
    private View f4836a;
    private GridView f4837b;
    private ProgressBar f4838c;
    private TextView f4839d;
    private C2327a f4840e;
    private boolean f4841f;
    private C2515r f4842g;
    @Nullable
    private String f4843h;
    @Nullable
    private String f4844i;
    @Nullable
    private String f4845j;

    /* renamed from: com.tinder.fragments.a.1 */
    class C25941 implements C0306b<JSONObject> {
        final /* synthetic */ String f4828a;
        final /* synthetic */ C2599a f4829b;

        C25941(C2599a c2599a, String str) {
            this.f4829b = c2599a;
            this.f4828a = str;
        }

        public void m7128a(@NonNull JSONObject jSONObject) {
            this.f4829b.m7139a(jSONObject);
            if (jSONObject.has("paging")) {
                try {
                    this.f4829b.m7137a(this.f4828a, jSONObject.getJSONObject("paging").getString("next"));
                } catch (JSONException e) {
                    C3095y.m9479c(e.toString());
                }
            }
        }
    }

    /* renamed from: com.tinder.fragments.a.2 */
    class C25952 implements C0305a {
        final /* synthetic */ String f4830a;
        final /* synthetic */ C2599a f4831b;

        C25952(C2599a c2599a, String str) {
            this.f4831b = c2599a;
            this.f4830a = str;
        }

        public void onErrorResponse(VolleyError volleyError) {
            C3095y.m9470a(volleyError, this.f4830a);
            this.f4831b.m7133a();
        }
    }

    /* renamed from: com.tinder.fragments.a.3 */
    class C25963 implements OnItemClickListener {
        final /* synthetic */ C2599a f4832a;

        C25963(C2599a c2599a) {
            this.f4832a = c2599a;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.f4832a.f4842g.show();
            this.f4832a.f4843h = this.f4832a.f4840e.m6364b(i);
            this.f4832a.f4844i = this.f4832a.f4840e.m6362a(i);
            this.f4832a.m7145a(this.f4832a.f4840e.m6362a(i));
        }
    }

    /* renamed from: com.tinder.fragments.a.4 */
    class C25974 implements C2316c {
        final /* synthetic */ C2599a f4833a;

        C25974(C2599a c2599a) {
            this.f4833a = c2599a;
        }

        public void m7129a(Object obj) {
            String str = (String) obj;
            Intent intent = new Intent(this.f4833a.getActivity(), CropImage.class);
            intent.putExtra("image-path", str);
            intent.putExtra("scale", true);
            intent.putExtra("save res id", R.string.save_button);
            intent.putExtra("cancel res id", R.string.cancel_button);
            intent.putExtra("aspectX", 3);
            intent.putExtra("aspectY", 2);
            al.m9297c(this.f4833a.f4842g);
            this.f4833a.startActivityForResult(intent, 0);
        }
    }

    /* renamed from: com.tinder.fragments.a.5 */
    class C25985 implements C2318a {
        final /* synthetic */ Bitmap f4834a;
        final /* synthetic */ C2599a f4835b;

        C25985(C2599a c2599a, Bitmap bitmap) {
            this.f4835b = c2599a;
            this.f4834a = bitmap;
        }

        @NonNull
        public Object m7130a() {
            return C2599a.m7131a(this.f4834a);
        }
    }

    public static String m7131a(@NonNull Bitmap bitmap) {
        try {
            File file = new File(ManagerApp.m7917h().getCacheDir(), "uncropped.png");
            OutputStream fileOutputStream = new FileOutputStream(file);
            C3095y.m9471a("Out" + Boolean.toString(fileOutputStream != null) + " file: " + file.toString());
            bitmap.compress(CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return file.getPath();
        } catch (Exception e) {
            C3095y.m9479c(e.getMessage());
            C0359a.m446a(e.toString());
            return BuildConfig.FLAVOR;
        }
    }

    private void m7133a() {
        if (getActivity() != null) {
            this.f4839d.setVisibility(0);
            this.f4838c.setVisibility(8);
        }
    }

    private void m7137a(@NonNull String str, String str2) {
        this.f4839d.setVisibility(8);
        if (str.length() > 0) {
            String b = TextUtils.isEmpty(str2) ? str.equals("tagged") ? C2828c.m8158b(this.f4845j) : C2828c.m8152a(str, this.f4845j) : str2;
            Request c0337j = new C0337j(b, null, new C25941(this, str), new C25952(this, b));
            c0337j.m219a(new C0294c(StatusCodes.AUTH_DISABLED, 1, 1.0f));
            ManagerApp.m7915f().m5900a(c0337j);
            return;
        }
        m7133a();
    }

    private void m7139a(@NonNull JSONObject jSONObject) {
        int i = 0;
        if (!this.f4841f) {
            List arrayList = new ArrayList();
            try {
                arrayList.addAll(C2972a.m8910b(jSONObject));
                this.f4840e.m6363a(arrayList);
                this.f4838c.setVisibility(8);
                this.f4836a.setVisibility(0);
                if (this.f4840e.getCount() != 0) {
                    i = 8;
                }
                this.f4839d.setVisibility(i);
                this.f4837b.setClickable(true);
                m7142b();
            } catch (JSONException e) {
                C3095y.m9479c(e.getMessage());
                this.f4840e.m6363a(arrayList);
                this.f4838c.setVisibility(8);
                this.f4836a.setVisibility(0);
                if (this.f4840e.getCount() != 0) {
                    i = 8;
                }
                this.f4839d.setVisibility(i);
                this.f4837b.setClickable(true);
                m7142b();
            } catch (Throwable th) {
                this.f4840e.m6363a(arrayList);
                this.f4838c.setVisibility(8);
                this.f4836a.setVisibility(0);
                if (this.f4840e.getCount() != 0) {
                    i = 8;
                }
                this.f4839d.setVisibility(i);
                this.f4837b.setClickable(true);
                m7142b();
            }
        }
    }

    private void m7142b() {
        this.f4837b.setOnItemClickListener(new C25963(this));
    }

    public void m7145a(String str) {
        Picasso.m8982a(getActivity()).m8990a(str).m9126a((C2281x) this);
    }

    private void m7138a(String str, String str2, float f, float f2, float f3, float f4) {
        C3095y.m9471a("id=" + str);
        Intent intent = new Intent();
        intent.putExtra(ShareConstants.WEB_DIALOG_PARAM_ID, str);
        intent.putExtra(ShareConstants.FEED_SOURCE_PARAM, str2);
        intent.putExtra("xdistance_percent", f);
        intent.putExtra("ydistance_percent", f2);
        intent.putExtra("xoffset_percent", f3);
        intent.putExtra("yoffset_percent", f4);
        getActivity().setResult(-1, intent);
        getActivity().finish();
    }

    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        C3095y.m9471a("requestCode=" + i + ", resultCode=" + i2 + ", data=" + intent);
        if (i2 == 0 || intent == null) {
            C3095y.m9471a("Cancelled or null data, returning ...");
            return;
        }
        Bundle extras = intent.getExtras();
        float f = extras.getFloat("rect_crop_x");
        float f2 = extras.getFloat("rect_crop_y");
        float f3 = extras.getFloat("rect_crop_width");
        float f4 = extras.getFloat("rect_crop_height");
        float f5 = extras.getFloat("image_width");
        float f6 = extras.getFloat("image_height");
        f3 /= f5;
        f4 /= f6;
        m7138a(this.f4843h, this.f4844i, f3, f4, f / f5, f2 / f6);
    }

    public void onCreate(@Nullable Bundle bundle) {
        C3095y.m9471a("bundle=" + bundle);
        super.onCreate(bundle);
        if (bundle != null) {
            this.f4843h = bundle.getString(ShareConstants.WEB_DIALOG_PARAM_ID);
            this.f4844i = bundle.getString(ShareConstants.FEED_SOURCE_PARAM);
            C3095y.m9471a("mSelecteId=" + this.f4843h + ", mSelectedSource=" + this.f4844i);
        }
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.view_add_photos, null);
        this.f4840e = new C2327a(getActivity());
        this.f4841f = false;
        return inflate;
    }

    public void onViewCreated(@NonNull View view, Bundle bundle) {
        C3095y.m9471a("savedInstanceState=" + bundle);
        super.onViewCreated(view, bundle);
        this.f4837b = (GridView) view.findViewById(R.id.grid_photos);
        this.f4838c = (ProgressBar) view.findViewById(R.id.progress);
        this.f4839d = (TextView) view.findViewById(R.id.txt_no_pics);
        this.f4836a = view.findViewById(R.id.grid_container);
        this.f4842g = new C2515r(getActivity());
        String string = getArguments().getString(ShareConstants.WEB_DIALOG_PARAM_ID);
        this.f4837b.setAdapter(this.f4840e);
        ManagerApp.m7912c();
        this.f4845j = C2828c.m8162c();
        m7137a(string, null);
    }

    public void onResume() {
        super.onResume();
        ((ActivitySignedInBase) getActivity()).ab().setMenu(this);
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        bundle.putString(ShareConstants.WEB_DIALOG_PARAM_ID, this.f4843h);
        bundle.putString(ShareConstants.FEED_SOURCE_PARAM, this.f4844i);
        super.onSaveInstanceState(bundle);
    }

    public void onDestroyView() {
        this.f4841f = true;
        super.onDestroyView();
    }

    public void onMenuItemClick(int i) {
        switch (i) {
            case R.drawable.selector_actionbar_back:
                getActivity().onBackPressed();
            default:
        }
    }

    public void onBitmapLoaded(@NonNull Bitmap bitmap, LoadedFrom loadedFrom) {
        if (!this.f4841f) {
            C3064c.m9336a(new C25985(this, bitmap)).m9340a(new C25974(this)).m9341a();
        }
    }

    public void onBitmapFailed(Drawable drawable) {
        if (!this.f4841f) {
            al.m9297c(this.f4842g);
            m7144c();
        }
    }

    public void onPrepareLoad(Drawable drawable) {
    }

    private void m7144c() {
        Toast.makeText(getActivity(), R.string.error_fetching_bitmap, 0).show();
    }

    public void onClick(View view) {
        getActivity().onBackPressed();
    }
}

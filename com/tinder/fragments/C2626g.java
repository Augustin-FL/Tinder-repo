package com.tinder.fragments;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.media.TransportMediator;
import android.support.v7.widget.GridLayout;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.BackgroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.tinder.R;
import com.tinder.activities.ActivityAddPhoto;
import com.tinder.dialogs.C2478e;
import com.tinder.dialogs.C2481f;
import com.tinder.dialogs.C2515r;
import com.tinder.dialogs.C2526u;
import com.tinder.dialogs.C2530v;
import com.tinder.dialogs.C2530v.C2529a;
import com.tinder.enums.PhotoSizeUser;
import com.tinder.managers.C2807a;
import com.tinder.managers.C2913k;
import com.tinder.managers.ManagerApp;
import com.tinder.model.PhotoUser;
import com.tinder.model.ProcessedPhoto;
import com.tinder.model.SparksEvent;
import com.tinder.model.User;
import com.tinder.p030d.ax;
import com.tinder.p030d.bq;
import com.tinder.p032c.C2420b;
import com.tinder.p032c.C2421c;
import com.tinder.p033e.C2557a;
import com.tinder.picassowebp.picasso.Picasso;
import com.tinder.utils.C3077n;
import com.tinder.utils.C3095y;
import com.tinder.utils.al;
import com.tinder.views.CustomTextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.http.HttpStatus;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.tinder.fragments.g */
public class C2626g extends Fragment implements TextWatcher, OnClickListener, AnimationListener, C2421c, ax, bq {
    ImageView f4950A;
    ImageView f4951B;
    ImageView f4952C;
    private int f4953D;
    private C2515r f4954E;
    private Intent f4955F;
    @Nullable
    private User f4956G;
    private boolean f4957H;
    private ProcessedPhoto[] f4958I;
    private PhotoUser[] f4959J;
    private ArrayList<ImageView> f4960K;
    private ArrayList<ProgressBar> f4961L;
    private ArrayList<ImageView> f4962M;
    private String f4963N;
    private boolean f4964O;
    private boolean f4965P;
    @Nullable
    private String f4966Q;
    private int f4967R;
    private int f4968S;
    @NonNull
    private boolean[] f4969T;
    private int f4970U;
    private int f4971V;
    private float f4972W;
    private float f4973X;
    private C2420b f4974Y;
    private CustomTextView f4975Z;
    ImageView f4976a;
    private CustomTextView aa;
    private ProgressBar ab;
    private int ac;
    private int ad;
    ImageView f4977b;
    ImageView f4978c;
    ImageView f4979d;
    ImageView f4980e;
    ImageView f4981f;
    ImageView f4982g;
    ImageView f4983h;
    ImageView f4984i;
    ImageView f4985j;
    ImageView f4986k;
    ImageView f4987l;
    ScrollView f4988m;
    LinearLayout f4989n;
    EditText f4990o;
    TextView f4991p;
    GridLayout f4992q;
    ProgressBar f4993r;
    ProgressBar f4994s;
    ProgressBar f4995t;
    ProgressBar f4996u;
    ProgressBar f4997v;
    ProgressBar f4998w;
    View f4999x;
    View f5000y;
    View f5001z;

    /* renamed from: com.tinder.fragments.g.1 */
    class C26171 implements OnClickListener {
        final /* synthetic */ C2626g f4937a;

        C26171(C2626g c2626g) {
            this.f4937a = c2626g;
        }

        public void onClick(View view) {
            int i = 0;
            while (i < this.f4937a.f4959J.length) {
                if (this.f4937a.ac == 0 && this.f4937a.f4959J[i] == null) {
                    C3095y.m9471a("indexToAdd=" + i);
                    this.f4937a.f4964O = true;
                    this.f4937a.ad = i;
                    this.f4937a.startActivityForResult(this.f4937a.f4955F, 1111);
                    return;
                }
                i++;
            }
        }
    }

    /* renamed from: com.tinder.fragments.g.2 */
    class C26182 implements AnimationListener {
        final /* synthetic */ ViewGroup f4938a;
        final /* synthetic */ ViewGroup f4939b;
        final /* synthetic */ ImageView f4940c;
        final /* synthetic */ ImageView f4941d;
        final /* synthetic */ C2626g f4942e;

        C26182(C2626g c2626g, ViewGroup viewGroup, ViewGroup viewGroup2, ImageView imageView, ImageView imageView2) {
            this.f4942e = c2626g;
            this.f4938a = viewGroup;
            this.f4939b = viewGroup2;
            this.f4940c = imageView;
            this.f4941d = imageView2;
        }

        public void onAnimationStart(Animation animation) {
            if (al.m9276a()) {
                al.m9288b(this.f4938a, 0.2f);
                al.m9288b(this.f4939b, 0.2f);
                return;
            }
            ObjectAnimator.ofFloat(this.f4938a, "alpha", new float[]{0.2f}).setDuration(50).start();
            ObjectAnimator.ofFloat(this.f4939b, "alpha", new float[]{0.2f}).setDuration(50).start();
        }

        public void onAnimationEnd(Animation animation) {
            Drawable drawable = this.f4940c.getDrawable();
            this.f4940c.setImageDrawable(this.f4941d.getDrawable());
            this.f4941d.setImageDrawable(drawable);
            if (al.m9276a()) {
                al.m9288b(this.f4938a, 1.0f);
                al.m9288b(this.f4939b, 1.0f);
                return;
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f4938a, "alpha", new float[]{1.0f});
            if (ofFloat == null) {
                ofFloat.setDuration(100);
            }
            ObjectAnimator.ofFloat(this.f4938a, "alpha", new float[]{1.0f}).setDuration(100).start();
            ObjectAnimator.ofFloat(this.f4939b, "alpha", new float[]{1.0f}).setDuration(100).start();
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: com.tinder.fragments.g.3 */
    class C26193 implements C2529a {
        final /* synthetic */ C2626g f4943a;

        C26193(C2626g c2626g) {
            this.f4943a = c2626g;
        }

        public void m7211a() {
            C3095y.m9471a("instagram start logout");
            this.f4943a.f4974Y.m6617b(1);
        }
    }

    /* renamed from: com.tinder.fragments.g.4 */
    class C26204 implements OnClickListener {
        final /* synthetic */ C2626g f4944a;

        C26204(C2626g c2626g) {
            this.f4944a = c2626g;
        }

        public void onClick(View view) {
            this.f4944a.m7224c(false);
        }
    }

    /* renamed from: com.tinder.fragments.g.5 */
    class C26215 implements OnClickListener {
        final /* synthetic */ C2626g f4945a;

        C26215(C2626g c2626g) {
            this.f4945a = c2626g;
        }

        public void onClick(View view) {
            this.f4945a.m7224c(true);
        }
    }

    /* renamed from: com.tinder.fragments.g.6 */
    class C26226 implements OnClickListener {
        final /* synthetic */ C2626g f4946a;

        C26226(C2626g c2626g) {
            this.f4946a = c2626g;
        }

        public void onClick(View view) {
            if (this.f4946a.ac == 0) {
                int d = this.f4946a.m7238q();
                this.f4946a.m7232g(d);
                this.f4946a.ad = d;
                this.f4946a.startActivityForResult(this.f4946a.f4955F, 1111);
            }
        }
    }

    /* renamed from: com.tinder.fragments.g.7 */
    class C26237 implements OnClickListener {
        final /* synthetic */ C2626g f4947a;

        C26237(C2626g c2626g) {
            this.f4947a = c2626g;
        }

        public void onClick(View view) {
            this.f4947a.m7237p();
        }
    }

    /* renamed from: com.tinder.fragments.g.8 */
    class C26248 implements OnPreDrawListener {
        final /* synthetic */ C2626g f4948a;

        C26248(C2626g c2626g) {
            this.f4948a = c2626g;
        }

        public boolean onPreDraw() {
            int measuredWidth = this.f4948a.f4992q.getMeasuredWidth();
            int i = (measuredWidth + 0) / 3;
            int i2 = (measuredWidth - i) - 0;
            this.f4948a.f4992q.getChildAt(0).getLayoutParams().width = i2;
            this.f4948a.f4992q.getChildAt(0).getLayoutParams().height = i2;
            for (measuredWidth = 1; measuredWidth < this.f4948a.f4959J.length; measuredWidth++) {
                this.f4948a.f4992q.getChildAt(measuredWidth).getLayoutParams().width = i;
                this.f4948a.f4992q.getChildAt(measuredWidth).getLayoutParams().height = i;
            }
            this.f4948a.f4992q.setVisibility(0);
            this.f4948a.f4972W = (float) (i2 / i);
            this.f4948a.f4973X = ((float) i) / ((float) i2);
            return true;
        }
    }

    /* renamed from: com.tinder.fragments.g.9 */
    class C26259 implements OnClickListener {
        final /* synthetic */ C2626g f4949a;

        C26259(C2626g c2626g) {
            this.f4949a = c2626g;
        }

        public void onClick(View view) {
            this.f4949a.getActivity().onBackPressed();
        }
    }

    public C2626g() {
        this.f4953D = 1;
        this.f4969T = new boolean[6];
    }

    private void m7234m() {
        int size;
        C3095y.m9469a();
        if (this.f4956G != null) {
            size = this.f4956G.getPhotos().size();
        } else {
            size = 0;
        }
        this.f4959J = new PhotoUser[6];
        this.f4958I = new ProcessedPhoto[6];
        for (int i = 0; i < 6; i++) {
            if (i >= size || this.f4956G == null) {
                this.f4959J[i] = null;
            } else {
                this.f4959J[i] = (PhotoUser) this.f4956G.getPhotos().get(i);
            }
            PhotoUser photoUser = this.f4959J[i];
            if (photoUser == null) {
                this.f4958I[i] = null;
            } else if (i == 0) {
                this.f4958I[i] = photoUser.getProcessedPhoto(PhotoSizeUser.LARGE);
            } else {
                this.f4958I[i] = photoUser.getProcessedPhoto(PhotoSizeUser.LARGE);
            }
        }
        if (size > 0 && this.f4959J[0] != null) {
            this.f4959J[0].setIsMain(true);
        }
    }

    private void m7224c(boolean z) {
        C3095y.m9469a();
        if (this.ac == 0) {
            this.f4971V = -1;
            this.f4970U = -1;
            for (int i = 0; i < this.f4969T.length; i++) {
                if (this.f4969T[i]) {
                    if (this.f4970U >= 0) {
                        this.f4971V = i;
                        break;
                    }
                    this.f4970U = i;
                }
            }
            if (z) {
                this.f4971V = 0;
            }
            if (this.f4970U <= -1 || this.f4971V <= -1) {
                C3095y.m9479c("Two photos not selected");
                m7235n();
                return;
            }
            ((ProgressBar) this.f4961L.get(this.f4970U)).setVisibility(0);
            ((ProgressBar) this.f4961L.get(this.f4971V)).setVisibility(0);
            this.ac++;
            C2913k.m8570a(this.f4970U, this.f4971V, this.f4959J, this);
            SparksEvent sparksEvent;
            if (this.f4971V > this.f4970U) {
                sparksEvent = new SparksEvent("Profile.ChangePhotoOrder");
                sparksEvent.put("photoId", this.f4959J[this.f4971V].getPhotoId());
                sparksEvent.put("fromIdx", Integer.valueOf(this.f4971V));
                sparksEvent.put("toIdx", Integer.valueOf(this.f4970U));
                C2807a.m8056a(sparksEvent);
                return;
            }
            sparksEvent = new SparksEvent("Profile.ChangePhotoOrder");
            sparksEvent.put("photoId", this.f4959J[this.f4970U].getPhotoId());
            sparksEvent.put("fromIdx", Integer.valueOf(this.f4970U));
            sparksEvent.put("toIdx", Integer.valueOf(this.f4971V));
            C2807a.m8056a(sparksEvent);
        }
    }

    private void m7235n() {
        for (int i = 0; i < this.f4960K.size(); i++) {
            m7227e(i);
        }
        this.f4968S = 0;
    }

    private void m7227e(int i) {
        C3095y.m9471a("photoIndex=" + i);
        ImageView imageView = (ImageView) this.f4960K.get(i);
        if (this.f4959J[i] != null) {
            C3095y.m9471a("unselecting ...");
            imageView.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.border_image_no_padding));
            this.f4969T[i] = false;
            this.f4968S--;
            ((ImageView) this.f4962M.get(i)).setSelected(false);
        } else {
            C3095y.m9471a("No photo, not unselecting ...");
        }
        m7236o();
    }

    private void m7231f(int i) {
        C3095y.m9471a("photoIndex=" + i);
        ((ImageView) this.f4960K.get(i)).setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.border_image_blue));
        this.f4969T[i] = true;
        this.f4968S++;
        ((ImageView) this.f4962M.get(i)).setSelected(true);
        m7236o();
    }

    private void m7236o() {
        OnClickListener c26171 = new C26171(this);
        OnClickListener c26204 = new C26204(this);
        OnClickListener c26215 = new C26215(this);
        OnClickListener c26226 = new C26226(this);
        OnClickListener c26237 = new C26237(this);
        if (this.f4968S == 0) {
            if (C3077n.m9401a(this.f4959J) < this.f4959J.length) {
                this.f4950A.setVisibility(8);
                this.f4951B.setVisibility(8);
                this.f4952C.setVisibility(0);
                this.f4952C.setImageResource(R.drawable.selector_actionbar_add);
                this.f4952C.setOnClickListener(c26171);
                return;
            }
            this.f4950A.setVisibility(8);
            this.f4951B.setVisibility(8);
            this.f4952C.setVisibility(8);
        } else if (this.f4968S == 1) {
            if (this.f4969T[0]) {
                this.f4950A.setVisibility(8);
                this.f4951B.setVisibility(8);
                this.f4952C.setVisibility(0);
                this.f4952C.setImageResource(R.drawable.selector_ab_btn_edit_profile);
                this.f4952C.setOnClickListener(c26226);
                return;
            }
            this.f4950A.setVisibility(0);
            this.f4951B.setVisibility(0);
            this.f4952C.setVisibility(0);
            this.f4950A.setImageResource(R.drawable.selector_ab_btn_edit_profile);
            this.f4950A.setOnClickListener(c26226);
            this.f4951B.setImageResource(R.drawable.selector_ab_make_profile);
            this.f4951B.setOnClickListener(c26215);
            this.f4952C.setImageResource(R.drawable.selector_ab_delete);
            this.f4952C.setOnClickListener(c26237);
        } else if (this.f4968S == 2) {
            if (this.f4969T[0]) {
                this.f4950A.setVisibility(8);
                this.f4951B.setVisibility(8);
                this.f4952C.setVisibility(0);
                this.f4952C.setImageResource(R.drawable.selector_ab_swap);
                this.f4952C.setOnClickListener(c26204);
                return;
            }
            this.f4950A.setVisibility(8);
            this.f4951B.setVisibility(0);
            this.f4952C.setVisibility(0);
            this.f4951B.setImageResource(R.drawable.selector_ab_swap);
            this.f4951B.setOnClickListener(c26204);
            this.f4952C.setImageResource(R.drawable.selector_ab_delete);
            this.f4952C.setOnClickListener(c26237);
        } else if (this.f4969T[0]) {
            this.f4950A.setVisibility(8);
            this.f4951B.setVisibility(8);
            this.f4952C.setVisibility(8);
        } else {
            this.f4950A.setVisibility(8);
            this.f4951B.setVisibility(8);
            this.f4952C.setVisibility(0);
            this.f4952C.setImageResource(R.drawable.selector_ab_delete);
            this.f4952C.setOnClickListener(c26237);
        }
    }

    private void m7237p() {
        C3095y.m9469a();
        if (this.f4965P || this.ac != 0) {
            C3095y.m9471a("Not doing anything, just reversing failed check");
            this.f4965P = false;
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < this.f4969T.length; i++) {
            if (this.f4969T[i]) {
                if (i < this.f4959J.length) {
                    PhotoUser photoUser = this.f4959J[i];
                    if (photoUser != null) {
                        this.ac++;
                        arrayList.add(photoUser.getPhotoId());
                        arrayList2.add(Integer.valueOf(i));
                        ((ProgressBar) this.f4961L.get(i)).setVisibility(0);
                    } else {
                        C3095y.m9479c("photo to delete is null, doh");
                    }
                } else {
                    C3095y.m9479c("index out of range");
                }
                m7227e(i);
            }
        }
        if (arrayList.size() > 0) {
            ManagerApp.m7922m().m8593a(arrayList, arrayList2, (ax) this);
        } else {
            C3095y.m9476b("No photos to delete");
        }
    }

    private int m7238q() {
        for (int i = 0; i < this.f4969T.length; i++) {
            if (this.f4969T[i]) {
                return i;
            }
        }
        return 0;
    }

    private void m7239r() {
        C3095y.m9471a("ENTER : " + this);
        this.f4976a.setOnClickListener(this);
        this.f4977b.setOnClickListener(this);
        this.f4978c.setOnClickListener(this);
        this.f4979d.setOnClickListener(this);
        this.f4980e.setOnClickListener(this);
        this.f4981f.setOnClickListener(this);
        this.f4982g.setOnClickListener(this);
        this.f4983h.setOnClickListener(this);
        this.f4984i.setOnClickListener(this);
        this.f4985j.setOnClickListener(this);
        this.f4986k.setOnClickListener(this);
        this.f4987l.setOnClickListener(this);
        this.f4960K = new ArrayList(6);
        this.f4960K.add(this.f4976a);
        this.f4960K.add(this.f4977b);
        this.f4960K.add(this.f4978c);
        this.f4960K.add(this.f4979d);
        this.f4960K.add(this.f4980e);
        this.f4960K.add(this.f4981f);
        this.f4960K.trimToSize();
        this.f4961L = new ArrayList();
        this.f4961L.add(this.f4993r);
        this.f4961L.add(this.f4994s);
        this.f4961L.add(this.f4995t);
        this.f4961L.add(this.f4996u);
        this.f4961L.add(this.f4997v);
        this.f4961L.add(this.f4998w);
        this.f4962M = new ArrayList();
        this.f4962M.add(this.f4982g);
        this.f4962M.add(this.f4983h);
        this.f4962M.add(this.f4984i);
        this.f4962M.add(this.f4985j);
        this.f4962M.add(this.f4986k);
        this.f4962M.add(this.f4987l);
        if (this.f4956G != null) {
            this.f4963N = this.f4956G.getBio();
        }
        if (this.f4963N != null && this.f4963N.length() > HttpStatus.SC_INTERNAL_SERVER_ERROR) {
            this.f4963N = this.f4963N.substring(0, HttpStatus.SC_INTERNAL_SERVER_ERROR);
        }
        this.f4990o.setText(this.f4963N);
        this.f4990o.addTextChangedListener(this);
        m7221b(this.f4963N);
        m7244a();
        this.f4992q.getViewTreeObserver().addOnPreDrawListener(new C26248(this));
        OnClickListener c26259 = new C26259(this);
        this.f4999x.setOnClickListener(c26259);
        this.f5001z.setOnClickListener(c26259);
        this.f5000y.setOnClickListener(c26259);
        this.f4974Y = new C2557a(this, ManagerApp.m7911b());
        CharSequence ap = ManagerApp.m7914e().ap();
        CharSequence string = getResources().getString(R.string.instagram_login);
        if (TextUtils.isEmpty(ap)) {
            this.f4975Z.setText(string);
            m7229e(false);
            m7226d(false);
        } else {
            this.f4975Z.setText(ap);
            m7229e(true);
            m7226d(true);
        }
        this.ab.setVisibility(8);
    }

    public void m7245a(int i) {
        C3095y.m9469a();
        if (i >= this.f4958I.length || this.f4958I[i] == null || this.f4958I[i].getImageUrl() == null) {
            ((ImageView) this.f4960K.get(i)).setImageDrawable(null);
            m7214a(false, i);
            return;
        }
        String imageUrl = this.f4958I[i].getImageUrl();
        C3095y.m9471a("Getting from Picasso...");
        Picasso.m8982a(getActivity()).m8990a(imageUrl).m9120a((int) R.drawable.image_add).m9121a((int) R.dimen.photo_container_sides, (int) R.dimen.photo_container_sides).m9127b().m9124a((ImageView) this.f4960K.get(i));
        ((ImageView) this.f4960K.get(i)).setTag(imageUrl);
        m7214a(true, i);
    }

    public void m7244a() {
        C3095y.m9469a();
        for (int i = 0; i < this.f4959J.length; i++) {
            m7245a(i);
        }
    }

    private void m7214a(boolean z, int i) {
        C3095y.m9471a("isPhotoAvailable=" + z + ", containNumber=" + i);
        if (!z) {
            ((ImageView) this.f4960K.get(i)).setScaleType(ScaleType.CENTER);
            ((ImageView) this.f4960K.get(i)).setBackgroundResource(R.drawable.image_add);
        }
        ((ImageView) this.f4960K.get(i)).setClickable(true);
        ((ProgressBar) this.f4961L.get(i)).setVisibility(4);
    }

    private void m7232g(int i) {
        C3095y.m9471a("photoIndex=" + i);
        if (this.ac != 0) {
            return;
        }
        if (this.f4959J[i] == null) {
            if (this.ac == 0) {
                this.ad = m7240s();
                startActivityForResult(this.f4955F, 1111);
            }
        } else if (this.f4969T[i]) {
            m7227e(i);
        } else {
            m7231f(i);
        }
    }

    private int m7240s() {
        for (int i = 0; i < this.f4959J.length; i++) {
            if (this.f4959J[i] == null) {
                return i;
            }
        }
        return 0;
    }

    private void m7233h(int i) {
        C3095y.m9471a("deletedIndex=" + i);
        while (i < this.f4959J.length - 1) {
            PhotoUser photoUser = this.f4959J[i + 1];
            if (photoUser != null) {
                ImageView imageView = (ImageView) this.f4960K.get(i);
                imageView.setScaleType(ScaleType.CENTER_CROP);
                Picasso.m8982a(getActivity()).m8990a(photoUser.getImageUrl()).m9121a((int) R.dimen.photo_container_sides, (int) R.dimen.photo_container_sides).m9124a(imageView);
            }
            this.f4959J[i] = this.f4959J[i + 1];
            this.f4959J[i + 1] = null;
            i++;
        }
        for (int i2 = 0; i2 < this.f4959J.length; i2++) {
            if (this.f4959J[i2] == null) {
                imageView = (ImageView) this.f4960K.get(i2);
                imageView.setScaleType(ScaleType.CENTER);
                imageView.setImageResource(R.drawable.image_add);
            }
        }
    }

    public void m7250a(boolean z) {
        C3095y.m9471a(this + " ENTER");
        this.f4957H = z;
        if (!this.f4963N.equals(this.f4990o.getText().toString())) {
            C3095y.m9471a("Bio changed");
            this.f4954E.show();
            this.f4963N = this.f4990o.getText().toString();
            ManagerApp.m7922m().m8592a(this.f4963N, (bq) this);
        } else if (z) {
            C3095y.m9471a("Bio didn't change");
            getActivity().setResult(-1);
            getActivity().finish();
        }
    }

    public void onActivityResult(int i, int i2, @NonNull Intent intent) {
        C3095y.m9471a(String.format("onActivityResult %s %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        String stringExtra;
        switch (i) {
            case C3374b.SmoothProgressBar_spb_progressiveStop_speed /*7*/:
                if (i2 == -1) {
                    stringExtra = intent.getStringExtra("access_code");
                    if (TextUtils.isEmpty(stringExtra)) {
                        C2807a.m8056a(new SparksEvent("Account.InstagramLoginFail"));
                        m7262h();
                        return;
                    }
                    this.f4974Y.m6616a(stringExtra);
                    return;
                }
                C3095y.m9471a("Instagram Login error: code empty");
                C2807a.m8056a(new SparksEvent("Account.InstagramLoginFail"));
                m7262h();
                return;
            case 1111:
                if (i2 == -1 && intent != null) {
                    stringExtra = intent.getStringExtra(ShareConstants.FEED_SOURCE_PARAM);
                    String stringExtra2 = intent.getStringExtra(ShareConstants.WEB_DIALOG_PARAM_ID);
                    float floatExtra = intent.getFloatExtra("xoffset_percent", GroundOverlayOptions.NO_DIMENSION);
                    float floatExtra2 = intent.getFloatExtra("yoffset_percent", GroundOverlayOptions.NO_DIMENSION);
                    float floatExtra3 = intent.getFloatExtra("xdistance_percent", GroundOverlayOptions.NO_DIMENSION);
                    float floatExtra4 = intent.getFloatExtra("ydistance_percent", GroundOverlayOptions.NO_DIMENSION);
                    if (floatExtra != GroundOverlayOptions.NO_DIMENSION && floatExtra2 != GroundOverlayOptions.NO_DIMENSION && floatExtra3 != GroundOverlayOptions.NO_DIMENSION && floatExtra4 != GroundOverlayOptions.NO_DIMENSION) {
                        boolean z;
                        C3095y.m9471a("cropXOff: " + floatExtra + " cropXDist: " + floatExtra3 + " cropYOff: " + floatExtra2 + " cropYDist: " + floatExtra4);
                        PhotoUser photoUser = new PhotoUser(stringExtra2, stringExtra);
                        photoUser.setXOffsetPercent(floatExtra);
                        photoUser.setYOffsetPercent(floatExtra2);
                        photoUser.setXDistancePercent(floatExtra3);
                        photoUser.setYDistancePercent(floatExtra4);
                        int i3 = this.ad;
                        if (i3 < this.f4959J.length) {
                            boolean isMain;
                            PhotoUser photoUser2 = this.f4959J[i3];
                            if (photoUser2 != null) {
                                this.f4966Q = photoUser2.getPhotoId();
                                isMain = photoUser2.isMain();
                            } else {
                                isMain = false;
                            }
                            z = isMain;
                        } else {
                            this.f4966Q = null;
                            z = false;
                        }
                        this.ac++;
                        ManagerApp.m7922m().m8586a(this.f4967R, i3, photoUser, this.f4966Q, (ax) this, z, photoUser);
                        ((ProgressBar) this.f4961L.get(i3)).setVisibility(0);
                        break;
                    }
                    return;
                }
                C3095y.m9471a("Not getting result");
                break;
                break;
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.ad = bundle.getInt("key_photo_pos", 0);
        }
        this.f4955F = new Intent(getActivity(), ActivityAddPhoto.class);
        this.f4955F.addFlags(67108864);
        this.f4956G = ManagerApp.m7922m().m8599d();
        m7234m();
        this.f4954E = new C2515r(getActivity());
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.view_edit_profile, viewGroup, false);
        this.f4976a = (ImageView) inflate.findViewById(R.id.imageViewMain);
        this.f4977b = (ImageView) inflate.findViewById(R.id.imageView2);
        this.f4978c = (ImageView) inflate.findViewById(R.id.imageView3);
        this.f4979d = (ImageView) inflate.findViewById(R.id.imageView4);
        this.f4980e = (ImageView) inflate.findViewById(R.id.imageView5);
        this.f4981f = (ImageView) inflate.findViewById(R.id.imageView6);
        this.f4982g = (ImageView) inflate.findViewById(R.id.imageView_selector_overlay_main);
        this.f4983h = (ImageView) inflate.findViewById(R.id.imageView_selector_overlay2);
        this.f4984i = (ImageView) inflate.findViewById(R.id.imageView_selector_overlay3);
        this.f4985j = (ImageView) inflate.findViewById(R.id.imageView_selector_overlay4);
        this.f4986k = (ImageView) inflate.findViewById(R.id.imageView_selector_overlay5);
        this.f4987l = (ImageView) inflate.findViewById(R.id.imageView_selector_overlay6);
        this.f4989n = (LinearLayout) inflate.findViewById(R.id.linearLayout_bio);
        this.f4990o = (EditText) inflate.findViewById(R.id.editText_bio);
        this.f4991p = (TextView) inflate.findViewById(R.id.textView_chars_remaining);
        this.f4992q = (GridLayout) inflate.findViewById(R.id.gridLayout_pics);
        this.f4993r = (ProgressBar) inflate.findViewById(R.id.progressSpinner1);
        this.f4994s = (ProgressBar) inflate.findViewById(R.id.progressSpinner2);
        this.f4995t = (ProgressBar) inflate.findViewById(R.id.progressSpinner3);
        this.f4996u = (ProgressBar) inflate.findViewById(R.id.progressSpinner4);
        this.f4997v = (ProgressBar) inflate.findViewById(R.id.progressSpinner5);
        this.f4998w = (ProgressBar) inflate.findViewById(R.id.progressSpinner6);
        this.f4988m = (ScrollView) inflate.findViewById(R.id.scrollView);
        this.f4999x = inflate.findViewById(R.id.view_ab_icon);
        this.f5000y = inflate.findViewById(R.id.view_back_title);
        this.f5001z = inflate.findViewById(R.id.view_back_icon);
        this.f4950A = (ImageView) inflate.findViewById(R.id.view_ab_icon_one);
        this.f4951B = (ImageView) inflate.findViewById(R.id.view_ab_icon_two);
        this.f4952C = (ImageView) inflate.findViewById(R.id.view_ab_icon_three);
        this.f4975Z = (CustomTextView) inflate.findViewById(R.id.button_instagram_auth);
        this.aa = (CustomTextView) inflate.findViewById(R.id.disconnect_button);
        inflate.findViewById(R.id.instagram_container).setOnClickListener(this);
        this.ab = (ProgressBar) inflate.findViewById(R.id.progress_web);
        return inflate;
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        m7239r();
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f4953D = arguments.getInt("instagramConnectValue", 1);
            if (this.f4953D != 1) {
                m7241t();
                this.f4988m.post(new Runnable() {
                    final /* synthetic */ C2626g f4935a;

                    {
                        this.f4935a = r1;
                    }

                    public void run() {
                        this.f4935a.f4988m.fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD);
                    }
                });
            }
        }
    }

    public void onResume() {
        super.onResume();
        C3095y.m9471a("ENTER :" + this);
        this.f4964O = false;
        m7236o();
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        bundle.putInt("key_photo_pos", this.ad);
        super.onSaveInstanceState(bundle);
    }

    public void onPause() {
        super.onPause();
        C3095y.m9471a(this + " ENTER mSelectingPic: " + this.f4964O);
        if (!this.f4964O) {
            m7250a(false);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        al.m9297c(this.f4954E);
    }

    public void m7242E() {
        C3095y.m9469a();
        if (this.f4954E != null && this.f4954E.isShowing()) {
            this.f4954E.dismiss();
        }
        if (this.f4957H && getActivity() != null) {
            C3095y.m9471a("Going to preview");
            getActivity().setResult(-1);
            getActivity().finish();
        } else if (getActivity() != null) {
            Toast.makeText(getActivity(), R.string.updated_profile, 1).show();
        }
    }

    public void m7243F() {
        C3095y.m9469a();
        if (getActivity() != null) {
            Toast.makeText(getActivity(), R.string.error_profile_info_update, 1).show();
        }
        al.m9297c(this.f4954E);
    }

    public void m7247a(int i, @NonNull PhotoUser photoUser) {
        C3095y.m9471a("index=" + i);
        C3095y.m9471a("ADD PHOTO SUCCESS : " + photoUser.getPhotoId() + " contents: " + photoUser);
        this.ac--;
        if (getActivity() != null) {
            ((ImageView) this.f4960K.get(i)).setScaleType(ScaleType.CENTER_CROP);
            ProcessedPhoto processedPhoto = photoUser.getProcessedPhoto(PhotoSizeUser.SMALL);
            if (processedPhoto != null) {
                Picasso.m8982a(getActivity()).m8990a(processedPhoto.getImageUrl()).m9121a((int) R.dimen.photo_container_sides, (int) R.dimen.photo_container_sides).m9124a((ImageView) this.f4960K.get(i));
            }
            ((ImageView) this.f4960K.get(i)).setTag(photoUser.getImageUrl());
            m7214a(true, i);
            this.f4959J[i] = photoUser;
            ((ProgressBar) this.f4961L.get(i)).setVisibility(4);
            SparksEvent sparksEvent = new SparksEvent("Profile.AddPhoto");
            sparksEvent.put("photoId", photoUser.getPhotoId());
            C2807a.m8056a(sparksEvent);
            m7236o();
            C2913k.m8579a(this.f4959J, (ax) this);
        }
    }

    public void m7252b(int i) {
        C3095y.m9471a("index=" + i);
        this.ac--;
        if (getActivity() != null) {
            Toast.makeText(getActivity(), R.string.error_pic_add, 1).show();
            ((ProgressBar) this.f4961L.get(i)).setVisibility(4);
        }
    }

    public void m7249a(@NonNull List<Integer> list) {
        Collections.sort(list, new Comparator<Integer>() {
            final /* synthetic */ C2626g f4936a;

            {
                this.f4936a = r1;
            }

            public /* synthetic */ int compare(Object obj, @NonNull Object obj2) {
                return m7210a((Integer) obj, (Integer) obj2);
            }

            public int m7210a(Integer num, @NonNull Integer num2) {
                return num2.compareTo(num);
            }
        });
        for (int i = 0; i < list.size(); i++) {
            m7256c(((Integer) list.get(i)).intValue());
        }
    }

    public void m7256c(int i) {
        C3095y.m9471a("index=" + i);
        this.ac--;
        if (getActivity() != null) {
            PhotoUser photoUser = this.f4959J[i];
            if (photoUser != null) {
                SparksEvent sparksEvent = new SparksEvent("Profile.DeletePhoto");
                sparksEvent.put("photoId", photoUser.getPhotoId());
                C2807a.m8056a(sparksEvent);
            }
            this.f4959J[i] = null;
            ((ImageView) this.f4960K.get(i)).setScaleType(ScaleType.CENTER);
            ((ImageView) this.f4960K.get(i)).setImageBitmap(null);
            ((ImageView) this.f4960K.get(i)).setBackgroundResource(R.drawable.image_add);
            m7214a(false, i);
            ((ProgressBar) this.f4961L.get(i)).setVisibility(4);
            m7233h(i);
            m7236o();
        }
    }

    public void m7258d(int i) {
        C3095y.m9471a("index=" + i);
        this.ac--;
        if (getActivity() != null) {
            Toast.makeText(getActivity(), R.string.error_pic_delete, 1).show();
            ((ProgressBar) this.f4961L.get(i)).setVisibility(4);
        }
    }

    public void m7246a(int i, int i2) {
        C3095y.m9471a("oldIndex=" + i + ", index=" + i2);
        this.ac--;
        if (getActivity() == null) {
            C3095y.m9471a("Activity null, returning");
            return;
        }
        C3095y.m9471a("mMainPhotoNew=" + i2);
        ((ProgressBar) this.f4961L.get(i2)).setVisibility(4);
        int i3 = 0;
        while (i3 < this.f4959J.length) {
            if (!(i3 == i2 || this.f4959J[i3] == null)) {
                this.f4959J[i3].setIsMain(false);
            }
            i3++;
        }
        m7214a(true, i);
        m7214a(true, i2);
        this.f4967R = i2;
    }

    public void m7253b(int i, int i2) {
        C3095y.m9471a("oldIndex=" + i + ", index=" + i2);
        this.ac--;
        if (getActivity() != null) {
            Toast.makeText(getActivity(), R.string.error_pic_main, 1).show();
            this.f4965P = true;
            ((ProgressBar) this.f4961L.get(i2)).setVisibility(4);
        }
    }

    public void m7251b() {
        C3095y.m9469a();
        this.ac--;
        if (getActivity() != null) {
            m7234m();
            m7235n();
            ((ProgressBar) this.f4961L.get(this.f4970U)).setVisibility(4);
            ((ProgressBar) this.f4961L.get(this.f4971V)).setVisibility(4);
            m7223c(this.f4970U, this.f4971V);
            m7236o();
        }
    }

    public void m7255c() {
        C3095y.m9469a();
        this.ac--;
        if (getActivity() != null) {
            m7235n();
            Toast.makeText(getActivity(), R.string.error_pic_swap, 1).show();
            this.f4965P = true;
            ((ProgressBar) this.f4961L.get(this.f4970U)).setVisibility(4);
            ((ProgressBar) this.f4961L.get(this.f4971V)).setVisibility(4);
        }
    }

    public void m7257d() {
    }

    public void m7259e() {
    }

    public void beforeTextChanged(@NonNull CharSequence charSequence, int i, int i2, int i3) {
        m7221b(charSequence.toString());
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(@NonNull Editable editable) {
        C3095y.m9471a("editable=" + editable);
        m7221b(editable.toString());
    }

    private void m7221b(@NonNull String str) {
        int length = 500 - str.length();
        if (this.f4991p != null) {
            this.f4991p.setText(String.valueOf(length));
            int length2 = this.f4990o.length();
            if (length < 0) {
                this.f4991p.setTextColor(getResources().getColor(R.color.red));
                this.f4990o.getText().setSpan(new BackgroundColorSpan(SupportMenu.CATEGORY_MASK), length + length2, length2, 33);
                return;
            }
            this.f4991p.setTextColor(getResources().getColor(R.color.text_light));
            this.f4990o.getText().setSpan(new BackgroundColorSpan(getActivity().getResources().getColor(R.color.transparent)), 0, length2, 33);
        }
    }

    private void m7223c(int i, int i2) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        C3095y.m9471a("index1=" + i + ", index2=" + i2);
        if (i == 3) {
            viewGroup = (ViewGroup) this.f4992q.getChildAt(5);
        } else if (i == 5) {
            viewGroup = (ViewGroup) this.f4992q.getChildAt(3);
        } else {
            viewGroup = (ViewGroup) this.f4992q.getChildAt(i);
        }
        if (i2 == 3) {
            viewGroup2 = (ViewGroup) this.f4992q.getChildAt(5);
        } else if (i2 == 5) {
            viewGroup2 = (ViewGroup) this.f4992q.getChildAt(3);
        } else {
            viewGroup2 = (ViewGroup) this.f4992q.getChildAt(i2);
        }
        ImageView imageView = (ImageView) this.f4960K.get(i);
        ImageView imageView2 = (ImageView) this.f4960K.get(i2);
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        viewGroup.getLocationInWindow(iArr);
        viewGroup2.getLocationInWindow(iArr2);
        float f = (float) (iArr2[0] - iArr[0]);
        float f2 = (float) (iArr2[1] - iArr[1]);
        float f3 = (float) (iArr[0] - iArr2[0]);
        float f4 = (float) (iArr[1] - iArr2[1]);
        Animation translateAnimation = new TranslateAnimation(0.0f, f, 0.0f, f2);
        translateAnimation.setDuration(230);
        translateAnimation.setFillAfter(false);
        Animation translateAnimation2 = new TranslateAnimation(0.0f, f3, 0.0f, f4);
        translateAnimation2.setDuration(230);
        translateAnimation2.setFillAfter(false);
        translateAnimation.setAnimationListener(new C26182(this, viewGroup, viewGroup2, imageView, imageView2));
        Animation animationSet = new AnimationSet(true);
        Animation animationSet2 = new AnimationSet(true);
        Animation scaleAnimation = new ScaleAnimation(1.0f, this.f4973X, 1.0f, this.f4973X);
        scaleAnimation.setDuration(230);
        Animation scaleAnimation2 = new ScaleAnimation(1.0f, this.f4972W, 1.0f, this.f4972W);
        scaleAnimation2.setDuration(230);
        if (imageView.equals(this.f4976a)) {
            animationSet.addAnimation(scaleAnimation);
            animationSet2.addAnimation(scaleAnimation2);
        } else if (imageView2.equals(this.f4976a)) {
            animationSet.addAnimation(scaleAnimation2);
            animationSet2.addAnimation(scaleAnimation);
        }
        animationSet.addAnimation(translateAnimation);
        animationSet2.addAnimation(translateAnimation2);
        animationSet.setZAdjustment(-1);
        animationSet2.setZAdjustment(1);
        animationSet.setInterpolator(new LinearInterpolator());
        animationSet2.setInterpolator(new LinearInterpolator());
        viewGroup.startAnimation(animationSet);
        viewGroup2.startAnimation(animationSet2);
    }

    public void m7260f() {
        C3095y.m9469a();
        ManagerApp.m7930u().m8493a((Fragment) this);
    }

    public void onClick(@NonNull View view) {
        C3095y.m9471a("view=" + view);
        switch (view.getId()) {
            case R.id.item_text_centerLeft:
                m7250a(true);
            case R.id.imageViewMain:
            case R.id.imageView_selector_overlay_main:
                m7232g(0);
            case R.id.imageView2:
            case R.id.imageView_selector_overlay2:
                m7232g(1);
            case R.id.imageView3:
            case R.id.imageView_selector_overlay3:
                m7232g(2);
            case R.id.imageView6:
            case R.id.imageView_selector_overlay6:
                m7232g(5);
            case R.id.imageView5:
            case R.id.imageView_selector_overlay5:
                m7232g(4);
            case R.id.imageView4:
            case R.id.imageView_selector_overlay4:
                m7232g(3);
            case R.id.instagram_container:
                this.f4953D = 1;
                m7241t();
            default:
        }
    }

    public void m7248a(String str) {
        this.f4975Z.setText(str);
        m7229e(true);
        m7226d(true);
    }

    public void m7261g() {
        this.f4975Z.setText(getResources().getText(R.string.instagram_login));
        m7229e(false);
        m7226d(false);
    }

    public void onAnimationStart(Animation animation) {
        C3095y.m9469a();
    }

    public void m7262h() {
        new C2481f(getActivity(), this.f4974Y).show();
    }

    public void m7263i() {
        this.aa.setVisibility(0);
        new C2526u(getActivity(), this.f4974Y).show();
    }

    public void onAnimationEnd(Animation animation) {
        C3095y.m9469a();
    }

    public void m7264j() {
        new C2478e(getActivity()).show();
    }

    public void m7265k() {
        this.ab.setVisibility(0);
        this.aa.setVisibility(4);
    }

    public void onAnimationRepeat(Animation animation) {
        C3095y.m9469a();
    }

    public void m7266l() {
        this.ab.setVisibility(8);
    }

    public void m7254b(boolean z) {
    }

    private void m7226d(boolean z) {
        this.aa.setVisibility(z ? 0 : 8);
    }

    private void m7229e(boolean z) {
        this.f4975Z.setTextColor(getResources().getColor(z ? R.color.instagram_loggedin_name : R.color.orange));
    }

    private void m7241t() {
        if (TextUtils.isEmpty(ManagerApp.m7914e().ap())) {
            C3095y.m9471a("instagram start login");
            this.f4974Y.m6615a(this.f4953D);
            return;
        }
        new C2530v(getActivity(), new C26193(this)).show();
    }
}

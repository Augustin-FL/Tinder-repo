package com.tinder.fragments;

import android.animation.Animator;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tinder.R;
import com.tinder.activities.ActivityMain;
import com.tinder.base.ActivitySignedInBase;
import com.tinder.base.C2415a;
import com.tinder.p030d.bu;
import com.tinder.utils.C3095y;
import com.tinder.views.LoadingView;

/* renamed from: com.tinder.fragments.j */
public class C2627j extends C2415a {
    private LoadingView f5002a;

    /* renamed from: com.tinder.fragments.j.1 */
    class C26311 implements Runnable {
        final /* synthetic */ C2627j f5007a;

        /* renamed from: com.tinder.fragments.j.1.1 */
        class C26301 extends bu {
            final /* synthetic */ C26311 f5006a;

            C26301(C26311 c26311) {
                this.f5006a = c26311;
            }

            public void onAnimationEnd(Animator animator) {
                if (this.f5006a.f5007a.getActivity() != null) {
                    ((ActivityMain) this.f5006a.f5007a.getActivity()).m5910V();
                }
                this.f5006a.f5007a.f5002a.startAllPingAnimations();
            }
        }

        C26311(C2627j c2627j) {
            this.f5007a = c2627j;
        }

        public void run() {
            if (this.f5007a.f5002a != null) {
                this.f5007a.f5002a.refreshProfileAvatarImage();
                this.f5007a.f5002a.setLoadingText(this.f5007a.m7268a());
                this.f5007a.f5002a.animateAvatarIn(new C26301(this));
            }
        }
    }

    /* renamed from: com.tinder.fragments.j.2 */
    class C26322 extends bu {
        final /* synthetic */ C2627j f5008a;

        C26322(C2627j c2627j) {
            this.f5008a = c2627j;
        }

        public void onAnimationEnd(Animator animator) {
            try {
                ((ActivityMain) this.f5008a.getActivity()).m5910V();
            } catch (NullPointerException e) {
            }
            this.f5008a.f5002a.startAllPingAnimations();
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        m6603a(new C26311(this));
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (getActivity() instanceof ActivityMain) {
            ((ActivitySignedInBase) getActivity()).ab().setMenu(this);
        }
        return layoutInflater.inflate(R.layout.view_fragment_loading, viewGroup, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f5002a = (LoadingView) view.findViewById(R.id.frag_loading_loadingview);
    }

    public void onResume() {
        C3095y.m9469a();
        super.onResume();
        this.f5002a.refreshProfileAvatarImage();
        this.f5002a.setLoadingText(m7268a());
        this.f5002a.animateAvatarIn(new C26322(this));
    }

    public int m7268a() {
        return R.string.finding_people;
    }
}

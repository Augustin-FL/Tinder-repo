package com.tinder.fragments;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.facebook.internal.NativeProtocol;
import com.tinder.R;

/* renamed from: com.tinder.fragments.y */
public class C2748y extends Fragment {
    public static final String f5487a;
    private ProgressBar f5488b;
    private WebView f5489c;

    /* renamed from: com.tinder.fragments.y.1 */
    class C27471 extends WebChromeClient {
        final /* synthetic */ C2748y f5486a;

        /* renamed from: com.tinder.fragments.y.1.1 */
        class C27461 extends AnimatorListenerAdapter {
            final /* synthetic */ C27471 f5485a;

            C27461(C27471 c27471) {
                this.f5485a = c27471;
            }

            public void onAnimationEnd(Animator animator) {
                this.f5485a.f5486a.f5488b.setVisibility(8);
            }
        }

        C27471(C2748y c2748y) {
            this.f5486a = c2748y;
        }

        public void onProgressChanged(WebView webView, int i) {
            this.f5486a.f5488b.setProgress(i);
            if (i == 100) {
                this.f5486a.f5488b.animate().alpha(0.0f).setListener(new C27461(this));
                this.f5486a.f5489c.setAlpha(0.0f);
                this.f5486a.f5489c.animate().alpha(1.0f);
            }
        }
    }

    static {
        f5487a = C2748y.class.getSimpleName();
    }

    @NonNull
    public static C2748y m7825a(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(NativeProtocol.WEB_DIALOG_URL, str);
        C2748y c2748y = new C2748y();
        c2748y.setArguments(bundle);
        return c2748y;
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        return layoutInflater.inflate(R.layout.fragment_webview, viewGroup, false);
    }

    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f5489c = (WebView) view.findViewById(R.id.fragment_webview);
        this.f5488b = (ProgressBar) view.findViewById(R.id.fragment_webview_loading);
        String string = getArguments().getString(NativeProtocol.WEB_DIALOG_URL);
        this.f5489c.getSettings().setJavaScriptEnabled(true);
        this.f5489c.setWebChromeClient(new C27471(this));
        this.f5489c.loadUrl(string);
    }
}

package com.tinder.base;

import android.graphics.Outline;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tinder.utils.C3077n;

/* renamed from: com.tinder.base.c */
public class C2418c extends Fragment {

    /* renamed from: com.tinder.base.c.1 */
    class C24171 extends ViewOutlineProvider {
        final /* synthetic */ C2418c f4320a;

        C24171(C2418c c2418c) {
            this.f4320a = c2418c;
        }

        public void getOutline(@NonNull View view, @NonNull Outline outline) {
            outline.setRect(0, 0, view.getWidth(), view.getHeight());
        }
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (C3077n.m9412e()) {
            view.setOutlineProvider(new C24171(this));
            view.setTranslationZ(26.0f);
            view.setClipToOutline(false);
        }
    }
}

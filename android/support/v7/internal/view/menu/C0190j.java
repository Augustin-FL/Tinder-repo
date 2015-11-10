package android.support.v7.internal.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider;
import android.support.v7.internal.view.menu.C0188i.C0184a;
import android.view.ActionProvider.VisibilityListener;
import android.view.MenuItem;
import android.view.View;

@TargetApi(16)
/* renamed from: android.support.v7.internal.view.menu.j */
class C0190j extends C0188i {

    /* renamed from: android.support.v7.internal.view.menu.j.a */
    class C0189a extends C0184a implements VisibilityListener {
        ActionProvider.VisibilityListener f181c;
        final /* synthetic */ C0190j f182d;

        public C0189a(C0190j c0190j, Context context, android.view.ActionProvider actionProvider) {
            this.f182d = c0190j;
            super(c0190j, context, actionProvider);
        }

        public View onCreateActionView(MenuItem menuItem) {
            return this.a.onCreateActionView(menuItem);
        }

        public boolean overridesItemVisibility() {
            return this.a.overridesItemVisibility();
        }

        public boolean isVisible() {
            return this.a.isVisible();
        }

        public void refreshVisibility() {
            this.a.refreshVisibility();
        }

        public void setVisibilityListener(ActionProvider.VisibilityListener visibilityListener) {
            VisibilityListener visibilityListener2;
            this.f181c = visibilityListener;
            android.view.ActionProvider actionProvider = this.a;
            if (visibilityListener == null) {
                visibilityListener2 = null;
            }
            actionProvider.setVisibilityListener(visibilityListener2);
        }

        public void onActionProviderVisibilityChanged(boolean z) {
            if (this.f181c != null) {
                this.f181c.onActionProviderVisibilityChanged(z);
            }
        }
    }

    C0190j(Context context, SupportMenuItem supportMenuItem) {
        super(context, supportMenuItem);
    }

    C0184a m182a(android.view.ActionProvider actionProvider) {
        return new C0189a(this, this.a, actionProvider);
    }
}

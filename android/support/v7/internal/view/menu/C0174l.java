package android.support.v7.internal.view.menu;

import android.content.Context;
import android.os.Parcelable;

/* renamed from: android.support.v7.internal.view.menu.l */
public interface C0174l {

    /* renamed from: android.support.v7.internal.view.menu.l.a */
    public interface C0156a {
        void onCloseMenu(C0180f c0180f, boolean z);

        boolean onOpenSubMenu(C0180f c0180f);
    }

    boolean collapseItemActionView(C0180f c0180f, C0183h c0183h);

    boolean expandItemActionView(C0180f c0180f, C0183h c0183h);

    boolean flagActionItems();

    int getId();

    void initForMenu(Context context, C0180f c0180f);

    void onCloseMenu(C0180f c0180f, boolean z);

    void onRestoreInstanceState(Parcelable parcelable);

    Parcelable onSaveInstanceState();

    boolean onSubMenuSelected(C0195p c0195p);

    void updateMenuView(boolean z);
}

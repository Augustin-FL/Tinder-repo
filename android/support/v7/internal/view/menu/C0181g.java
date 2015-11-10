package android.support.v7.internal.view.menu;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.os.IBinder;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.appcompat.C0159R;
import android.support.v7.internal.view.menu.C0174l.C0156a;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.google.android.gms.location.places.Place;

/* renamed from: android.support.v7.internal.view.menu.g */
public class C0181g implements OnClickListener, OnDismissListener, OnKeyListener, C0156a {
    C0179e f144a;
    private C0180f f145b;
    private AlertDialog f146c;
    private C0156a f147d;

    public C0181g(C0180f c0180f) {
        this.f145b = c0180f;
    }

    public void m153a(IBinder iBinder) {
        C0180f c0180f = this.f145b;
        Builder builder = new Builder(c0180f.m138e());
        this.f144a = new C0179e(builder.getContext(), C0159R.layout.abc_list_menu_item_layout);
        this.f144a.m93a((C0156a) this);
        this.f145b.m116a(this.f144a);
        builder.setAdapter(this.f144a.m91a(), this);
        View o = c0180f.m148o();
        if (o != null) {
            builder.setCustomTitle(o);
        } else {
            builder.setIcon(c0180f.m147n()).setTitle(c0180f.m146m());
        }
        builder.setOnKeyListener(this);
        this.f146c = builder.create();
        this.f146c.setOnDismissListener(this);
        LayoutParams attributes = this.f146c.getWindow().getAttributes();
        attributes.type = Place.TYPE_ADMINISTRATIVE_AREA_LEVEL_3;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= AccessibilityNodeInfoCompat.ACTION_SET_SELECTION;
        this.f146c.show();
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 82 || i == 4) {
            Window window;
            View decorView;
            DispatcherState keyDispatcherState;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                window = this.f146c.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null) {
                            keyDispatcherState.startTracking(keyEvent, this);
                            return true;
                        }
                    }
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled()) {
                window = this.f146c.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null && keyDispatcherState.isTracking(keyEvent)) {
                            this.f145b.m120a(true);
                            dialogInterface.dismiss();
                            return true;
                        }
                    }
                }
            }
        }
        return this.f145b.performShortcut(i, keyEvent, 0);
    }

    public void m152a() {
        if (this.f146c != null) {
            this.f146c.dismiss();
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f144a.onCloseMenu(this.f145b, true);
    }

    public void onCloseMenu(C0180f c0180f, boolean z) {
        if (z || c0180f == this.f145b) {
            m152a();
        }
        if (this.f147d != null) {
            this.f147d.onCloseMenu(c0180f, z);
        }
    }

    public boolean onOpenSubMenu(C0180f c0180f) {
        if (this.f147d != null) {
            return this.f147d.onOpenSubMenu(c0180f);
        }
        return false;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f145b.m122a((C0183h) this.f144a.m91a().getItem(i), 0);
    }
}

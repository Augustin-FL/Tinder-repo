package com.tinder.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.wearable.Asset;
import com.tinder.R;
import com.tinder.enums.PhotoSizeUser;
import com.tinder.managers.C2828c;
import com.tinder.managers.C2913k;
import com.tinder.managers.ManagerApp;
import com.tinder.model.CommonConnection;
import com.tinder.model.ConnectionsGroup;
import com.tinder.model.Interest;
import com.tinder.model.User;
import com.tinder.model.WearUser;
import com.tinder.p030d.C2432m;
import com.tinder.picassowebp.picasso.C2281x;
import com.tinder.picassowebp.picasso.Picasso;
import com.tinder.picassowebp.picasso.Picasso.LoadedFrom;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class am {
    private ArrayMap<User, C3055b> f6584a;
    private List<C3056c> f6585b;
    private int f6586c;
    private C3043a f6587d;

    /* renamed from: com.tinder.utils.am.a */
    public interface C3043a {
        void m9170a(List<WearUser> list);
    }

    /* renamed from: com.tinder.utils.am.b */
    protected static class C3055b {
        private List<String> f6574a;
        private List<String> f6575b;
        @Nullable
        private Asset f6576c;

        public C3055b() {
            this.f6576c = null;
            this.f6574a = new ArrayList();
            this.f6575b = new ArrayList();
        }

        public void m9303a(@NonNull Bitmap bitmap) {
            C3095y.m9471a("ENTER");
            try {
                this.f6576c = an.m9319a(bitmap);
            } catch (IOException e) {
                C3095y.m9479c(e.toString());
            }
        }

        @Nullable
        public Asset m9302a() {
            return this.f6576c;
        }

        public List<String> m9305b() {
            return this.f6574a;
        }

        public void m9304a(List<String> list) {
            this.f6574a = list;
        }

        public List<String> m9307c() {
            return this.f6575b;
        }

        public void m9306b(List<String> list) {
            this.f6575b = list;
        }
    }

    /* renamed from: com.tinder.utils.am.c */
    private class C3056c implements C2432m, C2281x {
        final /* synthetic */ am f6577a;
        private final PhotoSizeUser f6578b;
        private User f6579c;
        private C3055b f6580d;
        private String f6581e;
        private boolean f6582f;
        private boolean f6583g;

        public C3056c(am amVar, User user) {
            this.f6577a = amVar;
            this.f6578b = PhotoSizeUser.MED;
            this.f6580d = new C3055b();
            this.f6579c = user;
            this.f6581e = this.f6579c.getMainPhoto().getProcessedPhoto(this.f6578b).getImageUrl();
        }

        public void m9310a() {
            C3095y.m9471a("ENTER");
            m9309d();
            ConnectionsGroup connections = this.f6579c.getConnections();
            if (ManagerApp.m7914e().ar()) {
                C2913k.m8576a(this.f6579c.getId(), (C2432m) this);
            } else if (connections == null) {
                this.f6583g = true;
            } else if (connections.needsFill()) {
                C2828c.m8156a(connections, 100, (C2432m) this);
            } else {
                m9308a(connections);
                this.f6583g = true;
                m9314c();
            }
            Picasso.m8982a(ManagerApp.m7917h()).m8990a(this.f6581e).m9126a((C2281x) this);
        }

        public boolean m9313b() {
            boolean z;
            C3095y.m9471a("ENTER");
            if (this.f6580d.m9302a() != null || this.f6582f) {
                z = true;
            } else {
                z = false;
            }
            if (z && this.f6583g) {
                return true;
            }
            return false;
        }

        public void m9314c() {
            C3095y.m9471a("ENTER");
            if (m9313b()) {
                this.f6577a.m9316a(this.f6579c, this.f6580d);
            }
        }

        private void m9309d() {
            List<Interest> commonInterests = this.f6579c.getCommonInterests();
            List arrayList = new ArrayList(commonInterests.size());
            for (Interest name : commonInterests) {
                arrayList.add(name.getName());
            }
            this.f6580d.m9306b(arrayList);
        }

        private void m9308a(@NonNull ConnectionsGroup connectionsGroup) {
            List arrayList = new ArrayList(connectionsGroup.getCompleteConnections().size());
            for (CommonConnection commonConnection : connectionsGroup.getCompleteConnections()) {
                if (commonConnection.getName() != null) {
                    arrayList.add(commonConnection.getName());
                }
            }
            this.f6580d.m9304a(arrayList);
        }

        public void onBitmapLoaded(@NonNull Bitmap bitmap, LoadedFrom loadedFrom) {
            C3095y.m9471a("ENTER");
            this.f6582f = true;
            this.f6580d.m9303a(bitmap);
            m9314c();
        }

        public void onBitmapFailed(Drawable drawable) {
            this.f6582f = true;
            C3095y.m9471a("ENTER");
            this.f6580d.m9303a(BitmapFactory.decodeResource(ManagerApp.m7917h().getResources(), R.drawable.matches_noprofile_icon));
            m9314c();
        }

        public void onPrepareLoad(Drawable drawable) {
        }

        public void m9312a(@Nullable ConnectionsGroup connectionsGroup, int i) {
            if (i == 0) {
                if (connectionsGroup == null) {
                    this.f6583g = true;
                    m9314c();
                } else if (connectionsGroup.needsFill()) {
                    C2828c.m8156a(connectionsGroup, 100, (C2432m) this);
                } else {
                    m9308a(connectionsGroup);
                    this.f6583g = true;
                    m9314c();
                }
            } else if (i == 1) {
                this.f6583g = true;
                if (connectionsGroup != null) {
                    connectionsGroup.setIgnoreUnresolvableIds(true);
                    m9308a(connectionsGroup);
                    m9314c();
                }
            }
        }

        public void m9311a(int i) {
            this.f6583g = true;
            m9314c();
        }
    }

    public am(C3043a c3043a) {
        C3095y.m9471a("ENTER");
        this.f6584a = new ArrayMap();
        this.f6585b = new ArrayList();
        this.f6587d = c3043a;
    }

    public void m9318a(@NonNull List<User> list) {
        C3095y.m9471a("ENTER with" + list);
        this.f6586c = list.size();
        this.f6585b.clear();
        this.f6584a.clear();
        for (User c3056c : list) {
            C3056c c3056c2 = new C3056c(this, c3056c);
            this.f6585b.add(c3056c2);
            c3056c2.m9310a();
        }
    }

    private void m9316a(User user, C3055b c3055b) {
        C3095y.m9471a("ENTER");
        this.f6584a.put(user, c3055b);
        m9315a();
    }

    private void m9315a() {
        C3095y.m9471a("ENTER " + this.f6584a.size() + " of " + this.f6586c);
        if (this.f6584a.size() == this.f6586c) {
            List arrayList = new ArrayList();
            for (User user : this.f6584a.keySet()) {
                C3055b c3055b = (C3055b) this.f6584a.get(user);
                WearUser wearUser = new WearUser(user.getId(), user.getName(), user.getAge(), user.getBio(), c3055b.m9307c(), c3055b.m9305b());
                wearUser.setAsset(c3055b.m9302a());
                arrayList.add(wearUser);
            }
            if (this.f6587d != null) {
                C3095y.m9471a("all done..calling back ");
                this.f6587d.m9170a(arrayList);
                return;
            }
            C3095y.m9471a("all done. NOT calling back. Listener null");
        }
    }
}

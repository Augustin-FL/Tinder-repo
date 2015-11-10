package com.tinder.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tinder.R;
import com.tinder.model.FacebookAlbum;
import com.tinder.picassowebp.picasso.C2281x;
import com.tinder.picassowebp.picasso.Picasso;
import com.tinder.picassowebp.picasso.Picasso.LoadedFrom;
import com.tinder.views.RoundImageView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tinder.adapters.b */
public class C2329b extends BaseAdapter {
    @NonNull
    private final Context f4054a;
    @NonNull
    private final LayoutInflater f4055b;
    private List<FacebookAlbum> f4056c;

    /* renamed from: com.tinder.adapters.b.a */
    static class C2328a implements C2281x {
        RoundImageView f4051a;
        TextView f4052b;
        TextView f4053c;

        C2328a() {
        }

        public void onBitmapLoaded(Bitmap bitmap, LoadedFrom loadedFrom) {
            this.f4051a.onBitmapLoaded(bitmap, loadedFrom);
            this.f4051a.setBackgroundResource(R.color.transparent);
        }

        public void onBitmapFailed(Drawable drawable) {
        }

        public void onPrepareLoad(Drawable drawable) {
        }
    }

    public /* synthetic */ Object getItem(int i) {
        return m6365a(i);
    }

    public C2329b(@NonNull Context context) {
        this.f4056c = new ArrayList();
        this.f4054a = context;
        this.f4055b = LayoutInflater.from(context);
    }

    public void m6367a(List<FacebookAlbum> list) {
        this.f4056c = list;
        notifyDataSetChanged();
    }

    public void m6366a(FacebookAlbum facebookAlbum, int i) {
        this.f4056c.add(i, facebookAlbum);
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.f4056c.size();
    }

    public FacebookAlbum m6365a(int i) {
        return (FacebookAlbum) this.f4056c.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    @Nullable
    public View getView(int i, @Nullable View view, ViewGroup viewGroup) {
        if (view == null) {
            C2328a c2328a = new C2328a();
            view = this.f4055b.inflate(R.layout.row_view_album, null);
            c2328a.f4051a = (RoundImageView) view.findViewById(R.id.thumbnail_album);
            c2328a.f4052b = (TextView) view.findViewById(R.id.text_albumName);
            c2328a.f4053c = (TextView) view.findViewById(R.id.subtext_albumCount);
            view.setTag(c2328a);
        }
        C2328a c2328a2 = (C2328a) view.getTag();
        FacebookAlbum facebookAlbum = (FacebookAlbum) this.f4056c.get(i);
        int count = facebookAlbum.getCount();
        CharSequence name = facebookAlbum.getName();
        String thumbUrl = facebookAlbum.getThumbUrl();
        CharSequence quantityString = this.f4054a.getResources().getQuantityString(R.plurals.photo_count_plural, count, new Object[]{Integer.valueOf(count)});
        c2328a2.f4052b.setText(name);
        c2328a2.f4053c.setText(quantityString);
        c2328a2.f4051a.setBackgroundResource(R.drawable.photo_placeholder);
        if (!TextUtils.isEmpty(thumbUrl)) {
            Picasso.m8982a(this.f4054a).m8990a(thumbUrl).m9121a((int) R.dimen.photo_container_sides, (int) R.dimen.photo_container_sides).m9127b().m9126a(c2328a2.f4051a);
        }
        return view;
    }
}

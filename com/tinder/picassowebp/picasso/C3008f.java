package com.tinder.picassowebp.picasso;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.ContactsContract.Contacts;
import com.tinder.picassowebp.picasso.Picasso.LoadedFrom;
import java.io.IOException;
import java.io.InputStream;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.tinder.picassowebp.picasso.f */
class C3008f extends C2983c {
    private static final UriMatcher f6367p;
    final Context f6368o;

    @TargetApi(14)
    /* renamed from: com.tinder.picassowebp.picasso.f.a */
    private static class C3007a {
        static InputStream m9048a(ContentResolver contentResolver, Uri uri) {
            return Contacts.openContactPhotoInputStream(contentResolver, uri, true);
        }
    }

    static {
        f6367p = new UriMatcher(-1);
        f6367p.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        f6367p.addURI("com.android.contacts", "contacts/lookup/*", 1);
        f6367p.addURI("com.android.contacts", "contacts/#/photo", 2);
        f6367p.addURI("com.android.contacts", "contacts/#", 3);
        f6367p.addURI("com.android.contacts", "display_photo/#", 4);
    }

    C3008f(Context context, Picasso picasso, C3014i c3014i, C3005d c3005d, C3033v c3033v, C2993a c2993a) {
        super(picasso, c3014i, c3005d, c3033v, c2993a);
        this.f6368o = context;
    }

    Bitmap m9051a(C3026s c3026s) throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = m9050n();
            Bitmap a = m9049a(inputStream, c3026s);
            return a;
        } finally {
            ab.m9025a(inputStream);
        }
    }

    LoadedFrom m9052a() {
        return LoadedFrom.DISK;
    }

    private InputStream m9050n() throws IOException {
        ContentResolver contentResolver = this.f6368o.getContentResolver();
        Uri uri = m8965i().f6427a;
        switch (f6367p.match(uri)) {
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                uri = Contacts.lookupContact(contentResolver, uri);
                if (uri == null) {
                    return null;
                }
                break;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
            case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                return contentResolver.openInputStream(uri);
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                break;
            default:
                throw new IllegalStateException("Invalid uri: " + uri);
        }
        if (VERSION.SDK_INT < 14) {
            return Contacts.openContactPhotoInputStream(contentResolver, uri);
        }
        return C3007a.m9048a(contentResolver, uri);
    }

    private Bitmap m9049a(InputStream inputStream, C3026s c3026s) throws IOException {
        if (inputStream == null) {
            return null;
        }
        Options c = C2983c.m8951c(c3026s);
        if (C2983c.m8949a(c)) {
            InputStream n = m9050n();
            try {
                BitmapFactory.decodeStream(n, null, c);
                C2983c.m8948a(c3026s.f6430d, c3026s.f6431e, c);
            } finally {
                ab.m9025a(n);
            }
        }
        return BitmapFactory.decodeStream(inputStream, null, c);
    }
}

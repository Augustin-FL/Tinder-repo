package io.fabric.sdk.android.services.p003b;

import android.content.Context;
import com.google.android.gms.location.places.Place;
import io.fabric.sdk.android.services.common.C3264n;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: io.fabric.sdk.android.services.b.l */
public class C3233l implements C3232f {
    private final Context f7005a;
    private final File f7006b;
    private final String f7007c;
    private final File f7008d;
    private C3264n f7009e;
    private File f7010f;

    public C3233l(Context context, File file, String str, String str2) throws IOException {
        this.f7005a = context;
        this.f7006b = file;
        this.f7007c = str2;
        this.f7008d = new File(this.f7006b, str);
        this.f7009e = new C3264n(this.f7008d);
        m9812e();
    }

    private void m9812e() {
        this.f7010f = new File(this.f7006b, this.f7007c);
        if (!this.f7010f.exists()) {
            this.f7010f.mkdirs();
        }
    }

    public void m9818a(byte[] bArr) throws IOException {
        this.f7009e.m9968a(bArr);
    }

    public int m9813a() {
        return this.f7009e.m9966a();
    }

    public void m9816a(String str) throws IOException {
        this.f7009e.close();
        m9811a(this.f7008d, new File(this.f7010f, str));
        this.f7009e = new C3264n(this.f7008d);
    }

    private void m9811a(File file, File file2) throws IOException {
        Closeable fileInputStream;
        Throwable th;
        Closeable closeable = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                closeable = m9814a(file2);
                CommonUtils.m9857a((InputStream) fileInputStream, (OutputStream) closeable, new byte[Place.TYPE_SUBLOCALITY_LEVEL_2]);
                CommonUtils.m9855a(fileInputStream, "Failed to close file input stream");
                CommonUtils.m9855a(closeable, "Failed to close output stream");
                file.delete();
            } catch (Throwable th2) {
                th = th2;
                CommonUtils.m9855a(fileInputStream, "Failed to close file input stream");
                CommonUtils.m9855a(closeable, "Failed to close output stream");
                file.delete();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            CommonUtils.m9855a(fileInputStream, "Failed to close file input stream");
            CommonUtils.m9855a(closeable, "Failed to close output stream");
            file.delete();
            throw th;
        }
    }

    public OutputStream m9814a(File file) throws IOException {
        return new FileOutputStream(file);
    }

    public List<File> m9815a(int i) {
        List<File> arrayList = new ArrayList();
        for (Object add : this.f7010f.listFiles()) {
            arrayList.add(add);
            if (arrayList.size() >= i) {
                break;
            }
        }
        return arrayList;
    }

    public void m9817a(List<File> list) {
        for (File file : list) {
            CommonUtils.m9852a(this.f7005a, String.format("deleting sent analytics file %s", new Object[]{file.getName()}));
            file.delete();
        }
    }

    public List<File> m9821c() {
        return Arrays.asList(this.f7010f.listFiles());
    }

    public void m9822d() {
        try {
            this.f7009e.close();
        } catch (IOException e) {
        }
        this.f7008d.delete();
    }

    public boolean m9820b() {
        return this.f7009e.m9971b();
    }

    public boolean m9819a(int i, int i2) {
        return this.f7009e.m9970a(i, i2);
    }
}

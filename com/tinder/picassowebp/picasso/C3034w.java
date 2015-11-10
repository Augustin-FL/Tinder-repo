package com.tinder.picassowebp.picasso;

import java.io.PrintWriter;

/* renamed from: com.tinder.picassowebp.picasso.w */
public class C3034w {
    public final int f6472a;
    public final int f6473b;
    public final long f6474c;
    public final long f6475d;
    public final long f6476e;
    public final long f6477f;
    public final long f6478g;
    public final long f6479h;
    public final long f6480i;
    public final long f6481j;
    public final int f6482k;
    public final int f6483l;
    public final int f6484m;
    public final long f6485n;

    public C3034w(int i, int i2, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, int i3, int i4, int i5, long j9) {
        this.f6472a = i;
        this.f6473b = i2;
        this.f6474c = j;
        this.f6475d = j2;
        this.f6476e = j3;
        this.f6477f = j4;
        this.f6478g = j5;
        this.f6479h = j6;
        this.f6480i = j7;
        this.f6481j = j8;
        this.f6482k = i3;
        this.f6483l = i4;
        this.f6484m = i5;
        this.f6485n = j9;
    }

    public void m9148a(PrintWriter printWriter) {
        printWriter.println("===============BEGIN PICASSO STATS ===============");
        printWriter.println("Memory Cache Stats");
        printWriter.print("  Max Cache Size: ");
        printWriter.println(this.f6472a);
        printWriter.print("  Cache Size: ");
        printWriter.println(this.f6473b);
        printWriter.print("  Cache % Full: ");
        printWriter.println((int) Math.ceil((double) ((((float) this.f6473b) / ((float) this.f6472a)) * 100.0f)));
        printWriter.print("  Cache Hits: ");
        printWriter.println(this.f6474c);
        printWriter.print("  Cache Misses: ");
        printWriter.println(this.f6475d);
        printWriter.println("Network Stats");
        printWriter.print("  Download Count: ");
        printWriter.println(this.f6482k);
        printWriter.print("  Total Download Size: ");
        printWriter.println(this.f6476e);
        printWriter.print("  Average Download Size: ");
        printWriter.println(this.f6479h);
        printWriter.println("Bitmap Stats");
        printWriter.print("  Total Bitmaps Decoded: ");
        printWriter.println(this.f6483l);
        printWriter.print("  Total Bitmap Size: ");
        printWriter.println(this.f6477f);
        printWriter.print("  Total Transformed Bitmaps: ");
        printWriter.println(this.f6484m);
        printWriter.print("  Total Transformed Bitmap Size: ");
        printWriter.println(this.f6478g);
        printWriter.print("  Average Bitmap Size: ");
        printWriter.println(this.f6480i);
        printWriter.print("  Average Transformed Bitmap Size: ");
        printWriter.println(this.f6481j);
        printWriter.println("===============END PICASSO STATS ===============");
        printWriter.flush();
    }

    public String toString() {
        return "StatsSnapshot{maxSize=" + this.f6472a + ", size=" + this.f6473b + ", cacheHits=" + this.f6474c + ", cacheMisses=" + this.f6475d + ", downloadCount=" + this.f6482k + ", totalDownloadSize=" + this.f6476e + ", averageDownloadSize=" + this.f6479h + ", totalOriginalBitmapSize=" + this.f6477f + ", totalTransformedBitmapSize=" + this.f6478g + ", averageOriginalBitmapSize=" + this.f6480i + ", averageTransformedBitmapSize=" + this.f6481j + ", originalBitmapCount=" + this.f6483l + ", transformedBitmapCount=" + this.f6484m + ", timeStamp=" + this.f6485n + '}';
    }
}

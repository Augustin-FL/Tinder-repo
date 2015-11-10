package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: okio.l */
public final class C3342l {
    private static final Logger f7299a;

    /* renamed from: okio.l.1 */
    static class C33391 implements C2071q {
        final /* synthetic */ C2201s f7294a;
        final /* synthetic */ OutputStream f7295b;

        C33391(C2201s c2201s, OutputStream outputStream) {
            this.f7294a = c2201s;
            this.f7295b = outputStream;
        }

        public void a_(C3334c c3334c, long j) throws IOException {
            C3350t.m10340a(c3334c.f7280b, 0, j);
            while (j > 0) {
                this.f7294a.m5630g();
                C3347o c3347o = c3334c.f7279a;
                int min = (int) Math.min(j, (long) (c3347o.f7310c - c3347o.f7309b));
                this.f7295b.write(c3347o.f7308a, c3347o.f7309b, min);
                c3347o.f7309b += min;
                j -= (long) min;
                c3334c.f7280b -= (long) min;
                if (c3347o.f7309b == c3347o.f7310c) {
                    c3334c.f7279a = c3347o.m10328a();
                    C3348p.m10334a(c3347o);
                }
            }
        }

        public void flush() throws IOException {
            this.f7295b.flush();
        }

        public void close() throws IOException {
            this.f7295b.close();
        }

        public C2201s m10274a() {
            return this.f7294a;
        }

        public String toString() {
            return "sink(" + this.f7295b + ")";
        }
    }

    /* renamed from: okio.l.2 */
    static class C33402 implements C2076r {
        final /* synthetic */ C2201s f7296a;
        final /* synthetic */ InputStream f7297b;

        C33402(C2201s c2201s, InputStream inputStream) {
            this.f7296a = c2201s;
            this.f7297b = inputStream;
        }

        public long m10275a(C3334c c3334c, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (j == 0) {
                return 0;
            } else {
                this.f7296a.m5630g();
                C3347o e = c3334c.m10226e(1);
                int read = this.f7297b.read(e.f7308a, e.f7310c, (int) Math.min(j, (long) (2048 - e.f7310c)));
                if (read == -1) {
                    return -1;
                }
                e.f7310c += read;
                c3334c.f7280b += (long) read;
                return (long) read;
            }
        }

        public void close() throws IOException {
            this.f7297b.close();
        }

        public C2201s m10276a() {
            return this.f7296a;
        }

        public String toString() {
            return "source(" + this.f7297b + ")";
        }
    }

    /* renamed from: okio.l.3 */
    static class C33413 extends C2202a {
        final /* synthetic */ Socket f7298a;

        C33413(Socket socket) {
            this.f7298a = socket;
        }

        protected void m10277a() {
            try {
                this.f7298a.close();
            } catch (Throwable e) {
                C3342l.f7299a.log(Level.WARNING, "Failed to close timed out socket " + this.f7298a, e);
            }
        }
    }

    static {
        f7299a = Logger.getLogger(C3342l.class.getName());
    }

    private C3342l() {
    }

    public static C3333e m10280a(C2076r c2076r) {
        if (c2076r != null) {
            return new C3346n(c2076r);
        }
        throw new IllegalArgumentException("source == null");
    }

    public static C3332d m10279a(C2071q c2071q) {
        if (c2071q != null) {
            return new C3344m(c2071q);
        }
        throw new IllegalArgumentException("sink == null");
    }

    public static C2071q m10281a(OutputStream outputStream) {
        return C3342l.m10282a(outputStream, new C2201s());
    }

    private static C2071q m10282a(OutputStream outputStream, C2201s c2201s) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        } else if (c2201s != null) {
            return new C33391(c2201s, outputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static C2071q m10283a(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        C2201s c = C3342l.m10289c(socket);
        return c.m5637a(C3342l.m10282a(socket.getOutputStream(), c));
    }

    public static C2076r m10285a(InputStream inputStream) {
        return C3342l.m10286a(inputStream, new C2201s());
    }

    private static C2076r m10286a(InputStream inputStream, C2201s c2201s) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (c2201s != null) {
            return new C33402(c2201s, inputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static C2076r m10284a(File file) throws FileNotFoundException {
        if (file != null) {
            return C3342l.m10285a(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static C2071q m10287b(File file) throws FileNotFoundException {
        if (file != null) {
            return C3342l.m10281a(new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static C2071q m10290c(File file) throws FileNotFoundException {
        if (file != null) {
            return C3342l.m10281a(new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static C2076r m10288b(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        C2201s c = C3342l.m10289c(socket);
        return c.m5638a(C3342l.m10286a(socket.getInputStream(), c));
    }

    private static C2202a m10289c(Socket socket) {
        return new C33413(socket);
    }
}

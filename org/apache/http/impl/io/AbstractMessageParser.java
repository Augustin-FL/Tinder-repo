package org.apache.http.impl.io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.ParseException;
import org.apache.http.ProtocolException;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.config.MessageConstraints;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.BasicLineParser;
import org.apache.http.message.LineParser;
import org.apache.http.params.HttpParamConfig;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

@NotThreadSafe
public abstract class AbstractMessageParser<T extends HttpMessage> implements HttpMessageParser<T> {
    private static final int HEADERS = 1;
    private static final int HEAD_LINE = 0;
    private final List<CharArrayBuffer> headerLines;
    protected final LineParser lineParser;
    private T message;
    private final MessageConstraints messageConstraints;
    private final SessionInputBuffer sessionBuffer;
    private int state;

    protected abstract T parseHead(SessionInputBuffer sessionInputBuffer) throws IOException, HttpException, ParseException;

    @Deprecated
    public AbstractMessageParser(SessionInputBuffer sessionInputBuffer, LineParser lineParser, HttpParams httpParams) {
        Args.notNull(sessionInputBuffer, "Session input buffer");
        Args.notNull(httpParams, "HTTP parameters");
        this.sessionBuffer = sessionInputBuffer;
        this.messageConstraints = HttpParamConfig.getMessageConstraints(httpParams);
        if (lineParser == null) {
            lineParser = BasicLineParser.INSTANCE;
        }
        this.lineParser = lineParser;
        this.headerLines = new ArrayList();
        this.state = 0;
    }

    public AbstractMessageParser(SessionInputBuffer sessionInputBuffer, LineParser lineParser, MessageConstraints messageConstraints) {
        this.sessionBuffer = (SessionInputBuffer) Args.notNull(sessionInputBuffer, "Session input buffer");
        if (lineParser == null) {
            lineParser = BasicLineParser.INSTANCE;
        }
        this.lineParser = lineParser;
        if (messageConstraints == null) {
            messageConstraints = MessageConstraints.DEFAULT;
        }
        this.messageConstraints = messageConstraints;
        this.headerLines = new ArrayList();
        this.state = 0;
    }

    public static Header[] parseHeaders(SessionInputBuffer sessionInputBuffer, int i, int i2, LineParser lineParser) throws HttpException, IOException {
        List arrayList = new ArrayList();
        if (lineParser == null) {
            lineParser = BasicLineParser.INSTANCE;
        }
        return parseHeaders(sessionInputBuffer, i, i2, lineParser, arrayList);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.apache.http.Header[] parseHeaders(org.apache.http.io.SessionInputBuffer r9, int r10, int r11, org.apache.http.message.LineParser r12, java.util.List<org.apache.http.util.CharArrayBuffer> r13) throws org.apache.http.HttpException, java.io.IOException {
        /*
        r8 = 9;
        r4 = 0;
        r7 = 32;
        r2 = 0;
        r0 = "Session input buffer";
        org.apache.http.util.Args.notNull(r9, r0);
        r0 = "Line parser";
        org.apache.http.util.Args.notNull(r12, r0);
        r0 = "Header line list";
        org.apache.http.util.Args.notNull(r13, r0);
        r3 = r4;
        r0 = r4;
    L_0x0017:
        if (r0 != 0) goto L_0x0049;
    L_0x0019:
        r0 = new org.apache.http.util.CharArrayBuffer;
        r1 = 64;
        r0.<init>(r1);
    L_0x0020:
        r1 = r9.readLine(r0);
        r5 = -1;
        if (r1 == r5) goto L_0x002e;
    L_0x0027:
        r1 = r0.length();
        r5 = 1;
        if (r1 >= r5) goto L_0x004d;
    L_0x002e:
        r0 = r13.size();
        r1 = new org.apache.http.Header[r0];
    L_0x0034:
        r0 = r13.size();
        if (r2 >= r0) goto L_0x00b6;
    L_0x003a:
        r0 = r13.get(r2);
        r0 = (org.apache.http.util.CharArrayBuffer) r0;
        r0 = r12.parseHeader(r0);	 Catch:{ ParseException -> 0x00ab }
        r1[r2] = r0;	 Catch:{ ParseException -> 0x00ab }
        r2 = r2 + 1;
        goto L_0x0034;
    L_0x0049:
        r0.clear();
        goto L_0x0020;
    L_0x004d:
        r1 = r0.charAt(r2);
        if (r1 == r7) goto L_0x0059;
    L_0x0053:
        r1 = r0.charAt(r2);
        if (r1 != r8) goto L_0x00a2;
    L_0x0059:
        if (r3 == 0) goto L_0x00a2;
    L_0x005b:
        r1 = r2;
    L_0x005c:
        r5 = r0.length();
        if (r1 >= r5) goto L_0x006a;
    L_0x0062:
        r5 = r0.charAt(r1);
        if (r5 == r7) goto L_0x0082;
    L_0x0068:
        if (r5 == r8) goto L_0x0082;
    L_0x006a:
        if (r11 <= 0) goto L_0x0085;
    L_0x006c:
        r5 = r3.length();
        r5 = r5 + 1;
        r6 = r0.length();
        r5 = r5 + r6;
        r5 = r5 - r1;
        if (r5 <= r11) goto L_0x0085;
    L_0x007a:
        r0 = new org.apache.http.MessageConstraintException;
        r1 = "Maximum line length limit exceeded";
        r0.<init>(r1);
        throw r0;
    L_0x0082:
        r1 = r1 + 1;
        goto L_0x005c;
    L_0x0085:
        r3.append(r7);
        r5 = r0.length();
        r5 = r5 - r1;
        r3.append(r0, r1, r5);
        r1 = r0;
        r0 = r3;
    L_0x0092:
        if (r10 <= 0) goto L_0x00a7;
    L_0x0094:
        r3 = r13.size();
        if (r3 < r10) goto L_0x00a7;
    L_0x009a:
        r0 = new org.apache.http.MessageConstraintException;
        r1 = "Maximum header count exceeded";
        r0.<init>(r1);
        throw r0;
    L_0x00a2:
        r13.add(r0);
        r1 = r4;
        goto L_0x0092;
    L_0x00a7:
        r3 = r0;
        r0 = r1;
        goto L_0x0017;
    L_0x00ab:
        r0 = move-exception;
        r1 = new org.apache.http.ProtocolException;
        r0 = r0.getMessage();
        r1.<init>(r0);
        throw r1;
    L_0x00b6:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.impl.io.AbstractMessageParser.parseHeaders(org.apache.http.io.SessionInputBuffer, int, int, org.apache.http.message.LineParser, java.util.List):org.apache.http.Header[]");
    }

    public T parse() throws IOException, HttpException {
        switch (this.state) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                try {
                    this.message = parseHead(this.sessionBuffer);
                    this.state = HEADERS;
                    break;
                } catch (Throwable e) {
                    throw new ProtocolException(e.getMessage(), e);
                }
            case HEADERS /*1*/:
                break;
            default:
                throw new IllegalStateException("Inconsistent parser state");
        }
        this.message.setHeaders(parseHeaders(this.sessionBuffer, this.messageConstraints.getMaxHeaderCount(), this.messageConstraints.getMaxLineLength(), this.lineParser, this.headerLines));
        T t = this.message;
        this.message = null;
        this.headerLines.clear();
        this.state = 0;
        return t;
    }
}

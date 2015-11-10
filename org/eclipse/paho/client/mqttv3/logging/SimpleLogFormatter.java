package org.eclipse.paho.client.mqttv3.logging;

import com.facebook.stetho.BuildConfig;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.MessageFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class SimpleLogFormatter extends Formatter {
    final String ls;

    public SimpleLogFormatter() {
        this.ls = System.getProperty("line.separator");
    }

    public String format(LogRecord logRecord) {
        PrintWriter printWriter;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(logRecord.getLevel().getName() + "\t");
        stringBuffer.append(MessageFormat.format("{0, date, yy-MM-dd} {0, time, kk:mm:ss.SSSS} ", new Object[]{new Date(logRecord.getMillis())}) + "\t");
        String sourceClassName = logRecord.getSourceClassName();
        String str = BuildConfig.FLAVOR;
        if (sourceClassName != null) {
            int length = sourceClassName.length();
            if (length > 20) {
                str = logRecord.getSourceClassName().substring(length - 19);
            } else {
                str = new StringBuffer().append(sourceClassName).append(new char[]{' '}, 0, 1).toString();
            }
        }
        stringBuffer.append(str + "\t").append(" ");
        stringBuffer.append(left(logRecord.getSourceMethodName(), 23, ' ') + "\t");
        stringBuffer.append(logRecord.getThreadID() + "\t");
        stringBuffer.append(formatMessage(logRecord)).append(this.ls);
        if (logRecord.getThrown() != null) {
            stringBuffer.append("Throwable occurred: ");
            Throwable thrown = logRecord.getThrown();
            try {
                Writer stringWriter = new StringWriter();
                printWriter = new PrintWriter(stringWriter);
                try {
                    thrown.printStackTrace(printWriter);
                    stringBuffer.append(stringWriter.toString());
                    if (printWriter != null) {
                        try {
                            printWriter.close();
                        } catch (Exception e) {
                        }
                    }
                } catch (Throwable th) {
                    thrown = th;
                    if (printWriter != null) {
                        try {
                            printWriter.close();
                        } catch (Exception e2) {
                        }
                    }
                    throw thrown;
                }
            } catch (Throwable th2) {
                thrown = th2;
                printWriter = null;
                if (printWriter != null) {
                    printWriter.close();
                }
                throw thrown;
            }
        }
        return stringBuffer.toString();
    }

    public static String left(String str, int i, char c) {
        if (str.length() >= i) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(i);
        stringBuffer.append(str);
        int length = i - str.length();
        while (true) {
            length--;
            if (length < 0) {
                return stringBuffer.toString();
            }
            stringBuffer.append(c);
        }
    }
}

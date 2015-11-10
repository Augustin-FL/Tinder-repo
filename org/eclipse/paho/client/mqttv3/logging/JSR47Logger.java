package org.eclipse.paho.client.mqttv3.logging;

import com.facebook.appevents.AppEventsConstants;
import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.MemoryHandler;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class JSR47Logger implements Logger {
    private String catalogID;
    private Logger julLogger;
    private ResourceBundle logMessageCatalog;
    private String loggerName;
    private String resourceName;
    private ResourceBundle traceMessageCatalog;

    public JSR47Logger() {
        this.julLogger = null;
        this.logMessageCatalog = null;
        this.traceMessageCatalog = null;
        this.catalogID = null;
        this.resourceName = null;
        this.loggerName = null;
    }

    public void initialise(ResourceBundle resourceBundle, String str, String str2) {
        this.traceMessageCatalog = this.logMessageCatalog;
        this.resourceName = str2;
        this.loggerName = str;
        this.julLogger = Logger.getLogger(this.loggerName);
        this.logMessageCatalog = resourceBundle;
        this.traceMessageCatalog = resourceBundle;
        this.catalogID = this.logMessageCatalog.getString(AppEventsConstants.EVENT_PARAM_VALUE_NO);
    }

    public void setResourceName(String str) {
        this.resourceName = str;
    }

    public boolean isLoggable(int i) {
        return this.julLogger.isLoggable(mapJULLevel(i));
    }

    public void severe(String str, String str2, String str3) {
        log(1, str, str2, str3, null, null);
    }

    public void severe(String str, String str2, String str3, Object[] objArr) {
        log(1, str, str2, str3, objArr, null);
    }

    public void severe(String str, String str2, String str3, Object[] objArr, Throwable th) {
        log(1, str, str2, str3, objArr, th);
    }

    public void warning(String str, String str2, String str3) {
        log(2, str, str2, str3, null, null);
    }

    public void warning(String str, String str2, String str3, Object[] objArr) {
        log(2, str, str2, str3, objArr, null);
    }

    public void warning(String str, String str2, String str3, Object[] objArr, Throwable th) {
        log(2, str, str2, str3, objArr, th);
    }

    public void info(String str, String str2, String str3) {
        log(3, str, str2, str3, null, null);
    }

    public void info(String str, String str2, String str3, Object[] objArr) {
        log(3, str, str2, str3, objArr, null);
    }

    public void info(String str, String str2, String str3, Object[] objArr, Throwable th) {
        log(3, str, str2, str3, objArr, th);
    }

    public void config(String str, String str2, String str3) {
        log(4, str, str2, str3, null, null);
    }

    public void config(String str, String str2, String str3, Object[] objArr) {
        log(4, str, str2, str3, objArr, null);
    }

    public void config(String str, String str2, String str3, Object[] objArr, Throwable th) {
        log(4, str, str2, str3, objArr, th);
    }

    public void log(int i, String str, String str2, String str3, Object[] objArr, Throwable th) {
        Level mapJULLevel = mapJULLevel(i);
        if (this.julLogger.isLoggable(mapJULLevel)) {
            logToJsr47(mapJULLevel, str, str2, this.catalogID, this.logMessageCatalog, str3, objArr, th);
        }
    }

    public void fine(String str, String str2, String str3) {
        trace(5, str, str2, str3, null, null);
    }

    public void fine(String str, String str2, String str3, Object[] objArr) {
        trace(5, str, str2, str3, objArr, null);
    }

    public void fine(String str, String str2, String str3, Object[] objArr, Throwable th) {
        trace(5, str, str2, str3, objArr, th);
    }

    public void finer(String str, String str2, String str3) {
        trace(6, str, str2, str3, null, null);
    }

    public void finer(String str, String str2, String str3, Object[] objArr) {
        trace(6, str, str2, str3, objArr, null);
    }

    public void finer(String str, String str2, String str3, Object[] objArr, Throwable th) {
        trace(6, str, str2, str3, objArr, th);
    }

    public void finest(String str, String str2, String str3) {
        trace(7, str, str2, str3, null, null);
    }

    public void finest(String str, String str2, String str3, Object[] objArr) {
        trace(7, str, str2, str3, objArr, null);
    }

    public void finest(String str, String str2, String str3, Object[] objArr, Throwable th) {
        trace(7, str, str2, str3, objArr, th);
    }

    public void trace(int i, String str, String str2, String str3, Object[] objArr, Throwable th) {
        Level mapJULLevel = mapJULLevel(i);
        if (this.julLogger.isLoggable(mapJULLevel)) {
            logToJsr47(mapJULLevel, str, str2, this.catalogID, this.traceMessageCatalog, str3, objArr, th);
        }
    }

    private String getResourceMessage(ResourceBundle resourceBundle, String str) {
        try {
            str = resourceBundle.getString(str);
        } catch (MissingResourceException e) {
        }
        return str;
    }

    private void logToJsr47(Level level, String str, String str2, String str3, ResourceBundle resourceBundle, String str4, Object[] objArr, Throwable th) {
        if (str4.indexOf("=====") == -1) {
            str4 = MessageFormat.format(getResourceMessage(resourceBundle, str4), objArr);
        }
        LogRecord logRecord = new LogRecord(level, this.resourceName + ": " + str4);
        logRecord.setSourceClassName(str);
        logRecord.setSourceMethodName(str2);
        logRecord.setLoggerName(this.loggerName);
        if (th != null) {
            logRecord.setThrown(th);
        }
        this.julLogger.log(logRecord);
    }

    private Level mapJULLevel(int i) {
        switch (i) {
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                return Level.SEVERE;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                return Level.WARNING;
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                return Level.INFO;
            case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                return Level.CONFIG;
            case C3374b.SmoothProgressBar_spb_speed /*5*/:
                return Level.FINE;
            case C3374b.SmoothProgressBar_spb_progressiveStart_speed /*6*/:
                return Level.FINER;
            case C3374b.SmoothProgressBar_spb_progressiveStop_speed /*7*/:
                return Level.FINEST;
            default:
                return null;
        }
    }

    public String formatMessage(String str, Object[] objArr) {
        try {
            str = this.logMessageCatalog.getString(str);
        } catch (MissingResourceException e) {
        }
        return str;
    }

    public void dumpTrace() {
        dumpMemoryTrace47(this.julLogger);
    }

    protected static void dumpMemoryTrace47(Logger logger) {
        if (logger != null) {
            Handler[] handlers = logger.getHandlers();
            int i = 0;
            while (i < handlers.length) {
                if (handlers[i] instanceof MemoryHandler) {
                    synchronized (handlers[i]) {
                        ((MemoryHandler) handlers[i]).push();
                    }
                    return;
                }
                i++;
            }
            dumpMemoryTrace47(logger.getParent());
        }
    }
}

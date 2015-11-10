package org.eclipse.paho.client.mqttv3.logging;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class LoggerFactory {
    public static final String MQTT_CLIENT_MSG_CAT = "org.eclipse.paho.client.mqttv3.internal.nls.logcat";
    private static final String className;
    private static String jsr47LoggerClassName;
    private static String overrideloggerClassName;

    static {
        className = LoggerFactory.class.getName();
        overrideloggerClassName = null;
        jsr47LoggerClassName = "org.eclipse.paho.client.mqttv3.logging.JSR47Logger";
    }

    public static Logger getLogger(String str, String str2) {
        String str3 = overrideloggerClassName;
        if (str3 == null) {
            str3 = jsr47LoggerClassName;
        }
        Logger logger = getLogger(str3, ResourceBundle.getBundle(str), str2, null);
        if (logger != null) {
            return logger;
        }
        throw new MissingResourceException("Error locating the logging class", className, str2);
    }

    private static Logger getLogger(String str, ResourceBundle resourceBundle, String str2, String str3) {
        try {
            Logger logger;
            Class cls = Class.forName(str);
            if (cls != null) {
                try {
                    logger = (Logger) cls.newInstance();
                    logger.initialise(resourceBundle, str2, str3);
                } catch (IllegalAccessException e) {
                    return null;
                } catch (InstantiationException e2) {
                    return null;
                } catch (ExceptionInInitializerError e3) {
                    return null;
                } catch (SecurityException e4) {
                    return null;
                }
            }
            logger = null;
            return logger;
        } catch (NoClassDefFoundError e5) {
            return null;
        } catch (ClassNotFoundException e6) {
            return null;
        }
    }

    public static String getLoggingProperty(String str) {
        try {
            Class cls = Class.forName("java.util.logging.LogManager");
            Object invoke = cls.getMethod("getLogManager", new Class[0]).invoke(null, null);
            return (String) cls.getMethod("getProperty", new Class[]{String.class}).invoke(invoke, new Object[]{str});
        } catch (Exception e) {
            return null;
        }
    }

    public static void setLogger(String str) {
        overrideloggerClassName = str;
    }
}

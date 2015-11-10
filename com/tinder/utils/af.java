package com.tinder.utils;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.facebook.stetho.BuildConfig;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.HttpStatus;

public class af {

    /* renamed from: com.tinder.utils.af.a */
    public static class C3048a extends AsyncTask<Object, Void, Void> {
        @Nullable
        protected /* synthetic */ Object doInBackground(@NonNull Object[] objArr) {
            return m9228a(objArr);
        }

        @Nullable
        protected Void m9228a(@NonNull Object... objArr) {
            InputStream inputStream;
            OutputStream outputStream;
            Exception exception;
            HttpURLConnection httpURLConnection;
            Exception exception2;
            Throwable th;
            HttpURLConnection httpURLConnection2 = null;
            if (objArr.length == 2) {
                String str = (String) objArr[0];
                String c = af.m9233d(str);
                Runnable runnable = (Runnable) objArr[1];
                File a = af.m9229a(str);
                if (a != null && a.exists()) {
                    a.delete();
                }
                try {
                    HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(str).openConnection();
                    try {
                        httpURLConnection3.connect();
                        if (httpURLConnection3.getResponseCode() != HttpStatus.SC_OK) {
                            C3095y.m9479c("Server returned HTTP " + httpURLConnection3.getResponseCode() + " " + httpURLConnection3.getResponseMessage());
                        }
                        inputStream = httpURLConnection3.getInputStream();
                    } catch (Exception e) {
                        outputStream = null;
                        inputStream = null;
                        exception = e;
                        httpURLConnection = httpURLConnection3;
                        exception2 = exception;
                        try {
                            C3095y.m9479c(exception2.toString());
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e2) {
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    if (runnable != null) {
                                        runnable.run();
                                    }
                                    return null;
                                }
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            if (runnable != null) {
                                runnable.run();
                            }
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            httpURLConnection2 = httpURLConnection;
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e3) {
                                    if (httpURLConnection2 != null) {
                                        httpURLConnection2.disconnect();
                                    }
                                    throw th;
                                }
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        outputStream = null;
                        inputStream = null;
                        httpURLConnection2 = httpURLConnection3;
                        th = th3;
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        throw th;
                    }
                    try {
                        outputStream = new FileOutputStream(c);
                        try {
                            byte[] bArr = new byte[AccessibilityNodeInfoCompat.ACTION_SCROLL_FORWARD];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                outputStream.write(bArr, 0, read);
                            }
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e4) {
                                }
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (httpURLConnection3 != null) {
                                httpURLConnection3.disconnect();
                            }
                        } catch (Exception e5) {
                            exception = e5;
                            httpURLConnection = httpURLConnection3;
                            exception2 = exception;
                            C3095y.m9479c(exception2.toString());
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            if (runnable != null) {
                                runnable.run();
                            }
                            return null;
                        } catch (Throwable th32) {
                            httpURLConnection2 = httpURLConnection3;
                            th = th32;
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            throw th;
                        }
                    } catch (Exception e52) {
                        outputStream = null;
                        HttpURLConnection httpURLConnection4 = httpURLConnection3;
                        exception2 = e52;
                        httpURLConnection = httpURLConnection4;
                        C3095y.m9479c(exception2.toString());
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (runnable != null) {
                            runnable.run();
                        }
                        return null;
                    } catch (Throwable th322) {
                        outputStream = null;
                        httpURLConnection2 = httpURLConnection3;
                        th = th322;
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        throw th;
                    }
                } catch (Exception e6) {
                    exception2 = e6;
                    httpURLConnection = null;
                    outputStream = null;
                    inputStream = null;
                    C3095y.m9479c(exception2.toString());
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                    return null;
                } catch (Throwable th4) {
                    th = th4;
                    outputStream = null;
                    inputStream = null;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    throw th;
                }
                if (runnable != null) {
                    runnable.run();
                }
            }
            return null;
        }
    }

    public static File m9229a(@NonNull String str) {
        File file = new File(m9233d(str));
        String str2 = "Trying to load URL from cache for LiveRailWebView: %s for URL %s %s";
        Object[] objArr = new Object[3];
        objArr[0] = file.exists() ? "hit" : "miss";
        objArr[1] = str;
        objArr[2] = file.exists() ? '(' + file.getAbsolutePath() + ')' : BuildConfig.FLAVOR;
        C3095y.m9471a(String.format(str2, objArr));
        if (file.exists()) {
            return file;
        }
        return null;
    }

    private static String m9233d(@NonNull String str) {
        String a = C3078o.m9413a(str);
        String[] split = str.split("/");
        split = split[split.length - 1].split("\\.");
        Object obj = split[split.length - 1];
        return String.format("/sdcard/%s.%s", new Object[]{a, obj});
    }

    public static void m9230a(String str, Runnable runnable) {
        new C3048a().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[]{str, runnable});
    }

    public static void m9231b(@NonNull String str) {
        boolean z;
        File a = m9229a(str);
        if (a == null || !a.exists()) {
            z = false;
        } else {
            z = a.delete();
        }
        C3095y.m9471a(String.format("Deleted URL from cache: %s (%s)", new Object[]{Boolean.valueOf(z), str}));
    }
}

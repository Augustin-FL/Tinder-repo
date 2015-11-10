package com.mixpanel.android.mpmetrics;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.locks.ReentrantLock;

@TargetApi(14)
public class UpdateDisplayState implements Parcelable {
    public static final Creator<UpdateDisplayState> CREATOR;
    private static final ReentrantLock f2785d;
    private static long f2786e;
    private static UpdateDisplayState f2787f;
    private static int f2788g;
    private static int f2789h;
    private final String f2790a;
    private final String f2791b;
    private final DisplayState f2792c;

    /* renamed from: com.mixpanel.android.mpmetrics.UpdateDisplayState.1 */
    static class C20071 implements Creator<UpdateDisplayState> {
        C20071() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m4635a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m4636a(i);
        }

        public UpdateDisplayState m4635a(Parcel parcel) {
            Bundle bundle = new Bundle(UpdateDisplayState.class.getClassLoader());
            bundle.readFromParcel(parcel);
            return new UpdateDisplayState(null);
        }

        public UpdateDisplayState[] m4636a(int i) {
            return new UpdateDisplayState[i];
        }
    }

    public static class AnswerMap implements Parcelable {
        public static final Creator<AnswerMap> CREATOR;
        private final HashMap<Integer, String> f2776a;

        /* renamed from: com.mixpanel.android.mpmetrics.UpdateDisplayState.AnswerMap.1 */
        static class C20081 implements Creator<AnswerMap> {
            C20081() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m4637a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m4638a(i);
            }

            public AnswerMap m4637a(Parcel parcel) {
                Bundle bundle = new Bundle(AnswerMap.class.getClassLoader());
                AnswerMap answerMap = new AnswerMap();
                bundle.readFromParcel(parcel);
                for (String str : bundle.keySet()) {
                    answerMap.m4640a(Integer.valueOf(str), bundle.getString(str));
                }
                return answerMap;
            }

            public AnswerMap[] m4638a(int i) {
                return new AnswerMap[i];
            }
        }

        @SuppressLint({"UseSparseArrays"})
        public AnswerMap() {
            this.f2776a = new HashMap();
        }

        public void m4640a(Integer num, String str) {
            this.f2776a.put(num, str);
        }

        public String m4639a(Integer num) {
            return (String) this.f2776a.get(num);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Bundle bundle = new Bundle();
            for (Entry entry : this.f2776a.entrySet()) {
                bundle.putString(Integer.toString(((Integer) entry.getKey()).intValue()), (String) entry.getValue());
            }
            parcel.writeBundle(bundle);
        }

        static {
            CREATOR = new C20081();
        }
    }

    public static abstract class DisplayState implements Parcelable {
        public static final Creator<DisplayState> CREATOR;

        /* renamed from: com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.1 */
        static class C20091 implements Creator<DisplayState> {
            C20091() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m4641a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m4642a(i);
            }

            public DisplayState m4641a(Parcel parcel) {
                Bundle bundle = new Bundle(DisplayState.class.getClassLoader());
                bundle.readFromParcel(parcel);
                String string = bundle.getString("com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.STATE_TYPE_KEY");
                Bundle bundle2 = bundle.getBundle("com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.STATE_IMPL_KEY");
                if ("InAppNotificationState".equals(string)) {
                    return new InAppNotificationState(null);
                }
                if ("SurveyState".equals(string)) {
                    return new SurveyState(null);
                }
                throw new RuntimeException("Unrecognized display state type " + string);
            }

            public DisplayState[] m4642a(int i) {
                return new DisplayState[i];
            }
        }

        public static final class InAppNotificationState extends DisplayState {
            public static final Creator<InAppNotificationState> CREATOR;
            private static String f2777c;
            private static String f2778d;
            private final InAppNotification f2779a;
            private final int f2780b;

            /* renamed from: com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.InAppNotificationState.1 */
            static class C20101 implements Creator<InAppNotificationState> {
                C20101() {
                }

                public /* synthetic */ Object createFromParcel(Parcel parcel) {
                    return m4643a(parcel);
                }

                public /* synthetic */ Object[] newArray(int i) {
                    return m4644a(i);
                }

                public InAppNotificationState m4643a(Parcel parcel) {
                    Bundle bundle = new Bundle(InAppNotificationState.class.getClassLoader());
                    bundle.readFromParcel(parcel);
                    return new InAppNotificationState(null);
                }

                public InAppNotificationState[] m4644a(int i) {
                    return new InAppNotificationState[i];
                }
            }

            static {
                CREATOR = new C20101();
                f2777c = "com.com.mixpanel.android.mpmetrics.UpdateDisplayState.InAppNotificationState.INAPP_KEY";
                f2778d = "com.com.mixpanel.android.mpmetrics.UpdateDisplayState.InAppNotificationState.HIGHLIGHT_KEY";
            }

            public InAppNotificationState(InAppNotification inAppNotification, int i) {
                super();
                this.f2779a = inAppNotification;
                this.f2780b = i;
            }

            public int m4647b() {
                return this.f2780b;
            }

            public InAppNotification m4648c() {
                return this.f2779a;
            }

            public String m4646a() {
                return "InAppNotificationState";
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(f2777c, this.f2779a);
                bundle.putInt(f2778d, this.f2780b);
                parcel.writeBundle(bundle);
            }

            private InAppNotificationState(Bundle bundle) {
                super();
                this.f2779a = (InAppNotification) bundle.getParcelable(f2777c);
                this.f2780b = bundle.getInt(f2778d);
            }
        }

        public static final class SurveyState extends DisplayState {
            public static final Creator<SurveyState> CREATOR;
            private final Survey f2781a;
            private final AnswerMap f2782b;
            private Bitmap f2783c;
            private int f2784d;

            /* renamed from: com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.SurveyState.1 */
            static class C20111 implements Creator<SurveyState> {
                C20111() {
                }

                public /* synthetic */ Object createFromParcel(Parcel parcel) {
                    return m4649a(parcel);
                }

                public /* synthetic */ Object[] newArray(int i) {
                    return m4650a(i);
                }

                public SurveyState m4649a(Parcel parcel) {
                    Bundle bundle = new Bundle(SurveyState.class.getClassLoader());
                    bundle.readFromParcel(parcel);
                    return new SurveyState(null);
                }

                public SurveyState[] m4650a(int i) {
                    return new SurveyState[i];
                }
            }

            static {
                CREATOR = new C20111();
            }

            public SurveyState(Survey survey) {
                super();
                this.f2781a = survey;
                this.f2782b = new AnswerMap();
                this.f2784d = ViewCompat.MEASURED_STATE_MASK;
                this.f2783c = null;
            }

            public void m4653a(Bitmap bitmap) {
                this.f2783c = bitmap;
            }

            public void m4652a(int i) {
                this.f2784d = i;
            }

            public Bitmap m4654b() {
                return this.f2783c;
            }

            public AnswerMap m4655c() {
                return this.f2782b;
            }

            public Survey m4656d() {
                return this.f2781a;
            }

            public String m4651a() {
                return "SurveyState";
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                Bundle bundle = new Bundle();
                bundle.putInt("com.mixpanel.android.mpmetrics.UpdateDisplayState.HIGHLIGHT_COLOR_BUNDLE_KEY", this.f2784d);
                bundle.putParcelable("com.mixpanel.android.mpmetrics.UpdateDisplayState.ANSWERS_BUNDLE_KEY", this.f2782b);
                byte[] bArr = null;
                if (this.f2783c != null) {
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    this.f2783c.compress(CompressFormat.PNG, 20, byteArrayOutputStream);
                    bArr = byteArrayOutputStream.toByteArray();
                }
                bundle.putByteArray("com.mixpanel.android.mpmetrics.UpdateDisplayState.BACKGROUND_COMPRESSED_BUNDLE_KEY", bArr);
                bundle.putParcelable("com.mixpanel.android.mpmetrics.UpdateDisplayState.SURVEY_BUNDLE_KEY", this.f2781a);
                parcel.writeBundle(bundle);
            }

            private SurveyState(Bundle bundle) {
                super();
                this.f2784d = bundle.getInt("com.mixpanel.android.mpmetrics.UpdateDisplayState.HIGHLIGHT_COLOR_BUNDLE_KEY");
                this.f2782b = (AnswerMap) bundle.getParcelable("com.mixpanel.android.mpmetrics.UpdateDisplayState.ANSWERS_BUNDLE_KEY");
                byte[] byteArray = bundle.getByteArray("com.mixpanel.android.mpmetrics.UpdateDisplayState.BACKGROUND_COMPRESSED_BUNDLE_KEY");
                if (byteArray != null) {
                    this.f2783c = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                } else {
                    this.f2783c = null;
                }
                this.f2781a = (Survey) bundle.getParcelable("com.mixpanel.android.mpmetrics.UpdateDisplayState.SURVEY_BUNDLE_KEY");
            }
        }

        public abstract String m4645a();

        private DisplayState() {
        }

        static {
            CREATOR = new C20091();
        }
    }

    static ReentrantLock m4658a() {
        return f2785d;
    }

    static boolean m4661b() {
        if (f2785d.isHeldByCurrentThread()) {
            long currentTimeMillis = System.currentTimeMillis() - f2786e;
            if (f2788g > 0 && currentTimeMillis > 43200000) {
                Log.i("MixpanelAPI UpdateDisplayState", "UpdateDisplayState set long, long ago, without showing.");
                f2787f = null;
            }
            return f2787f != null;
        } else {
            throw new AssertionError();
        }
    }

    static int m4657a(DisplayState displayState, String str, String str2) {
        if (!f2785d.isHeldByCurrentThread()) {
            throw new AssertionError();
        } else if (!m4661b()) {
            f2786e = System.currentTimeMillis();
            f2787f = new UpdateDisplayState(displayState, str, str2);
            f2788g++;
            return f2788g;
        } else if (!C2031g.f2854a) {
            return -1;
        } else {
            Log.d("MixpanelAPI UpdateDisplayState", "Already showing (or cooking) a Mixpanel update, declining to show another.");
            return -1;
        }
    }

    public static void m4659a(int i) {
        f2785d.lock();
        try {
            if (i == f2789h) {
                f2789h = -1;
                f2787f = null;
            }
            f2785d.unlock();
        } catch (Throwable th) {
            f2785d.unlock();
        }
    }

    public static UpdateDisplayState m4660b(int i) {
        UpdateDisplayState updateDisplayState = null;
        f2785d.lock();
        try {
            if (f2789h > 0 && f2789h != i) {
                return updateDisplayState;
            }
            if (f2787f == null) {
                f2785d.unlock();
            } else {
                f2786e = System.currentTimeMillis();
                f2789h = i;
                updateDisplayState = f2787f;
                f2785d.unlock();
            }
            return updateDisplayState;
        } finally {
            f2785d.unlock();
        }
    }

    static {
        CREATOR = new C20071();
        f2785d = new ReentrantLock();
        f2786e = -1;
        f2787f = null;
        f2788g = 0;
        f2789h = -1;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("com.mixpanel.android.mpmetrics.UpdateDisplayState.DISTINCT_ID_BUNDLE_KEY", this.f2790a);
        bundle.putString("com.mixpanel.android.mpmetrics.UpdateDisplayState.TOKEN_BUNDLE_KEY", this.f2791b);
        bundle.putParcelable("com.mixpanel.android.mpmetrics.UpdateDisplayState.DISPLAYSTATE_BUNDLE_KEY", this.f2792c);
        parcel.writeBundle(bundle);
    }

    public DisplayState m4662c() {
        return this.f2792c;
    }

    public String m4663d() {
        return this.f2790a;
    }

    public String m4664e() {
        return this.f2791b;
    }

    UpdateDisplayState(DisplayState displayState, String str, String str2) {
        this.f2790a = str;
        this.f2791b = str2;
        this.f2792c = displayState;
    }

    private UpdateDisplayState(Bundle bundle) {
        this.f2790a = bundle.getString("com.mixpanel.android.mpmetrics.UpdateDisplayState.DISTINCT_ID_BUNDLE_KEY");
        this.f2791b = bundle.getString("com.mixpanel.android.mpmetrics.UpdateDisplayState.TOKEN_BUNDLE_KEY");
        this.f2792c = (DisplayState) bundle.getParcelable("com.mixpanel.android.mpmetrics.UpdateDisplayState.DISPLAYSTATE_BUNDLE_KEY");
    }
}

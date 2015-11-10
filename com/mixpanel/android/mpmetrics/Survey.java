package com.mixpanel.android.mpmetrics;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.share.internal.ShareConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Survey implements Parcelable {
    public static Creator<Survey> f2771a;
    private final JSONObject f2772b;
    private final int f2773c;
    private final int f2774d;
    private final List<C2006a> f2775e;

    /* renamed from: com.mixpanel.android.mpmetrics.Survey.1 */
    static class C20021 implements Creator<Survey> {
        C20021() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m4625a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m4626a(i);
        }

        public Survey m4625a(Parcel parcel) {
            try {
                return new Survey(new JSONObject(parcel.readString()));
            } catch (Throwable e) {
                throw new RuntimeException("Corrupted JSON object written to survey parcel.", e);
            } catch (Throwable e2) {
                throw new RuntimeException("Unexpected or incomplete object written to survey parcel.", e2);
            }
        }

        public Survey[] m4626a(int i) {
            return new Survey[i];
        }
    }

    public enum QuestionType {
        UNKNOWN {
            public String toString() {
                return "*unknown_type*";
            }
        },
        MULTIPLE_CHOICE {
            public String toString() {
                return "multiple_choice";
            }
        },
        TEXT {
            public String toString() {
                return "text";
            }
        };
    }

    /* renamed from: com.mixpanel.android.mpmetrics.Survey.a */
    public class C2006a {
        final /* synthetic */ Survey f2766a;
        private final int f2767b;
        private final String f2768c;
        private final String f2769d;
        private final List<String> f2770e;

        private C2006a(Survey survey, JSONObject jSONObject) throws JSONException, BadDecideObjectException {
            this.f2766a = survey;
            this.f2767b = jSONObject.getInt(ShareConstants.WEB_DIALOG_PARAM_ID);
            this.f2768c = jSONObject.getString("type");
            this.f2769d = jSONObject.getString("prompt");
            List emptyList = Collections.emptyList();
            if (jSONObject.has("extra_data")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("extra_data");
                if (jSONObject2.has("$choices")) {
                    JSONArray jSONArray = jSONObject2.getJSONArray("$choices");
                    List arrayList = new ArrayList(jSONArray.length());
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(jSONArray.getString(i));
                    }
                    emptyList = arrayList;
                }
            }
            this.f2770e = Collections.unmodifiableList(emptyList);
            if (m4630d() == QuestionType.MULTIPLE_CHOICE && this.f2770e.size() == 0) {
                throw new BadDecideObjectException("Question is multiple choice but has no answers:" + jSONObject.toString());
            }
        }

        public int m4627a() {
            return this.f2767b;
        }

        public String m4628b() {
            return this.f2769d;
        }

        public List<String> m4629c() {
            return this.f2770e;
        }

        public QuestionType m4630d() {
            if (QuestionType.MULTIPLE_CHOICE.toString().equals(this.f2768c)) {
                return QuestionType.MULTIPLE_CHOICE;
            }
            if (QuestionType.TEXT.toString().equals(this.f2768c)) {
                return QuestionType.TEXT;
            }
            return QuestionType.UNKNOWN;
        }
    }

    static {
        f2771a = new C20021();
    }

    Survey(JSONObject jSONObject) throws BadDecideObjectException {
        try {
            this.f2772b = jSONObject;
            this.f2773c = jSONObject.getInt(ShareConstants.WEB_DIALOG_PARAM_ID);
            this.f2774d = jSONObject.getJSONArray("collections").getJSONObject(0).getInt(ShareConstants.WEB_DIALOG_PARAM_ID);
            JSONArray jSONArray = jSONObject.getJSONArray("questions");
            if (jSONArray.length() == 0) {
                throw new BadDecideObjectException("Survey has no questions.");
            }
            List arrayList = new ArrayList(jSONArray.length());
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(new C2006a(jSONArray.getJSONObject(i), null));
            }
            this.f2775e = Collections.unmodifiableList(arrayList);
        } catch (Throwable e) {
            throw new BadDecideObjectException("Survey JSON was unexpected or bad", e);
        }
    }

    String m4631a() {
        return this.f2772b.toString();
    }

    public int m4632b() {
        return this.f2773c;
    }

    public int m4633c() {
        return this.f2774d;
    }

    public List<C2006a> m4634d() {
        return this.f2775e;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m4631a());
    }
}

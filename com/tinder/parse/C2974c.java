package com.tinder.parse;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.stream.JsonReader;
import com.tinder.enums.Gender;
import com.tinder.managers.ManagerApp;
import com.tinder.model.Match;
import com.tinder.model.Message;
import com.tinder.model.Person;
import com.tinder.model.PhotoUser;
import com.tinder.model.ProcessedPhoto;
import com.tinder.utils.C3070i;
import com.tinder.utils.C3095y;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.tinder.parse.c */
public class C2974c {
    public static Match m8915a(@NonNull JSONObject jSONObject, boolean z) throws JSONException {
        String string;
        C3095y.m9471a("jsonObjectMatch=" + jSONObject);
        if (jSONObject.has("_id")) {
            string = jSONObject.getString("_id");
        } else if (!jSONObject.has(ShareConstants.WEB_DIALOG_PARAM_ID)) {
            return null;
        } else {
            string = jSONObject.getString(ShareConstants.WEB_DIALOG_PARAM_ID);
        }
        C3095y.m9471a("matchId=" + string);
        boolean optBoolean = jSONObject.optBoolean("following", true);
        String string2 = jSONObject.getString("last_activity_date");
        String string3 = jSONObject.getString("created_date");
        JSONArray jSONArray = jSONObject.getJSONArray("messages");
        TreeSet treeSet = new TreeSet();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            String string4 = jSONObject2.getString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            String string5 = jSONObject2.getString("from");
            String string6 = jSONObject2.getString("created_date");
            treeSet.add(new Message(string, string6, string5, string4, z, C3070i.m9362a(string6)));
        }
        Person person = null;
        if (jSONObject.has("person")) {
            jSONObject2 = jSONObject.getJSONObject("person");
            string5 = jSONObject2.getString("_id");
            string4 = jSONObject2.getString(ShareConstants.WEB_DIALOG_PARAM_NAME);
            Gender gender = jSONObject2.optInt("gender", 0) == 0 ? Gender.MALE : Gender.FEMALE;
            JSONArray jSONArray2 = jSONObject2.getJSONArray("photos");
            boolean optBoolean2 = jSONObject2.optBoolean("is_verified", false);
            List arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                arrayList.add(C2974c.m8918a(jSONArray2.getJSONObject(i2), string5));
            }
            person = new Person(string5, string4, arrayList, gender, optBoolean2);
        }
        boolean optBoolean3 = jSONObject.optBoolean("is_super_like", false);
        String optString = jSONObject.optString("super_liker");
        C3095y.m9471a("matchparse: isSuperlike:" + optBoolean3);
        return new Match(person, string, null, treeSet, string2, string3, optBoolean, optBoolean3, optString);
    }

    @NonNull
    private static PhotoUser m8918a(@NonNull JSONObject jSONObject, String str) throws JSONException {
        String string = jSONObject.getString(ShareConstants.WEB_DIALOG_PARAM_ID);
        JSONArray jSONArray = jSONObject.getJSONArray("processedFiles");
        List arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            arrayList.add(new ProcessedPhoto(string, str, jSONObject2.getString(NativeProtocol.WEB_DIALOG_URL), jSONObject2.getInt("width"), jSONObject2.getInt("height")));
        }
        return new PhotoUser(null, string, 0, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0, arrayList);
    }

    @Nullable
    public static Match m8914a(@NonNull JsonReader jsonReader) throws IOException {
        DateFormat a = C3070i.m9366a();
        String str = null;
        String str2 = null;
        String str3 = null;
        Person person = null;
        TreeSet treeSet = new TreeSet();
        boolean z = true;
        boolean j = ManagerApp.m7925p().m8295j();
        boolean z2 = false;
        String str4 = null;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            Object obj = -1;
            switch (nextName.hashCode()) {
                case -1730523657:
                    if (nextName.equals("super_liker")) {
                        obj = 8;
                        break;
                    }
                    break;
                case -991716523:
                    if (nextName.equals("person")) {
                        obj = 5;
                        break;
                    }
                    break;
                case -462094004:
                    if (nextName.equals("messages")) {
                        obj = 4;
                        break;
                    }
                    break;
                case 3355:
                    if (nextName.equals(ShareConstants.WEB_DIALOG_PARAM_ID)) {
                        obj = 1;
                        break;
                    }
                    break;
                case 94650:
                    if (nextName.equals("_id")) {
                        obj = null;
                        break;
                    }
                    break;
                case 492793077:
                    if (nextName.equals("last_activity_date")) {
                        obj = 2;
                        break;
                    }
                    break;
                case 586987536:
                    if (nextName.equals("is_super_like")) {
                        obj = 7;
                        break;
                    }
                    break;
                case 765915793:
                    if (nextName.equals("following")) {
                        obj = 6;
                        break;
                    }
                    break;
                case 2002664101:
                    if (nextName.equals("created_date")) {
                        obj = 3;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case C3374b.SmoothProgressBar_spbStyle /*0*/:
                    str = jsonReader.nextString();
                    break;
                case C3374b.SmoothProgressBar_spb_color /*1*/:
                    str = jsonReader.nextString();
                    break;
                case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                    str2 = jsonReader.nextString();
                    try {
                        ManagerApp.m7925p().m8283b(a.parse(str2));
                        break;
                    } catch (Throwable e) {
                        C3095y.m9474a("Failed to parse activity date for comparison", e);
                        break;
                    }
                case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                    str3 = jsonReader.nextString();
                    break;
                case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        treeSet.add(C2974c.m8916a(jsonReader, str, j));
                    }
                    jsonReader.endArray();
                    break;
                case C3374b.SmoothProgressBar_spb_speed /*5*/:
                    person = C2974c.m8920b(jsonReader);
                    break;
                case C3374b.SmoothProgressBar_spb_progressiveStart_speed /*6*/:
                    z = jsonReader.nextBoolean();
                    break;
                case C3374b.SmoothProgressBar_spb_progressiveStop_speed /*7*/:
                    z2 = jsonReader.nextBoolean();
                    break;
                case C3374b.SmoothProgressBar_spb_interpolator /*8*/:
                    str4 = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        C3095y.m9471a("readMatch: isSuperlike:" + z2);
        Match match = new Match(person, str, null, treeSet, str2, str3, z, z2, str4);
        match.setTouched(j);
        if (!treeSet.isEmpty() && ((Message) treeSet.last()).isFromMe()) {
            match.setTouched(true);
        }
        return match;
    }

    @Nullable
    public static Person m8920b(@NonNull JsonReader jsonReader) throws IOException {
        List list = null;
        jsonReader.beginObject();
        boolean z = false;
        Gender gender = null;
        String str = null;
        String str2 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            Object obj = -1;
            switch (nextName.hashCode()) {
                case -1249512767:
                    if (nextName.equals("gender")) {
                        obj = 3;
                        break;
                    }
                    break;
                case -989034367:
                    if (nextName.equals("photos")) {
                        obj = 2;
                        break;
                    }
                    break;
                case 94650:
                    if (nextName.equals("_id")) {
                        obj = null;
                        break;
                    }
                    break;
                case 3373707:
                    if (nextName.equals(ShareConstants.WEB_DIALOG_PARAM_NAME)) {
                        obj = 1;
                        break;
                    }
                    break;
                case 1565553213:
                    if (nextName.equals("is_verified")) {
                        obj = 4;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case C3374b.SmoothProgressBar_spbStyle /*0*/:
                    str2 = jsonReader.nextString();
                    break;
                case C3374b.SmoothProgressBar_spb_color /*1*/:
                    str = jsonReader.nextString();
                    break;
                case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                    list = new ArrayList();
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        list.add(C2974c.m8917a(jsonReader, str2));
                    }
                    jsonReader.endArray();
                    break;
                case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                    if (jsonReader.nextInt() != 0) {
                        gender = Gender.FEMALE;
                        break;
                    }
                    gender = Gender.MALE;
                    break;
                case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                    z = jsonReader.nextBoolean();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                for (ProcessedPhoto userId : ((PhotoUser) it.next()).getProcessedPhotos()) {
                    userId.setUserId(str2);
                }
            }
        }
        return new Person(str2, str, list, gender, z);
    }

    @Nullable
    public static PhotoUser m8917a(@NonNull JsonReader jsonReader, String str) throws IOException {
        String str2 = null;
        ArrayList arrayList = new ArrayList();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextString;
            String nextName = jsonReader.nextName();
            Object obj = -1;
            switch (nextName.hashCode()) {
                case 3355:
                    if (nextName.equals(ShareConstants.WEB_DIALOG_PARAM_ID)) {
                        obj = null;
                        break;
                    }
                    break;
                case 624779209:
                    if (nextName.equals("processedFiles")) {
                        obj = 1;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case C3374b.SmoothProgressBar_spbStyle /*0*/:
                    nextString = jsonReader.nextString();
                    break;
                case C3374b.SmoothProgressBar_spb_color /*1*/:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        arrayList.add(C2974c.m8919a(jsonReader, str, str2));
                    }
                    jsonReader.endArray();
                    nextString = str2;
                    break;
                default:
                    jsonReader.skipValue();
                    nextString = str2;
                    break;
            }
            str2 = nextString;
        }
        jsonReader.endObject();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((ProcessedPhoto) it.next()).setPhotoId(str2);
        }
        return new PhotoUser(str2, arrayList);
    }

    @Nullable
    public static ProcessedPhoto m8919a(@NonNull JsonReader jsonReader, String str, String str2) throws IOException {
        String str3 = null;
        jsonReader.beginObject();
        int i = 0;
        int i2 = 0;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            Object obj = -1;
            switch (nextName.hashCode()) {
                case -1221029593:
                    if (nextName.equals("height")) {
                        obj = 2;
                        break;
                    }
                    break;
                case 116079:
                    try {
                        if (nextName.equals(NativeProtocol.WEB_DIALOG_URL)) {
                            obj = null;
                            break;
                        }
                    } catch (OutOfMemoryError e) {
                        C3095y.m9479c(e.getMessage());
                        break;
                    }
                    break;
                case 113126854:
                    if (nextName.equals("width")) {
                        obj = 1;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case C3374b.SmoothProgressBar_spbStyle /*0*/:
                    str3 = jsonReader.nextString();
                    break;
                case C3374b.SmoothProgressBar_spb_color /*1*/:
                    i2 = jsonReader.nextInt();
                    break;
                case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                    i = jsonReader.nextInt();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new ProcessedPhoto(str2, str, str3, i2, i);
    }

    @NonNull
    public static Message m8916a(@NonNull JsonReader jsonReader, String str, boolean z) throws IOException {
        String str2 = null;
        jsonReader.beginObject();
        String str3 = null;
        String str4 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            Object obj = -1;
            switch (nextName.hashCode()) {
                case 3151786:
                    if (nextName.equals("from")) {
                        obj = 1;
                        break;
                    }
                    break;
                case 484300789:
                    if (nextName.equals("sent_date")) {
                        obj = 2;
                        break;
                    }
                    break;
                case 954925063:
                    if (nextName.equals(ShareConstants.WEB_DIALOG_PARAM_MESSAGE)) {
                        obj = null;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case C3374b.SmoothProgressBar_spbStyle /*0*/:
                    str4 = jsonReader.nextString();
                    break;
                case C3374b.SmoothProgressBar_spb_color /*1*/:
                    str3 = jsonReader.nextString();
                    break;
                case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                    str2 = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new Message(str, str2, str3, str4, z, C3070i.m9362a(str2));
    }
}

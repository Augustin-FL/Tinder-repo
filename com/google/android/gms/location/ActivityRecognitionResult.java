package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.Collections;
import java.util.List;

public class ActivityRecognitionResult implements SafeParcelable {
    public static final ActivityRecognitionResultCreator CREATOR;
    private final int mVersionCode;
    List<DetectedActivity> zzaBt;
    long zzaBu;
    long zzaBv;
    int zzaBw;

    static {
        CREATOR = new ActivityRecognitionResultCreator();
    }

    public ActivityRecognitionResult(int i, List<DetectedActivity> list, long j, long j2, int i2) {
        this.mVersionCode = i;
        this.zzaBt = list;
        this.zzaBu = j;
        this.zzaBv = j2;
        this.zzaBw = i2;
    }

    public ActivityRecognitionResult(DetectedActivity detectedActivity, long j, long j2) {
        this(detectedActivity, j, j2, 0);
    }

    public ActivityRecognitionResult(DetectedActivity detectedActivity, long j, long j2, int i) {
        this(Collections.singletonList(detectedActivity), j, j2, i);
    }

    public ActivityRecognitionResult(List<DetectedActivity> list, long j, long j2) {
        this((List) list, j, j2, 0);
    }

    public ActivityRecognitionResult(List<DetectedActivity> list, long j, long j2, int i) {
        boolean z = true;
        boolean z2 = list != null && list.size() > 0;
        zzx.zzb(z2, (Object) "Must have at least 1 detected activity");
        if (j <= 0 || j2 <= 0) {
            z = false;
        }
        zzx.zzb(z, (Object) "Must set times");
        this.mVersionCode = 2;
        this.zzaBt = list;
        this.zzaBu = j;
        this.zzaBv = j2;
        this.zzaBw = i;
    }

    public static ActivityRecognitionResult extractResult(Intent intent) {
        if (!hasResult(intent)) {
            return null;
        }
        Object obj = intent.getExtras().get("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
        if (!(obj instanceof byte[])) {
            return obj instanceof ActivityRecognitionResult ? (ActivityRecognitionResult) obj : null;
        } else {
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall((byte[]) obj, 0, ((byte[]) obj).length);
            obtain.setDataPosition(0);
            return CREATOR.createFromParcel(obtain);
        }
    }

    public static boolean hasResult(Intent intent) {
        return intent == null ? false : intent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ActivityRecognitionResult activityRecognitionResult = (ActivityRecognitionResult) obj;
        return this.zzaBu == activityRecognitionResult.zzaBu && this.zzaBv == activityRecognitionResult.zzaBv && this.zzaBw == activityRecognitionResult.zzaBw && zzw.equal(this.zzaBt, activityRecognitionResult.zzaBt);
    }

    public int getActivityConfidence(int i) {
        for (DetectedActivity detectedActivity : this.zzaBt) {
            if (detectedActivity.getType() == i) {
                return detectedActivity.getConfidence();
            }
        }
        return 0;
    }

    public long getElapsedRealtimeMillis() {
        return this.zzaBv;
    }

    public DetectedActivity getMostProbableActivity() {
        return (DetectedActivity) this.zzaBt.get(0);
    }

    public List<DetectedActivity> getProbableActivities() {
        return this.zzaBt;
    }

    public long getTime() {
        return this.zzaBu;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzaBu), Long.valueOf(this.zzaBv), Integer.valueOf(this.zzaBw), this.zzaBt);
    }

    public String toString() {
        return "ActivityRecognitionResult [probableActivities=" + this.zzaBt + ", timeMillis=" + this.zzaBu + ", elapsedRealtimeMillis=" + this.zzaBv + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        ActivityRecognitionResultCreator.zza(this, parcel, i);
    }
}

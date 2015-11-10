package com.tinder.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Pair;
import com.facebook.stetho.BuildConfig;
import com.tinder.R;
import com.tinder.enums.AddType;
import com.tinder.enums.MomentAction;
import com.tinder.utils.C3070i;
import com.tinder.utils.ad;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Moment implements Comparable<Moment> {
    @NonNull
    private static String TINDER_MOCK_MOMENT;
    private String mAlignment;
    @Nullable
    private Bitmap mBitmap;
    private final long mCreatedDate;
    private String mFilter;
    private boolean mHasFailed;
    private String mHeight;
    private final String mId;
    private boolean mIsPending;
    @Nullable
    private Map<String, MomentLike> mMapLikes;
    private MomentAction mMomentAction;
    private ad<MomentLike> mMomentLikes;
    private int mNumLikes;
    private Person mPerson;
    private PhotoMoment mPhotoMoment;
    private RatedType mRatedType;
    private String mSize;
    private String mText;
    private String mUserId;

    public enum RatedType {
        PASSED(-1),
        UNRATED(0),
        LIKED(1);
        
        int mConstInt;

        private RatedType(int i) {
            this.mConstInt = i;
        }

        public int getIntConst() {
            return this.mConstInt;
        }
    }

    static {
        TINDER_MOCK_MOMENT = "tinder mock moment woaaaah";
    }

    public Moment(String str, String str2, long j, String str3, PhotoMoment photoMoment, String str4, String str5, String str6, String str7, ArrayList<MomentLike> arrayList, boolean z, MomentAction momentAction) {
        this(str, str2, j, str3, photoMoment, str4, str5, str6, str7, arrayList, z, momentAction, 0);
    }

    public Moment(String str, String str2, long j, String str3, PhotoMoment photoMoment, String str4, String str5, String str6, String str7, @Nullable ArrayList<MomentLike> arrayList, boolean z, @NonNull MomentAction momentAction, int i) {
        this.mRatedType = RatedType.UNRATED;
        this.mId = str;
        this.mUserId = str2;
        this.mCreatedDate = j;
        this.mText = str3;
        this.mPhotoMoment = photoMoment;
        this.mFilter = str4;
        this.mAlignment = str5;
        this.mSize = str6;
        this.mHeight = str7;
        this.mIsPending = z;
        this.mMomentLikes = new ad(false);
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.mMomentLikes.m9216a((MomentLike) it.next());
            }
        }
        this.mMomentAction = momentAction;
        this.mMapLikes = null;
        this.mNumLikes = i;
    }

    public Moment(String str, String str2, String str3, String str4, String str5) {
        this(null, null, System.currentTimeMillis(), str, null, str2, str3, str4, str5, new ArrayList(), false, MomentAction.CREATE);
    }

    public Moment(String str, long j, int i) {
        this.mRatedType = RatedType.UNRATED;
        String[] strArr = new String[]{str, str, str, str, str};
        this.mId = TINDER_MOCK_MOMENT + i;
        this.mUserId = TINDER_MOCK_MOMENT;
        this.mCreatedDate = j;
        this.mText = BuildConfig.FLAVOR;
        this.mPhotoMoment = new PhotoMoment(TINDER_MOCK_MOMENT, strArr);
        this.mFilter = BuildConfig.FLAVOR;
        this.mAlignment = BuildConfig.FLAVOR;
        this.mSize = BuildConfig.FLAVOR;
        this.mHeight = BuildConfig.FLAVOR;
        this.mIsPending = false;
        this.mMomentLikes = new ad(false);
        this.mMapLikes = null;
        this.mMomentAction = MomentAction.CREATE;
    }

    public static boolean isMockMoment(@Nullable String str) {
        return str != null && str.contains(TINDER_MOCK_MOMENT);
    }

    public boolean isMockMoment() {
        return this.mId != null && this.mId.contains(TINDER_MOCK_MOMENT);
    }

    @Nullable
    public String getTimeAgo(@NonNull Context context) {
        if (this.mCreatedDate > System.currentTimeMillis()) {
            return C3070i.m9364a(context.getString(R.string.now), new Date(System.currentTimeMillis()));
        }
        return C3070i.m9364a(context.getString(R.string.now), new Date(this.mCreatedDate));
    }

    public boolean hasBeenRated() {
        return !this.mRatedType.equals(RatedType.UNRATED);
    }

    public boolean hasBeenLiked() {
        return this.mRatedType.equals(RatedType.LIKED);
    }

    public boolean hasBeenPassed() {
        return this.mRatedType.equals(RatedType.PASSED);
    }

    public RatedType getRatedType() {
        return this.mRatedType;
    }

    public void setRatedType(RatedType ratedType) {
        this.mRatedType = ratedType;
    }

    public void setHasFailed(boolean z) {
        this.mHasFailed = z;
    }

    public boolean hasFailed() {
        return this.mHasFailed;
    }

    public Person getPerson() {
        return this.mPerson;
    }

    public void setPerson(Person person) {
        this.mPerson = person;
    }

    public String getId() {
        return this.mId;
    }

    public String getUserId() {
        return this.mUserId;
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public long getCreatedTime() {
        return this.mCreatedDate;
    }

    public String getText() {
        return this.mText;
    }

    public PhotoMoment getMomentPhoto() {
        return this.mPhotoMoment;
    }

    public String getFilter() {
        return this.mFilter;
    }

    public String getAlignment() {
        return this.mAlignment;
    }

    public String getSize() {
        return this.mSize;
    }

    public String getHeight() {
        return this.mHeight;
    }

    public int getNumLikes() {
        return Math.max(this.mNumLikes, this.mMomentLikes.m9214a());
    }

    @NonNull
    public List<MomentLike> getMomentLikes() {
        return this.mMomentLikes.m9220c();
    }

    @NonNull
    public AddType addLike(@NonNull MomentLike momentLike) {
        if (this.mMomentLikes == null) {
            this.mMomentLikes = new ad(false);
        }
        if (this.mMapLikes == null) {
            this.mMapLikes = new HashMap(1);
        }
        if (this.mMapLikes.containsKey(momentLike.getMixedId())) {
            MomentLike momentLike2 = (MomentLike) this.mMapLikes.get(momentLike.getMixedId());
            if (momentLike.compareTo((BaseMessage) momentLike2) <= 0) {
                return AddType.OLD;
            }
            this.mMomentLikes.m9221c(momentLike2);
            this.mMomentLikes.m9216a((Comparable) momentLike);
            return AddType.NEWER;
        }
        this.mMapLikes.put(momentLike.getMixedId(), momentLike);
        this.mMomentLikes.m9216a((Comparable) momentLike);
        return AddType.NEW;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() - this.mCreatedDate > 86400000;
    }

    public int getHoursLeft() {
        return (int) Math.ceil((double) ((86400000 - (System.currentTimeMillis() - this.mCreatedDate)) / 3600000));
    }

    @NonNull
    public Pair<Integer, Integer> getHoursMinutesLeft() {
        long currentTimeMillis = 86400000 - (System.currentTimeMillis() - this.mCreatedDate);
        int ceil = (int) Math.ceil((double) (currentTimeMillis / 3600000));
        int ceil2 = (int) Math.ceil((double) (currentTimeMillis / 60000));
        if (ceil2 != 60) {
            ceil2 %= 60;
        }
        return new Pair(Integer.valueOf(ceil), Integer.valueOf(ceil2));
    }

    @Nullable
    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public boolean isPending() {
        return this.mIsPending;
    }

    public void setIsPending(boolean z) {
        this.mIsPending = z;
    }

    @NonNull
    public MomentAction getAction() {
        return this.mMomentAction;
    }

    public void clearBitmap() {
        if (this.mBitmap != null) {
            this.mBitmap.recycle();
        }
        this.mBitmap = null;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null || !(obj instanceof Moment)) {
            return false;
        }
        return this.mId.equals(((Moment) obj).mId);
    }

    @NonNull
    public String toString() {
        return "id: " + this.mId + " person: " + this.mPerson + " text: " + this.mText + " momentLikesCount: " + this.mMomentLikes.m9214a() + " date: " + this.mCreatedDate;
    }

    public int compareTo(@Nullable Moment moment) {
        if (moment == null) {
            return 1;
        }
        if (this.mCreatedDate < moment.mCreatedDate) {
            return -1;
        }
        if (this.mCreatedDate <= moment.mCreatedDate) {
            return 0;
        }
        return 1;
    }
}

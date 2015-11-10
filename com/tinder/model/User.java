package com.tinder.model;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.facebook.stetho.BuildConfig;
import com.tinder.R;
import com.tinder.enums.Gender;
import com.tinder.enums.PhotoSizeUser;
import com.tinder.managers.C2957o;
import com.tinder.p032c.C2423e;
import com.tinder.utils.C3070i;
import com.tinder.utils.C3095y;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class User implements C2423e, Serializable {
    private static final String PROXIMITY_IN = "in";
    private static final String PROXIMITY_NEAR = "near";
    private String mBio;
    @Nullable
    private Date mBirthDate;
    private List<String> mCommonFriends;
    private List<Interest> mCommonInterests;
    private List<String> mCommonLikes;
    private ConnectionsGroup mConnections;
    private int mDistanceMiles;
    private String mFacebookId;
    private Gender mGender;
    private String mId;
    private InstagramDataSet mInstagramDataSet;
    private ArrayList<Gender> mInterestedIn;
    private boolean mIsBrand;
    private boolean mIsRecAndPassporting;
    private boolean mIsSuperlike;
    private boolean mIsVerified;
    private String mLastActivityDate;
    private String mName;
    private String mNearByLocationName;
    private String mNearByLocationProximity;
    private int mNumConnections;
    private ArrayList<PhotoUser> mPhotoUsers;
    private String mPingLocationName;
    private Date mPingTime;
    private int mTravelDistanceMiles;
    private String mTravelLocationName;
    private List<Interest> mUncommonInterests;

    public User(String str, @Nullable Date date, String str2, String str3, Date date2, int i, String str4, Gender gender, ArrayList<Gender> arrayList, ArrayList<PhotoUser> arrayList2, String str5, boolean z, boolean z2, boolean z3) {
        this();
        this.mBio = str;
        this.mBirthDate = date;
        this.mId = str2;
        this.mName = str3;
        this.mPingTime = date2;
        this.mDistanceMiles = i;
        this.mFacebookId = str4;
        this.mGender = gender;
        this.mInterestedIn = arrayList;
        this.mPhotoUsers = arrayList2;
        this.mCommonFriends = new ArrayList();
        this.mLastActivityDate = str5;
        this.mIsVerified = z;
        this.mIsSuperlike = z2;
        this.mIsBrand = z3;
    }

    public User(String str, String str2, @Nullable Date date, String str3, Date date2, Gender gender, List<String> list, List<String> list2, int i, ArrayList<PhotoUser> arrayList, String str4, String str5, String str6, boolean z, boolean z2, boolean z3) {
        this();
        this.mBio = str2;
        this.mBirthDate = date;
        this.mId = str3;
        this.mPingTime = date2;
        this.mGender = gender;
        this.mName = str;
        this.mCommonFriends = list;
        this.mCommonLikes = list2;
        this.mDistanceMiles = i;
        this.mLastActivityDate = str4;
        this.mPhotoUsers = arrayList;
        this.mNearByLocationName = str5;
        this.mNearByLocationProximity = str6;
        this.mIsVerified = z;
        this.mIsSuperlike = z2;
        this.mIsBrand = z3;
    }

    public User() {
        this.mLastActivityDate = BuildConfig.FLAVOR;
        this.mCommonInterests = new ArrayList(0);
        this.mUncommonInterests = new ArrayList(0);
    }

    @Nullable
    public ConnectionsGroup getConnections() {
        return this.mConnections;
    }

    public void setConnections(ConnectionsGroup connectionsGroup) {
        this.mConnections = connectionsGroup;
    }

    public int getNumConnections() {
        return Math.max(this.mNumConnections, this.mConnections == null ? 0 : this.mConnections.size());
    }

    public void setNumConnections(int i) {
        this.mNumConnections = i;
    }

    public List<Interest> getCommonInterests() {
        return this.mCommonInterests;
    }

    public void setCommonInterests(List<Interest> list) {
        this.mCommonInterests = list;
    }

    public int getNumCommonInterests() {
        return this.mCommonInterests == null ? 0 : this.mCommonInterests.size();
    }

    public List<Interest> getUncommonInterests() {
        return this.mUncommonInterests;
    }

    public void setUncommonInterests(List<Interest> list) {
        this.mUncommonInterests = list;
    }

    public boolean isRecAndPassporting() {
        return this.mIsRecAndPassporting;
    }

    public void setRecAndPassporting(boolean z) {
        this.mIsRecAndPassporting = z;
    }

    public List<String> getCommonFriendIds() {
        return this.mCommonFriends;
    }

    public List<String> getCommonLikes() {
        return this.mCommonLikes;
    }

    public String getBio() {
        if (this.mBio == null) {
            return BuildConfig.FLAVOR;
        }
        return this.mBio;
    }

    @Nullable
    public Date getBirthDate() {
        return this.mBirthDate;
    }

    public int getDistance(@NonNull C2957o c2957o) {
        if (c2957o.m8763e()) {
            return this.mDistanceMiles;
        }
        return (int) (((float) this.mDistanceMiles) * 1.60934f);
    }

    public int getDistanceMiles() {
        return this.mDistanceMiles;
    }

    public String getFacebookId() {
        return this.mFacebookId;
    }

    public Gender getGender() {
        return this.mGender;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public ArrayList<PhotoUser> getPhotos() {
        return this.mPhotoUsers;
    }

    public void setPhotos(ArrayList<PhotoUser> arrayList) {
        this.mPhotoUsers = arrayList;
    }

    public int getPhotoCount() {
        return this.mPhotoUsers.size();
    }

    public List<InstagramPhoto> getInstagramPhotos() {
        if (this.mInstagramDataSet != null) {
            return this.mInstagramDataSet.getInstagramPhotos();
        }
        return Collections.emptyList();
    }

    public InstagramDataSet getInstagramDataSet() {
        return this.mInstagramDataSet;
    }

    public void setInstagramDataSet(InstagramDataSet instagramDataSet) {
        this.mInstagramDataSet = instagramDataSet;
    }

    public Date getPingTime() {
        return this.mPingTime;
    }

    public int getCommonFriendCount() {
        if (this.mCommonFriends == null) {
            return 0;
        }
        return this.mCommonFriends.size();
    }

    public int getCommonLikeCount() {
        if (this.mCommonLikes == null) {
            return 0;
        }
        return this.mCommonLikes.size();
    }

    public boolean isInterestedInMales() {
        if (this.mInterestedIn == null) {
            return false;
        }
        Iterator it = this.mInterestedIn.iterator();
        while (it.hasNext()) {
            if (((Gender) it.next()).equals(Gender.MALE)) {
                return true;
            }
        }
        return false;
    }

    public boolean isInterestedInFemales() {
        if (this.mInterestedIn == null) {
            return false;
        }
        Iterator it = this.mInterestedIn.iterator();
        while (it.hasNext()) {
            if (((Gender) it.next()).equals(Gender.FEMALE)) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    public ArrayList<String> getAvatarUrlsForSize(PhotoSizeUser photoSizeUser) {
        ArrayList<String> arrayList = new ArrayList();
        Iterator it = this.mPhotoUsers.iterator();
        while (it.hasNext()) {
            for (ProcessedPhoto processedPhoto : ((PhotoUser) it.next()).getProcessedPhotos()) {
                if (processedPhoto.getPhotoSize() == photoSizeUser) {
                    arrayList.add(processedPhoto.getImageUrl());
                }
            }
        }
        return arrayList;
    }

    @Nullable
    public ProcessedPhoto getDisplayPhoto() {
        if (hasPhotos()) {
            List processedPhotos = ((PhotoUser) this.mPhotoUsers.get(0)).getProcessedPhotos();
            if (processedPhotos != null && processedPhotos.size() > 0) {
                return (ProcessedPhoto) processedPhotos.get(0);
            }
        }
        C3095y.m9476b("No photos");
        return null;
    }

    @Nullable
    public String getAge() {
        if (this.mBirthDate != null) {
            return Integer.toString(C3070i.m9361a(this.mBirthDate));
        }
        return null;
    }

    public String getLastActivityDate() {
        return this.mLastActivityDate;
    }

    @NonNull
    public ArrayList<String> getOtherPhotoIds(int i) {
        ArrayList<String> arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.mPhotoUsers.size(); i2++) {
            if (i2 != i) {
                arrayList.add(((PhotoUser) this.mPhotoUsers.get(i2)).getPhotoId());
            }
        }
        return arrayList;
    }

    @NonNull
    public ArrayList<String> getOtherPhotoIds(String str) {
        ArrayList<String> arrayList = new ArrayList();
        for (int i = 0; i < this.mPhotoUsers.size(); i++) {
            if (!((PhotoUser) this.mPhotoUsers.get(i)).getPhotoId().equals(str)) {
                arrayList.add(((PhotoUser) this.mPhotoUsers.get(i)).getPhotoId());
            }
        }
        return arrayList;
    }

    public void setInterestedIn(ArrayList<Gender> arrayList) {
        this.mInterestedIn = arrayList;
    }

    public boolean hasLargeImage(String str) {
        Iterator it = getAvatarUrlsForSize(PhotoSizeUser.LARGE).iterator();
        while (it.hasNext()) {
            if (((String) it.next()).equals(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasPhotos() {
        return this.mPhotoUsers != null && this.mPhotoUsers.size() > 0;
    }

    public String getThumbnailUrl() {
        if (getMainPhoto() == null) {
            return BuildConfig.FLAVOR;
        }
        return getMainPhoto().getProcessedPhoto(PhotoSizeUser.SMALL).getImageUrl();
    }

    @Nullable
    public PhotoUser getMainPhoto() {
        if (hasPhotos()) {
            return (PhotoUser) this.mPhotoUsers.get(0);
        }
        return null;
    }

    public String getTravelLocationName() {
        return this.mTravelLocationName;
    }

    public void setTravelLocationName(String str) {
        this.mTravelLocationName = str;
    }

    public int getTravelDistanceMiles() {
        return this.mTravelDistanceMiles;
    }

    public void setTravelDistanceMiles(int i) {
        this.mTravelDistanceMiles = i;
    }

    public String getPingLocationName() {
        return this.mPingLocationName;
    }

    public void setPingLocationName(String str) {
        this.mPingLocationName = str;
    }

    @NonNull
    public String getNearByLocation(@NonNull Resources resources) {
        String str = BuildConfig.FLAVOR;
        if (TextUtils.equals(this.mNearByLocationProximity, PROXIMITY_IN)) {
            str = resources.getString(R.string.near_city_location_proximity_in);
        } else if (TextUtils.equals(this.mNearByLocationProximity, PROXIMITY_NEAR)) {
            str = resources.getString(R.string.near_city_location_proximity_near);
        }
        return str + " " + this.mNearByLocationName;
    }

    public String getNearByLocationName() {
        return this.mNearByLocationName;
    }

    public void setNearByLocationName(String str) {
        this.mNearByLocationName = str;
    }

    public String getNearByLocationProximity() {
        return this.mNearByLocationProximity;
    }

    public void setNearByLocationProximity(String str) {
        this.mNearByLocationProximity = str;
    }

    public boolean equals(Object obj) {
        if (obj instanceof User) {
            return ((User) obj).getId().equals(getId());
        }
        return false;
    }

    @NonNull
    public String toString() {
        return "ID: " + this.mId + " Name: " + this.mName + " Num Photos: " + this.mPhotoUsers.size();
    }

    public boolean isVerified() {
        return this.mIsVerified;
    }

    public boolean isSuperLike() {
        return this.mIsSuperlike;
    }

    public boolean isBrand() {
        return this.mIsBrand;
    }
}

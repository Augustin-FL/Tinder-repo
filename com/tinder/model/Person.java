package com.tinder.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.facebook.stetho.BuildConfig;
import com.tinder.enums.Gender;
import com.tinder.enums.PhotoSizeUser;
import com.tinder.utils.C3095y;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable {
    @Nullable
    private Gender mGender;
    private final String mId;
    private boolean mIsVerified;
    private final String mName;
    private List<PhotoUser> mPhotoUsers;

    public Person(String str, String str2, List<PhotoUser> list, @Nullable Gender gender, boolean z) {
        this.mGender = Gender.MALE;
        this.mId = str;
        this.mName = str2;
        this.mPhotoUsers = list;
        this.mGender = gender;
        this.mIsVerified = z;
    }

    public Person(String str, String str2, @Nullable Gender gender, boolean z) {
        this.mGender = Gender.MALE;
        this.mId = str;
        this.mName = str2;
        this.mPhotoUsers = new ArrayList();
        this.mGender = gender;
        this.mIsVerified = z;
    }

    public void addPhoto(PhotoUser photoUser) {
        this.mPhotoUsers.add(photoUser);
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    @Nullable
    public Gender getGender() {
        return this.mGender;
    }

    public boolean isVerified() {
        return this.mIsVerified;
    }

    public String getAvatarUrl(int i, PhotoSizeUser photoSizeUser) {
        if (this.mPhotoUsers.size() > i) {
            PhotoUser photoUser = (PhotoUser) this.mPhotoUsers.get(i);
            if (photoUser != null) {
                ProcessedPhoto processedPhoto = photoUser.getProcessedPhoto(photoSizeUser);
                if (processedPhoto != null) {
                    return processedPhoto.getImageUrl();
                }
                C3095y.m9476b("Couldn't find processed photo at that size");
                return BuildConfig.FLAVOR;
            }
            C3095y.m9476b("Couldn't find photo at that position");
        } else {
            C3095y.m9476b("Not enough photos");
        }
        return BuildConfig.FLAVOR;
    }

    @NonNull
    public List<String> getAvatarUrlsForSize(PhotoSizeUser photoSizeUser) {
        List<String> arrayList = new ArrayList();
        for (PhotoUser processedPhoto : this.mPhotoUsers) {
            ProcessedPhoto processedPhoto2 = processedPhoto.getProcessedPhoto(photoSizeUser);
            if (processedPhoto2 != null) {
                arrayList.add(processedPhoto2.getImageUrl());
            }
        }
        return arrayList;
    }

    public List<PhotoUser> getPhotos() {
        return this.mPhotoUsers;
    }

    public void setPhotos(List<PhotoUser> list) {
        this.mPhotoUsers = list;
    }

    @NonNull
    public String toString() {
        return "(id: " + this.mId + " name: " + this.mName + ')';
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Person person = (Person) obj;
        if (this.mId != null) {
            if (this.mId.equals(person.mId)) {
                return true;
            }
        } else if (person.mId == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.mId != null ? this.mId.hashCode() : 0;
    }
}

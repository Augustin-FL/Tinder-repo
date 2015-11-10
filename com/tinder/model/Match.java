package com.tinder.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.facebook.stetho.BuildConfig;
import com.tinder.enums.PhotoSizeUser;
import com.tinder.p032c.C2423e;
import com.tinder.utils.C3070i;
import com.tinder.utils.C3095y;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Match implements C2423e, Serializable, Comparable<Match> {
    private static final TreeSet<Message> EMPTY_SET;
    public static final int REPORTED_ABUSIVE_CONTENT_MASK = 2;
    public static final int REPORTED_BAD_OFFLINE_BEHAVIOR = 9;
    public static final int REPORTED_INAPPROPRIATE_PHOTOS = 5;
    public static final int REPORTED_OTHER = 7;
    public static final int REPORTED_SPAM_MASK = 1;
    static final long serialVersionUID = 4285871404555324967L;
    private final String mCreatedDate;
    private String mDraftMsg;
    private String mFormattedCreatedDate;
    private final String mId;
    private boolean mIsFollowed;
    private boolean mIsSuperlike;
    private final String mLastActivityDate;
    @Nullable
    private TreeSet<Message> mMessages;
    @Nullable
    private String[] mParticipants;
    private Person mPerson;
    private int mReportedMasks;
    @NonNull
    private Set<String> mSeenMessages;
    private String mSuperLiker;
    private boolean mTouched;
    private boolean mViewed;

    static {
        EMPTY_SET = new TreeSet();
    }

    public Match(Person person, String str, @Nullable String[] strArr, @Nullable TreeSet<Message> treeSet, String str2, String str3, boolean z, boolean z2, String str4) {
        this.mSeenMessages = new HashSet();
        this.mDraftMsg = BuildConfig.FLAVOR;
        this.mPerson = person;
        this.mId = str;
        this.mParticipants = strArr;
        this.mMessages = treeSet;
        this.mLastActivityDate = str2;
        this.mCreatedDate = str3;
        this.mIsFollowed = z;
        this.mIsSuperlike = z2;
        this.mSuperLiker = str4;
        if (treeSet != null) {
            Iterator descendingIterator = treeSet.descendingIterator();
            while (descendingIterator.hasNext()) {
                Message message = (Message) descendingIterator.next();
                if (!this.mSeenMessages.contains(message.getCreationDate())) {
                    this.mSeenMessages.add(message.getCreationDate());
                }
            }
        }
    }

    public Match(Person person, String str, @Nullable String[] strArr, String str2, String str3, boolean z, boolean z2, String str4) {
        this.mSeenMessages = new HashSet();
        this.mDraftMsg = BuildConfig.FLAVOR;
        this.mPerson = person;
        this.mId = str;
        this.mParticipants = strArr;
        this.mMessages = null;
        this.mLastActivityDate = str2;
        this.mCreatedDate = str3;
        this.mIsFollowed = z;
        this.mIsSuperlike = z2;
        this.mSuperLiker = str4;
    }

    public String getLatestTimestamp() {
        String str;
        String str2 = this.mCreatedDate;
        if (str2 == null || this.mLastActivityDate.compareTo(str2) > 0) {
            str = this.mLastActivityDate;
        } else {
            str = str2;
        }
        if (this.mMessages == null || this.mMessages.isEmpty()) {
            return str;
        }
        str2 = ((Message) this.mMessages.last()).getCreationDate();
        if (str2 == null || str2.compareTo(str) <= 0) {
            return str;
        }
        return str2;
    }

    public void setIsFollowed(boolean z) {
        this.mIsFollowed = z;
    }

    public boolean isFollowed() {
        return this.mIsFollowed;
    }

    public boolean isSuperlike() {
        return this.mIsSuperlike;
    }

    public String getSuperLiker() {
        return this.mSuperLiker;
    }

    public boolean superLikerIsThem() {
        return isTheSuperLiker(this.mPerson.getId());
    }

    public boolean isTheSuperLiker(@NonNull String str) {
        return str.equalsIgnoreCase(this.mSuperLiker);
    }

    public boolean isTheSuperLiker(User user) {
        return user == null ? false : isTheSuperLiker(user.getId());
    }

    public int getReportedMasks() {
        return this.mReportedMasks;
    }

    public void setReportedMasks(int i) {
        this.mReportedMasks = i;
    }

    public void addReportedMask(int i) {
        this.mReportedMasks |= i;
    }

    public String getFormattedCreatedDate() {
        return this.mFormattedCreatedDate;
    }

    public void setFormattedCreatedDate(String str) {
        this.mFormattedCreatedDate = str;
    }

    public boolean isLastMsgFromMe() {
        if (this.mMessages == null || this.mMessages.size() <= 0 || !((Message) this.mMessages.last()).isFromMe()) {
            return false;
        }
        return true;
    }

    public void addPhoto(PhotoUser photoUser) {
        this.mPerson.addPhoto(photoUser);
    }

    public void addPreviousMessages(@NonNull TreeSet<Message> treeSet) {
        if (treeSet.size() > 0) {
            Iterator descendingIterator = treeSet.descendingIterator();
            while (descendingIterator.hasNext()) {
                Message message = (Message) descendingIterator.next();
                if (!this.mSeenMessages.contains(message.getCreationDate())) {
                    this.mSeenMessages.add(message.getCreationDate());
                    if (this.mMessages == null) {
                        this.mMessages = new TreeSet();
                    }
                    this.mMessages.add(message);
                }
            }
        }
    }

    public void addMessage(@NonNull Message message) {
        if (!this.mSeenMessages.contains(message.getCreationDate())) {
            this.mSeenMessages.add(message.getCreationDate());
            if (this.mMessages == null) {
                this.mMessages = new TreeSet();
            }
            this.mMessages.add(message);
        }
    }

    public String getDraftMsg() {
        return this.mDraftMsg;
    }

    public void setDraftMsg(String str) {
        this.mDraftMsg = str;
    }

    public boolean isTouched() {
        return this.mTouched;
    }

    public void setTouched(boolean z) {
        this.mTouched = z;
    }

    public void setViewed(boolean z) {
        this.mViewed = z;
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

    @Nullable
    public String[] getParticipants() {
        return this.mParticipants;
    }

    @NonNull
    public TreeSet<Message> getMessages() {
        if (this.mMessages == null) {
            return EMPTY_SET;
        }
        return this.mMessages;
    }

    public void setMessages(TreeSet<Message> treeSet) {
        this.mMessages = treeSet;
    }

    public boolean hasNewMessage() {
        if (this.mMessages == null || this.mMessages.isEmpty() || wasTouched()) {
            return false;
        }
        if (((Message) this.mMessages.last()).isFromMe()) {
            return false;
        }
        return true;
    }

    public String getLastActivityDate() {
        return this.mLastActivityDate;
    }

    @Nullable
    public String getCreatedDate() {
        return this.mCreatedDate;
    }

    public boolean wasTouched() {
        return this.mTouched;
    }

    public boolean wasViewed() {
        return this.mViewed;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Match match = (Match) obj;
        if (this.mId != null) {
            if (this.mId.equals(match.mId)) {
                return true;
            }
        } else if (match.mId == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.mId != null ? this.mId.hashCode() : 0;
    }

    @NonNull
    public String toString() {
        if (this.mPerson != null) {
            return "Name: " + this.mPerson.getName() + " id: " + this.mId;
        }
        return "id: " + this.mId;
    }

    public String getName() {
        String name = this.mPerson.getName();
        if (name == null) {
            return BuildConfig.FLAVOR;
        }
        return name;
    }

    public String getThumbnailUrl() {
        if (this.mPerson == null || this.mPerson.getPhotos().size() <= 0) {
            return BuildConfig.FLAVOR;
        }
        return this.mPerson.getAvatarUrl(0, PhotoSizeUser.XSMALL);
    }

    public boolean hasMessageFromMe() {
        if (this.mMessages == null) {
            return false;
        }
        Iterator it = this.mMessages.iterator();
        while (it.hasNext()) {
            if (((Message) it.next()).isFromMe()) {
                return true;
            }
        }
        return false;
    }

    public int compareTo(@NonNull Match match) {
        try {
            return C3070i.m9360a(match.mLastActivityDate, this.mLastActivityDate);
        } catch (Throwable e) {
            C3095y.m9474a("Failed to parse match activity dates.", e);
            return 0;
        }
    }

    public boolean isVerified() {
        return this.mPerson == null ? false : this.mPerson.isVerified();
    }
}

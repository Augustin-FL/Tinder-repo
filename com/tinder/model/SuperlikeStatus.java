package com.tinder.model;

import com.tinder.utils.C3070i;
import com.tinder.utils.C3095y;
import java.util.Date;

public class SuperlikeStatus {
    private int mAllotment;
    private int mRemaining;
    private String mResetDate;

    public int getRemaining() {
        return this.mRemaining;
    }

    public void setRemaining(int i) {
        this.mRemaining = i;
    }

    public int getAllotment() {
        return this.mAllotment;
    }

    public void setAllotment(int i) {
        this.mAllotment = i;
    }

    public String getResetDate() {
        return this.mResetDate;
    }

    public void setResetDate(String str) {
        this.mResetDate = str;
    }

    public boolean isOutOfSuperlikes() {
        C3095y.m9471a("resetDate is set to:" + this.mResetDate);
        if (this.mResetDate != null && !this.mResetDate.equalsIgnoreCase("null")) {
            try {
                Date parse = C3070i.m9369b().parse(this.mResetDate);
                if (this.mRemaining >= 1 || parse.getTime() <= System.currentTimeMillis()) {
                    return false;
                }
                return true;
            } catch (Throwable e) {
                C3095y.m9474a("parsing reset date in Super Like Status", e);
                if (this.mRemaining >= 1) {
                    return false;
                }
                return true;
            }
        } else if (this.mRemaining < 1) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("superlikes: [");
        stringBuilder.append("remaining:" + this.mRemaining);
        stringBuilder.append(",allotment:" + this.mAllotment);
        stringBuilder.append(",reset date:" + this.mResetDate);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

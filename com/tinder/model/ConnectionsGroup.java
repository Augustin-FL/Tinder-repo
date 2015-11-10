package com.tinder.model;

import android.support.annotation.NonNull;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConnectionsGroup implements Serializable {
    private static final DegreeComparator COMPARATOR;
    private List<CommonConnection> mCompleteCxns;
    private boolean mIgnoreUnbuilt;
    @NonNull
    private HashMap<String, CommonConnection> mUnbuiltCxns;

    private static class DegreeComparator implements Comparator<CommonConnection> {
        private DegreeComparator() {
        }

        public int compare(@NonNull CommonConnection commonConnection, @NonNull CommonConnection commonConnection2) {
            int degree = commonConnection.getDegree();
            int degree2 = commonConnection2.getDegree();
            if (degree > degree2) {
                return 1;
            }
            if (degree == degree2) {
                return 0;
            }
            return -1;
        }
    }

    static {
        COMPARATOR = new DegreeComparator();
    }

    public ConnectionsGroup(List<CommonConnection> list, @NonNull List<CommonConnection> list2) {
        this.mCompleteCxns = list;
        this.mUnbuiltCxns = new HashMap();
        buildMap(list2);
        sort();
    }

    private void buildMap(@NonNull List<CommonConnection> list) {
        for (CommonConnection commonConnection : list) {
            this.mUnbuiltCxns.put(commonConnection.getId(), commonConnection);
        }
    }

    @NonNull
    public List<String> getUnbuiltIds() {
        return Arrays.asList(this.mUnbuiltCxns.keySet().toArray(new String[this.mUnbuiltCxns.size()]));
    }

    @NonNull
    public Map<String, CommonConnection> getUnbuiltConnections() {
        return this.mUnbuiltCxns;
    }

    public List<CommonConnection> getCompleteConnections() {
        return this.mCompleteCxns;
    }

    public boolean needsFill() {
        return !this.mIgnoreUnbuilt && this.mUnbuiltCxns.size() > 0;
    }

    public boolean getIgnoreUnresolvableIds() {
        return this.mIgnoreUnbuilt;
    }

    public void setIgnoreUnresolvableIds(boolean z) {
        this.mIgnoreUnbuilt = z;
    }

    public int size() {
        return this.mUnbuiltCxns.size() + this.mCompleteCxns.size();
    }

    public void fillIn(@NonNull List<CommonConnection> list) {
        for (CommonConnection commonConnection : list) {
            String id = commonConnection.getId();
            if (this.mUnbuiltCxns.containsKey(id)) {
                this.mUnbuiltCxns.remove(id);
                this.mCompleteCxns.add(commonConnection);
            }
        }
        sort();
    }

    public int getDegreeCount(int i) {
        int i2;
        int i3;
        if (this.mCompleteCxns != null) {
            i2 = 0;
            for (CommonConnection degree : this.mCompleteCxns) {
                if (degree.getDegree() == i) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                i2 = i3 + i2;
            }
        } else {
            i2 = 0;
        }
        if (!this.mUnbuiltCxns.isEmpty()) {
            for (CommonConnection degree2 : this.mUnbuiltCxns.values()) {
                if (degree2.getDegree() == i) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                i2 += i3;
            }
        }
        return i2;
    }

    public void sort() {
        Collections.sort(this.mCompleteCxns, COMPARATOR);
    }
}

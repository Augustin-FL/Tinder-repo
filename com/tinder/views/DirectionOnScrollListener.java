package com.tinder.views;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseArray;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

public class DirectionOnScrollListener implements OnScrollListener {
    private static final int MIN_SCROLL_DELTA = 10;
    private boolean mIsScrollingUp;
    private AbsListView mListView;
    private ListenerScrollDirection mListenerScrollDirection;
    private ListViewScrollTracker mScrollTracker;

    public interface ListenerScrollDirection {
        void onLastItemShown();

        void onScrollDown();

        void onScrollUp();

        void onTopItemScrolled(float f);
    }

    public class ListViewScrollTracker {
        private AbsListView mListView;
        @Nullable
        private SparseArray<Integer> mPositions;

        public ListViewScrollTracker(AbsListView absListView) {
            this.mListView = absListView;
        }

        public int calculateIncrementalOffset(int i, int i2) {
            int i3;
            SparseArray sparseArray = this.mPositions;
            this.mPositions = new SparseArray();
            for (i3 = 0; i3 < i2; i3++) {
                this.mPositions.put(i + i3, Integer.valueOf(this.mListView.getChildAt(i3).getTop()));
            }
            if (sparseArray != null) {
                for (i3 = 0; i3 < sparseArray.size(); i3++) {
                    int keyAt = sparseArray.keyAt(i3);
                    int intValue = ((Integer) sparseArray.get(keyAt)).intValue();
                    Integer num = (Integer) this.mPositions.get(keyAt);
                    if (num != null) {
                        return num.intValue() - intValue;
                    }
                }
            }
            return 11;
        }

        public void clear() {
            this.mPositions = null;
        }
    }

    public DirectionOnScrollListener(AbsListView absListView, ListenerScrollDirection listenerScrollDirection) {
        this.mListView = absListView;
        this.mScrollTracker = new ListViewScrollTracker(absListView);
        this.mListenerScrollDirection = listenerScrollDirection;
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    public void onScroll(@NonNull AbsListView absListView, int i, int i2, int i3) {
        int calculateIncrementalOffset = this.mScrollTracker.calculateIncrementalOffset(i, i2);
        if (Math.abs(calculateIncrementalOffset) > MIN_SCROLL_DELTA) {
            boolean z = calculateIncrementalOffset > 0;
            if (z != this.mIsScrollingUp) {
                this.mIsScrollingUp = z;
                if (this.mIsScrollingUp) {
                    this.mListenerScrollDirection.onScrollUp();
                } else {
                    this.mListenerScrollDirection.onScrollDown();
                }
            }
        }
        if (this.mListView.getId() == absListView.getId()) {
            if (this.mListView.getChildCount() > 0) {
                if (i == 0) {
                    this.mListenerScrollDirection.onTopItemScrolled(Math.abs(this.mListView.getChildAt(0).getY() / ((float) this.mListView.getChildAt(0).getHeight())));
                } else {
                    this.mListenerScrollDirection.onTopItemScrolled(1.0f);
                }
            }
            if (i + i2 == i3) {
                this.mListenerScrollDirection.onLastItemShown();
            }
        }
    }
}

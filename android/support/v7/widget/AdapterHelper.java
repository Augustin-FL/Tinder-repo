package android.support.v7.widget;

import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SimplePool;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

class AdapterHelper implements Callback {
    private static final boolean DEBUG = false;
    static final int POSITION_TYPE_INVISIBLE = 0;
    static final int POSITION_TYPE_NEW_OR_LAID_OUT = 1;
    private static final String TAG = "AHT";
    final Callback mCallback;
    final boolean mDisableRecycler;
    Runnable mOnItemProcessedCallback;
    final OpReorderer mOpReorderer;
    final ArrayList<UpdateOp> mPendingUpdates;
    final ArrayList<UpdateOp> mPostponedList;
    private Pool<UpdateOp> mUpdateOpPool;

    interface Callback {
        ViewHolder findViewHolder(int i);

        void markViewHoldersUpdated(int i, int i2);

        void offsetPositionsForAdd(int i, int i2);

        void offsetPositionsForMove(int i, int i2);

        void offsetPositionsForRemovingInvisible(int i, int i2);

        void offsetPositionsForRemovingLaidOutOrNewView(int i, int i2);

        void onDispatchFirstPass(UpdateOp updateOp);

        void onDispatchSecondPass(UpdateOp updateOp);
    }

    static class UpdateOp {
        static final int ADD = 0;
        static final int MOVE = 3;
        static final int POOL_SIZE = 30;
        static final int REMOVE = 1;
        static final int UPDATE = 2;
        int cmd;
        int itemCount;
        int positionStart;

        UpdateOp(int i, int i2, int i3) {
            this.cmd = i;
            this.positionStart = i2;
            this.itemCount = i3;
        }

        String cmdToString() {
            switch (this.cmd) {
                case ADD /*0*/:
                    return ProductAction.ACTION_ADD;
                case REMOVE /*1*/:
                    return "rm";
                case UPDATE /*2*/:
                    return "up";
                case MOVE /*3*/:
                    return "mv";
                default:
                    return "??";
            }
        }

        public String toString() {
            return "[" + cmdToString() + ",s:" + this.positionStart + "c:" + this.itemCount + "]";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return AdapterHelper.DEBUG;
            }
            UpdateOp updateOp = (UpdateOp) obj;
            if (this.cmd != updateOp.cmd) {
                return AdapterHelper.DEBUG;
            }
            if (this.cmd == MOVE && Math.abs(this.itemCount - this.positionStart) == REMOVE && this.itemCount == updateOp.positionStart && this.positionStart == updateOp.itemCount) {
                return true;
            }
            if (this.itemCount != updateOp.itemCount) {
                return AdapterHelper.DEBUG;
            }
            if (this.positionStart != updateOp.positionStart) {
                return AdapterHelper.DEBUG;
            }
            return true;
        }

        public int hashCode() {
            return (((this.cmd * 31) + this.positionStart) * 31) + this.itemCount;
        }
    }

    AdapterHelper(Callback callback) {
        this(callback, DEBUG);
    }

    AdapterHelper(Callback callback, boolean z) {
        this.mUpdateOpPool = new SimplePool(30);
        this.mPendingUpdates = new ArrayList();
        this.mPostponedList = new ArrayList();
        this.mCallback = callback;
        this.mDisableRecycler = z;
        this.mOpReorderer = new OpReorderer(this);
    }

    AdapterHelper addUpdateOp(UpdateOp... updateOpArr) {
        Collections.addAll(this.mPendingUpdates, updateOpArr);
        return this;
    }

    void reset() {
        recycleUpdateOpsAndClearList(this.mPendingUpdates);
        recycleUpdateOpsAndClearList(this.mPostponedList);
    }

    void preProcess() {
        this.mOpReorderer.reorderOps(this.mPendingUpdates);
        int size = this.mPendingUpdates.size();
        for (int i = POSITION_TYPE_INVISIBLE; i < size; i += POSITION_TYPE_NEW_OR_LAID_OUT) {
            UpdateOp updateOp = (UpdateOp) this.mPendingUpdates.get(i);
            switch (updateOp.cmd) {
                case POSITION_TYPE_INVISIBLE /*0*/:
                    applyAdd(updateOp);
                    break;
                case POSITION_TYPE_NEW_OR_LAID_OUT /*1*/:
                    applyRemove(updateOp);
                    break;
                case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                    applyUpdate(updateOp);
                    break;
                case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                    applyMove(updateOp);
                    break;
            }
            if (this.mOnItemProcessedCallback != null) {
                this.mOnItemProcessedCallback.run();
            }
        }
        this.mPendingUpdates.clear();
    }

    void consumePostponedUpdates() {
        int size = this.mPostponedList.size();
        for (int i = POSITION_TYPE_INVISIBLE; i < size; i += POSITION_TYPE_NEW_OR_LAID_OUT) {
            this.mCallback.onDispatchSecondPass((UpdateOp) this.mPostponedList.get(i));
        }
        recycleUpdateOpsAndClearList(this.mPostponedList);
    }

    private void applyMove(UpdateOp updateOp) {
        postponeAndUpdateViewHolders(updateOp);
    }

    private void applyRemove(UpdateOp updateOp) {
        int i = updateOp.positionStart;
        int i2 = updateOp.positionStart + updateOp.itemCount;
        int i3 = -1;
        int i4 = updateOp.positionStart;
        int i5 = POSITION_TYPE_INVISIBLE;
        while (i4 < i2) {
            int i6;
            if (this.mCallback.findViewHolder(i4) != null || canFindInPreLayout(i4)) {
                if (i3 == 0) {
                    dispatchAndUpdateViewHolders(obtainUpdateOp(POSITION_TYPE_NEW_OR_LAID_OUT, i, i5));
                    i6 = POSITION_TYPE_NEW_OR_LAID_OUT;
                } else {
                    i6 = POSITION_TYPE_INVISIBLE;
                }
                i3 = POSITION_TYPE_NEW_OR_LAID_OUT;
            } else {
                if (i3 == POSITION_TYPE_NEW_OR_LAID_OUT) {
                    postponeAndUpdateViewHolders(obtainUpdateOp(POSITION_TYPE_NEW_OR_LAID_OUT, i, i5));
                    i6 = POSITION_TYPE_NEW_OR_LAID_OUT;
                } else {
                    i6 = POSITION_TYPE_INVISIBLE;
                }
                i3 = POSITION_TYPE_INVISIBLE;
            }
            if (i6 != 0) {
                i6 = i4 - i5;
                i4 = i2 - i5;
                i2 = POSITION_TYPE_NEW_OR_LAID_OUT;
            } else {
                int i7 = i4;
                i4 = i2;
                i2 = i5 + POSITION_TYPE_NEW_OR_LAID_OUT;
                i6 = i7;
            }
            i5 = i2;
            i2 = i4;
            i4 = i6 + POSITION_TYPE_NEW_OR_LAID_OUT;
        }
        if (i5 != updateOp.itemCount) {
            recycleUpdateOp(updateOp);
            updateOp = obtainUpdateOp(POSITION_TYPE_NEW_OR_LAID_OUT, i, i5);
        }
        if (i3 == 0) {
            dispatchAndUpdateViewHolders(updateOp);
        } else {
            postponeAndUpdateViewHolders(updateOp);
        }
    }

    private void applyUpdate(UpdateOp updateOp) {
        int i = updateOp.positionStart;
        int i2 = updateOp.positionStart + updateOp.itemCount;
        int i3 = updateOp.positionStart;
        Object obj = -1;
        int i4 = POSITION_TYPE_INVISIBLE;
        while (i3 < i2) {
            int i5;
            Object obj2;
            if (this.mCallback.findViewHolder(i3) != null || canFindInPreLayout(i3)) {
                if (obj == null) {
                    dispatchAndUpdateViewHolders(obtainUpdateOp(2, i, i4));
                    i4 = POSITION_TYPE_INVISIBLE;
                    i = i3;
                }
                i5 = i;
                i = i4;
                obj2 = POSITION_TYPE_NEW_OR_LAID_OUT;
            } else {
                if (obj == POSITION_TYPE_NEW_OR_LAID_OUT) {
                    postponeAndUpdateViewHolders(obtainUpdateOp(2, i, i4));
                    i4 = POSITION_TYPE_INVISIBLE;
                    i = i3;
                }
                i5 = i;
                i = i4;
                obj2 = POSITION_TYPE_INVISIBLE;
            }
            i3 += POSITION_TYPE_NEW_OR_LAID_OUT;
            Object obj3 = obj2;
            i4 = i + POSITION_TYPE_NEW_OR_LAID_OUT;
            i = i5;
            obj = obj3;
        }
        if (i4 != updateOp.itemCount) {
            recycleUpdateOp(updateOp);
            updateOp = obtainUpdateOp(2, i, i4);
        }
        if (obj == null) {
            dispatchAndUpdateViewHolders(updateOp);
        } else {
            postponeAndUpdateViewHolders(updateOp);
        }
    }

    private void dispatchAndUpdateViewHolders(UpdateOp updateOp) {
        if (updateOp.cmd == 0 || updateOp.cmd == 3) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int i;
        int updatePositionWithPostponed = updatePositionWithPostponed(updateOp.positionStart, updateOp.cmd);
        int i2 = updateOp.positionStart;
        switch (updateOp.cmd) {
            case POSITION_TYPE_NEW_OR_LAID_OUT /*1*/:
                i = POSITION_TYPE_INVISIBLE;
                break;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                i = POSITION_TYPE_NEW_OR_LAID_OUT;
                break;
            default:
                throw new IllegalArgumentException("op should be remove or update." + updateOp);
        }
        int i3 = POSITION_TYPE_NEW_OR_LAID_OUT;
        int i4 = updatePositionWithPostponed;
        updatePositionWithPostponed = i2;
        for (i2 = POSITION_TYPE_NEW_OR_LAID_OUT; i2 < updateOp.itemCount; i2 += POSITION_TYPE_NEW_OR_LAID_OUT) {
            Object obj;
            int updatePositionWithPostponed2 = updatePositionWithPostponed(updateOp.positionStart + (i * i2), updateOp.cmd);
            switch (updateOp.cmd) {
                case POSITION_TYPE_NEW_OR_LAID_OUT /*1*/:
                    if (updatePositionWithPostponed2 != i4) {
                        obj = POSITION_TYPE_INVISIBLE;
                        break;
                    } else {
                        obj = POSITION_TYPE_NEW_OR_LAID_OUT;
                        break;
                    }
                case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                    if (updatePositionWithPostponed2 != i4 + POSITION_TYPE_NEW_OR_LAID_OUT) {
                        obj = POSITION_TYPE_INVISIBLE;
                        break;
                    } else {
                        obj = POSITION_TYPE_NEW_OR_LAID_OUT;
                        break;
                    }
                default:
                    obj = POSITION_TYPE_INVISIBLE;
                    break;
            }
            if (obj != null) {
                i3 += POSITION_TYPE_NEW_OR_LAID_OUT;
            } else {
                UpdateOp obtainUpdateOp = obtainUpdateOp(updateOp.cmd, i4, i3);
                dispatchFirstPassAndUpdateViewHolders(obtainUpdateOp, updatePositionWithPostponed);
                recycleUpdateOp(obtainUpdateOp);
                if (updateOp.cmd == 2) {
                    updatePositionWithPostponed += i3;
                }
                i3 = POSITION_TYPE_NEW_OR_LAID_OUT;
                i4 = updatePositionWithPostponed2;
            }
        }
        recycleUpdateOp(updateOp);
        if (i3 > 0) {
            UpdateOp obtainUpdateOp2 = obtainUpdateOp(updateOp.cmd, i4, i3);
            dispatchFirstPassAndUpdateViewHolders(obtainUpdateOp2, updatePositionWithPostponed);
            recycleUpdateOp(obtainUpdateOp2);
        }
    }

    void dispatchFirstPassAndUpdateViewHolders(UpdateOp updateOp, int i) {
        this.mCallback.onDispatchFirstPass(updateOp);
        switch (updateOp.cmd) {
            case POSITION_TYPE_NEW_OR_LAID_OUT /*1*/:
                this.mCallback.offsetPositionsForRemovingInvisible(i, updateOp.itemCount);
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                this.mCallback.markViewHoldersUpdated(i, updateOp.itemCount);
            default:
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    private int updatePositionWithPostponed(int i, int i2) {
        int i3;
        int i4 = i;
        for (int size = this.mPostponedList.size() - 1; size >= 0; size--) {
            UpdateOp updateOp = (UpdateOp) this.mPostponedList.get(size);
            if (updateOp.cmd == 3) {
                int i5;
                int i6;
                if (updateOp.positionStart < updateOp.itemCount) {
                    i5 = updateOp.positionStart;
                    i3 = updateOp.itemCount;
                } else {
                    i5 = updateOp.itemCount;
                    i3 = updateOp.positionStart;
                }
                if (i4 < i5 || i4 > r2) {
                    if (i4 < updateOp.positionStart) {
                        if (i2 == 0) {
                            updateOp.positionStart += POSITION_TYPE_NEW_OR_LAID_OUT;
                            updateOp.itemCount += POSITION_TYPE_NEW_OR_LAID_OUT;
                            i6 = i4;
                        } else if (i2 == POSITION_TYPE_NEW_OR_LAID_OUT) {
                            updateOp.positionStart--;
                            updateOp.itemCount--;
                        }
                    }
                    i6 = i4;
                } else if (i5 == updateOp.positionStart) {
                    if (i2 == 0) {
                        updateOp.itemCount += POSITION_TYPE_NEW_OR_LAID_OUT;
                    } else if (i2 == POSITION_TYPE_NEW_OR_LAID_OUT) {
                        updateOp.itemCount--;
                    }
                    i6 = i4 + POSITION_TYPE_NEW_OR_LAID_OUT;
                } else {
                    if (i2 == 0) {
                        updateOp.positionStart += POSITION_TYPE_NEW_OR_LAID_OUT;
                    } else if (i2 == POSITION_TYPE_NEW_OR_LAID_OUT) {
                        updateOp.positionStart--;
                    }
                    i6 = i4 - 1;
                }
                i4 = i6;
            } else if (updateOp.positionStart <= i4) {
                if (updateOp.cmd == 0) {
                    i4 -= updateOp.itemCount;
                } else if (updateOp.cmd == POSITION_TYPE_NEW_OR_LAID_OUT) {
                    i4 += updateOp.itemCount;
                }
            } else if (i2 == 0) {
                updateOp.positionStart += POSITION_TYPE_NEW_OR_LAID_OUT;
            } else if (i2 == POSITION_TYPE_NEW_OR_LAID_OUT) {
                updateOp.positionStart--;
            }
        }
        for (i3 = this.mPostponedList.size() - 1; i3 >= 0; i3--) {
            updateOp = (UpdateOp) this.mPostponedList.get(i3);
            if (updateOp.cmd == 3) {
                if (updateOp.itemCount == updateOp.positionStart || updateOp.itemCount < 0) {
                    this.mPostponedList.remove(i3);
                    recycleUpdateOp(updateOp);
                }
            } else if (updateOp.itemCount <= 0) {
                this.mPostponedList.remove(i3);
                recycleUpdateOp(updateOp);
            }
        }
        return i4;
    }

    private boolean canFindInPreLayout(int i) {
        int size = this.mPostponedList.size();
        for (int i2 = POSITION_TYPE_INVISIBLE; i2 < size; i2 += POSITION_TYPE_NEW_OR_LAID_OUT) {
            UpdateOp updateOp = (UpdateOp) this.mPostponedList.get(i2);
            if (updateOp.cmd == 3) {
                if (findPositionOffset(updateOp.itemCount, i2 + POSITION_TYPE_NEW_OR_LAID_OUT) == i) {
                    return true;
                }
            } else if (updateOp.cmd == 0) {
                int i3 = updateOp.positionStart + updateOp.itemCount;
                for (int i4 = updateOp.positionStart; i4 < i3; i4 += POSITION_TYPE_NEW_OR_LAID_OUT) {
                    if (findPositionOffset(i4, i2 + POSITION_TYPE_NEW_OR_LAID_OUT) == i) {
                        return true;
                    }
                }
                continue;
            } else {
                continue;
            }
        }
        return DEBUG;
    }

    private void applyAdd(UpdateOp updateOp) {
        postponeAndUpdateViewHolders(updateOp);
    }

    private void postponeAndUpdateViewHolders(UpdateOp updateOp) {
        this.mPostponedList.add(updateOp);
        switch (updateOp.cmd) {
            case POSITION_TYPE_INVISIBLE /*0*/:
                this.mCallback.offsetPositionsForAdd(updateOp.positionStart, updateOp.itemCount);
            case POSITION_TYPE_NEW_OR_LAID_OUT /*1*/:
                this.mCallback.offsetPositionsForRemovingLaidOutOrNewView(updateOp.positionStart, updateOp.itemCount);
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                this.mCallback.markViewHoldersUpdated(updateOp.positionStart, updateOp.itemCount);
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                this.mCallback.offsetPositionsForMove(updateOp.positionStart, updateOp.itemCount);
            default:
                throw new IllegalArgumentException("Unknown update op type for " + updateOp);
        }
    }

    boolean hasPendingUpdates() {
        return this.mPendingUpdates.size() > 0 ? true : DEBUG;
    }

    int findPositionOffset(int i) {
        return findPositionOffset(i, POSITION_TYPE_INVISIBLE);
    }

    int findPositionOffset(int i, int i2) {
        int size = this.mPostponedList.size();
        int i3 = i;
        while (i2 < size) {
            UpdateOp updateOp = (UpdateOp) this.mPostponedList.get(i2);
            if (updateOp.cmd == 3) {
                if (updateOp.positionStart == i3) {
                    i3 = updateOp.itemCount;
                } else {
                    if (updateOp.positionStart < i3) {
                        i3--;
                    }
                    if (updateOp.itemCount <= i3) {
                        i3 += POSITION_TYPE_NEW_OR_LAID_OUT;
                    }
                }
            } else if (updateOp.positionStart > i3) {
                continue;
            } else if (updateOp.cmd == POSITION_TYPE_NEW_OR_LAID_OUT) {
                if (i3 < updateOp.positionStart + updateOp.itemCount) {
                    return -1;
                }
                i3 -= updateOp.itemCount;
            } else if (updateOp.cmd == 0) {
                i3 += updateOp.itemCount;
            }
            i2 += POSITION_TYPE_NEW_OR_LAID_OUT;
        }
        return i3;
    }

    boolean onItemRangeChanged(int i, int i2) {
        this.mPendingUpdates.add(obtainUpdateOp(2, i, i2));
        if (this.mPendingUpdates.size() == POSITION_TYPE_NEW_OR_LAID_OUT) {
            return true;
        }
        return DEBUG;
    }

    boolean onItemRangeInserted(int i, int i2) {
        this.mPendingUpdates.add(obtainUpdateOp(POSITION_TYPE_INVISIBLE, i, i2));
        if (this.mPendingUpdates.size() == POSITION_TYPE_NEW_OR_LAID_OUT) {
            return true;
        }
        return DEBUG;
    }

    boolean onItemRangeRemoved(int i, int i2) {
        this.mPendingUpdates.add(obtainUpdateOp(POSITION_TYPE_NEW_OR_LAID_OUT, i, i2));
        if (this.mPendingUpdates.size() == POSITION_TYPE_NEW_OR_LAID_OUT) {
            return true;
        }
        return DEBUG;
    }

    boolean onItemRangeMoved(int i, int i2, int i3) {
        boolean z = true;
        if (i == i2) {
            return DEBUG;
        }
        if (i3 != POSITION_TYPE_NEW_OR_LAID_OUT) {
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        this.mPendingUpdates.add(obtainUpdateOp(3, i, i2));
        if (this.mPendingUpdates.size() != POSITION_TYPE_NEW_OR_LAID_OUT) {
            z = DEBUG;
        }
        return z;
    }

    void consumeUpdatesInOnePass() {
        consumePostponedUpdates();
        int size = this.mPendingUpdates.size();
        for (int i = POSITION_TYPE_INVISIBLE; i < size; i += POSITION_TYPE_NEW_OR_LAID_OUT) {
            UpdateOp updateOp = (UpdateOp) this.mPendingUpdates.get(i);
            switch (updateOp.cmd) {
                case POSITION_TYPE_INVISIBLE /*0*/:
                    this.mCallback.onDispatchSecondPass(updateOp);
                    this.mCallback.offsetPositionsForAdd(updateOp.positionStart, updateOp.itemCount);
                    break;
                case POSITION_TYPE_NEW_OR_LAID_OUT /*1*/:
                    this.mCallback.onDispatchSecondPass(updateOp);
                    this.mCallback.offsetPositionsForRemovingInvisible(updateOp.positionStart, updateOp.itemCount);
                    break;
                case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                    this.mCallback.onDispatchSecondPass(updateOp);
                    this.mCallback.markViewHoldersUpdated(updateOp.positionStart, updateOp.itemCount);
                    break;
                case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                    this.mCallback.onDispatchSecondPass(updateOp);
                    this.mCallback.offsetPositionsForMove(updateOp.positionStart, updateOp.itemCount);
                    break;
            }
            if (this.mOnItemProcessedCallback != null) {
                this.mOnItemProcessedCallback.run();
            }
        }
        recycleUpdateOpsAndClearList(this.mPendingUpdates);
    }

    public int applyPendingUpdatesToPosition(int i) {
        int size = this.mPendingUpdates.size();
        int i2 = i;
        for (int i3 = POSITION_TYPE_INVISIBLE; i3 < size; i3 += POSITION_TYPE_NEW_OR_LAID_OUT) {
            UpdateOp updateOp = (UpdateOp) this.mPendingUpdates.get(i3);
            switch (updateOp.cmd) {
                case POSITION_TYPE_INVISIBLE /*0*/:
                    if (updateOp.positionStart > i2) {
                        break;
                    }
                    i2 += updateOp.itemCount;
                    break;
                case POSITION_TYPE_NEW_OR_LAID_OUT /*1*/:
                    if (updateOp.positionStart <= i2) {
                        if (updateOp.positionStart + updateOp.itemCount <= i2) {
                            i2 -= updateOp.itemCount;
                            break;
                        }
                        return -1;
                    }
                    continue;
                case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                    if (updateOp.positionStart != i2) {
                        if (updateOp.positionStart < i2) {
                            i2--;
                        }
                        if (updateOp.itemCount > i2) {
                            break;
                        }
                        i2 += POSITION_TYPE_NEW_OR_LAID_OUT;
                        break;
                    }
                    i2 = updateOp.itemCount;
                    break;
                default:
                    break;
            }
        }
        return i2;
    }

    public UpdateOp obtainUpdateOp(int i, int i2, int i3) {
        UpdateOp updateOp = (UpdateOp) this.mUpdateOpPool.acquire();
        if (updateOp == null) {
            return new UpdateOp(i, i2, i3);
        }
        updateOp.cmd = i;
        updateOp.positionStart = i2;
        updateOp.itemCount = i3;
        return updateOp;
    }

    public void recycleUpdateOp(UpdateOp updateOp) {
        if (!this.mDisableRecycler) {
            this.mUpdateOpPool.release(updateOp);
        }
    }

    void recycleUpdateOpsAndClearList(List<UpdateOp> list) {
        int size = list.size();
        for (int i = POSITION_TYPE_INVISIBLE; i < size; i += POSITION_TYPE_NEW_OR_LAID_OUT) {
            recycleUpdateOp((UpdateOp) list.get(i));
        }
        list.clear();
    }
}

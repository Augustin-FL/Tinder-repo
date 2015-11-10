package com.tinder.views;

import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public abstract class FragmentTagPagerAdapter extends PagerAdapter {
    private static final boolean DEBUG = false;
    private static final String TAG = "FragmentPagerAdapter";
    @Nullable
    private FragmentTransaction mCurTransaction;
    @Nullable
    private Fragment mCurrentPrimaryItem;
    private final FragmentManager mFragmentManager;

    @Nullable
    public abstract Fragment getItem(int i);

    public FragmentTagPagerAdapter(FragmentManager fragmentManager) {
        this.mCurTransaction = null;
        this.mCurrentPrimaryItem = null;
        this.mFragmentManager = fragmentManager;
    }

    @NonNull
    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void startUpdate(ViewGroup viewGroup) {
    }

    @Nullable
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.beginTransaction();
        }
        long itemId = getItemId(i);
        Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(viewGroup.getId(), itemId));
        if (findFragmentByTag == null) {
            findFragmentByTag = getItem(i);
            this.mCurTransaction.add(viewGroup.getId(), findFragmentByTag, makeFragmentName(viewGroup.getId(), itemId));
        } else if (isCorrectFragment(i, findFragmentByTag)) {
            this.mCurTransaction.attach(findFragmentByTag);
        } else {
            this.mCurTransaction.remove(findFragmentByTag);
            findFragmentByTag = getItem(i);
            this.mCurTransaction.add(viewGroup.getId(), findFragmentByTag, makeFragmentName(viewGroup.getId(), itemId));
        }
        if (!(findFragmentByTag == this.mCurrentPrimaryItem || findFragmentByTag == null)) {
            findFragmentByTag.setMenuVisibility(DEBUG);
            findFragmentByTag.setUserVisibleHint(DEBUG);
        }
        return findFragmentByTag;
    }

    public void destroyItem(ViewGroup viewGroup, int i, @NonNull Object obj) {
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.beginTransaction();
        }
        this.mCurTransaction.detach((Fragment) obj);
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.mCurrentPrimaryItem) {
            if (this.mCurrentPrimaryItem != null) {
                this.mCurrentPrimaryItem.setMenuVisibility(DEBUG);
                this.mCurrentPrimaryItem.setUserVisibleHint(DEBUG);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            this.mCurrentPrimaryItem = fragment;
        }
    }

    public void finishUpdate(ViewGroup viewGroup) {
        if (this.mCurTransaction != null) {
            this.mCurTransaction.commitAllowingStateLoss();
            this.mCurTransaction = null;
            this.mFragmentManager.executePendingTransactions();
        }
    }

    public boolean isViewFromObject(View view, @NonNull Object obj) {
        return ((Fragment) obj).getView() == view ? true : DEBUG;
    }

    @Nullable
    public Parcelable saveState() {
        return null;
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    protected boolean isCorrectFragment(int i, Fragment fragment) {
        return true;
    }

    public long getItemId(int i) {
        return (long) i;
    }
}

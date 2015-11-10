package uk.co.senab.actionbarpulltorefresh.library;

import com.tinder.R;

/* renamed from: uk.co.senab.actionbarpulltorefresh.library.e */
public final class C3375e {

    /* renamed from: uk.co.senab.actionbarpulltorefresh.library.e.a */
    public static final class C3373a {
        public static final int default_header = 2130903087;
    }

    /* renamed from: uk.co.senab.actionbarpulltorefresh.library.e.b */
    public static final class C3374b {
        public static final int[] PullToRefreshHeader;
        public static final int PullToRefreshHeader_ptrHeaderBackground = 0;
        public static final int PullToRefreshHeader_ptrHeaderHeight = 1;
        public static final int PullToRefreshHeader_ptrHeaderTitleTextAppearance = 2;
        public static final int PullToRefreshHeader_ptrProgressBarColor = 3;
        public static final int PullToRefreshHeader_ptrProgressBarHeight = 5;
        public static final int PullToRefreshHeader_ptrProgressBarStyle = 4;
        public static final int PullToRefreshHeader_ptrPullText = 6;
        public static final int PullToRefreshHeader_ptrRefreshingText = 7;
        public static final int PullToRefreshHeader_ptrReleaseText = 8;
        public static final int PullToRefreshHeader_ptrSmoothProgressBarStyle = 9;
        public static final int[] PullToRefreshView;
        public static final int PullToRefreshView_ptrViewDelegateClass = 0;
        public static final int[] SmoothProgressBar;
        public static final int SmoothProgressBar_spbStyle = 0;
        public static final int SmoothProgressBar_spb_background = 13;
        public static final int SmoothProgressBar_spb_color = 1;
        public static final int SmoothProgressBar_spb_colors = 11;
        public static final int SmoothProgressBar_spb_generate_background_with_colors = 14;
        public static final int SmoothProgressBar_spb_interpolator = 8;
        public static final int SmoothProgressBar_spb_mirror_mode = 10;
        public static final int SmoothProgressBar_spb_progressiveStart_activated = 12;
        public static final int SmoothProgressBar_spb_progressiveStart_speed = 6;
        public static final int SmoothProgressBar_spb_progressiveStop_speed = 7;
        public static final int SmoothProgressBar_spb_reversed = 9;
        public static final int SmoothProgressBar_spb_sections_count = 4;
        public static final int SmoothProgressBar_spb_speed = 5;
        public static final int SmoothProgressBar_spb_stroke_separator_length = 3;
        public static final int SmoothProgressBar_spb_stroke_width = 2;

        static {
            PullToRefreshHeader = new int[]{R.attr.ptrHeaderBackground, R.attr.ptrHeaderHeight, R.attr.ptrHeaderTitleTextAppearance, R.attr.ptrProgressBarColor, R.attr.ptrProgressBarStyle, R.attr.ptrProgressBarHeight, R.attr.ptrPullText, R.attr.ptrRefreshingText, R.attr.ptrReleaseText, R.attr.ptrSmoothProgressBarStyle};
            int[] iArr = new int[SmoothProgressBar_spb_color];
            iArr[SmoothProgressBar_spbStyle] = R.attr.ptrViewDelegateClass;
            PullToRefreshView = iArr;
            SmoothProgressBar = new int[]{R.attr.spbStyle, R.attr.spb_color, R.attr.spb_stroke_width, R.attr.spb_stroke_separator_length, R.attr.spb_sections_count, R.attr.spb_speed, R.attr.spb_progressiveStart_speed, R.attr.spb_progressiveStop_speed, R.attr.spb_interpolator, R.attr.spb_reversed, R.attr.spb_mirror_mode, R.attr.spb_colors, R.attr.spb_progressiveStart_activated, R.attr.spb_background, R.attr.spb_generate_background_with_colors};
        }
    }
}

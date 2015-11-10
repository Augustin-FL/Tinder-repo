package com.tinder.views;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewOutlineProvider;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.webkit.ConsoleMessage;
import android.webkit.ConsoleMessage.MessageLevel;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.google.android.gms.location.LocationStatusCodes;
import com.tinder.R;
import com.tinder.activities.ActivityCallToActionBrowser;
import com.tinder.enums.SwipeType;
import com.tinder.managers.ManagerApp;
import com.tinder.managers.ManagerLiveRail.LiveRailEvent;
import com.tinder.model.ProcessedPhoto;
import com.tinder.model.SparksEvent;
import com.tinder.model.User;
import com.tinder.p030d.C2424a;
import com.tinder.p030d.C2425e;
import com.tinder.p030d.bt;
import com.tinder.picassowebp.picasso.C2281x;
import com.tinder.picassowebp.picasso.Picasso;
import com.tinder.picassowebp.picasso.Picasso.LoadedFrom;
import com.tinder.utils.C3045a;
import com.tinder.utils.C3067g;
import com.tinder.utils.C3077n;
import com.tinder.utils.C3095y;
import com.tinder.utils.af;
import com.tinder.utils.al;
import com.tinder.video.C3099a;
import com.tinder.views.LiveRailWebView.LiveRailCommand;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import org.apache.http.protocol.HTTP;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class RecCard extends CardBase implements C2281x {
    private static final float DIM_FULL = 0.04f;
    private static final float DIM_MED = 0.02f;
    private static final DecimalFormat EVENT_DECIMAL_FORMAT;
    private static final String FILE_PATH = "file:///android_asset/content/video_ad/index.html";
    private static final float PERCENT_WIDTH_TO_DRAG = 0.25f;
    private static final float ROTATION_ON_DRAG = 0.03f;
    private static final float SUPERLIKE_SCALE_END = 1.0f;
    private static final float SUPERLIKE_START_SCALE = 0.45f;
    private static final float SUPERLIKE_START_TRANS_Y = 50.0f;
    private static final float TILT_SLOP = 1.3f;
    private static final float VELOCITY_SLOP = 1.5f;
    private static final float VELOCITY_UPSWIPE_SLOP = 0.8f;
    private TextView mAge;
    private float mClickThreshold;
    private TextView mCommonFriendCount;
    private TextView mCommonInterestCount;
    private boolean mEnableSuperlike;
    private ImageView mFriendsIcon;
    private int mHeight;
    private ImageView mInterestsIcon;
    private CardMode mLastCardMode;
    private boolean mLastMuteState;
    private double mLastProgress;
    private C2424a mListenerAdCache;
    private CardMode mMode;
    private TextView mName;
    private ImageView mPartnerLogo;
    private ProgressBar mProgressBar;
    private User mRec;
    private String mRecId;
    private RecImageView mRecImage;
    private boolean mShouldBypassBecauseOfError;
    private View mStarTailCenter;
    private View mStartTailLeft;
    private View mStartTailRight;
    private TextView mSubtitle;
    private View mSuperlikeIcon;
    private View mSuperlikeTails;
    private int mSuperlikeTextColor;
    private long mTimeMillisCardLoaded;
    private View mTooltip;
    private RelativeLayout mTopLayout;
    private VerifiedBadgeView mVerifiedBadgeView;
    private ViewGroup mVideoViewContainer;
    private LiveRailWebView mWebView;
    private WebAppLiveRailInterface mWebViewBridge;
    private int mWidth;

    /* renamed from: com.tinder.views.RecCard.1 */
    class C31331 implements bt {
        C31331() {
        }

        public void onClick(MotionEvent motionEvent, View view) {
            C2425e cardListener = RecCard.this.getCardListener();
            if (cardListener != null) {
                C3095y.m9471a("CARD CLICK");
                cardListener.m6649a();
            }
        }
    }

    /* renamed from: com.tinder.views.RecCard.2 */
    class C31342 implements bt {
        C31342() {
        }

        public void onClick(@NonNull MotionEvent motionEvent, View view) {
            if (motionEvent.getRawY() > ((float) (al.m9263a(RecCard.this.mWebView).y + RecCard.this.mWebView.getMeasuredHeight()))) {
                RecCard.this.mWebViewBridge.launchCallToAction();
            } else {
                RecCard.this.mWebView.simulateMotionEvent(motionEvent);
            }
        }
    }

    /* renamed from: com.tinder.views.RecCard.3 */
    class C31353 implements OnLongClickListener {
        C31353() {
        }

        public boolean onLongClick(View view) {
            return true;
        }
    }

    /* renamed from: com.tinder.views.RecCard.4 */
    class C31364 extends C3099a {
        C31364() {
        }

        public boolean onConsoleMessage(@NonNull ConsoleMessage consoleMessage) {
            C3095y.m9485e(String.format("Console: %s [%s:%s] %s", new Object[]{consoleMessage.messageLevel().name(), consoleMessage.sourceId(), Integer.valueOf(consoleMessage.lineNumber()), consoleMessage.message()}));
            if (consoleMessage.messageLevel() == MessageLevel.ERROR) {
                RecCard.this.mShouldBypassBecauseOfError = true;
            }
            return true;
        }
    }

    /* renamed from: com.tinder.views.RecCard.5 */
    class C31375 extends WebViewClient {
        C31375() {
        }

        @Nullable
        public WebResourceResponse shouldInterceptRequest(WebView webView, @NonNull String str) {
            if (str.startsWith("file://")) {
                return null;
            }
            File a = af.m9229a(str);
            if (a == null) {
                return null;
            }
            try {
                return new WebResourceResponse("video/webm", HTTP.UTF_8, new FileInputStream(a));
            } catch (FileNotFoundException e) {
                return null;
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            C3095y.m9485e("Overriding URL loading for URL " + str);
            return super.shouldOverrideUrlLoading(webView, str);
        }

        public void onPageFinished(WebView webView, @NonNull String str) {
            C3095y.m9485e("Loaded URL " + str + " into WebView");
            if (!str.startsWith("javascript:")) {
                C3095y.m9471a("Setting up LiveRail view");
                RecCard.this.mWebView.runCommand(LiveRailCommand.setup);
                C3095y.m9471a(ManagerApp.m7931v().toString());
                RecCard.this.mName.setText(ManagerApp.m7931v().m7977h());
                RecCard.this.mSubtitle.setText(ManagerApp.m7931v().m7978i());
                Picasso.m8982a(RecCard.this.getContext()).m8990a(ManagerApp.m7931v().m7984o()).m9124a(RecCard.this.mPartnerLogo);
            }
            super.onPageFinished(webView, str);
        }

        public void onPageStarted(WebView webView, @NonNull String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (str.equals(RecCard.FILE_PATH)) {
                RecCard.this.mProgressBar.setVisibility(0);
            }
        }
    }

    /* renamed from: com.tinder.views.RecCard.6 */
    class C31386 extends ViewOutlineProvider {
        C31386() {
        }

        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, RecCard.this.mWidth, RecCard.this.mHeight, RecCard.this.getResources().getDimension(R.dimen.rounded_card_radius));
            outline.setAlpha(0.55f);
        }
    }

    /* renamed from: com.tinder.views.RecCard.7 */
    class C31397 implements AnimationListener {
        C31397() {
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            RecCard.this.mTooltip.animate().scaleX(0.0f).scaleY(0.0f).setStartDelay(128).setDuration(128).setInterpolator(new AccelerateInterpolator());
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: com.tinder.views.RecCard.8 */
    class C31418 implements Runnable {

        /* renamed from: com.tinder.views.RecCard.8.1 */
        class C31401 extends SimpleSpringListener {
            C31401() {
            }

            public void onSpringUpdate(Spring spring) {
                float currentValue = (float) spring.getCurrentValue();
                al.m9296c(RecCard.this.mSuperlikeIcon, C3077n.m9399a(currentValue, 0.0f, RecCard.SUPERLIKE_START_SCALE, RecCard.SUPERLIKE_SCALE_END, RecCard.SUPERLIKE_SCALE_END));
                RecCard.this.mSuperlikeIcon.setTranslationY((RecCard.SUPERLIKE_SCALE_END - currentValue) * RecCard.SUPERLIKE_START_TRANS_Y);
                RecCard.this.mSuperlikeIcon.setAlpha(currentValue);
                RecCard.this.mSuperlikeTails.setTranslationY((RecCard.SUPERLIKE_SCALE_END - currentValue) * RecCard.SUPERLIKE_START_TRANS_Y);
                RecCard.this.mSuperlikeTails.setAlpha(currentValue);
            }

            public void onSpringAtRest(Spring spring) {
                RecCard.this.mSuperlikeIcon.startAnimation(AnimationUtils.loadAnimation(RecCard.this.getContext(), R.anim.superlike_sparkle));
            }
        }

        C31418() {
        }

        public void run() {
            RecCard.this.mSuperlikeIcon.setVisibility(0);
            RecCard.this.mSuperlikeTails.setVisibility(0);
            Spring a = C3045a.m9201a();
            a.setSpringConfig(SpringConfig.fromBouncinessAndSpeed(14.0d, 14.0d));
            a.addListener(new C31401());
            a.setCurrentValue(0.0d);
            a.setEndValue(1.0d);
        }
    }

    /* renamed from: com.tinder.views.RecCard.9 */
    static /* synthetic */ class C31429 {
        static final /* synthetic */ int[] $SwitchMap$com$tinder$views$RecCard$CardMode;

        static {
            $SwitchMap$com$tinder$views$RecCard$CardMode = new int[CardMode.values().length];
            try {
                $SwitchMap$com$tinder$views$RecCard$CardMode[CardMode.REC.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$tinder$views$RecCard$CardMode[CardMode.PROMOTED_REC.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$tinder$views$RecCard$CardMode[CardMode.SUPER_LIKE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$tinder$views$RecCard$CardMode[CardMode.VIDEO_AD.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public enum CardMode {
        REC,
        PROMOTED_REC,
        SUPER_LIKE,
        VIDEO_AD
    }

    enum Progress {
        INITIAL(0.0d),
        FIRST_QUARTILE(0.25d),
        MIDPOINT(0.5d),
        THIRD_QUARTILE(0.75d);
        
        private double mValue;

        private Progress(double d) {
            this.mValue = d;
        }

        public double getValue() {
            return this.mValue;
        }
    }

    public interface SetRecListener {
        void setupComplete();
    }

    public class WebAppLiveRailInterface {
        double mDuration;
        private boolean mFiredFirstQuartile;
        private boolean mFiredMidpoint;
        private boolean mFiredThirdQuartile;
        private boolean mPaused;

        public boolean getPaused() {
            return this.mPaused;
        }

        @Nullable
        @JavascriptInterface
        public String getTitle() {
            return ManagerApp.m7931v().m7977h();
        }

        @Nullable
        @JavascriptInterface
        public String getSubtitle() {
            return ManagerApp.m7931v().m7978i();
        }

        @Nullable
        @JavascriptInterface
        public String getActionButtonTitle() {
            return ManagerApp.m7931v().m7979j();
        }

        @Nullable
        @JavascriptInterface
        public String getVideoUrl() {
            return ManagerApp.m7931v().m7980k();
        }

        @JavascriptInterface
        public void onVideoEnded() {
            ManagerApp.m7931v().m7967a(LiveRailEvent.complete);
            RecCard.this.getBaseAdEvent("Ad.Complete", true, false, false, false).fire();
            this.mFiredFirstQuartile = false;
            this.mFiredMidpoint = false;
            this.mFiredThirdQuartile = false;
            RecCard.this.mLastProgress = Progress.INITIAL.getValue();
        }

        @JavascriptInterface
        public void onTimeChanged(String str) {
            boolean z;
            if (this.mDuration == 0.0d) {
                this.mDuration = ManagerApp.m7931v().m7973d();
            }
            int parseDouble = (int) Double.parseDouble(str);
            if (parseDouble == ((int) Math.ceil(this.mDuration * Progress.FIRST_QUARTILE.getValue())) && !this.mFiredFirstQuartile) {
                ManagerApp.m7931v().m7967a(LiveRailEvent.firstQuartile);
                this.mFiredFirstQuartile = true;
                RecCard.this.mLastProgress = Progress.FIRST_QUARTILE.getValue();
                z = true;
            } else if (parseDouble == ((int) Math.ceil(this.mDuration * Progress.MIDPOINT.getValue())) && !this.mFiredMidpoint) {
                ManagerApp.m7931v().m7967a(LiveRailEvent.midpoint);
                this.mFiredMidpoint = true;
                RecCard.this.mLastProgress = Progress.MIDPOINT.getValue();
                z = true;
            } else if (parseDouble != ((int) Math.ceil(this.mDuration * Progress.THIRD_QUARTILE.getValue())) || this.mFiredThirdQuartile) {
                z = false;
            } else {
                ManagerApp.m7931v().m7967a(LiveRailEvent.thirdQuartile);
                this.mFiredThirdQuartile = true;
                RecCard.this.mLastProgress = Progress.THIRD_QUARTILE.getValue();
                z = true;
            }
            if (z) {
                RecCard.this.getBaseAdEvent("Ad.Progress", true, true, false, true).fire();
            }
        }

        @JavascriptInterface
        public void onPaused() {
            ManagerApp.m7931v().m7967a(LiveRailEvent.pause);
            this.mPaused = true;
        }

        @JavascriptInterface
        public void onResumed() {
            RecCard.this.getBaseAdEvent("Ad.Play", true, false, false, false).fire();
            ManagerApp.m7931v().m7967a(LiveRailEvent.resume);
            this.mPaused = false;
        }

        @JavascriptInterface
        public void onImpression() {
            ManagerApp.m7931v().m7967a(LiveRailEvent.impression);
        }

        @JavascriptInterface
        public void onClosed() {
            ManagerApp.m7931v().m7967a(LiveRailEvent.close);
        }

        @JavascriptInterface
        public void launchCallToAction() {
            RecCard.this.getBaseAdEvent("Ad.Select", true, true, true, true).put("method", "BUTTON").fire();
            ManagerApp.m7931v().m7967a(LiveRailEvent.acceptInvitation);
            String n = ManagerApp.m7931v().m7983n();
            if (!C3067g.m9353a(n)) {
                Intent intent = new Intent(RecCard.this.getContext(), ActivityCallToActionBrowser.class);
                intent.putExtra(ActivityCallToActionBrowser.f3743a, n);
                RecCard.this.getContext().startActivity(intent);
            }
        }

        @JavascriptInterface
        public void onMuted(String str) {
            RecCard.this.mLastMuteState = Boolean.parseBoolean(str);
            RecCard.this.getBaseAdEvent("Ad.ToggleAudio", true, true, true, false).fire();
        }

        @JavascriptInterface
        public void onLoadComplete() {
            RecCard.this.getBaseAdEvent("Ad.Play", true, true, false, false).fire();
        }

        @JavascriptInterface
        public void onReplay() {
            RecCard.this.getBaseAdEvent("Ad.Replay", true, false, false, false).fire();
        }

        @JavascriptInterface
        public void invalidate() {
            RecCard.this.mWebView.postInvalidate();
        }
    }

    static {
        EVENT_DECIMAL_FORMAT = new DecimalFormat("0.00");
    }

    public RecCard(@NonNull Context context) {
        super(context);
        this.mShouldBypassBecauseOfError = false;
        this.mEnableSuperlike = ManagerApp.m7914e().at();
        this.mSuperlikeTextColor = getResources().getColor(R.color.superlike_text);
        initCommon(context);
    }

    public RecCard(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mShouldBypassBecauseOfError = false;
        this.mEnableSuperlike = ManagerApp.m7914e().at();
        this.mSuperlikeTextColor = getResources().getColor(R.color.superlike_text);
        initCommon(context);
    }

    public RecCard(@NonNull Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mShouldBypassBecauseOfError = false;
        this.mEnableSuperlike = ManagerApp.m7914e().at();
        this.mSuperlikeTextColor = getResources().getColor(R.color.superlike_text);
        initCommon(context);
    }

    @TargetApi(21)
    public RecCard(@NonNull Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mShouldBypassBecauseOfError = false;
        this.mEnableSuperlike = ManagerApp.m7914e().at();
        this.mSuperlikeTextColor = getResources().getColor(R.color.superlike_text);
        initCommon(context);
    }

    public void setAdCacheListener(C2424a c2424a) {
        this.mListenerAdCache = c2424a;
    }

    public CardMode getCardMode() {
        return this.mMode;
    }

    public void setCardMode(@NonNull CardMode cardMode) {
        this.mLastCardMode = this.mMode;
        this.mMode = cardMode;
        this.mShouldBypassBecauseOfError = false;
        switch (C31429.$SwitchMap$com$tinder$views$RecCard$CardMode[cardMode.ordinal()]) {
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                initRecMode();
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                initPromotedRecMode();
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                initSuperLikeMode();
            case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                initVideoAdMode();
            default:
        }
    }

    public void onPause() {
        if (this.mMode == CardMode.VIDEO_AD && this.mWebView != null) {
            this.mWebView.runCommand(LiveRailCommand.pause);
        }
    }

    public boolean canBeSuperLiked() {
        return this.mMode == CardMode.REC;
    }

    private void initCommon(@NonNull Context context) {
        this.mClickThreshold = (float) (ViewConfiguration.get(context).getScaledTouchSlop() / 2);
        inflate(getContext(), R.layout.view_rec_card, this);
        this.mProgressBar = (ProgressBar) findViewById(R.id.spinner);
        this.mRecImage = (RecImageView) findViewById(R.id.rec_card_image);
        this.mWebView = (LiveRailWebView) findViewWithTag("video_ad");
        this.mWebView.setLayerType(2, null);
        this.mName = (TextView) findViewById(R.id.txt_name);
        this.mAge = (TextView) findViewById(R.id.txt_age);
        this.mSubtitle = (TextView) findViewById(R.id.txt_subtitle);
        this.mCommonFriendCount = (TextView) findViewById(R.id.txt_friend_count);
        this.mCommonInterestCount = (TextView) findViewById(R.id.txt_interest_count);
        this.mFriendsIcon = (ImageView) findViewById(R.id.img_friends_icon);
        this.mInterestsIcon = (ImageView) findViewById(R.id.img_interests_icon);
        this.mPartnerLogo = (ImageView) findViewById(R.id.img_partner_logo);
        this.mVideoViewContainer = (ViewGroup) findViewById(R.id.video_ad_container);
        this.mVerifiedBadgeView = (VerifiedBadgeView) findViewById(R.id.verified_badge);
        this.mTooltip = findViewById(R.id.tooltip);
        this.mSuperlikeIcon = findViewById(R.id.superlike_icon);
        this.mSuperlikeTails = findViewById(R.id.superlike_tails);
        this.mStarTailCenter = findViewById(R.id.star_tail_center);
        this.mStartTailLeft = findViewById(R.id.star_tail_left);
        this.mStartTailRight = findViewById(R.id.star_tail_right);
        ((ImageView) this.mTooltip.findViewById(R.id.tooltip_bottom_corner)).setColorFilter(getResources().getColor(R.color.orange));
        this.mTopLayout = (RelativeLayout) findViewById(R.id.rec_card_top_relative);
        enableDimming(this.mTopLayout, getResources().getDrawable(R.drawable.shape_card_dim));
        resizeToScreen();
        setupTooltipThrob();
        setupTouchValues();
        setupStamps();
        if (C3077n.m9412e()) {
            setupShadows();
        }
        setCardMode(CardMode.REC);
    }

    public boolean meetsRequirementsForSwipeUp() {
        return !this.mRec.isSuperLike();
    }

    private void initRecMode() {
        this.mVideoViewContainer.setVisibility(8);
        this.mSubtitle.setVisibility(8);
        this.mRecImage.setVisibility(0);
        this.mAge.setVisibility(0);
        this.mFriendsIcon.setVisibility(0);
        this.mInterestsIcon.setVisibility(0);
        this.mCommonInterestCount.setVisibility(0);
        this.mCommonFriendCount.setVisibility(0);
        this.mPartnerLogo.setVisibility(8);
        setSwipeUpEnabled(this.mEnableSuperlike);
        setOnClickWithEventListener(new C31331());
    }

    private void initSuperLikeMode() {
        initRecMode();
        al.m9271a(this.mTopLayout, ContextCompat.getDrawable(getContext(), R.drawable.rec_card_superlike_bg));
        this.mName.setTextColor(getResources().getColor(R.color.white));
        this.mAge.setTextColor(getResources().getColor(R.color.white));
        this.mSubtitle.setVisibility(0);
        this.mSubtitle.setTextColor(this.mSuperlikeTextColor);
        this.mSubtitle.setText(R.string.rec_superliked_you);
        this.mSubtitle.setTextSize(0, getResources().getDimension(R.dimen.text_small));
        findViewById(R.id.superlike_overlay).setVisibility(0);
        this.mFriendsIcon.setImageResource(R.drawable.recs_common_friends_superlike);
        this.mCommonFriendCount.setTextColor(this.mSuperlikeTextColor);
        this.mInterestsIcon.setVisibility(8);
        this.mCommonInterestCount.setVisibility(8);
        setSwipeUpEnabled(false);
    }

    private void initPromotedRecMode() {
        initRecMode();
        setSwipeUpEnabled(false);
    }

    private void initVideoAdMode() {
        this.mVideoViewContainer.setVisibility(0);
        this.mSubtitle.setVisibility(0);
        this.mRecImage.setVisibility(8);
        this.mSubtitle.setTextSize(0, getResources().getDimension(R.dimen.text_med));
        this.mSubtitle.setTextColor(getResources().getColor(R.color.subtext_gray));
        this.mAge.setVisibility(8);
        this.mFriendsIcon.setVisibility(8);
        this.mInterestsIcon.setVisibility(8);
        this.mCommonInterestCount.setVisibility(8);
        this.mCommonFriendCount.setVisibility(8);
        this.mPartnerLogo.setVisibility(0);
        setSwipeUpEnabled(false);
        this.mName.setFilters(new InputFilter[]{new LengthFilter(LocationStatusCodes.GEOFENCE_NOT_AVAILABLE)});
        this.mWebViewBridge = new WebAppLiveRailInterface();
        setOnClickWithEventListener(new C31342());
        this.mWebView.getSettings().setSupportZoom(false);
        this.mWebView.getSettings().setPluginState(PluginState.ON);
        this.mWebView.getSettings().setCacheMode(1);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.getSettings().setLoadWithOverviewMode(true);
        this.mWebView.getSettings().setUseWideViewPort(true);
        this.mWebView.getSettings().setBuiltInZoomControls(false);
        if (C3077n.m9411d()) {
            this.mWebView.getSettings().setAllowUniversalAccessFromFileURLs(true);
        }
        this.mWebView.addJavascriptInterface(this.mWebViewBridge, "TinderAds");
        this.mWebView.setInitialScale(1);
        this.mWebView.setLongClickable(false);
        this.mWebView.setOnLongClickListener(new C31353());
        this.mWebView.setHapticFeedbackEnabled(false);
        this.mWebView.setLayerType(2, null);
        this.mWebView.setWebChromeClient(new C31364());
        this.mWebView.setWebViewClient(new C31375());
        this.mWebView.loadUrl(FILE_PATH);
    }

    @TargetApi(21)
    private void setupShadows() {
        setOutlineProvider(new C31386());
        setClipToOutline(false);
    }

    private void setupTooltipThrob() {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.anim_throb_verification_tooltip);
        loadAnimation.setAnimationListener(new C31397());
        this.mTooltip.startAnimation(loadAnimation);
    }

    private void resizeToScreen() {
        double a = (double) al.m9262a(getContext());
        double b = (double) (al.m9285b(getContext()) - al.m9294c(getContext()));
        double dimension = (double) getResources().getDimension(R.dimen.actionbar_size);
        double d = 0.4d * a;
        this.mHeight = Math.min((int) ((b - dimension) - d), (int) ((0.95d * a) + dimension));
        this.mWidth = (int) (((double) this.mHeight) - dimension);
        C3095y.m9471a("resizeToScreen: " + a + ", " + b + ", " + dimension + ", " + d + " Output: " + this.mWidth + ", " + this.mHeight);
        LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(this.mWidth, this.mHeight);
        }
        layoutParams.width = this.mWidth;
        layoutParams.height = this.mHeight;
        setLayoutParams(layoutParams);
        View findViewById = findViewById(R.id.content_mock);
        LayoutParams layoutParams2 = findViewById.getLayoutParams();
        layoutParams2.width = this.mWidth;
        layoutParams2.height = this.mWidth;
        findViewById.setLayoutParams(layoutParams2);
    }

    private float getTopThreshold() {
        return (float) (this.mScreenHeight / 3);
    }

    private void setupTouchValues() {
        setClickThreshold((float) ViewConfiguration.get(getContext()).getScaledTouchSlop());
        setSwipeThreshold(PERCENT_WIDTH_TO_DRAG * ((float) this.mWidth));
        setTopThreshhold(getTopThreshold());
        setSwipeEndX(((float) this.mWidth) * 1.4f);
        setSwipeEndY((float) this.mScreenHeight);
        setMinimumSwipeVelocity(VELOCITY_SLOP);
        setMinimumSwipeUpVelocity(VELOCITY_UPSWIPE_SLOP);
        setTiltSlop(((float) this.mHeight) / TILT_SLOP);
        setRotationOnDrag(ROTATION_ON_DRAG);
        setSwipeBoundaries(70.0f, 15.0f, 70.0f);
        setStampLeftBounds();
        setStampRightBounds();
    }

    private void setupStamps() {
        setStampNopeCompat((ImageView) findViewById(R.id.stamp_nope));
        setStampLikeCompat((ImageView) findViewById(R.id.stamp_liked));
        setStampSuperLikeCompat((ImageView) findViewById(R.id.stamp_superlike));
    }

    public int getCardHeight() {
        return this.mHeight;
    }

    public int getCardWidth() {
        return this.mWidth;
    }

    public User getRec() {
        return this.mRec;
    }

    public void setRec(@NonNull User user) {
        setRec(user, null);
    }

    public void setRec(@NonNull User user, @Nullable SetRecListener setRecListener) {
        this.mRec = user;
        if (!(this.mRecId != null && this.mRecId.equals(user.getId()) && this.mLastCardMode == CardMode.REC)) {
            this.mRec = user;
            this.mRecId = user.getId();
            this.mRecImage.setImageDrawable(null);
            int numConnections = user.getNumConnections();
            this.mCommonFriendCount.setText(String.valueOf(numConnections));
            boolean isSuperLike = this.mRec.isSuperLike();
            this.mSuperlikeIcon.setVisibility(8);
            this.mSuperlikeIcon.clearAnimation();
            this.mSuperlikeTails.setVisibility(8);
            this.mStartTailLeft.clearAnimation();
            this.mStarTailCenter.clearAnimation();
            this.mStartTailRight.clearAnimation();
            if (isSuperLike && this.mEnableSuperlike) {
                setCardMode(CardMode.SUPER_LIKE);
            } else {
                al.m9271a(this.mTopLayout, getResources().getDrawable(R.drawable.rec_card_bg));
                this.mName.setTextColor(getResources().getColor(R.color.text_dark));
                this.mAge.setTextColor(getResources().getColor(R.color.text_dark));
                this.mSubtitle.setVisibility(8);
                findViewById(R.id.superlike_overlay).setVisibility(8);
                this.mCommonInterestCount.setText(String.valueOf(user.getNumCommonInterests()));
                if (numConnections > 0) {
                    this.mCommonFriendCount.setTextColor(getResources().getColor(R.color.orange));
                    this.mFriendsIcon.setImageResource(R.drawable.rec_friends_active);
                } else {
                    this.mCommonFriendCount.setTextColor(getResources().getColor(R.color.another_freaking_grey));
                    this.mFriendsIcon.setImageResource(R.drawable.rec_friends_normal);
                }
                this.mInterestsIcon.setVisibility(0);
                this.mCommonInterestCount.setVisibility(0);
                if (this.mRec.isBrand()) {
                    setCardMode(CardMode.PROMOTED_REC);
                }
            }
            if (user.hasPhotos() && user.getMainPhoto() != null) {
                ProcessedPhoto processedPhoto = user.getMainPhoto().getProcessedPhoto(al.m9265a((Activity) getContext()));
                if (processedPhoto != null) {
                    setImageUrl(processedPhoto.getImageUrl());
                }
            }
            setNameAge(user.getName(), user.getAge());
            displayBadgeTooltip();
            this.mRecId = user.getId();
        }
        if (!isMoving()) {
            resetStamps();
        }
        if (setRecListener != null) {
            setRecListener.setupComplete();
        }
    }

    public void animateSuperLike() {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.superlike_tail);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.superlike_tail);
        Animation loadAnimation3 = AnimationUtils.loadAnimation(getContext(), R.anim.superlike_tail);
        loadAnimation3.setStartOffset(500);
        loadAnimation2.setStartOffset(200);
        this.mStarTailCenter.startAnimation(loadAnimation2);
        this.mStartTailLeft.startAnimation(loadAnimation);
        this.mStartTailRight.startAnimation(loadAnimation3);
        post(new C31418());
    }

    private void displayBadgeTooltip() {
        if (this.mRec != null) {
            this.mVerifiedBadgeView.displayBadge(this.mRec);
            if (this.mRec.isVerified()) {
                Point a = al.m9263a((View) this);
                Point a2 = al.m9263a(this.mVerifiedBadgeView);
                Point a3 = al.m9263a(this.mTooltip);
                a2.x -= a.x;
                a2.y -= a.y;
                a3.x -= a.x;
                a3.y -= a.y;
                int measuredWidth = (this.mVerifiedBadgeView.getMeasuredWidth() / 2) + (a2.x - (this.mTooltip.getMeasuredWidth() / 2));
                int measuredHeight = a2.y - this.mTooltip.getMeasuredHeight();
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTooltip.getLayoutParams();
                layoutParams.leftMargin = measuredWidth;
                layoutParams.topMargin = measuredHeight;
                this.mTooltip.setLayoutParams(layoutParams);
                this.mTooltip.setPivotX((float) (this.mTooltip.getMeasuredWidth() / 2));
                this.mTooltip.setPivotY((float) this.mTooltip.getMeasuredHeight());
                this.mTooltip.setVisibility(0);
                return;
            }
            this.mTooltip.setVisibility(8);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        displayBadgeTooltip();
    }

    public String getRecId() {
        return this.mRecId;
    }

    public void setNameAge(String str, String str2) {
        this.mAge.setText(", " + str2);
        this.mName.setText(TextUtils.ellipsize(str, this.mName.getPaint(), ((float) this.mWidth) / 2.5f, TruncateAt.END));
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.mProgressBar.setVisibility(8);
        this.mRecImage.setImageBitmap(bitmap);
    }

    public void setImageUrl(String str) {
        C3095y.m9471a("rec loading " + str);
        this.mRecImage.setImageDrawable(null);
        this.mProgressBar.setVisibility(0);
        Picasso.m8982a(getContext()).m8990a(str).m9126a((C2281x) this);
    }

    @TargetApi(21)
    @NonNull
    public RecCard clone() {
        RecCard recCard = new RecCard(getContext());
        recCard.setRec(this.mRec);
        recCard.setRotation(getRotation());
        recCard.setTranslationX(getTranslationX());
        recCard.setTranslationY(getTranslationY());
        if (C3077n.m9412e()) {
            recCard.setTranslationZ(getTranslationZ());
        }
        return recCard;
    }

    public ImageView getImageView() {
        return this.mRecImage;
    }

    public View getSuperLikeStar() {
        return this.mSuperlikeIcon;
    }

    public TextView getNameTextView() {
        return this.mName;
    }

    public float getDimMedium() {
        return DIM_MED;
    }

    public float getDimFull() {
        return DIM_FULL;
    }

    public void onBitmapLoaded(Bitmap bitmap, @NonNull LoadedFrom loadedFrom) {
        C3095y.m9471a("image load from " + loadedFrom.name());
        this.mProgressBar.setVisibility(8);
        this.mRecImage.setImageBitmap(bitmap);
    }

    public void onBitmapFailed(Drawable drawable) {
    }

    public void onPrepareLoad(Drawable drawable) {
    }

    @NonNull
    public SparksEvent getBaseAdEvent(String str, boolean z, boolean z2, boolean z3, boolean z4) {
        SparksEvent put = new SparksEvent(str).put("creativeId", ManagerApp.m7931v().m7975f()).put("campaignId", ManagerApp.m7931v().m7974e()).put("provider", ManagerApp.m7931v().m7976g()).put("type", "rec").put("format", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO).put("from", "recs");
        if (z4) {
            put.put("paused", Boolean.valueOf(this.mWebViewBridge.getPaused()));
        }
        if (z) {
            put.put("mute", Boolean.valueOf(this.mLastMuteState));
        }
        if (z2) {
            put.put(NotificationCompatApi21.CATEGORY_PROGRESS, EVENT_DECIMAL_FORMAT.format(this.mLastProgress));
        }
        if (z3) {
            put.put("timeViewed", Long.valueOf(System.currentTimeMillis() - this.mTimeMillisCardLoaded));
        }
        return put;
    }

    public void onPoppedOffStack(SwipeType swipeType) {
        if (this.mMode == CardMode.VIDEO_AD) {
            if (this.mListenerAdCache != null) {
                this.mListenerAdCache.m6636y();
            }
            this.mWebView.loadUrl("about:blank");
            ManagerApp.m7931v().m7967a(LiveRailEvent.close);
            ManagerApp.m7931v().m7972c();
            SparksEvent baseAdEvent = getBaseAdEvent("Ad.Close", true, true, true, true);
            if (swipeType != null) {
                baseAdEvent.put("like", Boolean.valueOf(swipeType.getAnalyticsFlag())).put("method", swipeType.getAnalyticsMethod());
            }
            baseAdEvent.fire();
            setCardMode(CardMode.REC);
        }
    }

    public void onPushedToTopOfStack() {
        if (this.mMode == CardMode.VIDEO_AD) {
            this.mWebView.runCommand(LiveRailCommand.load);
            this.mTimeMillisCardLoaded = System.currentTimeMillis();
            C3095y.m9485e("Playing video");
            getBaseAdEvent("Ad.View", true, false, false, false).fire();
            if (this.mShouldBypassBecauseOfError) {
                getCardListener().m6651a(false);
            }
        } else if (this.mMode == CardMode.REC) {
            displayBadgeTooltip();
        }
    }
}

package com.tinder.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tinder.R;
import com.tinder.enums.PhotoSizeMoment;
import com.tinder.enums.PhotoSizeUser;
import com.tinder.model.Moment;
import com.tinder.p030d.ai;
import com.tinder.picassowebp.picasso.C2281x;
import com.tinder.picassowebp.picasso.Picasso;
import com.tinder.picassowebp.picasso.Picasso.LoadedFrom;
import com.tinder.utils.C3077n;
import com.tinder.utils.C3095y;
import com.tinder.utils.al;

public class MomentCard extends CardBase implements OnClickListener {
    private static final float DIM_FULL = 0.15f;
    private static final float DIM_MED = 0.08f;
    private RoundImageView mAvatarImage;
    private ImageView mAvatarMockImage;
    private ImageButton mBtnLikeMsg;
    private ImageButton mBtnMenu;
    private int mHeight;
    private ImageView mImageViewMoment;
    private String mMomentId;
    private String mScreenDensity;
    private TextView mTextName;
    private TextView mTextTime;
    private String mUserId;
    private int mWidth;

    /* renamed from: com.tinder.views.MomentCard.1 */
    class C31201 extends ViewOutlineProvider {
        C31201() {
        }

        public void getOutline(View view, @NonNull Outline outline) {
            outline.setRoundRect(0, 0, MomentCard.this.mWidth, MomentCard.this.mHeight, MomentCard.this.getResources().getDimension(R.dimen.rounded_card_radius));
        }
    }

    /* renamed from: com.tinder.views.MomentCard.2 */
    class C31212 implements C2281x {
        C31212() {
        }

        public void onBitmapLoaded(Bitmap bitmap, LoadedFrom loadedFrom) {
            MomentCard.this.mImageViewMoment.setImageBitmap(bitmap);
        }

        public void onBitmapFailed(Drawable drawable) {
        }

        public void onPrepareLoad(Drawable drawable) {
        }
    }

    public MomentCard(@NonNull Context context) {
        super(context);
        init(context);
    }

    public MomentCard(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public MomentCard(@NonNull Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    @TargetApi(21)
    public MomentCard(@NonNull Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(context);
    }

    public int getCardHeight() {
        return this.mHeight;
    }

    private void init(@NonNull Context context) {
        this.mScreenDensity = al.m9298d(context);
        float b = al.m9284b(4.0f, context);
        inflate(context, R.layout.view_moment_card, this);
        this.mImageViewMoment = (ImageView) findViewById(R.id.moment_card_image);
        this.mAvatarMockImage = (ImageView) findViewById(R.id.moment_card_mock_avatar);
        this.mAvatarImage = (RoundImageView) findViewById(R.id.moment_card_avatar);
        this.mTextName = (TextView) findViewById(R.id.moment_card_text_name);
        this.mTextTime = (TextView) findViewById(R.id.moment_card_text_time);
        this.mBtnMenu = (ImageButton) findViewById(R.id.moment_card_btn_menu);
        this.mBtnLikeMsg = (ImageButton) findViewById(R.id.moment_card_btn_likemsg);
        this.mWidth = (int) (((float) al.m9262a(context)) * 0.95f);
        this.mHeight = (int) ((((float) al.m9285b(context)) * 0.95f) - al.m9284b(40.0f, getContext()));
        setLayoutParams(new LayoutParams(this.mWidth, this.mHeight));
        this.mBtnMenu.setOnClickListener(this);
        this.mAvatarImage.setOnClickListener(this);
        this.mBtnMenu.setOnClickListener(this);
        this.mBtnLikeMsg.setOnClickListener(this);
        int round = Math.round(((float) this.mHeight) * 0.85f);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(this.mWidth, round);
        layoutParams.addRule(14);
        layoutParams.addRule(11);
        this.mImageViewMoment.setLayoutParams(layoutParams);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.moment_card_avatar_layout);
        ViewGroup.LayoutParams layoutParams2 = new LayoutParams(this.mWidth, (int) ((((float) this.mHeight) - b) - ((float) round)));
        layoutParams2.addRule(12);
        relativeLayout.setLayoutParams(layoutParams2);
        this.mImageViewMoment.setPivotX((float) (this.mWidth / 2));
        this.mImageViewMoment.setPivotY((float) (this.mHeight / 2));
        al.m9287b(this.mBtnLikeMsg);
        al.m9287b(this.mBtnMenu);
        setupStamps();
        setupTouchValues();
        if (C3077n.m9412e()) {
            setupShadows();
        } else {
            enableDimming((RelativeLayout) findViewById(R.id.moment_card_rounded_relativelayout), getResources().getDrawable(R.drawable.shape_card_dim));
        }
    }

    @TargetApi(21)
    private void setupShadows() {
        setOutlineProvider(new C31201());
        setClipToOutline(false);
    }

    public float getDimMedium() {
        return DIM_MED;
    }

    public float getDimFull() {
        return DIM_FULL;
    }

    private void setupTouchValues() {
        setClickThreshold((float) (ViewConfiguration.get(getContext()).getScaledTouchSlop() / 2));
        setMinimumSwipeVelocity(1.5f);
        setSwipeThreshold(((float) this.mWidth) * 0.33f);
        setSwipeEndX(((float) this.mWidth) * 1.3f);
        setTiltSlop(((float) this.mHeight) * PeekStack.HEIGHT_PERCENT_OF_SCREEN);
        setRotationOnDrag(0.015f);
    }

    private void setupStamps() {
        setStampNopeCompat((ImageView) findViewById(R.id.moment_card_stamp_pass));
        setStampLikeCompat((ImageView) findViewById(R.id.moment_card_stamp_liked));
    }

    public void setMoment(@NonNull Moment moment) {
        if (this.mMomentId == null || !this.mMomentId.equals(moment.getId())) {
            this.mMomentId = moment.getId();
            this.mUserId = moment.getUserId();
            setImage(getMomentImageUrlToShow(moment));
            setAvatar(moment);
            setNameText(moment);
            setTimePosted(moment);
            if (moment.isMockMoment()) {
                this.mBtnLikeMsg.setVisibility(8);
                this.mBtnMenu.setVisibility(8);
                this.mTextName.setPadding(0, 0, 0, 0);
                return;
            }
            this.mBtnLikeMsg.setVisibility(0);
            this.mBtnMenu.setVisibility(0);
            if (this.mTextName.getPaddingBottom() == 0) {
                this.mTextName.setPadding(0, 0, 0, getResources().getDimensionPixelSize(R.dimen.padding_large));
                return;
            }
            return;
        }
        C3095y.m9476b("Not doing anything");
    }

    public void setImage(String str) {
        C3095y.m9471a("imageUrl=" + str);
        C2281x c31212 = new C31212();
        this.mTextName.setTag(c31212);
        Picasso.m8982a(getContext()).m8990a(str).m9129b(this.mWidth, this.mHeight).m9127b().m9126a(c31212);
    }

    public void setAvatar(@NonNull Moment moment) {
        if (moment.isMockMoment()) {
            this.mAvatarMockImage.setVisibility(0);
            this.mAvatarImage.setVisibility(4);
            return;
        }
        String avatarUrl = moment.getPerson().getAvatarUrl(0, PhotoSizeUser.SMALL);
        if (avatarUrl.length() == 0) {
            this.mAvatarMockImage.setVisibility(0);
            this.mAvatarImage.setVisibility(4);
            return;
        }
        this.mAvatarMockImage.setVisibility(8);
        this.mAvatarImage.setVisibility(0);
        Picasso.m8982a(getContext()).m8990a(avatarUrl).m9121a((int) R.dimen.avatar_length_messages, (int) R.dimen.avatar_length_messages).m9127b().m9126a(this.mAvatarImage);
    }

    private String getMomentImageUrlToShow(@NonNull Moment moment) {
        PhotoSizeMoment photoSizeMoment;
        if (this.mScreenDensity.equals("xxxhdpi")) {
            photoSizeMoment = PhotoSizeMoment.ORIG;
        } else if (this.mScreenDensity.equals("xxhdpi") || this.mScreenDensity.equals("xhdpi")) {
            photoSizeMoment = PhotoSizeMoment.LARGE;
        } else {
            photoSizeMoment = PhotoSizeMoment.MED;
        }
        return moment.getMomentPhoto().getProcessedFile(photoSizeMoment);
    }

    public String getMomentId() {
        return this.mMomentId;
    }

    public String getUserId() {
        return this.mUserId;
    }

    public void setNameText(@NonNull Moment moment) {
        if (moment.isMockMoment()) {
            this.mTextName.setText(R.string.tinder_team);
        } else {
            this.mTextName.setText(moment.getPerson().getName());
        }
    }

    public void setTimePosted(@NonNull Moment moment) {
        long createdTime = moment.getCreatedTime();
        if (moment.isMockMoment()) {
            this.mTextTime.setVisibility(8);
        } else if (Math.abs(System.currentTimeMillis() - createdTime) < 60000) {
            this.mTextTime.setVisibility(0);
            this.mTextTime.setText(R.string.now);
        } else {
            this.mTextTime.setVisibility(0);
            this.mTextTime.setText(String.valueOf(DateUtils.getRelativeTimeSpanString(createdTime)));
        }
    }

    public ImageView getImageView() {
        return this.mImageViewMoment;
    }

    public void onClick(@NonNull View view) {
        ai aiVar = (ai) getCardListener();
        if (aiVar != null) {
            switch (view.getId()) {
                case R.id.moment_card_avatar:
                    aiVar.m6654b();
                case R.id.moment_card_text_name:
                    aiVar.m6654b();
                case R.id.moment_card_text_time:
                    aiVar.m6654b();
                case R.id.moment_card_btn_menu:
                    aiVar.m6655c();
                case R.id.moment_card_btn_likemsg:
                    aiVar.m6656d();
                default:
            }
        }
    }
}

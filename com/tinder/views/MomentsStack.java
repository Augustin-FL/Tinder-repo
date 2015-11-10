package com.tinder.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tinder.R;
import com.tinder.enums.PhotoSizeMoment;
import com.tinder.model.Moment;
import com.tinder.picassowebp.picasso.C2281x;
import com.tinder.picassowebp.picasso.Picasso;
import com.tinder.picassowebp.picasso.Picasso.LoadedFrom;
import com.tinder.utils.C3095y;
import com.tinder.utils.al;
import java.util.ArrayList;
import java.util.List;

public class MomentsStack extends FrameLayout {
    @NonNull
    private static List<Moment> mListMoments;
    private Context mContext;
    private ImageView mImgTopCard;
    private boolean mIsGettingAndDrawingImage;
    private long mLastTimeLoaded;
    private TextView mTxtTimeAgo;
    private TextView mTxtUnreadMoments;

    /* renamed from: com.tinder.views.MomentsStack.1 */
    class C31221 implements Runnable {
        C31221() {
        }

        public void run() {
            LayoutParams layoutParams = MomentsStack.this.getLayoutParams();
            layoutParams.width = al.m9262a(MomentsStack.this.mContext);
            MomentsStack.this.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.tinder.views.MomentsStack.2 */
    class C31232 implements C2281x {
        final /* synthetic */ ImageView val$imageView;

        C31232(ImageView imageView) {
            this.val$imageView = imageView;
        }

        public void onBitmapLoaded(Bitmap bitmap, LoadedFrom loadedFrom) {
            MomentsStack.this.mIsGettingAndDrawingImage = false;
            this.val$imageView.setImageBitmap(bitmap);
        }

        public void onBitmapFailed(Drawable drawable) {
            MomentsStack.this.mIsGettingAndDrawingImage = false;
        }

        public void onPrepareLoad(Drawable drawable) {
            this.val$imageView.setImageDrawable(drawable);
        }
    }

    static {
        mListMoments = new ArrayList();
    }

    public MomentsStack(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public MomentsStack(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    public MomentsStack(@NonNull Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init();
    }

    private void init() {
        setForegroundGravity(17);
        inflate(this.mContext, R.layout.view_moment_stack, this);
        this.mImgTopCard = (ImageView) findViewById(R.id.img_top_card);
        this.mTxtTimeAgo = (TextView) findViewById(R.id.txt_time_ago);
        this.mTxtUnreadMoments = (TextView) findViewById(R.id.txt_num_new_moments);
        post(new C31221());
    }

    public ImageView getTopImage() {
        return this.mImgTopCard;
    }

    public void setMoments(@NonNull List<Moment> list, boolean z) {
        C3095y.m9469a();
        if (list.isEmpty()) {
            mListMoments.clear();
            C3095y.m9471a("No moments passed in, not doing anything");
            return;
        }
        mListMoments = new ArrayList(list.size());
        for (int size = list.size() - 1; size >= 0; size--) {
            mListMoments.add(list.get(size));
        }
        drawUi(list.size(), z);
    }

    @NonNull
    public List<Moment> getMoments() {
        return mListMoments;
    }

    private void drawUi(int i, boolean z) {
        C3095y.m9471a("numNewMoments=" + i);
        if (mListMoments.isEmpty()) {
            C3095y.m9471a("mListMoments empty");
        } else {
            C3095y.m9471a("mListMoments not empty");
            Moment moment = (Moment) mListMoments.get(0);
            int dimensionPixelSize = (int) (((float) this.mContext.getResources().getDimensionPixelSize(R.dimen.moments_stack_card_height)) * 1.17f);
            int a = (int) (((float) al.m9262a(this.mContext)) * 1.0f);
            int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.moment_stack_corner_radius);
            C3095y.m9471a("last time drew image was " + (System.currentTimeMillis() - this.mLastTimeLoaded) + " ago");
            long currentTimeMillis = System.currentTimeMillis() - this.mLastTimeLoaded;
            if ((!this.mIsGettingAndDrawingImage && currentTimeMillis >= 400) || z) {
                this.mLastTimeLoaded = System.currentTimeMillis();
                setMomentCard(this.mImgTopCard, moment.getMomentPhoto().getProcessedFile(PhotoSizeMoment.MED), a, dimensionPixelSize, dimensionPixelSize2);
            }
            this.mTxtTimeAgo.setText(moment.getTimeAgo(this.mContext));
        }
        this.mTxtUnreadMoments.setText(getResources().getQuantityString(R.plurals.num_moments, i, new Object[]{Integer.valueOf(i)}));
    }

    private void setMomentCard(@NonNull ImageView imageView, String str, int i, int i2, int i3) {
        C3095y.m9471a("loading url: " + str);
        this.mIsGettingAndDrawingImage = true;
        C2281x c31232 = new C31232(imageView);
        this.mTxtUnreadMoments.setTag(c31232);
        Picasso.m8982a(this.mContext).m8990a(str).m9129b(i, i2).m9127b().m9126a(c31232);
    }
}

package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.C0508R;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;

public final class ShareButton extends ShareButtonBase {

    /* renamed from: com.facebook.share.widget.ShareButton.1 */
    class C06541 implements OnClickListener {
        C06541() {
        }

        public void onClick(View view) {
            ShareDialog shareDialog;
            ShareButton.this.callExternalOnClickListener(view);
            if (ShareButton.this.getFragment() != null) {
                shareDialog = new ShareDialog(ShareButton.this.getFragment(), ShareButton.this.getRequestCode());
            } else {
                shareDialog = new ShareDialog(ShareButton.this.getActivity(), ShareButton.this.getRequestCode());
            }
            shareDialog.show(ShareButton.this.getShareContent());
        }
    }

    public ShareButton(Context context) {
        super(context, null, 0, AnalyticsEvents.EVENT_SHARE_BUTTON_CREATE, AnalyticsEvents.EVENT_SHARE_BUTTON_DID_TAP);
    }

    public ShareButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, AnalyticsEvents.EVENT_SHARE_BUTTON_CREATE, AnalyticsEvents.EVENT_SHARE_BUTTON_DID_TAP);
    }

    public ShareButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, AnalyticsEvents.EVENT_SHARE_BUTTON_CREATE, AnalyticsEvents.EVENT_SHARE_BUTTON_DID_TAP);
    }

    protected int getDefaultStyleResource() {
        return C0508R.style.com_facebook_button_share;
    }

    protected OnClickListener getShareOnClickListener() {
        return new C06541();
    }

    protected int getDefaultRequestCode() {
        return RequestCodeOffset.Share.toRequestCode();
    }
}

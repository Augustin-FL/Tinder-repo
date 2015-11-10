package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.C0508R;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;

public final class SendButton extends ShareButtonBase {

    /* renamed from: com.facebook.share.widget.SendButton.1 */
    class C06531 implements OnClickListener {
        C06531() {
        }

        public void onClick(View view) {
            MessageDialog messageDialog;
            SendButton.this.callExternalOnClickListener(view);
            if (SendButton.this.getFragment() != null) {
                messageDialog = new MessageDialog(SendButton.this.getFragment(), SendButton.this.getRequestCode());
            } else {
                messageDialog = new MessageDialog(SendButton.this.getActivity(), SendButton.this.getRequestCode());
            }
            messageDialog.show(SendButton.this.getShareContent());
        }
    }

    public SendButton(Context context) {
        super(context, null, 0, AnalyticsEvents.EVENT_SEND_BUTTON_CREATE, AnalyticsEvents.EVENT_SEND_BUTTON_DID_TAP);
    }

    public SendButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, AnalyticsEvents.EVENT_SEND_BUTTON_CREATE, AnalyticsEvents.EVENT_SEND_BUTTON_DID_TAP);
    }

    public SendButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, AnalyticsEvents.EVENT_SEND_BUTTON_CREATE, AnalyticsEvents.EVENT_SEND_BUTTON_DID_TAP);
    }

    protected int getDefaultStyleResource() {
        return C0508R.style.com_facebook_button_send;
    }

    protected OnClickListener getShareOnClickListener() {
        return new C06531();
    }

    protected int getDefaultRequestCode() {
        return RequestCodeOffset.Message.toRequestCode();
    }
}

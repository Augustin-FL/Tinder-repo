package com.facebook.share.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import com.facebook.FacebookCallback;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.Callback;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.DialogFeature;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.DialogPresenter.ParameterProvider;
import com.facebook.internal.FacebookDialogBase;
import java.util.ArrayList;
import java.util.List;

public class LikeDialog extends FacebookDialogBase<LikeContent, Result> {
    private static final int DEFAULT_REQUEST_CODE;
    private static final String TAG = "LikeDialog";

    /* renamed from: com.facebook.share.internal.LikeDialog.1 */
    class C06111 extends ResultProcessor {
        final /* synthetic */ FacebookCallback val$callback;

        C06111(FacebookCallback facebookCallback, FacebookCallback facebookCallback2) {
            this.val$callback = facebookCallback2;
            super(facebookCallback);
        }

        public void onSuccess(AppCall appCall, Bundle bundle) {
            this.val$callback.onSuccess(new Result(bundle));
        }
    }

    /* renamed from: com.facebook.share.internal.LikeDialog.2 */
    class C06122 implements Callback {
        final /* synthetic */ ResultProcessor val$resultProcessor;

        C06122(ResultProcessor resultProcessor) {
            this.val$resultProcessor = resultProcessor;
        }

        public boolean onActivityResult(int i, Intent intent) {
            return ShareInternalUtility.handleActivityResult(LikeDialog.this.getRequestCode(), i, intent, this.val$resultProcessor);
        }
    }

    private class NativeHandler extends ModeHandler {

        /* renamed from: com.facebook.share.internal.LikeDialog.NativeHandler.1 */
        class C06131 implements ParameterProvider {
            final /* synthetic */ LikeContent val$content;

            C06131(LikeContent likeContent) {
                this.val$content = likeContent;
            }

            public Bundle getParameters() {
                return LikeDialog.createParameters(this.val$content);
            }

            public Bundle getLegacyParameters() {
                Log.e(LikeDialog.TAG, "Attempting to present the Like Dialog with an outdated Facebook app on the device");
                return new Bundle();
            }
        }

        private NativeHandler() {
            super();
        }

        public boolean canShow(LikeContent likeContent) {
            return likeContent != null && LikeDialog.canShowNativeDialog();
        }

        public AppCall createAppCall(LikeContent likeContent) {
            AppCall createBaseAppCall = LikeDialog.this.createBaseAppCall();
            DialogPresenter.setupAppCallForNativeDialog(createBaseAppCall, new C06131(likeContent), LikeDialog.getFeature());
            return createBaseAppCall;
        }
    }

    public static final class Result {
        private final Bundle bundle;

        public Result(Bundle bundle) {
            this.bundle = bundle;
        }

        public Bundle getData() {
            return this.bundle;
        }
    }

    private class WebFallbackHandler extends ModeHandler {
        private WebFallbackHandler() {
            super();
        }

        public boolean canShow(LikeContent likeContent) {
            return likeContent != null && LikeDialog.canShowWebFallback();
        }

        public AppCall createAppCall(LikeContent likeContent) {
            AppCall createBaseAppCall = LikeDialog.this.createBaseAppCall();
            DialogPresenter.setupAppCallForWebFallbackDialog(createBaseAppCall, LikeDialog.createParameters(likeContent), LikeDialog.getFeature());
            return createBaseAppCall;
        }
    }

    static {
        DEFAULT_REQUEST_CODE = RequestCodeOffset.Like.toRequestCode();
    }

    public static boolean canShowNativeDialog() {
        return VERSION.SDK_INT >= 14 && DialogPresenter.canPresentNativeDialogWithFeature(getFeature());
    }

    public static boolean canShowWebFallback() {
        return VERSION.SDK_INT >= 14 && DialogPresenter.canPresentWebFallbackDialogWithFeature(getFeature());
    }

    public LikeDialog(Activity activity) {
        super(activity, DEFAULT_REQUEST_CODE);
    }

    public LikeDialog(Fragment fragment) {
        super(fragment, DEFAULT_REQUEST_CODE);
    }

    protected AppCall createBaseAppCall() {
        return new AppCall(getRequestCode());
    }

    protected List<ModeHandler> getOrderedModeHandlers() {
        List arrayList = new ArrayList();
        arrayList.add(new NativeHandler());
        arrayList.add(new WebFallbackHandler());
        return arrayList;
    }

    protected void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, FacebookCallback<Result> facebookCallback) {
        callbackManagerImpl.registerCallback(getRequestCode(), new C06122(facebookCallback == null ? null : new C06111(facebookCallback, facebookCallback)));
    }

    private static DialogFeature getFeature() {
        return LikeDialogFeature.LIKE_DIALOG;
    }

    private static Bundle createParameters(LikeContent likeContent) {
        Bundle bundle = new Bundle();
        bundle.putString(ShareConstants.WEB_DIALOG_PARAM_OBJECT_ID, likeContent.getObjectId());
        bundle.putString(ShareConstants.OBJECT_TYPE, likeContent.getObjectType());
        return bundle;
    }
}

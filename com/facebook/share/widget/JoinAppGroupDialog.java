package com.facebook.share.widget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.FacebookCallback;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.Callback;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.internal.ShareInternalUtility;
import java.util.ArrayList;
import java.util.List;

public class JoinAppGroupDialog extends FacebookDialogBase<String, Result> {
    private static final int DEFAULT_REQUEST_CODE;
    private static final String JOIN_GAME_GROUP_DIALOG = "game_group_join";

    /* renamed from: com.facebook.share.widget.JoinAppGroupDialog.1 */
    class C06471 extends ResultProcessor {
        final /* synthetic */ FacebookCallback val$callback;

        C06471(FacebookCallback facebookCallback, FacebookCallback facebookCallback2) {
            this.val$callback = facebookCallback2;
            super(facebookCallback);
        }

        public void onSuccess(AppCall appCall, Bundle bundle) {
            this.val$callback.onSuccess(new Result(null));
        }
    }

    /* renamed from: com.facebook.share.widget.JoinAppGroupDialog.2 */
    class C06482 implements Callback {
        final /* synthetic */ ResultProcessor val$resultProcessor;

        C06482(ResultProcessor resultProcessor) {
            this.val$resultProcessor = resultProcessor;
        }

        public boolean onActivityResult(int i, Intent intent) {
            return ShareInternalUtility.handleActivityResult(JoinAppGroupDialog.this.getRequestCode(), i, intent, this.val$resultProcessor);
        }
    }

    public static final class Result {
        private final Bundle data;

        private Result(Bundle bundle) {
            this.data = bundle;
        }

        public Bundle getData() {
            return this.data;
        }
    }

    private class WebHandler extends ModeHandler {
        private WebHandler() {
            super();
        }

        public boolean canShow(String str) {
            return true;
        }

        public AppCall createAppCall(String str) {
            AppCall createBaseAppCall = JoinAppGroupDialog.this.createBaseAppCall();
            Bundle bundle = new Bundle();
            bundle.putString(ShareConstants.WEB_DIALOG_PARAM_ID, str);
            DialogPresenter.setupAppCallForWebDialog(createBaseAppCall, JoinAppGroupDialog.JOIN_GAME_GROUP_DIALOG, bundle);
            return createBaseAppCall;
        }
    }

    static {
        DEFAULT_REQUEST_CODE = RequestCodeOffset.AppGroupJoin.toRequestCode();
    }

    public static boolean canShow() {
        return true;
    }

    public static void show(Activity activity, String str) {
        new JoinAppGroupDialog(activity).show(str);
    }

    public static void show(Fragment fragment, String str) {
        new JoinAppGroupDialog(fragment).show(str);
    }

    public JoinAppGroupDialog(Activity activity) {
        super(activity, DEFAULT_REQUEST_CODE);
    }

    public JoinAppGroupDialog(Fragment fragment) {
        super(fragment, DEFAULT_REQUEST_CODE);
    }

    protected void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, FacebookCallback<Result> facebookCallback) {
        callbackManagerImpl.registerCallback(getRequestCode(), new C06482(facebookCallback == null ? null : new C06471(facebookCallback, facebookCallback)));
    }

    protected AppCall createBaseAppCall() {
        return new AppCall(getRequestCode());
    }

    protected List<ModeHandler> getOrderedModeHandlers() {
        List arrayList = new ArrayList();
        arrayList.add(new WebHandler());
        return arrayList;
    }
}

package com.facebook.login;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookActivity;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.Callback;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.Validate;
import com.facebook.login.LoginClient.Request;
import com.facebook.login.LoginClient.Result;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class LoginManager {
    private static final String MANAGE_PERMISSION_PREFIX = "manage";
    private static final Set<String> OTHER_PUBLISH_PERMISSIONS;
    private static final String PUBLISH_PERMISSION_PREFIX = "publish";
    private static volatile LoginManager instance;
    private DefaultAudience defaultAudience;
    private LoginBehavior loginBehavior;
    private LoginLogger loginLogger;
    private HashMap<String, String> pendingLoggingExtras;
    private Request pendingLoginRequest;

    /* renamed from: com.facebook.login.LoginManager.1 */
    class C05661 implements Callback {
        final /* synthetic */ FacebookCallback val$callback;

        C05661(FacebookCallback facebookCallback) {
            this.val$callback = facebookCallback;
        }

        public boolean onActivityResult(int i, Intent intent) {
            return LoginManager.this.onActivityResult(i, intent, this.val$callback);
        }
    }

    /* renamed from: com.facebook.login.LoginManager.2 */
    static class C05672 extends HashSet<String> {
        C05672() {
            add("ads_management");
            add("create_event");
            add("rsvp_event");
        }
    }

    /* renamed from: com.facebook.login.LoginManager.3 */
    class C05683 implements Callback {
        C05683() {
        }

        public boolean onActivityResult(int i, Intent intent) {
            return LoginManager.this.onActivityResult(i, intent);
        }
    }

    private static class ActivityStartActivityDelegate implements StartActivityDelegate {
        private final Activity activity;

        ActivityStartActivityDelegate(Activity activity) {
            Validate.notNull(activity, "activity");
            this.activity = activity;
        }

        public void startActivityForResult(Intent intent, int i) {
            this.activity.startActivityForResult(intent, i);
        }

        public Activity getActivityContext() {
            return this.activity;
        }
    }

    private static class FragmentStartActivityDelegate implements StartActivityDelegate {
        private final Fragment fragment;

        FragmentStartActivityDelegate(Fragment fragment) {
            Validate.notNull(fragment, "fragment");
            this.fragment = fragment;
        }

        public void startActivityForResult(Intent intent, int i) {
            this.fragment.startActivityForResult(intent, i);
        }

        public Activity getActivityContext() {
            return this.fragment.getActivity();
        }
    }

    static {
        OTHER_PUBLISH_PERMISSIONS = getOtherPublishPermissions();
    }

    LoginManager() {
        this.loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
        this.defaultAudience = DefaultAudience.FRIENDS;
        Validate.sdkInitialized();
    }

    public static LoginManager getInstance() {
        if (instance == null) {
            synchronized (LoginManager.class) {
                if (instance == null) {
                    instance = new LoginManager();
                }
            }
        }
        return instance;
    }

    public void resolveError(Activity activity, GraphResponse graphResponse) {
        startLogin(new ActivityStartActivityDelegate(activity), createLoginRequestFromResponse(graphResponse));
    }

    public void resolveError(Fragment fragment, GraphResponse graphResponse) {
        startLogin(new FragmentStartActivityDelegate(fragment), createLoginRequestFromResponse(graphResponse));
    }

    private Request createLoginRequestFromResponse(GraphResponse graphResponse) {
        Validate.notNull(graphResponse, "response");
        AccessToken accessToken = graphResponse.getRequest().getAccessToken();
        return createLoginRequest(accessToken != null ? accessToken.getPermissions() : null);
    }

    public void registerCallback(CallbackManager callbackManager, FacebookCallback<LoginResult> facebookCallback) {
        if (callbackManager instanceof CallbackManagerImpl) {
            ((CallbackManagerImpl) callbackManager).registerCallback(RequestCodeOffset.Login.toRequestCode(), new C05661(facebookCallback));
            return;
        }
        throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
    }

    boolean onActivityResult(int i, Intent intent) {
        return onActivityResult(i, intent, null);
    }

    boolean onActivityResult(int i, Intent intent, FacebookCallback<LoginResult> facebookCallback) {
        boolean z = false;
        Map map = null;
        if (this.pendingLoginRequest == null) {
            return false;
        }
        Exception exception;
        AccessToken accessToken;
        Code code = Code.ERROR;
        if (intent != null) {
            AccessToken accessToken2;
            Code code2;
            Map map2;
            Result result = (Result) intent.getParcelableExtra("com.facebook.LoginFragment:Result");
            if (result != null) {
                Code code3 = result.code;
                if (i == -1) {
                    if (result.code == Code.SUCCESS) {
                        accessToken2 = result.token;
                    } else {
                        Object facebookAuthorizationException = new FacebookAuthorizationException(result.errorMessage);
                        Object obj = null;
                    }
                } else if (i == 0) {
                    z = true;
                    accessToken2 = null;
                } else {
                    accessToken2 = null;
                }
                Map map3 = result.loggingExtras;
                code2 = code3;
                map2 = map;
                map = map3;
            } else {
                code2 = code;
                map2 = null;
                accessToken2 = null;
            }
            Code code4 = code2;
            exception = map2;
            accessToken = accessToken2;
            code = code4;
        } else if (i == 0) {
            z = true;
            code = Code.CANCEL;
            accessToken = null;
            exception = null;
        } else {
            accessToken = null;
            exception = null;
        }
        if (exception == null && accessToken == null && !z) {
            exception = new FacebookException("Unexpected call to LoginManager.onActivityResult");
        }
        logCompleteLogin(code, map, exception);
        finishLogin(accessToken, exception, z, facebookCallback);
        return true;
    }

    public LoginBehavior getLoginBehavior() {
        return this.loginBehavior;
    }

    public LoginManager setLoginBehavior(LoginBehavior loginBehavior) {
        this.loginBehavior = loginBehavior;
        return this;
    }

    public DefaultAudience getDefaultAudience() {
        return this.defaultAudience;
    }

    public LoginManager setDefaultAudience(DefaultAudience defaultAudience) {
        this.defaultAudience = defaultAudience;
        return this;
    }

    public void logOut() {
        AccessToken.setCurrentAccessToken(null);
        Profile.setCurrentProfile(null);
    }

    public void logInWithReadPermissions(Fragment fragment, Collection<String> collection) {
        validateReadPermissions(collection);
        startLogin(new FragmentStartActivityDelegate(fragment), createLoginRequest(collection));
    }

    public void logInWithReadPermissions(Activity activity, Collection<String> collection) {
        validateReadPermissions(collection);
        startLogin(new ActivityStartActivityDelegate(activity), createLoginRequest(collection));
    }

    public void logInWithPublishPermissions(Fragment fragment, Collection<String> collection) {
        validatePublishPermissions(collection);
        startLogin(new FragmentStartActivityDelegate(fragment), createLoginRequest(collection));
    }

    public void logInWithPublishPermissions(Activity activity, Collection<String> collection) {
        validatePublishPermissions(collection);
        startLogin(new ActivityStartActivityDelegate(activity), createLoginRequest(collection));
    }

    Request getPendingLoginRequest() {
        return this.pendingLoginRequest;
    }

    private void validateReadPermissions(Collection<String> collection) {
        if (collection != null) {
            for (String isPublishPermission : collection) {
                if (isPublishPermission(isPublishPermission)) {
                    throw new FacebookException(String.format("Cannot pass a publish or manage permission (%s) to a request for read authorization", new Object[]{(String) r1.next()}));
                }
            }
        }
    }

    private void validatePublishPermissions(Collection<String> collection) {
        if (collection != null) {
            for (String isPublishPermission : collection) {
                if (!isPublishPermission(isPublishPermission)) {
                    throw new FacebookException(String.format("Cannot pass a read permission (%s) to a request for publish authorization", new Object[]{(String) r1.next()}));
                }
            }
        }
    }

    static boolean isPublishPermission(String str) {
        return str != null && (str.startsWith(PUBLISH_PERMISSION_PREFIX) || str.startsWith(MANAGE_PERMISSION_PREFIX) || OTHER_PUBLISH_PERMISSIONS.contains(str));
    }

    private static Set<String> getOtherPublishPermissions() {
        return Collections.unmodifiableSet(new C05672());
    }

    private Request createLoginRequest(Collection<String> collection) {
        Request request = new Request(this.loginBehavior, Collections.unmodifiableSet(collection != null ? new HashSet(collection) : new HashSet()), this.defaultAudience, FacebookSdk.getApplicationId(), UUID.randomUUID().toString());
        request.setRerequest(AccessToken.getCurrentAccessToken() != null);
        return request;
    }

    private void startLogin(StartActivityDelegate startActivityDelegate, Request request) throws FacebookException {
        this.pendingLoginRequest = request;
        this.pendingLoggingExtras = new HashMap();
        this.loginLogger = getLoggerForContext(startActivityDelegate.getActivityContext());
        logStartLogin();
        CallbackManagerImpl.registerStaticCallback(RequestCodeOffset.Login.toRequestCode(), new C05683());
        boolean tryFacebookActivity = tryFacebookActivity(startActivityDelegate, request);
        this.pendingLoggingExtras.put("try_login_activity", tryFacebookActivity ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        if (!tryFacebookActivity) {
            Exception facebookException = new FacebookException("Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
            logCompleteLogin(Code.ERROR, null, facebookException);
            this.pendingLoginRequest = null;
            throw facebookException;
        }
    }

    private LoginLogger getLoggerForContext(Context context) {
        if (context == null || this.pendingLoginRequest == null) {
            return null;
        }
        LoginLogger loginLogger = this.loginLogger;
        if (loginLogger == null || !loginLogger.getApplicationId().equals(this.pendingLoginRequest.getApplicationId())) {
            return new LoginLogger(context, this.pendingLoginRequest.getApplicationId());
        }
        return loginLogger;
    }

    private void logStartLogin() {
        if (this.loginLogger != null && this.pendingLoginRequest != null) {
            this.loginLogger.logStartLogin(this.pendingLoginRequest);
        }
    }

    private void logCompleteLogin(Code code, Map<String, String> map, Exception exception) {
        if (this.loginLogger != null) {
            if (this.pendingLoginRequest == null) {
                this.loginLogger.logUnexpectedError("fb_mobile_login_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.");
            } else {
                this.loginLogger.logCompleteLogin(this.pendingLoginRequest.getAuthId(), this.pendingLoggingExtras, code, map, exception);
            }
        }
    }

    private boolean tryFacebookActivity(StartActivityDelegate startActivityDelegate, Request request) {
        Intent facebookActivityIntent = getFacebookActivityIntent(request);
        if (!resolveIntent(facebookActivityIntent)) {
            return false;
        }
        try {
            startActivityDelegate.startActivityForResult(facebookActivityIntent, LoginClient.getLoginRequestCode());
            return true;
        } catch (ActivityNotFoundException e) {
            return false;
        }
    }

    private boolean resolveIntent(Intent intent) {
        if (FacebookSdk.getApplicationContext().getPackageManager().resolveActivity(intent, 0) == null) {
            return false;
        }
        return true;
    }

    private Intent getFacebookActivityIntent(Request request) {
        Intent intent = new Intent();
        intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
        intent.setAction(request.getLoginBehavior().toString());
        intent.putExtras(LoginFragment.populateIntentExtras(request));
        return intent;
    }

    static LoginResult computeLoginResult(Request request, AccessToken accessToken) {
        Collection permissions = request.getPermissions();
        Object hashSet = new HashSet(accessToken.getPermissions());
        if (request.isRerequest()) {
            hashSet.retainAll(permissions);
        }
        Set hashSet2 = new HashSet(permissions);
        hashSet2.removeAll(hashSet);
        return new LoginResult(accessToken, hashSet, hashSet2);
    }

    private void finishLogin(AccessToken accessToken, FacebookException facebookException, boolean z, FacebookCallback<LoginResult> facebookCallback) {
        if (accessToken != null) {
            AccessToken.setCurrentAccessToken(accessToken);
            Profile.fetchProfileForCurrentAccessToken();
        }
        if (facebookCallback != null) {
            LoginResult computeLoginResult = accessToken != null ? computeLoginResult(this.pendingLoginRequest, accessToken) : null;
            if (z || (computeLoginResult != null && computeLoginResult.getRecentlyGrantedPermissions().size() == 0)) {
                facebookCallback.onCancel();
            } else if (facebookException != null) {
                facebookCallback.onError(facebookException);
            } else if (accessToken != null) {
                facebookCallback.onSuccess(computeLoginResult);
            }
        }
        this.pendingLoginRequest = null;
        this.loginLogger = null;
    }
}

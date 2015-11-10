package com.facebook;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.FetchedAppSettings;
import java.net.HttpURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

public final class FacebookRequestError {
    private static final String BODY_KEY = "body";
    private static final String CODE_KEY = "code";
    private static final String ERROR_CODE_FIELD_KEY = "code";
    private static final String ERROR_CODE_KEY = "error_code";
    private static final String ERROR_IS_TRANSIENT_KEY = "is_transient";
    private static final String ERROR_KEY = "error";
    private static final String ERROR_MESSAGE_FIELD_KEY = "message";
    private static final String ERROR_MSG_KEY = "error_msg";
    private static final String ERROR_REASON_KEY = "error_reason";
    private static final String ERROR_SUB_CODE_KEY = "error_subcode";
    private static final String ERROR_TYPE_FIELD_KEY = "type";
    private static final String ERROR_USER_MSG_KEY = "error_user_msg";
    private static final String ERROR_USER_TITLE_KEY = "error_user_title";
    static final Range HTTP_RANGE_SUCCESS;
    public static final int INVALID_ERROR_CODE = -1;
    public static final int INVALID_HTTP_STATUS_CODE = -1;
    private final Object batchRequestResult;
    private final Category category;
    private final HttpURLConnection connection;
    private final int errorCode;
    private final String errorMessage;
    private final String errorRecoveryMessage;
    private final String errorType;
    private final String errorUserMessage;
    private final String errorUserTitle;
    private final FacebookException exception;
    private final JSONObject requestResult;
    private final JSONObject requestResultBody;
    private final int requestStatusCode;
    private final int subErrorCode;

    public enum Category {
        LOGIN_RECOVERABLE,
        OTHER,
        TRANSIENT
    }

    private static class Range {
        private final int end;
        private final int start;

        private Range(int i, int i2) {
            this.start = i;
            this.end = i2;
        }

        boolean contains(int i) {
            return this.start <= i && i <= this.end;
        }
    }

    static {
        HTTP_RANGE_SUCCESS = new Range(299, null);
    }

    private FacebookRequestError(int i, int i2, int i3, String str, String str2, String str3, String str4, boolean z, JSONObject jSONObject, JSONObject jSONObject2, Object obj, HttpURLConnection httpURLConnection, FacebookException facebookException) {
        Category category;
        this.requestStatusCode = i;
        this.errorCode = i2;
        this.subErrorCode = i3;
        this.errorType = str;
        this.errorMessage = str2;
        this.requestResultBody = jSONObject;
        this.requestResult = jSONObject2;
        this.batchRequestResult = obj;
        this.connection = httpURLConnection;
        this.errorUserTitle = str3;
        this.errorUserMessage = str4;
        Object obj2 = null;
        if (facebookException != null) {
            this.exception = facebookException;
            obj2 = 1;
        } else {
            this.exception = new FacebookServiceException(this, str2);
        }
        FacebookRequestErrorClassification errorClassification = getErrorClassification();
        if (obj2 != null) {
            category = Category.OTHER;
        } else {
            category = errorClassification.classify(i2, i3, z);
        }
        this.category = category;
        this.errorRecoveryMessage = errorClassification.getRecoveryMessage(this.category);
    }

    FacebookRequestError(HttpURLConnection httpURLConnection, Exception exception) {
        FacebookException facebookException;
        if (exception instanceof FacebookException) {
            facebookException = (FacebookException) exception;
        } else {
            facebookException = new FacebookException((Throwable) exception);
        }
        this(INVALID_HTTP_STATUS_CODE, INVALID_HTTP_STATUS_CODE, INVALID_HTTP_STATUS_CODE, null, null, null, null, false, null, null, null, httpURLConnection, facebookException);
    }

    public FacebookRequestError(int i, String str, String str2) {
        this(INVALID_HTTP_STATUS_CODE, i, INVALID_HTTP_STATUS_CODE, str, str2, null, null, false, null, null, null, null, null);
    }

    public Category getCategory() {
        return this.category;
    }

    public int getRequestStatusCode() {
        return this.requestStatusCode;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public int getSubErrorCode() {
        return this.subErrorCode;
    }

    public String getErrorType() {
        return this.errorType;
    }

    public String getErrorMessage() {
        if (this.errorMessage != null) {
            return this.errorMessage;
        }
        return this.exception.getLocalizedMessage();
    }

    public String getErrorRecoveryMessage() {
        return this.errorRecoveryMessage;
    }

    public String getErrorUserMessage() {
        return this.errorUserMessage;
    }

    public String getErrorUserTitle() {
        return this.errorUserTitle;
    }

    public JSONObject getRequestResultBody() {
        return this.requestResultBody;
    }

    public JSONObject getRequestResult() {
        return this.requestResult;
    }

    public Object getBatchRequestResult() {
        return this.batchRequestResult;
    }

    public HttpURLConnection getConnection() {
        return this.connection;
    }

    public FacebookException getException() {
        return this.exception;
    }

    public String toString() {
        return "{HttpStatus: " + this.requestStatusCode + ", errorCode: " + this.errorCode + ", errorType: " + this.errorType + ", errorMessage: " + getErrorMessage() + "}";
    }

    static FacebookRequestError checkResponseAndCreateError(JSONObject jSONObject, Object obj, HttpURLConnection httpURLConnection) {
        try {
            if (jSONObject.has(ERROR_CODE_FIELD_KEY)) {
                JSONObject jSONObject2;
                int i = jSONObject.getInt(ERROR_CODE_FIELD_KEY);
                Object stringPropertyAsJSON = Utility.getStringPropertyAsJSON(jSONObject, BODY_KEY, GraphResponse.NON_JSON_RESPONSE_PROPERTY);
                if (stringPropertyAsJSON != null && (stringPropertyAsJSON instanceof JSONObject)) {
                    jSONObject2 = (JSONObject) stringPropertyAsJSON;
                    String str = null;
                    String str2 = null;
                    String str3 = null;
                    String str4 = null;
                    boolean z = false;
                    int i2 = INVALID_HTTP_STATUS_CODE;
                    int i3 = INVALID_HTTP_STATUS_CODE;
                    Object obj2 = null;
                    if (jSONObject2.has(ERROR_KEY)) {
                        JSONObject jSONObject3 = (JSONObject) Utility.getStringPropertyAsJSON(jSONObject2, ERROR_KEY, null);
                        str = jSONObject3.optString(ERROR_TYPE_FIELD_KEY, null);
                        str2 = jSONObject3.optString(ERROR_MESSAGE_FIELD_KEY, null);
                        i2 = jSONObject3.optInt(ERROR_CODE_FIELD_KEY, INVALID_HTTP_STATUS_CODE);
                        i3 = jSONObject3.optInt(ERROR_SUB_CODE_KEY, INVALID_HTTP_STATUS_CODE);
                        str3 = jSONObject3.optString(ERROR_USER_MSG_KEY, null);
                        str4 = jSONObject3.optString(ERROR_USER_TITLE_KEY, null);
                        z = jSONObject3.optBoolean(ERROR_IS_TRANSIENT_KEY, false);
                        obj2 = 1;
                    } else if (jSONObject2.has(ERROR_CODE_KEY) || jSONObject2.has(ERROR_MSG_KEY) || jSONObject2.has(ERROR_REASON_KEY)) {
                        str = jSONObject2.optString(ERROR_REASON_KEY, null);
                        str2 = jSONObject2.optString(ERROR_MSG_KEY, null);
                        i2 = jSONObject2.optInt(ERROR_CODE_KEY, INVALID_HTTP_STATUS_CODE);
                        i3 = jSONObject2.optInt(ERROR_SUB_CODE_KEY, INVALID_HTTP_STATUS_CODE);
                        obj2 = 1;
                    }
                    if (obj2 != null) {
                        return new FacebookRequestError(i, i2, i3, str, str2, str4, str3, z, jSONObject2, jSONObject, obj, httpURLConnection, null);
                    }
                }
                if (!HTTP_RANGE_SUCCESS.contains(i)) {
                    if (jSONObject.has(BODY_KEY)) {
                        jSONObject2 = (JSONObject) Utility.getStringPropertyAsJSON(jSONObject, BODY_KEY, GraphResponse.NON_JSON_RESPONSE_PROPERTY);
                    } else {
                        jSONObject2 = null;
                    }
                    return new FacebookRequestError(i, INVALID_HTTP_STATUS_CODE, INVALID_HTTP_STATUS_CODE, null, null, null, null, false, jSONObject2, jSONObject, obj, httpURLConnection, null);
                }
            }
        } catch (JSONException e) {
        }
        return null;
    }

    static synchronized FacebookRequestErrorClassification getErrorClassification() {
        FacebookRequestErrorClassification defaultErrorClassification;
        synchronized (FacebookRequestError.class) {
            FetchedAppSettings appSettingsWithoutQuery = Utility.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
            if (appSettingsWithoutQuery == null) {
                defaultErrorClassification = FacebookRequestErrorClassification.getDefaultErrorClassification();
            } else {
                defaultErrorClassification = appSettingsWithoutQuery.getErrorClassification();
            }
        }
        return defaultErrorClassification;
    }
}

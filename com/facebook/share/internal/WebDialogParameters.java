package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.Utility;
import com.facebook.share.model.AppGroupCreationContent;
import com.facebook.share.model.AppGroupCreationContent.AppGroupPrivacy;
import com.facebook.share.model.GameRequestContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import java.util.Locale;
import org.json.JSONObject;

public class WebDialogParameters {
    public static Bundle create(AppGroupCreationContent appGroupCreationContent) {
        Bundle bundle = new Bundle();
        Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_NAME, appGroupCreationContent.getName());
        Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_DESCRIPTION, appGroupCreationContent.getDescription());
        AppGroupPrivacy appGroupPrivacy = appGroupCreationContent.getAppGroupPrivacy();
        if (appGroupPrivacy != null) {
            Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_PRIVACY, appGroupPrivacy.toString().toLowerCase(Locale.ENGLISH));
        }
        return bundle;
    }

    public static Bundle create(GameRequestContent gameRequestContent) {
        Bundle bundle = new Bundle();
        Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_MESSAGE, gameRequestContent.getMessage());
        Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_TO, gameRequestContent.getTo());
        Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_TITLE, gameRequestContent.getTitle());
        Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_DATA, gameRequestContent.getData());
        if (gameRequestContent.getActionType() != null) {
            Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE, gameRequestContent.getActionType().toString().toLowerCase(Locale.ENGLISH));
        }
        Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_OBJECT_ID, gameRequestContent.getObjectId());
        if (gameRequestContent.getFilters() != null) {
            Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_FILTERS, gameRequestContent.getFilters().toString().toLowerCase(Locale.ENGLISH));
        }
        Utility.putCommaSeparatedStringList(bundle, ShareConstants.WEB_DIALOG_PARAM_SUGGESTIONS, gameRequestContent.getSuggestions());
        return bundle;
    }

    public static Bundle create(ShareLinkContent shareLinkContent) {
        Bundle bundle = new Bundle();
        Utility.putUri(bundle, ShareConstants.WEB_DIALOG_PARAM_HREF, shareLinkContent.getContentUrl());
        return bundle;
    }

    public static Bundle create(ShareOpenGraphContent shareOpenGraphContent) {
        Bundle bundle = new Bundle();
        Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE, shareOpenGraphContent.getAction().getActionType());
        try {
            JSONObject removeNamespacesFromOGJsonObject = ShareInternalUtility.removeNamespacesFromOGJsonObject(ShareInternalUtility.toJSONObjectForWeb(shareOpenGraphContent), false);
            if (removeNamespacesFromOGJsonObject != null) {
                Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_ACTION_PROPERTIES, removeNamespacesFromOGJsonObject.toString());
            }
            return bundle;
        } catch (Throwable e) {
            throw new FacebookException("Unable to serialize the ShareOpenGraphContent to JSON", e);
        }
    }

    public static Bundle createForFeed(ShareLinkContent shareLinkContent) {
        Bundle bundle = new Bundle();
        Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_NAME, shareLinkContent.getContentTitle());
        Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_DESCRIPTION, shareLinkContent.getContentDescription());
        Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_LINK, Utility.getUriString(shareLinkContent.getContentUrl()));
        Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_PICTURE, Utility.getUriString(shareLinkContent.getImageUrl()));
        return bundle;
    }

    public static Bundle createForFeed(ShareFeedContent shareFeedContent) {
        Bundle bundle = new Bundle();
        Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_TO, shareFeedContent.getToId());
        Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_LINK, shareFeedContent.getLink());
        Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_PICTURE, shareFeedContent.getPicture());
        Utility.putNonEmptyString(bundle, ShareConstants.FEED_SOURCE_PARAM, shareFeedContent.getMediaSource());
        Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_NAME, shareFeedContent.getLinkName());
        Utility.putNonEmptyString(bundle, ShareConstants.FEED_CAPTION_PARAM, shareFeedContent.getLinkCaption());
        Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_DESCRIPTION, shareFeedContent.getLinkDescription());
        return bundle;
    }
}

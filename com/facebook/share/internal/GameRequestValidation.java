package com.facebook.share.internal;

import com.facebook.internal.Validate;
import com.facebook.share.model.GameRequestContent;
import com.facebook.share.model.GameRequestContent.ActionType;

public class GameRequestValidation {
    public static void validate(GameRequestContent gameRequestContent) {
        int i;
        int i2;
        int i3 = 0;
        Validate.notNull(gameRequestContent.getMessage(), ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        if (gameRequestContent.getObjectId() != null) {
            i = 1;
        } else {
            i = 0;
        }
        if (gameRequestContent.getActionType() == ActionType.ASKFOR || gameRequestContent.getActionType() == ActionType.SEND) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if ((i ^ i2) != 0) {
            throw new IllegalArgumentException("Object id should be provided if and only if action type is send or askfor");
        }
        if (gameRequestContent.getTo() != null) {
            i3 = 1;
        }
        if (gameRequestContent.getSuggestions() != null) {
            i3++;
        }
        if (gameRequestContent.getFilters() != null) {
            i3++;
        }
        if (i3 > 1) {
            throw new IllegalArgumentException("Parameters to, filters and suggestions are mutually exclusive");
        }
    }
}

package android.support.v7.internal.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompatBase.Action;
import android.support.v7.appcompat.C0159R;
import android.widget.RemoteViews;
import java.text.NumberFormat;
import java.util.List;

public class NotificationCompatImplBase {
    static final int MAX_MEDIA_BUTTONS = 5;
    static final int MAX_MEDIA_BUTTONS_IN_COMPACT = 3;

    public static <T extends Action> void overrideContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, List<T> list, int[] iArr, boolean z2, PendingIntent pendingIntent) {
        notificationBuilderWithBuilderAccessor.getBuilder().setContent(generateContentView(context, charSequence, charSequence2, charSequence3, i, bitmap, charSequence4, z, j, list, iArr, z2, pendingIntent));
        if (z2) {
            notificationBuilderWithBuilderAccessor.getBuilder().setOngoing(true);
        }
    }

    private static <T extends Action> RemoteViews generateContentView(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, List<T> list, int[] iArr, boolean z2, PendingIntent pendingIntent) {
        int i2;
        RemoteViews applyStandardTemplate = applyStandardTemplate(context, charSequence, charSequence2, charSequence3, i, bitmap, charSequence4, z, j, C0159R.layout.notification_template_media, true);
        int size = list.size();
        if (iArr == null) {
            i2 = 0;
        } else {
            i2 = Math.min(iArr.length, MAX_MEDIA_BUTTONS_IN_COMPACT);
        }
        applyStandardTemplate.removeAllViews(C0159R.id.media_actions);
        if (i2 > 0) {
            for (int i3 = 0; i3 < i2; i3++) {
                if (i3 >= size) {
                    throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", new Object[]{Integer.valueOf(i3), Integer.valueOf(size - 1)}));
                }
                applyStandardTemplate.addView(C0159R.id.media_actions, generateMediaActionButton(context, (Action) list.get(iArr[i3])));
            }
        }
        if (z2) {
            applyStandardTemplate.setViewVisibility(C0159R.id.end_padder, 8);
            applyStandardTemplate.setViewVisibility(C0159R.id.cancel_action, 0);
            applyStandardTemplate.setOnClickPendingIntent(C0159R.id.cancel_action, pendingIntent);
            applyStandardTemplate.setInt(C0159R.id.cancel_action, "setAlpha", context.getResources().getInteger(C0159R.integer.cancel_button_image_alpha));
        } else {
            applyStandardTemplate.setViewVisibility(C0159R.id.end_padder, 0);
            applyStandardTemplate.setViewVisibility(C0159R.id.cancel_action, 8);
        }
        return applyStandardTemplate;
    }

    public static <T extends Action> void overrideBigContentView(Notification notification, Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, List<T> list, boolean z2, PendingIntent pendingIntent) {
        notification.bigContentView = generateBigContentView(context, charSequence, charSequence2, charSequence3, i, bitmap, charSequence4, z, j, list, z2, pendingIntent);
        if (z2) {
            notification.flags |= 2;
        }
    }

    private static <T extends Action> RemoteViews generateBigContentView(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, List<T> list, boolean z2, PendingIntent pendingIntent) {
        int min = Math.min(list.size(), MAX_MEDIA_BUTTONS);
        RemoteViews applyStandardTemplate = applyStandardTemplate(context, charSequence, charSequence2, charSequence3, i, bitmap, charSequence4, z, j, getBigLayoutResource(min), false);
        applyStandardTemplate.removeAllViews(C0159R.id.media_actions);
        if (min > 0) {
            for (int i2 = 0; i2 < min; i2++) {
                applyStandardTemplate.addView(C0159R.id.media_actions, generateMediaActionButton(context, (Action) list.get(i2)));
            }
        }
        if (z2) {
            applyStandardTemplate.setViewVisibility(C0159R.id.cancel_action, 0);
            applyStandardTemplate.setInt(C0159R.id.cancel_action, "setAlpha", context.getResources().getInteger(C0159R.integer.cancel_button_image_alpha));
            applyStandardTemplate.setOnClickPendingIntent(C0159R.id.cancel_action, pendingIntent);
        } else {
            applyStandardTemplate.setViewVisibility(C0159R.id.cancel_action, 8);
        }
        return applyStandardTemplate;
    }

    private static RemoteViews generateMediaActionButton(Context context, Action action) {
        Object obj = action.getActionIntent() == null ? 1 : null;
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), C0159R.layout.notification_media_action);
        remoteViews.setImageViewResource(C0159R.id.action0, action.getIcon());
        if (obj == null) {
            remoteViews.setOnClickPendingIntent(C0159R.id.action0, action.getActionIntent());
        }
        if (VERSION.SDK_INT >= 15) {
            remoteViews.setContentDescription(C0159R.id.action0, action.getTitle());
        }
        return remoteViews;
    }

    private static int getBigLayoutResource(int i) {
        if (i <= MAX_MEDIA_BUTTONS_IN_COMPACT) {
            return C0159R.layout.notification_template_big_media_narrow;
        }
        return C0159R.layout.notification_template_big_media;
    }

    private static RemoteViews applyStandardTemplate(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, int i2, boolean z2) {
        Object obj;
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), i2);
        Object obj2 = null;
        Object obj3 = null;
        if (bitmap == null || VERSION.SDK_INT < 16) {
            remoteViews.setViewVisibility(C0159R.id.icon, 8);
        } else {
            remoteViews.setImageViewBitmap(C0159R.id.icon, bitmap);
        }
        if (charSequence != null) {
            remoteViews.setTextViewText(C0159R.id.title, charSequence);
        }
        if (charSequence2 != null) {
            remoteViews.setTextViewText(C0159R.id.text, charSequence2);
            obj2 = 1;
        }
        if (charSequence3 != null) {
            remoteViews.setTextViewText(C0159R.id.info, charSequence3);
            remoteViews.setViewVisibility(C0159R.id.info, 0);
            obj = 1;
        } else if (i > 0) {
            if (i > context.getResources().getInteger(C0159R.integer.status_bar_notification_info_maxnum)) {
                remoteViews.setTextViewText(C0159R.id.info, context.getResources().getString(C0159R.string.status_bar_notification_info_overflow));
            } else {
                remoteViews.setTextViewText(C0159R.id.info, NumberFormat.getIntegerInstance().format((long) i));
            }
            remoteViews.setViewVisibility(C0159R.id.info, 0);
            int i3 = 1;
        } else {
            remoteViews.setViewVisibility(C0159R.id.info, 8);
            obj = obj2;
        }
        if (charSequence4 != null && VERSION.SDK_INT >= 16) {
            remoteViews.setTextViewText(C0159R.id.text, charSequence4);
            if (charSequence2 != null) {
                remoteViews.setTextViewText(C0159R.id.text2, charSequence2);
                remoteViews.setViewVisibility(C0159R.id.text2, 0);
                obj3 = 1;
            } else {
                remoteViews.setViewVisibility(C0159R.id.text2, 8);
            }
        }
        if (obj3 != null && VERSION.SDK_INT >= 16) {
            if (z2) {
                remoteViews.setTextViewTextSize(C0159R.id.text, 0, (float) context.getResources().getDimensionPixelSize(C0159R.dimen.notification_subtext_size));
            }
            remoteViews.setViewPadding(C0159R.id.line1, 0, 0, 0, 0);
        }
        if (j != 0) {
            if (z) {
                remoteViews.setViewVisibility(C0159R.id.chronometer, 0);
                remoteViews.setLong(C0159R.id.chronometer, "setBase", (SystemClock.elapsedRealtime() - System.currentTimeMillis()) + j);
                remoteViews.setBoolean(C0159R.id.chronometer, "setStarted", true);
            } else {
                remoteViews.setViewVisibility(C0159R.id.time, 0);
                remoteViews.setLong(C0159R.id.time, "setTime", j);
            }
        }
        remoteViews.setViewVisibility(C0159R.id.line3, obj != null ? 0 : 8);
        return remoteViews;
    }
}

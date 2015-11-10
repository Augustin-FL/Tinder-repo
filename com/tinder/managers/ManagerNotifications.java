package com.tinder.managers;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat.Action;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.app.NotificationCompat.Extender;
import android.support.v4.app.NotificationCompat.WearableExtender;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.RemoteInput;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.stetho.BuildConfig;
import com.tinder.R;
import com.tinder.activities.ActivityMain;
import com.tinder.enums.PhotoSizeMoment;
import com.tinder.fragments.FragmentMessages;
import com.tinder.model.Match;
import com.tinder.model.Moment;
import com.tinder.model.MomentLike;
import com.tinder.model.SparksEvent;
import com.tinder.model.User;
import com.tinder.p030d.C2433n;
import com.tinder.p030d.C2434o;
import com.tinder.p030d.bw;
import com.tinder.p031b.C2392e;
import com.tinder.picassowebp.picasso.C2281x;
import com.tinder.picassowebp.picasso.Picasso;
import com.tinder.picassowebp.picasso.Picasso.LoadedFrom;
import com.tinder.services.WearIntentService;
import com.tinder.utils.C3061b;
import com.tinder.utils.C3061b.C2774c;
import com.tinder.utils.C3064c;
import com.tinder.utils.C3064c.C2316c;
import com.tinder.utils.C3064c.C2318a;
import com.tinder.utils.C3064c.C2669b;
import com.tinder.utils.C3070i;
import com.tinder.utils.C3095y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class ManagerNotifications implements C2774c {
    @NonNull
    private final Context f5713a;
    @NonNull
    private final NotificationManager f5714b;
    private Notification f5715c;
    private PendingIntent f5716d;
    private String f5717e;
    private String f5718f;
    @NonNull
    private Map<String, C2281x> f5719g;
    @NonNull
    private LinkedList<Long> f5720h;
    @NonNull
    private ArrayList<Toast> f5721i;
    private C3061b f5722j;

    /* renamed from: com.tinder.managers.ManagerNotifications.1 */
    class C27881 implements C2433n {
        final /* synthetic */ C2792a f5673a;
        final /* synthetic */ ManagerNotifications f5674b;

        /* renamed from: com.tinder.managers.ManagerNotifications.1.1 */
        class C27841 implements C2669b {
            final /* synthetic */ Match f5665a;
            final /* synthetic */ C27881 f5666b;

            C27841(C27881 c27881, Match match) {
                this.f5666b = c27881;
                this.f5665a = match;
            }

            public void m7989a() {
                C2392e c2392e = new C2392e();
                C2392e.m6507a(this.f5665a);
            }
        }

        /* renamed from: com.tinder.managers.ManagerNotifications.1.2 */
        class C27852 implements C2281x {
            final /* synthetic */ String f5667a;
            final /* synthetic */ Match f5668b;
            final /* synthetic */ C27881 f5669c;

            C27852(C27881 c27881, String str, Match match) {
                this.f5669c = c27881;
                this.f5667a = str;
                this.f5668b = match;
            }

            public void onBitmapLoaded(Bitmap bitmap, LoadedFrom loadedFrom) {
                this.f5669c.f5674b.f5719g.remove(this.f5667a);
                this.f5669c.f5673a.m7998a(this.f5668b, bitmap);
            }

            public void onBitmapFailed(Drawable drawable) {
                this.f5669c.f5674b.f5719g.remove(this.f5667a);
                this.f5669c.f5673a.m7997a(this.f5668b);
            }

            public void onPrepareLoad(Drawable drawable) {
            }
        }

        /* renamed from: com.tinder.managers.ManagerNotifications.1.3 */
        class C27863 implements C2316c {
            final /* synthetic */ C2281x f5670a;
            final /* synthetic */ C27881 f5671b;

            C27863(C27881 c27881, C2281x c2281x) {
                this.f5671b = c27881;
                this.f5670a = c2281x;
            }

            public void m7990a(Object obj) {
                this.f5670a.onBitmapLoaded((Bitmap) obj, LoadedFrom.DISK);
            }
        }

        /* renamed from: com.tinder.managers.ManagerNotifications.1.4 */
        class C27874 implements C2318a {
            final /* synthetic */ C27881 f5672a;

            C27874(C27881 c27881) {
                this.f5672a = c27881;
            }

            public Object m7991a() {
                return BitmapFactory.decodeResource(this.f5672a.f5674b.f5713a.getResources(), R.drawable.tinder_flame_icon);
            }
        }

        C27881(ManagerNotifications managerNotifications, C2792a c2792a) {
            this.f5674b = managerNotifications;
            this.f5673a = c2792a;
        }

        public void m7993a(@NonNull Match match) {
            C3095y.m9471a("got match for push notification successfully");
            CharSequence thumbnailUrl = match.getThumbnailUrl();
            int dimension = (int) this.f5674b.f5713a.getResources().getDimension(R.dimen.notification_big_icon_length);
            ManagerApp.m7925p().m8281b(match);
            C3064c.m9337a(new C27841(this, match));
            C2281x c27852 = new C27852(this, thumbnailUrl, match);
            if (TextUtils.isEmpty(thumbnailUrl)) {
                C3064c.m9336a(new C27874(this)).m9340a(new C27863(this, c27852)).m9341a();
                return;
            }
            this.f5674b.f5719g.put(thumbnailUrl, c27852);
            Picasso.m8982a(this.f5674b.f5713a).m8990a(match.getThumbnailUrl()).m9129b(dimension, dimension).m9126a(c27852);
        }

        public void m7992a() {
            C3095y.m9479c("failed to get match for push notification");
            this.f5673a.m7996a();
        }
    }

    /* renamed from: com.tinder.managers.ManagerNotifications.2 */
    class C27912 implements Runnable {
        final /* synthetic */ String f5679a;
        final /* synthetic */ C2794b f5680b;
        final /* synthetic */ ManagerNotifications f5681c;

        /* renamed from: com.tinder.managers.ManagerNotifications.2.1 */
        class C27901 implements C2434o {
            final /* synthetic */ C27912 f5678a;

            /* renamed from: com.tinder.managers.ManagerNotifications.2.1.1 */
            class C27891 implements C2281x {
                final /* synthetic */ String f5675a;
                final /* synthetic */ Moment f5676b;
                final /* synthetic */ C27901 f5677c;

                C27891(C27901 c27901, String str, Moment moment) {
                    this.f5677c = c27901;
                    this.f5675a = str;
                    this.f5676b = moment;
                }

                public void onBitmapLoaded(Bitmap bitmap, LoadedFrom loadedFrom) {
                    this.f5677c.f5678a.f5681c.f5719g.remove(this.f5675a);
                    this.f5677c.f5678a.f5680b.m8004a(this.f5676b, bitmap);
                }

                public void onBitmapFailed(Drawable drawable) {
                    this.f5677c.f5678a.f5681c.f5719g.remove(this.f5675a);
                    this.f5677c.f5678a.f5680b.m8003a(this.f5676b);
                }

                public void onPrepareLoad(Drawable drawable) {
                }
            }

            C27901(C27912 c27912) {
                this.f5678a = c27912;
            }

            public void m7995a(@NonNull Moment moment) {
                String processedFile = moment.getMomentPhoto().getProcessedFile(PhotoSizeMoment.MED);
                int dimension = (int) this.f5678a.f5681c.f5713a.getResources().getDimension(R.dimen.notification_big_icon_length);
                C2281x c27891 = new C27891(this, processedFile, moment);
                this.f5678a.f5681c.f5719g.put(processedFile, c27891);
                Picasso.m8982a(this.f5678a.f5681c.f5713a).m8990a(processedFile).m9129b(dimension, dimension).m9127b().m9126a(c27891);
            }

            public void m7994a() {
                this.f5678a.f5680b.m8002a();
            }
        }

        C27912(ManagerNotifications managerNotifications, String str, C2794b c2794b) {
            this.f5681c = managerNotifications;
            this.f5679a = str;
            this.f5680b = c2794b;
        }

        public void run() {
            ManagerApp.m7926q().m8464a(this.f5679a, new C27901(this));
        }
    }

    /* renamed from: com.tinder.managers.ManagerNotifications.a */
    interface C2792a {
        void m7996a();

        void m7997a(Match match);

        void m7998a(Match match, Bitmap bitmap);
    }

    /* renamed from: com.tinder.managers.ManagerNotifications.3 */
    class C27933 implements C2792a {
        final /* synthetic */ String f5682a;
        final /* synthetic */ NotificationType f5683b;
        final /* synthetic */ ManagerNotifications f5684c;

        C27933(ManagerNotifications managerNotifications, String str, NotificationType notificationType) {
            this.f5684c = managerNotifications;
            this.f5682a = str;
            this.f5683b = notificationType;
        }

        public void m8001a(Match match, Bitmap bitmap) {
            this.f5684c.m8024a(this.f5682a, this.f5683b, match, bitmap);
        }

        public void m8000a(Match match) {
            this.f5684c.m8024a(this.f5682a, this.f5683b, match, null);
        }

        public void m7999a() {
            this.f5684c.m8038a(this.f5682a);
        }
    }

    /* renamed from: com.tinder.managers.ManagerNotifications.b */
    interface C2794b {
        void m8002a();

        void m8003a(Moment moment);

        void m8004a(Moment moment, Bitmap bitmap);
    }

    /* renamed from: com.tinder.managers.ManagerNotifications.4 */
    class C27954 implements C2794b {
        final /* synthetic */ String f5685a;
        final /* synthetic */ String f5686b;
        final /* synthetic */ String f5687c;
        final /* synthetic */ String f5688d;
        final /* synthetic */ ManagerNotifications f5689e;

        C27954(ManagerNotifications managerNotifications, String str, String str2, String str3, String str4) {
            this.f5689e = managerNotifications;
            this.f5685a = str;
            this.f5686b = str2;
            this.f5687c = str3;
            this.f5688d = str4;
        }

        public void m8007a(@NonNull Moment moment, Bitmap bitmap) {
            String c = ManagerApp.m7925p().m8286c(this.f5685a);
            if (c.length() == 0) {
                c = this.f5689e.f5713a.getResources().getString(R.string.somebody);
            }
            ManagerApp.m7926q().m8462a(new MomentLike(this.f5686b, this.f5687c, this.f5685a, moment.getMomentPhoto().getProcessedFile(PhotoSizeMoment.THUMB), C3070i.m9362a(this.f5686b)), true);
            this.f5689e.m8027a(this.f5688d, moment, c, bitmap);
        }

        public void m8006a(@NonNull Moment moment) {
            String c = ManagerApp.m7925p().m8286c(this.f5685a);
            if (c.length() == 0) {
                c = this.f5689e.f5713a.getResources().getString(R.string.somebody);
            }
            ManagerApp.m7926q().m8462a(new MomentLike(this.f5686b, this.f5687c, this.f5685a, moment.getMomentPhoto().getProcessedFile(PhotoSizeMoment.THUMB), C3070i.m9362a(this.f5686b)), true);
            this.f5689e.m8027a(this.f5688d, moment, c, null);
        }

        public void m8005a() {
            this.f5689e.m8038a(this.f5689e.f5713a.getString(R.string.moment_like_notification_no_moment_found));
        }
    }

    /* renamed from: com.tinder.managers.ManagerNotifications.c */
    interface C2796c {
        void m8008a();

        void m8009a(User user);

        void m8010a(User user, Bitmap bitmap);
    }

    /* renamed from: com.tinder.managers.ManagerNotifications.5 */
    class C27975 implements C2796c {
        final /* synthetic */ String f5690a;
        final /* synthetic */ String f5691b;
        final /* synthetic */ ManagerNotifications f5692c;

        C27975(ManagerNotifications managerNotifications, String str, String str2) {
            this.f5692c = managerNotifications;
            this.f5690a = str;
            this.f5691b = str2;
        }

        public void m8013a(User user, Bitmap bitmap) {
            this.f5692c.m8028a(this.f5690a, this.f5691b, user, bitmap);
        }

        public void m8012a(User user) {
            this.f5692c.m8028a(this.f5690a, this.f5691b, user, null);
        }

        public void m8011a() {
            this.f5692c.m8028a(this.f5690a, this.f5691b, null, null);
        }
    }

    /* renamed from: com.tinder.managers.ManagerNotifications.6 */
    class C27996 extends bw {
        final /* synthetic */ C2796c f5695a;
        final /* synthetic */ int f5696b;
        final /* synthetic */ ManagerNotifications f5697c;

        /* renamed from: com.tinder.managers.ManagerNotifications.6.1 */
        class C27981 implements C2281x {
            final /* synthetic */ User f5693a;
            final /* synthetic */ C27996 f5694b;

            C27981(C27996 c27996, User user) {
                this.f5694b = c27996;
                this.f5693a = user;
            }

            public void onBitmapLoaded(Bitmap bitmap, LoadedFrom loadedFrom) {
                this.f5694b.f5695a.m8010a(this.f5693a, bitmap);
            }

            public void onBitmapFailed(Drawable drawable) {
                this.f5694b.f5695a.m8009a(this.f5693a);
            }

            public void onPrepareLoad(Drawable drawable) {
            }
        }

        C27996(ManagerNotifications managerNotifications, C2796c c2796c, int i) {
            this.f5697c = managerNotifications;
            this.f5695a = c2796c;
            this.f5696b = i;
        }

        public void m8014a(@NonNull User user) {
            Picasso.m8982a(this.f5697c.f5713a).m8990a(user.getThumbnailUrl()).m9129b(this.f5696b, this.f5696b).m9126a(new C27981(this, user));
        }

        public void m8015g() {
            this.f5695a.m8008a();
        }
    }

    /* renamed from: com.tinder.managers.ManagerNotifications.7 */
    class C28007 implements OnClickListener {
        final /* synthetic */ Toast f5698a;
        final /* synthetic */ ManagerNotifications f5699b;

        C28007(ManagerNotifications managerNotifications, Toast toast) {
            this.f5699b = managerNotifications;
            this.f5698a = toast;
        }

        public void onClick(View view) {
            C3095y.m9469a();
            this.f5698a.cancel();
        }
    }

    /* renamed from: com.tinder.managers.ManagerNotifications.8 */
    static /* synthetic */ class C28018 {
        static final /* synthetic */ int[] f5700a;

        static {
            f5700a = new int[NotificationType.values().length];
            try {
                f5700a[NotificationType.MATCH_NEW.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5700a[NotificationType.FRIEND_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f5700a[NotificationType.FRIEND_REQUEST_ACCEPTED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f5700a[NotificationType.MESSAGE_FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f5700a[NotificationType.MESSAGE_NEW.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f5700a[NotificationType.MOMENT_LIKE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f5700a[NotificationType.SUPER_LIKE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f5700a[NotificationType.ALERT.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    public enum NotificationType {
        MATCH_NEW(-12989833),
        MESSAGE_NEW(-13529098),
        MESSAGE_FAILED(-1154746),
        FRIEND_REQUEST(-12989833),
        MOMENT_LIKE(-13529098),
        SUPER_LIKE(-14379865),
        FRIEND_REQUEST_ACCEPTED(3787383),
        ALERT(-1349041),
        ID_TAKEN(-1154746),
        ID_ACCEPTED(-12989833);
        
        private int f5712k;

        private NotificationType(int i) {
            this.f5712k = i;
        }

        public int m8016a() {
            return this.f5712k;
        }
    }

    public ManagerNotifications(@NonNull Context context) {
        this.f5719g = new HashMap();
        this.f5720h = new LinkedList();
        this.f5721i = new ArrayList();
        C3095y.m9469a();
        this.f5713a = context;
        this.f5714b = (NotificationManager) context.getSystemService("notification");
        this.f5717e = BuildConfig.FLAVOR;
        this.f5718f = "Tinder";
        this.f5722j = new C3061b(this);
    }

    public void m8041a(String str, String str2) {
        C3095y.m9471a("message=" + str);
        m8038a(str);
        SparksEvent sparksEvent = new SparksEvent("Push.Market");
        sparksEvent.put("campaignId", str2);
        C2807a.m8056a(sparksEvent);
    }

    public void m8038a(String str) {
        C3095y.m9471a("message=" + str);
        if (ManagerApp.m7935z()) {
            m8046b(str, NotificationType.ALERT, null);
            return;
        }
        Intent intent = new Intent(this.f5713a, ActivityMain.class);
        intent.setFlags(AccessibilityNodeInfoCompat.ACTION_PASTE);
        this.f5716d = PendingIntent.getActivity(this.f5713a, 0, intent, 1073741824);
        Builder builder = new Builder(this.f5713a);
        Bitmap decodeResource = BitmapFactory.decodeResource(this.f5713a.getResources(), R.drawable.tinder_flame_icon);
        builder.setDefaults(6).setContentIntent(this.f5716d).setContentTitle(this.f5718f).setStyle(new BigTextStyle().bigText(str)).setContentText(str).setOnlyAlertOnce(true).setAutoCancel(true).setTicker(str).setSmallIcon(R.drawable.ic_stat_notification).setLargeIcon(decodeResource);
        this.f5715c = builder.build();
        this.f5714b.notify(8887, this.f5715c);
        decodeResource.recycle();
    }

    private void m8025a(String str, @NonNull C2792a c2792a) {
        ManagerApp.m7925p().m8276a(false, str, new C27881(this, c2792a));
    }

    public void m8040a(String str, @NonNull C2794b c2794b) {
        new Handler(Looper.getMainLooper()).post(new C27912(this, str, c2794b));
    }

    public void m8039a(String str, @NonNull NotificationType notificationType, String str2) {
        boolean z = false;
        C3095y.m9471a("message=" + str + ", notificationType=" + notificationType);
        boolean f = ManagerApp.m7918i().m8765f();
        if (notificationType.equals(NotificationType.MATCH_NEW)) {
            if (f && ManagerApp.m7918i().m8757b()) {
                z = true;
            }
        } else if (!notificationType.equals(NotificationType.MESSAGE_NEW)) {
            z = f;
        } else if (f && ManagerApp.m7918i().m8759c()) {
            z = true;
        }
        if (z) {
            C3095y.m9471a("Push on matchId: " + str2);
            m8025a(str2, new C27933(this, str, notificationType));
        } else {
            C3095y.m9471a("Push notifications turned off");
        }
        ManagerApp.m7925p().m8278a(true);
    }

    public void m8043a(String str, String str2, String str3, String str4, String str5) {
        Object obj = (ManagerApp.m7918i().m8765f() && ManagerApp.m7918i().m8761d()) ? 1 : null;
        if (obj != null) {
            C3095y.m9471a("Push on matchId: " + str2);
            m8040a(str4, new C27954(this, str3, str5, str4, str));
            return;
        }
        C3095y.m9471a("Push notifications turned off");
    }

    public void m8042a(String str, String str2, String str3) {
        Object obj = (ManagerApp.m7918i().m8754a() && ManagerApp.m7918i().m8765f()) ? 1 : null;
        if (obj != null) {
            m8026a(str2, new C27975(this, str2, str3));
        }
    }

    public void m8045b(String str) {
        if (C2958p.au()) {
            m8048c(str);
        }
    }

    public void m8048c(String str) {
        if (ManagerApp.m7935z()) {
            m8046b(str, NotificationType.SUPER_LIKE, null);
            return;
        }
        Intent intent = new Intent(this.f5713a, ActivityMain.class);
        intent.setFlags(AccessibilityNodeInfoCompat.ACTION_PASTE);
        this.f5716d = PendingIntent.getActivity(this.f5713a, 0, intent, 1073741824);
        Builder builder = new Builder(this.f5713a);
        Bitmap decodeResource = BitmapFactory.decodeResource(this.f5713a.getResources(), R.drawable.tinder_flame_icon);
        builder.setDefaults(6).setContentIntent(this.f5716d).setContentTitle(this.f5718f).setStyle(new BigTextStyle().bigText(str)).setContentText(str).setOnlyAlertOnce(true).setAutoCancel(true).setTicker(str).setSmallIcon(R.drawable.ic_stat_notification).setLargeIcon(decodeResource);
        this.f5715c = builder.build();
        this.f5714b.notify(9000, this.f5715c);
        decodeResource.recycle();
    }

    private void m8026a(String str, @NonNull C2796c c2796c) {
        C2913k.m8575a(str, new C27996(this, c2796c, this.f5713a.getResources().getDimensionPixelSize(R.dimen.notification_big_icon_length)));
    }

    private void m8028a(String str, String str2, @Nullable User user, @Nullable Bitmap bitmap) {
        String string;
        SparksEvent sparksEvent = new SparksEvent("Friends.Requested");
        sparksEvent.put("otherId", str);
        C2807a.m8056a(sparksEvent);
        if (user == null) {
            string = this.f5713a.getResources().getString(R.string.notification_new_friend_request_nameless);
        } else {
            string = this.f5713a.getResources().getString(R.string.notification_new_friend_request, new Object[]{user.getName()});
        }
        if (ManagerApp.m7935z()) {
            m8046b(string, NotificationType.FRIEND_REQUEST, BuildConfig.FLAVOR);
            return;
        }
        Intent intent = new Intent(this.f5713a, ActivityMain.class);
        intent.putExtra("from_push", true);
        intent.putExtra("from_friend_request_push", true);
        intent.setFlags(AccessibilityNodeInfoCompat.ACTION_PASTE);
        this.f5716d = PendingIntent.getActivity(this.f5713a, 0, intent, 1073741824);
        Builder builder = new Builder(this.f5713a);
        this.f5717e = string;
        if (bitmap == null) {
            bitmap = BitmapFactory.decodeResource(this.f5713a.getResources(), R.drawable.tinder_flame_icon);
        }
        this.f5715c = builder.setDefaults(4).setContentIntent(this.f5716d).setContentTitle(this.f5718f).setOnlyAlertOnce(true).setAutoCancel(true).setTicker(this.f5717e).setSmallIcon(R.drawable.ic_stat_notification).setLargeIcon(bitmap).setContentText(this.f5717e).build();
        this.f5714b.notify(8892, this.f5715c);
    }

    private void m8027a(String str, @NonNull Moment moment, String str2, @Nullable Bitmap bitmap) {
        if (ManagerApp.m7935z()) {
            m8046b(str, NotificationType.MOMENT_LIKE, str2);
            return;
        }
        Intent intent = new Intent(this.f5713a, ActivityMain.class);
        intent.putExtra("from_push", true);
        intent.putExtra("moment_id", moment.getId());
        intent.setFlags(AccessibilityNodeInfoCompat.ACTION_PASTE);
        this.f5716d = PendingIntent.getActivity(this.f5713a, 0, intent, 1073741824);
        Builder builder = new Builder(this.f5713a);
        this.f5717e = this.f5713a.getString(R.string.moment_like_notification_title, new Object[]{str2});
        if (bitmap == null) {
            bitmap = BitmapFactory.decodeResource(this.f5713a.getResources(), R.drawable.tinder_flame_icon);
        }
        this.f5715c = builder.setDefaults(4).setContentIntent(this.f5716d).setContentTitle(this.f5718f).setOnlyAlertOnce(true).setAutoCancel(true).setTicker(this.f5717e).setSmallIcon(R.drawable.ic_stat_notification).setLargeIcon(bitmap).setContentText(this.f5717e).setLocalOnly(true).build();
        this.f5714b.notify(8887, this.f5715c);
    }

    private void m8024a(String str, @NonNull NotificationType notificationType, @Nullable Match match, @Nullable Bitmap bitmap) {
        C3095y.m9471a("message=" + str + ", notificationType=" + notificationType);
        if (match != null && !match.getId().equals(FragmentMessages.m7097b())) {
            int i;
            TaskStackBuilder create = TaskStackBuilder.create(this.f5713a);
            Intent intent;
            SparksEvent sparksEvent;
            if (notificationType.equals(NotificationType.MATCH_NEW)) {
                C3095y.m9471a("Match push");
                intent = new Intent(this.f5713a, ActivityMain.class);
                intent.putExtra("match", match);
                intent.putExtra("from_push", true);
                intent.putExtra("is_match", true);
                create.addParentStack(ActivityMain.class);
                create.addNextIntent(intent);
                this.f5717e = this.f5713a.getString(R.string.notification_notice_match_one);
                i = 8889;
                sparksEvent = new SparksEvent("Push.Match");
                sparksEvent.put("matchId", match.getId());
                C2807a.m8056a(sparksEvent);
            } else {
                C3095y.m9471a("Message push");
                intent = new Intent(this.f5713a, ActivityMain.class);
                intent.putExtra("match", match);
                intent.putExtra("from_push", true);
                intent.putExtra("is_message", true);
                create.addParentStack(ActivityMain.class);
                create.addNextIntent(intent);
                this.f5717e = String.format(this.f5713a.getString(R.string.notification_notice_message_one), new Object[]{match.getName()});
                i = 8888;
                sparksEvent = new SparksEvent("Push.Message");
                sparksEvent.put("matchId", match.getId());
                C2807a.m8056a(sparksEvent);
            }
            if (ManagerApp.m7935z()) {
                m8046b(str, notificationType, match.getName());
                return;
            }
            Notification a;
            this.f5716d = create.getPendingIntent(0, 1073741824);
            Builder builder = new Builder(this.f5713a);
            if (bitmap == null) {
                bitmap = BitmapFactory.decodeResource(this.f5713a.getResources(), R.drawable.tinder_flame_icon);
            }
            builder.setDefaults(6).setContentIntent(this.f5716d).setContentTitle(this.f5718f).setContentText(this.f5717e).setStyle(new BigTextStyle().bigText(str)).setOnlyAlertOnce(true).setAutoCancel(true).setTicker(this.f5717e).setSmallIcon(R.drawable.ic_stat_notification).setLargeIcon(bitmap);
            if (notificationType == NotificationType.MESSAGE_NEW) {
                a = m8018a(builder, match, str);
            } else {
                a = m8017a(builder, match);
            }
            this.f5715c = a;
            this.f5715c = builder.build();
            NotificationManagerCompat.from(this.f5713a).notify(match.getId(), i, this.f5715c);
        }
    }

    public void m8046b(String str, @NonNull NotificationType notificationType, String str2) {
        if (m8033e() && ManagerApp.m7897A() && ManagerApp.m7935z()) {
            m8034f();
            m8031c(str, notificationType, str2);
            return;
        }
        C3095y.m9471a("Already have max number of toasts queued or app not in foreground.");
    }

    private void m8032d() {
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        Long l = (Long) this.f5720h.peekFirst();
        while (l != null && valueOf.longValue() - l.longValue() > 3500) {
            this.f5720h.pop();
            l = (Long) this.f5720h.peekFirst();
        }
    }

    private boolean m8033e() {
        m8032d();
        return this.f5720h.size() < 3;
    }

    private void m8034f() {
        m8032d();
        if (this.f5720h.size() == 0) {
            this.f5720h.add(Long.valueOf(System.currentTimeMillis()));
            return;
        }
        this.f5720h.add(Long.valueOf(((Long) this.f5720h.getLast()).longValue() + 3500));
    }

    private void m8031c(String str, @NonNull NotificationType notificationType, @Nullable String str2) {
        C3095y.m9471a("message=" + str + ", notificationType=" + notificationType);
        View inflate = ((LayoutInflater) this.f5713a.getSystemService("layout_inflater")).inflate(R.layout.view_toast_custom, null);
        TextView textView = (TextView) inflate.findViewById(R.id.text);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.icon);
        ((LinearLayout) inflate.findViewById(R.id.toast_layout_root)).setBackgroundColor(notificationType.m8016a());
        switch (C28018.f5700a[notificationType.ordinal()]) {
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                textView.setText(this.f5713a.getString(R.string.notification_notice_match_one));
                break;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                textView.setText(str);
                break;
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                textView.setText(this.f5713a.getString(R.string.notification_match_request_accepted));
                break;
            case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                textView.setText(this.f5713a.getString(R.string.notification_message_failed));
                break;
            case C3374b.SmoothProgressBar_spb_speed /*5*/:
                if (str2 != null) {
                    textView.setText(String.format(this.f5713a.getString(R.string.notification_notice_message_one), new Object[]{str2}));
                    break;
                }
                textView.setText(this.f5713a.getString(R.string.notification_message_new));
                break;
            case C3374b.SmoothProgressBar_spb_progressiveStart_speed /*6*/:
                textView.setText(String.format(this.f5713a.getString(R.string.notification_moment_like), new Object[]{str2}));
                break;
            case C3374b.SmoothProgressBar_spb_progressiveStop_speed /*7*/:
                textView.setText(str);
                break;
            case C3374b.SmoothProgressBar_spb_interpolator /*8*/:
                textView.setText(str);
                break;
            default:
                C3095y.m9476b("Notification type not found");
                if (!TextUtils.isEmpty(str)) {
                    textView.setText(str);
                    break;
                }
                return;
        }
        Toast toast = new Toast(this.f5713a);
        toast.setGravity(55, 0, (int) this.f5713a.getResources().getDimension(R.dimen.actionbar_size));
        toast.setDuration(1);
        toast.setView(inflate);
        this.f5721i.add(toast);
        toast.show();
        textView.setOnClickListener(new C28007(this, toast));
    }

    public void m8037a() {
        C3095y.m9469a();
        PendingIntent activity = PendingIntent.getActivity(this.f5713a, 0, new Intent("android.settings.SYNC_SETTINGS"), 0);
        Builder builder = new Builder(this.f5713a);
        this.f5714b.notify(8890, builder.setDefaults(7).setContentIntent(activity).setSmallIcon(R.drawable.tinder_flame_icon).setContentTitle(this.f5718f).setContentText(this.f5713a.getString(R.string.push_reg_failed) + ". " + this.f5713a.getString(R.string.google_acct_not_present)).build());
    }

    public void m8044b() {
        C3095y.m9469a();
        PendingIntent activity = PendingIntent.getActivity(this.f5713a, 0, new Intent("android.settings.SYNC_SETTINGS"), 0);
        Builder builder = new Builder(this.f5713a);
        this.f5714b.notify(8891, builder.setDefaults(7).setContentIntent(activity).setSmallIcon(R.drawable.tinder_flame_icon).setContentTitle(this.f5718f).setContentText(this.f5713a.getString(R.string.push_reg_failed) + ". " + this.f5713a.getString(R.string.google_acct_invalid_creds)).build());
    }

    private Notification m8018a(@NonNull Builder builder, @NonNull Match match, String str) {
        CharSequence string = this.f5713a.getResources().getString(R.string.wear_notification_reply);
        CharSequence string2 = this.f5713a.getResources().getString(R.string.wear_view_profile);
        RemoteInput build = new RemoteInput.Builder("chat_msg").setLabel(string).build();
        Action.Builder builder2 = new Action.Builder(R.drawable.wear_reply, string, m8019a(match));
        builder2.addRemoteInput(build);
        Action.Builder builder3 = new Action.Builder(R.drawable.wear_viewprofile, string2, m8029b(match));
        Extender wearableExtender = new WearableExtender();
        wearableExtender.addAction(builder2.build());
        wearableExtender.addAction(builder3.build());
        builder.extend(wearableExtender);
        return builder.build();
    }

    private Notification m8017a(@NonNull Builder builder, @NonNull Match match) {
        CharSequence string = this.f5713a.getResources().getString(R.string.wear_view_profile);
        CharSequence string2 = this.f5713a.getResources().getString(R.string.wear_send_message);
        RemoteInput build = new RemoteInput.Builder("chat_msg").setLabel(string2).build();
        Action.Builder builder2 = new Action.Builder(R.drawable.wear_reply, string2, m8019a(match));
        builder2.addRemoteInput(build);
        Action.Builder builder3 = new Action.Builder(R.drawable.wear_viewprofile, string, m8029b(match));
        Extender wearableExtender = new WearableExtender();
        wearableExtender.addAction(builder2.build());
        wearableExtender.addAction(builder3.build());
        builder.extend(wearableExtender);
        return builder.build();
    }

    private PendingIntent m8019a(@NonNull Match match) {
        String str = "/api/matches/send_message/" + match.getId();
        Intent intent = new Intent(this.f5713a, WearIntentService.class);
        intent.putExtra("path", str);
        intent.putExtra("match_id", match.getId());
        return PendingIntent.getService(this.f5713a, 2021, intent, 134217728);
    }

    private PendingIntent m8029b(Match match) {
        Intent intent = new Intent(this.f5713a, WearIntentService.class);
        intent.putExtra("match", match);
        intent.putExtra("path", "/start/profile/match");
        return PendingIntent.getService(this.f5713a, 2022, intent, 134217728);
    }

    public void m8047c() {
        this.f5714b.cancelAll();
    }

    public void m8049d(String str) {
        this.f5714b.cancel(str, 8889);
        this.f5714b.cancel(str, 8888);
        this.f5714b.cancel(str, 8887);
    }

    public void m8035C() {
        m8047c();
    }

    public void m8036D() {
        if (!this.f5721i.isEmpty()) {
            Iterator it = this.f5721i.iterator();
            while (it.hasNext()) {
                ((Toast) it.next()).cancel();
            }
        }
    }
}

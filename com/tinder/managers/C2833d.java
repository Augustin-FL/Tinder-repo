package com.tinder.managers;

import android.app.Activity;
import android.content.Context;
import android.content.IntentSender.SendIntentException;
import android.location.Location;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.Toast;
import com.android.volley.C0294c;
import com.android.volley.C0307i.C0305a;
import com.android.volley.C0307i.C0306b;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.search.SearchAuth.StatusCodes;
import com.tinder.R;
import com.tinder.p029a.C2237d;
import com.tinder.p029a.C2239e;
import com.tinder.p030d.ay;
import com.tinder.utils.C3077n;
import com.tinder.utils.C3095y;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.tinder.managers.d */
public class C2833d implements ConnectionCallbacks, OnConnectionFailedListener, LocationListener {
    private final List<C2296a> f5801a;
    private Context f5802b;
    private int f5803c;
    private GoogleApiClient f5804d;
    private WeakReference<Activity> f5805e;
    private boolean f5806f;
    private boolean f5807g;
    private List<SoftReference<C2633b>> f5808h;
    @Nullable
    private Location f5809i;
    private int f5810j;

    /* renamed from: com.tinder.managers.d.a */
    public interface C2296a {
        void m6140R();
    }

    /* renamed from: com.tinder.managers.d.b */
    public interface C2633b {
        void m7272a();

        void m7273b();

        void m7274c();
    }

    /* renamed from: com.tinder.managers.d.1 */
    class C28291 implements ay {
        final /* synthetic */ C2833d f5794a;

        C28291(C2833d c2833d) {
            this.f5794a = c2833d;
        }

        public void m8171a() {
            C3095y.m9469a();
        }

        public void m8172b() {
            C3095y.m9469a();
            C3095y.m9479c("Failed to ping");
        }

        public void m8173c() {
            C3095y.m9469a();
            ManagerApp.m7912c();
            C2828c.m8161b();
        }

        public void m8174d() {
            C3095y.m9469a();
            C3095y.m9479c("Ping responded with bad location.");
            this.f5794a.m8192k();
        }
    }

    /* renamed from: com.tinder.managers.d.2 */
    class C28302 implements C0306b<JSONObject> {
        final /* synthetic */ ay f5795a;
        final /* synthetic */ C2833d f5796b;

        C28302(C2833d c2833d, ay ayVar) {
            this.f5796b = c2833d;
            this.f5795a = ayVar;
        }

        public void m8176a(@NonNull JSONObject jSONObject) {
            C3095y.m9471a("response=" + jSONObject);
            this.f5796b.f5806f = true;
            try {
                if (jSONObject.optInt(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, HttpStatus.SC_OK) == HttpStatus.SC_OK) {
                    this.f5795a.m6695a();
                    if (this.f5796b.f5808h != null) {
                        for (SoftReference softReference : this.f5796b.f5808h) {
                            if (C3077n.m9406a(softReference)) {
                                ((C2633b) softReference.get()).m7272a();
                            }
                        }
                        return;
                    }
                    return;
                }
                this.f5795a.m6696b();
                if (this.f5796b.f5808h != null) {
                    for (SoftReference softReference2 : this.f5796b.f5808h) {
                        if (C3077n.m9406a(softReference2)) {
                            ((C2633b) softReference2.get()).m7273b();
                        }
                    }
                }
            } catch (Throwable e) {
                C3095y.m9474a("Failed to ping", e);
                this.f5795a.m6696b();
                if (this.f5796b.f5808h != null) {
                    for (SoftReference softReference22 : this.f5796b.f5808h) {
                        if (C3077n.m9406a(softReference22)) {
                            ((C2633b) softReference22.get()).m7273b();
                        }
                    }
                }
            }
        }
    }

    /* renamed from: com.tinder.managers.d.3 */
    class C28313 implements C0305a {
        final /* synthetic */ ay f5797a;
        final /* synthetic */ C2833d f5798b;

        C28313(C2833d c2833d, ay ayVar) {
            this.f5798b = c2833d;
            this.f5797a = ayVar;
        }

        public void onErrorResponse(VolleyError volleyError) {
            C3095y.m9470a(volleyError, C2239e.f3699p);
            this.f5798b.f5806f = true;
            this.f5797a.m6696b();
        }
    }

    /* renamed from: com.tinder.managers.d.4 */
    class C28324 implements ResultCallback<LocationSettingsResult> {
        final /* synthetic */ LocationRequest f5799a;
        final /* synthetic */ C2833d f5800b;

        C28324(C2833d c2833d, LocationRequest locationRequest) {
            this.f5800b = c2833d;
            this.f5799a = locationRequest;
        }

        public /* synthetic */ void onResult(Result result) {
            m8177a((LocationSettingsResult) result);
        }

        public void m8177a(LocationSettingsResult locationSettingsResult) {
            if (this.f5800b.m8191j()) {
                Status status = locationSettingsResult.getStatus();
                switch (status.getStatusCode()) {
                    case C3374b.SmoothProgressBar_spbStyle /*0*/:
                        C3095y.m9483d("Location ask successful. Requesting updates!");
                        LocationServices.FusedLocationApi.requestLocationUpdates(this.f5800b.f5804d, this.f5799a, this.f5800b);
                        return;
                    case C3374b.SmoothProgressBar_spb_progressiveStart_speed /*6*/:
                        C3095y.m9483d("Location ask resolution needed!");
                        try {
                            if (this.f5800b.f5805e == null) {
                                C3095y.m9479c("Cannot attempt to fix locations settings without an activity.");
                                return;
                            }
                            Activity activity = (Activity) this.f5800b.f5805e.get();
                            if (activity != null) {
                                C3095y.m9471a("Resolution result will go to " + activity.getClass());
                                status.startResolutionForResult(activity, StatusCodes.AUTH_DISABLED);
                                return;
                            }
                            C3095y.m9479c("No activity in weak ref to get location resolution result from");
                            return;
                        } catch (Throwable e) {
                            C3095y.m9474a("Failed to send intent to activity about location settings update", e);
                            return;
                        }
                    case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE /*8502*/:
                        C3095y.m9479c("Could not change settings for locations, user perma-denied us?");
                        if (this.f5800b.f5805e != null) {
                            Toast.makeText((Activity) this.f5800b.f5805e.get(), R.string.location_perma_disabled, 1).show();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
            C3095y.m9479c("Google API client is null or not connected, unable to continue.");
            if (this.f5800b.f5810j > 0) {
                this.f5800b.m8189h();
            }
        }
    }

    public C2833d(Context context) {
        this.f5801a = new ArrayList();
        this.f5803c = 0;
        this.f5807g = false;
        this.f5809i = null;
        this.f5810j = 0;
        C3095y.m9469a();
        this.f5802b = context;
    }

    public void m8198a(C2633b c2633b) {
        C3095y.m9483d("Adding ping callback");
        if (this.f5808h == null) {
            this.f5808h = new ArrayList(1);
        }
        this.f5808h.add(new SoftReference(c2633b));
    }

    public void m8201b(C2633b c2633b) {
        C3095y.m9483d("Removing ping callback");
        if (this.f5808h != null) {
            Iterator it = this.f5808h.iterator();
            while (it.hasNext()) {
                SoftReference softReference = (SoftReference) it.next();
                if (softReference.get() == null || softReference.get() == c2633b) {
                    it.remove();
                }
            }
        }
    }

    private void m8189h() {
        if (this.f5804d == null) {
            C3095y.m9471a("Setting up a new google location client.");
            this.f5804d = new Builder(this.f5802b).addApi(LocationServices.API).addConnectionCallbacks(this).addOnConnectionFailedListener(this).build();
        } else {
            C3095y.m9471a("Google location client already existed, not recreating it.");
        }
        m8193a();
    }

    public void m8193a() {
        if (this.f5804d == null || this.f5804d.isConnecting() || this.f5804d.isConnected()) {
            C3095y.m9471a("Not connect()ing to google location client, already connected or connecting.");
            return;
        }
        C3095y.m9471a("Connect()ing to google location client");
        this.f5804d.connect();
    }

    public boolean m8199a(Activity activity) {
        C3095y.m9471a("Updating current location using activity " + activity.getClass().getSimpleName());
        this.f5805e = new WeakReference(activity);
        if (this.f5804d != null) {
            C3095y.m9471a("location googleapiclient not null");
            if (this.f5804d.isConnected()) {
                C3095y.m9471a("location google api client connected");
                Location lastLocation = LocationServices.FusedLocationApi.getLastLocation(this.f5804d);
                C3095y.m9471a("location " + lastLocation);
                if (lastLocation != null) {
                    boolean z;
                    if (!C3077n.m9410c() || SystemClock.elapsedRealtimeNanos() - lastLocation.getElapsedRealtimeNanos() <= 300000000) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        C3095y.m9483d("Using old last known location, since it's not THAT old.");
                        onLocationChanged(lastLocation);
                        return true;
                    }
                }
            }
            C3095y.m9479c("location googleapiclient not connected but setup, trying to connect");
            m8193a();
        } else {
            C3095y.m9471a("location googleapiclient null, call connection to location services");
            m8189h();
        }
        return false;
    }

    public void m8194a(double d, double d2) {
        ManagerApp.m7914e().m8823a(d);
        ManagerApp.m7914e().m8830b(d2);
        C3095y.m9471a("location **************_________ Storing " + ("lat: " + d + " long: " + d2) + " _________**************");
    }

    public boolean m8202b() {
        C3095y.m9471a("location lat: " + m8203c() + " lon: " + m8204d());
        return (m8203c() == -100000.0d || m8204d() == -100000.0d) ? false : true;
    }

    public double m8203c() {
        return this.f5809i == null ? -100000.0d : this.f5809i.getLatitude();
    }

    public double m8204d() {
        return this.f5809i == null ? -100000.0d : this.f5809i.getLongitude();
    }

    public void onLocationChanged(@NonNull Location location) {
        C3095y.m9471a("location onLocation: " + location);
        this.f5809i = location;
        if (C2833d.m8179a(location)) {
            C3095y.m9471a("pinging because minimum location displacement has met");
            m8182b(location);
            m8196a(new C28291(this), false);
        } else {
            C3095y.m9471a("not pinging because minimum location displacement not met");
            if (this.f5808h != null) {
                for (SoftReference softReference : this.f5808h) {
                    if (C3077n.m9406a(softReference)) {
                        ((C2633b) softReference.get()).m7274c();
                    }
                }
            }
        }
        for (C2296a R : this.f5801a) {
            R.m6140R();
        }
    }

    public void m8196a(@NonNull ay ayVar, boolean z) {
        C3095y.m9469a();
        ManagerApp.m7911b();
        String b = C2821b.m8123b();
        double c = m8203c();
        double d = m8204d();
        if (b == null) {
            C3095y.m9471a("no token");
            ayVar.m6697c();
        } else if (!z && !m8202b()) {
            C3095y.m9471a("no location");
            ayVar.m6698d();
        } else if (m8202b()) {
            C3095y.m9471a("Proceeding to ping ... lat = " + c + " long =" + d);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("lat", c);
                jSONObject.put("lon", d);
            } catch (Throwable e) {
                C3095y.m9474a("Failed to put lat/long into json", e);
            }
            Request c2237d = new C2237d(1, C2239e.f3699p, jSONObject, new C28302(this, ayVar), new C28313(this, ayVar), b);
            c2237d.m219a(new C0294c(20000, 1, 1.0f));
            ManagerApp.m7915f().m5900a(c2237d);
        }
    }

    public void m8195a(Activity activity, C2296a c2296a) {
        this.f5801a.add(c2296a);
        this.f5803c++;
        C3095y.m9471a("location numGpsUsers: " + this.f5803c);
        if (this.f5803c == 1) {
            m8183c(activity);
        }
    }

    public void m8197a(C2296a c2296a) {
        C3095y.m9469a();
        if (this.f5803c == 0) {
            C3095y.m9479c("Attempting to remove a location listener, but none are registered! Check your code!");
            return;
        }
        this.f5803c--;
        C3095y.m9471a("location numGpsUsers: " + this.f5803c);
        if (this.f5803c == 0) {
            m8190i();
        }
        for (int i = 0; i < this.f5801a.size(); i++) {
            if (this.f5801a.get(i) == c2296a) {
                this.f5801a.remove(i);
                return;
            }
        }
    }

    public void m8200b(Activity activity) {
        this.f5810j++;
        if (this.f5805e == null || this.f5805e.get() == null) {
            C3095y.m9471a("Location activity reference dead, settting to " + activity.getClass());
            this.f5805e = new WeakReference(activity);
        }
        C3095y.m9471a("location googleApiClient connect, active activities: " + this.f5810j);
        m8189h();
    }

    public void m8205e() {
        this.f5810j--;
        C3095y.m9471a("Got activity stop for location, remaining activities: " + this.f5810j);
        if (this.f5804d != null && this.f5810j == 0) {
            C3095y.m9471a("location googleApiClient disconnect");
            this.f5804d.disconnect();
            this.f5809i = null;
        }
    }

    public void m8206f() {
        if (this.f5801a != null) {
            for (int i = 0; i < this.f5801a.size(); i++) {
                this.f5801a.remove(i);
            }
        }
        this.f5803c = 0;
        m8190i();
    }

    public static boolean m8179a(@NonNull Location location) {
        float[] fArr = new float[1];
        double I = ManagerApp.m7914e().m8805I();
        double J = ManagerApp.m7914e().m8806J();
        Location.distanceBetween(location.getLatitude(), location.getLongitude(), I, J, fArr);
        float f = fArr[0];
        C3095y.m9471a("location displacement: " + f + " after comparing " + location.getLatitude() + ',' + location.getLongitude() + " with stored location: " + I + ',' + J);
        return f > 1609.0f;
    }

    private void m8182b(@NonNull Location location) {
        m8194a(location.getLatitude(), location.getLongitude());
    }

    private void m8190i() {
        C3095y.m9471a("*** STOPPING GPS ***");
        if (this.f5804d != null && this.f5804d.isConnected()) {
            LocationServices.FusedLocationApi.removeLocationUpdates(this.f5804d, (LocationListener) this);
        }
    }

    private void m8183c(Activity activity) {
        C3095y.m9471a("*** STARTING GPS ***");
        m8199a(activity);
    }

    public void onConnected(Bundle bundle) {
        C3095y.m9469a();
        m8192k();
    }

    private boolean m8191j() {
        if (this.f5804d == null || !this.f5804d.isConnected()) {
            return false;
        }
        return true;
    }

    private void m8192k() {
        if (m8191j()) {
            LocationRequest create = LocationRequest.create();
            create.setPriority(100);
            create.setInterval(60000);
            create.setFastestInterval(30000);
            create.setSmallestDisplacement(1609.0f);
            LocationServices.SettingsApi.checkLocationSettings(this.f5804d, new LocationSettingsRequest.Builder().setAlwaysShow(true).addLocationRequest(create).build()).setResultCallback(new C28324(this, create));
            return;
        }
        C3095y.m9479c("Failed to create and requets location updates, client is null or not connected");
    }

    public void onConnectionSuspended(int i) {
        C3095y.m9469a();
    }

    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Activity activity = null;
        C3095y.m9469a();
        if (!this.f5807g) {
            Activity activity2;
            if (connectionResult.hasResolution()) {
                try {
                    this.f5807g = true;
                    if (C3077n.m9407a(this.f5805e)) {
                        activity2 = (Activity) this.f5805e.get();
                        if (!activity2.isFinishing()) {
                            activity = activity2;
                        }
                    }
                    if (activity != null) {
                        connectionResult.startResolutionForResult(activity, 9000);
                        return;
                    }
                    return;
                } catch (SendIntentException e) {
                    m8193a();
                    return;
                }
            }
            if (C3077n.m9407a(this.f5805e)) {
                activity2 = (Activity) this.f5805e.get();
                if (activity2.isFinishing()) {
                    activity2 = null;
                }
            } else {
                activity2 = null;
            }
            if (activity2 != null) {
                GoogleApiAvailability.getInstance().getErrorDialog(activity2, connectionResult.getErrorCode(), 9000).show();
                this.f5807g = true;
            }
        }
    }

    public void m8207g() {
        this.f5807g = false;
    }
}

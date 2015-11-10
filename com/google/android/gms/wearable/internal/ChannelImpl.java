package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.Channel.GetInputStreamResult;
import com.google.android.gms.wearable.Channel.GetOutputStreamResult;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ChannelImpl implements SafeParcelable, Channel {
    public static final Creator<ChannelImpl> CREATOR;
    private final String mPath;
    final int mVersionCode;
    private final String zzaYR;
    private final String zzaZM;

    /* renamed from: com.google.android.gms.wearable.internal.ChannelImpl.1 */
    class C12841 extends zzh<Status> {
        final /* synthetic */ ChannelImpl zzaZS;

        C12841(ChannelImpl channelImpl, GoogleApiClient googleApiClient) {
            this.zzaZS = channelImpl;
            super(googleApiClient);
        }

        protected void zza(zzbn com_google_android_gms_wearable_internal_zzbn) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbn.zzt(this, this.zzaZS.zzaZM);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        protected Status zzd(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ChannelImpl.2 */
    class C12852 extends zzh<Status> {
        final /* synthetic */ ChannelImpl zzaZS;
        final /* synthetic */ int zzamY;

        C12852(ChannelImpl channelImpl, GoogleApiClient googleApiClient, int i) {
            this.zzaZS = channelImpl;
            this.zzamY = i;
            super(googleApiClient);
        }

        protected void zza(zzbn com_google_android_gms_wearable_internal_zzbn) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbn.zzh(this, this.zzaZS.zzaZM, this.zzamY);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        protected Status zzd(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ChannelImpl.3 */
    class C12863 extends zzh<GetInputStreamResult> {
        final /* synthetic */ ChannelImpl zzaZS;

        C12863(ChannelImpl channelImpl, GoogleApiClient googleApiClient) {
            this.zzaZS = channelImpl;
            super(googleApiClient);
        }

        protected void zza(zzbn com_google_android_gms_wearable_internal_zzbn) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbn.zzu(this, this.zzaZS.zzaZM);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzbn(status);
        }

        public GetInputStreamResult zzbn(Status status) {
            return new zza(status, null);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ChannelImpl.4 */
    class C12874 extends zzh<GetOutputStreamResult> {
        final /* synthetic */ ChannelImpl zzaZS;

        C12874(ChannelImpl channelImpl, GoogleApiClient googleApiClient) {
            this.zzaZS = channelImpl;
            super(googleApiClient);
        }

        protected void zza(zzbn com_google_android_gms_wearable_internal_zzbn) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbn.zzv(this, this.zzaZS.zzaZM);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzbo(status);
        }

        public GetOutputStreamResult zzbo(Status status) {
            return new zzb(status, null);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ChannelImpl.5 */
    class C12885 extends zzh<Status> {
        final /* synthetic */ Uri zzaKy;
        final /* synthetic */ ChannelImpl zzaZS;
        final /* synthetic */ boolean zzaZT;

        C12885(ChannelImpl channelImpl, GoogleApiClient googleApiClient, Uri uri, boolean z) {
            this.zzaZS = channelImpl;
            this.zzaKy = uri;
            this.zzaZT = z;
            super(googleApiClient);
        }

        protected void zza(zzbn com_google_android_gms_wearable_internal_zzbn) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbn.zza((com.google.android.gms.common.api.zzc.zzb) this, this.zzaZS.zzaZM, this.zzaKy, this.zzaZT);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        public Status zzd(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ChannelImpl.6 */
    class C12896 extends zzh<Status> {
        final /* synthetic */ Uri zzaKy;
        final /* synthetic */ ChannelImpl zzaZS;
        final /* synthetic */ long zzaZU;
        final /* synthetic */ long zzaZV;

        C12896(ChannelImpl channelImpl, GoogleApiClient googleApiClient, Uri uri, long j, long j2) {
            this.zzaZS = channelImpl;
            this.zzaKy = uri;
            this.zzaZU = j;
            this.zzaZV = j2;
            super(googleApiClient);
        }

        protected void zza(zzbn com_google_android_gms_wearable_internal_zzbn) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbn.zza(this, this.zzaZS.zzaZM, this.zzaKy, this.zzaZU, this.zzaZV);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        public Status zzd(Status status) {
            return status;
        }
    }

    static final class zza implements GetInputStreamResult {
        private final Status zzQA;
        private final InputStream zzaZW;

        zza(Status status, InputStream inputStream) {
            this.zzQA = (Status) zzx.zzv(status);
            this.zzaZW = inputStream;
        }

        public InputStream getInputStream() {
            return this.zzaZW;
        }

        public Status getStatus() {
            return this.zzQA;
        }

        public void release() {
            if (this.zzaZW != null) {
                try {
                    this.zzaZW.close();
                } catch (IOException e) {
                }
            }
        }
    }

    static final class zzb implements GetOutputStreamResult {
        private final Status zzQA;
        private final OutputStream zzaZX;

        zzb(Status status, OutputStream outputStream) {
            this.zzQA = (Status) zzx.zzv(status);
            this.zzaZX = outputStream;
        }

        public OutputStream getOutputStream() {
            return this.zzaZX;
        }

        public Status getStatus() {
            return this.zzQA;
        }

        public void release() {
            if (this.zzaZX != null) {
                try {
                    this.zzaZX.close();
                } catch (IOException e) {
                }
            }
        }
    }

    static {
        CREATOR = new zzn();
    }

    ChannelImpl(int i, String str, String str2, String str3) {
        this.mVersionCode = i;
        this.zzaZM = (String) zzx.zzv(str);
        this.zzaYR = (String) zzx.zzv(str2);
        this.mPath = (String) zzx.zzv(str3);
    }

    public PendingResult<Status> addListener(GoogleApiClient googleApiClient, ChannelListener channelListener) {
        zzx.zzb((Object) googleApiClient, (Object) "client is null");
        zzx.zzb((Object) channelListener, (Object) "listener is null");
        return googleApiClient.zza(new zza(googleApiClient, channelListener, this.zzaZM));
    }

    public PendingResult<Status> close(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new C12841(this, googleApiClient));
    }

    public PendingResult<Status> close(GoogleApiClient googleApiClient, int i) {
        return googleApiClient.zzb(new C12852(this, googleApiClient, i));
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChannelImpl)) {
            return false;
        }
        ChannelImpl channelImpl = (ChannelImpl) obj;
        return this.zzaZM.equals(channelImpl.zzaZM) && zzw.equal(channelImpl.zzaYR, this.zzaYR) && zzw.equal(channelImpl.mPath, this.mPath) && channelImpl.mVersionCode == this.mVersionCode;
    }

    public PendingResult<GetInputStreamResult> getInputStream(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new C12863(this, googleApiClient));
    }

    public String getNodeId() {
        return this.zzaYR;
    }

    public PendingResult<GetOutputStreamResult> getOutputStream(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new C12874(this, googleApiClient));
    }

    public String getPath() {
        return this.mPath;
    }

    public String getToken() {
        return this.zzaZM;
    }

    public int hashCode() {
        return this.zzaZM.hashCode();
    }

    public PendingResult<Status> receiveFile(GoogleApiClient googleApiClient, Uri uri, boolean z) {
        zzx.zzb((Object) googleApiClient, (Object) "client is null");
        zzx.zzb((Object) uri, (Object) "uri is null");
        return googleApiClient.zzb(new C12885(this, googleApiClient, uri, z));
    }

    public PendingResult<Status> removeListener(GoogleApiClient googleApiClient, ChannelListener channelListener) {
        zzx.zzb((Object) googleApiClient, (Object) "client is null");
        zzx.zzb((Object) channelListener, (Object) "listener is null");
        return googleApiClient.zza(new zzc(googleApiClient, channelListener, this.zzaZM));
    }

    public PendingResult<Status> sendFile(GoogleApiClient googleApiClient, Uri uri) {
        return sendFile(googleApiClient, uri, 0, -1);
    }

    public PendingResult<Status> sendFile(GoogleApiClient googleApiClient, Uri uri, long j, long j2) {
        zzx.zzb((Object) googleApiClient, (Object) "client is null");
        zzx.zzb(this.zzaZM, (Object) "token is null");
        zzx.zzb((Object) uri, (Object) "uri is null");
        zzx.zzb(j >= 0, "startOffset is negative: %s", Long.valueOf(j));
        boolean z = j2 >= 0 || j2 == -1;
        zzx.zzb(z, "invalid length: %s", Long.valueOf(j2));
        return googleApiClient.zzb(new C12896(this, googleApiClient, uri, j, j2));
    }

    public String toString() {
        return "ChannelImpl{versionCode=" + this.mVersionCode + ", token='" + this.zzaZM + '\'' + ", nodeId='" + this.zzaYR + '\'' + ", path='" + this.mPath + '\'' + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzn.zza(this, parcel, i);
    }
}

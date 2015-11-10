package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.ConnectionConfiguration;
import com.google.android.gms.wearable.PutDataRequest;
import com.viewpagerindicator.C3169d.C3168f;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.LangUtils;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public interface zzaw extends IInterface {

    public static abstract class zza extends Binder implements zzaw {

        private static class zza implements zzaw {
            private IBinder zznI;

            zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public void zza(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    this.zznI.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau com_google_android_gms_wearable_internal_zzau, byte b) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    obtain.writeByte(b);
                    this.zznI.transact(53, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau com_google_android_gms_wearable_internal_zzau, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    obtain.writeInt(i);
                    this.zznI.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau com_google_android_gms_wearable_internal_zzau, Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau com_google_android_gms_wearable_internal_zzau, Uri uri, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.zznI.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau com_google_android_gms_wearable_internal_zzau, Asset asset) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    if (asset != null) {
                        obtain.writeInt(1);
                        asset.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau com_google_android_gms_wearable_internal_zzau, ConnectionConfiguration connectionConfiguration) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    if (connectionConfiguration != null) {
                        obtain.writeInt(1);
                        connectionConfiguration.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau com_google_android_gms_wearable_internal_zzau, PutDataRequest putDataRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    if (putDataRequest != null) {
                        obtain.writeInt(1);
                        putDataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau com_google_android_gms_wearable_internal_zzau, AddListenerRequest addListenerRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    if (addListenerRequest != null) {
                        obtain.writeInt(1);
                        addListenerRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau com_google_android_gms_wearable_internal_zzau, AncsNotificationParcelable ancsNotificationParcelable) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    if (ancsNotificationParcelable != null) {
                        obtain.writeInt(1);
                        ancsNotificationParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau com_google_android_gms_wearable_internal_zzau, RemoveListenerRequest removeListenerRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    if (removeListenerRequest != null) {
                        obtain.writeInt(1);
                        removeListenerRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau com_google_android_gms_wearable_internal_zzau, zzat com_google_android_gms_wearable_internal_zzat, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    if (com_google_android_gms_wearable_internal_zzat != null) {
                        iBinder = com_google_android_gms_wearable_internal_zzat.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.zznI.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau com_google_android_gms_wearable_internal_zzau, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    obtain.writeString(str);
                    this.zznI.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau com_google_android_gms_wearable_internal_zzau, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.zznI.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau com_google_android_gms_wearable_internal_zzau, String str, ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    obtain.writeString(str);
                    if (parcelFileDescriptor != null) {
                        obtain.writeInt(1);
                        parcelFileDescriptor.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau com_google_android_gms_wearable_internal_zzau, String str, ParcelFileDescriptor parcelFileDescriptor, long j, long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    obtain.writeString(str);
                    if (parcelFileDescriptor != null) {
                        obtain.writeInt(1);
                        parcelFileDescriptor.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    this.zznI.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau com_google_android_gms_wearable_internal_zzau, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zznI.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau com_google_android_gms_wearable_internal_zzau, String str, String str2, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeByteArray(bArr);
                    this.zznI.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau com_google_android_gms_wearable_internal_zzau, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zznI.transact(48, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    this.zznI.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzau com_google_android_gms_wearable_internal_zzau, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    obtain.writeInt(i);
                    this.zznI.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzau com_google_android_gms_wearable_internal_zzau, Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzau com_google_android_gms_wearable_internal_zzau, Uri uri, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.zznI.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzau com_google_android_gms_wearable_internal_zzau, ConnectionConfiguration connectionConfiguration) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    if (connectionConfiguration != null) {
                        obtain.writeInt(1);
                        connectionConfiguration.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzau com_google_android_gms_wearable_internal_zzau, zzat com_google_android_gms_wearable_internal_zzat, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    if (com_google_android_gms_wearable_internal_zzat != null) {
                        iBinder = com_google_android_gms_wearable_internal_zzat.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.zznI.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzau com_google_android_gms_wearable_internal_zzau, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    obtain.writeString(str);
                    this.zznI.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzau com_google_android_gms_wearable_internal_zzau, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.zznI.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzau com_google_android_gms_wearable_internal_zzau, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zznI.transact(50, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    this.zznI.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzau com_google_android_gms_wearable_internal_zzau, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    obtain.writeInt(i);
                    this.zznI.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzau com_google_android_gms_wearable_internal_zzau, Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzau com_google_android_gms_wearable_internal_zzau, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    obtain.writeString(str);
                    this.zznI.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    this.zznI.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(zzau com_google_android_gms_wearable_internal_zzau, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    obtain.writeString(str);
                    this.zznI.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    this.zznI.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(zzau com_google_android_gms_wearable_internal_zzau, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    obtain.writeString(str);
                    this.zznI.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzf(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    this.zznI.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzf(zzau com_google_android_gms_wearable_internal_zzau, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    obtain.writeString(str);
                    this.zznI.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzg(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    this.zznI.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzh(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    this.zznI.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzi(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    this.zznI.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzj(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    this.zznI.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzk(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    this.zznI.transact(49, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzl(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    this.zznI.transact(51, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzm(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    this.zznI.transact(52, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzn(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    this.zznI.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzo(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    this.zznI.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzp(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    this.zznI.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzaw zzea(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzaw)) ? new zza(iBinder) : (zzaw) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            boolean z = false;
            ConnectionConfiguration connectionConfiguration = null;
            zzau zzdY;
            Uri uri;
            switch (i) {
                case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzdY = com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        connectionConfiguration = (ConnectionConfiguration) ConnectionConfiguration.CREATOR.createFromParcel(parcel);
                    }
                    zzb(zzdY, connectionConfiguration);
                    parcel2.writeNoException();
                    return true;
                case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzn(com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzo(com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C3374b.SmoothProgressBar_spb_speed /*5*/:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzp(com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C3374b.SmoothProgressBar_spb_progressiveStart_speed /*6*/:
                    PutDataRequest putDataRequest;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzdY = com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        putDataRequest = (PutDataRequest) PutDataRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(zzdY, putDataRequest);
                    parcel2.writeNoException();
                    return true;
                case C3374b.SmoothProgressBar_spb_progressiveStop_speed /*7*/:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzdY = com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        uri = (Uri) Uri.CREATOR.createFromParcel(parcel);
                    }
                    zza(zzdY, uri);
                    parcel2.writeNoException();
                    return true;
                case C3374b.SmoothProgressBar_spb_interpolator /*8*/:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzb(com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C3374b.SmoothProgressBar_spb_reversed /*9*/:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzdY = com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        uri = (Uri) Uri.CREATOR.createFromParcel(parcel);
                    }
                    zzb(zzdY, uri);
                    parcel2.writeNoException();
                    return true;
                case C3374b.SmoothProgressBar_spb_colors /*11*/:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzdY = com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        uri = (Uri) Uri.CREATOR.createFromParcel(parcel);
                    }
                    zzc(zzdY, uri);
                    parcel2.writeNoException();
                    return true;
                case C3374b.SmoothProgressBar_spb_progressiveStart_activated /*12*/:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case C3374b.SmoothProgressBar_spb_background /*13*/:
                    Asset asset;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzdY = com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        asset = (Asset) Asset.CREATOR.createFromParcel(parcel);
                    }
                    zza(zzdY, asset);
                    parcel2.writeNoException();
                    return true;
                case C3374b.SmoothProgressBar_spb_generate_background_with_colors /*14*/:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzc(com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C3168f.Toolbar_titleMarginBottom /*15*/:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzd(com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C3168f.Toolbar_maxButtonHeight /*16*/:
                    AddListenerRequest addListenerRequest;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzdY = com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        addListenerRequest = (AddListenerRequest) AddListenerRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(zzdY, addListenerRequest);
                    parcel2.writeNoException();
                    return true;
                case LangUtils.HASH_SEED /*17*/:
                    RemoveListenerRequest removeListenerRequest;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzdY = com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        removeListenerRequest = (RemoveListenerRequest) RemoveListenerRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(zzdY, removeListenerRequest);
                    parcel2.writeNoException();
                    return true;
                case C3168f.Toolbar_collapseContentDescription /*18*/:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zze(com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C3168f.Toolbar_navigationIcon /*19*/:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzf(com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C3168f.Toolbar_navigationContentDescription /*20*/:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzdY = com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        connectionConfiguration = (ConnectionConfiguration) ConnectionConfiguration.CREATOR.createFromParcel(parcel);
                    }
                    zza(zzdY, connectionConfiguration);
                    parcel2.writeNoException();
                    return true;
                case C3168f.Theme_actionBarWidgetTheme /*21*/:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case C3168f.Theme_actionBarSize /*22*/:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C3168f.Theme_actionBarDivider /*23*/:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzb(com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case C3168f.Theme_actionBarItemBackground /*24*/:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzc(com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case C3168f.Theme_actionMenuTextAppearance /*25*/:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzg(com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C3168f.Theme_actionMenuTextColor /*26*/:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzh(com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C3168f.Theme_actionModeStyle /*27*/:
                    AncsNotificationParcelable ancsNotificationParcelable;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzdY = com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        ancsNotificationParcelable = (AncsNotificationParcelable) AncsNotificationParcelable.CREATOR.createFromParcel(parcel);
                    }
                    zza(zzdY, ancsNotificationParcelable);
                    parcel2.writeNoException();
                    return true;
                case C3168f.Theme_actionModeCloseButtonStyle /*28*/:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzb(com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case C3168f.Theme_actionModeBackground /*29*/:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzc(com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case C3168f.Theme_actionModeSplitBackground /*30*/:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzi(com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C3168f.Theme_actionModeCloseDrawable /*31*/:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case HTTP.SP /*32*/:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzf(com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case C3168f.Theme_actionModeCopyDrawable /*33*/:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzb(com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder()), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case C3168f.Theme_actionModePasteDrawable /*34*/:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder()), com.google.android.gms.wearable.internal.zzat.zza.zzdX(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case C3168f.Theme_actionModeSelectAllDrawable /*35*/:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzb(com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder()), com.google.android.gms.wearable.internal.zzat.zza.zzdX(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case LangUtils.HASH_OFFSET /*37*/:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzj(com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C3168f.Theme_actionModeWebSearchDrawable /*38*/:
                    ParcelFileDescriptor parcelFileDescriptor;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzdY = com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder());
                    String readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        parcelFileDescriptor = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
                    }
                    zza(zzdY, readString, parcelFileDescriptor);
                    parcel2.writeNoException();
                    return true;
                case C3168f.Theme_actionModePopupWindowStyle /*39*/:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(parcel) : null, parcel.readLong(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case C3168f.Theme_textAppearanceLargePopupMenu /*40*/:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzdY = com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        uri = (Uri) Uri.CREATOR.createFromParcel(parcel);
                    }
                    zza(zzdY, uri, parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case C3168f.Theme_textAppearanceSmallPopupMenu /*41*/:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzdY = com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        uri = (Uri) Uri.CREATOR.createFromParcel(parcel);
                    }
                    zzb(zzdY, uri, parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case C3168f.Theme_dialogTheme /*42*/:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder()), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case C3168f.Theme_dialogPreferredPadding /*43*/:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case C3168f.Theme_dropdownListPreferredItemHeight /*46*/:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzd(com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case C3168f.Theme_spinnerDropDownItemStyle /*47*/:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zze(com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case C3168f.Theme_homeAsUpIndicator /*48*/:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder()), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case C3168f.Theme_actionButtonStyle /*49*/:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzk(com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C3168f.Theme_buttonBarStyle /*50*/:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzau zzdY2 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    zzb(zzdY2, z);
                    parcel2.writeNoException();
                    return true;
                case C3168f.Theme_buttonBarButtonStyle /*51*/:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzl(com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C3168f.Theme_selectableItemBackground /*52*/:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzm(com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C3168f.Theme_selectableItemBackgroundBorderless /*53*/:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzau.zza.zzdY(parcel.readStrongBinder()), parcel.readByte());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.wearable.internal.IWearableService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException;

    void zza(zzau com_google_android_gms_wearable_internal_zzau, byte b) throws RemoteException;

    void zza(zzau com_google_android_gms_wearable_internal_zzau, int i) throws RemoteException;

    void zza(zzau com_google_android_gms_wearable_internal_zzau, Uri uri) throws RemoteException;

    void zza(zzau com_google_android_gms_wearable_internal_zzau, Uri uri, int i) throws RemoteException;

    void zza(zzau com_google_android_gms_wearable_internal_zzau, Asset asset) throws RemoteException;

    void zza(zzau com_google_android_gms_wearable_internal_zzau, ConnectionConfiguration connectionConfiguration) throws RemoteException;

    void zza(zzau com_google_android_gms_wearable_internal_zzau, PutDataRequest putDataRequest) throws RemoteException;

    void zza(zzau com_google_android_gms_wearable_internal_zzau, AddListenerRequest addListenerRequest) throws RemoteException;

    void zza(zzau com_google_android_gms_wearable_internal_zzau, AncsNotificationParcelable ancsNotificationParcelable) throws RemoteException;

    void zza(zzau com_google_android_gms_wearable_internal_zzau, RemoveListenerRequest removeListenerRequest) throws RemoteException;

    void zza(zzau com_google_android_gms_wearable_internal_zzau, zzat com_google_android_gms_wearable_internal_zzat, String str) throws RemoteException;

    void zza(zzau com_google_android_gms_wearable_internal_zzau, String str) throws RemoteException;

    void zza(zzau com_google_android_gms_wearable_internal_zzau, String str, int i) throws RemoteException;

    void zza(zzau com_google_android_gms_wearable_internal_zzau, String str, ParcelFileDescriptor parcelFileDescriptor) throws RemoteException;

    void zza(zzau com_google_android_gms_wearable_internal_zzau, String str, ParcelFileDescriptor parcelFileDescriptor, long j, long j2) throws RemoteException;

    void zza(zzau com_google_android_gms_wearable_internal_zzau, String str, String str2) throws RemoteException;

    void zza(zzau com_google_android_gms_wearable_internal_zzau, String str, String str2, byte[] bArr) throws RemoteException;

    void zza(zzau com_google_android_gms_wearable_internal_zzau, boolean z) throws RemoteException;

    void zzb(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException;

    void zzb(zzau com_google_android_gms_wearable_internal_zzau, int i) throws RemoteException;

    void zzb(zzau com_google_android_gms_wearable_internal_zzau, Uri uri) throws RemoteException;

    void zzb(zzau com_google_android_gms_wearable_internal_zzau, Uri uri, int i) throws RemoteException;

    void zzb(zzau com_google_android_gms_wearable_internal_zzau, ConnectionConfiguration connectionConfiguration) throws RemoteException;

    void zzb(zzau com_google_android_gms_wearable_internal_zzau, zzat com_google_android_gms_wearable_internal_zzat, String str) throws RemoteException;

    void zzb(zzau com_google_android_gms_wearable_internal_zzau, String str) throws RemoteException;

    void zzb(zzau com_google_android_gms_wearable_internal_zzau, String str, int i) throws RemoteException;

    void zzb(zzau com_google_android_gms_wearable_internal_zzau, boolean z) throws RemoteException;

    void zzc(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException;

    void zzc(zzau com_google_android_gms_wearable_internal_zzau, int i) throws RemoteException;

    void zzc(zzau com_google_android_gms_wearable_internal_zzau, Uri uri) throws RemoteException;

    void zzc(zzau com_google_android_gms_wearable_internal_zzau, String str) throws RemoteException;

    void zzd(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException;

    void zzd(zzau com_google_android_gms_wearable_internal_zzau, String str) throws RemoteException;

    void zze(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException;

    void zze(zzau com_google_android_gms_wearable_internal_zzau, String str) throws RemoteException;

    void zzf(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException;

    void zzf(zzau com_google_android_gms_wearable_internal_zzau, String str) throws RemoteException;

    void zzg(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException;

    void zzh(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException;

    void zzi(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException;

    void zzj(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException;

    void zzk(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException;

    void zzl(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException;

    void zzm(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException;

    void zzn(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException;

    void zzo(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException;

    void zzp(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException;
}

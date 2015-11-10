package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.mediation.C0701c;
import com.google.ads.mediation.C0706h;
import com.google.ads.mediation.MediationServerParameters;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.zzeh.zza;
import java.util.Map;

@zzgk
public final class zzeg extends zza {
    private Map<Class<? extends NetworkExtras>, NetworkExtras> zzyU;

    private <NETWORK_EXTRAS extends C0706h, SERVER_PARAMETERS extends MediationServerParameters> zzei zzad(String str) throws RemoteException {
        try {
            Class cls = Class.forName(str, false, zzeg.class.getClassLoader());
            if (C0701c.class.isAssignableFrom(cls)) {
                C0701c c0701c = (C0701c) cls.newInstance();
                return new zzes(c0701c, (C0706h) this.zzyU.get(c0701c.m963b()));
            } else if (MediationAdapter.class.isAssignableFrom(cls)) {
                return new zzen((MediationAdapter) cls.newInstance());
            } else {
                zzb.zzaE("Could not instantiate mediation adapter: " + str + " (not a valid adapter).");
                throw new RemoteException();
            }
        } catch (Throwable th) {
            zzb.zzaE("Could not instantiate mediation adapter: " + str + ". " + th.getMessage());
            RemoteException remoteException = new RemoteException();
        }
    }

    public zzei zzab(String str) throws RemoteException {
        return zzad(str);
    }

    public boolean zzac(String str) throws RemoteException {
        boolean z = false;
        try {
            z = CustomEvent.class.isAssignableFrom(Class.forName(str, false, zzeg.class.getClassLoader()));
        } catch (Throwable th) {
            zzb.zzaE("Could not load custom event implementation class: " + str + ", assuming old implementation.");
        }
        return z;
    }

    public void zze(Map<Class<? extends NetworkExtras>, NetworkExtras> map) {
        this.zzyU = map;
    }
}

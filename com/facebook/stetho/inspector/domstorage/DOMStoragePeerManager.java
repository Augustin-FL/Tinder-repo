package com.facebook.stetho.inspector.domstorage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.stetho.inspector.helper.ChromePeerManager;
import com.facebook.stetho.inspector.helper.PeerRegistrationListener;
import com.facebook.stetho.inspector.helper.PeersRegisteredListener;
import com.facebook.stetho.inspector.protocol.module.DOMStorage.DomStorageItemAddedParams;
import com.facebook.stetho.inspector.protocol.module.DOMStorage.DomStorageItemRemovedParams;
import com.facebook.stetho.inspector.protocol.module.DOMStorage.DomStorageItemUpdatedParams;
import com.facebook.stetho.inspector.protocol.module.DOMStorage.StorageId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DOMStoragePeerManager extends ChromePeerManager {
    private final Context mContext;
    private final PeerRegistrationListener mPeerListener;

    /* renamed from: com.facebook.stetho.inspector.domstorage.DOMStoragePeerManager.1 */
    class C06641 extends PeersRegisteredListener {
        private final List<DevToolsSharedPreferencesListener> mPrefsListeners;

        C06641() {
            this.mPrefsListeners = new ArrayList();
        }

        protected synchronized void onFirstPeerRegistered() {
            for (String str : SharedPreferencesHelper.getSharedPreferenceTags(DOMStoragePeerManager.this.mContext)) {
                SharedPreferences sharedPreferences = DOMStoragePeerManager.this.mContext.getSharedPreferences(str, 0);
                OnSharedPreferenceChangeListener devToolsSharedPreferencesListener = new DevToolsSharedPreferencesListener(sharedPreferences, str);
                sharedPreferences.registerOnSharedPreferenceChangeListener(devToolsSharedPreferencesListener);
                this.mPrefsListeners.add(devToolsSharedPreferencesListener);
            }
        }

        protected synchronized void onLastPeerUnregistered() {
            for (DevToolsSharedPreferencesListener unregister : this.mPrefsListeners) {
                unregister.unregister();
            }
            this.mPrefsListeners.clear();
        }
    }

    private class DevToolsSharedPreferencesListener implements OnSharedPreferenceChangeListener {
        private final Map<String, Object> mCopy;
        private final SharedPreferences mPrefs;
        private final StorageId mStorageId;

        public DevToolsSharedPreferencesListener(SharedPreferences sharedPreferences, String str) {
            this.mPrefs = sharedPreferences;
            this.mStorageId = new StorageId();
            this.mStorageId.securityOrigin = str;
            this.mStorageId.isLocalStorage = true;
            this.mCopy = DOMStoragePeerManager.prefsCopy(sharedPreferences.getAll());
        }

        public void unregister() {
            this.mPrefs.unregisterOnSharedPreferenceChangeListener(this);
        }

        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            Map all = sharedPreferences.getAll();
            boolean containsKey = this.mCopy.containsKey(str);
            boolean containsKey2 = all.containsKey(str);
            Object obj = containsKey2 ? all.get(str) : null;
            if (containsKey && containsKey2) {
                DOMStoragePeerManager.this.signalItemUpdated(this.mStorageId, str, SharedPreferencesHelper.valueToString(this.mCopy.get(str)), SharedPreferencesHelper.valueToString(obj));
                this.mCopy.put(str, obj);
            } else if (containsKey) {
                DOMStoragePeerManager.this.signalItemRemoved(this.mStorageId, str);
                this.mCopy.remove(str);
            } else if (containsKey2) {
                DOMStoragePeerManager.this.signalItemAdded(this.mStorageId, str, SharedPreferencesHelper.valueToString(obj));
                this.mCopy.put(str, obj);
            } else {
                throw new RuntimeException("Prefs change detected for unknown key=" + str);
            }
        }
    }

    public DOMStoragePeerManager(Context context) {
        this.mPeerListener = new C06641();
        this.mContext = context;
        setListener(this.mPeerListener);
    }

    public void signalItemRemoved(StorageId storageId, String str) {
        DomStorageItemRemovedParams domStorageItemRemovedParams = new DomStorageItemRemovedParams();
        domStorageItemRemovedParams.storageId = storageId;
        domStorageItemRemovedParams.key = str;
        sendNotificationToPeers("DOMStorage.domStorageItemRemoved", domStorageItemRemovedParams);
    }

    public void signalItemAdded(StorageId storageId, String str, String str2) {
        DomStorageItemAddedParams domStorageItemAddedParams = new DomStorageItemAddedParams();
        domStorageItemAddedParams.storageId = storageId;
        domStorageItemAddedParams.key = str;
        domStorageItemAddedParams.newValue = str2;
        sendNotificationToPeers("DOMStorage.domStorageItemAdded", domStorageItemAddedParams);
    }

    public void signalItemUpdated(StorageId storageId, String str, String str2, String str3) {
        DomStorageItemUpdatedParams domStorageItemUpdatedParams = new DomStorageItemUpdatedParams();
        domStorageItemUpdatedParams.storageId = storageId;
        domStorageItemUpdatedParams.key = str;
        domStorageItemUpdatedParams.oldValue = str2;
        domStorageItemUpdatedParams.newValue = str3;
        sendNotificationToPeers("DOMStorage.domStorageItemUpdated", domStorageItemUpdatedParams);
    }

    private static Map<String, Object> prefsCopy(Map<String, ?> map) {
        Map hashMap = new HashMap(map.size());
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Set) {
                hashMap.put(str, shallowCopy((Set) value));
            } else {
                hashMap.put(str, value);
            }
        }
        return hashMap;
    }

    private static <T> Set<T> shallowCopy(Set<T> set) {
        Set hashSet = new HashSet();
        for (T add : set) {
            hashSet.add(add);
        }
        return hashSet;
    }
}

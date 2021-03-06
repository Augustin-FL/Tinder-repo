package com.facebook.stetho.inspector.helper;

import com.facebook.stetho.common.LogRedirector;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.jsonrpc.DisconnectReceiver;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.PendingRequestCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ChromePeerManager {
    private static final String TAG = "ChromePeerManager";
    private PeerRegistrationListener mListener;
    private final Map<JsonRpcPeer, DisconnectReceiver> mReceivingPeers;

    private class UnregisterOnDisconnect implements DisconnectReceiver {
        private final JsonRpcPeer mPeer;

        public UnregisterOnDisconnect(JsonRpcPeer jsonRpcPeer) {
            this.mPeer = jsonRpcPeer;
        }

        public void onDisconnect() {
            ChromePeerManager.this.removePeer(this.mPeer);
        }
    }

    public ChromePeerManager() {
        this.mReceivingPeers = new HashMap();
    }

    public synchronized void setListener(PeerRegistrationListener peerRegistrationListener) {
        this.mListener = peerRegistrationListener;
    }

    public synchronized boolean addPeer(JsonRpcPeer jsonRpcPeer) {
        boolean z;
        if (this.mReceivingPeers.containsKey(jsonRpcPeer)) {
            z = false;
        } else {
            DisconnectReceiver unregisterOnDisconnect = new UnregisterOnDisconnect(jsonRpcPeer);
            jsonRpcPeer.registerDisconnectReceiver(unregisterOnDisconnect);
            this.mReceivingPeers.put(jsonRpcPeer, unregisterOnDisconnect);
            if (this.mListener != null) {
                this.mListener.onPeerRegistered(jsonRpcPeer);
            }
            z = true;
        }
        return z;
    }

    public synchronized void removePeer(JsonRpcPeer jsonRpcPeer) {
        if (!(this.mReceivingPeers.remove(jsonRpcPeer) == null || this.mListener == null)) {
            this.mListener.onPeerUnregistered(jsonRpcPeer);
        }
    }

    public synchronized boolean hasRegisteredPeers() {
        return !this.mReceivingPeers.isEmpty();
    }

    private synchronized ArrayList<JsonRpcPeer> getReceivingPeersCopy() {
        return new ArrayList(this.mReceivingPeers.keySet());
    }

    public void sendNotificationToPeers(String str, Object obj) {
        sendMessageToPeers(str, obj, null);
    }

    public void invokeMethodOnPeers(String str, Object obj, PendingRequestCallback pendingRequestCallback) {
        Util.throwIfNull(pendingRequestCallback);
        sendMessageToPeers(str, obj, pendingRequestCallback);
    }

    private void sendMessageToPeers(String str, Object obj, PendingRequestCallback pendingRequestCallback) {
        ArrayList receivingPeersCopy = getReceivingPeersCopy();
        int size = receivingPeersCopy.size();
        for (int i = 0; i < size; i++) {
            try {
                ((JsonRpcPeer) receivingPeersCopy.get(i)).invokeMethod(str, obj, pendingRequestCallback);
            } catch (Throwable e) {
                LogRedirector.m924e(TAG, "Error delivering data to Chrome", e);
            }
        }
    }
}

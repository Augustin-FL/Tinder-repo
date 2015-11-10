package com.facebook.stetho.inspector.jsonrpc;

import android.database.Observable;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcRequest;
import com.facebook.stetho.json.ObjectMapper;
import com.facebook.stetho.websocket.SimpleSession;
import java.nio.channels.NotYetConnectedException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class JsonRpcPeer {
    private final DisconnectObservable mDisconnectObservable;
    private long mNextRequestId;
    private final ObjectMapper mObjectMapper;
    private final SimpleSession mPeer;
    private final Map<Long, PendingRequest> mPendingRequests;

    private static class DisconnectObservable extends Observable<DisconnectReceiver> {
        private DisconnectObservable() {
        }

        public void onDisconnect() {
            Iterator it = this.mObservers.iterator();
            while (it.hasNext()) {
                ((DisconnectReceiver) it.next()).onDisconnect();
            }
        }
    }

    public JsonRpcPeer(ObjectMapper objectMapper, SimpleSession simpleSession) {
        this.mPendingRequests = new HashMap();
        this.mDisconnectObservable = new DisconnectObservable();
        this.mObjectMapper = objectMapper;
        this.mPeer = (SimpleSession) Util.throwIfNull(simpleSession);
    }

    public SimpleSession getWebSocket() {
        return this.mPeer;
    }

    public void invokeMethod(String str, Object obj, PendingRequestCallback pendingRequestCallback) throws NotYetConnectedException {
        Util.throwIfNull(str);
        this.mPeer.sendText(((JSONObject) this.mObjectMapper.convertValue(new JsonRpcRequest(pendingRequestCallback != null ? Long.valueOf(preparePendingRequest(pendingRequestCallback)) : null, str, (JSONObject) this.mObjectMapper.convertValue(obj, JSONObject.class)), JSONObject.class)).toString());
    }

    public void registerDisconnectReceiver(DisconnectReceiver disconnectReceiver) {
        this.mDisconnectObservable.registerObserver(disconnectReceiver);
    }

    public void unregisterDisconnectReceiver(DisconnectReceiver disconnectReceiver) {
        this.mDisconnectObservable.unregisterObserver(disconnectReceiver);
    }

    public void invokeDisconnectReceivers() {
        this.mDisconnectObservable.onDisconnect();
    }

    private synchronized long preparePendingRequest(PendingRequestCallback pendingRequestCallback) {
        long j;
        j = this.mNextRequestId;
        this.mNextRequestId = 1 + j;
        this.mPendingRequests.put(Long.valueOf(j), new PendingRequest(j, pendingRequestCallback));
        return j;
    }

    public synchronized PendingRequest getAndRemovePendingRequest(long j) {
        return (PendingRequest) this.mPendingRequests.remove(Long.valueOf(j));
    }
}

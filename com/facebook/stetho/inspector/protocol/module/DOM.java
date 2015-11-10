package com.facebook.stetho.inspector.protocol.module;

import android.graphics.Color;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.elements.AttributeAccumulator;
import com.facebook.stetho.inspector.elements.DOMProvider;
import com.facebook.stetho.inspector.elements.DOMProvider.Factory;
import com.facebook.stetho.inspector.elements.DOMProvider.Listener;
import com.facebook.stetho.inspector.elements.NodeDescriptor;
import com.facebook.stetho.inspector.elements.NodeType;
import com.facebook.stetho.inspector.helper.ChromePeerManager;
import com.facebook.stetho.inspector.helper.ObjectIdMapper;
import com.facebook.stetho.inspector.helper.PeersRegisteredListener;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcException;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.inspector.protocol.module.Runtime.ObjectSubType;
import com.facebook.stetho.inspector.protocol.module.Runtime.ObjectType;
import com.facebook.stetho.inspector.protocol.module.Runtime.RemoteObject;
import com.facebook.stetho.json.ObjectMapper;
import com.facebook.stetho.json.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

public class DOM implements ChromeDevtoolsDomain {
    private volatile DOMProvider mDOMProvider;
    private final Factory mDOMProviderFactory;
    private final DOMObjectIdMapper mObjectIdMapper;
    private final ObjectMapper mObjectMapper;
    private final ChromePeerManager mPeerManager;

    /* renamed from: com.facebook.stetho.inspector.protocol.module.DOM.1 */
    class C06791 implements Runnable {
        final /* synthetic */ GetDocumentResponse val$result;

        C06791(GetDocumentResponse getDocumentResponse) {
            this.val$result = getDocumentResponse;
        }

        public void run() {
            Object rootElement = DOM.this.mDOMProvider.getRootElement();
            if (rootElement != null) {
                this.val$result.root = DOM.this.createNodeForElement(rootElement);
            }
        }
    }

    /* renamed from: com.facebook.stetho.inspector.protocol.module.DOM.2 */
    class C06802 implements Runnable {
        final /* synthetic */ RGBAColor val$contentColor;
        final /* synthetic */ Object val$element;

        C06802(Object obj, RGBAColor rGBAColor) {
            this.val$element = obj;
            this.val$contentColor = rGBAColor;
        }

        public void run() {
            DOM.this.mDOMProvider.highlightElement(this.val$element, this.val$contentColor.getColor());
        }
    }

    private static final class AttributeListAccumulator implements AttributeAccumulator {
        private final List<String> mList;

        public AttributeListAccumulator(List<String> list) {
            this.mList = (List) Util.throwIfNull(list);
        }

        public void add(String str, String str2) {
            this.mList.add(str);
            this.mList.add(str2);
        }
    }

    private static class AttributeModifiedEvent {
        @JsonProperty(required = true)
        public String name;
        @JsonProperty(required = true)
        public int nodeId;
        @JsonProperty(required = true)
        public String value;

        private AttributeModifiedEvent() {
        }
    }

    private static class AttributeRemovedEvent {
        @JsonProperty(required = true)
        public String name;
        @JsonProperty(required = true)
        public int nodeId;

        private AttributeRemovedEvent() {
        }
    }

    private static class ChildNodeInsertedEvent {
        @JsonProperty(required = true)
        public Node node;
        @JsonProperty(required = true)
        public int parentNodeId;
        @JsonProperty(required = true)
        public int previousNodeId;

        private ChildNodeInsertedEvent() {
        }
    }

    private static class ChildNodeRemovedEvent {
        @JsonProperty(required = true)
        public int nodeId;
        @JsonProperty(required = true)
        public int parentNodeId;

        private ChildNodeRemovedEvent() {
        }
    }

    private final class DOMObjectIdMapper extends ObjectIdMapper {
        private DOMObjectIdMapper() {
        }

        protected void onMapped(Object obj, int i) {
            DOM.this.mDOMProvider.getNodeDescriptor(obj).hook(obj);
        }

        protected void onUnmapped(Object obj, int i) {
            DOM.this.mDOMProvider.getNodeDescriptor(obj).unhook(obj);
        }
    }

    private static class GetDocumentResponse implements JsonRpcResult {
        @JsonProperty(required = true)
        public Node root;

        private GetDocumentResponse() {
        }
    }

    private static class HighlightConfig {
        @JsonProperty
        public RGBAColor contentColor;

        private HighlightConfig() {
        }
    }

    private static class HighlightNodeRequest {
        @JsonProperty(required = true)
        public HighlightConfig highlightConfig;
        @JsonProperty
        public Integer nodeId;
        @JsonProperty
        public String objectId;

        private HighlightNodeRequest() {
        }
    }

    private static class InspectNodeRequestedEvent {
        @JsonProperty
        public int nodeId;

        private InspectNodeRequestedEvent() {
        }
    }

    private static class Node implements JsonRpcResult {
        @JsonProperty
        public List<String> attributes;
        @JsonProperty
        public Integer childNodeCount;
        @JsonProperty
        public List<Node> children;
        @JsonProperty(required = true)
        public String localName;
        @JsonProperty(required = true)
        public int nodeId;
        @JsonProperty(required = true)
        public String nodeName;
        @JsonProperty(required = true)
        public NodeType nodeType;
        @JsonProperty(required = true)
        public String nodeValue;

        private Node() {
        }
    }

    private final class PeerManagerListener extends PeersRegisteredListener {

        /* renamed from: com.facebook.stetho.inspector.protocol.module.DOM.PeerManagerListener.1 */
        class C06811 implements Runnable {
            C06811() {
            }

            public void run() {
                DOM.this.mObjectIdMapper.clear();
            }
        }

        private PeerManagerListener() {
        }

        protected synchronized void onFirstPeerRegistered() {
            DOM.this.mDOMProvider = DOM.this.mDOMProviderFactory.create();
            DOM.this.mDOMProvider.setListener(new ProviderListener(null));
        }

        protected synchronized void onLastPeerUnregistered() {
            DOM.this.mDOMProvider.postAndWait(new C06811());
            DOM.this.mDOMProvider.dispose();
            DOM.this.mDOMProvider = null;
        }
    }

    private final class ProviderListener implements Listener {
        private ProviderListener() {
        }

        public void onAttributeModified(Object obj, String str, String str2) {
            AttributeModifiedEvent attributeModifiedEvent = new AttributeModifiedEvent();
            attributeModifiedEvent.nodeId = DOM.this.mObjectIdMapper.getIdForObject(obj).intValue();
            attributeModifiedEvent.name = str;
            attributeModifiedEvent.value = str2;
            DOM.this.mPeerManager.sendNotificationToPeers("DOM.attributeModified", attributeModifiedEvent);
        }

        public void onAttributeRemoved(Object obj, String str) {
            AttributeRemovedEvent attributeRemovedEvent = new AttributeRemovedEvent();
            attributeRemovedEvent.nodeId = DOM.this.mObjectIdMapper.getIdForObject(obj).intValue();
            attributeRemovedEvent.name = str;
            DOM.this.mPeerManager.sendNotificationToPeers("DOM.attributeRemoved", attributeRemovedEvent);
        }

        public void onChildInserted(Object obj, Object obj2, Object obj3) {
            ChildNodeInsertedEvent childNodeInsertedEvent = new ChildNodeInsertedEvent();
            childNodeInsertedEvent.parentNodeId = DOM.this.mObjectIdMapper.getIdForObject(obj).intValue();
            childNodeInsertedEvent.previousNodeId = obj2 == null ? -1 : DOM.this.mObjectIdMapper.getIdForObject(obj2).intValue();
            childNodeInsertedEvent.node = DOM.this.createNodeForElement(obj3);
            DOM.this.mPeerManager.sendNotificationToPeers("DOM.childNodeInserted", childNodeInsertedEvent);
        }

        public void onChildRemoved(Object obj, Object obj2) {
            Integer idForObject = DOM.this.mObjectIdMapper.getIdForObject(obj);
            Integer idForObject2 = DOM.this.mObjectIdMapper.getIdForObject(obj2);
            if (idForObject == null || idForObject2 == null) {
                LogUtil.m932d("DOMProvider.Listener.onChildRemoved() called for a non-mapped node: parentElement=(nodeId=%s, %s), childElement=(nodeId=%s, %s)", idForObject, obj, idForObject2, obj2);
            } else {
                ChildNodeRemovedEvent childNodeRemovedEvent = new ChildNodeRemovedEvent();
                childNodeRemovedEvent.parentNodeId = idForObject.intValue();
                childNodeRemovedEvent.nodeId = idForObject2.intValue();
                DOM.this.mPeerManager.sendNotificationToPeers("DOM.childNodeRemoved", childNodeRemovedEvent);
            }
            DOM.this.removeElementTree(obj2);
        }

        public void onInspectRequested(Object obj) {
            Integer idForObject = DOM.this.mObjectIdMapper.getIdForObject(obj);
            if (idForObject == null) {
                LogUtil.m932d("DOMProvider.Listener.onInspectRequested() called for a non-mapped node: element=%s", obj);
                return;
            }
            InspectNodeRequestedEvent inspectNodeRequestedEvent = new InspectNodeRequestedEvent();
            inspectNodeRequestedEvent.nodeId = idForObject.intValue();
            DOM.this.mPeerManager.sendNotificationToPeers("DOM.inspectNodeRequested", inspectNodeRequestedEvent);
        }
    }

    private static class RGBAColor {
        @JsonProperty
        public Double f705a;
        @JsonProperty(required = true)
        public int f706b;
        @JsonProperty(required = true)
        public int f707g;
        @JsonProperty(required = true)
        public int f708r;

        private RGBAColor() {
        }

        public int getColor() {
            int i = -1;
            if (this.f705a != null) {
                long round = Math.round(this.f705a.doubleValue() * 255.0d);
                if (round < 0) {
                    i = 0;
                } else if (round < 255) {
                    i = (byte) ((int) round);
                }
            }
            return Color.argb(i, this.f708r, this.f707g, this.f706b);
        }
    }

    private static class ResolveNodeRequest {
        @JsonProperty(required = true)
        public int nodeId;
        @JsonProperty
        public String objectGroup;

        private ResolveNodeRequest() {
        }
    }

    private static class ResolveNodeResponse implements JsonRpcResult {
        @JsonProperty(required = true)
        public RemoteObject object;

        private ResolveNodeResponse() {
        }
    }

    private static class SetInspectModeEnabledRequest {
        @JsonProperty(required = true)
        public boolean enabled;
        @JsonProperty
        public HighlightConfig highlightConfig;
        @JsonProperty
        public Boolean inspectShadowDOM;

        private SetInspectModeEnabledRequest() {
        }
    }

    public DOM(Factory factory) {
        this.mDOMProviderFactory = (Factory) Util.throwIfNull(factory);
        this.mPeerManager = new ChromePeerManager();
        this.mPeerManager.setListener(new PeerManagerListener());
        this.mObjectMapper = new ObjectMapper();
        this.mObjectIdMapper = new DOMObjectIdMapper();
    }

    @ChromeDevtoolsMethod
    public void enable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        this.mPeerManager.addPeer(jsonRpcPeer);
    }

    @ChromeDevtoolsMethod
    public void disable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        this.mPeerManager.removePeer(jsonRpcPeer);
    }

    @ChromeDevtoolsMethod
    public JsonRpcResult getDocument(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        JsonRpcResult getDocumentResponse = new GetDocumentResponse();
        this.mDOMProvider.postAndWait(new C06791(getDocumentResponse));
        return getDocumentResponse;
    }

    @ChromeDevtoolsMethod
    public void highlightNode(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        HighlightNodeRequest highlightNodeRequest = (HighlightNodeRequest) this.mObjectMapper.convertValue(jSONObject, HighlightNodeRequest.class);
        if (highlightNodeRequest.nodeId == null) {
            LogUtil.m947w("DOM.highlightNode was not given a nodeId; JS objectId is not supported");
            return;
        }
        RGBAColor rGBAColor = highlightNodeRequest.highlightConfig.contentColor;
        if (rGBAColor == null) {
            LogUtil.m947w("DOM.highlightNode was not given a color to highlight with");
            return;
        }
        this.mDOMProvider.postAndWait(new C06802(this.mObjectIdMapper.getObjectForId(highlightNodeRequest.nodeId.intValue()), rGBAColor));
    }

    @ChromeDevtoolsMethod
    public void hideHighlight(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        this.mDOMProvider.hideHighlight();
    }

    @ChromeDevtoolsMethod
    public ResolveNodeResponse resolveNode(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) throws JsonRpcException {
        int mapObject = Runtime.mapObject(jsonRpcPeer, this.mObjectIdMapper.getObjectForId(((ResolveNodeRequest) this.mObjectMapper.convertValue(jSONObject, ResolveNodeRequest.class)).nodeId));
        RemoteObject remoteObject = new RemoteObject();
        remoteObject.type = ObjectType.OBJECT;
        remoteObject.subtype = ObjectSubType.NODE;
        remoteObject.className = remoteObject.getClass().getName();
        remoteObject.value = null;
        remoteObject.description = null;
        remoteObject.objectId = String.valueOf(mapObject);
        ResolveNodeResponse resolveNodeResponse = new ResolveNodeResponse();
        resolveNodeResponse.object = remoteObject;
        return resolveNodeResponse;
    }

    @ChromeDevtoolsMethod
    public void setInspectModeEnabled(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        this.mDOMProvider.setInspectModeEnabled(((SetInspectModeEnabledRequest) this.mObjectMapper.convertValue(jSONObject, SetInspectModeEnabledRequest.class)).enabled);
    }

    private Node createNodeForElement(Object obj) {
        NodeDescriptor nodeDescriptor = this.mDOMProvider.getNodeDescriptor(obj);
        Node node = new Node();
        node.nodeId = this.mObjectIdMapper.putObject(obj);
        node.nodeType = nodeDescriptor.getNodeType(obj);
        node.nodeName = nodeDescriptor.getNodeName(obj);
        node.localName = nodeDescriptor.getLocalName(obj);
        node.nodeValue = nodeDescriptor.getNodeValue(obj);
        node.children = getChildNodesForElement(obj);
        node.childNodeCount = Integer.valueOf(node.children.size());
        node.attributes = new ArrayList();
        nodeDescriptor.copyAttributes(obj, new AttributeListAccumulator(node.attributes));
        return node;
    }

    private List<Node> getChildNodesForElement(Object obj) {
        NodeDescriptor nodeDescriptor = this.mDOMProvider.getNodeDescriptor(obj);
        int childCount = nodeDescriptor.getChildCount(obj);
        if (childCount == 0) {
            return Collections.emptyList();
        }
        List<Node> arrayList = new ArrayList(childCount);
        for (int i = 0; i < childCount; i++) {
            arrayList.add(createNodeForElement(nodeDescriptor.getChildAt(obj, i)));
        }
        return arrayList;
    }

    private void removeElementTree(Object obj) {
        int i = 0;
        if (this.mObjectIdMapper.containsObject(obj)) {
            NodeDescriptor nodeDescriptor = this.mDOMProvider.getNodeDescriptor(obj);
            int childCount = nodeDescriptor.getChildCount(obj);
            while (i < childCount) {
                removeElementTree(nodeDescriptor.getChildAt(obj, i));
                i++;
            }
            this.mObjectIdMapper.removeObject(obj);
            return;
        }
        LogUtil.m948w("DOM.removeElementTree() called for a non-mapped node: element=%s", obj);
    }
}

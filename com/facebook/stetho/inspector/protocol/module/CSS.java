package com.facebook.stetho.inspector.protocol.module;

import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.json.annotation.JsonProperty;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

public class CSS implements ChromeDevtoolsDomain {

    private static class CSSPropertyInfo {
        private CSSPropertyInfo() {
        }
    }

    private static class GetSupportedCSSPropertiesResponse implements JsonRpcResult {
        @JsonProperty(required = true)
        public List<CSSPropertyInfo> cssProperties;

        private GetSupportedCSSPropertiesResponse() {
        }
    }

    @ChromeDevtoolsMethod
    public void enable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
    }

    @ChromeDevtoolsMethod
    public void disable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
    }

    @ChromeDevtoolsMethod
    public JsonRpcResult getSupportedCSSProperties(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        JsonRpcResult getSupportedCSSPropertiesResponse = new GetSupportedCSSPropertiesResponse();
        getSupportedCSSPropertiesResponse.cssProperties = Collections.emptyList();
        return getSupportedCSSPropertiesResponse;
    }
}

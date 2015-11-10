package com.facebook.stetho.volley;

import com.android.volley.Request;
import com.facebook.stetho.inspector.network.NetworkEventReporter.InspectorResponse;
import org.apache.http.HttpResponse;

public class VolleyNetworkInspectorResponse implements InspectorResponse {
    private final Request request;
    private final String requestId;
    private final HttpResponse response;

    public VolleyNetworkInspectorResponse(Request request, HttpResponse httpResponse, String str) {
        this.response = httpResponse;
        this.requestId = str;
        this.request = request;
    }

    public int headerCount() {
        return this.response.getAllHeaders().length;
    }

    public String headerName(int i) {
        return this.response.getAllHeaders()[i].getName();
    }

    public String headerValue(int i) {
        return this.response.getAllHeaders()[i].getValue();
    }

    public String firstHeaderValue(String str) {
        return null;
    }

    public String requestId() {
        return this.requestId;
    }

    public String url() {
        return this.request.m228d();
    }

    public int statusCode() {
        return this.response.getStatusLine().getStatusCode();
    }

    public String reasonPhrase() {
        return null;
    }

    public boolean connectionReused() {
        return false;
    }

    public int connectionId() {
        return 0;
    }

    public boolean fromDiskCache() {
        return false;
    }
}

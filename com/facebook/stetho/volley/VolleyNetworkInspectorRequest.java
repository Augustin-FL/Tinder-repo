package com.facebook.stetho.volley;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.facebook.stetho.inspector.network.NetworkEventReporter.InspectorRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class VolleyNetworkInspectorRequest implements InspectorRequest {
    private ArrayList<Entry<String, String>> orderedHeaders;
    private final Request request;
    private final String requestId;

    public VolleyNetworkInspectorRequest(int i, Request request) throws AuthFailureError {
        this.requestId = String.valueOf(i);
        this.request = request;
        this.orderedHeaders = new ArrayList();
        if (request != null && request.m233i() != null) {
            this.orderedHeaders.addAll(request.m233i().entrySet());
        }
    }

    public String id() {
        return this.requestId;
    }

    public String friendlyName() {
        return url();
    }

    public Integer friendlyNameExtra() {
        return null;
    }

    public String url() {
        return this.request.m228d();
    }

    public String method() {
        return getMethodName(this.request.m212a());
    }

    public byte[] body() throws IOException {
        try {
            return this.request.m241q();
        } catch (AuthFailureError e) {
            return null;
        }
    }

    public int headerCount() {
        return this.orderedHeaders.size();
    }

    public String headerName(int i) {
        return (String) ((Entry) this.orderedHeaders.get(i)).getKey();
    }

    public String headerValue(int i) {
        return (String) ((Entry) this.orderedHeaders.get(i)).getValue();
    }

    public String firstHeaderValue(String str) {
        Iterator it = this.orderedHeaders.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            if (((String) entry.getKey()).equals(str)) {
                return (String) entry.getValue();
            }
        }
        return null;
    }

    public String getMethodName(int i) {
        switch (i) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                return "GET";
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                return "POST";
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                return "PUT";
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                return "DELETE";
            default:
                return "GET";
        }
    }
}

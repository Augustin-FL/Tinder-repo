package com.facebook.stetho.inspector.elements.android;

import android.view.View;
import com.facebook.stetho.common.StringUtil;
import com.facebook.stetho.common.android.ResourcesUtil;
import com.facebook.stetho.inspector.elements.AttributeAccumulator;
import com.facebook.stetho.inspector.elements.ChainedDescriptor;

final class ViewDescriptor extends ChainedDescriptor<View> implements HighlightableDescriptor {
    private static final String ID_ATTRIBUTE_NAME = "id";

    ViewDescriptor() {
    }

    protected String onGetNodeName(View view) {
        String name = view.getClass().getName();
        return StringUtil.removePrefix(name, "android.view.", StringUtil.removePrefix(name, "android.widget."));
    }

    protected void onCopyAttributes(View view, AttributeAccumulator attributeAccumulator) {
        String idAttribute = getIdAttribute(view);
        if (idAttribute != null) {
            attributeAccumulator.add(ID_ATTRIBUTE_NAME, idAttribute);
        }
    }

    private static String getIdAttribute(View view) {
        int id = view.getId();
        if (id == -1) {
            return null;
        }
        return ResourcesUtil.getIdStringQuietly(view, view.getResources(), id);
    }

    public View getViewForHighlighting(Object obj) {
        return (View) obj;
    }
}

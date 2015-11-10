package com.facebook.stetho.inspector.elements.android;

import android.view.View;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.android.FragmentAccessor;
import com.facebook.stetho.common.android.FragmentApi;
import com.facebook.stetho.common.android.ResourcesUtil;
import com.facebook.stetho.inspector.elements.AttributeAccumulator;
import com.facebook.stetho.inspector.elements.ChainedDescriptor;
import com.facebook.stetho.inspector.elements.DescriptorMap;

final class FragmentDescriptor extends ChainedDescriptor<Object> implements HighlightableDescriptor {
    private static final String ID_ATTRIBUTE_NAME = "id";
    private static final String TAG_ATTRIBUTE_NAME = "tag";

    public static DescriptorMap register(DescriptorMap descriptorMap) {
        Class tryGetSupportFragmentClass = FragmentApi.tryGetSupportFragmentClass();
        if (tryGetSupportFragmentClass != null) {
            LogUtil.m931d("Registering support Fragment descriptor");
            descriptorMap.register(tryGetSupportFragmentClass, new FragmentDescriptor());
        }
        tryGetSupportFragmentClass = FragmentApi.tryGetFragmentClass();
        if (tryGetSupportFragmentClass != null) {
            LogUtil.m931d("Registering Fragment descriptor");
            descriptorMap.register(tryGetSupportFragmentClass, new FragmentDescriptor());
        }
        return descriptorMap;
    }

    private FragmentDescriptor() {
    }

    protected void onCopyAttributes(Object obj, AttributeAccumulator attributeAccumulator) {
        FragmentAccessor fragmentAccessorFor = FragmentApi.getFragmentAccessorFor(obj);
        int id = fragmentAccessorFor.getId(obj);
        if (id != -1) {
            attributeAccumulator.add(ID_ATTRIBUTE_NAME, ResourcesUtil.getIdStringQuietly(obj, fragmentAccessorFor.getResources(obj), id));
        }
        String tag = fragmentAccessorFor.getTag(obj);
        if (tag != null && tag.length() > 0) {
            attributeAccumulator.add(TAG_ATTRIBUTE_NAME, tag);
        }
    }

    protected int onGetChildCount(Object obj) {
        return FragmentApi.getFragmentAccessorFor(obj).getView(obj) == null ? 0 : 1;
    }

    protected Object onGetChildAt(Object obj, int i) {
        if (i != 0) {
            throw new IndexOutOfBoundsException();
        }
        View view = FragmentApi.getFragmentAccessorFor(obj).getView(obj);
        if (view != null) {
            return view;
        }
        throw new IndexOutOfBoundsException();
    }

    public View getViewForHighlighting(Object obj) {
        return FragmentApi.getFragmentAccessorFor(obj).getView(obj);
    }
}

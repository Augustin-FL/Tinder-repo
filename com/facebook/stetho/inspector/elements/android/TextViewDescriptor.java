package com.facebook.stetho.inspector.elements.android;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.elements.AttributeAccumulator;
import com.facebook.stetho.inspector.elements.ChainedDescriptor;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;

final class TextViewDescriptor extends ChainedDescriptor<TextView> {
    private static final String TEXT_ATTRIBUTE_NAME = "text";
    private final Map<TextView, ElementContext> mElementToContextMap;

    private final class ElementContext implements TextWatcher {
        private TextView mElement;

        private ElementContext() {
        }

        public void hook(TextView textView) {
            this.mElement = (TextView) Util.throwIfNull(textView);
            this.mElement.addTextChangedListener(this);
        }

        public void unhook() {
            if (this.mElement != null) {
                this.mElement.removeTextChangedListener(this);
                this.mElement = null;
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            if (editable.length() == 0) {
                TextViewDescriptor.this.getHost().onAttributeRemoved(this.mElement, TextViewDescriptor.TEXT_ATTRIBUTE_NAME);
            } else {
                TextViewDescriptor.this.getHost().onAttributeModified(this.mElement, TextViewDescriptor.TEXT_ATTRIBUTE_NAME, editable.toString());
            }
        }
    }

    TextViewDescriptor() {
        this.mElementToContextMap = Collections.synchronizedMap(new IdentityHashMap());
    }

    protected void onHook(TextView textView) {
        ElementContext elementContext = new ElementContext();
        elementContext.hook(textView);
        this.mElementToContextMap.put(textView, elementContext);
    }

    protected void onUnhook(TextView textView) {
        ((ElementContext) this.mElementToContextMap.remove(textView)).unhook();
    }

    protected void onCopyAttributes(TextView textView, AttributeAccumulator attributeAccumulator) {
        CharSequence text = textView.getText();
        if (text.length() != 0) {
            attributeAccumulator.add(TEXT_ATTRIBUTE_NAME, text.toString());
        }
    }
}

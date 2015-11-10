package com.facebook.stetho.common.android;

import java.util.List;

public interface FragmentManagerAccessor {
    List<?> getAddedFragments(Object obj);
}

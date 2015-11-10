package com.facebook.internal;

import com.facebook.FacebookException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CollectionMapper {

    public interface OnErrorListener {
        void onError(FacebookException facebookException);
    }

    public interface OnMapperCompleteListener extends OnErrorListener {
        void onComplete();
    }

    /* renamed from: com.facebook.internal.CollectionMapper.1 */
    static class C05311 implements OnMapperCompleteListener {
        final /* synthetic */ Mutable val$didReturnError;
        final /* synthetic */ OnMapperCompleteListener val$onMapperCompleteListener;
        final /* synthetic */ Mutable val$pendingJobCount;

        C05311(Mutable mutable, Mutable mutable2, OnMapperCompleteListener onMapperCompleteListener) {
            this.val$didReturnError = mutable;
            this.val$pendingJobCount = mutable2;
            this.val$onMapperCompleteListener = onMapperCompleteListener;
        }

        public void onComplete() {
            if (!((Boolean) this.val$didReturnError.value).booleanValue()) {
                Mutable mutable = this.val$pendingJobCount;
                Integer valueOf = Integer.valueOf(((Integer) this.val$pendingJobCount.value).intValue() - 1);
                mutable.value = valueOf;
                if (valueOf.intValue() == 0) {
                    this.val$onMapperCompleteListener.onComplete();
                }
            }
        }

        public void onError(FacebookException facebookException) {
            if (!((Boolean) this.val$didReturnError.value).booleanValue()) {
                this.val$didReturnError.value = Boolean.valueOf(true);
                this.val$onMapperCompleteListener.onError(facebookException);
            }
        }
    }

    public interface OnMapValueCompleteListener extends OnErrorListener {
        void onComplete(Object obj);
    }

    /* renamed from: com.facebook.internal.CollectionMapper.2 */
    static class C05322 implements OnMapValueCompleteListener {
        final /* synthetic */ Collection val$collection;
        final /* synthetic */ OnMapperCompleteListener val$jobCompleteListener;
        final /* synthetic */ Object val$key;

        C05322(Collection collection, Object obj, OnMapperCompleteListener onMapperCompleteListener) {
            this.val$collection = collection;
            this.val$key = obj;
            this.val$jobCompleteListener = onMapperCompleteListener;
        }

        public void onComplete(Object obj) {
            this.val$collection.set(this.val$key, obj, this.val$jobCompleteListener);
            this.val$jobCompleteListener.onComplete();
        }

        public void onError(FacebookException facebookException) {
            this.val$jobCompleteListener.onError(facebookException);
        }
    }

    public interface Collection<T> {
        Object get(T t);

        Iterator<T> keyIterator();

        void set(T t, Object obj, OnErrorListener onErrorListener);
    }

    public interface ValueMapper {
        void mapValue(Object obj, OnMapValueCompleteListener onMapValueCompleteListener);
    }

    public static <T> void iterate(Collection<T> collection, ValueMapper valueMapper, OnMapperCompleteListener onMapperCompleteListener) {
        Mutable mutable = new Mutable(Boolean.valueOf(false));
        Mutable mutable2 = new Mutable(Integer.valueOf(1));
        OnMapperCompleteListener c05311 = new C05311(mutable, mutable2, onMapperCompleteListener);
        Iterator keyIterator = collection.keyIterator();
        List linkedList = new LinkedList();
        while (keyIterator.hasNext()) {
            linkedList.add(keyIterator.next());
        }
        for (Object next : linkedList) {
            Object obj = collection.get(next);
            OnMapValueCompleteListener c05322 = new C05322(collection, next, c05311);
            Integer num = (Integer) mutable2.value;
            mutable2.value = Integer.valueOf(((Integer) mutable2.value).intValue() + 1);
            valueMapper.mapValue(obj, c05322);
        }
        c05311.onComplete();
    }

    private CollectionMapper() {
    }
}

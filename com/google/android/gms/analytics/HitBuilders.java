package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.facebook.stetho.BuildConfig;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.analytics.internal.zzae;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.tagmanager.DataLayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HitBuilders {

    protected static class HitBuilder<T extends HitBuilder> {
        private Map<String, String> zzKB;
        ProductAction zzKC;
        Map<String, List<Product>> zzKD;
        List<Promotion> zzKE;
        List<Product> zzKF;

        protected HitBuilder() {
            this.zzKB = new HashMap();
            this.zzKD = new HashMap();
            this.zzKE = new ArrayList();
            this.zzKF = new ArrayList();
        }

        public T addImpression(Product product, String str) {
            if (product == null) {
                zzae.zzaE("product should be non-null");
            } else {
                Object obj;
                if (str == null) {
                    obj = BuildConfig.FLAVOR;
                }
                if (!this.zzKD.containsKey(obj)) {
                    this.zzKD.put(obj, new ArrayList());
                }
                ((List) this.zzKD.get(obj)).add(product);
            }
            return this;
        }

        public T addProduct(Product product) {
            if (product == null) {
                zzae.zzaE("product should be non-null");
            } else {
                this.zzKF.add(product);
            }
            return this;
        }

        public T addPromotion(Promotion promotion) {
            if (promotion == null) {
                zzae.zzaE("promotion should be non-null");
            } else {
                this.zzKE.add(promotion);
            }
            return this;
        }

        public Map<String, String> build() {
            Map<String, String> hashMap = new HashMap(this.zzKB);
            if (this.zzKC != null) {
                hashMap.putAll(this.zzKC.build());
            }
            int i = 1;
            for (Promotion zzaV : this.zzKE) {
                hashMap.putAll(zzaV.zzaV(zzc.zzU(i)));
                i++;
            }
            i = 1;
            for (Product zzaV2 : this.zzKF) {
                hashMap.putAll(zzaV2.zzaV(zzc.zzS(i)));
                i++;
            }
            int i2 = 1;
            for (Entry entry : this.zzKD.entrySet()) {
                List<Product> list = (List) entry.getValue();
                String zzX = zzc.zzX(i2);
                int i3 = 1;
                for (Product zzaV3 : list) {
                    hashMap.putAll(zzaV3.zzaV(zzX + zzc.zzW(i3)));
                    i3++;
                }
                if (!TextUtils.isEmpty((CharSequence) entry.getKey())) {
                    hashMap.put(zzX + "nm", entry.getKey());
                }
                i2++;
            }
            return hashMap;
        }

        protected String get(String str) {
            return (String) this.zzKB.get(str);
        }

        public final T set(String str, String str2) {
            if (str != null) {
                this.zzKB.put(str, str2);
            } else {
                zzae.zzaE(" HitBuilder.set() called with a null paramName.");
            }
            return this;
        }

        public final T setAll(Map<String, String> map) {
            if (map != null) {
                this.zzKB.putAll(new HashMap(map));
            }
            return this;
        }

        public T setCampaignParamsFromUrl(String str) {
            Object zzbp = zzam.zzbp(str);
            if (!TextUtils.isEmpty(zzbp)) {
                Map zzbn = zzam.zzbn(zzbp);
                set("&cc", (String) zzbn.get("utm_content"));
                set("&cm", (String) zzbn.get("utm_medium"));
                set("&cn", (String) zzbn.get("utm_campaign"));
                set("&cs", (String) zzbn.get("utm_source"));
                set("&ck", (String) zzbn.get("utm_term"));
                set("&ci", (String) zzbn.get("utm_id"));
                set("&anid", (String) zzbn.get("anid"));
                set("&gclid", (String) zzbn.get("gclid"));
                set("&dclid", (String) zzbn.get("dclid"));
                set("&aclid", (String) zzbn.get("aclid"));
                set("&gmob_t", (String) zzbn.get("gmob_t"));
            }
            return this;
        }

        public T setCustomDimension(int i, String str) {
            set(zzc.zzO(i), str);
            return this;
        }

        public T setCustomMetric(int i, float f) {
            set(zzc.zzQ(i), Float.toString(f));
            return this;
        }

        protected T setHitType(String str) {
            set("&t", str);
            return this;
        }

        public T setNewSession() {
            set("&sc", "start");
            return this;
        }

        public T setNonInteraction(boolean z) {
            set("&ni", zzam.zzJ(z));
            return this;
        }

        public T setProductAction(ProductAction productAction) {
            this.zzKC = productAction;
            return this;
        }

        public T setPromotionAction(String str) {
            this.zzKB.put("&promoa", str);
            return this;
        }
    }

    @Deprecated
    public static class AppViewBuilder extends HitBuilder<AppViewBuilder> {
        public AppViewBuilder() {
            set("&t", "screenview");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }
    }

    public static class EventBuilder extends HitBuilder<EventBuilder> {
        public EventBuilder() {
            set("&t", DataLayer.EVENT_KEY);
        }

        public EventBuilder(String str, String str2) {
            this();
            setCategory(str);
            setAction(str2);
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public EventBuilder setAction(String str) {
            set("&ea", str);
            return this;
        }

        public EventBuilder setCategory(String str) {
            set("&ec", str);
            return this;
        }

        public EventBuilder setLabel(String str) {
            set("&el", str);
            return this;
        }

        public EventBuilder setValue(long j) {
            set("&ev", Long.toString(j));
            return this;
        }
    }

    public static class ExceptionBuilder extends HitBuilder<ExceptionBuilder> {
        public ExceptionBuilder() {
            set("&t", "exception");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public ExceptionBuilder setDescription(String str) {
            set("&exd", str);
            return this;
        }

        public ExceptionBuilder setFatal(boolean z) {
            set("&exf", zzam.zzJ(z));
            return this;
        }
    }

    @Deprecated
    public static class ItemBuilder extends HitBuilder<ItemBuilder> {
        public ItemBuilder() {
            set("&t", "item");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public ItemBuilder setCategory(String str) {
            set("&iv", str);
            return this;
        }

        public ItemBuilder setCurrencyCode(String str) {
            set("&cu", str);
            return this;
        }

        public ItemBuilder setName(String str) {
            set("&in", str);
            return this;
        }

        public ItemBuilder setPrice(double d) {
            set("&ip", Double.toString(d));
            return this;
        }

        public ItemBuilder setQuantity(long j) {
            set("&iq", Long.toString(j));
            return this;
        }

        public ItemBuilder setSku(String str) {
            set("&ic", str);
            return this;
        }

        public ItemBuilder setTransactionId(String str) {
            set("&ti", str);
            return this;
        }
    }

    public static class ScreenViewBuilder extends HitBuilder<ScreenViewBuilder> {
        public ScreenViewBuilder() {
            set("&t", "screenview");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }
    }

    public static class SocialBuilder extends HitBuilder<SocialBuilder> {
        public SocialBuilder() {
            set("&t", NotificationCompatApi21.CATEGORY_SOCIAL);
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public SocialBuilder setAction(String str) {
            set("&sa", str);
            return this;
        }

        public SocialBuilder setNetwork(String str) {
            set("&sn", str);
            return this;
        }

        public SocialBuilder setTarget(String str) {
            set("&st", str);
            return this;
        }
    }

    public static class TimingBuilder extends HitBuilder<TimingBuilder> {
        public TimingBuilder() {
            set("&t", "timing");
        }

        public TimingBuilder(String str, String str2, long j) {
            this();
            setVariable(str2);
            setValue(j);
            setCategory(str);
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public TimingBuilder setCategory(String str) {
            set("&utc", str);
            return this;
        }

        public TimingBuilder setLabel(String str) {
            set("&utl", str);
            return this;
        }

        public TimingBuilder setValue(long j) {
            set("&utt", Long.toString(j));
            return this;
        }

        public TimingBuilder setVariable(String str) {
            set("&utv", str);
            return this;
        }
    }

    @Deprecated
    public static class TransactionBuilder extends HitBuilder<TransactionBuilder> {
        public TransactionBuilder() {
            set("&t", "transaction");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public TransactionBuilder setAffiliation(String str) {
            set("&ta", str);
            return this;
        }

        public TransactionBuilder setCurrencyCode(String str) {
            set("&cu", str);
            return this;
        }

        public TransactionBuilder setRevenue(double d) {
            set("&tr", Double.toString(d));
            return this;
        }

        public TransactionBuilder setShipping(double d) {
            set("&ts", Double.toString(d));
            return this;
        }

        public TransactionBuilder setTax(double d) {
            set("&tt", Double.toString(d));
            return this;
        }

        public TransactionBuilder setTransactionId(String str) {
            set("&ti", str);
            return this;
        }
    }
}

package com.google.i18n.phonenumbers;

import com.facebook.stetho.BuildConfig;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

public final class Phonemetadata {

    public static class NumberFormat implements Externalizable {
        private static final long serialVersionUID = 1;
        private boolean f2589a;
        private String f2590b;
        private boolean f2591c;
        private String f2592d;
        private List<String> f2593e;
        private boolean f2594f;
        private String f2595g;
        private boolean f2596h;
        private boolean f2597i;
        private boolean f2598j;
        private String f2599k;

        public NumberFormat() {
            this.f2590b = BuildConfig.FLAVOR;
            this.f2592d = BuildConfig.FLAVOR;
            this.f2593e = new ArrayList();
            this.f2595g = BuildConfig.FLAVOR;
            this.f2597i = false;
            this.f2599k = BuildConfig.FLAVOR;
        }

        public String m4488a() {
            return this.f2590b;
        }

        public NumberFormat m4486a(String str) {
            this.f2589a = true;
            this.f2590b = str;
            return this;
        }

        public String m4491b() {
            return this.f2592d;
        }

        public NumberFormat m4490b(String str) {
            this.f2591c = true;
            this.f2592d = str;
            return this;
        }

        public int m4492c() {
            return this.f2593e.size();
        }

        public String m4489a(int i) {
            return (String) this.f2593e.get(i);
        }

        public String m4495d() {
            return this.f2595g;
        }

        public NumberFormat m4493c(String str) {
            this.f2594f = true;
            this.f2595g = str;
            return this;
        }

        public boolean m4496e() {
            return this.f2597i;
        }

        public NumberFormat m4487a(boolean z) {
            this.f2596h = true;
            this.f2597i = z;
            return this;
        }

        public NumberFormat m4494d(String str) {
            this.f2598j = true;
            this.f2599k = str;
            return this;
        }

        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeUTF(this.f2590b);
            objectOutput.writeUTF(this.f2592d);
            int c = m4492c();
            objectOutput.writeInt(c);
            for (int i = 0; i < c; i++) {
                objectOutput.writeUTF((String) this.f2593e.get(i));
            }
            objectOutput.writeBoolean(this.f2594f);
            if (this.f2594f) {
                objectOutput.writeUTF(this.f2595g);
            }
            objectOutput.writeBoolean(this.f2598j);
            if (this.f2598j) {
                objectOutput.writeUTF(this.f2599k);
            }
            objectOutput.writeBoolean(this.f2597i);
        }

        public void readExternal(ObjectInput objectInput) throws IOException {
            m4486a(objectInput.readUTF());
            m4490b(objectInput.readUTF());
            int readInt = objectInput.readInt();
            for (int i = 0; i < readInt; i++) {
                this.f2593e.add(objectInput.readUTF());
            }
            if (objectInput.readBoolean()) {
                m4493c(objectInput.readUTF());
            }
            if (objectInput.readBoolean()) {
                m4494d(objectInput.readUTF());
            }
            m4487a(objectInput.readBoolean());
        }
    }

    public static class PhoneMetadata implements Externalizable {
        private static final long serialVersionUID = 1;
        private boolean f2600A;
        private PhoneNumberDesc f2601B;
        private boolean f2602C;
        private PhoneNumberDesc f2603D;
        private boolean f2604E;
        private PhoneNumberDesc f2605F;
        private boolean f2606G;
        private String f2607H;
        private boolean f2608I;
        private int f2609J;
        private boolean f2610K;
        private String f2611L;
        private boolean f2612M;
        private String f2613N;
        private boolean f2614O;
        private String f2615P;
        private boolean f2616Q;
        private String f2617R;
        private boolean f2618S;
        private String f2619T;
        private boolean f2620U;
        private String f2621V;
        private boolean f2622W;
        private boolean f2623X;
        private List<NumberFormat> f2624Y;
        private List<NumberFormat> f2625Z;
        private boolean f2626a;
        private boolean aa;
        private boolean ab;
        private boolean ac;
        private String ad;
        private boolean ae;
        private boolean af;
        private boolean ag;
        private boolean ah;
        private PhoneNumberDesc f2627b;
        private boolean f2628c;
        private PhoneNumberDesc f2629d;
        private boolean f2630e;
        private PhoneNumberDesc f2631f;
        private boolean f2632g;
        private PhoneNumberDesc f2633h;
        private boolean f2634i;
        private PhoneNumberDesc f2635j;
        private boolean f2636k;
        private PhoneNumberDesc f2637l;
        private boolean f2638m;
        private PhoneNumberDesc f2639n;
        private boolean f2640o;
        private PhoneNumberDesc f2641p;
        private boolean f2642q;
        private PhoneNumberDesc f2643r;
        private boolean f2644s;
        private PhoneNumberDesc f2645t;
        private boolean f2646u;
        private PhoneNumberDesc f2647v;
        private boolean f2648w;
        private PhoneNumberDesc f2649x;
        private boolean f2650y;
        private PhoneNumberDesc f2651z;

        public PhoneMetadata() {
            this.f2627b = null;
            this.f2629d = null;
            this.f2631f = null;
            this.f2633h = null;
            this.f2635j = null;
            this.f2637l = null;
            this.f2639n = null;
            this.f2641p = null;
            this.f2643r = null;
            this.f2645t = null;
            this.f2647v = null;
            this.f2649x = null;
            this.f2651z = null;
            this.f2601B = null;
            this.f2603D = null;
            this.f2605F = null;
            this.f2607H = BuildConfig.FLAVOR;
            this.f2609J = 0;
            this.f2611L = BuildConfig.FLAVOR;
            this.f2613N = BuildConfig.FLAVOR;
            this.f2615P = BuildConfig.FLAVOR;
            this.f2617R = BuildConfig.FLAVOR;
            this.f2619T = BuildConfig.FLAVOR;
            this.f2621V = BuildConfig.FLAVOR;
            this.f2623X = false;
            this.f2624Y = new ArrayList();
            this.f2625Z = new ArrayList();
            this.ab = false;
            this.ad = BuildConfig.FLAVOR;
            this.af = false;
            this.ah = false;
        }

        public PhoneMetadata m4499a(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc == null) {
                throw new NullPointerException();
            }
            this.f2626a = true;
            this.f2627b = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata m4502b(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc == null) {
                throw new NullPointerException();
            }
            this.f2628c = true;
            this.f2629d = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata m4506c(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc == null) {
                throw new NullPointerException();
            }
            this.f2630e = true;
            this.f2631f = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata m4510d(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc == null) {
                throw new NullPointerException();
            }
            this.f2632g = true;
            this.f2633h = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata m4514e(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc == null) {
                throw new NullPointerException();
            }
            this.f2634i = true;
            this.f2635j = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata m4517f(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc == null) {
                throw new NullPointerException();
            }
            this.f2636k = true;
            this.f2637l = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata m4521g(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc == null) {
                throw new NullPointerException();
            }
            this.f2638m = true;
            this.f2639n = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata m4523h(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc == null) {
                throw new NullPointerException();
            }
            this.f2640o = true;
            this.f2641p = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata m4527i(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc == null) {
                throw new NullPointerException();
            }
            this.f2642q = true;
            this.f2643r = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata m4528j(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc == null) {
                throw new NullPointerException();
            }
            this.f2644s = true;
            this.f2645t = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata m4529k(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc == null) {
                throw new NullPointerException();
            }
            this.f2646u = true;
            this.f2647v = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata m4530l(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc == null) {
                throw new NullPointerException();
            }
            this.f2648w = true;
            this.f2649x = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata m4531m(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc == null) {
                throw new NullPointerException();
            }
            this.f2650y = true;
            this.f2651z = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata m4532n(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc == null) {
                throw new NullPointerException();
            }
            this.f2600A = true;
            this.f2601B = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata m4533o(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc == null) {
                throw new NullPointerException();
            }
            this.f2602C = true;
            this.f2603D = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata m4534p(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc == null) {
                throw new NullPointerException();
            }
            this.f2604E = true;
            this.f2605F = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata m4500a(String str) {
            this.f2606G = true;
            this.f2607H = str;
            return this;
        }

        public int m4497a() {
            return this.f2609J;
        }

        public PhoneMetadata m4498a(int i) {
            this.f2608I = true;
            this.f2609J = i;
            return this;
        }

        public String m4505b() {
            return this.f2611L;
        }

        public PhoneMetadata m4503b(String str) {
            this.f2610K = true;
            this.f2611L = str;
            return this;
        }

        public PhoneMetadata m4507c(String str) {
            this.f2612M = true;
            this.f2613N = str;
            return this;
        }

        public boolean m4509c() {
            return this.f2614O;
        }

        public PhoneMetadata m4511d(String str) {
            this.f2614O = true;
            this.f2615P = str;
            return this;
        }

        public PhoneMetadata m4515e(String str) {
            this.f2616Q = true;
            this.f2617R = str;
            return this;
        }

        public boolean m4513d() {
            return this.f2618S;
        }

        public String m4516e() {
            return this.f2619T;
        }

        public PhoneMetadata m4518f(String str) {
            this.f2618S = true;
            this.f2619T = str;
            return this;
        }

        public PhoneMetadata m4522g(String str) {
            this.f2620U = true;
            this.f2621V = str;
            return this;
        }

        public PhoneMetadata m4501a(boolean z) {
            this.f2622W = true;
            this.f2623X = z;
            return this;
        }

        public List<NumberFormat> m4519f() {
            return this.f2624Y;
        }

        public int m4520g() {
            return this.f2624Y.size();
        }

        public List<NumberFormat> m4525h() {
            return this.f2625Z;
        }

        public int m4526i() {
            return this.f2625Z.size();
        }

        public PhoneMetadata m4504b(boolean z) {
            this.aa = true;
            this.ab = z;
            return this;
        }

        public PhoneMetadata m4524h(String str) {
            this.ac = true;
            this.ad = str;
            return this;
        }

        public PhoneMetadata m4508c(boolean z) {
            this.ae = true;
            this.af = z;
            return this;
        }

        public PhoneMetadata m4512d(boolean z) {
            this.ag = true;
            this.ah = z;
            return this;
        }

        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            int i;
            int i2 = 0;
            objectOutput.writeBoolean(this.f2626a);
            if (this.f2626a) {
                this.f2627b.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.f2628c);
            if (this.f2628c) {
                this.f2629d.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.f2630e);
            if (this.f2630e) {
                this.f2631f.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.f2632g);
            if (this.f2632g) {
                this.f2633h.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.f2634i);
            if (this.f2634i) {
                this.f2635j.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.f2636k);
            if (this.f2636k) {
                this.f2637l.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.f2638m);
            if (this.f2638m) {
                this.f2639n.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.f2640o);
            if (this.f2640o) {
                this.f2641p.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.f2642q);
            if (this.f2642q) {
                this.f2643r.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.f2644s);
            if (this.f2644s) {
                this.f2645t.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.f2646u);
            if (this.f2646u) {
                this.f2647v.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.f2648w);
            if (this.f2648w) {
                this.f2649x.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.f2650y);
            if (this.f2650y) {
                this.f2651z.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.f2600A);
            if (this.f2600A) {
                this.f2601B.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.f2602C);
            if (this.f2602C) {
                this.f2603D.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.f2604E);
            if (this.f2604E) {
                this.f2605F.writeExternal(objectOutput);
            }
            objectOutput.writeUTF(this.f2607H);
            objectOutput.writeInt(this.f2609J);
            objectOutput.writeUTF(this.f2611L);
            objectOutput.writeBoolean(this.f2612M);
            if (this.f2612M) {
                objectOutput.writeUTF(this.f2613N);
            }
            objectOutput.writeBoolean(this.f2614O);
            if (this.f2614O) {
                objectOutput.writeUTF(this.f2615P);
            }
            objectOutput.writeBoolean(this.f2616Q);
            if (this.f2616Q) {
                objectOutput.writeUTF(this.f2617R);
            }
            objectOutput.writeBoolean(this.f2618S);
            if (this.f2618S) {
                objectOutput.writeUTF(this.f2619T);
            }
            objectOutput.writeBoolean(this.f2620U);
            if (this.f2620U) {
                objectOutput.writeUTF(this.f2621V);
            }
            objectOutput.writeBoolean(this.f2623X);
            int g = m4520g();
            objectOutput.writeInt(g);
            for (i = 0; i < g; i++) {
                ((NumberFormat) this.f2624Y.get(i)).writeExternal(objectOutput);
            }
            i = m4526i();
            objectOutput.writeInt(i);
            while (i2 < i) {
                ((NumberFormat) this.f2625Z.get(i2)).writeExternal(objectOutput);
                i2++;
            }
            objectOutput.writeBoolean(this.ab);
            objectOutput.writeBoolean(this.ac);
            if (this.ac) {
                objectOutput.writeUTF(this.ad);
            }
            objectOutput.writeBoolean(this.af);
            objectOutput.writeBoolean(this.ah);
        }

        public void readExternal(ObjectInput objectInput) throws IOException {
            int i;
            int i2 = 0;
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                m4499a(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                m4502b(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                m4506c(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                m4510d(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                m4514e(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                m4517f(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                m4521g(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                m4523h(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                m4527i(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                m4528j(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                m4529k(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                m4530l(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                m4531m(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                m4532n(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                m4533o(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                m4534p(phoneNumberDesc);
            }
            m4500a(objectInput.readUTF());
            m4498a(objectInput.readInt());
            m4503b(objectInput.readUTF());
            if (objectInput.readBoolean()) {
                m4507c(objectInput.readUTF());
            }
            if (objectInput.readBoolean()) {
                m4511d(objectInput.readUTF());
            }
            if (objectInput.readBoolean()) {
                m4515e(objectInput.readUTF());
            }
            if (objectInput.readBoolean()) {
                m4518f(objectInput.readUTF());
            }
            if (objectInput.readBoolean()) {
                m4522g(objectInput.readUTF());
            }
            m4501a(objectInput.readBoolean());
            int readInt = objectInput.readInt();
            for (i = 0; i < readInt; i++) {
                NumberFormat numberFormat = new NumberFormat();
                numberFormat.readExternal(objectInput);
                this.f2624Y.add(numberFormat);
            }
            i = objectInput.readInt();
            while (i2 < i) {
                NumberFormat numberFormat2 = new NumberFormat();
                numberFormat2.readExternal(objectInput);
                this.f2625Z.add(numberFormat2);
                i2++;
            }
            m4504b(objectInput.readBoolean());
            if (objectInput.readBoolean()) {
                m4524h(objectInput.readUTF());
            }
            m4508c(objectInput.readBoolean());
            m4512d(objectInput.readBoolean());
        }
    }

    public static class PhoneMetadataCollection implements Externalizable {
        private static final long serialVersionUID = 1;
        private List<PhoneMetadata> f2652a;

        public PhoneMetadataCollection() {
            this.f2652a = new ArrayList();
        }

        public List<PhoneMetadata> m4535a() {
            return this.f2652a;
        }

        public int m4536b() {
            return this.f2652a.size();
        }

        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            int b = m4536b();
            objectOutput.writeInt(b);
            for (int i = 0; i < b; i++) {
                ((PhoneMetadata) this.f2652a.get(i)).writeExternal(objectOutput);
            }
        }

        public void readExternal(ObjectInput objectInput) throws IOException {
            int readInt = objectInput.readInt();
            for (int i = 0; i < readInt; i++) {
                PhoneMetadata phoneMetadata = new PhoneMetadata();
                phoneMetadata.readExternal(objectInput);
                this.f2652a.add(phoneMetadata);
            }
        }
    }

    public static class PhoneNumberDesc implements Externalizable {
        private static final long serialVersionUID = 1;
        private boolean f2653a;
        private String f2654b;
        private boolean f2655c;
        private String f2656d;
        private boolean f2657e;
        private String f2658f;

        public PhoneNumberDesc() {
            this.f2654b = BuildConfig.FLAVOR;
            this.f2656d = BuildConfig.FLAVOR;
            this.f2658f = BuildConfig.FLAVOR;
        }

        public PhoneNumberDesc m4537a(String str) {
            this.f2653a = true;
            this.f2654b = str;
            return this;
        }

        public PhoneNumberDesc m4538b(String str) {
            this.f2655c = true;
            this.f2656d = str;
            return this;
        }

        public PhoneNumberDesc m4539c(String str) {
            this.f2657e = true;
            this.f2658f = str;
            return this;
        }

        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeBoolean(this.f2653a);
            if (this.f2653a) {
                objectOutput.writeUTF(this.f2654b);
            }
            objectOutput.writeBoolean(this.f2655c);
            if (this.f2655c) {
                objectOutput.writeUTF(this.f2656d);
            }
            objectOutput.writeBoolean(this.f2657e);
            if (this.f2657e) {
                objectOutput.writeUTF(this.f2658f);
            }
        }

        public void readExternal(ObjectInput objectInput) throws IOException {
            if (objectInput.readBoolean()) {
                m4537a(objectInput.readUTF());
            }
            if (objectInput.readBoolean()) {
                m4538b(objectInput.readUTF());
            }
            if (objectInput.readBoolean()) {
                m4539c(objectInput.readUTF());
            }
        }
    }
}

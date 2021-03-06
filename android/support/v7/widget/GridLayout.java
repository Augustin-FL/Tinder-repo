package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewGroupCompat;
import android.support.v7.gridlayout.C0161R;
import android.util.AttributeSet;
import android.util.LogPrinter;
import android.util.Pair;
import android.util.Printer;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class GridLayout extends ViewGroup {
    private static final int ALIGNMENT_MODE;
    public static final int ALIGN_BOUNDS = 0;
    public static final int ALIGN_MARGINS = 1;
    public static final Alignment BASELINE;
    public static final Alignment BOTTOM;
    private static final int CAN_STRETCH = 2;
    public static final Alignment CENTER;
    private static final int COLUMN_COUNT;
    private static final int COLUMN_ORDER_PRESERVED;
    private static final int DEFAULT_ALIGNMENT_MODE = 1;
    static final int DEFAULT_CONTAINER_MARGIN = 0;
    private static final int DEFAULT_COUNT = Integer.MIN_VALUE;
    private static final boolean DEFAULT_ORDER_PRESERVED = true;
    private static final int DEFAULT_ORIENTATION = 0;
    private static final boolean DEFAULT_USE_DEFAULT_MARGINS = false;
    public static final Alignment END;
    public static final Alignment FILL;
    public static final int HORIZONTAL = 0;
    private static final int INFLEXIBLE = 0;
    private static final Alignment LEADING;
    public static final Alignment LEFT;
    static final Printer LOG_PRINTER;
    static final int MAX_SIZE = 100000;
    static final Printer NO_PRINTER;
    private static final int ORIENTATION;
    public static final Alignment RIGHT;
    private static final int ROW_COUNT;
    private static final int ROW_ORDER_PRESERVED;
    public static final Alignment START;
    public static final Alignment TOP;
    private static final Alignment TRAILING;
    public static final int UNDEFINED = Integer.MIN_VALUE;
    static final Alignment UNDEFINED_ALIGNMENT;
    static final int UNINITIALIZED_HASH = 0;
    private static final int USE_DEFAULT_MARGINS;
    public static final int VERTICAL = 1;
    int mAlignmentMode;
    int mDefaultGap;
    final Axis mHorizontalAxis;
    int mLastLayoutParamsHashCode;
    int mOrientation;
    Printer mPrinter;
    boolean mUseDefaultMargins;
    final Axis mVerticalAxis;

    /* renamed from: android.support.v7.widget.GridLayout.1 */
    static class C02361 implements Printer {
        C02361() {
        }

        public void println(String str) {
        }
    }

    public static abstract class Alignment {
        abstract int getAlignmentValue(View view, int i, int i2);

        abstract String getDebugString();

        abstract int getGravityOffset(View view, int i);

        Alignment() {
        }

        int getSizeInCell(View view, int i, int i2) {
            return i;
        }

        Bounds getBounds() {
            return new Bounds();
        }

        public String toString() {
            return "Alignment:" + getDebugString();
        }
    }

    /* renamed from: android.support.v7.widget.GridLayout.2 */
    static class C02372 extends Alignment {
        C02372() {
        }

        int getGravityOffset(View view, int i) {
            return GridLayout.UNDEFINED;
        }

        public int getAlignmentValue(View view, int i, int i2) {
            return GridLayout.UNDEFINED;
        }

        String getDebugString() {
            return "UNDEFINED";
        }
    }

    /* renamed from: android.support.v7.widget.GridLayout.3 */
    static class C02383 extends Alignment {
        C02383() {
        }

        int getGravityOffset(View view, int i) {
            return GridLayout.USE_DEFAULT_MARGINS;
        }

        public int getAlignmentValue(View view, int i, int i2) {
            return GridLayout.USE_DEFAULT_MARGINS;
        }

        String getDebugString() {
            return "LEADING";
        }
    }

    /* renamed from: android.support.v7.widget.GridLayout.4 */
    static class C02394 extends Alignment {
        C02394() {
        }

        int getGravityOffset(View view, int i) {
            return i;
        }

        public int getAlignmentValue(View view, int i, int i2) {
            return i;
        }

        String getDebugString() {
            return "TRAILING";
        }
    }

    /* renamed from: android.support.v7.widget.GridLayout.5 */
    static class C02405 extends Alignment {
        final /* synthetic */ Alignment val$ltr;
        final /* synthetic */ Alignment val$rtl;

        C02405(Alignment alignment, Alignment alignment2) {
            this.val$ltr = alignment;
            this.val$rtl = alignment2;
        }

        int getGravityOffset(View view, int i) {
            Object obj = GridLayout.VERTICAL;
            if (ViewCompat.getLayoutDirection(view) != GridLayout.VERTICAL) {
                obj = null;
            }
            return (obj == null ? this.val$ltr : this.val$rtl).getGravityOffset(view, i);
        }

        public int getAlignmentValue(View view, int i, int i2) {
            Object obj = GridLayout.VERTICAL;
            if (ViewCompat.getLayoutDirection(view) != GridLayout.VERTICAL) {
                obj = null;
            }
            return (obj == null ? this.val$ltr : this.val$rtl).getAlignmentValue(view, i, i2);
        }

        String getDebugString() {
            return "SWITCHING[L:" + this.val$ltr.getDebugString() + ", R:" + this.val$rtl.getDebugString() + "]";
        }
    }

    /* renamed from: android.support.v7.widget.GridLayout.6 */
    static class C02416 extends Alignment {
        C02416() {
        }

        int getGravityOffset(View view, int i) {
            return i >> GridLayout.VERTICAL;
        }

        public int getAlignmentValue(View view, int i, int i2) {
            return i >> GridLayout.VERTICAL;
        }

        String getDebugString() {
            return "CENTER";
        }
    }

    static class Bounds {
        public int after;
        public int before;
        public int flexibility;

        private Bounds() {
            reset();
        }

        protected void reset() {
            this.before = GridLayout.UNDEFINED;
            this.after = GridLayout.UNDEFINED;
            this.flexibility = GridLayout.CAN_STRETCH;
        }

        protected void include(int i, int i2) {
            this.before = Math.max(this.before, i);
            this.after = Math.max(this.after, i2);
        }

        protected int size(boolean z) {
            if (z || !GridLayout.canStretch(this.flexibility)) {
                return this.before + this.after;
            }
            return GridLayout.MAX_SIZE;
        }

        protected int getOffset(GridLayout gridLayout, View view, Alignment alignment, int i, boolean z) {
            return this.before - alignment.getAlignmentValue(view, i, ViewGroupCompat.getLayoutMode(gridLayout));
        }

        protected final void include(GridLayout gridLayout, View view, Spec spec, Axis axis, int i) {
            this.flexibility &= spec.getFlexibility();
            int alignmentValue = spec.getAbsoluteAlignment(axis.horizontal).getAlignmentValue(view, i, ViewGroupCompat.getLayoutMode(gridLayout));
            include(alignmentValue, i - alignmentValue);
        }

        public String toString() {
            return "Bounds{before=" + this.before + ", after=" + this.after + '}';
        }
    }

    /* renamed from: android.support.v7.widget.GridLayout.7 */
    static class C02437 extends Alignment {

        /* renamed from: android.support.v7.widget.GridLayout.7.1 */
        class C02421 extends Bounds {
            private int size;

            C02421() {
                super();
            }

            protected void reset() {
                super.reset();
                this.size = GridLayout.UNDEFINED;
            }

            protected void include(int i, int i2) {
                super.include(i, i2);
                this.size = Math.max(this.size, i + i2);
            }

            protected int size(boolean z) {
                return Math.max(super.size(z), this.size);
            }

            protected int getOffset(GridLayout gridLayout, View view, Alignment alignment, int i, boolean z) {
                return Math.max(GridLayout.USE_DEFAULT_MARGINS, super.getOffset(gridLayout, view, alignment, i, z));
            }
        }

        C02437() {
        }

        int getGravityOffset(View view, int i) {
            return GridLayout.USE_DEFAULT_MARGINS;
        }

        public int getAlignmentValue(View view, int i, int i2) {
            if (view.getVisibility() == 8) {
                return GridLayout.USE_DEFAULT_MARGINS;
            }
            int baseline = view.getBaseline();
            return baseline == -1 ? GridLayout.UNDEFINED : baseline;
        }

        public Bounds getBounds() {
            return new C02421();
        }

        String getDebugString() {
            return "BASELINE";
        }
    }

    /* renamed from: android.support.v7.widget.GridLayout.8 */
    static class C02448 extends Alignment {
        C02448() {
        }

        int getGravityOffset(View view, int i) {
            return GridLayout.USE_DEFAULT_MARGINS;
        }

        public int getAlignmentValue(View view, int i, int i2) {
            return GridLayout.UNDEFINED;
        }

        public int getSizeInCell(View view, int i, int i2) {
            return i2;
        }

        String getDebugString() {
            return "FILL";
        }
    }

    static final class Arc {
        public final Interval span;
        public boolean valid;
        public final MutableInt value;

        public Arc(Interval interval, MutableInt mutableInt) {
            this.valid = GridLayout.DEFAULT_ORDER_PRESERVED;
            this.span = interval;
            this.value = mutableInt;
        }

        public String toString() {
            return this.span + " " + (!this.valid ? "+>" : "->") + " " + this.value;
        }
    }

    static final class Assoc<K, V> extends ArrayList<Pair<K, V>> {
        private final Class<K> keyType;
        private final Class<V> valueType;

        private Assoc(Class<K> cls, Class<V> cls2) {
            this.keyType = cls;
            this.valueType = cls2;
        }

        public static <K, V> Assoc<K, V> of(Class<K> cls, Class<V> cls2) {
            return new Assoc(cls, cls2);
        }

        public void put(K k, V v) {
            add(Pair.create(k, v));
        }

        public PackedMap<K, V> pack() {
            int size = size();
            Object[] objArr = (Object[]) Array.newInstance(this.keyType, size);
            Object[] objArr2 = (Object[]) Array.newInstance(this.valueType, size);
            for (int i = GridLayout.USE_DEFAULT_MARGINS; i < size; i += GridLayout.VERTICAL) {
                objArr[i] = ((Pair) get(i)).first;
                objArr2[i] = ((Pair) get(i)).second;
            }
            return new PackedMap(objArr2, null);
        }
    }

    final class Axis {
        static final /* synthetic */ boolean $assertionsDisabled;
        private static final int COMPLETE = 2;
        private static final int NEW = 0;
        private static final int PENDING = 1;
        public Arc[] arcs;
        public boolean arcsValid;
        PackedMap<Interval, MutableInt> backwardLinks;
        public boolean backwardLinksValid;
        public int definedCount;
        public int[] deltas;
        PackedMap<Interval, MutableInt> forwardLinks;
        public boolean forwardLinksValid;
        PackedMap<Spec, Bounds> groupBounds;
        public boolean groupBoundsValid;
        public boolean hasWeights;
        public boolean hasWeightsValid;
        public final boolean horizontal;
        public int[] leadingMargins;
        public boolean leadingMarginsValid;
        public int[] locations;
        public boolean locationsValid;
        private int maxIndex;
        boolean orderPreserved;
        private MutableInt parentMax;
        private MutableInt parentMin;
        public int[] trailingMargins;
        public boolean trailingMarginsValid;

        /* renamed from: android.support.v7.widget.GridLayout.Axis.1 */
        class C02451 {
            static final /* synthetic */ boolean $assertionsDisabled;
            Arc[][] arcsByVertex;
            int cursor;
            Arc[] result;
            final /* synthetic */ Arc[] val$arcs;
            int[] visited;

            static {
                $assertionsDisabled = !GridLayout.class.desiredAssertionStatus() ? GridLayout.DEFAULT_ORDER_PRESERVED : Axis.$assertionsDisabled;
            }

            C02451(Arc[] arcArr) {
                this.val$arcs = arcArr;
                this.result = new Arc[this.val$arcs.length];
                this.cursor = this.result.length - 1;
                this.arcsByVertex = Axis.this.groupArcsByFirstVertex(this.val$arcs);
                this.visited = new int[(Axis.this.getCount() + Axis.PENDING)];
            }

            void walk(int i) {
                switch (this.visited[i]) {
                    case Axis.NEW /*0*/:
                        this.visited[i] = Axis.PENDING;
                        Arc[] arcArr = this.arcsByVertex[i];
                        int length = arcArr.length;
                        for (int i2 = Axis.NEW; i2 < length; i2 += Axis.PENDING) {
                            Arc arc = arcArr[i2];
                            walk(arc.span.max);
                            Arc[] arcArr2 = this.result;
                            int i3 = this.cursor;
                            this.cursor = i3 - 1;
                            arcArr2[i3] = arc;
                        }
                        this.visited[i] = Axis.COMPLETE;
                    case Axis.PENDING /*1*/:
                        if (!$assertionsDisabled) {
                            throw new AssertionError();
                        }
                    default:
                }
            }

            Arc[] sort() {
                int length = this.arcsByVertex.length;
                for (int i = Axis.NEW; i < length; i += Axis.PENDING) {
                    walk(i);
                }
                if ($assertionsDisabled || this.cursor == -1) {
                    return this.result;
                }
                throw new AssertionError();
            }
        }

        static {
            $assertionsDisabled = !GridLayout.class.desiredAssertionStatus() ? GridLayout.DEFAULT_ORDER_PRESERVED : $assertionsDisabled;
        }

        private Axis(boolean z) {
            this.definedCount = GridLayout.UNDEFINED;
            this.maxIndex = GridLayout.UNDEFINED;
            this.groupBoundsValid = $assertionsDisabled;
            this.forwardLinksValid = $assertionsDisabled;
            this.backwardLinksValid = $assertionsDisabled;
            this.leadingMarginsValid = $assertionsDisabled;
            this.trailingMarginsValid = $assertionsDisabled;
            this.arcsValid = $assertionsDisabled;
            this.locationsValid = $assertionsDisabled;
            this.hasWeightsValid = $assertionsDisabled;
            this.orderPreserved = GridLayout.DEFAULT_ORDER_PRESERVED;
            this.parentMin = new MutableInt(NEW);
            this.parentMax = new MutableInt(-100000);
            this.horizontal = z;
        }

        private int calculateMaxIndex() {
            int childCount = GridLayout.this.getChildCount();
            int i = -1;
            for (int i2 = NEW; i2 < childCount; i2 += PENDING) {
                LayoutParams layoutParams = GridLayout.this.getLayoutParams(GridLayout.this.getChildAt(i2));
                Interval interval = (this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec).span;
                i = Math.max(Math.max(Math.max(i, interval.min), interval.max), interval.size());
            }
            return i == -1 ? GridLayout.UNDEFINED : i;
        }

        private int getMaxIndex() {
            if (this.maxIndex == GridLayout.UNDEFINED) {
                this.maxIndex = Math.max(NEW, calculateMaxIndex());
            }
            return this.maxIndex;
        }

        public int getCount() {
            return Math.max(this.definedCount, getMaxIndex());
        }

        public void setCount(int i) {
            if (i != GridLayout.UNDEFINED && i < getMaxIndex()) {
                GridLayout.handleInvalidParams((this.horizontal ? "column" : "row") + "Count must be greater than or equal to the maximum of all grid indices " + "(and spans) defined in the LayoutParams of each child");
            }
            this.definedCount = i;
        }

        public boolean isOrderPreserved() {
            return this.orderPreserved;
        }

        public void setOrderPreserved(boolean z) {
            this.orderPreserved = z;
            invalidateStructure();
        }

        private PackedMap<Spec, Bounds> createGroupBounds() {
            Assoc of = Assoc.of(Spec.class, Bounds.class);
            int childCount = GridLayout.this.getChildCount();
            for (int i = NEW; i < childCount; i += PENDING) {
                LayoutParams layoutParams = GridLayout.this.getLayoutParams(GridLayout.this.getChildAt(i));
                Spec spec = this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec;
                of.put(spec, spec.getAbsoluteAlignment(this.horizontal).getBounds());
            }
            return of.pack();
        }

        private void computeGroupBounds() {
            Bounds[] boundsArr = (Bounds[]) this.groupBounds.values;
            for (int i = NEW; i < boundsArr.length; i += PENDING) {
                boundsArr[i].reset();
            }
            int childCount = GridLayout.this.getChildCount();
            int i2 = NEW;
            while (i2 < childCount) {
                View childAt = GridLayout.this.getChildAt(i2);
                LayoutParams layoutParams = GridLayout.this.getLayoutParams(childAt);
                Spec spec = this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec;
                ((Bounds) this.groupBounds.getValue(i2)).include(GridLayout.this, childAt, spec, this, GridLayout.this.getMeasurementIncludingMargin(childAt, this.horizontal) + (spec.weight == 0.0f ? NEW : getDeltas()[i2]));
                i2 += PENDING;
            }
        }

        public PackedMap<Spec, Bounds> getGroupBounds() {
            if (this.groupBounds == null) {
                this.groupBounds = createGroupBounds();
            }
            if (!this.groupBoundsValid) {
                computeGroupBounds();
                this.groupBoundsValid = GridLayout.DEFAULT_ORDER_PRESERVED;
            }
            return this.groupBounds;
        }

        private PackedMap<Interval, MutableInt> createLinks(boolean z) {
            Assoc of = Assoc.of(Interval.class, MutableInt.class);
            Spec[] specArr = (Spec[]) getGroupBounds().keys;
            int length = specArr.length;
            for (int i = NEW; i < length; i += PENDING) {
                of.put(z ? specArr[i].span : specArr[i].span.inverse(), new MutableInt());
            }
            return of.pack();
        }

        private void computeLinks(PackedMap<Interval, MutableInt> packedMap, boolean z) {
            int i = NEW;
            MutableInt[] mutableIntArr = (MutableInt[]) packedMap.values;
            for (int i2 = NEW; i2 < mutableIntArr.length; i2 += PENDING) {
                mutableIntArr[i2].reset();
            }
            Bounds[] boundsArr = (Bounds[]) getGroupBounds().values;
            while (i < boundsArr.length) {
                int size = boundsArr[i].size(z);
                MutableInt mutableInt = (MutableInt) packedMap.getValue(i);
                int i3 = mutableInt.value;
                if (!z) {
                    size = -size;
                }
                mutableInt.value = Math.max(i3, size);
                i += PENDING;
            }
        }

        private PackedMap<Interval, MutableInt> getForwardLinks() {
            if (this.forwardLinks == null) {
                this.forwardLinks = createLinks(GridLayout.DEFAULT_ORDER_PRESERVED);
            }
            if (!this.forwardLinksValid) {
                computeLinks(this.forwardLinks, GridLayout.DEFAULT_ORDER_PRESERVED);
                this.forwardLinksValid = GridLayout.DEFAULT_ORDER_PRESERVED;
            }
            return this.forwardLinks;
        }

        private PackedMap<Interval, MutableInt> getBackwardLinks() {
            if (this.backwardLinks == null) {
                this.backwardLinks = createLinks($assertionsDisabled);
            }
            if (!this.backwardLinksValid) {
                computeLinks(this.backwardLinks, $assertionsDisabled);
                this.backwardLinksValid = GridLayout.DEFAULT_ORDER_PRESERVED;
            }
            return this.backwardLinks;
        }

        private void include(List<Arc> list, Interval interval, MutableInt mutableInt, boolean z) {
            if (interval.size() != 0) {
                if (z) {
                    for (Arc arc : list) {
                        if (arc.span.equals(interval)) {
                            return;
                        }
                    }
                }
                list.add(new Arc(interval, mutableInt));
            }
        }

        private void include(List<Arc> list, Interval interval, MutableInt mutableInt) {
            include(list, interval, mutableInt, GridLayout.DEFAULT_ORDER_PRESERVED);
        }

        Arc[][] groupArcsByFirstVertex(Arc[] arcArr) {
            int i = NEW;
            int count = getCount() + PENDING;
            Arc[][] arcArr2 = new Arc[count][];
            int[] iArr = new int[count];
            int length = arcArr.length;
            for (count = NEW; count < length; count += PENDING) {
                int i2 = arcArr[count].span.min;
                iArr[i2] = iArr[i2] + PENDING;
            }
            for (count = NEW; count < iArr.length; count += PENDING) {
                arcArr2[count] = new Arc[iArr[count]];
            }
            Arrays.fill(iArr, NEW);
            count = arcArr.length;
            while (i < count) {
                Arc arc = arcArr[i];
                i2 = arc.span.min;
                Arc[] arcArr3 = arcArr2[i2];
                int i3 = iArr[i2];
                iArr[i2] = i3 + PENDING;
                arcArr3[i3] = arc;
                i += PENDING;
            }
            return arcArr2;
        }

        private Arc[] topologicalSort(Arc[] arcArr) {
            return new C02451(arcArr).sort();
        }

        private Arc[] topologicalSort(List<Arc> list) {
            return topologicalSort((Arc[]) list.toArray(new Arc[list.size()]));
        }

        private void addComponentSizes(List<Arc> list, PackedMap<Interval, MutableInt> packedMap) {
            for (int i = NEW; i < ((Interval[]) packedMap.keys).length; i += PENDING) {
                include(list, ((Interval[]) packedMap.keys)[i], ((MutableInt[]) packedMap.values)[i], $assertionsDisabled);
            }
        }

        private Arc[] createArcs() {
            int i;
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            addComponentSizes(arrayList, getForwardLinks());
            addComponentSizes(arrayList2, getBackwardLinks());
            if (this.orderPreserved) {
                for (i = NEW; i < getCount(); i += PENDING) {
                    include(arrayList, new Interval(i, i + PENDING), new MutableInt(NEW));
                }
            }
            i = getCount();
            include(arrayList, new Interval(NEW, i), this.parentMin, $assertionsDisabled);
            include(arrayList2, new Interval(i, NEW), this.parentMax, $assertionsDisabled);
            return (Arc[]) GridLayout.append(topologicalSort(arrayList), topologicalSort(arrayList2));
        }

        private void computeArcs() {
            getForwardLinks();
            getBackwardLinks();
        }

        public Arc[] getArcs() {
            if (this.arcs == null) {
                this.arcs = createArcs();
            }
            if (!this.arcsValid) {
                computeArcs();
                this.arcsValid = GridLayout.DEFAULT_ORDER_PRESERVED;
            }
            return this.arcs;
        }

        private boolean relax(int[] iArr, Arc arc) {
            if (!arc.valid) {
                return $assertionsDisabled;
            }
            Interval interval = arc.span;
            int i = interval.min;
            int i2 = interval.max;
            i = iArr[i] + arc.value.value;
            if (i <= iArr[i2]) {
                return $assertionsDisabled;
            }
            iArr[i2] = i;
            return GridLayout.DEFAULT_ORDER_PRESERVED;
        }

        private void init(int[] iArr) {
            Arrays.fill(iArr, NEW);
        }

        private String arcsToString(List<Arc> list) {
            String str = this.horizontal ? "x" : "y";
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder stringBuilder2 = stringBuilder;
            Object obj = PENDING;
            for (Arc arc : list) {
                String str2;
                if (obj != null) {
                    obj = null;
                } else {
                    stringBuilder2 = stringBuilder2.append(", ");
                }
                int i = arc.span.min;
                int i2 = arc.span.max;
                int i3 = arc.value.value;
                if (i < i2) {
                    str2 = str + i2 + "-" + str + i + ">=" + i3;
                } else {
                    str2 = str + i + "-" + str + i2 + "<=" + (-i3);
                }
                stringBuilder2.append(str2);
            }
            return stringBuilder2.toString();
        }

        private void logError(String str, Arc[] arcArr, boolean[] zArr) {
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            for (int i = NEW; i < arcArr.length; i += PENDING) {
                Arc arc = arcArr[i];
                if (zArr[i]) {
                    arrayList.add(arc);
                }
                if (!arc.valid) {
                    arrayList2.add(arc);
                }
            }
            GridLayout.this.mPrinter.println(str + " constraints: " + arcsToString(arrayList) + " are inconsistent; permanently removing: " + arcsToString(arrayList2) + ". ");
        }

        private boolean solve(Arc[] arcArr, int[] iArr) {
            return solve(arcArr, iArr, GridLayout.DEFAULT_ORDER_PRESERVED);
        }

        private boolean solve(Arc[] arcArr, int[] iArr, boolean z) {
            String str = this.horizontal ? "horizontal" : "vertical";
            int count = getCount() + PENDING;
            boolean[] zArr = null;
            for (int i = NEW; i < arcArr.length; i += PENDING) {
                int i2;
                init(iArr);
                for (i2 = NEW; i2 < count; i2 += PENDING) {
                    int i3 = NEW;
                    for (int i4 = NEW; i4 < arcArr.length; i4 += PENDING) {
                        i3 |= relax(iArr, arcArr[i4]);
                    }
                    if (i3 == 0) {
                        if (zArr != null) {
                            logError(str, arcArr, zArr);
                        }
                        return GridLayout.DEFAULT_ORDER_PRESERVED;
                    }
                }
                if (!z) {
                    return $assertionsDisabled;
                }
                boolean[] zArr2 = new boolean[arcArr.length];
                for (i2 = NEW; i2 < count; i2 += PENDING) {
                    int length = arcArr.length;
                    for (i3 = NEW; i3 < length; i3 += PENDING) {
                        zArr2[i3] = zArr2[i3] | relax(iArr, arcArr[i3]);
                    }
                }
                if (i == 0) {
                    zArr = zArr2;
                }
                for (i3 = NEW; i3 < arcArr.length; i3 += PENDING) {
                    if (zArr2[i3]) {
                        Arc arc = arcArr[i3];
                        if (arc.span.min >= arc.span.max) {
                            arc.valid = $assertionsDisabled;
                            break;
                        }
                    }
                }
            }
            return GridLayout.DEFAULT_ORDER_PRESERVED;
        }

        private void computeMargins(boolean z) {
            int[] iArr = z ? this.leadingMargins : this.trailingMargins;
            int childCount = GridLayout.this.getChildCount();
            for (int i = NEW; i < childCount; i += PENDING) {
                View childAt = GridLayout.this.getChildAt(i);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = GridLayout.this.getLayoutParams(childAt);
                    Interval interval = (this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec).span;
                    int i2 = z ? interval.min : interval.max;
                    iArr[i2] = Math.max(iArr[i2], GridLayout.this.getMargin1(childAt, this.horizontal, z));
                }
            }
        }

        public int[] getLeadingMargins() {
            if (this.leadingMargins == null) {
                this.leadingMargins = new int[(getCount() + PENDING)];
            }
            if (!this.leadingMarginsValid) {
                computeMargins(GridLayout.DEFAULT_ORDER_PRESERVED);
                this.leadingMarginsValid = GridLayout.DEFAULT_ORDER_PRESERVED;
            }
            return this.leadingMargins;
        }

        public int[] getTrailingMargins() {
            if (this.trailingMargins == null) {
                this.trailingMargins = new int[(getCount() + PENDING)];
            }
            if (!this.trailingMarginsValid) {
                computeMargins($assertionsDisabled);
                this.trailingMarginsValid = GridLayout.DEFAULT_ORDER_PRESERVED;
            }
            return this.trailingMargins;
        }

        private boolean solve(int[] iArr) {
            return solve(getArcs(), iArr);
        }

        private boolean computeHasWeights() {
            int childCount = GridLayout.this.getChildCount();
            for (int i = NEW; i < childCount; i += PENDING) {
                View childAt = GridLayout.this.getChildAt(i);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = GridLayout.this.getLayoutParams(childAt);
                    if ((this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec).weight != 0.0f) {
                        return GridLayout.DEFAULT_ORDER_PRESERVED;
                    }
                }
            }
            return $assertionsDisabled;
        }

        private boolean hasWeights() {
            if (!this.hasWeightsValid) {
                this.hasWeights = computeHasWeights();
                this.hasWeightsValid = GridLayout.DEFAULT_ORDER_PRESERVED;
            }
            return this.hasWeights;
        }

        public int[] getDeltas() {
            if (this.deltas == null) {
                this.deltas = new int[GridLayout.this.getChildCount()];
            }
            return this.deltas;
        }

        private void shareOutDelta(int i, float f) {
            Arrays.fill(this.deltas, NEW);
            int childCount = GridLayout.this.getChildCount();
            int i2 = NEW;
            float f2 = f;
            int i3 = i;
            while (i2 < childCount) {
                float f3;
                int i4;
                View childAt = GridLayout.this.getChildAt(i2);
                if (childAt.getVisibility() == 8) {
                    f3 = f2;
                    i4 = i3;
                } else {
                    LayoutParams layoutParams = GridLayout.this.getLayoutParams(childAt);
                    f3 = (this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec).weight;
                    if (f3 != 0.0f) {
                        int round = Math.round((((float) i3) * f3) / f2);
                        this.deltas[i2] = round;
                        f3 = f2 - f3;
                        i4 = i3 - round;
                    } else {
                        f3 = f2;
                        i4 = i3;
                    }
                }
                i2 += PENDING;
                i3 = i4;
                f2 = f3;
            }
        }

        private void solveAndDistributeSpace(int[] iArr) {
            Arrays.fill(getDeltas(), NEW);
            solve(iArr);
            int childCount = (this.parentMin.value * GridLayout.this.getChildCount()) + PENDING;
            if (childCount >= COMPLETE) {
                float calculateTotalWeight = calculateTotalWeight();
                int i = -1;
                boolean z = GridLayout.DEFAULT_ORDER_PRESERVED;
                int i2 = NEW;
                while (i2 < childCount) {
                    int i3 = (i2 + childCount) / COMPLETE;
                    invalidateValues();
                    shareOutDelta(i3, calculateTotalWeight);
                    boolean solve = solve(getArcs(), iArr, $assertionsDisabled);
                    if (solve) {
                        i = i3 + PENDING;
                        i2 = childCount;
                    } else {
                        int i4 = i;
                        i = i2;
                        i2 = i3;
                        i3 = i4;
                    }
                    childCount = i2;
                    i2 = i;
                    i = i3;
                    z = solve;
                }
                if (i > 0 && !r0) {
                    invalidateValues();
                    shareOutDelta(i, calculateTotalWeight);
                    solve(iArr);
                }
            }
        }

        private float calculateTotalWeight() {
            float f = 0.0f;
            int childCount = GridLayout.this.getChildCount();
            int i = NEW;
            while (i < childCount) {
                float f2;
                View childAt = GridLayout.this.getChildAt(i);
                if (childAt.getVisibility() == 8) {
                    f2 = f;
                } else {
                    LayoutParams layoutParams = GridLayout.this.getLayoutParams(childAt);
                    f2 = (this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec).weight + f;
                }
                i += PENDING;
                f = f2;
            }
            return f;
        }

        private void computeLocations(int[] iArr) {
            int i = NEW;
            if (hasWeights()) {
                solveAndDistributeSpace(iArr);
            } else {
                solve(iArr);
            }
            if (!this.orderPreserved) {
                int i2 = iArr[NEW];
                int length = iArr.length;
                while (i < length) {
                    iArr[i] = iArr[i] - i2;
                    i += PENDING;
                }
            }
        }

        public int[] getLocations() {
            if (this.locations == null) {
                this.locations = new int[(getCount() + PENDING)];
            }
            if (!this.locationsValid) {
                computeLocations(this.locations);
                this.locationsValid = GridLayout.DEFAULT_ORDER_PRESERVED;
            }
            return this.locations;
        }

        private int size(int[] iArr) {
            return iArr[getCount()];
        }

        private void setParentConstraints(int i, int i2) {
            this.parentMin.value = i;
            this.parentMax.value = -i2;
            this.locationsValid = $assertionsDisabled;
        }

        private int getMeasure(int i, int i2) {
            setParentConstraints(i, i2);
            return size(getLocations());
        }

        public int getMeasure(int i) {
            int mode = MeasureSpec.getMode(i);
            int size = MeasureSpec.getSize(i);
            switch (mode) {
                case GridLayout.UNDEFINED /*-2147483648*/:
                    return getMeasure(NEW, size);
                case NEW /*0*/:
                    return getMeasure(NEW, GridLayout.MAX_SIZE);
                case 1073741824:
                    return getMeasure(size, size);
                default:
                    if ($assertionsDisabled) {
                        return NEW;
                    }
                    throw new AssertionError();
            }
        }

        public void layout(int i) {
            setParentConstraints(i, i);
            getLocations();
        }

        public void invalidateStructure() {
            this.maxIndex = GridLayout.UNDEFINED;
            this.groupBounds = null;
            this.forwardLinks = null;
            this.backwardLinks = null;
            this.leadingMargins = null;
            this.trailingMargins = null;
            this.arcs = null;
            this.locations = null;
            this.deltas = null;
            this.hasWeightsValid = $assertionsDisabled;
            invalidateValues();
        }

        public void invalidateValues() {
            this.groupBoundsValid = $assertionsDisabled;
            this.forwardLinksValid = $assertionsDisabled;
            this.backwardLinksValid = $assertionsDisabled;
            this.leadingMarginsValid = $assertionsDisabled;
            this.trailingMarginsValid = $assertionsDisabled;
            this.arcsValid = $assertionsDisabled;
            this.locationsValid = $assertionsDisabled;
        }
    }

    static final class Interval {
        public final int max;
        public final int min;

        public Interval(int i, int i2) {
            this.min = i;
            this.max = i2;
        }

        int size() {
            return this.max - this.min;
        }

        Interval inverse() {
            return new Interval(this.max, this.min);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return GridLayout.DEFAULT_ORDER_PRESERVED;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return GridLayout.DEFAULT_USE_DEFAULT_MARGINS;
            }
            Interval interval = (Interval) obj;
            if (this.max != interval.max) {
                return GridLayout.DEFAULT_USE_DEFAULT_MARGINS;
            }
            if (this.min != interval.min) {
                return GridLayout.DEFAULT_USE_DEFAULT_MARGINS;
            }
            return GridLayout.DEFAULT_ORDER_PRESERVED;
        }

        public int hashCode() {
            return (this.min * 31) + this.max;
        }

        public String toString() {
            return "[" + this.min + ", " + this.max + "]";
        }
    }

    public static class LayoutParams extends MarginLayoutParams {
        private static final int BOTTOM_MARGIN;
        private static final int COLUMN;
        private static final int COLUMN_SPAN;
        private static final int COLUMN_WEIGHT;
        private static final int DEFAULT_COLUMN = Integer.MIN_VALUE;
        private static final int DEFAULT_HEIGHT = -2;
        private static final int DEFAULT_MARGIN = Integer.MIN_VALUE;
        private static final int DEFAULT_ROW = Integer.MIN_VALUE;
        private static final Interval DEFAULT_SPAN;
        private static final int DEFAULT_SPAN_SIZE;
        private static final int DEFAULT_WIDTH = -2;
        private static final int GRAVITY;
        private static final int LEFT_MARGIN;
        private static final int MARGIN;
        private static final int RIGHT_MARGIN;
        private static final int ROW;
        private static final int ROW_SPAN;
        private static final int ROW_WEIGHT;
        private static final int TOP_MARGIN;
        public Spec columnSpec;
        public Spec rowSpec;

        static {
            DEFAULT_SPAN = new Interval(DEFAULT_ROW, -2147483647);
            DEFAULT_SPAN_SIZE = DEFAULT_SPAN.size();
            MARGIN = C0161R.styleable.GridLayout_Layout_android_layout_margin;
            LEFT_MARGIN = C0161R.styleable.GridLayout_Layout_android_layout_marginLeft;
            TOP_MARGIN = C0161R.styleable.GridLayout_Layout_android_layout_marginTop;
            RIGHT_MARGIN = C0161R.styleable.GridLayout_Layout_android_layout_marginRight;
            BOTTOM_MARGIN = C0161R.styleable.GridLayout_Layout_android_layout_marginBottom;
            COLUMN = C0161R.styleable.GridLayout_Layout_layout_column;
            COLUMN_SPAN = C0161R.styleable.GridLayout_Layout_layout_columnSpan;
            COLUMN_WEIGHT = C0161R.styleable.GridLayout_Layout_layout_columnWeight;
            ROW = C0161R.styleable.GridLayout_Layout_layout_row;
            ROW_SPAN = C0161R.styleable.GridLayout_Layout_layout_rowSpan;
            ROW_WEIGHT = C0161R.styleable.GridLayout_Layout_layout_rowWeight;
            GRAVITY = C0161R.styleable.GridLayout_Layout_layout_gravity;
        }

        private LayoutParams(int i, int i2, int i3, int i4, int i5, int i6, Spec spec, Spec spec2) {
            super(i, i2);
            this.rowSpec = Spec.UNDEFINED;
            this.columnSpec = Spec.UNDEFINED;
            setMargins(i3, i4, i5, i6);
            this.rowSpec = spec;
            this.columnSpec = spec2;
        }

        public LayoutParams(Spec spec, Spec spec2) {
            this(DEFAULT_WIDTH, DEFAULT_WIDTH, DEFAULT_ROW, DEFAULT_ROW, DEFAULT_ROW, DEFAULT_ROW, spec, spec2);
        }

        public LayoutParams() {
            this(Spec.UNDEFINED, Spec.UNDEFINED);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.rowSpec = Spec.UNDEFINED;
            this.columnSpec = Spec.UNDEFINED;
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.rowSpec = Spec.UNDEFINED;
            this.columnSpec = Spec.UNDEFINED;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.rowSpec = Spec.UNDEFINED;
            this.columnSpec = Spec.UNDEFINED;
            this.rowSpec = layoutParams.rowSpec;
            this.columnSpec = layoutParams.columnSpec;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.rowSpec = Spec.UNDEFINED;
            this.columnSpec = Spec.UNDEFINED;
            reInitSuper(context, attributeSet);
            init(context, attributeSet);
        }

        private void reInitSuper(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0161R.styleable.GridLayout_Layout);
            try {
                int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(MARGIN, DEFAULT_ROW);
                this.leftMargin = obtainStyledAttributes.getDimensionPixelSize(LEFT_MARGIN, dimensionPixelSize);
                this.topMargin = obtainStyledAttributes.getDimensionPixelSize(TOP_MARGIN, dimensionPixelSize);
                this.rightMargin = obtainStyledAttributes.getDimensionPixelSize(RIGHT_MARGIN, dimensionPixelSize);
                this.bottomMargin = obtainStyledAttributes.getDimensionPixelSize(BOTTOM_MARGIN, dimensionPixelSize);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }

        private void init(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0161R.styleable.GridLayout_Layout);
            try {
                int i = obtainStyledAttributes.getInt(GRAVITY, DEFAULT_SPAN_SIZE);
                this.columnSpec = GridLayout.spec(obtainStyledAttributes.getInt(COLUMN, DEFAULT_ROW), obtainStyledAttributes.getInt(COLUMN_SPAN, DEFAULT_SPAN_SIZE), GridLayout.getAlignment(i, GridLayout.DEFAULT_ORDER_PRESERVED), obtainStyledAttributes.getFloat(COLUMN_WEIGHT, 0.0f));
                this.rowSpec = GridLayout.spec(obtainStyledAttributes.getInt(ROW, DEFAULT_ROW), obtainStyledAttributes.getInt(ROW_SPAN, DEFAULT_SPAN_SIZE), GridLayout.getAlignment(i, GridLayout.DEFAULT_USE_DEFAULT_MARGINS), obtainStyledAttributes.getFloat(ROW_WEIGHT, 0.0f));
            } finally {
                obtainStyledAttributes.recycle();
            }
        }

        public void setGravity(int i) {
            this.rowSpec = this.rowSpec.copyWriteAlignment(GridLayout.getAlignment(i, GridLayout.DEFAULT_USE_DEFAULT_MARGINS));
            this.columnSpec = this.columnSpec.copyWriteAlignment(GridLayout.getAlignment(i, GridLayout.DEFAULT_ORDER_PRESERVED));
        }

        protected void setBaseAttributes(TypedArray typedArray, int i, int i2) {
            this.width = typedArray.getLayoutDimension(i, DEFAULT_WIDTH);
            this.height = typedArray.getLayoutDimension(i2, DEFAULT_WIDTH);
        }

        final void setRowSpecSpan(Interval interval) {
            this.rowSpec = this.rowSpec.copyWriteSpan(interval);
        }

        final void setColumnSpecSpan(Interval interval) {
            this.columnSpec = this.columnSpec.copyWriteSpan(interval);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return GridLayout.DEFAULT_ORDER_PRESERVED;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return GridLayout.DEFAULT_USE_DEFAULT_MARGINS;
            }
            LayoutParams layoutParams = (LayoutParams) obj;
            if (!this.columnSpec.equals(layoutParams.columnSpec)) {
                return GridLayout.DEFAULT_USE_DEFAULT_MARGINS;
            }
            if (this.rowSpec.equals(layoutParams.rowSpec)) {
                return GridLayout.DEFAULT_ORDER_PRESERVED;
            }
            return GridLayout.DEFAULT_USE_DEFAULT_MARGINS;
        }

        public int hashCode() {
            return (this.rowSpec.hashCode() * 31) + this.columnSpec.hashCode();
        }
    }

    static final class MutableInt {
        public int value;

        public MutableInt() {
            reset();
        }

        public MutableInt(int i) {
            this.value = i;
        }

        public void reset() {
            this.value = GridLayout.UNDEFINED;
        }

        public String toString() {
            return Integer.toString(this.value);
        }
    }

    static final class PackedMap<K, V> {
        public final int[] index;
        public final K[] keys;
        public final V[] values;

        private PackedMap(K[] kArr, V[] vArr) {
            this.index = createIndex(kArr);
            this.keys = compact(kArr, this.index);
            this.values = compact(vArr, this.index);
        }

        public V getValue(int i) {
            return this.values[this.index[i]];
        }

        private static <K> int[] createIndex(K[] kArr) {
            int length = kArr.length;
            int[] iArr = new int[length];
            Map hashMap = new HashMap();
            for (int i = GridLayout.USE_DEFAULT_MARGINS; i < length; i += GridLayout.VERTICAL) {
                Object obj = kArr[i];
                Integer num = (Integer) hashMap.get(obj);
                if (num == null) {
                    num = Integer.valueOf(hashMap.size());
                    hashMap.put(obj, num);
                }
                iArr[i] = num.intValue();
            }
            return iArr;
        }

        private static <K> K[] compact(K[] kArr, int[] iArr) {
            int length = kArr.length;
            Object[] objArr = (Object[]) Array.newInstance(kArr.getClass().getComponentType(), GridLayout.max2(iArr, -1) + GridLayout.VERTICAL);
            for (int i = GridLayout.USE_DEFAULT_MARGINS; i < length; i += GridLayout.VERTICAL) {
                objArr[iArr[i]] = kArr[i];
            }
            return objArr;
        }
    }

    public static class Spec {
        static final float DEFAULT_WEIGHT = 0.0f;
        static final Spec UNDEFINED;
        final Alignment alignment;
        final Interval span;
        final boolean startDefined;
        final float weight;

        static {
            UNDEFINED = GridLayout.spec(GridLayout.UNDEFINED);
        }

        private Spec(boolean z, Interval interval, Alignment alignment, float f) {
            this.startDefined = z;
            this.span = interval;
            this.alignment = alignment;
            this.weight = f;
        }

        private Spec(boolean z, int i, int i2, Alignment alignment, float f) {
            this(z, new Interval(i, i + i2), alignment, f);
        }

        public Alignment getAbsoluteAlignment(boolean z) {
            if (this.alignment != GridLayout.UNDEFINED_ALIGNMENT) {
                return this.alignment;
            }
            if (this.weight == 0.0f) {
                return z ? GridLayout.START : GridLayout.BASELINE;
            } else {
                return GridLayout.FILL;
            }
        }

        final Spec copyWriteSpan(Interval interval) {
            return new Spec(this.startDefined, interval, this.alignment, this.weight);
        }

        final Spec copyWriteAlignment(Alignment alignment) {
            return new Spec(this.startDefined, this.span, alignment, this.weight);
        }

        final int getFlexibility() {
            return (this.alignment == GridLayout.UNDEFINED_ALIGNMENT && this.weight == 0.0f) ? GridLayout.USE_DEFAULT_MARGINS : GridLayout.CAN_STRETCH;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return GridLayout.DEFAULT_ORDER_PRESERVED;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return GridLayout.DEFAULT_USE_DEFAULT_MARGINS;
            }
            Spec spec = (Spec) obj;
            if (!this.alignment.equals(spec.alignment)) {
                return GridLayout.DEFAULT_USE_DEFAULT_MARGINS;
            }
            if (this.span.equals(spec.span)) {
                return GridLayout.DEFAULT_ORDER_PRESERVED;
            }
            return GridLayout.DEFAULT_USE_DEFAULT_MARGINS;
        }

        public int hashCode() {
            return (this.span.hashCode() * 31) + this.alignment.hashCode();
        }
    }

    static {
        LOG_PRINTER = new LogPrinter(3, GridLayout.class.getName());
        NO_PRINTER = new C02361();
        ORIENTATION = C0161R.styleable.GridLayout_orientation;
        ROW_COUNT = C0161R.styleable.GridLayout_rowCount;
        COLUMN_COUNT = C0161R.styleable.GridLayout_columnCount;
        USE_DEFAULT_MARGINS = C0161R.styleable.GridLayout_useDefaultMargins;
        ALIGNMENT_MODE = C0161R.styleable.GridLayout_alignmentMode;
        ROW_ORDER_PRESERVED = C0161R.styleable.GridLayout_rowOrderPreserved;
        COLUMN_ORDER_PRESERVED = C0161R.styleable.GridLayout_columnOrderPreserved;
        UNDEFINED_ALIGNMENT = new C02372();
        LEADING = new C02383();
        TRAILING = new C02394();
        TOP = LEADING;
        BOTTOM = TRAILING;
        START = LEADING;
        END = TRAILING;
        LEFT = createSwitchingAlignment(START, END);
        RIGHT = createSwitchingAlignment(END, START);
        CENTER = new C02416();
        BASELINE = new C02437();
        FILL = new C02448();
    }

    public GridLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHorizontalAxis = new Axis(DEFAULT_ORDER_PRESERVED, null);
        this.mVerticalAxis = new Axis(DEFAULT_USE_DEFAULT_MARGINS, null);
        this.mOrientation = USE_DEFAULT_MARGINS;
        this.mUseDefaultMargins = DEFAULT_USE_DEFAULT_MARGINS;
        this.mAlignmentMode = VERTICAL;
        this.mLastLayoutParamsHashCode = USE_DEFAULT_MARGINS;
        this.mPrinter = LOG_PRINTER;
        this.mDefaultGap = context.getResources().getDimensionPixelOffset(C0161R.dimen.default_gap);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0161R.styleable.GridLayout);
        try {
            setRowCount(obtainStyledAttributes.getInt(ROW_COUNT, UNDEFINED));
            setColumnCount(obtainStyledAttributes.getInt(COLUMN_COUNT, UNDEFINED));
            setOrientation(obtainStyledAttributes.getInt(ORIENTATION, USE_DEFAULT_MARGINS));
            setUseDefaultMargins(obtainStyledAttributes.getBoolean(USE_DEFAULT_MARGINS, DEFAULT_USE_DEFAULT_MARGINS));
            setAlignmentMode(obtainStyledAttributes.getInt(ALIGNMENT_MODE, VERTICAL));
            setRowOrderPreserved(obtainStyledAttributes.getBoolean(ROW_ORDER_PRESERVED, DEFAULT_ORDER_PRESERVED));
            setColumnOrderPreserved(obtainStyledAttributes.getBoolean(COLUMN_ORDER_PRESERVED, DEFAULT_ORDER_PRESERVED));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public GridLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, USE_DEFAULT_MARGINS);
    }

    public GridLayout(Context context) {
        this(context, null);
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            invalidateStructure();
            requestLayout();
        }
    }

    public int getRowCount() {
        return this.mVerticalAxis.getCount();
    }

    public void setRowCount(int i) {
        this.mVerticalAxis.setCount(i);
        invalidateStructure();
        requestLayout();
    }

    public int getColumnCount() {
        return this.mHorizontalAxis.getCount();
    }

    public void setColumnCount(int i) {
        this.mHorizontalAxis.setCount(i);
        invalidateStructure();
        requestLayout();
    }

    public boolean getUseDefaultMargins() {
        return this.mUseDefaultMargins;
    }

    public void setUseDefaultMargins(boolean z) {
        this.mUseDefaultMargins = z;
        requestLayout();
    }

    public int getAlignmentMode() {
        return this.mAlignmentMode;
    }

    public void setAlignmentMode(int i) {
        this.mAlignmentMode = i;
        requestLayout();
    }

    public boolean isRowOrderPreserved() {
        return this.mVerticalAxis.isOrderPreserved();
    }

    public void setRowOrderPreserved(boolean z) {
        this.mVerticalAxis.setOrderPreserved(z);
        invalidateStructure();
        requestLayout();
    }

    public boolean isColumnOrderPreserved() {
        return this.mHorizontalAxis.isOrderPreserved();
    }

    public void setColumnOrderPreserved(boolean z) {
        this.mHorizontalAxis.setOrderPreserved(z);
        invalidateStructure();
        requestLayout();
    }

    public Printer getPrinter() {
        return this.mPrinter;
    }

    public void setPrinter(Printer printer) {
        if (printer == null) {
            printer = NO_PRINTER;
        }
        this.mPrinter = printer;
    }

    static int max2(int[] iArr, int i) {
        int length = iArr.length;
        for (int i2 = USE_DEFAULT_MARGINS; i2 < length; i2 += VERTICAL) {
            i = Math.max(i, iArr[i2]);
        }
        return i;
    }

    static <T> T[] append(T[] tArr, T[] tArr2) {
        Object[] objArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), tArr.length + tArr2.length);
        System.arraycopy(tArr, USE_DEFAULT_MARGINS, objArr, USE_DEFAULT_MARGINS, tArr.length);
        System.arraycopy(tArr2, USE_DEFAULT_MARGINS, objArr, tArr.length, tArr2.length);
        return objArr;
    }

    static Alignment getAlignment(int i, boolean z) {
        switch (((z ? 7 : 112) & i) >> (z ? USE_DEFAULT_MARGINS : 4)) {
            case VERTICAL /*1*/:
                return CENTER;
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                return z ? LEFT : TOP;
            case C3374b.SmoothProgressBar_spb_speed /*5*/:
                return z ? RIGHT : BOTTOM;
            case C3374b.SmoothProgressBar_spb_progressiveStop_speed /*7*/:
                return FILL;
            case GravityCompat.START /*8388611*/:
                return START;
            case GravityCompat.END /*8388613*/:
                return END;
            default:
                return UNDEFINED_ALIGNMENT;
        }
    }

    private int getDefaultMargin(View view, boolean z, boolean z2) {
        if (view.getClass() == Space.class) {
            return USE_DEFAULT_MARGINS;
        }
        return this.mDefaultGap / CAN_STRETCH;
    }

    private int getDefaultMargin(View view, boolean z, boolean z2, boolean z3) {
        return getDefaultMargin(view, z2, z3);
    }

    private int getDefaultMargin(View view, LayoutParams layoutParams, boolean z, boolean z2) {
        if (!this.mUseDefaultMargins) {
            return USE_DEFAULT_MARGINS;
        }
        int i;
        Spec spec = z ? layoutParams.columnSpec : layoutParams.rowSpec;
        Axis axis = z ? this.mHorizontalAxis : this.mVerticalAxis;
        Interval interval = spec.span;
        if (z && isLayoutRtlCompat()) {
            i = !z2 ? VERTICAL : USE_DEFAULT_MARGINS;
        } else {
            boolean z3 = z2;
        }
        boolean z4 = i != 0 ? interval.min == 0 ? DEFAULT_ORDER_PRESERVED : DEFAULT_USE_DEFAULT_MARGINS : interval.max == axis.getCount() ? DEFAULT_ORDER_PRESERVED : DEFAULT_USE_DEFAULT_MARGINS;
        return getDefaultMargin(view, z4, z, z2);
    }

    int getMargin1(View view, boolean z, boolean z2) {
        LayoutParams layoutParams = getLayoutParams(view);
        int i = z ? z2 ? layoutParams.leftMargin : layoutParams.rightMargin : z2 ? layoutParams.topMargin : layoutParams.bottomMargin;
        return i == UNDEFINED ? getDefaultMargin(view, layoutParams, z, z2) : i;
    }

    private boolean isLayoutRtlCompat() {
        return ViewCompat.getLayoutDirection(this) == VERTICAL ? DEFAULT_ORDER_PRESERVED : DEFAULT_USE_DEFAULT_MARGINS;
    }

    private int getMargin(View view, boolean z, boolean z2) {
        if (this.mAlignmentMode == VERTICAL) {
            return getMargin1(view, z, z2);
        }
        Axis axis = z ? this.mHorizontalAxis : this.mVerticalAxis;
        int[] leadingMargins = z2 ? axis.getLeadingMargins() : axis.getTrailingMargins();
        LayoutParams layoutParams = getLayoutParams(view);
        Spec spec = z ? layoutParams.columnSpec : layoutParams.rowSpec;
        return leadingMargins[z2 ? spec.span.min : spec.span.max];
    }

    private int getTotalMargin(View view, boolean z) {
        return getMargin(view, z, DEFAULT_ORDER_PRESERVED) + getMargin(view, z, DEFAULT_USE_DEFAULT_MARGINS);
    }

    private static boolean fits(int[] iArr, int i, int i2, int i3) {
        if (i3 > iArr.length) {
            return DEFAULT_USE_DEFAULT_MARGINS;
        }
        while (i2 < i3) {
            if (iArr[i2] > i) {
                return DEFAULT_USE_DEFAULT_MARGINS;
            }
            i2 += VERTICAL;
        }
        return DEFAULT_ORDER_PRESERVED;
    }

    private static void procrusteanFill(int[] iArr, int i, int i2, int i3) {
        int length = iArr.length;
        Arrays.fill(iArr, Math.min(i, length), Math.min(i2, length), i3);
    }

    private static void setCellGroup(LayoutParams layoutParams, int i, int i2, int i3, int i4) {
        layoutParams.setRowSpecSpan(new Interval(i, i + i2));
        layoutParams.setColumnSpecSpan(new Interval(i3, i3 + i4));
    }

    private static int clip(Interval interval, boolean z, int i) {
        int size = interval.size();
        if (i == 0) {
            return size;
        }
        return Math.min(size, i - (z ? Math.min(interval.min, i) : USE_DEFAULT_MARGINS));
    }

    private void validateLayoutParams() {
        int i;
        Object obj = this.mOrientation == 0 ? VERTICAL : USE_DEFAULT_MARGINS;
        Axis axis = obj != null ? this.mHorizontalAxis : this.mVerticalAxis;
        if (axis.definedCount != UNDEFINED) {
            i = axis.definedCount;
        } else {
            i = USE_DEFAULT_MARGINS;
        }
        int[] iArr = new int[i];
        int childCount = getChildCount();
        int i2 = USE_DEFAULT_MARGINS;
        int i3 = USE_DEFAULT_MARGINS;
        for (int i4 = USE_DEFAULT_MARGINS; i4 < childCount; i4 += VERTICAL) {
            int i5;
            LayoutParams layoutParams = (LayoutParams) getChildAt(i4).getLayoutParams();
            Spec spec = obj != null ? layoutParams.rowSpec : layoutParams.columnSpec;
            Interval interval = spec.span;
            boolean z = spec.startDefined;
            int size = interval.size();
            if (z) {
                i3 = interval.min;
            }
            spec = obj != null ? layoutParams.columnSpec : layoutParams.rowSpec;
            interval = spec.span;
            boolean z2 = spec.startDefined;
            int clip = clip(interval, z2, i);
            if (z2) {
                i5 = interval.min;
            } else {
                i5 = i2;
            }
            if (i != 0) {
                if (!(z && z2)) {
                    while (!fits(iArr, i3, i5, i5 + clip)) {
                        if (z2) {
                            i3 += VERTICAL;
                        } else if (i5 + clip <= i) {
                            i5 += VERTICAL;
                        } else {
                            i3 += VERTICAL;
                            i5 = USE_DEFAULT_MARGINS;
                        }
                    }
                }
                procrusteanFill(iArr, i5, i5 + clip, i3 + size);
            }
            if (obj != null) {
                setCellGroup(layoutParams, i3, size, i5, clip);
            } else {
                setCellGroup(layoutParams, i5, clip, i3, size);
            }
            i2 = i5 + clip;
        }
    }

    private void invalidateStructure() {
        this.mLastLayoutParamsHashCode = USE_DEFAULT_MARGINS;
        if (this.mHorizontalAxis != null) {
            this.mHorizontalAxis.invalidateStructure();
        }
        if (this.mVerticalAxis != null) {
            this.mVerticalAxis.invalidateStructure();
        }
        invalidateValues();
    }

    private void invalidateValues() {
        if (this.mHorizontalAxis != null && this.mVerticalAxis != null) {
            this.mHorizontalAxis.invalidateValues();
            this.mVerticalAxis.invalidateValues();
        }
    }

    final LayoutParams getLayoutParams(View view) {
        return (LayoutParams) view.getLayoutParams();
    }

    private static void handleInvalidParams(String str) {
        throw new IllegalArgumentException(str + ". ");
    }

    private void checkLayoutParams(LayoutParams layoutParams, boolean z) {
        String str = z ? "column" : "row";
        Interval interval = (z ? layoutParams.columnSpec : layoutParams.rowSpec).span;
        if (interval.min != UNDEFINED && interval.min < 0) {
            handleInvalidParams(str + " indices must be positive");
        }
        int i = (z ? this.mHorizontalAxis : this.mVerticalAxis).definedCount;
        if (i != UNDEFINED) {
            if (interval.max > i) {
                handleInvalidParams(str + " indices (start + span) mustn't exceed the " + str + " count");
            }
            if (interval.size() > i) {
                handleInvalidParams(str + " span mustn't exceed the " + str + " count");
            }
        }
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (!(layoutParams instanceof LayoutParams)) {
            return DEFAULT_USE_DEFAULT_MARGINS;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        checkLayoutParams(layoutParams2, DEFAULT_ORDER_PRESERVED);
        checkLayoutParams(layoutParams2, DEFAULT_USE_DEFAULT_MARGINS);
        return DEFAULT_ORDER_PRESERVED;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    private void drawLine(Canvas canvas, int i, int i2, int i3, int i4, Paint paint) {
        if (isLayoutRtlCompat()) {
            int width = getWidth();
            canvas.drawLine((float) (width - i), (float) i2, (float) (width - i3), (float) i4, paint);
            return;
        }
        canvas.drawLine((float) i, (float) i2, (float) i3, (float) i4, paint);
    }

    private int computeLayoutParamsHashCode() {
        int i = VERTICAL;
        int childCount = getChildCount();
        int i2 = USE_DEFAULT_MARGINS;
        while (i2 < childCount) {
            int i3;
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 8) {
                i3 = i;
            } else {
                i3 = ((LayoutParams) childAt.getLayoutParams()).hashCode() + (i * 31);
            }
            i2 += VERTICAL;
            i = i3;
        }
        return i;
    }

    private void consistencyCheck() {
        if (this.mLastLayoutParamsHashCode == 0) {
            validateLayoutParams();
            this.mLastLayoutParamsHashCode = computeLayoutParamsHashCode();
        } else if (this.mLastLayoutParamsHashCode != computeLayoutParamsHashCode()) {
            this.mPrinter.println("The fields of some layout parameters were modified in between layout operations. Check the javadoc for GridLayout.LayoutParams#rowSpec.");
            invalidateStructure();
            consistencyCheck();
        }
    }

    private void measureChildWithMargins2(View view, int i, int i2, int i3, int i4) {
        view.measure(getChildMeasureSpec(i, getTotalMargin(view, DEFAULT_ORDER_PRESERVED), i3), getChildMeasureSpec(i2, getTotalMargin(view, DEFAULT_USE_DEFAULT_MARGINS), i4));
    }

    private void measureChildrenWithMargins(int i, int i2, boolean z) {
        int childCount = getChildCount();
        for (int i3 = USE_DEFAULT_MARGINS; i3 < childCount; i3 += VERTICAL) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = getLayoutParams(childAt);
                if (z) {
                    measureChildWithMargins2(childAt, i, i2, layoutParams.width, layoutParams.height);
                } else {
                    boolean z2 = this.mOrientation == 0 ? DEFAULT_ORDER_PRESERVED : DEFAULT_USE_DEFAULT_MARGINS;
                    Spec spec = z2 ? layoutParams.columnSpec : layoutParams.rowSpec;
                    if (spec.getAbsoluteAlignment(z2) == FILL) {
                        Interval interval = spec.span;
                        int[] locations = (z2 ? this.mHorizontalAxis : this.mVerticalAxis).getLocations();
                        int totalMargin = (locations[interval.max] - locations[interval.min]) - getTotalMargin(childAt, z2);
                        if (z2) {
                            measureChildWithMargins2(childAt, i, i2, totalMargin, layoutParams.height);
                        } else {
                            measureChildWithMargins2(childAt, i, i2, layoutParams.width, totalMargin);
                        }
                    }
                }
            }
        }
    }

    static int adjust(int i, int i2) {
        return MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i + i2), MeasureSpec.getMode(i));
    }

    protected void onMeasure(int i, int i2) {
        int measure;
        int measure2;
        consistencyCheck();
        invalidateValues();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int adjust = adjust(i, -paddingLeft);
        int adjust2 = adjust(i2, -paddingTop);
        measureChildrenWithMargins(adjust, adjust2, DEFAULT_ORDER_PRESERVED);
        if (this.mOrientation == 0) {
            measure = this.mHorizontalAxis.getMeasure(adjust);
            measureChildrenWithMargins(adjust, adjust2, DEFAULT_USE_DEFAULT_MARGINS);
            measure2 = this.mVerticalAxis.getMeasure(adjust2);
        } else {
            measure2 = this.mVerticalAxis.getMeasure(adjust2);
            measureChildrenWithMargins(adjust, adjust2, DEFAULT_USE_DEFAULT_MARGINS);
            measure = this.mHorizontalAxis.getMeasure(adjust);
        }
        setMeasuredDimension(ViewCompat.resolveSizeAndState(Math.max(measure + paddingLeft, getSuggestedMinimumWidth()), i, USE_DEFAULT_MARGINS), ViewCompat.resolveSizeAndState(Math.max(measure2 + paddingTop, getSuggestedMinimumHeight()), i2, USE_DEFAULT_MARGINS));
    }

    private int getMeasurement(View view, boolean z) {
        return z ? view.getMeasuredWidth() : view.getMeasuredHeight();
    }

    final int getMeasurementIncludingMargin(View view, boolean z) {
        if (view.getVisibility() == 8) {
            return USE_DEFAULT_MARGINS;
        }
        return getMeasurement(view, z) + getTotalMargin(view, z);
    }

    public void requestLayout() {
        super.requestLayout();
        invalidateStructure();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        consistencyCheck();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        this.mHorizontalAxis.layout((i5 - paddingLeft) - paddingRight);
        this.mVerticalAxis.layout((i6 - paddingTop) - paddingBottom);
        int[] locations = this.mHorizontalAxis.getLocations();
        int[] locations2 = this.mVerticalAxis.getLocations();
        int childCount = getChildCount();
        for (int i7 = USE_DEFAULT_MARGINS; i7 < childCount; i7 += VERTICAL) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = getLayoutParams(childAt);
                Spec spec = layoutParams.columnSpec;
                Spec spec2 = layoutParams.rowSpec;
                Interval interval = spec.span;
                Interval interval2 = spec2.span;
                int i8 = locations[interval.min];
                int i9 = locations2[interval2.min];
                int i10 = locations[interval.max] - i8;
                int i11 = locations2[interval2.max] - i9;
                int measurement = getMeasurement(childAt, DEFAULT_ORDER_PRESERVED);
                int measurement2 = getMeasurement(childAt, DEFAULT_USE_DEFAULT_MARGINS);
                Alignment absoluteAlignment = spec.getAbsoluteAlignment(DEFAULT_ORDER_PRESERVED);
                Alignment absoluteAlignment2 = spec2.getAbsoluteAlignment(DEFAULT_USE_DEFAULT_MARGINS);
                Bounds bounds = (Bounds) this.mHorizontalAxis.getGroupBounds().getValue(i7);
                Bounds bounds2 = (Bounds) this.mVerticalAxis.getGroupBounds().getValue(i7);
                int gravityOffset = absoluteAlignment.getGravityOffset(childAt, i10 - bounds.size(DEFAULT_ORDER_PRESERVED));
                int gravityOffset2 = absoluteAlignment2.getGravityOffset(childAt, i11 - bounds2.size(DEFAULT_ORDER_PRESERVED));
                int margin = getMargin(childAt, DEFAULT_ORDER_PRESERVED, DEFAULT_ORDER_PRESERVED);
                int margin2 = getMargin(childAt, DEFAULT_USE_DEFAULT_MARGINS, DEFAULT_ORDER_PRESERVED);
                int margin3 = getMargin(childAt, DEFAULT_ORDER_PRESERVED, DEFAULT_USE_DEFAULT_MARGINS);
                int i12 = margin + margin3;
                int margin4 = margin2 + getMargin(childAt, DEFAULT_USE_DEFAULT_MARGINS, DEFAULT_USE_DEFAULT_MARGINS);
                i6 = bounds.getOffset(this, childAt, absoluteAlignment, measurement + i12, DEFAULT_ORDER_PRESERVED);
                paddingBottom = bounds2.getOffset(this, childAt, absoluteAlignment2, measurement2 + margin4, DEFAULT_USE_DEFAULT_MARGINS);
                int sizeInCell = absoluteAlignment.getSizeInCell(childAt, measurement, i10 - i12);
                int sizeInCell2 = absoluteAlignment2.getSizeInCell(childAt, measurement2, i11 - margin4);
                i6 += i8 + gravityOffset;
                i6 = !isLayoutRtlCompat() ? i6 + (paddingLeft + margin) : (((i5 - sizeInCell) - paddingRight) - margin3) - i6;
                paddingBottom = (paddingBottom + ((paddingTop + i9) + gravityOffset2)) + margin2;
                if (!(sizeInCell == childAt.getMeasuredWidth() && sizeInCell2 == childAt.getMeasuredHeight())) {
                    childAt.measure(MeasureSpec.makeMeasureSpec(sizeInCell, 1073741824), MeasureSpec.makeMeasureSpec(sizeInCell2, 1073741824));
                }
                childAt.layout(i6, paddingBottom, sizeInCell + i6, sizeInCell2 + paddingBottom);
            }
        }
    }

    public static Spec spec(int i, int i2, Alignment alignment, float f) {
        return new Spec(i, i2, alignment, f, null);
    }

    public static Spec spec(int i, Alignment alignment, float f) {
        return spec(i, VERTICAL, alignment, f);
    }

    public static Spec spec(int i, int i2, float f) {
        return spec(i, i2, UNDEFINED_ALIGNMENT, f);
    }

    public static Spec spec(int i, float f) {
        return spec(i, (int) VERTICAL, f);
    }

    public static Spec spec(int i, int i2, Alignment alignment) {
        return spec(i, i2, alignment, 0.0f);
    }

    public static Spec spec(int i, Alignment alignment) {
        return spec(i, (int) VERTICAL, alignment);
    }

    public static Spec spec(int i, int i2) {
        return spec(i, i2, UNDEFINED_ALIGNMENT);
    }

    public static Spec spec(int i) {
        return spec(i, (int) VERTICAL);
    }

    private static Alignment createSwitchingAlignment(Alignment alignment, Alignment alignment2) {
        return new C02405(alignment, alignment2);
    }

    static boolean canStretch(int i) {
        return (i & CAN_STRETCH) != 0 ? DEFAULT_ORDER_PRESERVED : DEFAULT_USE_DEFAULT_MARGINS;
    }
}

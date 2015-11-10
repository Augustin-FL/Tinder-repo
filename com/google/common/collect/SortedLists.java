package com.google.common.collect;

import com.google.common.base.C1650g;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

final class SortedLists {

    public enum KeyAbsentBehavior {
        NEXT_LOWER {
            int m4248a(int i) {
                return i - 1;
            }
        },
        NEXT_HIGHER {
            public int m4249a(int i) {
                return i;
            }
        },
        INVERTED_INSERTION_INDEX {
            public int m4250a(int i) {
                return i ^ -1;
            }
        };

        abstract int m4247a(int i);
    }

    public enum KeyPresentBehavior {
        ANY_PRESENT {
            <E> int m4252a(Comparator<? super E> comparator, E e, List<? extends E> list, int i) {
                return i;
            }
        },
        LAST_PRESENT {
            <E> int m4253a(Comparator<? super E> comparator, E e, List<? extends E> list, int i) {
                int size = list.size() - 1;
                int i2 = i;
                while (i2 < size) {
                    int i3 = ((i2 + size) + 1) >>> 1;
                    if (comparator.compare(list.get(i3), e) > 0) {
                        size = i3 - 1;
                    } else {
                        i2 = i3;
                    }
                }
                return i2;
            }
        },
        FIRST_PRESENT {
            <E> int m4254a(Comparator<? super E> comparator, E e, List<? extends E> list, int i) {
                int i2 = 0;
                int i3 = i;
                while (i2 < i3) {
                    int i4 = (i2 + i3) >>> 1;
                    if (comparator.compare(list.get(i4), e) < 0) {
                        i4++;
                    } else {
                        i3 = i4;
                        i4 = i2;
                    }
                    i2 = i4;
                }
                return i2;
            }
        },
        FIRST_AFTER {
            public <E> int m4255a(Comparator<? super E> comparator, E e, List<? extends E> list, int i) {
                return b.m4251a(comparator, e, list, i) + 1;
            }
        },
        LAST_BEFORE {
            public <E> int m4256a(Comparator<? super E> comparator, E e, List<? extends E> list, int i) {
                return c.m4251a(comparator, e, list, i) - 1;
            }
        };

        abstract <E> int m4251a(Comparator<? super E> comparator, E e, List<? extends E> list, int i);
    }

    public static <E> int m4257a(List<? extends E> list, E e, Comparator<? super E> comparator, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        C1650g.m3080a((Object) comparator);
        C1650g.m3080a((Object) list);
        C1650g.m3080a((Object) keyPresentBehavior);
        C1650g.m3080a((Object) keyAbsentBehavior);
        if (!(list instanceof RandomAccess)) {
            list = C1872p.m4310a((Iterable) list);
        }
        int i = 0;
        int size = list.size() - 1;
        while (i <= size) {
            int i2 = (i + size) >>> 1;
            int compare = comparator.compare(e, list.get(i2));
            if (compare < 0) {
                size = i2 - 1;
            } else if (compare <= 0) {
                return keyPresentBehavior.m4251a(comparator, e, list.subList(i, size + 1), i2 - i) + i;
            } else {
                i = i2 + 1;
            }
        }
        return keyAbsentBehavior.m4247a(i);
    }
}

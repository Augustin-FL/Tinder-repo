package org.apache.commons.cli;

/* renamed from: org.apache.commons.cli.d */
class C3357d {
    static void m10401a(String str) throws IllegalArgumentException {
        int i = 0;
        if (str != null) {
            if (str.length() == 1) {
                char charAt = str.charAt(0);
                if (!C3357d.m10402a(charAt)) {
                    throw new IllegalArgumentException(new StringBuffer().append("illegal option value '").append(charAt).append("'").toString());
                }
                return;
            }
            char[] toCharArray = str.toCharArray();
            while (i < toCharArray.length) {
                if (C3357d.m10403b(toCharArray[i])) {
                    i++;
                } else {
                    throw new IllegalArgumentException(new StringBuffer().append("opt contains illegal character value '").append(toCharArray[i]).append("'").toString());
                }
            }
        }
    }

    private static boolean m10402a(char c) {
        return C3357d.m10403b(c) || c == ' ' || c == '?' || c == '@';
    }

    private static boolean m10403b(char c) {
        return Character.isJavaIdentifierPart(c);
    }
}

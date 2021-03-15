package learn.katas.corejava.tools.diff;

public class DiffStrings {

    /**
     * Finds the index of first differing character in the specified strings or -1 if strings are equal.
     * @param a first string
     * @param b second string
     * @return index of differing character or -1
     */
    public static int firstDifferingIndex(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        int len = Math.min(aLen, bLen);
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return i;
            }
        }
        return (aLen == bLen) ? -1 : len;
    }
}

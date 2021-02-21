package learn.katas.start;

// DONE BUT NEEDS IMPROVEMENT: Find primary numbers
public class Primary {
    /**
     * Retrieves array of first primary numbers.
     * @param number number of primary numbers
     * @return array of primary numbers
     */
    public long[] first(int number) {
        long[] result = new long[number];
        int idx = 0;
        for (long value = 2; idx < result.length; value++) {
            boolean primary = true;
            for (long divider = 2; divider <= value / 2; divider++) {
                if (value % divider == 0) {
                    primary = false;
                    break;
                }
            }
            if (primary) {
                result[idx++] = value;
            }
        }
        return result;
    }
}

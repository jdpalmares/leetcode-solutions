public class HIndex {
    public int hIndex(int[] citations) {
        // bucket sort implementation
        // int n = citations.length;
        // int[] buckets = new int[n + 1];
        // for (int c : citations) {
        // if (c >= n) {
        // buckets[n]++;
        // } else {
        // buckets[c]++;
        // }
        // }
        // int count = 0;
        // for (int i = n; i >= 0; i--) {
        // count += buckets[i];
        // if (count >= i) {
        // return i;
        // }
        // }
        // return 0;

        // faster binary sort implementation
        int min = 0, max = citations.length;
        while (min < max) {
            int avg = (min + max + 1) / 2;
            int ctr = 0;
            for (int i = 0; i < citations.length; i++)
                if (citations[i] >= avg)
                    ctr++;
            if (ctr >= avg)
                min = avg;
            else
                max = avg - 1;
        }
        return min;
    }
}

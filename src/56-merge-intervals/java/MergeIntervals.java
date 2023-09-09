import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    // intuition solution
    public int[][] merge(int[][] intervals) {
        int numIntervals = intervals.length;
        if (numIntervals <= 1)
            return intervals;
        List<int[]> listAns = new ArrayList<>();
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        for (int i = 0; i < numIntervals; i++) {
            int[] tempInterval = intervals[i];
            while (i != numIntervals - 1) {
                if (tempInterval[1] >= intervals[i + 1][0] && tempInterval[1] < intervals[i + 1][1])
                    tempInterval[1] = intervals[i + 1][1];
                if ((tempInterval[0] <= intervals[i + 1][0]) &&
                        (tempInterval[1] < intervals[i + 1][0]))
                    break;
                i++;
            }

            listAns.add(tempInterval);
        }

        return listAns.toArray(new int[0][1]);
    }

    // alternative solution more concise code
    // public int[][] merge(int[][] intervals) {
    // if (intervals.length <= 1)
    // return intervals;

    // Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

    // List<int[]> ans = new ArrayList<>();
    // int[] newInterval = intervals[0];
    // ans.add(newInterval);
    // for (int[] interval : intervals) {
    // if (interval[0] <= newInterval[1])
    // newInterval[1] = Math.max(newInterval[1], interval[1]);
    // else {
    // newInterval = interval;
    // ans.add(newInterval);
    // }
    // }

    // return ans.toArray(new int[0][1]);
    // }
}

import java.util.ArrayList;
import java.util.List;

public class InsertIntervals {
    // intuition answer based on previous problem
    // public int[][] insert(int[][] intervals, int[] newInterval) {
    // int numIntervals = intervals.length;
    // int[][] newIntervals = Arrays.copyOf(intervals, numIntervals + 1);
    // newIntervals[numIntervals] = newInterval;

    // if (newIntervals.length <= 1)
    // return newIntervals;

    // return merge(newIntervals);
    // }

    // public int[][] merge(int[][] intervals) {
    // int numIntervals = intervals.length;
    // if (numIntervals <= 1)
    // return intervals;
    // List<int[]> listAns = new ArrayList<>();
    // Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
    // for (int i = 0; i < numIntervals; i++) {
    // int[] tempInterval = intervals[i];
    // while (i != numIntervals - 1) {
    // if (tempInterval[1] >= intervals[i + 1][0] && tempInterval[1] < intervals[i +
    // 1][1])
    // tempInterval[1] = intervals[i + 1][1];
    // if ((tempInterval[0] <= intervals[i + 1][0]) &&
    // (tempInterval[1] < intervals[i + 1][0]))
    // break;
    // i++;
    // }

    // listAns.add(tempInterval);
    // }

    // return listAns.toArray(new int[0][1]);
    // }

    // alternative answer more efficient
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();

        for (int[] interval : intervals) {
            if (newInterval[1] < interval[0]) {
                ans.add(newInterval);
                newInterval = interval;
            } else if (interval[1] < newInterval[0]) {
                ans.add(interval);
            } else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }

        ans.add(newInterval);
        return ans.toArray(new int[0][0]);
    }
}

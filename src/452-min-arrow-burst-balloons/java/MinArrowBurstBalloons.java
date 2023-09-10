import java.util.Arrays;

public class MinArrowBurstBalloons {
    // intuition answer based on other related problems regarding intervals
    public int findMinArrowShots(int[][] points) {
        int pointLen = points.length;
        if (pointLen <= 1)
            return pointLen;
        Arrays.sort(points, (i1, i2) -> Integer.compare(i1[1], i2[1]));
        int currPoint = points[0][1];
        int ans = 1;
        for (int i = 1; i < pointLen; i++) {
            if (currPoint >= points[i][0])
                continue;
            ans++;
            currPoint = points[i][1];
        }
        return ans;
    }

    // alt answer same perf
    // public int findMinArrowShots(int[][] points) {
    // int pointLen = points.length;
    // if (pointLen <= 1)
    // return pointLen;
    // Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
    // int ans = 0, arrow = 0;
    // for (int i = 0; i < pointLen; i++) {
    // if (ans == 0 || points[i][0] > arrow) {
    // ans++;
    // arrow = points[i][1];
    // }
    // }
    // return ans;
    // }
}

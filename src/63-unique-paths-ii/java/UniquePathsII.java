
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rowLen = obstacleGrid[0].length;
        int[] ans = new int[rowLen];
        ans[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < rowLen; j++) {
                if (row[j] == 1) ans[j] = 0;
                else if (j > 0) ans[j] += ans[j - 1];
            }
        }
        return ans[rowLen - 1];
    }
}

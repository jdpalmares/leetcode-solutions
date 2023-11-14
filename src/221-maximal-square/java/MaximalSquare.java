
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        //DP solution
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
            
        int ans = 0;
        int colLen = matrix.length, rowLen = matrix[0].length;
        
        int[][] dp = new int[colLen + 1][rowLen + 1];
        
        for (int i = 1; i <= colLen; i++) {
            for (int j = 1; j <= rowLen; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        
        return ans * ans;
    }
}


public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int colLen = grid.length;
        int rowLen = grid[0].length;
        
        for (int i = 1; i < colLen; i++)
            grid[i][0] += grid[i-1][0];
        
        for (int j = 1; j < rowLen; j++)
            grid[0][j] += grid[0][j-1];
        
        for (int i = 1; i < colLen; i++) {
            for (int j = 1; j < rowLen; j++)
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
        }
        
        return grid[colLen-1][rowLen-1];
    }
}

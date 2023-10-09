
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        int gridOutLen = grid.length;
        if (gridOutLen == 0)
            return 0;
        int gridInLen = grid[0].length;
        for (int i = 0; i < gridOutLen; i++){
            for (int j = 0; j < gridInLen; j++)
                if (grid[i][j] == '1') {
                    sinkIsland(grid, gridOutLen, gridInLen, i, j);
                    ++count;
                }
        }
        return count;
    }

    private void sinkIsland(char[][] grid, int gridOutLen, int gridInLen, int i, int j) {
        if (i < 0 || j < 0 || i >= gridOutLen || j >= gridInLen || grid[i][j] != '1')
            return;
        grid[i][j] = '0';
        sinkIsland(grid, gridOutLen, gridInLen, i + 1, j);
        sinkIsland(grid, gridOutLen, gridInLen, i - 1, j);
        sinkIsland(grid, gridOutLen, gridInLen, i, j + 1);
        sinkIsland(grid, gridOutLen, gridInLen, i, j - 1);
    }
}

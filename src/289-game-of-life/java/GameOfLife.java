
public class GameOfLife {
    // not in-place solution but efficient time complexity also easier to understand
    // public void gameOfLife(int[][] board) {
    // int rows = board.length, cols = board[0].length;
    // int[][] tempBoard = new int[rows][cols];
    // for (int r = 0; r < rows; r++) {
    // for (int c = 0; c < cols; c++) {
    // int liveNeighbors = neighbor(board, r - 1, c - 1) + neighbor(board, r - 1, c)
    // + neighbor(board, r - 1, c + 1) + neighbor(board, r, c + 1) +
    // neighbor(board, r + 1, c + 1) + neighbor(board, r + 1, c) + neighbor(board, r
    // + 1, c - 1)
    // + neighbor(board, r, c - 1);
    // // System.out.println("cell: ("+r+","+c+") , liveNeighbors: "+liveNeighbors);
    // // update temporary matrix,based on the rules in question
    // if (board[r][c] == 1)
    // tempBoard[r][c] = (liveNeighbors < 2 || liveNeighbors > 3) ? 0 : 1;
    // else
    // tempBoard[r][c] = (liveNeighbors == 3) ? 1 : 0;
    // }
    // }

    // for (int r = 0; r < rows; r++) // copy all tempBoard elements back to board
    // matrix
    // board[r] = tempBoard[r].clone();
    // }

    // public int neighbor(int[][] board, int r, int c) {
    // // out of bound cases
    // if (r < 0 || r >= board.length || c < 0 || c >= board[0].length ||
    // board[r][c] == 0)
    // return 0;
    // return 1;
    // }

    // in-place and concise solution w/o using too much magic numbers
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                int around = countNeighbors(i, j, board);
                if (board[i][j] == 0 && around == 3)
                    board[i][j] = 3; // resurrected
                else if (board[i][j] == 1 && around != 2 && around != 3)
                    board[i][j] = 2; // dies
            }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (board[i][j] > 1)
                    board[i][j] -= 2;
    }

    private int countNeighbors(int i, int j, int[][] board) {
        int count = 0, m = board.length, n = board[0].length;
        // check around the cell and maintain in bound
        for (int x = Math.max(0, i - 1); x < Math.min(i + 2, m); x++)
            for (int y = Math.max(0, j - 1); y < Math.min(j + 2, n); y++)
                if ((x != i || y != j) && (board[x][y] == 1 || board[x][y] == 2))
                    count++; // increase count if neighbor is still or previously alive
        return count;
    }
}

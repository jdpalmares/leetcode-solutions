
public class WordSearch {
    //solution using recursion DFS
    public boolean exist(char[][] board, String word) {
        char[] wordCharArrr = word.toCharArray();
        for (int col = 0; col < board.length; col++) {
            for (int row = 0; row < board[col].length; row++) {
                if (checkDFS(board, col, row, wordCharArrr, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean checkDFS(char[][] board, int col, int row, char[] word, int i) {
        if (i == word.length)
            return true;
        if (col < 0 || row < 0 || col == board.length || row == board[col].length)
            return false;
        if (board[col][row] != word[i])
            return false;
        board[col][row] ^= 256;
        boolean ans = checkDFS(board, col, row + 1, word, i + 1)
            || checkDFS(board, col, row - 1, word, i + 1)
            || checkDFS(board, col + 1, row, word, i + 1)
            || checkDFS(board, col - 1, row, word, i + 1);
        board[col][row] ^= 256;
        return ans;
    }
}

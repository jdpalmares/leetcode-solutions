public class ValidSudoku {
    // slow but self explanatory answer
    // public boolean isValidSudoku(char[][] board) {
    // Set<String> sudokuSet = new HashSet<String>();
    // for (int i = 0; i < 9; ++i) {
    // for (int j = 0; j < 9; ++j) {
    // char number = board[i][j];
    // if (number != '.')
    // if (!sudokuSet.add(number + " in row " + i) ||
    // !sudokuSet.add(number + " in column " + j) ||
    // !sudokuSet.add(number + " in block " + i / 3 + "-" + j / 3))
    // return false;
    // }
    // }
    // return true;
    // }

    // fast solution using arrays of int
    public boolean isValidSudoku(char[][] board) {
        int[] vertCheck = new int[9];
        int[] horizontalCheck = new int[9];
        int[] squareCheck = new int[9];
        int idx = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    idx = 1 << (board[i][j] - '0');
                    if ((horizontalCheck[i] & idx) > 0 || (vertCheck[j] & idx) > 0
                            || (squareCheck[(i / 3) * 3 + j / 3] & idx) > 0)
                        return false;
                    horizontalCheck[i] |= idx;
                    vertCheck[j] |= idx;
                    squareCheck[(i / 3) * 3 + j / 3] |= idx;
                }
            }
        }
        return true;
    }
}


public class SurroundedRegions {
    public void solve(char[][] board) {
        if(board.length==0)
            return;
        int rowLen = board.length, colLen = board[0].length;

        for( int i = 0; i < colLen; i++ ){
            depthFirstSearch(board, 0, i, rowLen, colLen);
            depthFirstSearch(board, rowLen-1, i, rowLen, colLen);
        }
        for( int i = 0; i < rowLen; i++ ){
            depthFirstSearch(board, i, 0, rowLen, colLen);
            depthFirstSearch(board, i, colLen-1, rowLen, colLen);
        }
        for(int i = 0; i < rowLen; i++ )
            for(int j = 0; j < colLen; j++ )
                if( board[i][j] == 'O' )
                    board[i][j]='X';
                else if( board[i][j] == 'P' )
                    board[i][j]='O';
    }

    private void depthFirstSearch(char[][] board,int row,int col,int rowLen,int colLen){
        if( row < 0 || col < 0 || row == rowLen || col == colLen || board[row][col] != 'O' )
            return;
        board[row][col] = 'P';
        depthFirstSearch( board, row + 1, col, rowLen, colLen );
        depthFirstSearch( board, row, col + 1, rowLen, colLen );
        depthFirstSearch( board, row - 1, col, rowLen, colLen );
        depthFirstSearch( board, row, col - 1, rowLen, colLen );
    }
}

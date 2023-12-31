
public class SetMatrixZero {
    // initial solution using top down and bottom up iteration
    public void setZeroes(int[][] matrix) {
        int colStart = 1, rowLen = matrix.length, colLen = matrix[0].length;

        for (int i = 0; i < rowLen; i++) { // set states top-down
            if (matrix[i][0] == 0)
                colStart = 0;
            for (int j = 1; j < colLen; j++)
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
        }

        for (int i = rowLen - 1; i >= 0; i--) { // set states bottom-up
            for (int j = colLen - 1; j >= 1; j--)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            if (colStart == 0)
                matrix[i][0] = 0;
        }
    }

    // alternative but 1ms solution
    // public void setZeroes(int[][] matrix) {
    // boolean fr = false,fc = false;
    // for(int i = 0; i < matrix.length; i++) {
    // for(int j = 0; j < matrix[0].length; j++) {
    // if(matrix[i][j] == 0) {
    // if(i == 0) fr = true;
    // if(j == 0) fc = true;
    // matrix[0][j] = 0;
    // matrix[i][0] = 0;
    // }
    // }
    // }
    // for(int i = 1; i < matrix.length; i++) {
    // for(int j = 1; j < matrix[0].length; j++)
    // if(matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
    // }
    // if(fr)
    // for(int j = 0; j < matrix[0].length; j++) matrix[0][j] = 0;
    // if(fc)
    // for(int i = 0; i < matrix.length; i++) matrix[i][0] = 0;
    // }
}
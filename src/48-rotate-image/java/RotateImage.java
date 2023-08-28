public class RotateImage {
    // initial solution transponse and reverse still time O(n) and space O(1)
    // public void rotate(int[][] matrix) {
    // int rows = matrix.length;
    // int cols = matrix[0].length;
    // for (int i = 0; i < rows; i++) { // Transpose the matrix
    // for (int j = i; j < cols; j++) {
    // int temp = matrix[i][j];
    // matrix[i][j] = matrix[j][i];
    // matrix[j][i] = temp;
    // }
    // }
    // for (int i = 0; i < rows; i++) { // Reverse each row
    // for (int j = 0; j < cols / 2; j++) {
    // int temp = matrix[i][j];
    // matrix[i][j] = matrix[i][cols - 1 - j];
    // matrix[i][cols - 1 - j] = temp;
    // }
    // }
    // }

    // 4 way swap solution. time O(n) and space O(1)
    public void rotate(int[][] matrix) {
        int matLen = matrix.length;
        for (int layer = 0; layer < matLen / 2; layer++) { // from outer to inner layer
            int first = layer, last = matLen - 1 - layer;
            for (int i = first; i < last; i++) { // Iterate current layer
                int offset = i - first;
                int temp = matrix[first][i];
                matrix[first][i] = matrix[last - offset][first]; // Left -> Top
                matrix[last - offset][first] = matrix[last][last - offset]; // Bottom -> Left
                matrix[last][last - offset] = matrix[i][last]; // Right -> Bottom
                matrix[i][last] = temp; // Top -> Right
            }
        }
    }
}

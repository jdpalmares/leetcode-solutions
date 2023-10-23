
public class Search2DMatrix {
    //intuition answer
    // public boolean searchMatrix(int[][] matrix, int target) {
    //     if (matrix.length == 0 || matrix[0].length == 0) return false;

    //     int rowLen = matrix[0].length - 1, colLen = matrix.length - 1;

    //     for(int i = 0; i <= colLen; i++){
    //         int rowMax = matrix[i][rowLen];
    //         if (target == rowMax)
    //             return true;
    //         else if (target > rowMax)
    //             continue;
    //         else{
    //             int left = 0, right = rowLen;
    //             while(left < right){
    //                 int mid = left + (right - left)/2;
                    
    //                 if(matrix[i][mid] == target) return true;
    //                 else if(matrix[i][mid] > target) right = mid;
    //                 else left = mid + 1;
    //             }
    //             return false;
    //         }
    //     }
    //     return false;
    // }

    //fully binary search answer
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int rowLen = matrix[0].length, colLen = matrix.length, left = 0, right = colLen * rowLen - 1;

        while (left <= right) {
            int midIdx = left + (right - left) / 2;
            int midVal = matrix[midIdx / rowLen][midIdx % rowLen];

            if (midVal == target)
                return true;
            else if (midVal < target)
                left = midIdx + 1;
            else
                right = midIdx - 1;
        }
        return false;
    }
}

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    // Intuition O(n) solution using 4-pointers and arraylist
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;

        List<Integer> answer = new ArrayList<Integer>();
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) // Traverse top row
                answer.add(matrix[top][i]);
            top++; // update top value to avoid duplicate

            for (int i = top; i <= bottom; i++) // Traverse right column
                answer.add(matrix[i][right]);
            right--; // update right value to avoid duplicate

            if (top <= bottom) { // Traverse bottom row (if there are remaining rows)
                for (int i = right; i >= left; i--)
                    answer.add(matrix[bottom][i]);
                bottom--; // update bottom value to avoid duplicate
            }

            if (left <= right) { // Traverse left column (if there are remaining columns)
                for (int i = bottom; i >= top; i--)
                    answer.add(matrix[i][left]);
                left++; // update left value to avoid duplicate
            }
        }
        return answer;
    }
}

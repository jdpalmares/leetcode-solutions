
public class TwoSumSorted {
    // intuition answer but wrong will fail if numbers is too large
    // public int[] twoSum(int[] numbers, int target) {
    // int numLen = numbers.length;
    // int firstNumIdx = 0, secondNumIdx = 1;
    // int twoSum = numbers[firstNumIdx] + numbers[secondNumIdx];
    // while (twoSum != target) {
    // if (twoSum < target) {
    // secondNumIdx++;
    // } else {
    // firstNumIdx++;
    // secondNumIdx = firstNumIdx + 1;
    // }
    // if (secondNumIdx >= numLen) {
    // firstNumIdx++;
    // secondNumIdx = firstNumIdx + 1;
    // }
    // twoSum = numbers[firstNumIdx] + numbers[secondNumIdx];
    // }
    // return new int[] { firstNumIdx + 1, secondNumIdx + 1 };
    // }

    // two pointer solution from leftmost and rightmost num
    public int[] twoSum(int[] numbers, int target) {
        int firstNumIdx = 0, secondNumIdx = numbers.length - 1;

        while (numbers[firstNumIdx] + numbers[secondNumIdx] != target) {
            if (numbers[firstNumIdx] + numbers[secondNumIdx] < target)
                firstNumIdx++;
            else
                secondNumIdx--;
        }

        return new int[] { firstNumIdx + 1, secondNumIdx + 1 };

    }

    // binary search solution slower than two pointer
    // public int[] twoSum(int[] numbers, int target) {
    // for (int i = 0; i < numbers.length; ++i) {
    // int low = i + 1;
    // int high = numbers.length - 1;
    // while (low <= high) {
    // int mid = (high - low) / 2 + low;
    // if (numbers[mid] == target - numbers[i]) {
    // return new int[]{i + 1, mid + 1};
    // } else if (numbers[mid] > target - numbers[i]) {
    // high = mid - 1;
    // } else {
    // low = mid + 1;
    // }
    // }
    // }
    // return new int[]{-1, -1};
    // }

}

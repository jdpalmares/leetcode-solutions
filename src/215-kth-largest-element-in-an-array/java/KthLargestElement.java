
public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int i = left;
            for (int j = left + 1; j <= right; j++)
                if (nums[j] < nums[left]) swap(nums, j, ++i);
            swap(nums, left, i);

            if (k < i) right = i - 1;
            else if (k > i) left = i + 1;
            else return nums[i];
        }
        return -1;
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}

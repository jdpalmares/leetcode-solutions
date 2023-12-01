
public class FindMinRotSortArray {
    public int findMin(int[] nums) { //binary search
        int left = 0, right = nums.length - 1;

        while (left < right) {
            final int mid = (left + right) / 2;
            if (nums[mid] < nums[right]) right = mid;
            else left = mid + 1;
        }

        return nums[left];
    }
}

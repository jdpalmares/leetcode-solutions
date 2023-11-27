
public class FindFirstLastPosElemSortArray {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = findFirstLast(nums, target, true);
        ans[1] = findFirstLast(nums, target, false);
        return ans;
    }

    private int findFirstLast(int[] nums, int target, boolean isFirstIdx) {
        int idx = -1, left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target < nums[mid] || (isFirstIdx && target == nums[mid]))
                right = mid-1;
            else left = mid+1;
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }
}

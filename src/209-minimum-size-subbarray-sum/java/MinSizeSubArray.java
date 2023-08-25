public class MinSizeSubArray {
    // O(n) solution
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, numsLen = nums.length, ans = numsLen + 1;
        for (int j = 0; j < numsLen; ++j) {
            target -= nums[j];
            while (target <= 0) {
                ans = Math.min(ans, j - i + 1);
                target += nums[i++];
            }
        }
        return ans % (numsLen + 1);
    }

    // O(nlog(n)) solution but essentially slower
    // public int minSubArrayLen(int target, int[] nums) {
    // int i = 1, j = nums.length, min = 0;
    // while (i <= j) {
    // int mid = (i + j) / 2;
    // if (windowExist(mid, nums, target)) {
    // j = mid - 1;
    // min = mid;
    // } else
    // i = mid + 1;
    // }
    // return min;
    // }

    // private boolean windowExist(int size, int[] nums, int s) {
    // int sum = 0;
    // for (int i = 0; i < nums.length; i++) {
    // if (i >= size)
    // sum -= nums[i - size];
    // sum += nums[i];
    // if (sum >= s)
    // return true;
    // }
    // return false;
    // }
}

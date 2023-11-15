
public class HouseRobber {
    //DP and memoization solution (somehow more space efficient)
    public int rob(int[] nums) {
        int numLen = nums.length;
        if (numLen == 0) return 0;
        int[] memo = new int[numLen + 1];
        memo[0] = 0;
        memo[1] = nums[0];
        for (int i = 1; i < numLen; i++) {
            memo[i+1] = Math.max(memo[i], memo[i-1] + nums[i]);
        }
        return memo[numLen];
    }

    //memo solution but using only 2 ints same performance but somehow uses more memory
    // public int rob(int[] nums) {
    //     if (nums.length == 0) return 0;
    //     int ans = 0, prev = 0;
    //     for (int num : nums) {
    //         int temp = ans;
    //         ans = Math.max(prev + num, ans);
    //         prev = temp;
    //     }
    //     return ans;
    // }
}

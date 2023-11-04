
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int numLen = nums.length;
        if(numLen == 0) return -1;
        else if (numLen == 1) return nums[0];
        else {
            int ans = Integer.MIN_VALUE, currVal = 0;
        
            for (int i = 0; i < nums.length; i++) {
                currVal += nums[i];
                if (currVal > ans) ans = currVal;
                if (currVal < 0) currVal = 0;
            }
            
            return ans;
        }
    }
}

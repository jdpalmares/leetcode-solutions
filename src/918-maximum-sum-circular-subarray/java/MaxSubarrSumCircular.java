
public class MaxSubarrSumCircular {
    //kadane algorithm
    public int maxSubarraySumCircular(int[] nums) {
        int nonCircularSum = kadaneMaxSum(nums);
        int totalSum = 0;
        for(int i = 0; i < nums.length; i++){
            totalSum += nums[i];
            nums[i] = -nums[i];
        }
        int circularSum = totalSum + kadaneMaxSum(nums);
        if(circularSum == 0) return nonCircularSum;
        return Math.max(circularSum,nonCircularSum);
    }
    
    int kadaneMaxSum(int[] nums){
        int currentSum = nums[0];
        int maxSum = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(currentSum < 0) currentSum = 0;
            currentSum = nums[i] + currentSum;
            maxSum = Math.max(maxSum,currentSum);
        }
        return maxSum;
    }

    //understandable alt algo one pass
    // public int maxSubarraySumCircularOnePass(int[] nums) {
    //     int total = 0, maxSum = nums[0], curMax = 0, minSum = nums[0], curMin = 0;
    //     for (int num : nums) {
    //         curMax = Math.max(curMax + num, num);
    //         maxSum = Math.max(maxSum, curMax);
    //         curMin = Math.min(curMin + num, num);
    //         minSum = Math.min(minSum, curMin);
    //         total += num;
    //     }
    //     return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    // }
}

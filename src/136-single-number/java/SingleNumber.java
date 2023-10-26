public class SingleNumber {
    //intuition answer using hashmap
    // public int singleNumber(int[] nums) {
    //     int numLen = nums.length;
    //     if(numLen == 0) return -1;
    //     else if (numLen == 1) return nums[0];
    //     else {
    //         Map<Integer, Integer> ansStack = new HashMap<>();
    //         for(int i = 0; i < numLen; i++){
    //             if(ansStack.containsKey(nums[i]))
    //                 ansStack.remove(nums[i]);
    //             else
    //                 ansStack.put(nums[i], 1);
    //         }
    //         return ansStack.keySet().iterator().next();
    //     }
    // }
    //optimized solution using bit manipulation XOR
    public int singleNumber(int[] nums) {
        int numLen = nums.length;
        if(numLen == 0) return -1;
        else if (numLen == 1) return nums[0];
        else {
            int ans = 0;
            for(int i = 0; i < numLen; i++)
                ans ^= nums[i];
            return ans;
        }
    }
}
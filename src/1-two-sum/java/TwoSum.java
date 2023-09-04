import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    // brute force
    // public int[] twoSum(int[] nums, int target) {
    // int numsLen = nums.length;
    // for (int i = 0; i < numsLen - 1; i++) {
    // for (int j = i + 1; j < numsLen; j++) {
    // if (nums[i] + nums[j] == target) {
    // return new int[] { i, j };
    // }
    // }
    // }
    // return new int[] {};
    // }

    // optimal Answer using Map
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int numsLen = nums.length;

        for (int i = 0; i < numsLen; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i };
            }
            numMap.put(nums[i], i);
        }

        return new int[] {};
    }
}

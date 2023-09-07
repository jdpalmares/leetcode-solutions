import java.util.HashSet;
import java.util.Set;

public class LongestConsecSequence {
    // intuition answser
    // public int longestConsecutive(int[] nums) {
    // if (nums.length == 0)
    // return 0;

    // TreeSet<Integer> numbers = new TreeSet<>();
    // for (int i = 0; i < nums.length; i++)
    // numbers.add(nums[i]);

    // int currNum = numbers.pollFirst();
    // int ans = 1;
    // int tempAns = 1;
    // while (!numbers.isEmpty()) {
    // int temp = numbers.pollFirst();
    // if (Math.abs(temp - currNum) == 1) {
    // tempAns++;
    // } else {
    // ans = Math.max(ans, tempAns);
    // tempAns = 1;
    // }
    // currNum = temp;
    // }
    // ans = Math.max(ans, tempAns);
    // return ans;
    // }

    // alternative answser for loop set and array
    public int longestConsecutive(int[] nums) {
        int max = 0;

        Set<Integer> numSet = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++)
            numSet.add(nums[i]);

        for (int i = 0; i < nums.length; i++) {
            int count = 1;

            int num = nums[i]; // look left
            while (numSet.contains(--num)) {
                count++;
                numSet.remove(num);
            }

            num = nums[i]; // look right
            while (numSet.contains(++num)) {
                count++;
                numSet.remove(num);
            }

            max = Math.max(max, count);
        }

        return max;
    }
}

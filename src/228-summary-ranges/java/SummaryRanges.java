import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    // intuition answer
    // public List<String> summaryRanges(int[] nums) {
    // List<String> ans = new ArrayList<String>();

    // if (nums.length == 0)
    // return ans;
    // else if (nums.length == 1) {
    // ans.add("" + nums[0]);
    // return ans;
    // }

    // int start = nums[0], cont = start;
    // for (int i = 1; i < nums.length; i++) {
    // if (nums[i] - cont != 1) {
    // if (start != cont)
    // ans.add("" + start + "->" + cont);
    // else
    // ans.add("" + start);
    // start = nums[i];
    // }
    // cont = nums[i];
    // if (i == nums.length - 1) {
    // if (start != cont)
    // ans.add("" + start + "->" + cont);
    // else
    // ans.add("" + start);
    // start = nums[i];
    // }
    // }
    // return ans;
    // }

    // // alternative answer same time complexity less lines and space
    // public List<String> summaryRanges(int[] nums) {
    // List<String> ans = new ArrayList<String>();

    // for (int i = 0; i < nums.length; i++) {
    // int start = nums[i];
    // while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1])
    // i++;
    // if (start != nums[i])
    // ans.add("" + start + "->" + nums[i]);
    // else
    // ans.add("" + start);
    // }
    // return ans;
    // }

    // alternative answer less lines more efficient two pointer approach
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<String>();

        int start = 0, end = 0;
        for (int i = 0; i < nums.length; i++) {
            while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
                end++;
                i++;
            }
            if (start == end)
                ans.add(String.valueOf(nums[start]));
            else
                ans.add(nums[start] + "->" + nums[end]);
            end++;
            start = end;
        }
        return ans;
    }
}

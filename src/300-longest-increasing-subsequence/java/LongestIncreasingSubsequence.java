
public class LongestIncreasingSubsequence {
    //DP and Binary search O(nlogn) solution
    public int lengthOfLIS(int[] nums) {
        int[] seqBases = new int[nums.length];
        int ans = 0;
        for (int num : nums) {
            int left = 0, right = ans;
            while (left != right) {
                int mid = (left + right) / 2;
                if (seqBases[mid] < num) left = mid + 1;
                else right = mid;
            }
            seqBases[left] = num;
            if (left == ans) ++ans;
        }
        return ans;
    }
}

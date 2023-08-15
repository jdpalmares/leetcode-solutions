import java.util.Arrays;

public class ProdArrayExceptSelf {
    // dynamic programming solution
    public int[] productExceptSelf(int[] nums) {
        int inArrLen = nums.length;
        int ans[] = new int[inArrLen];
        Arrays.fill(ans, 1);
        int currentAnsValue = 1;
        for (int i = 0; i < inArrLen; i++) {
            ans[i] *= currentAnsValue;
            currentAnsValue *= nums[i];
        }
        currentAnsValue = 1;
        for (int i = inArrLen - 1; i >= 0; i--) {
            ans[i] *= currentAnsValue;
            currentAnsValue *= nums[i];
        }
        return ans;
    }

    // bruteForce multiply each time
    // public int[] productExceptSelf(int[] nums) {
    // int inArrLen = nums.length;
    // int ans[] = new int[inArrLen];
    // for(int i = 0; i < inArrLen; i++) {
    // int productAns = 1;
    // for(int j = 0; j < inArrLen; j++) {
    // if(i == j) continue;
    // productAns *= nums[j];
    // }
    // ans[i] = productAns;
    // }
    // return ans;
    // }

    // divide method limit 0 (can be optimized to catch 0?)
    // public int[] productExceptSelf(int[] nums) {
    // int inArrLen = nums.length;
    // int ans[] = new int[inArrLen];
    // int productAns = 1;
    // for (int i : nums) {
    // productAns *= i;
    // }
    // for (int i = 0; i < inArrLen; i++) {
    // ans[i] = productAns / nums[i];
    // }
    // return ans;
    // }

    // O(n) time without divide but additional space complexity
    // public int[] productExceptSelf(int[] nums) {
    // int inArrLen = nums.length;
    // int prefixArr[] = new int[inArrLen];
    // int suffixArr[] = new int[inArrLen];
    // prefixArr[0] = 1;
    // suffixArr[inArrLen - 1] = 1;

    // for (int i = 1; i < inArrLen; i++) {
    // prefixArr[i] = prefixArr[i - 1] * nums[i - 1];
    // }
    // for (int i = inArrLen - 2; i >= 0; i--) {
    // suffixArr[i] = suffixArr[i + 1] * nums[i + 1];
    // }

    // int ans[] = new int[inArrLen];
    // for (int i = 0; i < inArrLen; i++) {
    // ans[i] = prefixArr[i] * suffixArr[i];
    // }
    // return ans;
    // }
}

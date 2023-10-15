public class ClimbingStairs {
    //dynamic programming array solution
    // public int climbStairs(int n) {
    //     if (n == 0 || n == 1)
    //         return 1;
    //     int[] dpArr = new int[n+1];
    //     dpArr[0] = dpArr[1] = 1;
    //     for (int i = 2; i <= n; i++)
    //         dpArr[i] = dpArr[i-1] + dpArr[i-2];
    //     return dpArr[n];
    // }
    //dynamic programming space optimal
    public int climbStairs(int n) {
        if (n == 0 || n == 1)
            return 1;
        int prev = 1, curr = 1;
        for (int i = 2; i <= n; i++) {
            int temp = curr;
            curr = prev + curr;
            prev = temp;
        }
        return curr;
    }
}
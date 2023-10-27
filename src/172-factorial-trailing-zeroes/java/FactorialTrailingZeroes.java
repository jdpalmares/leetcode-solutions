
public class FactorialTrailingZeroes {
    //iterative solution
    public int trailingZeroes(int n) {
        int ans = 0;
        while (n != 0) {
            int temp = n / 5;
            ans += temp;
            n = temp;
        }
        return ans;
    }
    //recursive one liner
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}
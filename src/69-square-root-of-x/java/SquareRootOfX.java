
public class SquareRootOfX {
    //linear search using newton's method
    public int mySqrt(int x) {
        long ans = x;
        while (ans*ans > x)
            ans = (ans + x/ans) / 2;
        return (int) ans;
    }

    //binary search solution
    // public int mySqrt(int x) {
    //     if (x == 0) return 0;
    //     int left = 1, right = x;
    //     while (left <= right) {
    //         int mid = left + (right - left) / 2;
    //         if (mid == x / mid) return mid;
    //         else if (mid > x / mid) right = mid - 1;
    //         else left = mid + 1;
    //     }
    //     return right;
    // }
}

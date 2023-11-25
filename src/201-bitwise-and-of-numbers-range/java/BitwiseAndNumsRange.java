
public class BitwiseAndNumsRange {
    // solution using common prefix with a factor to record iteration
    public int rangeBitwiseAnd(int left, int right) {
        if(left == 0) return 0;
        int factor = 1;
        while(left != right){
            left >>= 1;
            right >>= 1;
            factor <<= 1;
        }
        return left * factor;
    }

    // Bitwise-AND of any two numbers will always produce a number less than or equal to the smaller number.
    public int rangeBitwiseAndMath(int left, int right) {
        while(right > left) right = right & right - 1;
        return left & right;
    }
}

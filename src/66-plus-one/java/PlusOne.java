public class PlusOne {
    //accepted answer
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    // intuition answer, will never be because length of number can be far greater than limit
    // public int[] plusOne(int[] digits) {
    //     int multiplier = 1;
    //     double ansNum = 0;
    //     for(int i = digits.length - 1; i >= 0; i--){
    //         int sub = digits[i] * multiplier;
    //         ansNum += sub;
    //         multiplier *= 10;
    //     }
    //     ansNum++;
    //     int ansLen = (int)(Math.log10(ansNum)+1);
    //     double divisor = Math.pow(10, ansLen - 1);
    //     int[] ans = new int[(int)ansLen];
    //     int modNum = 0;
    //     for(int i = 0; i < ansLen; i++){
    //         modNum *= 10;
    //         double divided = (ansNum / divisor);
    //         int digit = modNum == 0 ? (int) divided : (int) divided % modNum;
    //         ans[i] = digit;
    //         modNum += ans[i];
    //         divisor /= 10;
    //     }
    //     return ans;
    // }
}
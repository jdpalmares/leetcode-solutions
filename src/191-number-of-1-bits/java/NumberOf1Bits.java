
public class NumberOf1Bits {
    public int hammingWeight(int n) { //bitshift solution
        int oneCtr = 0;
        while(n!=0) {
            oneCtr = oneCtr + (n & 1);
            n = n>>>1;
        }
        return oneCtr;
    }

    // public int hammingWeight(int n) { //logical OR solution
	// 	int oneCtr = 0;
	// 	while (n != 0) {
    //         n &= (n - 1);
    //         ++oneCtr;
    //     }
    //     return oneCtr;
    // }
}

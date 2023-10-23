class PowXN {
    //intuition answer
    // public double myPow(double x, int n) {
    //     double ans = 1;
    //     if(n == 0) return ans;
    //     else {
    //         if(n < 0){
    //             n = -n;
    //             x = 1 / x;
    //         }

    //         while(n > 0){
    //             ans *= x;
    //             n--;
    //         }
    //         return ans;
    //     }
    // }

    //more optimal solution using greedy algo
    public double myPow(double x, int n) {
        double ans = 1;
        if(n == 0) return ans;
        else {
            if(n < 0){
                n = -n;
                x = 1 / x;
            }

            while(n != 0){
                if((n & 1) != 0)
                    ans *= x;
                x *= x;
                n >>>= 1;
            }
            return ans;
        }
    }

    //concise solution bit a bit slower due to recursion
    // public double myPow(double x, int n) {
    //     if(n == 0)
    //         return 1;
    //     if(n<0){
    //         return 1/x * myPow(1/x, -(n + 1));
    //     }
    //     return (n%2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    // }
}
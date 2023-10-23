//solution based on java optimal solution
function myPow(x: number, n: number): number {
    let ans : number = 1;
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
};

//solution based on typescript library (Faster)
// function myPow(x: number, n: number): number {
//     return Math.pow(x,n)
// };
function trailingZeroes(n: number): number { //iterative
    let ans : number = 0;
    while (n != 0) {
        let temp : number = Math.floor(n / 5);
        ans += temp;
        n = temp;
    }
    return ans;
};

function trailingZeroes(n: number): number { //recursive
    if(n === 0) return 0;
    const tempNum : number = Math.floor(n / 5);
    return tempNum + trailingZeroes(tempNum);
};
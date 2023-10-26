function singleNumber(nums: number[]): number {
    let numLen : number = nums.length;
    if(numLen == 0) return -1;
    else if (numLen == 1) return nums[0];
    else {
        let ans : number = 0;
        for(let i : number = 0; i < numLen; i++)
            ans ^= nums[i];
        return ans;
    }
};
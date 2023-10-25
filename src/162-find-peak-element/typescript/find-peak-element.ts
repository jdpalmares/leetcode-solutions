function findPeakElement(nums: number[]): number { // solution based on java solution
    const numLen : number = nums.length;
    if(numLen == 0) return -1;
    else if(numLen == 1) return 0;
    else {
        if(nums[0] > nums[1]) return 0;
        if(nums[numLen-1] > nums[numLen-2]) return numLen-1;

        let start : number = 1;
        let end : number = numLen - 2;

        while(start <= end) {
            let mid : number = Math.floor(start + (end - start)/2);
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) return mid;
            else if(nums[mid] < nums[mid-1]) end = mid - 1;
            else if(nums[mid] < nums[mid+1]) start = mid + 1;
        }
    }
    return -1;
};

function findPeakElement(nums: number[]): number { //simpler solution
    let left : number = 0;
    let right : number = nums.length - 1;

    while (left < right) {
        const mid = Math.floor((left + right) / 2);
        if (nums[mid] > nums[mid + 1]) right = mid;
        else  left = mid + 1;
    }

    return left;
}
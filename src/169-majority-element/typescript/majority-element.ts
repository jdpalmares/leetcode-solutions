function majorityElement(nums: number[]): number {
    let ans;
    let ctr = 0;
    
    // Using boyer-moor majority vote algo
    // https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm
    for (const num of nums) {
        if (ctr === 0) {
            ans = num;
        }
        ctr += (num === ans) ? 1 : -1
    }
    return ans;
    // Alternative solutions can be:
    // Sort the array and return the median element time and space is O(n log n)
    // Use a hashmap and store count of each element, then check if entry count is >n/2
    // time complexity is O(n) but space is a lot more significant
};
function largestNumber(nums: number[]): string {
    const ans = nums.map(String).sort((a, b) => {
        return a.concat(b) > b.concat(a) ? -1 : 1;
    }).join('');

    return ans.charAt(0) === '0' ? '0' : ans;
};

//javascript solution
// var largestNumber = function(nums) {
//     nums.sort((a,b)=>{
//         let stringA = a.toString()
//         let stringB = b.toString()
//         return parseInt(stringA + stringB) > parseInt(stringB + stringA) ? -1 : 1
//     })
//     return (nums[0] === 0) ? '0' : nums.join('')
// };
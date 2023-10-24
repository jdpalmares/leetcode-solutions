// function minimumTotal(triangle: number[][]): number { //solution based on DP with O(1)
//     if (triangle.length === 1)
//         return triangle[0][0];
//     for (let level: number = triangle.length - 2; level >= 0; level--) {
//         for (let col: number = 0; col < triangle[level].length; col++)
//             triangle[level][col] += Math.min(triangle[level + 1][col], triangle[level + 1][col + 1]);
//     }
    
//     return triangle[0][0];
// };

function minimumTotal(triangle: number[][]): number { //solution based on DP with extra space
    const ans: number[] = new Array(triangle.length + 1).fill(0);

    for (let i = triangle.length - 1; i >= 0; i--) {
        for (let j = 0; j < triangle[i].length; j++)
            ans[j] = Math.min(ans[j], ans[j + 1]) + triangle[i][j];
    }

    return ans[0];
};
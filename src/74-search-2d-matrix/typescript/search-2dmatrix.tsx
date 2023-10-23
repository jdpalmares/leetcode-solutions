//solution based on java optimal solution
// function searchMatrix(matrix: number[][], target: number): boolean {
//     if (matrix.length === 0 || matrix[0].length === 0) return false;
//     const rowLen = matrix[0].length, colLen = matrix.length;
//     let left = 0, right = colLen * rowLen - 1;

//     while (left <= right) {
//         const midIdx = Math.floor(left + (right - left) / 2);
//         const midVal = matrix[Math.floor(midIdx / rowLen)][midIdx % rowLen];

//         if (midVal == target)
//             return true;
//         else if (midVal < target)
//             left = midIdx + 1;
//         else
//             right = midIdx - 1;
//     }
//     return false;
// };
//solution based on intuition answer faster because it is not using math.floor
function searchMatrix(matrix: number[][], target: number): boolean {
    let matLen = matrix.length - 1, foundRowIndex = matLen;
    for (let i = 0; i < matLen; i++) {
        if (target >= matrix[i][0] && target < matrix[i + 1][0]) {
            foundRowIndex = i;
            break;
        }
    }
    for (let i = 0; i < matrix[foundRowIndex].length; i++)
        if (matrix[foundRowIndex][i] === target) return true;
    return false;
};
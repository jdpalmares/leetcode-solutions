
public class ContainerWithMostWater {
    // intuition answer
    // public int maxArea(int[] height) {
    // int ans = 0, arrLen = height.length - 1;
    // int leftSideIdx = 0, rightSideIdx = arrLen;
    // while (leftSideIdx < rightSideIdx) {
    // int leftWall = height[leftSideIdx], rightWall = height[rightSideIdx];
    // ans = Math.max(ans, Math.min(leftWall, rightWall) * (rightSideIdx -
    // leftSideIdx));
    // if (leftWall < rightWall)
    // leftSideIdx++;
    // else if (leftWall > rightWall)
    // rightSideIdx--;
    // else {
    // leftSideIdx++;
    // rightSideIdx--;
    // }
    // }
    // return ans;
    // }

    // faster runtime checking for walls but still O(n)
    public int maxArea(int[] height) {
        int ans = 0, arrLen = height.length - 1;
        int leftSideIdx = 0, rightSideIdx = arrLen;
        while (leftSideIdx < rightSideIdx) {
            int leftWall = height[leftSideIdx], rightWall = height[rightSideIdx];
            ans = Math.max(ans, Math.min(leftWall, rightWall) * (rightSideIdx - leftSideIdx));
            if (leftWall < rightWall) {
                while (height[leftSideIdx] <= leftWall && leftSideIdx < rightSideIdx)
                    leftSideIdx++;
            } else {
                while (height[rightSideIdx] <= rightWall && leftSideIdx < rightSideIdx)
                    rightSideIdx--;
            }
        }
        return ans;
    }
}

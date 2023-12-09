
public class TrapRainWater {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = height[0], rightMax = height[height.length - 1];
        int ans = 0;
        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                if (leftMax < height[left]) leftMax = height[left];
                else ans += leftMax - height[left];
            } else {
                right--;
                if (rightMax < height[right]) rightMax = height[right];
                else ans += rightMax - height[right];
            }
        }
        return ans;
    }
}

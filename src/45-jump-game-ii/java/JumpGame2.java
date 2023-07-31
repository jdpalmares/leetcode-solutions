class JumpGame {
    public int jump(int[] nums) {
        int jumpCtr = 0, maxHeight = 0, maxJump = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxJump = Math.max(maxJump, i + nums[i]);
            if (i == maxHeight) {
                maxHeight = maxJump;
                jumpCtr++;
            }
        }
        return jumpCtr;
    }
}
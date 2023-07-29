class JumpGame {
    public boolean canJump(int[] nums) {
        // basic but effective solution to check each level
        // int currMaxJump = 0;
        // for(int i = 0; i < nums.length; i ++) {
        // if(i > currMaxJump) return false;
        // currMaxJump = Math.max(currMaxJump, i + nums[i]);
        // }
        // return true;

        // check if max jump is over array length. more efficient
        int maxJump = 0;
        for (int i = 0; i <= maxJump; i++) {
            maxJump = Math.max(maxJump, i + nums[i]);
            if (maxJump >= nums.length - 1)
                return true;
        }
        return false;
    }
}
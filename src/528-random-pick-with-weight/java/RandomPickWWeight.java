import java.util.Random;

public class RandomPickWWeight {

    private int[] nums;
    private int total;
    private Random randomizer;

    public RandomPickWWeight(int[] w) {
        this.randomizer = new Random();

        for (int i = 1; i < w.length; i++)
            w[i] += w[i - 1];

        this.nums = w;
        this.total = w[w.length - 1];
    }
    
    public int pickIndex() {
        if (this.total == 0) return -1;

        int n = this.randomizer.nextInt(this.total) + 1;

        int left = 0, right = this.nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (this.nums[mid] == n) return mid;
            else if (this.nums[mid] < n) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}

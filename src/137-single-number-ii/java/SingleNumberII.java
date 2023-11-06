
public class SingleNumberII {
    //solution using bit manipulation of every 32bit integer value and input
    // public int singleNumber(int[] nums) {
    //     int ans = 0;
    //     for(int i = 0; i < 32; i++){
    //         int sum = 0;
    //         for(int num : nums) sum += (num >> i) & 1;
    //         sum %= 3;
    //         ans |= sum << i;
    //     }
    //     return ans;
    // }
    //solution using bitwise operator for every input
    public int singleNumber(int[] nums) {
        int once = 0;
        int twice = 0;

        for (int num : nums) {
            once ^= (num & ~twice);
            twice ^= (num & ~once);
        }

        return once;
    }
}

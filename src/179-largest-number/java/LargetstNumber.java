import java.util.Arrays;

public class LargetstNumber {
    //3-line solution using streams library and lambda to sort and reduce 0 but slower
    // public String largestNumber(int[] nums) {
    //     String[] numStrs = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
    //     Arrays.sort(numStrs, (String a, String b) -> (b + a).compareTo(a + b));
    //     return Arrays.stream(numStrs).reduce((x, y) -> x.equals("0") ? y : x + y).get();
    // }

    //intuition answer to convert to string, compare as string, check for 0 and append
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return "";

        String[] numStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            numStrs[i] = Integer.toString(nums[i]);
        Arrays.sort(numStrs,(a,b)->(b+a).compareTo(a+b));

        if (numStrs[0].charAt(0) == '0')
            return "0";
        StringBuilder ans = new StringBuilder();
        for(String s:numStrs)
            ans.append(s);
        return ans.toString();
    }
}

import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String firstAscStr = strs[0];
        String lastAscStr = strs[strs.length - 1];
        int lcpIndex = 0;
        while (lcpIndex < firstAscStr.length() && lcpIndex < lastAscStr.length()) {
            if (firstAscStr.charAt(lcpIndex) == lastAscStr.charAt(lcpIndex))
                lcpIndex++;
            else
                break;
        }
        return firstAscStr.substring(0, lcpIndex);
    }
}

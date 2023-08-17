
public class LastWordLength {
    // intuition solution use built in methods
    // public int lengthOfLastWord(String s) {
    // String[] sArr = s.trim().split(" ");
    // return sArr[sArr.length - 1].length();
    // }

    // more optimal solution manually count and skip spaces
    public int lengthOfLastWord(String s) {
        int ans = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ')
                ans++;
            else if (ans > 0)
                return ans;
        }
        return ans;
    }
}


public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int i = 0, curTIdx = 0;
        while (i < s.length()) {
            curTIdx = t.indexOf(s.charAt(i), curTIdx);
            if (curTIdx == -1)
                return false;
            else {
                i++;
                curTIdx++;
            }
        }
        // in case not all of s's characters are exhausted while it went past through t
        if (curTIdx > t.length())
            return false;
        return true;
    }
}


public class ValidPalindrome {
    // intuition answer two pointer no extra memory O(n) time complexity
    public boolean isPalindrome(String s) {
        if (s.isEmpty())
            return true;
        int strLen = s.length() - 1;
        for (int i = 0, j = strLen; i < strLen && j > 0; i++, j--) {
            if (i == j)
                return true;
            else {
                // Alternatively for interviews w/ no external references
                // use Character.isLetterOrDigit()
                while (!isAlphaNumberic(s.charAt(i)) && i < strLen)
                    i++;
                while (!isAlphaNumberic(s.charAt(j)) && j > 0)
                    j--;
                if (i == strLen && j == 0)
                    return true;
                if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                    return false;
            }
        }
        return true;
    }

    public boolean isAlphaNumberic(char c) {
        int codePoint = (int) c; // Unicode code point, faster than string or char compare
        return (codePoint >= 48 && codePoint <= 57) || // Digits 0-9
                (codePoint >= 65 && codePoint <= 90) || // Uppercase letters A-Z
                (codePoint >= 97 && codePoint <= 122); // Lowercase letters a-z
    }
}

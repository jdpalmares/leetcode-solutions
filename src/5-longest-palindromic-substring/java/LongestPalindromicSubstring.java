
public class LongestPalindromicSubstring {
    //Manacher's Algorithm (a lot faster but more complex)
    //based on https://leetcode.cn/problems/longest-palindromic-substring/solutions/255195/zui-chang-hui-wen-zi-chuan-by-leetcode-solution/
    public String longestPalindrome(String s) {
        int strLen = 2 * s.length() + 3;
        char[] sChars = new char[strLen];

        sChars[0] = '@';
        sChars[strLen - 1] = '$';
        int t = 1;
        for (char c : s.toCharArray()) {
            sChars[t++] = '#';
            sChars[t++] = c;
        }
        sChars[t] = '#';

        int maxLen = 0;
        int start = 0;
        int maxRight = 0;
        int center = 0;
        int[] p = new int[strLen];
        for (int i = 1; i < strLen - 1; i++) {
            if (i < maxRight)
                p[i] = Math.min(maxRight - i, p[2 * center - i]);

            while (sChars[i + p[i] + 1] == sChars[i - p[i] - 1])
                p[i]++;

            if (i + p[i] > maxRight) {
                center = i;
                maxRight = i + p[i];
            }

            if (p[i] > maxLen) {
                start = (i - p[i] - 1) / 2;
                maxLen = p[i];
            }
        }

        return s.substring(start, start + maxLen);
    }

    //DP 2 pointer solution (slower but simpler)
    // private int left, rightMost;
    // public String longestPalindrome(String s) {
    //     int len = s.length();
    //     if (len < 2) return s;
        
    //     for (int i = 0; i < len-1; i++) {
    //         extendPalindrome(s, i, i);
    //         extendPalindrome(s, i, i + 1);
    //     }
    //     return s.substring(left, left + rightMost);
    // }
    // private void extendPalindrome(String s, int j, int right) {
    //     while (j >= 0 && right < s.length() && s.charAt(j) == s.charAt(right)) {
    //         j--;
    //         right++;
    //     }
    //     if (rightMost < right - j - 1) {
    //         left = j + 1;
    //         rightMost = right - j - 1;
    //     }
    // }
}

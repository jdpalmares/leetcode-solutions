
public class InterleavingString {
    //orig solution using dfs (can also use class variables for simplification but will more space)
    // public boolean isInterleave(String s1, String s2, String s3) {
    //     char[] c1 = s1.toCharArray(), c2 = s2.toCharArray(), c3 = s3.toCharArray();
    //     int m = s1.length(), n = s2.length();
    //     if(m + n != s3.length()) return false;
    //     return dfs(c1, c2, c3, 0, 0, 0, new boolean[m + 1][n + 1]);
    // }

    // public boolean dfs(char[] c1, char[] c2, char[] c3, int i, int j, int k, boolean[][] invalid) {
    //     if(invalid[i][j]) return false;
    //     if(k == c3.length) return true;
    //     boolean valid =
    //         i < c1.length && c1[i] == c3[k] && dfs(c1, c2, c3, i + 1, j, k + 1, invalid) ||
    //         j < c2.length && c2[j] == c3[k] && dfs(c1, c2, c3, i, j + 1, k + 1, invalid);
    //     if(!valid) invalid[i][j] = true;
    //     return valid;
    // }

    //same solution without additional space in the charArrays (surpsingly still the same time complexity with less space)
    public boolean isInterleave(String s1, String s2, String s3) {
        int s1Len = s1.length(), s2Len = s2.length();
        if(s1Len + s2Len != s3.length()) return false;
        return dfs(s1, s2, s3, 0, 0, 0, new boolean[s1Len + 1][s2Len + 1]);
    }

    public boolean dfs(String s1, String s2, String s3, int i, int j, int k, boolean[][] invalid) {
        if(invalid[i][j]) return false;
        if(k == s3.length()) return true;
        boolean valid =
            i < s1.length() && s1.charAt(i) == s3.charAt(k) && dfs(s1, s2, s3, i + 1, j, k + 1, invalid) ||
            j < s2.length() && s2.charAt(j) == s3.charAt(k) && dfs(s1, s2, s3, i, j + 1, k + 1, invalid);
        if(!valid) invalid[i][j] = true;
        return valid;
    }
}

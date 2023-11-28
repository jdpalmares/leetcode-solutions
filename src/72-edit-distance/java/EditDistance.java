
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int word1Len = word1.length(), word2Len = word2.length();
        int[][] dp = new int[word1Len + 1][word2Len + 1];
    
        for (int i = 1; i <= word1Len; ++i) dp[i][0] = i;
        for (int j = 1; j <= word2Len; ++j) dp[0][j] = j;
    
        for (int i = 1; i <= word1Len; ++i)
            for (int j = 1; j <= word2Len; ++j)
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else {
                    int replaceCh = dp[i - 1][j - 1], deleteCh = dp[i - 1][j], insertCh = dp[i][j - 1];
                    dp[i][j] = Math.min(replaceCh, Math.min(deleteCh, insertCh)) + 1;
                }
        return dp[word1Len][word2Len];
    }
}

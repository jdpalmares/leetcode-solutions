import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        
        return dpDFS(s, 0, wordDict, dp);
    }

    private boolean dpDFS(String s, int index, List<String> wordDict, int[] dp) {
        if (index >= s.length()) return true;
        
        if (dp[index] != -1) return dp[index] == 1;
        
        int match = 0;
        for (int i = 0; i < wordDict.size(); i++) {
            String word = wordDict.get(i);
            if (s.startsWith(word, index) && dpDFS(s, index + word.length(), wordDict, dp)) {
                match = 1;
                break;
            }
        }
        
        dp[index] = match;
        
        return match == 1;
    }
}

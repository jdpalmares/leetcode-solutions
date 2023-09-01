import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    // intuition answer
    // public boolean wordPattern(String pattern, String s) {
    // String[] words = s.split(" ");
    // if (pattern.length() != words.length)
    // return false;
    // Map<Character, String> charDic = new HashMap<Character, String>();
    // for (int i = 0; i < pattern.length(); i++) {
    // char c = pattern.charAt(i);
    // String word = words[i];
    // if (!charDic.containsKey(c)) {
    // if (charDic.containsValue(word))
    // return false;
    // else
    // charDic.put(c, word);
    // } else {
    // if (!charDic.get(c).equals(word))
    // return false;

    // }
    // }
    // return true;
    // }

    // more efficient solution
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length())
            return false;
        Map<Object, Integer> wordPatIdxMAp = new HashMap<Object, Integer>();
        for (Integer i = 0; i < words.length; ++i)
            if (wordPatIdxMAp.put(pattern.charAt(i), i) != wordPatIdxMAp.put(words[i], i))
                return false;
        return true;
    }
}

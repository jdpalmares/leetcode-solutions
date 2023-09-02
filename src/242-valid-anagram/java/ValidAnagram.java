public class ValidAnagram {
    // intuition answer can get beyond english alphabet
    // public boolean isAnagram(String s, String t) {
    // if (s.length() != t.length())
    // return false;
    // Map<Character, Integer> charCtrMap = new HashMap<Character, Integer>();
    // // setup s map
    // for (int i = 0; i < s.length(); i++) {
    // char c = s.charAt(i);
    // if (!charCtrMap.containsKey(c)) {
    // charCtrMap.put(c, 1);
    // } else {
    // charCtrMap.replace(c, charCtrMap.get(c) + 1);
    // }
    // }
    // // iterate through t
    // for (int i = 0; i < t.length(); i++) {
    // char c = t.charAt(i);
    // if (!charCtrMap.containsKey(c)) {
    // return false;
    // } else {
    // int count = charCtrMap.get(c) - 1;
    // if (count < 0)
    // return false;
    // charCtrMap.replace(c, count);
    // }
    // }
    // return true;
    // }

    // efficient answer
    public boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        if (s.length() != t.length())
            return false;
        int arrLen = s.length();
        for (int i = 0; i < arrLen; i++) {
            alphabet[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < arrLen; i++) {
            char c = t.charAt(i);
            alphabet[c - 'a']--;
            if (alphabet[c - 'a'] < 0)
                return false;
        }
        return true;
    }
}

import java.util.HashMap;

public class MinWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() ==0 || t.length() == 0 || s.length() < t.length())
            return new String();
        int[] map = new int[128];
        int count = t.length();
        int start = 0, end = 0, minLen = Integer.MAX_VALUE,startIndex =0;
        for (char c :t.toCharArray()) map[c]++;
        char[] chS = s.toCharArray();
        while (end < chS.length) {
            if (map[chS[end++]]-- >0) count--;
            while (count == 0) {
                if (end - start < minLen) {
                    startIndex = start;
                    minLen = end - start;
                }
                if (map[chS[start++]]++ == 0) count++;
            }
        }

        return minLen == Integer.MAX_VALUE ? new String() : new String(chS,startIndex,minLen);
    }

    //sliding window approach (slower but easier to understand)
    public String minWindowSliding(String s, String t) {
        HashMap<Character, Integer> mp = new HashMap<>();

        int ans = Integer.MAX_VALUE, start = 0;

        for (char c : t.toCharArray())
            mp.put(c, mp.getOrDefault(c, 0) + 1);

        int count = mp.size();

        int i = 0, j = 0;

        while (j < s.length()) {
            mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j), 0) - 1);
            if (mp.get(s.charAt(j)) == 0) count--;

            if (count == 0) {
                while (count == 0) {
                    if (ans > j - i + 1) {
                        ans = j - i + 1;
                        start = i;
                    }
                    mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0) + 1);
                    if (mp.get(s.charAt(i)) > 0) count++;

                    i++;
                }
            }
            j++;
        }
        if (ans != Integer.MAX_VALUE) return s.substring(start, start + ans);
        else return "";
    }
}
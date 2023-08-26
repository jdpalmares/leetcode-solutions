public class LongestSubStringNoRepeatChar {
    // optimal O(n) solution using charAt value array
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int[] charAtArr = new int[256];
        for (int i = 0, j = 0; i < s.length(); i++) {
            j = Math.max(j, charAtArr[s.charAt(i)]);
            charAtArr[s.charAt(i)] = i + 1;
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }

    // // sliding O(n) solution using HashMap
    // public int lengthOfLongestSubstring(String s) {
    // if (s.length() == 0)
    // return 0;
    // HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    // int max = 0;
    // for (int i = 0, j = 0; i < s.length(); ++i) {
    // if (map.containsKey(s.charAt(i))) {
    // j = Math.max(j, map.get(s.charAt(i)) + 1);
    // }
    // map.put(s.charAt(i), i);
    // max = Math.max(max, i - j + 1);
    // }
    // return max;
    // }

    // // alternative sliding O(n) solution using HashSet
    // public int lengthOfLongestSubstring(String s) {
    // int i = 0, j = 0, max = 0;
    // Set<Character> set = new HashSet<>();

    // while (j < s.length()) {
    // if (!set.contains(s.charAt(j))) {
    // set.add(s.charAt(j++));
    // max = Math.max(max, set.size());
    // } else {
    // set.remove(s.charAt(i++));
    // }
    // }

    // return max;
    // }
}

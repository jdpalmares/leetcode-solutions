
public class RansomNote {
    // intuition answer slow
    // public boolean canConstruct(String ransomNote, String magazine) {
    // if (ransomNote.length() > magazine.length()) return false;
    // for (int i = 0; i < ransomNote.length(); i++) {
    // char c = ransomNote.charAt(i);
    // if (!magazine.contains(String.valueOf(c)))
    // return false;
    // else
    // magazine = magazine.replaceFirst(String.valueOf(c), "");
    // }
    // return true;
    // }

    // efficient answer using alphabet counter
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length())
            return false;
        int[] chatCr = new int[26];

        for (char c : magazine.toCharArray())
            chatCr[c - 'a']++;

        for (char c : ransomNote.toCharArray()) {
            if (chatCr[c - 'a'] == 0)
                return false;
            chatCr[c - 'a']--;
        }
        return true;
    }
}

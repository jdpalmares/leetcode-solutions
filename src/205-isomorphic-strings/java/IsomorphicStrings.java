
public class IsomorphicStrings {
    // clear solution using ascii maps and asign its index
    public boolean isIsomorphic(String s, String t) {
        int asciiMapS[] = new int[200];
        int asciiMapT[] = new int[200];

        for (int i = 0; i < s.length(); i++) {
            if (asciiMapS[s.charAt(i)] != asciiMapT[t.charAt(i)]) // check if it was assigned before
                return false;
            // assign index of those characters
            asciiMapS[s.charAt(i)] = i + 1;
            asciiMapT[t.charAt(i)] = i + 1;
        }
        return true;
    }

    // same runtime lesser space since it uses only one map
    // public boolean isIsomorphic(String s, String t) {
    // int[] asciiMap = new int[512];
    // for (int i = 0; i < s.length(); i++) {
    // if (asciiMap[s.charAt(i)] != asciiMap[t.charAt(i) + 256])
    // return false;
    // asciiMap[s.charAt(i)] = asciiMap[t.charAt(i) + 256] = i + 1;
    // }
    // return true;
    // }
}

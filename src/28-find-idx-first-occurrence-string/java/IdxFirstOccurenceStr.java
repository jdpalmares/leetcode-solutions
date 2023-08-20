
public class IdxFirstOccurenceStr {
    // intuition using existing libraries
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    // other solution without libraries lower memory higher runtime
    // public int strStr(String haystack, String needle) {
    // for (int i = 0;; i++) {
    // for (int j = 0;; j++) {
    // if (j == needle.length())
    // return i;
    // if (i + j == haystack.length())
    // return -1;
    // if (needle.charAt(j) != haystack.charAt(i + j))
    // break;
    // }
    // }
    // }
}

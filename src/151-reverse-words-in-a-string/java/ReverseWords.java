public class ReverseWords {
    // intuition answer
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            StringBuilder subWord = new StringBuilder();
            boolean wordFound = false;
            while (i >= 0 && s.charAt(i) != ' ') {
                wordFound = true;
                subWord.append(s.charAt(i));
                i--;
            }
            if (wordFound) {
                ans.append(subWord.reverse() + " ");
            }
        }
        ans.deleteCharAt(ans.length() - 1);
        return ans.toString();
    }

    /*
     * //meticulous but faster solution
     * public String reverseWords(String s) {
     * if (s == null)
     * return null;
     *
     * char[] a = s.toCharArray();
     * int n = a.length;
     *
     * reverse(a, 0, n - 1);
     * reverseWords(a, n);
     * return cleanSpaces(a, n);
     * }
     *
     * void reverseWords(char[] a, int n) {
     * int i = 0, j = 0;
     *
     * while (i < n) {
     * while (i < j || i < n && a[i] == ' ')
     * i++;
     * while (j < i || j < n && a[j] != ' ')
     * j++;
     * reverse(a, i, j - 1);
     * }
     * }
     *
     * String cleanSpaces(char[] a, int n) {
     * int i = 0, j = 0;
     *
     * while (j < n) {
     * while (j < n && a[j] == ' ')
     * j++;
     * while (j < n && a[j] != ' ')
     * a[i++] = a[j++];
     * while (j < n && a[j] == ' ')
     * j++;
     * if (j < n)
     * a[i++] = ' ';
     * }
     *
     * return new String(a).substring(0, i);
     * }
     *
     * private void reverse(char[] a, int i, int j) {
     * while (i < j) {
     * char t = a[i];
     * a[i++] = a[j];
     * a[j--] = t;
     * }
     * }
     */
}

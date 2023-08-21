
public class ZigzagConversion {
    // solution regarding cycling through formula 2n-2 using stringbuilder
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        int cycle = numRows * 2 - 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            // System.out.println("i value = " + i);
            for (int j = i, k = cycle - i; j < s.length(); j += cycle, k += cycle) {
                // System.out.println("j value = " + j);
                // System.out.println("k value = " + i);
                sb.append(s.charAt(j));
                // System.out.println("sb append j");
                // 1st row, i = 0; last row, j == k; avoid duplicate addition
                if (i != 0 && j != k && k < s.length()) {
                    // System.out.println("sb append at k value = " + k);
                    sb.append(s.charAt(k));
                }
            }
        }
        return sb.toString();
    }

    // faster and more efficient solution 2n-2 charArray and pointer
    // public String convert(String s, int numRows) {
    // if (numRows == 1)
    // return s;
    // int cycle = numRows * 2 - 2;
    // char[] charArray = new char[s.length()];
    // int pointer = 0;
    // // 1st row
    // for (int i = 0; i < s.length(); i += cycle) {
    // // System.out.println("i value first row = " + i);
    // // System.out.println("pointer value = " + pointer);
    // charArray[pointer] = s.charAt(i);
    // pointer++;
    // }
    // // middle rows
    // for (int i = 1; i < numRows - 1; i++) {
    // // System.out.println("i value middle rows = " + i);
    // for (int j = i, k = cycle - j; j < s.length(); j += cycle, k += cycle) {
    // // System.out.println("j value middle rows = " + j);
    // // System.out.println("pointer value = " + pointer);
    // charArray[pointer] = s.charAt(j);
    // pointer++;
    // if (k < s.length()) { // for the zigzag parts
    // // System.out.println("k value middle rows = " + k);
    // // System.out.println("pointer value = " + pointer);
    // charArray[pointer] = s.charAt(k);
    // pointer++;
    // }
    // }
    // }
    // // last row
    // for (int i = numRows - 1; i < s.length(); i += cycle) {
    // // System.out.println("i value last row = " + i);
    // // System.out.println("pointer value = " + pointer);
    // charArray[pointer] = s.charAt(i);
    // pointer++;
    // }
    // return String.valueOf(charArray);
    // }
}

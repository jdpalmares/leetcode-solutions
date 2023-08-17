public class RomanToInt {
    public int romanToInt(String s) {
        int ans = 0, charVal = 0, prevCVal = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'M' -> charVal = 1000;
                case 'D' -> charVal = 500;
                case 'C' -> charVal = 100;
                case 'L' -> charVal = 50;
                case 'X' -> charVal = 10;
                case 'V' -> charVal = 5;
                case 'I' -> charVal = 1;
            }
            if (charVal < prevCVal) {
                ans -= charVal;
            } else {
                ans += charVal;
            }
            prevCVal = charVal;
        }
        return ans;
    }
    // cooler switch implementation but takes up a lot of memory
    // public int romanToInt(String s) {
    // int ans = 0, prevCVal = 0;
    // for (int i = s.length() - 1; i >= 0; i--) {
    // int charVal = switch (s.charAt(i)) {
    // case 'M' -> 1000;
    // case 'D' -> 500;
    // case 'C' -> 100;
    // case 'L' -> 50;
    // case 'X' -> 10;
    // case 'V' -> 5;
    // case 'I' -> 1;
    // default -> 0;
    // };
    // if (charVal < prevCVal)
    // ans -= charVal;
    // else
    // ans += charVal;
    // prevCVal = charVal;
    // }
    // return ans;
    // }

    // better space implementation albeit allegedly slower
    // public int romanToInt(String s) {
    // int ans = 0;
    // for (int i = s.length() - 1; i >= 0; i--) {
    // int charVal = switch (s.charAt(i)) {
    // case 'M' -> 1000;
    // case 'D' -> 500;
    // case 'C' -> 100;
    // case 'L' -> 50;
    // case 'X' -> 10;
    // case 'V' -> 5;
    // case 'I' -> 1;
    // default -> 0;
    // };
    // if (4 * charVal < ans)
    // ans -= charVal;
    // else
    // ans += charVal;
    // }
    // return ans;
    // }
}
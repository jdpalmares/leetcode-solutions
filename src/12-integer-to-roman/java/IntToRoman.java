
public class IntToRoman {
    // hacky string array solution
    // public String intToRoman(int num) {
    // String thousands[] = { "", "M", "MM", "MMM" };
    // String hundreds[] = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC",
    // "CM" };
    // String tens[] = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"
    // };
    // String ones[] = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"
    // };
    // return thousands[num / 1000] + hundreds[(num % 1000) / 100] + tens[(num %
    // 100) / 10] + ones[num % 10];
    // }

    // count and say solution easier to understand
    public String intToRoman(int num) {
        if (num < 1 || num > 3999)
            return "";

        StringBuilder ans = new StringBuilder();

        String[] romanVal = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int[] intVal = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

        int i = 0;
        while (num > 0) {
            while (num >= intVal[i]) {
                num -= intVal[i];
                ans.append(romanVal[i]);
            }
            i++;
        }
        return ans.toString();
    }
}

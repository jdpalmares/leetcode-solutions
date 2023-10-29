import java.util.ArrayList;
import java.util.List;

public class LetterCombPhonePad {

    //intuition answer
    // public List<String> letterCombinations(String digits) {
    //     String phonePad[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    //         List<String> ans = new ArrayList<String>();
    
    //         if (digits.length()==0) return ans;
            
    //         ans.add("");
    //         for (int i = 0; i < digits.length(); i++)
    //             ans = letterComb(phonePad[digits.charAt(i)-'0'],ans);
            
    //         return ans;
    // }
    // public static List<String> letterComb(String digit, List<String> ans) {
    //     List<String> combinations = new ArrayList<String>();
        
    //     for (int i = 0; i < digit.length(); i++)
    //         for (String x : ans)
    //         combinations.add(x+digit.charAt(i));
    //     return combinations;
    // }

    //using backtracking
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<String>();
        if (digits.isEmpty()) return ans;

        String[] phonePad = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack("", digits, phonePad, ans);
        return ans;
    }

    private void backtrack(String combination, String next_digits, String[] phonePad, List<String> ans) {
        if (next_digits.isEmpty()) {
            ans.add(combination);
        } else {
            String letters = phonePad[next_digits.charAt(0) - '2'];
            for (char letter : letters.toCharArray()) {
                backtrack(combination + letter, next_digits.substring(1), phonePad, ans);
            }
        }
    }
}
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        checkParenthesis(ans, "", 0, 0, n);
        return ans;
    }

    public void checkParenthesis(List<String> list, String str, int open, int close, int n){
        if(str.length() == n * 2) {
            list.add(str);
            return;
        }
        
        if(open < n) checkParenthesis(list, str + "(", open + 1, close, n);
        if(close < open) checkParenthesis(list, str + ")", open, close + 1, n);
    }

    //iterative but slower
    public List<String> generateParenthesisIterative(int n) {
        List<List<String>> ans = new ArrayList<>();
        ans.add(Collections.singletonList(""));
        
        for (int i = 1; i <= n; ++i) {
            final List<String> list = new ArrayList<>();
            for (int j = 0; j < i; ++j)
                for (final String first : ans.get(j))
                    for (final String second : ans.get(i - 1 - j))
                        list.add("(" + first + ")" + second);
            ans.add(list);
        }
        
        return ans.get(ans.size() - 1);
    }
}

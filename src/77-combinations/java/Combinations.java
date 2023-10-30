import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
		backtrack(ans, new ArrayList<Integer>(), 1, n, k);
		return ans;
    }

    public static void backtrack(List<List<Integer>> ans, List<Integer> combination,
                                    int start, int n, int k) {
		if(k == 0) {
			ans.add(new ArrayList<Integer>(combination));
			return;
		}
		for(int i = start; i <= n; i++ ) {
			combination.add(i);
			backtrack(ans, combination, i + 1, n, k - 1);
			combination.remove(combination.size()-1);
		}
	}
}
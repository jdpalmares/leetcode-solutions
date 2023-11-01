import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    //solution using backtracking
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(ans, new ArrayList<>(), candidates, target, 0);
        return ans;
    }
    private void backtrack(List<List<Integer>> ans, List<Integer> tempList, int [] candidates, int target, int start) {
        if(target < 0) return;
        else if(target == 0) ans.add(new ArrayList<>(tempList));
        else {
            for(int i = start; i < candidates.length; i++) {
                tempList.add(candidates[i]);
                backtrack(ans, tempList, candidates, target - candidates[i], i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    
    // solution using dynamic programming
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<List<Integer>>> ans = new ArrayList<>();
        for (int i = 1; i <= target; i++) {
            List<List<Integer>> tempList = new ArrayList<>();
            for (int j = 0; j < candidates.length && candidates[j] <= i; j++) {
                if (i == candidates[j]) tempList.add(Arrays.asList(candidates[j]));
                else {
                    for (List<Integer> l : ans.get(i-candidates[j]-1)) {
                        if (candidates[j] <= l.get(0)) {
                            List<Integer> listForNum = new ArrayList<>();
                            listForNum.add(candidates[j]);
                            listForNum.addAll(l);
                            tempList.add(listForNum);
                        }
                    }
                }
                
            }
            ans.add(tempList);
        }
        return ans.get(target-1);
    }
}

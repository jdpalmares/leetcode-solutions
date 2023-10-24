import java.util.List;

class Triangle {
    //Dynamic programming solution
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] ans = new int[triangle.size()+1];
        for(int i=triangle.size()-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++)
                ans[j] = Math.min( ans[j],ans[j+1] ) + triangle.get(i).get(j);
        }
        return ans[0];
    }
    //same algo without extra space (slower time complexity)
    // public int minimumTotal(List<List<Integer>> triangle) {
    //     for(int i = triangle.size()-2 ; i>=0; i--) {
    //         for(int j=0; j<=i; j++)
    //             triangle.get(i).set(j, triangle.get(i).get(j) + Math.min( triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));
    //     }
    //     return triangle.get(0).get(0);
    // }
}
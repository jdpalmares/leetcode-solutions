import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary3LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> treeQueue = new LinkedList<TreeNode>();
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        
        if(root == null) return ans;

        treeQueue.offer(root);
        while (treeQueue.size() > 0) {
            double qlen = treeQueue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i< qlen; i++) {
                if(treeQueue.peek().left != null)
                    treeQueue.offer(treeQueue.peek().left);
                if(treeQueue.peek().right != null)

                    treeQueue.offer(treeQueue.peek().right);
                subList.add(treeQueue.poll().val);
            }
            ans.add(subList);
        }
        return ans;
    }
    
    //recursion solution
    // public List<List<Integer>> levelOrder(TreeNode root) {
    //     List<List<Integer>> ans =new ArrayList<>();
    //     pre(root,0,ans);
    //     return ans;
    // }
    
    // public static void pre(TreeNode root,int l,List<List<Integer>> ans) {
    //     if(root==null) return;
    //     if(ans.size()==l) {
    //         List<Integer>li=new ArrayList<>();
    //         li.add(root.val);
    //         ans.add(li);
    //     } else
    //         ans.get(l).add(root.val);
    //     pre(root.left,l+1,ans);
    //     pre(root.right,l+1,ans);
    // }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

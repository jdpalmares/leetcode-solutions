import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BtreeZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        zigzagTraverse(root, ans, 0);
        return ans;
    }

    private void zigzagTraverse(TreeNode node, List<List<Integer>> tree, int level) {
        if(node == null) return;
        
        if(tree.size() <= level) {
            List<Integer> newLevel = new LinkedList<>();
            tree.add(newLevel);
        }
        
        List<Integer> collection  = tree.get(level);
        if(level % 2 == 0) collection.add(node.val);
        else collection.add(0, node.val);
        
        zigzagTraverse(node.left, tree, level + 1);
        zigzagTraverse(node.right, tree, level + 1);
    }

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

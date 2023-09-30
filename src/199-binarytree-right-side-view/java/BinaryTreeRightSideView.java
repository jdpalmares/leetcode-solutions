import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    // intuition answer via recrursion
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        viewRight(root, ans, 0);
        return ans;
    }

    public void viewRight(TreeNode node, List<Integer> ans, int currDepth) {
        if (node == null)
            return;
        if (currDepth == ans.size())
            ans.add(node.val);

        viewRight(node.right, ans, currDepth + 1);
        viewRight(node.left, ans, currDepth + 1);

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

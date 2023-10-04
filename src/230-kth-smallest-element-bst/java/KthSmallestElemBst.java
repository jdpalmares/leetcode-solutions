
public class KthSmallestElemBst {
    private static int ans = 0;
    private static int currentCount = 0;

    public int kthSmallest(TreeNode root, int k) {
        currentCount = k;
        findKSmallest(root);
        return ans;
    }

    public void findKSmallest(TreeNode node) {
        if (node.left != null)
            findKSmallest(node.left);
        currentCount--;
        if (currentCount == 0) {
            ans = node.val;
            return;
        }
        if (node.right != null)
            findKSmallest(node.right);
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

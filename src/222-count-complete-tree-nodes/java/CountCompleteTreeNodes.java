
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        int nodeHeight = getHeight(root);
        return nodeHeight < 0 ? 0 :
                getHeight(root.right) == nodeHeight - 1 ? (1 << nodeHeight) + countNodes(root.right)
                                        : (1 << nodeHeight - 1) + countNodes(root.left);
    }

    private int getHeight(TreeNode root) {
        return root == null ? -1 : 1 + getHeight(root.left);
    }
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
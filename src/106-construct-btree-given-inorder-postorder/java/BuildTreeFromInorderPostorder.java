
public class BuildTreeFromInorderPostorder {
    // intuition answer based from 105 BuildTreeFromInorderPreorder
    private int inorderCount, postorderCount;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderCount = postorderCount = postorder.length - 1;
        return treeBuilder(inorder, postorder, Integer.MAX_VALUE);
    }

    private TreeNode treeBuilder(int[] inorder, int[] postorder, int stop) {
        if (postorderCount == -1 || inorder[inorderCount] == stop)
            return null;
        TreeNode node = new TreeNode(postorder[postorderCount--]);
        node.right = treeBuilder(inorder, postorder, node.val);
        inorderCount--;
        node.left = treeBuilder(inorder, postorder, stop);
        return node;
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

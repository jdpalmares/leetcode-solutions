import java.util.Stack;

public class ValidateBST {
    //iterative using inorder traversal
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> treeStack = new Stack<>();
        TreeNode prevNode = null;
        while (root != null || !treeStack.isEmpty()) {
            while (root != null) {
                treeStack.push(root);
                root = root.left;
            }
            root = treeStack.pop();
            if(prevNode != null && root.val <= prevNode.val) return false;
            prevNode = root;
            root = root.right;
        }
        return true;
    }

    //solution using recursion with Checking on left side value
    // private long leftVal = Long.MIN_VALUE;
    // public boolean isValidBST(TreeNode root) {
    //     if (root == null) return true;
    //     if (!isValidBST(root.left)) return false;
    //     if (leftVal >= root.val) return false;
    //     leftVal = root.val;
    //     if (!isValidBST(root.right)) return false;
    //     return true;
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

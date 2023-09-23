public class SymmetricTree {
    // intuitive recursive solution
    public boolean isSymmetric(TreeNode root) {
        return (root == null) || isSymmetricComp(root.left, root.right);
    }

    private boolean isSymmetricComp(TreeNode left, TreeNode right) {
        if (left == null || right == null)
            return left == right;
        if (left.val != right.val)
            return false;
        else
            return isSymmetricComp(left.left, right.right) && isSymmetricComp(left.right, right.left);
    }

    // iterative solution using stack
    // public boolean isSymmetric(TreeNode root) {
    // if (root == null)
    // return true;
    // Stack<TreeNode> treeStack = new Stack<>();
    // treeStack.push(root.left);
    // treeStack.push(root.right);
    // while (!treeStack.empty()) {
    // TreeNode right = treeStack.pop(), left = treeStack.pop();
    // if (right == null && left == null)
    // continue;
    // if (right == null || left == null || right.val != left.val)
    // return false;
    // treeStack.push(right.left);
    // treeStack.push(left.right);
    // treeStack.push(right.right);
    // treeStack.push(left.left);
    // }
    // return true;
    // }

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

public class PathSum {
    // recursive solution
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null && root.val == targetSum)
            return true;
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    // iteration using stacks
    // public boolean hasPathSum(TreeNode root, int targetSum) {
    // if (root == null)
    // return false;
    // Stack<TreeNode> path = new Stack<>();
    // Stack<Integer> currTotal = new Stack<>();
    // path.push(root);
    // currTotal.push(root.val);
    // while (!path.isEmpty()) {
    // TreeNode temp = path.pop();
    // int tempVal = currTotal.pop();
    // if (temp.left == null && temp.right == null) {
    // if (tempVal == targetSum)
    // return true;
    // } else {
    // if (temp.left != null) {
    // path.push(temp.left);
    // currTotal.push(temp.left.val + tempVal);
    // }
    // if (temp.right != null) {
    // path.push(temp.right);
    // currTotal.push(temp.right.val + tempVal);
    // }
    // }
    // }
    // return false;
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

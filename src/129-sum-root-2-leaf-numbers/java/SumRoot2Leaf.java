public class SumRoot2Leaf {
    // intuition answer recursive
    public int sumNumbers(TreeNode root) {
        return addNodes(root, 0);
    }

    private int addNodes(TreeNode node, int subTotal) {
        if (node == null)
            return 0;
        subTotal = subTotal * 10 + node.val;
        if (node.right == null && node.left == null)
            return subTotal;
        return addNodes(node.left, subTotal) + addNodes(node.right, subTotal);
    }

    // alternative iterative answer
    // public int sumNumbers(TreeNode root) {
    // if (root == null)
    // return 0;
    // int sum = 0;
    // TreeNode curr;
    // Stack<TreeNode> ws = new Stack<TreeNode>();
    // ws.push(root);

    // while (!ws.empty()) {
    // curr = ws.pop();

    // if (curr.right != null) {
    // curr.right.val = curr.val * 10 + curr.right.val;
    // ws.push(curr.right);
    // }

    // if (curr.left != null) {
    // curr.left.val = curr.val * 10 + curr.left.val;
    // ws.push(curr.left);
    // }

    // if (curr.left == null && curr.right == null)
    // sum += curr.val;
    // }
    // return sum;
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

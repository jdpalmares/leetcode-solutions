
public class FlattenBtree2LinkedList {

    // O(1) space implementation
    public void flatten(TreeNode root) {
        TreeNode head = null, currentNode = root;
        while (head != root) {
            if (currentNode.right == head)
                currentNode.right = null;
            if (currentNode.left == head)
                currentNode.left = null;
            if (currentNode.right != null)
                currentNode = currentNode.right;
            else if (currentNode.left != null)
                currentNode = currentNode.left;
            else {
                currentNode.right = head;
                head = currentNode;
                currentNode = root;
            }
        }
    }

    // morris traversal
    // public void flatten(TreeNode root) {
    // TreeNode currentNode = root;
    // while (currentNode != null) {
    // if (currentNode.left != null) {
    // TreeNode iterNode = currentNode.left;
    // while (iterNode.right != null)
    // iterNode = iterNode.right;
    // iterNode.right = currentNode.right;
    // currentNode.right = currentNode.left;
    // currentNode.left = null;
    // }
    // currentNode = currentNode.right;
    // }
    // }

    // intuition answer using recursion and global var for reference
    // private TreeNode prevNode = null;
    // public void flatten(TreeNode root) {
    // if (root == null)
    // return;
    // flatten(root.right);
    // flatten(root.left);
    // root.right = prevNode;
    // root.left = null;
    // prevNode = root;
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
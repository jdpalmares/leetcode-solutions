public class BuildTreeFromInorderPreorder {
    // solution using global variable iterator for inorder and preorder
    private int inorderCount = 0;
    private int preorderCount = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return treeBuilder(preorder, inorder, Integer.MIN_VALUE);
    }

    private TreeNode treeBuilder(int[] preorder, int[] inorder, int stop) {
        if (preorderCount >= preorder.length) {
            return null;
        }
        if (inorder[inorderCount] == stop) {
            ++inorderCount;
            return null;
        }

        TreeNode node = new TreeNode(preorder[preorderCount++]);
        node.left = treeBuilder(preorder, inorder, node.val);
        node.right = treeBuilder(preorder, inorder, stop);
        return node;
    }

    // solution using cache via hashmap
    // public TreeNode buildTree(int[] preorder, int[] inorder) {
    // Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();

    // for (int i = 0; i < inorder.length; i++) {
    // inMap.put(inorder[i], i);
    // }

    // TreeNode root = treeBuilder(preorder, 0, preorder.length - 1, inorder, 0,
    // inorder.length - 1, inMap);
    // return root;
    // }

    // public TreeNode treeBuilder(int[] preorder, int preStart, int preEnd, int[]
    // inorder, int inStart, int inEnd,
    // Map<Integer, Integer> inMap) {
    // if (preStart > preEnd || inStart > inEnd)
    // return null;

    // TreeNode root = new TreeNode(preorder[preStart]);
    // int inRoot = inMap.get(root.val);
    // int numsLeft = inRoot - inStart;

    // root.left = treeBuilder(preorder, preStart + 1, preStart + numsLeft, inorder,
    // inStart, inRoot - 1, inMap);
    // root.right = treeBuilder(preorder, preStart + numsLeft + 1, preEnd, inorder,
    // inRoot + 1, inEnd, inMap);

    // return root;
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


public class SameTree {
    // intuition answer
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if (p != null && q == null)
            return false;
        else if (p == null && q != null)
            return false;
        else {
            if (p.val != q.val)
                return false;
            else {
                if (!isSameTree(p.left, q.left))
                    return false;
                else
                    return isSameTree(p.right, q.right);
            }
        }
    }

    // clean and concise answer
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null)
            return (p == q);
        else
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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

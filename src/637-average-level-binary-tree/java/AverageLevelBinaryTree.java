import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageLevelBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> treeQueue = new LinkedList<>(List.of(root));
        List<Double> ans = new ArrayList<>();
        while (treeQueue.size() > 0) {
            double qlen = treeQueue.size(), rowSum = 0;
            for (int i = 0; i < qlen; i++) {
                TreeNode currNode = treeQueue.poll();
                rowSum += currNode.val;
                if (currNode.left != null)
                    treeQueue.offer(currNode.left);
                if (currNode.right != null)
                    treeQueue.offer(currNode.right);
            }
            ans.add(rowSum / qlen);
        }
        return ans;
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

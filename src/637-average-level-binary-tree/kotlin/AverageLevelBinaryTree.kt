class AverageLevelBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null)
            return doubleArrayOf()
        val treeQueue : Queue<TreeNode> = LinkedList()
        treeQueue.offer(root)
        val ans = mutableListOf<Double>()
        while(treeQueue.isNotEmpty()) {
            val size = treeQueue.size
            var sum = 0.0
            for(i in 0 until size) {
                val node = treeQueue.poll()
                sum += node.`val`.toDouble()
                node.left?.let{ treeQueue.offer(it) }
                node.right?.let{ treeQueue.offer(it) }
            }
            ans.add(sum.toDouble() / size.toDouble())
        }
        return ans.toDoubleArray()
    }
    }
    
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}
class Binary3LevelOrderTraversal {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()
        val ans = mutableListOf<List<Int>>()
        val queue = LinkedList<TreeNode>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            ans.add(queue.toList().map { it.`val` })
            for (i in queue.indices) {
                val currentNode = queue.poll()
                currentNode.left?.let { queue.add(it) }
                currentNode.right?.let { queue.add(it) }
            }
        }
        return ans
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}
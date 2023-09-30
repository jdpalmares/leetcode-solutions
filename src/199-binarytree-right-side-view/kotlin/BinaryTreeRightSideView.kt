class BinaryTreeRightSideView {
    //solution based on Java Solution
    fun rightSideView(root: TreeNode?): List<Int> {
        val ans = arrayListOf<Int>()
        viewRight(root, ans, 0)
        return ans
    }

    fun viewRight(node: TreeNode?, ans: MutableList<Int>, currDepth: Int) {
        if (node == null)
            return
        if (currDepth == ans.size)
            ans.add(node?.`val` ?: 0)
    
        viewRight(node.right, ans, currDepth + 1)
        viewRight(node.left, ans, currDepth + 1)
    }

    //one liner kotlin code
    fun rightSideView(root: TreeNode?): List<Int> = root ?.
        let{ listOf(it.`val`) + rightSideView(it.right).
            let { it + rightSideView(root.left).drop(it.size) } } ?: emptyList()
}

class TreeNode(var `val`: Int) {
      var left: TreeNode? = null
      var right: TreeNode? = null
}
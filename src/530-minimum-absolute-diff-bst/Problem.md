# 530. Minimum Absolute Difference in BST


## Easy

Given the `root` of a Binary Search Tree (BST), return the *minimum absolute difference between the values of any two different nodes in the tree*.

### Example 1:
[Example 1 image](https://assets.leetcode.com/uploads/2021/02/05/bst1.jpg)
```console
Input: root = [4,2,6,1,3]
Output: 1
```

### Example 2:
[Example 2 image](https://assets.leetcode.com/uploads/2021/02/05/bst2.jpg)
```console
Input: root = [1,0,48,null,null,12,49]
Output: 1
```


### Constraints:

- The number of nodes in the tree is in the range `[2, 10`^4^`]`.
- `0 <= Node.val <= 10`^5^

**Note:** This question is the same as 783: https://leetcode.com/problems/minimum-distance-between-bst-nodes/
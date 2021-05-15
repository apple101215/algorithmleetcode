package com.shawn.algorithm.leetcode.editor.cn;
//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出：3
//解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
// 
//
// 示例 2： 
//
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出：5
//解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], p = 1, q = 2
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [2, 105] 内。 
// -109 <= Node.val <= 109 
// 所有 Node.val 互不相同 。 
// p != q 
// p 和 q 均存在于给定的二叉树中。 
// 
// Related Topics 树 
// 👍 1082 👎 0

import java.util.Stack;

/**
 * 二叉树的最近公共祖先
 * @author shawn
 * @date 2021-04-17 20:49:39
 */
public class LowestCommonAncestorOfABinaryTree{
    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinaryTree().new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        TreeNode treeNode = solution.lowestCommonAncestor(root, new TreeNode(0), new TreeNode(8));
        System.out.println(treeNode.val);
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*boolean commonAncestor = isCommonAncestor(root.left, p, q);
        if (commonAncestor) {
            root = root.left;
            return lowestCommonAncestor(root, p, q);
        } else {
            commonAncestor = isCommonAncestor(root.right, p, q);
            if (commonAncestor) {
                root = root.right;
                return lowestCommonAncestor(root, p, q);
            } else {
                return root;
            }

        }*/
        dfs(root, p, q);
        return result;
    }
    private TreeNode result;
    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            result = root;
        }
        return lson || rson || root.val == p.val || root.val == q.val;
    }

    public boolean isCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        boolean hasP = false, hasQ = false;
        Stack<TreeNode> nodeStack = new Stack<>();
        if (root != null) {
            nodeStack.push(root);
        }
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            if (!hasP && (node.val == p.val)) {
                hasP = true;
            }
            if (!hasQ && (node.val == q.val)) {
                hasQ = true;
            }
            if (hasP && hasQ) {
                return true;
            }
            if (node.left != null) {
                nodeStack.push(node.left);
            }
            if (node.right != null) {
                nodeStack.push(node.right);
            }
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
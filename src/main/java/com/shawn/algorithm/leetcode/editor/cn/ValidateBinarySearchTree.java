package com.shawn.algorithm.leetcode.editor.cn;
//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 960 👎 0


import java.util.ArrayList;
import java.util.List;

/**
 * 验证二叉搜索树
 *
 * @author shawn
 * @date 2021-03-15 23:02:48
 */
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        Integer pre;

        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (!isValidBST((root.left))) {
                return false;
            }
            if (pre != null && root.val <= pre) {
                return false;
            }
            pre = root.val;
            return isValidBST(root.right);
        }


        public boolean isValidBST2(TreeNode root) {
            boolean gtLeft = true;
            if (root.left != null) {
                gtLeft = isValidBST2(root.left) && root.val > maxVal(root.left);
            }
            boolean ltRight = true;
            if (root.right != null) {
                ltRight = isValidBST2(root.right) && root.val < minVal(root.right);
            }
            return gtLeft && ltRight;
        }

        public int maxVal(TreeNode root) {
            int max = root.val;
            if (root.right != null) {
                max = maxVal(root.right);
            }
            return max;
        }

        public int minVal(TreeNode root) {
            int min = root.val;
            if (root.left != null) {
                min = minVal(root.left);
            }
            return min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
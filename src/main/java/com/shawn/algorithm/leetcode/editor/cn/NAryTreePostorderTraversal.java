package com.shawn.algorithm.leetcode.editor.cn;
//给定一个 N 叉树，返回其节点值的 后序遍历 。 
//
// N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。 
//
// 
// 
// 
//
// 进阶： 
//
// 递归法很简单，你可以使用迭代法完成此题吗? 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,null,3,2,4,null,5,6]
//输出：[5,6,3,2,4,1]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
//null,13,null,null,14]
//输出：[2,6,14,11,7,3,12,8,4,13,9,10,5,1]
// 
//
// 
//
// 提示： 
//
// 
// N 叉树的高度小于或等于 1000 
// 节点总数在范围 [0, 10^4] 内 
// 
// 
// 
// Related Topics 树 
// 👍 149 👎 0

import java.util.*;

/**
 * N 叉树的后序遍历
 *
 * @author shawn
 * @date 2021-06-06 16:37:10
 */
public class NAryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new NAryTreePostorderTraversal().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

    class Solution {
        /**
         * 翻转列表解法
         * @param root
         * @return
         */
        public List<Integer> postorder(Node root) {
            List<Integer> list = new ArrayList<>();
            if (root == null) return list;

            Stack<Node> stack = new Stack<>();
            stack.add(root);

            while(!stack.isEmpty()) {
                root = stack.pop();
                list.add(root.val);
                stack.addAll(root.children);
            }
            Collections.reverse(list);
            return list;
        }
        /**
         * 双向链表迭代
         * @param root
         * @return
         */
        public List<Integer> postorde2(Node root) {
            LinkedList<Integer> result = new LinkedList<>();
            if (root != null) {
                Stack<Node> stack = new Stack<>();
                stack.push(root);
                while (!stack.isEmpty()) {
                    Node pop = stack.pop();
                    result.addFirst(pop.val);
                    stack.addAll(pop.children);
                }
            }
            return result;
        }

        /**
         * 我都迭代处理
         * @param root
         * @return
         */
        public List<Integer> postorderMyLoop(Node root) {
            List<Integer> result = new ArrayList<>();
            if (root != null) {
                Stack<Node> nodes = new Stack<>();
                List<Node> hasRead = new ArrayList<>();
                nodes.push(root);
                while (!nodes.isEmpty()) {
                    Node top = nodes.peek();
                    boolean has = true;
                    for (int i = top.children.size() - 1; i >= 0; i--) {
                        if (!hasRead.contains(top.children.get(i))) {
                            nodes.push(top.children.get(i));
                            has = false;
                        }
                    }
                    if (has) {
                        hasRead.add(top);
                        result.add(nodes.pop().val);
                    }
                }
            }
            return result;
        }

        /**
         * 递归
         *
         * @param root
         * @return
         */
        public List<Integer> postorderRecursion(Node root) {
            List<Integer> result = new ArrayList<>();
            if (root != null) {
                for (Node child : root.children) {
                    result.addAll(postorderRecursion(child));
                }
                result.add(root.val);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
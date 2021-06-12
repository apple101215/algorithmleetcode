package com.shawn.algorithm.leetcode.editor.cn;
//给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。 
//
// 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,null,3,2,4,null,5,6]
//输出：[[1],[3,2,4],[5,6]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
//null,13,null,null,14]
//输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
// 
//
// 
//
// 提示： 
//
// 
// 树的高度不会超过 1000 
// 树的节点总数在 [0, 10^4] 之间 
// 
// Related Topics 树 广度优先搜索 
// 👍 158 👎 0

import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * N 叉树的层序遍历
 *
 * @author shawn
 * @date 2021-06-06 16:31:34
 */
public class NAryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new NAryTreeLevelOrderTraversal().new Solution();
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
         * 通过队列size来实现
         * @param root
         * @return
         */
        public List<List<Integer>> levelOrderSize(Node root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root != null) {
                Queue<Node> queue = new LinkedList<>();
                queue.add(root);
                while (!queue.isEmpty()) {
                    List<Integer> level = new ArrayList<>();
                    int size = queue.size();
                    for (int i = 0; i < size; i++) {
                        Node node = queue.poll();
                        assert node != null;
                        level.add(node.val);
                        queue.addAll(node.children);
                    }
                    result.add(level);

                }
            }
            return result;
        }

        private List<List<Integer>> result = new ArrayList<>();

        /**
         * 记录level值方法
         * @param root
         * @return
         */
        public List<List<Integer>> levelOrder(Node root) {
            if (root != null) {
                traverseNode(root, 0);
            }
            return result;
        }

        private void traverseNode(Node node, int level) {
            if (result.size() <= level) {
                result.add(new ArrayList<>());
            }
            result.get(level).add(node.val);
            for (Node child : node.children) {
                traverseNode(child, level + 1);
            }
        }
        /**
         * 循环解法
         * @param root
         * @return
         */
        public List<List<Integer>> levelOrderLoop(Node root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root != null) {
                result.add(Collections.singletonList(root.val));
                List<Node> children = root.children;
                while (children != null && children.size() != 0) {
                    List<Node> newChildren = new ArrayList<>();
                    List<Integer> temp = new ArrayList<>();
                    for (Node child : children) {
                        temp.add(child.val);
                        newChildren.addAll(child.children);
                    }
                    result.add(temp);
                    children = newChildren;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
package com.shawn.algorithm.leetcode.editor.cn;
//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 进阶： 
//
// 
// 你可以设计一个只使用常数额外空间的算法来解决此问题吗？ 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2,3,4,5], k = 1
//输出：[1,2,3,4,5]
// 
//
// 示例 4： 
//
// 
//输入：head = [1], k = 1
//输出：[1]
// 
//
// 
// 
//
// 提示： 
//
// 
// 列表中节点的数量在范围 sz 内 
// 1 <= sz <= 5000 
// 0 <= Node.val <= 1000 
// 1 <= k <= sz 
// 
// Related Topics 链表 
// 👍 1110 👎 0

/**
 * K 个一组翻转链表
 *
 * @author shawn
 * @date 2021-05-23 11:52:16
 */
public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup().new Solution();
        solution.reverseKGroup(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || head.next == null || k <= 1) {
                return head;
            }
            ListNode pre = new ListNode(0, head);
            ListNode first = head, tail = head;
            int i = 1;
            while (tail != null) {
                if (i == k) {
                    reverseList(first, tail);
                    if (first == head) {
                        head = tail;
                    }
                    pre.next = tail;
                    pre = first;
                    tail = first.next;
                    first = tail;
                    i = 1;
                } else {
                    i++;
                    tail = tail.next;
                }
            }
            return head;
        }

        public void reverseList(ListNode head, ListNode tail) {
            ListNode next = tail.next, preNode = head, end = tail.next;
            while (preNode != end) {
                ListNode temp = preNode.next;
                preNode.next = next;
                next = preNode;
                preNode = temp;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
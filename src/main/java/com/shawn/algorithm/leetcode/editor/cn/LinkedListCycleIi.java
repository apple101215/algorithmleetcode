package com.shawn.algorithm.leetcode.editor.cn;
//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，po
//s 仅仅是用于标识环的情况，并不会作为参数传递到函数中。 
//
// 说明：不允许修改给定的链表。 
//
// 进阶： 
//
// 
// 你是否可以使用 O(1) 空间解决此题？ 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [3,2,0,-4], pos = 1
//输出：返回索引为 1 的链表节点
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2], pos = 0
//输出：返回索引为 0 的链表节点
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [1], pos = -1
//输出：返回 null
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围在范围 [0, 104] 内 
// -105 <= Node.val <= 105 
// pos 的值为 -1 或者链表中的一个有效索引 
// 
// Related Topics 链表 双指针 
// 👍 1003 👎 0

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 环形链表 II
 *
 * @author shawn
 * @date 2021-05-23 11:51:27
 */
public class LinkedListCycleIi {
    public static void main(String[] args) {
        Solution solution = new LinkedListCycleIi().new Solution();
        int[] nums = {-21,10,17,8,4,26,5,35,33,-7,-16,27,-12,6,29,-12,5,9,20,14,14,2,13,-24,21,23,-21,5};
        System.out.println(nums.length);
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        /**
         * 双指针+公式
         * a = c + (n-1)(b + c)
         * a是头节点到入环节点长度
         * b是入环节点到快慢指针首次相遇节点长度
         * c是快慢节点首次相遇到入环节点长度
         * n即快慢节点首次相遇快节点跑了n圈环
         * @param head
         * @return
         */
        public ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null) {
                return null;
            }
            ListNode slow = head,fast = head, pre = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    while (slow != pre) {
                        slow = slow.next;
                        pre = pre.next;
                    }
                    return pre;
                }
            }
            return null;
        }
        /**
         * hash求解
         * @param head
         * @return
         */
        public ListNode detectCycleHash(ListNode head) {
            if (head == null || head.next == null) {
                return null;
            }
            Set<ListNode> vals = new HashSet<>();
            while (head != null) {
                if (!vals.add(head)) {
                    return head;
                }
                head = head.next;
            }
            return null;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}
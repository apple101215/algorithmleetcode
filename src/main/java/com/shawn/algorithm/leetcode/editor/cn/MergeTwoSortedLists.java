package com.shawn.algorithm.leetcode.editor.cn;
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 
// 👍 1732 👎 0

/**
 * 合并两个有序链表
 * @author shawn
 * @date 2021-05-30 10:58:13
 */
public class MergeTwoSortedLists{
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution(); 
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    /**
     * 递归方式
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoListsD(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else {
            if (l1.val > l2.val) {
                l2.next = mergeTwoLists(l2.next, l1);
                return l2;
            } else {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            }
        }
    }

    /**
     * 题解的迭代
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode temp  = result;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                temp.next = l2;
                l2 = l2.next;
            } else {
                temp.next = l1;
                l1 = l1.next;
            }
            temp = temp.next;
        }
        temp.next = l1 == null ? l2 : l1;
        return result.next;
    }

    /**
     * 我的迭代
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoListsMy(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode temp  = result;
        while (true) {
           if (l1 == null) {
               temp.next = l2;
               break;
           } else if (l2 == null) {
               temp.next = l1;
               break;
           } else {
               if (l1.val > l2.val) {
                   temp.next = new ListNode(l2.val);
                   l2 = l2.next;
               } else {
                   temp.next = new ListNode(l1.val);
                   l1 = l1.next;
               }
               temp = temp.next;
           }
        }
        return result.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
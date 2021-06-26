package com.shawn.algorithm.leetcode.editor.cn;
//给你一个整数 n ，请你找出并返回第 n 个 丑数 。 
//
// 丑数 就是只包含质因数 2、3 和/或 5 的正整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：12
//解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
//解释：1 通常被视为丑数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1690 
// 
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 
// 👍 679 👎 0

import java.util.PriorityQueue;

/**
 * 丑数 II
 *
 * @author shawn
 * @date 2021-06-26 10:40:10
 */
public class UglyNumberIi {
    public static void main(String[] args) {
        Solution solution = new UglyNumberIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * dp实现 dp[n] = Math
         *
         * @param n
         * @return
         */
        public int nthUglyNumber(int n) {
            int[] dp = new int[n];
            int i = 0, j = 0, k = 0;
            dp[0] = 1;
            for (int l = 1; l < n; l++) {
                int num2 = 2 * dp[i];
                int num3 = 3 * dp[j];
                int num5 = 5 * dp[k];
                dp[l] = Math.min(Math.min(num2, num3), num5);
                if (dp[l] == num2) {
                    i++;
                }
                if (dp[l] == num3) {
                    j++;
                }
                if (dp[l] == num5) {
                    k++;
                }
            }
            return dp[n - 1];
        }

        /**
         * 用堆实现
         *
         * @param n
         * @return
         */
        public int nthUglyNumberHeap(int n) {
            long[] factors = {2L, 3L, 5L};
            PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
            priorityQueue.add(1L);
            int uglyNum = 0;
            for (int i = 0; i < n; i++) {
                uglyNum = priorityQueue.poll().intValue();
                for (long factor : factors) {
                    if (!priorityQueue.contains(uglyNum * factor)) {
                        priorityQueue.add(uglyNum * factor);
                    }
                }
            }
            return uglyNum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
package com.shawn.algorithm.leetcode.editor.cn;
//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。 
//
// 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/ 
// Related Topics 数学 
// 👍 178 👎 0

/**
 * 丑数
 *
 * @author shawn
 * @date 2021-06-24 22:55:05
 */
public class ChouShuLcof {
    public static void main(String[] args) {
        Solution solution = new ChouShuLcof().new Solution();
        solution.nthUglyNumber(10);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthUglyNumber(int n) {
            int[] dp = new int[n];
            dp[0] = 1;
            int i = 0, j = 0, k = 0;
            for (int l = 1; l < n; l++) {
                int num2 = dp[i] * 2;
                int num3 = dp[j] * 3;
                int num5 = dp[k] * 5;
                dp[l] = Math.min(Math.min(num2, num3), num5);
                // 都if判断进行去重
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
            return dp[n-1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
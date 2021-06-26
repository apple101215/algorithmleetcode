package com.shawn.algorithm.leetcode.editor.cn;
//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100
// 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25
// 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -231 <= n <= 231-1 
// -104 <= xn <= 104 
// 
// Related Topics 递归 数学 
// 👍 673 👎 0

/**
 * Pow(x, n)
 *
 * @author shawn
 * @date 2021-06-26 12:05:35
 */
public class PowxN {
    public static void main(String[] args) {
        Solution solution = new PowxN().new Solution();
        System.out.println(solution.myPow(2, -2147483648));
        System.out.println(Math.pow(2, -2147483648));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 递归
         *
         * @param x
         * @param n
         * @return
         */
        public double myPow(double x, int n) {
            if (n == 0)
                return 1;
            if (n < 0) {
                return 1 / x * myPow(1 / x, -(n + 1));
            }
            return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
        }

        /**
         * 迭代
         *
         * @param x
         * @param n
         * @return
         */
        public double myPowIterator(double x, int n) {
            if (x == 0) {
                return 0;
            }
            if (x == 1) {
                return 1;
            }
            double result = 1;
            long nl = n;
            if (n < 0) {
                x = 1 / x;
                nl = -nl;
            }
            while (nl > 0) {
                if (nl % 2 == 1) {
                    result *= x;
                }
                x *= x;
                nl /= 2;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
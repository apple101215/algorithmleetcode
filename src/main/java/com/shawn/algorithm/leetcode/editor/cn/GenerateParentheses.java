package com.shawn.algorithm.leetcode.editor.cn;
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1622 👎 0
/**
 * 生成括号
 *
 * @author shawn
 * @date 2021/3/12
 */

import java.util.*;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        System.out.println(solution.generateParenthesis(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            if (n == 0) {
                return res;
            }
            dfs(new StringBuilder(), 0, 0, n, res);
            return res;
        }

        /**
         * @param curStr 当前递归得到的结果
         * @param left   左括号已经用了几个
         * @param right  右括号已经用了几个
         * @param n      左括号、右括号一共得用几个
         * @param res    结果集
         */
        private void dfs(StringBuilder curStr, int left, int right, int n, List<String> res) {
            if (left == n && right == n) {
                res.add(curStr.toString());
                return;
            }

            if (left < n) {
                dfs(curStr.append('('), left + 1, right, n, res);
                curStr.deleteCharAt(curStr.length() - 1);
            }
            if (right < left) {
                dfs(curStr.append(')'), left, right + 1, n, res);
                curStr.deleteCharAt(curStr.length() - 1);
            }
        }

    /*public List<String> generateParenthesis(int n) {
        if (n == 1) {
            List<String> result = new ArrayList<>();
            result.add("()");
            return result;
        }
        List<String> list = generateParenthesis(n - 1);
        Set<String> result = new HashSet<>();
        char left = '(';
        char right = ')';
        list.forEach(temp -> {
            for (int i = 0; i <= temp.length(); i++) {
                for (int j = temp.length(); j > i; j--) {
                    StringBuilder sb = new StringBuilder(temp);
                    sb.insert(i, left);
                    sb.insert(j, right);
                    result.add(sb.toString());
                }
            }
        });
        ArrayList<String> strings = new ArrayList<>(result);
        strings.sort(String::compareTo);
        return strings;
    }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}
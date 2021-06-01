package com.shawn.algorithm.leetcode.editor.cn;
//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 391 👎 0

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 有效的字母异位词
 *
 * @author shawn
 * @date 2021-06-01 22:00:15
 */
public class ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new ValidAnagram().new Solution();
        System.out.println(solution.isAnagram("anagram", "nagaram"));
        ;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            int[] temp = new int[26];
            for (int i = 0; i < s.length(); i++) {
                temp[s.charAt(i) - 'a']++;
                temp[t.charAt(i) - 'a']--;
            }
            for (int j : temp) {
                if (j != 0) {
                    return false;
                }
            }
            return true;
        }

        /**
         * 字母异位判读
         * @param s
         * @param t
         * @return
         */
        public boolean isAnagramMy(String s, String t) {
            if(s.length() != t.length()) {
                return false;
            }
            char[] sChars = s.toCharArray();
            Arrays.sort(sChars);
            char[] tChars = t.toCharArray();
            Arrays.sort(tChars);
            return Arrays.equals(sChars, tChars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
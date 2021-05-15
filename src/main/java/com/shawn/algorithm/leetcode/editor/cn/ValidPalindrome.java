package com.shawn.algorithm.leetcode.editor.cn;
//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 383 👎 0

import java.text.Format;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

/**
 * 验证回文串
 * @author shawn
 * @date 2021-05-15 20:21:46
 */
public class ValidPalindrome{
    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; ) {
            if (!Character.isLetterOrDigit(chars[i])) {
                i ++;
            } else if (!Character.isLetterOrDigit(chars[j])) {
                j --;
            } else if (Character.toLowerCase(chars[i]) != Character.toLowerCase(chars[j])) {
                return false;
            } else {
                i ++;
                j --;
            }
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


}
package com.shawn.algorithm.leetcode.editor.cn;
//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 755 👎 0

import java.util.*;

/**
 * 字母异位词分组
 *
 * @author shawn
 * @date 2021-06-06 11:15:12
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
        System.out.println(solution.sortKey("ana"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String str: strs) {
                String sortKey = sortKey(str);
                List<String> strings = map.getOrDefault(sortKey, new ArrayList<>());
                strings.add(str);
                map.put(sortKey, strings);
            }
            return new ArrayList<>(map.values());
        }

        public String sortKey(String s) {
            char[] sChars = s.toCharArray();
            Arrays.sort(sChars);
            return new String(sChars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
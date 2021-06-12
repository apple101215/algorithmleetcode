package com.shawn.algorithm.leetcode.editor.cn;
//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 只会存在一个有效答案 
// 
//
// 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？ 
// Related Topics 数组 哈希表 
// 👍 11158 👎 0

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * @author shawn
 * @date 2021-05-23 10:39:34
 */
public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 第二次写nums之和
         * @param nums
         * @param target
         * @return
         */
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> numsMap = new HashMap<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (numsMap.containsKey(target - num)) {
                    return new int[]{numsMap.get(target - num), i};
                } else {
                    numsMap.put(num, i);
                }
            }
            return null;
        }

        public int[] twoSumOld(int[] nums, int target) {
            if (nums.length > 1) {
                Map<Integer, Integer> existVals = new HashMap<>(nums.length);
                for (int i = 0; i < nums.length; i++) {
                    if (existVals.containsKey(target - nums[i])) {
                        return new int[]{existVals.get(target - nums[i]), i};
                    } else {
                        existVals.put(nums[i], i);
                    }
                }
            }
            return new int[0];
        }

        public int[] twoSum2(int[] nums, int target) {
            if (nums.length > 1) {
                Map<Integer, Integer> keys = new HashMap<>(nums.length);
                for (int k = 0; k < nums.length; k++) {
                    keys.put(nums[k], k);
                }
                for (int i = 0; i < nums.length; i++) {
                    int temp = target - nums[i];
                    if (keys.containsKey(temp) && keys.get(temp) != i) {
                        return new int[]{i, keys.get(temp)};
                    }
                }

            }
            return new int[0];
        }

        public int[] myTwoSum(int[] nums, int target) {
            int[] result = new int[2];
            if (nums.length > 1) {
                for (int i = 0; i < nums.length - 1; i++) {
                    for (int j = nums.length - 1; j > i; j--) {
                        if (nums[i] + nums[j] == target) {
                            result[0] = i;
                            result[1] = j;
                            return result;
                        }
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
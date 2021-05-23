package com.shawn.algorithm.leetcode.editor.cn;
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 3365 👎 0

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 *
 * @author shawn
 * @date 2021-05-23 10:01:24
 */
public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums.length > 2) {
                Arrays.sort(nums);
                for (int first = 0; first < nums.length - 2; first++) {
                    if (nums[first] > 0) {
                        return result;
                    }
                    if (first != 0 && nums[first] == nums[first - 1]) {
                        continue;
                    }
                    int third = nums.length - 1;
                    int target = -nums[first];
                    for (int second = first + 1; second < third; second ++) {
                        if (second > first + 1 && nums[second] == nums[second - 1]) {
                            continue;
                        }
                        while (nums[third] > 0
                                && third > (second + 1)
                                && nums[second] + nums[third] > target) {
                            third --;
                        }
                        if (nums[second] + nums[third] == target) {
                            result.add(Arrays.asList(nums[first], nums[second], nums[third]));
                        }
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
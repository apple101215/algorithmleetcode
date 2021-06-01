package com.shawn.algorithm.leetcode.editor.cn;
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 
// 👍 2374 👎 0

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 接雨水
 *
 * @author shawn
 * @date 2021-05-30 20:03:14
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
        int[] height = {4, 2, 3};
        solution.trap(height);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 双指针解决
         *
         * @param height
         * @return
         */
        public int trap(int[] height) {
            if (height.length < 3) {
                return 0;
            }
            int sum = 0;
            int maxLeft = height[0];
            int maxRight = height[height.length - 1];
            int left = 1, right = height.length - 2;
            for (int i = 1; i < height.length - 1; i++) {
                if (maxLeft < maxRight) {
                    // 当右侧随便一个柱子都大于左侧最大时，当前柱子肯定是由左侧最大柱子都高度决定积水都
                    if (maxLeft > height[left]) {
                        sum += (maxLeft - height[left]);
                    } else {
                        maxLeft = height[left];
                    }
                    left++;
                } else {
                    // 同理
                    if (maxRight > height[right]) {
                        sum += (maxRight - height[right]);
                    } else {
                        maxRight = height[right];
                    }
                    right--;
                }
            }
            return sum;
        }

        /**
         * 动态规划
         * maxLeft[i] = max(maxLeft[i-1], height[i-1])
         * maxRight[i] = max(maxRight[i + 1], height[i+1);
         *
         * @param height
         * @return
         */
        public int trapDp(int[] height) {
            if (height.length < 3) {
                return 0;
            }
            int sum = 0;
            int[] maxLeft = new int[height.length];
            int[] maxRight = new int[height.length];
            maxLeft[0] = 0;
            maxRight[height.length - 1] = 0;
            for (int i = 1; i < height.length; i++) {
                maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
            }
            for (int i = height.length - 2; i >= 0; i--) {
                maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
            }
            for (int i = 1; i < height.length - 1; i++) {
                int count = Math.min(maxLeft[i], maxRight[i]) - height[i];
                if (count > 0) {
                    sum += count;
                }
            }
            return sum;
        }

        /**
         * 使用栈都优化版,进行层级求解
         * @param height
         * @return
         */
        public int trapStack(int[] height) {
            if (height.length < 3) {
                return 0;
            }
            int sum = 0;
            Stack<Integer> index = new Stack<>();
            for (int i = 0; i < height.length; i++) {
                while (!index.empty() && height[i] > height[index.peek()]) {
                    int temp = height[index.pop()];
                    if (index.empty()) {
                        break;
                    }
                    sum += (Math.min(height[i], height[index.peek()]) - temp) * (i - index.peek() - 1);
                }
                index.push(i);
            }
            return sum;
        }

        /**
         * 我的求解方法
         *
         * @param height
         * @return
         */
        public int trapMy(int[] height) {
            if (height.length < 3) {
                return 0;
            }
            int sum = 0;
            Deque<Integer> nums = new LinkedList<>();
            for (int i : height) {
                if (nums.isEmpty()) {
                    nums.addLast(i);
                } else if (nums.size() == 1) {
                    if (i >= nums.peek()) {
                        nums.removeLast();
                    }
                    nums.addLast(i);
                } else if (i >= nums.peek()) {
                    while (!nums.isEmpty()) {
                        int h = nums.getFirst();
                        sum += (h - nums.removeLast());
                    }
                    nums.addLast(i);
                } else {
                    nums.addLast(i);
                }
            }
            if (nums.size() > 2) {
                int[] tem = new int[nums.size()];
                int i = 0;
                while (!nums.isEmpty()) {
                    tem[i++] = nums.removeLast();
                }
                sum += trapMy(tem);
            }

            return sum;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
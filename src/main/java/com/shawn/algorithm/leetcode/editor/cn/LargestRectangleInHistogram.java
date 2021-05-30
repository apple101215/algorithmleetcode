package com.shawn.algorithm.leetcode.editor.cn;
//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组 
// 👍 1376 👎 0

import java.util.Arrays;
import java.util.Stack;

/**
 * 柱状图中最大的矩形
 *
 * @author shawn
 * @date 2021-05-29 11:17:31
 */
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();
        int[] nums = {2, 3};
        System.out.println(solution.largestRectangleArea(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 暴力求解的优化，边界与最近的有关联
         * @param height
         * @return
         */
        public int largestRectangleArea(int[] height) {
            if (height == null || height.length == 0) {
                return 0;
            }
            int[] lessFromLeft = new int[height.length]; // idx of the first bar the left that is lower than current
            int[] lessFromRight = new int[height.length]; // idx of the first bar the right that is lower than current
            lessFromRight[height.length - 1] = height.length;
            lessFromLeft[0] = -1;

            for (int i = 1; i < height.length; i++) {
                int p = i - 1;

                while (p >= 0 && height[p] >= height[i]) {
                    p = lessFromLeft[p];
                }
                lessFromLeft[i] = p;
            }

            for (int i = height.length - 2; i >= 0; i--) {
                int p = i + 1;

                while (p < height.length && height[p] >= height[i]) {
                    p = lessFromRight[p];
                }
                lessFromRight[i] = p;
            }

            int maxArea = 0;
            for (int i = 0; i < height.length; i++) {
                maxArea = Math.max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
            }

            return maxArea;
        }

        /**
         * 哨兵栈模式
         *
         * @param heights
         * @return
         */
        public int largestRectangleArea4(int[] heights) {
            int len = heights.length;
            if (len == 0) {
                return 0;
            }
            if (len == 1) {
                return heights[0];
            }
            int[] newHeight = new int[len + 2];
            System.arraycopy(heights, 0, newHeight, 1, len);
            newHeight[0] = 0;
            newHeight[len + 1] = 0;
            heights = newHeight;
            Stack<Integer> data = new Stack<>();
            data.push(0);
            int maxArea = 0;
            for (int i = 1; i < heights.length; i++) {
                while (heights[data.peek()] > heights[i]) {
                    maxArea = Math.max(maxArea, heights[data.pop()] * (i - data.peek() - 1));
                }
                data.push(i);
            }
            return maxArea;
        }

        /**
         * 栈解法
         *
         * @param heights
         * @return
         */
        public int largestRectangleArea3(int[] heights) {
            int maxArea = 0;
            Stack<Integer> data = new Stack<>();
            data.push(-1);
            for (int i = 0; i < heights.length; i++) {
                while (data.peek() != -1 && heights[data.peek()] >= heights[i]) {
                    maxArea = Math.max(maxArea, heights[data.pop()] * (i - data.peek() - 1));
                }
                data.push(i);
            }
            while (data.peek() != -1) {
                maxArea = Math.max(maxArea, heights[data.pop()] * (heights.length - data.peek() - 1));
            }
            return maxArea;
        }

        /**
         * 暴力求解，超时
         *
         * @param heights
         * @return
         */
        public int largestRectangleArea2(int[] heights) {
            int max = 0;
            Stack<Integer> data = new Stack<>();
            if (heights.length == 1) {
                max = heights[0];
            } else if (heights.length == 2) {
                max = Math.min(heights[0], heights[1]) * 2;
                max = Math.max(Math.max(heights[0], heights[1]), max);
            } else {
                for (int i = 0; i < heights.length; i++) {
                    int leftIndex = i - 1, rightIndex = i + 1;
                    while (leftIndex >= 0 && heights[leftIndex] >= heights[i]) {
                        leftIndex--;
                    }
                    while (rightIndex < heights.length && heights[rightIndex] >= heights[i]) {
                        rightIndex++;
                    }
                    max = Math.max(max, heights[i] * (rightIndex - leftIndex - 1));
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
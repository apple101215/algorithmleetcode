package com.shawn.algorithm.leetcode.editor.cn;
//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 
//
// 进阶： 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？ 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,3,4,5,6,7], k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 
//输入：nums = [-1,-100,3,99], k = 2
//输出：[3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 104 
// -231 <= nums[i] <= 231 - 1 
// 0 <= k <= 105 
// 
//
// 
// 
// Related Topics 数组 
// 👍 976 👎 0

/**
 * 旋转数组
 *
 * @author shawn
 * @date 2021-05-30 09:54:18
 */
public class RotateArray {
    public static void main(String[] args) {
        Solution solution = new RotateArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 通过临时变量进行移动
         * @param nums
         * @param k
         */
        public void rotate(int[] nums, int k) {
            k %= nums.length;
            int count = 0;
            for (int i = 0; count < nums.length; i++) {
                int cur = i;
                int curVal = nums[i];
                do {
                    int next = (cur + k) % nums.length;
                    int temp = nums[next];
                    nums[next] = curVal;
                    curVal = temp;
                    cur = next;
                    count ++;
                } while (cur != i);
            }
        }

        /**
         * 翻转数组
         *
         * @param nums
         * @param k
         */
        public void rotateReverse(int[] nums, int k) {
            k = k % nums.length;
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }

        public void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[end];
                nums[end] = nums[start];
                nums[start] = temp;
                start++;
                end--;
            }
        }

        /**
         * 只需要k长度是数组做缓存即可
         *
         * @param nums
         * @param k
         */
        public void rotateK(int[] nums, int k) {
            k = k % nums.length;
            int[] temp = new int[k];
            System.arraycopy(nums, nums.length - k, temp, 0, k);
            System.arraycopy(nums, 0, nums, k, nums.length - k);
            System.arraycopy(temp, 0, nums, 0, k);
        }

        /**
         * 数组clone
         *
         * @param nums
         * @param k
         */
        public void rotateClone(int[] nums, int k) {
            k = k % nums.length;
            int[] temp = nums.clone();
            System.arraycopy(temp, 0, nums, k, nums.length - k);
            System.arraycopy(temp, nums.length - k, nums, 0, k);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
package com.shawn.algorithm.leetcode.editor.cn;
//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nu
//ms2 的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//输出：[1,2,2,3,5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1], m = 1, nums2 = [], n = 0
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m + n 
// nums2.length == n 
// 0 <= m, n <= 200 
// 1 <= m + n <= 200 
// -109 <= nums1[i], nums2[i] <= 109 
// 
// Related Topics 数组 双指针 
// 👍 963 👎 0

/**
 * 合并两个有序数组
 *
 * @author shawn
 * @date 2021-05-30 15:56:28
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
        int[] nums1 = {1, 2, 3, 4, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        solution.merge(nums1, 4, nums2, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 简洁的代码
         * @param nums1
         * @param m
         * @param nums2
         * @param n
         */
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int tail1 = m - 1, tail2 = n - 1, finished = m + n - 1;
            while (tail1 >= 0 && tail2 >= 0) {
                nums1[finished--] = (nums1[tail1] > nums2[tail2]) ?
                        nums1[tail1--] : nums2[tail2--];
            }

            while (tail2 >= 0) { //only need to combine with remaining nums2
                nums1[finished--] = nums2[tail2--];
            }
        }
        /**
         * 参考官方双指针优化
         *
         * @param nums1
         * @param m
         * @param nums2
         * @param n
         */
        public void merge2(int[] nums1, int m, int[] nums2, int n) {
            int i = m - 1, j = n - 1;
            for (int k = nums1.length - 1; k >= 0; k--) {
                if (i < 0) {
                    nums1[k] = nums2[j];
                    j--;
                } else if (j < 0) {
                    break;
                } else {
                    if (nums1[i] > nums2[j]) {
                        nums1[k] = nums1[i];
                        i--;
                    } else {
                        nums1[k] = nums2[j];
                        j--;
                    }
                }
            }
        }

        /**
         * 我的解答
         *
         * @param nums1
         * @param m
         * @param nums2
         * @param n
         */
        public void mergeMy(int[] nums1, int m, int[] nums2, int n) {
            for (int k = nums1.length - 1; k >= n; k--) {
                nums1[k] = nums1[k - n];
            }
            int i = n, j = 0;
            for (int k = 0; k < nums1.length; k++) {
                if (i >= nums1.length) {
                    nums1[k] = nums2[j];
                    j++;
                } else if (j >= n) {
                    break;
                } else {
                    if (nums1[i] < nums2[j]) {
                        nums1[k] = nums1[i];
                        i++;
                    } else {
                        nums1[k] = nums2[j];
                        j++;
                    }
                }

            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
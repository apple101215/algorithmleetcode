package com.shawn.algorithm.leetcode.editor.cn;
//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,-1], k = 1
//输出：[1,-1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [9,11], k = 2
//输出：[11]
// 
//
// 示例 5： 
//
// 
//输入：nums = [4,-2], k = 2
//输出：[4] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window 
// 👍 1001 👎 0

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 滑动窗口最大值
 *
 * @author shawn
 * @date 2021-05-29 21:56:49
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 保存数组下标的方式
         * @param nums
         * @param k
         * @return
         */
        public int[] maxSlidingWindow(int[] nums, int k) {
            int[] result = new int[nums.length - k + 1];
            Deque<Integer> window = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                while (!window.isEmpty() && nums[window.peekLast()] < nums[i]) {
                    window.pollLast();
                }
                window.addLast(i);
                if (window.element() < i + 1 - k) {
                    window.pollFirst();
                }
                if (i + 1 >= k) {
                    result[i + 1 -k] = nums[window.element()];
                }
            }
            return result;
        }

        /**
         * 优先队列升级版
         * @param nums
         * @param k
         * @return
         */
        public int[] maxSlidingWindowPreUp(int[] nums, int k) {
            int n = nums.length;
            PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
                public int compare(int[] pair1, int[] pair2) {
                    return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
                }
            });
            for (int i = 0; i < k; ++i) {
                pq.offer(new int[]{nums[i], i});
            }
            int[] ans = new int[n - k + 1];
            ans[0] = pq.peek()[0];
            for (int i = k; i < n; ++i) {
                pq.offer(new int[]{nums[i], i});
                while (pq.peek()[1] <= i - k) {
                    pq.poll();
                }
                ans[i - k + 1] = pq.peek()[0];
            }
            return ans;
        }

        /**
         * 优先队列暴力求解
         * @param nums
         * @param k
         * @return
         */
        public int[] maxSlidingWindowPre(int[] nums, int k) {
            int[] result = new int[nums.length - k + 1];
            PriorityQueue<Integer> window = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
            for (int i = 0; i < k; i++) {
                window.offer(nums[i]);
            }
            result[0] = window.element();
            for (int i = k; i < nums.length; i++) {
                window.remove(nums[i-k]);
                window.offer(nums[i]);
                result[i - k + 1] = window.element();
            }
            return result;
        }


        /**
         * 暴力求解
         *
         * @param nums
         * @param k
         * @return
         */
        public int[] maxSlidingWindowForce(int[] nums, int k) {
            int[] result = new int[nums.length - k + 1];
            Deque<Integer> target = new LinkedList<>();
            for (int i = 0; i < k; i++) {
                target.addLast(nums[i]);
            }
            result[0] = target.stream().max(Integer::compareTo).orElse(0);
            for (int i = k; i < nums.length; i++) {
                target.pollFirst();
                target.addLast(nums[i]);
                result[i + 1 - k] = target.stream().max(Integer::compareTo).orElse(0);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
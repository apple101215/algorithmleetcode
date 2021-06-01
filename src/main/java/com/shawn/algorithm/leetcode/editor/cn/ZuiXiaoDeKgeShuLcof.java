package com.shawn.algorithm.leetcode.editor.cn;
//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法 
// 👍 246 👎 0

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 最小的k个数
 *
 * @author shawn
 * @date 2021-06-01 22:27:12
 */
public class ZuiXiaoDeKgeShuLcof {
    public static void main(String[] args) {
        Solution solution = new ZuiXiaoDeKgeShuLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] getLeastNumbers(int[] arr, int k) {
            Arrays.sort(arr);
            int[] result = new int[k];
            System.arraycopy(arr, 0, result, 0, k);
            return result;
        }
        /**
         * 使用优先队列堆排完成
         * @param arr
         * @param k
         * @return
         */
        public int[] getLeastNumbersP(int[] arr, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(arr.length, Integer::compareTo);
            for (int a : arr) {
                queue.add(a);
            }
            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                result[i] = queue.remove();
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
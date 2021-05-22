package com.shawn.algorithm.leetcode.editor.cn;
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 1064 👎 0

/**
 * 移动零
 *
 * @author shawn
 * @date 2021-05-22 20:14:00
 */
public class MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
        int[] nums = {0, 1, 0, 3, 12};
        solution.moveZeroes(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[j] = nums[i];
                    if (i != j) {
                        //判断i!=j是为了防止i=j的时候， nums[j]被重新赋值成0
                        nums[i] = 0;
                    }
                    j++;
                }
            }
        }

        public void moveZeroesSnowBall(int[] nums) {
            int snowBallSize = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    snowBallSize++;
                } else if (snowBallSize > 0) {
                    nums[i - snowBallSize] = nums[i];
                    nums[i] = 0;
                }
            }
        }

        public void myMoveZeroes(int[] nums) {
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[index] = nums[i];
                    index++;
                }
            }
            for (int i = index; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
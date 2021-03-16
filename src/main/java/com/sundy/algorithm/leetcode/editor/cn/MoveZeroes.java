package com.sundy.algorithm.leetcode.editor.cn;
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
// 👍 987 👎 0

import com.alibaba.fastjson.JSON;

/**
 * 移动零
 * 解法1(优秀)：index
 * 解法2：new int[]
 * 解法3：loop，count zeroes
 * 解法4：在1的基础上直接交换，因为一直将i和j之间的元素赋值为0，所以交换也就相当于0和非0的交换
 * 解法5；在1的基础上，为了减少判断i!= j,直接在赋值前面加i>j或者i!=j的判断
 * 解法6：在1的基础上，一开始不赋值0，最后再赋值0
 * 解法7(优秀)：在3的基础上，滚雪球算法，nums[i] != 0判断加上countZeroes>0
 * @author shawn
 * @date 2021-03-14 14:18:15
 */
public class MoveZeroes{
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
        int[] nums = new int[]{0,1,0,3,12};
        //方法1
//        solution.moveZeroes(nums);
        //方法2
//        nums = solution.moveZeroes2(nums);
//        solution.moveZeroesAfterOneDay(nums);
        solution.moveZeroesSnowBallAfterOneDay(nums);

        System.out.println(JSON.toJSONString(nums));
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes1(int[] nums) {
       int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if(i != j){
                    //判断i!=j是为了防止i=j的时候， nums[j]被重新赋值成0
                    nums[i] = 0;
                }
                j++;
            }
        }
    }


    public int[] moveZeroes2(int[] nums) {
        int[] result = new int[nums.length];
        int j=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
               result[j++] = nums[i];
            }
        }
        return result;
    }

    public void moveZeroes3(int[] nums) {
        int countZeroes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                countZeroes ++;
            }
            if (nums[i] != 0) {
                nums[i-countZeroes] = nums[i];
                nums[i] = 0;
            }
        }
        for (int j = nums.length - countZeroes; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

    public void moveZeroes4(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
           if(nums[i] != 0){
               int temp = nums[i];
               nums[i] = nums[j];
               nums[j] = temp;
               j++;
           }
        }


    }

    public void moveZeroes5(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 ) {
                if (j != i) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
               j++;
            }
        }

    }

    public void moveZeroes6(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        while (j < nums.length) {
            nums[j++] = 0;
        }
    }

    public void moveZeroes(int[] nums) {
        int snowBallCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                snowBallCount++;
                continue;
            }

            if (nums[i] != 0 && snowBallCount > 0) {
                //必须判断snowBallCount >0，否则nums[i] = 0会错误，入参为[1]的时候，会出错
                nums[i-snowBallCount] = nums[i];
                nums[i] = 0;
            }

        }
    }


    public void moveZeroesAfterOneDay(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if(i != j){
                    nums[i] = 0;
                }
                j++;
            }
        }
    }


    public void moveZeroesSnowBallAfterOneDay(int[] nums) {
        int snowBallCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                snowBallCount ++;
            }
            if (nums[i] != 0 && snowBallCount > 0){
                nums[i-snowBallCount] = nums[i];
                nums[i] = 0;
            }
        }




    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
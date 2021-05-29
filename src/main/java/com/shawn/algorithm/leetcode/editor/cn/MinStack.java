package com.shawn.algorithm.leetcode.editor.cn;
//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) —— 将元素 x 推入栈中。 
// pop() —— 删除栈顶的元素。 
// top() —— 获取栈顶元素。 
// getMin() —— 检索栈中的最小元素。 
// 
//
// 
//
// 示例: 
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// pop、top 和 getMin 操作总是在 非空栈 上调用。 
// 
// Related Topics 栈 设计 
// 👍 914 👎 0

import java.util.Arrays;
import java.util.Stack;

/**
 * 最小栈
 * @author shawn
 * @date 2021-05-29 10:39:54
 */
public class MinStackSolution{
    public static void main(String[] args) {
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class MinStack {
    Stack<Integer> data = new Stack<>();
    Stack<Integer> minData = new Stack<>();
    /** initialize your data structure here. */
    public MinStack() {
    }
    
    public void push(int val) {
        data.push(val);
        if (minData.empty() || minData.peek() >= val) {
            minData.push(val);
        }
    }
    
    public void pop() {
        Integer pop = data.pop();
        if (minData.peek().equals(pop)) {
            minData.pop();
        }
    }
    
    public int top() {
        return data.peek();
    }
    
    public int getMin() {
        return minData.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)
class MyMinStack {
    int[] elementData;
    int elementCount = 0;
    /** initialize your data structure here. */
    public MyMinStack() {
        elementData = new int[100];
    }

    public void push(int val) {
        ensureCap(elementCount + 1);
        elementData[elementCount] = val;
        elementCount ++;
    }
    private void ensureCap(int len) {
        if (elementData.length < len) {
            elementData = Arrays.copyOf(elementData, elementCount * 2);
        }
    }

    public void pop() {
        elementCount--;
    }

    public int top() {
        return elementData[elementCount - 1];
    }

    public int getMin() {
        int min = elementData[0];
        for (int i = 1; i < elementCount; i++) {
            if (elementData[i] < min) {
                min = elementData[i];
            }
        }
        return min;
    }
}

}
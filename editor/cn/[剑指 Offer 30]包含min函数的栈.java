import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 各函数的调用总次数不超过 20000 次
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/
 * Related Topics 栈 设计 👍 320 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {
    Stack<Integer> s = new Stack<>();
    int min = Integer.MAX_VALUE;

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        s.push(min);
        if (x < min) {
            min = x;
        }
        s.push(x);
    }

    public void pop() {
        s.pop();
        min = s.peek();
        s.pop();
    }

    public int top() {
        return s.peek();
    }

    public int min() {
        return min;
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
//leetcode submit region end(Prohibit modification and deletion)

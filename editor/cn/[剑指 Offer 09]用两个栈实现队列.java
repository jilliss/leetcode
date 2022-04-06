import java.util.Iterator;
import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能
 * 。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 * <p>
 * Related Topics 栈 设计 队列 👍 494 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class CQueue {
    Stack<Integer> head = new Stack<>();
    Stack<Integer> tail = new Stack<>();
    int size = 0;

    public CQueue() {

    }

    public void appendTail(int value) {
        tail.push(value);
        ++size;
    }

    public int deleteHead() {
        if (size == 0) {
            return -1;
        }
        if (head.empty()) {
            while (!tail.empty()) {
                head.push(tail.pop());
            }
        }
        size--;
        return head.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)

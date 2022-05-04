import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是
 * O(1)。
 * <p>
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 * <p>
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * <p>
 * 1 <= push_back,pop_front,max_value的总操作数 <= 10000
 * 1 <= value <= 10^5
 * <p>
 * Related Topics 设计 队列 单调队列 👍 360 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class MaxQueue59 {
    Deque<Integer> q;
    Deque<Integer> help;


    public MaxQueue59() {
        q = new ArrayDeque<>();
        help = new ArrayDeque<>();
    }

    public int max_value() {
        if (q.isEmpty()) {
            return -1;
        } else {
            return help.peek();
        }
    }

    public void push_back(int value) {
        q.offer(value);
        while (!help.isEmpty() && value > help.peekLast()) {
            help.pollLast();
        }
        help.offer(value);
    }

    public int pop_front() {
        if (q.isEmpty()) {
            return -1;
        }
        int val = q.pop();
        if(help.peek() == val) {
            help.pop();
        }
        return val;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
//leetcode submit region end(Prohibit modification and deletion)

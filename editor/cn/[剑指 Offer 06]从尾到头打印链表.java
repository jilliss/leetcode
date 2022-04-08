/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 10000
 * Related Topics 栈 递归 链表 双指针 👍 271 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution06 {
    public int[] reversePrint(ListNode head) {
        ListNode node = head;
        // Stack<Integer> stack = new Stack<>();
        // List<Integer> list = new ArrayList<>();
        int count = 0;
        while (node != null) {
            // list.add(node.val);
            // stack.push(node.val);
            count++;
            node = node.next;
        }
        node = head;
        int[] ints = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            ints[i] = node.val;
            node = node.next;
        }
        // int j = 0;
        // for (int i = 0; !stack.isEmpty(); i++) {
        //     ints[i] = stack.pop();
        // }
        return ints;
    }

    // public static void main(String[] args) {
    //     ListNode node = new ListNode(1);
    //     node.next = new ListNode(3);
    //     node.next.next = new ListNode(2);
    //     new Solution().reversePrint(node);
    // }
}
//leetcode submit region end(Prohibit modification and deletion)

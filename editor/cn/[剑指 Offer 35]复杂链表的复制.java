import java.util.HashMap;
import java.util.Map;

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链
 * 表中的任意节点或者 null。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 * 节点数目不超过 1000 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 138 题相同：https://leetcode-cn.com/problems/copy-list-with-random-
 * pointer/
 * <p>
 * <p>
 * Related Topics 哈希表 链表 👍 488 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution35 {
    public Node copyRandomList(Node head) {
        //map中存的是(原节点，拷贝节点)的一个映射
        Map<Node, Node> map = new HashMap<>();
        for (Node cur = head; cur != null; cur = cur.next) {
            map.put(cur, new Node(cur.val));
        }
        //将拷贝的新的节点组织成一个链表
        for (Node cur = head; cur != null; cur = cur.next) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
        }
        return map.get(head);
    }
    //
    // public static void main(String[] args) {
    //     Node node = new Node(7);
    //     node.next = new Node(13);
    //     node.next.random = new Node(0);
    //     node.next.next = new Node(11);
    //     node.next.next.random = new Node(4);
    //     node.next.next.next = new Node(10);
    //     node.next.next.next.random = new Node(2);
    //     node.next.next.next.next = new Node(1);
    //     node.next.next.next.next.random = new Node(0);
    //
    //     new Solution().copyRandomList(node);
    // }
}
//leetcode submit region end(Prohibit modification and deletion)

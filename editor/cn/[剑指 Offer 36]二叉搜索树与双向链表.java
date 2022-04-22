/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * <p>
 * <p>
 * <p>
 * 为了让您更好地理解问题，以下面的二叉搜索树为例：
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一
 * 个节点。
 * <p>
 * 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 426 题相同：https://leetcode-cn.com/problems/convert-binary-search-tree-
 * to-sorted-doubly-linked-list/
 * <p>
 * 注意：此题对比原题有改动。
 * Related Topics 栈 树 深度优先搜索 二叉搜索树 链表 二叉树 双向链表 👍 479 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution36 {
    Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        dfs(root);
        // 左侧 为指向上个节点的指针
        head.left = pre;
        // 右侧 为指向下个节点的指针
        pre.right = head;

        return head;
    }

    /**
     * 前序位置的代码在刚刚进入一个二叉树节点的时候执行；
     * <p>
     * 后序位置的代码在将要离开一个二叉树节点的时候执行；
     * <p>
     * 中序位置的代码在一个二叉树节点左子树都遍历完，即将开始遍历右子树的时候执行。
     *
     * @param cur 二叉树节点
     */
    private void dfs(Node cur) {
        // 递归结束条件
        if (cur == null) {
            return;
        }
        // 最左边的一定是最小的
        // 第一次 pre == null 时 head 节点一定是指向 最小的节点
        dfs(cur.left);
        // 如果pre为空，就说明是第一个节点，头结点，然后用head保存头结点，用于之后的返回
        if (pre == null) {
            // 最小的节点
            head = cur;
        } else {
            // 如果不为空，那就说明是中间的节点。并且pre保存的是上一个节点，
            // 让上一个节点的右指针指向当前节点
            pre.right = cur;
        }
        // 再让当前节点的左指针指向父节点，也就连成了双向链表
        // 第一次进来肯定为null
        cur.left = pre;
        // 保存当前节点，用于下层递归创建
        pre = cur;
        dfs(cur.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

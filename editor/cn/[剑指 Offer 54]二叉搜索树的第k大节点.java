/**
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 *    2
 * 输出: 4
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 4
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * <p>
 * 1 ≤ k ≤ 二叉搜索树元素个数
 * <p>
 * Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 290 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class SolutionO54 {
    int res = 0;

    int count = 0;

    public int kthLargest(TreeNode root, int k) {
        each(root, k);
        return res;
    }

    private void each(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        // 先遍历右边的，这样就是从大到小了
        if (node.right != null) {
            each(node.right, k);
        }
        // 中序遍历二叉搜索树得到的结果时有序的
        if (++count == k) {
            res = node.val;
            return;
        }
        if (node.left != null) {
            each(node.left, k);
        }


    }
}
//leetcode submit region end(Prohibit modification and deletion)

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * <p>
 * 例如:
 * 给定的树 A:
 * <p>
 * 3
 * / \
 * 4 5
 * / \
 * 1 2
 * 给定的树 B：
 * <p>
 * 4
 * /
 * 1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 10000
 * Related Topics 树 深度优先搜索 二叉树 👍 535 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return true;
        }
        // Queue<TreeNode> q = new LinkedList<>();
        // q.add(A);
        // while (!q.isEmpty()) {
        //     TreeNode poll = q.poll();
        //     boolean b = eachTree(poll, B);
        //     if (b) {
        //         return true;
        //     }
        //     if (poll.left != null){
        //         q.add(poll.left);
        //     }
        //     if (poll.right != null){
        //         q.add(poll.right);
        //     }
        // }
        if (eachTree(A,B)){
            return true;
        }
        if (isSubStructure(A.left, B)){
            return true;
        }
        if (isSubStructure(A.right, B)){
            return true;
        }
        return false;

        // return false;
    }

    private boolean eachTree(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        if (A.val == B.val) {
            boolean l = eachTree(A.left, B.left);
            boolean r = eachTree(A.right, B.right);
            return l || r;
        }


        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

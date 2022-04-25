/**
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 返回 true 。
 * <p>
 * 示例 2:
 * <p>
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * <p>
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * <p>
 * <p>
 * 返回 false 。
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * <p>
 * 0 <= 树的结点个数 <= 10000
 * <p>
 * <p>
 * 注意：本题与主站 110 题相同：https://leetcode-cn.com/problems/balanced-binary-tree/
 * <p>
 * <p>
 * Related Topics 树 深度优先搜索 二叉树 👍 270 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class SolutionO55tow {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int l = traverse(root.left);
        int r = traverse(root.right);
        return Math.abs(l - r) > 1;
    }
    private int traverse(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = traverse(node.left);
        int r = traverse(node.right);
        return Math.max(l, r) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

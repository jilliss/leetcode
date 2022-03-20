/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：root = []
 * 输出：true
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树中的节点数在范围 [0, 5000] 内
 * -10⁴ <= Node.val <= 10⁴
 * <p>
 * Related Topics 树 深度优先搜索 二叉树 👍 930 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution110 {
    boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        maxDept(root);
        return isBalanced;
    }


    private int maxDept(TreeNode root) {
        if (!isBalanced) {
            return -1;
        }
        if (root == null) {
            return 0;
        }
        int left = maxDept(root.left);
        int right = maxDept(root.right);
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }

        return 1 + Math.max(left, right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

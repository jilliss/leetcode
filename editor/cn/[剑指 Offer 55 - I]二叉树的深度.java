/**
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * <p>
 * 例如：
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 返回它的最大深度 3 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 节点总数 <= 10000
 * <p>
 * <p>
 * 注意：本题与主站 104 题相同：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * <p>
 * Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 186 👎 0
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
class SolutionO55 {
    public int maxDepth(TreeNode root) {

        return 0;
    }


    private int traverse(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = traverse(node.left);
        int r = traverse(node.right);
        // 二叉树 后续遍历 自下而上
        return Math.max(l, r) + 1;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

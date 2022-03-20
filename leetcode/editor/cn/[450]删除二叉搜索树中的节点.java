/**
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节
 * 点的引用。
 * <p>
 * 一般来说，删除节点可分为两个步骤：
 * <p>
 * <p>
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：root = [5,3,6,2,4,null,7], key = 3
 * 输出：[5,4,6,2,null,null,7]
 * 解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: root = [5,3,6,2,4,null,7], key = 0
 * 输出: [5,3,6,2,4,null,7]
 * 解释: 二叉树不包含值为 0 的节点
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * 输入: root = [], key = 0
 * 输出: []
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 节点数的范围 [0, 10⁴].
 * -10⁵ <= Node.val <= 10⁵
 * 节点值唯一
 * root 是合法的二叉搜索树
 * -10⁵ <= key <= 10⁵
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶： 要求算法时间复杂度为 O(h)，h 为树的高度。
 * Related Topics 树 二叉搜索树 二叉树 👍 676 👎 0
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
class Solution450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            //    当左右两边都有节点，获取右侧最小值，或者左侧最大值
            //    因为BSF 左小右大，右侧最小的一定比当前节点的左侧节点大
            //    min <= root.right   root <= root.right
            //    所以 获取到右侧最小值后，与root 交换值不会破坏BSF结构
            //    交换左侧最大值同理 max>= root.left root >= root.left
            TreeNode min = getMin(root.right);
            // 使删除节点的值设置为最小值
            root.val = min.val;
            // 并且删除右侧的最小值节点
            root.right = deleteNode(root.right, min.val);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    private TreeNode getMin(TreeNode root) {
        // 左侧节点一直找到头就是最小的节点
        while (root.left != null) {
            root = root.left;
        }
        return root;


    }


}
//leetcode submit region end(Prohibit modification and deletion)

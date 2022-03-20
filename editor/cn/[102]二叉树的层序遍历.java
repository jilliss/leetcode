/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1]
 * 输出：[[1]]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树中节点数目在范围 [0, 2000] 内
 * -1000 <= Node.val <= 1000
 * <p>
 * Related Topics 树 广度优先搜索 二叉树 👍 1230 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int sz = q.size();
            List<Integer> curList = new ArrayList<>();
            boolean allNodeIsEmpty = true;
            // BSF 每一层
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                curList.add(cur.val);
                if (cur.left != null || cur.right != null) {
                    allNodeIsEmpty = false;
                    // return depth;
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                    // curList.add(cur.left.val);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                    // curList.add(cur.right.val);
                }
            }
            if (!curList.isEmpty()) {
                res.add(curList);
            }
            if (allNodeIsEmpty) {
                return res;
            }

        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        // List<List<Integer>> lists = new Solution().levelOrder(root);
        // System.out.println("lists = " + lists);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

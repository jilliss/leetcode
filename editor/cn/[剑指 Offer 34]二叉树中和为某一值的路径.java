/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：[]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：root = [1,2], targetSum = 0
 * 输出：[]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树中节点总数在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 * <p>
 * <p>
 * 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/
 * Related Topics 树 深度优先搜索 回溯 二叉树 👍 326 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

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
class Solution34 {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root,target,res,new LinkedList<>());
        return res;
    }

    private void dfs(TreeNode node, int target,  List<List<Integer>> res,LinkedList<Integer> path) {
        if (node == null || node.val > target) {
            return;
        }
        int i = target - node.val;
        if (node.left == null && node.right == null){
            if (i == 0){
                path.add(node.val);
                res.add(new ArrayList<>(path));
                // 这里删除是因为 退出此次递归 左节点或右节点可能还有解
                path.removeLast();
            }
            return;
        }
        // 选择 取消选择
        path.add(node.val);
        dfs(node.left, i, res, path);
        path.removeLast();

        path.add(node.val);
        dfs(node.right,i,res,path);
        path.removeLast();

    }
}
//leetcode submit region end(Prohibit modification and deletion)

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个
 * 节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5]
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 * <p>
 * <p>
 * <p>
 * 说明:
 * <p>
 * <p>
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 * <p>
 * <p>
 * 注意：本题与主站 235 题相同：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-
 * binary-search-tree/
 * Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 226 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class SolutionO68 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val == root.val) {
            return p;
        }
        if (q.val == root.val) {
            return q;
        }
        // 前序遍历，一层一层找
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }

    private TreeNode search(TreeNode root, TreeNode p) {
        Integer.valueOf(1);
        new ArrayList<>().remove(1);
        new LinkedList<>().remove(1);
        TreeNode sp = root;
        TreeNode csp = root;
        while (sp.val != p.val) {
            csp = sp;
            if (sp.val > p.val) {
                sp = sp.left;
            } else {
                sp = sp.right;
            }
        }
        return csp;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(3);
        node.right = new TreeNode(6);
        node.left.left = new TreeNode(2);
        node.left.right = new TreeNode(4);
        // node.right.left =new TreeNode(7);
        // node.right.right =new TreeNode(9);
        node.left.left.left = new TreeNode(1);
        // node.left.right.right =new TreeNode(5);
        // [5,3,6,2,4,null,null,1]
        // 1
        // 4
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        new SolutionO68().lowestCommonAncestor(node, node1, node2);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

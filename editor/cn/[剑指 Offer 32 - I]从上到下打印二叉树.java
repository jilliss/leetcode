/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * <p>
 * <p>
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * <p>
 * 返回：
 * <p>
 * [3,9,20,15,7]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 节点总数 <= 1000
 * <p>
 * Related Topics 树 广度优先搜索 二叉树 👍 186 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution32 {
    public int[] levelOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        res.add(root.val);
        // each(root.left, res);
        // each(root.right, res);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            res.add(node.val);
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
        int[] arr = new int[res.size()];
        for (int j = 0, resSize = res.size(); j < resSize; j++) {
            Integer i = res.get(j);
            arr[j] = i;
        }
        return arr;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!q.isEmpty()) {
            List<Integer> item = new ArrayList<>();
            int size = q.size();
            while (size > 0) {
                TreeNode node = q.poll();
                item.add(node.val);
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
                size--;
            }
            res.add(item);
        }

        return res;
    }


    public List<List<Integer>> levelOrder3(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<List<Integer>> res = new ArrayList<>();
        boolean b = false;
        Stack<TreeNode> stack = new Stack<>();
        while (!q.isEmpty()) {
            List<Integer> item = new ArrayList<>();
            int size = q.size();
            while (size > 0) {
                TreeNode node = q.poll();
                item.add(node.val);
                if (!b) {
                    if (node.left != null) {
                        stack.push(node.left);
                        // q.add(node.left);
                    }
                    if (node.right != null) {
                        stack.push(node.right);
                        // q.add(node.right);
                    }
                } else {
                    if (node.right != null) {
                        // q.add(node.right);
                        stack.push(node.right);
                    }
                    if (node.left != null) {
                        stack.push(node.left);
                        // q.add(node.left);
                    }
                }
                size--;
            }
            for (int i = stack.size() - 1; i >= 0; i--) {
                q.add(stack.pop());
            }
            b = !b;
            res.add(item);
        }

        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

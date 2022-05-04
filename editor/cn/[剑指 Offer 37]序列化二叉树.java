/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * <p>
 * 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
 * 反序列化为原始的树结构。
 * <p>
 * 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解
 * 决这个问题。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-
 * binary-tree/
 * Related Topics 树 深度优先搜索 广度优先搜索 设计 字符串 二叉树 👍 299 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)

import javax.swing.*;
import java.util.LinkedList;
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
class Codec {

    public static final String NULL = "null";
    public static final String COMMA = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NULL).append(COMMA);
            return;
        }
        sb.append(node.val).append(COMMA);
        serialize(node.left, sb);
        serialize(node.right, sb);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data)) {
            return null;
        }
        String[] split = data.split(COMMA);
        LinkedList<Integer> list = new LinkedList<>();
        for (String s : split) {
            if (NULL.equals(s)) {
                list.add(null);
            } else {
                list.add(Integer.parseInt(s));
            }
        }

        return deserialize(list);
    }

    private TreeNode deserialize(LinkedList<Integer> list) {
        if (list.isEmpty()) {
            return null;
        }
        Integer val = list.removeFirst();

        TreeNode root;
        if (val == null) {
            return null;
        } else {
            root = new TreeNode(val);
        }
        root.left = deserialize(list);
        root.right = deserialize(list);
        return root;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

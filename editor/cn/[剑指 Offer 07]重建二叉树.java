/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * <p>
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 * <p>
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
 * preorder-and-inorder-traversal/
 * Related Topics 树 数组 哈希表 分治 二叉树 👍 766 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;
import java.util.HashMap;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution07 {
    HashMap<Integer, Integer> valToIndex = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, 0);
    }

    TreeNode build(int[] preorder, int preStart, int preEnd,
                   int inStart) {
        if (preStart > preEnd) {
            return null;
        }
        // root 节点对应的值就是前序遍历数组的第一个元素
        int rootVal = preorder[preStart];
        // rootVal 在中序遍历数组中的索引
        int index = valToIndex.get(rootVal);

        int leftSize = index - inStart;

        // 先构造出当前根节点
        TreeNode root = new TreeNode(rootVal);
        /*
        前序数组 第一个就是root节点
        第二个就是root.left 节点
         */
        // 递归构造左右子树
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inStart);
        /*
        前序数组寻找右节点计算
        在中序数组中root节点的下标
        0~index） 为左侧子树的长度
        （index ~  inorder.length -1  为右侧子树的长度
        前序root节点下标+左侧子树长度+1
        中序遍历起始下标+1 用于下一层的子节点构建
         */
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                index + 1);
        return root;
    }


    public static int countOnes(int n) {
        // 在这⾥写代码
        //位因子
        long cur = 1;
        int count = 0;
        while ( cur <= n){
            //高位
            int high = (int) (n / (cur * 10));
            //低位
            int low = (int) (n - (n / cur) * cur);
            //当前位
            int current = (int) ((n / cur) % 10);
            if (current == 0){
                count = (int) (count + high * cur);
            }else if (current == 1){
                count = (int) (count + high * cur + low + 1);
            }else {
                count = (int) (count + (high + 1) * cur);
            }
            cur = cur * 10;
        }
        return count;
    }

    public static void main(String[] args) {
        // int i = countOnes(13);
        // System.out.println("i = " + i);
        // int[]a = new int[]{1,2,3,4,5};
        // int[] res = new int[a.length];
        // for (int i = 0, cur = 1; i < a.length; i++) {
        //     // 先乘左边的数(不包括自己)
        //     res[i] = cur;
        //     cur *= a[i];
        // }
        // System.out.println("res = " + Arrays.toString(res));

    }



}
//leetcode submit region end(Prohibit modification and deletion)




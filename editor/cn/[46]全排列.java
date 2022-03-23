import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [1]
 * 输出：[[1]]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 * <p>
 * Related Topics 数组 回溯 👍 1868 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> select = new LinkedList<>();
        backtracking(nums, select, res);
        return res;
    }


    private void backtracking(int[] path, LinkedList<Integer> select, List<List<Integer>> res) {
        if (path.length == select.size()) {
            // 递归出去会删掉，所以拷贝一份
            res.add(new ArrayList<>(select));
            return;
        }
        for (int item : path) {
            if (select.contains(item)) {
                continue;
            }
            // 双向链表默认插入到最后
            select.add(item);
            backtracking(path, select, res);
            // 移除选择
            select.removeLast();
        }
    }

    // public static void main(String[] args) {
    //     new Solution().permute(new int[]{1, 2, 3});
    // }

}
//leetcode submit region end(Prohibit modification and deletion)

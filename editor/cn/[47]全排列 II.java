import java.util.*;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 * <p>
 * Related Topics 数组 回溯 👍 978 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution47 {
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> select = new LinkedList<>();
        used = new boolean[nums.length];
        backtracking(nums, select, res);
        return res;
    }

    private void backtracking(int[] path, LinkedList<Integer> select, List<List<Integer>> res) {
        if (path.length == select.size()) {
            // 递归出去会删掉，所以拷贝一份
            LinkedList<Integer> selectValue = new LinkedList<>();
            for (Integer i : select) {
                int value = path[i];
                selectValue.add(value);
            }

            res.add(selectValue);
            return;
        }
        for (int i = 0, pathLength = path.length; i < pathLength; i++) {

            if (used[i]) {
                continue;
            }
            // 新添加的剪枝逻辑，固定相同的元素在排列中的相对位置
            if (i > 0 && path[i] == path[i - 1] && !used[i - 1]) {
                // 如果前面的相邻相等元素没有用过，则跳过
                continue;
            }
            // 双向链表默认插入到最后
            // 选择的索引，这个不会重复
            used[i] = true;
            select.add(i);
            backtracking(path, select, res);
            // 移除选择
            used[i] = false;
            select.removeLast();
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

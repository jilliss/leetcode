import java.util.*;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 * <p>
 * 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/
 * Related Topics 队列 滑动窗口 单调队列 堆（优先队列） 👍 433 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution59{
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0){
            return new int[]{};
        }
        int length = nums.length;
        // 传入比较方法，使小顶堆变成大顶堆
        Queue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        // 窗口用双向链表 删除更方便
        LinkedList<Integer> list = new LinkedList<>();
        int[] res = new int[length - k + 1];
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (i < k) {
                // 第一次填充窗口
                q.add(nums[i]);
                list.add(nums[i]);
            } else {
                // 窗口移动
                list.removeFirst();
                Integer max = q.peek();
                res[index++] = max;
                list.add(nums[i]);
                q.clear();
                // 重新初始化大顶堆
                q.addAll(list);
            }
        }
        Integer max = (q.peek());
        res[index] = max;
        q.clear();
        return res;
    }
    private int[] m2(int[] nums,int k){
        // 单调队列解法
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < k; ++i) {
            // 填充窗口 并比较 当前值是否小于 队列末的值
            // 因为队列是单调递减队列
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        int[] ans = new int[n - k + 1];
        // 队头既是窗口最大值
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            // 填充窗口 并比较 当前值是否小于 队列末的值
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            // 判断队头是不是在窗口内 i-k 既是窗口左侧下标
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }
    public static void main(String[] args) {
        // new Solution().m2(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 45
 * <p>
 * Related Topics 记忆化搜索 数学 动态规划 👍 2289 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution70 {

    int dp(int n, int[] memo) {
        // base case
        if (n <= 2) {
            return n;
        }
        if (memo[n] > 0) {
            return memo[n];
        }
        // 状态转移方程：
        // 爬到第 n 级台阶的方法个数等于爬到 n - 1 的方法个数和爬到 n - 2 的方法个数之和。
        memo[n] = dp(n - 1, memo) + dp(n - 2, memo);
        return memo[n];
    }

    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return dp(n,memo);
    }

    // public static void main(String[] args) {
    //     int i = new Solution().climbStairs(3);
    // }
}
//leetcode submit region end(Prohibit modification and deletion)

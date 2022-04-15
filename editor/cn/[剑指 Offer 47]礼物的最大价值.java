/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到
 * 达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 < grid.length <= 200
 * 0 < grid[0].length <= 200
 * <p>
 * Related Topics 数组 动态规划 矩阵 👍 280 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionO47 {
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n + 1];
        for (int i = 1; i < m; i++) {
            for (int k = 1; k < n; k++) {
                // 滚动数组 因为 i 在这个循环里面是不变的，所以，i,i-1都可以去掉，转换成一维数组
                // dp[i][k] = max(dp[i][k-1],dp[i-1][k])+grid[i -1][k -1]
                dp[k] = Math.max(dp[k], dp[k - 1]) + grid[i - 1][k - 1];
            }

        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

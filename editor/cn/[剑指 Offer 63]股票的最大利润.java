import static java.lang.Math.max;

/**
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 数组长度 <= 10^5
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 121 题相同：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-
 * stock/
 * Related Topics 数组 动态规划 👍 238 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution63 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[2][n];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                dp[0][i] = 0;
                // 第一天买入 利润为负数
                dp[1][i] = -prices[i];
                continue;
            }
            /*
             * 满足今天没有，两种可能
             * 昨天没有，今天不操作，所以今天还是没有
             * 昨天有，今天卖出，所以今天还是没有股票
             * 昨天有，今天不卖出，不符合状态所以不考虑
             */
            // 今天没有           不操作      ，      卖出利润增加
            dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1] + prices[i]);
            /*
             * 满足今天又，有两种情况
             * 昨天有，今天不操作，利润为昨天的利润
             * 昨天没有，今天买入，利润减少 直接取 -prices[i]
             * 昨天没有，今天不操作，不符合状态
             */
            // 今天持有           不操作      ，买入利润减少
            dp[1][i] = Math.max(dp[1][i - 1], -prices[i]);
        }
        return dp[n - 1][0];
    }

    int maxProfit_k_1(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        return dp_i_0;
    }

    private int maxProfit_all_in_one(int max_k, int[] prices, int cooldown, int fee) {
        int n = prices.length;
        if (max_k > n / 2) {
            return maxProfit_k_inf(prices, cooldown, fee);
        }
        int[][][] dp = new int[2][n][max_k + 1];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < max_k; k++) {
                if (i - 1 == -1) {
                    dp[0][i][k] = 0;
                    dp[1][i][k] = -prices[i] - fee;
                    continue;
                }

                if (i - cooldown - 1 == -1) {
                    dp[0][i][k] = Math.max(dp[0][i - 1][k], dp[1][i - 1][k] + prices[i]);
                    dp[1][i][k] = Math.max(dp[0][i - 1][k], -prices[i] - fee);
                    continue;
                }
                dp[0][i][k] = Math.max(dp[0][i - 1][k], dp[1][i - 1][k] + prices[i]);
                dp[1][i][k] = Math.max(dp[0][i - 1][k], dp[0][i - cooldown - 1][k] - prices[i] - fee);
            }
        }
        return dp[0][n - 1][max_k];
    }

    /**
     * k 无限制，包含手续费和冷冻期
     *
     * @param cooldown 冷冻期
     * @param fee      手续费
     * @param prices   股票价格
     */
    int maxProfit_k_inf(int[] prices, int cooldown, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                // base case 1
                dp[i][0] = 0;
                dp[i][1] = -prices[i] - fee;
                continue;
            }

            // 包含 cooldown 的 base case
            if (i - cooldown - 1 < 0) {
                // base case 2
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                // 别忘了减 fee
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i] - fee);
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 同时考虑 cooldown 和 fee
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - cooldown - 1][0] - prices[i] - fee);
        }
        return dp[n - 1][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

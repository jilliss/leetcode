/**
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * <p>
 * <p>
 * <p>
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: 2
 * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.0
 * 5556,0.02778]
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= n <= 11
 * Related Topics 数学 动态规划 概率与统计 👍 416 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution60 {
    public double[] dicesProbability(int n) {
        //直接使用动态规划：
        //思路：
        //定义 dp[i][j] 表示投了 i 个色子，点数为 j 的概率
        //现由投了 i-1 个色子来递推 i 的情况：，由于一个色子只能加数值 1-6,所以有以下情况：
        // dp[i-1][j-1],dp[i-1][j-2],...dp[i-1][j-k] 代表除去最后一个色子的点数的概率，而最后一个色子投任意数的概率为 1/6
        //所以有状态转移方程 dp[i][j] = (求和k从1到6) dp[i-1][j-k] * 1/6

        //n个色子投掷结果 [n,6n],共 5n+1个数
        double[] ans = new double[5 * n + 1];
        double[][] dp = new double[n + 1][6 * n + 1];

        //初始化 一个骰子 全是1/6
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1 / 6.0;
        }

        //状态转移方程
        for (int i = 2; i <= n; i++) {
            // i 个色子的点数范围 [i,6i]
            for (int j = i; j <= 6 * i; j++) {
                // dp[i][j] 表示投了 i 个色子，点数为 j 的概率
                for (int k = 1; k <= 6; k++) {
                    //j-k大于0是有意义的   1 <= k <= 6
                    if (j - k > 0) {
                        //注意此处求和
                        dp[i][j] += dp[i - 1][j - k] * 1 / 6.0;
                    }
                    //当出现j-k = 0了，抛弃之后 = -1，-2...的情况
                    else {
                        break;
                    }
                }
            }
        }

        //将二维数组等于n个色子的情况数值赋值给一维数组结果
        //注意 dp的点数从 n开始算
        if (5 * n + 1 >= 0) {
            System.arraycopy(dp[n], n, ans, 0, 5 * n + 1);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

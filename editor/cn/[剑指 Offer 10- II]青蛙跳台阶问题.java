/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：2
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 7
 * 输出：21
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：n = 0
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= n <= 100
 * <p>
 * <p>
 * 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/
 * <p>
 * <p>
 * Related Topics 记忆化搜索 数学 动态规划 👍 271 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution10 {
    public int numWays(int n) {
        int[] memo = new int[n+1];
        return dp(n, memo);
    }

    private int dp(int n, int[] memo) {
        if(n <= 2){
            return  n;
        }
        if (memo[n] > 0){
             return memo[n];
        }


        memo[n] = (dp(n - 1, memo) + dp(n - 2, memo)) % 1000000007;
        return memo[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

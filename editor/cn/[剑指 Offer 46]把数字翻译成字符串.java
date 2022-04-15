/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有
 * 多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= num < 2³¹
 * <p>
 * Related Topics 字符串 动态规划 👍 417 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution46 {
    public int translateNum(int num) {
        if (num < 10) {
            return 1;
        }
        if (num <= 25) {
            return 2;
        }
        String str = String.valueOf(num);
        int[] dp = new int[str.length()];
        // 第一个格子只存在跳一格
        // dp[0] = 1;
        int a = 1;
        // 判断到第二格能否以跳两格的形式
        int b = 1;
        // dp[1] = str.charAt(0) - '0' == 1 || (str.charAt(0) - '0' == 2 && str.charAt(1) - '0' < 6) ? 2 : 1;
        // for (int i = 2; i < dp.length; i++) {
        for (int i = 2; i <= dp.length; i++) {
            int temp = str.charAt(i - 1) - '0';
            // 满足 >=10 <=25 即可跳两格
            // dp[i] = temp == 1 || (temp == 2 && str.charAt(i) - '0' < 6) ? dp[i - 1] + dp[i - 2] : dp[i - 1];
            String tmp = str.substring(i - 2, i);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        // return dp[str.length() - 1];
        return a;
    }

    // public static void main(String[] args) {
    //     new Solution().translateNum(542);
    // }


}
//leetcode submit region end(Prohibit modification and deletion)

/**
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指
 * 字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * <p>
 * <p>
 * 示例 4:
 * <p>
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * <p>
 * <p>
 * 示例 5:
 * <p>
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 * <p>
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母以及字符 . 和 *，无连续的 '*'。
 * <p>
 * <p>
 * 注意：本题与主站 10 题相同：https://leetcode-cn.com/problems/regular-expression-matching/
 * Related Topics 递归 字符串 动态规划 👍 388 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution19 {
    /**
     * 正则匹配 动态规划
     *
     * @param s 字符串
     * @param p 正则
     */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        // f[i][j] 为 长度为i的字符能否和长度为j的正则匹配上
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                // 当前正则符号是【*】
                if (p.charAt(j - 1) == '*') {
                    // 先看前面的正则串匹配么
                    // 如果前面的正则串匹配，*就充当一个任意字符
                    f[i][j] = f[i][j - 2];
                    // * 前面是点 直接匹配
                    if (matches(s, p, i, j - 1)) {
                        // 1.前面正则匹配，*充当任意字符匹配了
                        // 2.前面正则不匹配，*充当任意字符匹配了，则判断上一个字符是否匹配了
                        // 也就是 sata 匹配 s*t* 如果上一个字符匹配补上，*充当任意字符也无意义
                        // sata s*q* 这时 此表达式为false
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                // 当前正则符号不是【*】
                } else {
                    if (matches(s, p, i, j)) {
                        // 前面匹配补上后面匹配上也没用
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

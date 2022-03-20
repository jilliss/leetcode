/**
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: s = "abab"
 * 输出: true
 * 解释: 可由子串 "ab" 重复两次构成。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: s = "aba"
 * 输出: false
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * 输入: s = "abcabcabcabc"
 * 输出: true
 * 解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * <p>
 * <p>
 * 1 <= s.length <= 10⁴
 * s 由小写英文字母组成
 * <p>
 * Related Topics 字符串 字符串匹配 👍 643 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution459 {
    public boolean repeatedSubstringPattern(String s) {
        // String x = s + s;
        // x = x.substring(1, x.length() - 2);
        // if (!x.contains(s)) {
        //     return false;
        // }
        // 双指针
        char[] chars = s.toCharArray();
        for (int i = 1; i <= chars.length / 2; i++) {
            if (chars.length % i != 0) continue;
            int slow = 0;
            int fast = slow + i;
            while (fast < chars.length) {
                if (chars[fast] != chars[slow]) {
                    break;
                }
                fast++;
                slow++;
            }
            if (fast == chars.length) {
                return true;
            }
        }
        return false;
    }

    // public static void main(String[] args) {
    //     new Solution().repeatedSubstringPattern("aabaaba");
    // }
}
//leetcode submit region end(Prohibit modification and deletion)

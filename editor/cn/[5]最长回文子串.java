/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 * <p>
 * Related Topics 字符串 动态规划 👍 4834 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution5 {
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        int[] res = new int[3];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int[] s1 = findStr(chars, i, i);
            int[] s2 = findStr(chars, i, i + 1);
            if (res[2] < s1[2]) {
                res = s1;
            }
            if (res[2] < s2[2]) {
                res = s2;
            }
            // res = res.length > s1.length() ? res : s1;
            // res = res.length() > s2.length() ? res : s2;
        }
        return s.substring(res[0], res[1]);
    }

    private static int[] findStr(char[] chars, int l, int r) {
        //  左右展开
        while (l >= 0 && r < chars.length && chars[l] == chars[r]) {
            l--;
            r++;
        }
        return new int[]{l + 1, r, r - (l + 1)};
    }

    // public static void main(String[] args) {
    //     String s = new Solution().longestPalindrome("babad");
    //     System.out.println("s = " + s);
    //     // s = new Solution().longestPalindrome("cbbd");
    //     // System.out.println("s = " + s);
    //     // s = new Solution().longestPalindrome("ccc");
    //     // System.out.println("s = " + s);
    //     s = new Solution().longestPalindrome("ccd");
    //     System.out.println("s = " + s);
    //     // s = new Solution().longestPalindrome("abb");
    //     // System.out.println("s = " + s);
    //     // s = new Solution().longestPalindrome("ac");
    //     // System.out.println("s = " + s);
    // }
}
//leetcode submit region end(Prohibit modification and deletion)

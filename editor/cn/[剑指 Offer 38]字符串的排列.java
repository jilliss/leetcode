import java.util.*;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * <p>
 * <p>
 * <p>
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * <p>
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= s 的长度 <= 8
 * Related Topics 字符串 回溯 👍 550 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution38 {
    public String[] permutation(String s) {
        Set<String> set = new HashSet<>();
        // String[] split = s.split("");
        int length = s.length();
        boolean[] used = new boolean[length];

        StringBuilder sb = new StringBuilder();
        dfs(set, s, length, used, sb);
        return set.toArray(new String[set.size()]);
    }

    private void dfs(Set<String> set, String s, int n, boolean[] used, StringBuilder sb) {
        if (n == 0) {
            set.add(sb.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            // 上层剪枝
            if (i > 0 && s.charAt(i) == s.charAt(i - 1) && !used[i - 1]) {
                continue;
            }
            if (used[i]) {
                continue;
            }
            used[i] = true;
            sb.append(s.charAt(i));
            dfs(set, s, n - 1, used, sb);
            sb.delete(sb.length() - 1, sb.length());
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        String[] aabcs = new Solution38().permutation("aabc");
        //    ["caab","cbaa","aacb","abca","baca","caba","aabc","acba","abac","acab","baac","bcaa"]
        //    ["abac","abca","acab","acba","aabc","aacb","baca","baac","bcaa","caba","caab","cbaa"]
    }
}
//leetcode submit region end(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.Map;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * s.length <= 40000
 * <p>
 * <p>
 * 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-
 * repeating-characters/
 * Related Topics 哈希表 字符串 滑动窗口 👍 413 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionO48 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 增大窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (window.containsKey(c)) {
                Integer i = window.get(c);
                window.put(c, ++i);
            } else {
                window.put(c, 1);
            }

            // 判断左侧窗口是否要收缩
            while (window.get(c) > 1) {
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 缩小窗口
                left++;
                // 进行窗口内数据的一系列更新
                // if (window.containsKey(d)) {
                Integer i = window.get(d);
                window.put(d, --i);
                // }
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

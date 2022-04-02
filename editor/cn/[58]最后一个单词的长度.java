/**
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * <p>
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "Hello World"
 * 输出：5
 * 解释：最后一个单词是“World”，长度为5。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 * 解释：最后一个单词是“moon”，长度为4。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：s = "luffy is still joyboy"
 * 输出：6
 * 解释：最后一个单词是长度为6的“joyboy”。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 10⁴
 * s 仅有英文字母和空格 ' ' 组成
 * s 中至少存在一个单词
 * <p>
 * Related Topics 字符串 👍 444 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution58 {
    public int lengthOfLastWord(String s) {
        int len = 0;
        for (int i = s.length() - 1; i >= 0; i--) {

            char c = s.charAt(i);
            if (c != ' ') {
                len++;
                //  不为零说明最后一个单词到头了
            } else if (len != 0) {
                return len;
            }
        }
        // String[] s1 = s.split(" ");
        // s1[0]
        // return s1[s1.length - 1].length();
        return len;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

import java.util.Arrays;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：digits = [0]
 * 输出：[1]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * <p>
 * Related Topics 数组 数学 👍 953 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] ++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] temp = new int[digits.length + 1];
        temp[0] = 1;
        return temp;
    }

    // public static void main(String[] args) {
    //     int[] ints = new Solution().plusOne(new int[]{1,9, 9});
    //     System.out.println("ints = " + Arrays.toString(ints));
    // }
}
//leetcode submit region end(Prohibit modification and deletion)

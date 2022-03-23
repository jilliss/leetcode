import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 整数的 数组形式 num 是按照从左到右的顺序表示其数字的数组。
 * <p>
 * <p>
 * 例如，对于 num = 1321 ，数组形式是 [1,3,2,1] 。
 * <p>
 * <p>
 * 给定 num ，整数的 数组形式 ，和整数 k ，返回 整数 num + k 的 数组形式 。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：num = [1,2,0,0], k = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：num = [2,7,4], k = 181
 * 输出：[4,5,5]
 * 解释：274 + 181 = 455
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：num = [2,1,5], k = 806
 * 输出：[1,0,2,1]
 * 解释：215 + 806 = 1021
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= num.length <= 10⁴
 * 0 <= num[i] <= 9
 * num 不包含任何前导零，除了零本身
 * 1 <= k <= 10⁴
 * <p>
 * Related Topics 数组 数学 👍 189 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution989 {
    public List<Integer> addToArrayForm(int[] num, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        int length = num.length;
        int i = length - 1;

        while (i >= 0 || k > 0) {
            if (i >= 0) {
                k += num[i];
            }
            res.addFirst(k % 10);
            k /= 10;
            i--;

        }

        return res;
    }

    // public static void main(String[] args) {
    //     System.out.println("34%10 = " + 34 % 10);
    //     System.out.println("34%10 = " + 34 / 10);
    // }
}
//leetcode submit region end(Prohibit modification and deletion)

import java.util.Arrays;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= num1.length, num2.length <= 200
 * num1 和 num2 只能由数字组成。
 * num1 和 num2 都不包含任何前导零，除了数字0本身。
 * <p>
 * Related Topics 数学 字符串 模拟 👍 871 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution43 {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        for (int i = chars1.length - 1; i >= 0; i--) {
            for (int j = chars2.length - 1; j >= 0; j--) {
                // 字符 >= 1 所以 直接减去 '0' 就是对应的int数值
                int mul = (chars1[i] - '0') * (chars2[j] - '0');
                // 乘机对应起止索引
                int p1 = i + j, p2 = i + j + 1;
                // 叠加, 算是后面进来的
                int sum = mul + res[p2];
                // 小的，靠前的是 十位
                res[p1] += sum / 10;
                // 大的，靠后的是 个位
                res[p2] = sum % 10;
            }


        }
        int index = 0;
        while (index < res.length && res[index] == 0) {
            index++;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = index; i < res.length; i++) {
            builder.append(res[i]);
        }
        return builder.toString();

    }

    // public static void main(String[] args) {
    //     new Solution().multiply("123", "456");
    // }
}
//leetcode submit region end(Prohibit modification and deletion)

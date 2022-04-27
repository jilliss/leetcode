import java.math.BigDecimal;

/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 3
 * 输出: 6
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入: n = 9
 * 输出: 45
 * <p>
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * <p>
 * 1 <= n <= 10000
 * <p>
 * Related Topics 位运算 递归 脑筋急转弯 👍 491 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionO64 {
    public int sumNums(int n) {
        int sum = n;
        // 断路 n<0 直接停止递归了  n + n-1 + n-2..... 1;
        boolean flag = n > 0 && (sum += sumNums(n - 1)) > 0;
        return sum;
    }

    public static void main(String[] args) throws InterruptedException {
        Integer a = 1;
        int b = 1;
        Integer c = 1;
        System.out.println(a == c);
        System.out.println(a == b);
        BigDecimal.valueOf(123);
        // Thread.sleep(100000);
        // String s = a.toString();
        // String s1 = String.valueOf(b);
        // System.out.println("a = " + s);
        // System.out.println("a = " + s1);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

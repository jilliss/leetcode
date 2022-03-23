import java.util.Stack;

/**
 * 根据 逆波兰表示法，求表达式的值。
 * <p>
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * <p>
 * 注意 两个整数之间的除法只保留整数部分。
 * <p>
 * 可以保证给定的逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：tokens = ["4","13","5","/","+"]
 * 输出：6
 * 解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * 输出：22
 * 解释：该算式转化为常见的中缀算术表达式为：
 * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= tokens.length <= 10⁴
 * tokens[i] 是一个算符（"+"、"-"、"*" 或 "/"），或是在范围 [-200, 200] 内的一个整数
 * <p>
 * <p>
 * <p>
 * <p>
 * 逆波兰表达式：
 * <p>
 * 逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。
 * <p>
 * <p>
 * 平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。
 * 该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。
 * <p>
 * <p>
 * 逆波兰表达式主要有以下两个优点：
 * <p>
 * <p>
 * 去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
 * 适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中
 * <p>
 * Related Topics 栈 数组 数学 👍 490 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution150 {

    final String add = "+";
    final String minus = "-";
    final String multiply = "*";
    final String divide = "/";

    public int evalRPN(String[] tokens) {

        Stack<String> strings = new Stack<>();
        for (String token : tokens) {
            boolean b = add.equals(token) || minus.equals(token) || multiply.equals(token) || divide.equals(token);
            if (b) {
                if (strings.isEmpty()) {
                    continue;
                }
                String p1 = strings.pop();
                if (strings.isEmpty()) {
                    continue;
                }
                String p2 = strings.pop();
                Integer v1 = Integer.valueOf(p1);
                Integer v2 = Integer.valueOf(p2);
                switch (token) {
                    case add:
                        strings.push(String.valueOf(v1 + v2));
                        break;
                    case minus:
                        strings.push(String.valueOf(v2 - v1));
                        break;
                    case multiply:
                        strings.push(String.valueOf(v1 * v2));
                        break;
                    case divide:
                        // 先进后出 v2/v1
                        strings.push(String.valueOf(v2 / v1));
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + token);
                }
            } else {
                strings.push(token);
            }


        }
        if (strings.isEmpty()) {
            return 0;
        } else {
            return Integer.parseInt(strings.pop());
        }
    }

    // public static void main(String[] args) {
    //     new Solution().evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"});
    // }
}
//leetcode submit region end(Prohibit modification and deletion)

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 👍 2481 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder track= new StringBuilder();
        backtrack(n, n, track, res);
        return res;
    }
    private void backtrack(int left,int right,StringBuilder s,List<String> res){
        if (right < left) {
            return;
        }
        // 数量小于 0 肯定是不合法的
        if (left < 0) {
            return;
        }
        if (left == 0 && right == 0) {
            res.add(s.toString());
            return;
        }
        // 选择
        s.append('(');
        backtrack(left - 1, right, s, res);
        // 撤消选择
        s.delete(s.length()-1,s.length());
        // 尝试放一个右括号
        s.append(')');
        // 选择
        backtrack(left, right - 1, s, res);
        // 撤消选择
        s.delete(s.length()-1,s.length());
    }


}
//leetcode submit region end(Prohibit modification and deletion)

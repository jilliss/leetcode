import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 4
 * 输出：2
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 1
 * 输出：1
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 9
 * <p>
 * <p>
 * <p>
 * Related Topics 回溯 👍 342 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution52 {
    int res;
    final char Q = 'Q';
    final char DOT = '.';

    public int totalNQueens(int n) {
        List<char[]> board = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            char[] s = ".".repeat(n).toCharArray();
            board.add(s);
        }
        backtrack(board, 0);
        return res;
    }

    private void backtrack(List<char[]> board, int row) {
        if (row == board.size()) {
            // List<String> collect = board.stream().map(String::new).collect(Collectors.toList());
            // res.add(new ArrayList<>(collect));
            res++;
            return;
        }
        int n = board.get(row).length;
        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col)) {
                continue;
            }
            board.get(row)[col] = Q;
            backtrack(board, row + 1);
            board.get(row)[col] = DOT;
        }

    }

    private boolean isValid(List<char[]> board, int row, int col) {
        int n = board.size();
        // 检查列是否有皇后互相冲突
        for (char[] chars : board) {
            char s = chars[col];
            if (Q == (s)) {
                return false;
            }
        }
        // 检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            char s = board.get(i)[j];
            if (Q == (s)) {
                return false;
            }
        }
        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            char s = board.get(i)[j];
            if (Q == s) {
                return false;
            }
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

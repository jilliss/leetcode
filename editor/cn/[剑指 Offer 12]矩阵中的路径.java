/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * <p>
 * <p>
 * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
 * "ABCCED"
 * 输出：true
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * board 和 word 仅由大小写英文字母组成
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/
 * Related Topics 数组 回溯 矩阵 👍 581 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution12 {
    public boolean exist(char[][] board, String word) {
        if (board == null) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        StringBuilder sb = new StringBuilder();
        // for (int i = 0; i < m; i++) {
        // }
        boolean[][] used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(board, used, i, j, 0, word)) {
                    return true;
                }

            }
        }
        return false;
        // return word.equals(sb.toString());
    }


    public boolean backtrack(char[][] board, boolean[][] flag, int x, int y, int nextIndex, String word) {
        // x，y 越界 或者已经使用
        if (x < 0 || y < 0 || x > board.length - 1 || y > board[0].length - 1 || flag[x][y]) {
            return false;
        }
        if (board[x][y] == word.charAt(nextIndex)) {
            nextIndex++;
            if (nextIndex == word.length()) {
                return true;
            }
        } else {
            return false;
        }
        flag[x][y] = true;
        boolean result = backtrack(board, flag, x - 1, y, nextIndex, word) ||
                backtrack(board, flag, x + 1, y, nextIndex, word) ||
                backtrack(board, flag, x, y - 1, nextIndex, word) ||
                backtrack(board, flag, x, y + 1, nextIndex, word);
        flag[x][y] = false;
        return result;
    }

    private boolean backtrack(StringBuilder sb, char[][] board, String world, boolean[][] used) {
        if (world.equals(sb.toString())) {
            return true;
        }
        if (!world.startsWith(sb.toString())) {
            return false;
        }

        int m = board.length;
        int n = board[0].length;
        //
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (used[i][j]) {
                    continue;
                }
                char c = board[i][j];
                // 做选择
                // 进入下一层决策树
                sb.append(c);
                used[i][j] = true;
                boolean res = backtrack(sb, board, world, used);
                if (res) {
                    return true;
                }


                // 取消选择
                sb.delete(sb.length() - 1, sb.length());
                used[i][j] = false;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        // boolean abcc = new Solution().exist(new char[][]{
        //         // new char[]{'A', 'B', 'C', 'E'},
        //         // new char[]{'S', 'F', 'C', 'S'},
        //         // new char[]{'A', 'D', 'E', 'E'},
        //         // new char[]{'A', 'D', 'E', 'E'},
        //         new char[]{'A', 'B'},
        //         new char[]{'C', 'D'},
        // }, "ABCD");
        //
        // System.out.println("abcc = " + abcc);


    }
}
//leetcode submit region end(Prohibit modification and deletion)

import java.util.Arrays;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（
 * 不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不
 * 能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 * <p>
 * Related Topics 深度优先搜索 广度优先搜索 动态规划 👍 495 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution13 {
    public int movingCount(int m, int n, int k) {
        int[][] arr = new int[m][n];
        return dfs(0, 0, m, n, arr, k);
        // return res;
    }

    private int dfs(int i, int j, int m, int n, int[][] v, int k) {
        if (i < 0 || j < 0 || i == m || j == n) {
            return 0;
        }
        if (v[i][j] == 1) {
            return 0;
        }
        if ((i / 10 + i % 10 + j / 10 + j % 10) <= k) {
            // 这里return 之所以 + 1 是因为 i 和 j 已经符合条件了，所以+1 下面再调用就是寻找上下左右四个的格子是否符合条件
            //             上
            return 1 + dfs(i - 1, j, m, n, v, k)
                    //        下
                    + dfs(i + 1, j, m, n, v, k)
                    //        左
                    + dfs(i, j - 1, m, n, v, k)
                    //        右
                    + dfs(i, j + 1, m, n, v, k);
        }
        return 0;
    }

    public static void main(String[] args) {
        // int i = new Solution().movingCount(38, 15, 9);
        // System.out.println("i = " + i);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

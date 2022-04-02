import java.util.Arrays;

/**
 * 给你两个大小为 n x n 的二进制矩阵 mat 和 target 。现 以 90 度顺时针轮转 矩阵 mat 中的元素 若干次 ，如果能够使 mat 与
 * target 一致，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
 * 输出：true
 * 解释：顺时针轮转 90 度一次可以使 mat 和 target 一致。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：mat = [[0,1],[1,1]], target = [[1,0],[0,1]]
 * 输出：false
 * 解释：无法通过轮转矩阵中的元素使 equal 与 target 一致。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
 * 输出：true
 * 解释：顺时针轮转 90 度两次可以使 mat 和 target 一致。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * n == mat.length == target.length
 * n == mat[i].length == target[i].length
 * 1 <= n <= 10
 * mat[i][j] 和 target[i][j] 不是 0 就是 1
 * <p>
 * Related Topics 数组 矩阵 👍 18 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1886 {
    public boolean findRotation(int[][] mat, int[][] target) {
        for (int i = 0; i < 4; i++) {
            rotate(target);
            boolean eq = true;
            for (int j = 0; j < mat.length; j++) {
                if (!Arrays.equals(mat[j], target[j])) {
                    eq = false;
                }
            }
            if (eq) {
                return true;
            }
        }
        return false;
    }


    public void rotate(int[][] matrix) {
        // 思路，先镜像翻转 再行翻转
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int[] row : matrix) {
            reverse(row);
        }

    }

    private void reverse(int[] row) {
        int j = row.length - 1;
        for (int i = 0; i < j; i++) {
            int temp = row[i];
            row[i] = row[j];
            row[j] = temp;
            j--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

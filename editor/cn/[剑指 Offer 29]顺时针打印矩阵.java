import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * <p>
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 * <p>
 * <p>
 * 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
 * Related Topics 数组 矩阵 模拟 👍 400 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution29 {
    public int[] spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = 0;
        int maxCol = n - 1;
        int maxRow = m - 1;
        int max = m * n;
        int[] res = new int[max];
        int index = 0;
        while (index < max) {
            // 左 ->右
            for (int j = col; j <= maxCol; j++) {
                res[index++] = matrix[row][j];
            }
            row++;
            if (row > maxRow) {
                break;
            }
            // 上 -> 下
            for (int j = row; j <= maxRow; j++) {
                res[index++] = matrix[j][maxCol];
            }
            maxCol--;
            if (col > maxCol) {
                break;
            }
            // 右 -> 左
            for (int j = maxCol; j >= col; j--) {
                res[index++] = matrix[maxRow][j];
            }
            maxRow--;
            if (row > maxRow) {
                break;
            }
            // 下 -> 上
            for (int j = maxRow; j >= row; j--) {
                res[index++] = matrix[j][col];
            }
            col++;
            if (col > maxRow) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] ints = new int[][]{
                new int[]{1, 2, 3, 4},
                new int[]{5, 6, 7, 8},
                new int[]{9, 10, 11, 12},
        };
        int[][] ints2 = {

                new int[]{1, 11},
                new int[]{2, 12},
                new int[]{3, 13},
                new int[]{4, 14},
                new int[]{5, 15},
                new int[]{6, 16},
                new int[]{7, 17},
                new int[]{8, 18},
                new int[]{9, 19},
                new int[]{10, 20}};


        // int[] ints1 = new Solution().spiralOrder(ints2);
        // System.out.println("ints1 = "+Arrays.toString(ints1));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

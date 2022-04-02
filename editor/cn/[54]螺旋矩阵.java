import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 * <p>
 * Related Topics 数组 矩阵 模拟 👍 1040 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>(matrix.length * matrix[0].length);
        int upperBound = 0, lowerBound = m - 1;
        int leftBound = 0, rightBound = n - 1;
        while (res.size() < m * n) {
            // 在顶部从左向右遍历
            if (upperBound <= lowerBound) {
                for (int i = leftBound; i <= rightBound; i++) {
                    res.add(matrix[upperBound][i]);
                }
                //遍历完一行
                upperBound++;
            }

            if (leftBound <= rightBound) {
                // 从上到下
                for (int i = upperBound; i <= lowerBound; i++) {
                    res.add(matrix[i][rightBound]);
                }
                // 遍历到头 列减少
                rightBound--;
            }

            if (upperBound <= lowerBound) {
                //   从左到右
                for (int i = rightBound; i >= leftBound; i--) {
                    res.add(matrix[lowerBound][i]);
                }
                // 最后一行遍历 下方上移
                lowerBound--;

            }
            if (leftBound <= rightBound) {
                //   从左侧 自下而上
                for (int i = lowerBound; i >= upperBound; i--) {
                    res.add(matrix[i][leftBound]);
                }
                // 左侧再收缩
                leftBound++;
            }
        }
        return res;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

/**
 * 给定一个二维矩阵 matrix，以下类型的多个请求：
 * <p>
 * <p>
 * 计算其子矩形范围内元素的总和，该子矩阵的 左上角 为 (row1, col1) ，右下角 为 (row2, col2) 。
 * <p>
 * <p>
 * 实现 NumMatrix 类：
 * <p>
 * <p>
 * NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化
 * int sumRegion(int row1, int col1, int row2, int col2) 返回 左上角 (row1, col1) 、右下角
 * (row2, col2) 所描述的子矩阵的元素 总和 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入:
 * ["NumMatrix","sumRegion","sumRegion","sumRegion"]
 * [[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,1,
 * 2,2],[1,2,2,4]]
 * 输出:
 * [null, 8, 11, 12]
 * <p>
 * 解释:
 * NumMatrix numMatrix = new NumMatrix([[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,
 * 1,7],[1,0,3,0,5]]);
 * numMatrix.sumRegion(2, 1, 4, 3); // return 8 (红色矩形框的元素总和)
 * numMatrix.sumRegion(1, 1, 2, 2); // return 11 (绿色矩形框的元素总和)
 * numMatrix.sumRegion(1, 2, 2, 4); // return 12 (蓝色矩形框的元素总和)
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 200
 * -10⁵ <= matrix[i][j] <= 10⁵
 * 0 <= row1 <= row2 < m
 * 0 <= col1 <= col2 < n
 * 最多调用 10⁴ 次 sumRegion 方法
 * <p>
 * Related Topics 设计 数组 矩阵 前缀和 👍 353 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class NumMatrix {
    private int[][] preSum;

    public NumMatrix(int[][] matrix) {
        preSum = new int[matrix.length + 1][];
        int n = matrix[0].length;
        preSum = new int[matrix.length + 1][n + 1];
        // preSum[i + 1] = new int[matrix[i].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            int[] innerArr = matrix[i];
            for (int j = 0, innerLength = innerArr.length; j < innerLength; j++) {
                // int inner = innerArr[j];
                // preSum[i + 1][j + 1] = preSum[i + 1][j] + inner;
                // 二维前缀和
                preSum[i + 1][j + 1] = preSum[i][j + 1] + preSum[i + 1][j] - preSum[i][j] + matrix[i][j];

            }

        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        //     1,1,2,2
        //    1,1 1,2  2,1 2,2
        // return
        int i = preSum[row2 + 1][col2 + 1] - preSum[row1][col2 + 1] - preSum[row2 + 1][col1] + preSum[row1][col1];
        int count = 0;
        for (; row1 <= row2; row1++) {
            int[] r1 = preSum[row1 + 1];
            count += r1[col2 + 1] - r1[col1];

        }
        // int[] r2 = preSum[row2 + 1];
        // count += r2[col2 + 1] - r2[col1];
        return count;
    }

    public static void main(String[] args) {
        int[][] ints = {new int[]{3, 0, 1, 4, 2}, new int[]{5, 6, 3, 2, 1}, new int[]{1, 2, 0, 1, 5}, new int[]{4, 1, 0, 1, 7}, new int[]{1, 0, 3, 0, 5},};
        NumMatrix numMatrix = new NumMatrix(ints);
        int i = numMatrix.sumRegion(2, 1, 4, 3);
        System.out.println("i = " + i);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)

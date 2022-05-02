
import java.util.ArrayList;
import java.util.*;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问
 * k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * <p>
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * <p>
 * 提示：
 * <p>
 * <p>
 * 2 <= n <= 58
 * <p>
 * <p>
 * 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/
 * Related Topics 数学 动态规划 👍 424 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution14 {
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = i - 1; j >= 1; j--) {
                // dp[i] 既是 数字 i 对应的乘积最大值
                // dp[j] 是 数字 j 对应乘积的最大值
                // 比较 i-j * dp[j] 和 j * i-j那个大用那个
                dp[i] = Math.max(dp[i], dp[j] * (i - j));
                dp[i] = Math.max(dp[i], j * (i - j));
            }
        }
        return dp[n];

    }


    public static void main(String[] args) {
        // int i = new Solution().cuttingRope(8);
        // System.out.println("i = " + i);
        // int[][] ints = {new int[]{3, 1, 2, 4, 5}, new int[]{1, 2, 3, 4}, new int[]{3, 4, 5, 6}};
        // int[][] ints = new int[][]{new }
        // List<Integer> intersection = intersection(ints);
        // System.out.println("intersection = " + intersection);
    }

    public static List<Integer> intersection(int[][] nums) {
        List<Integer> res = new LinkedList<>();
        HashMap<Integer, Integer> map1 = new HashMap<>();
        int[] start = nums[0];
        for (int j : start) {
            map1.put(j, 1);
        }
        for (int i = 1; i < nums.length; i++) {
            for (int x : nums[i]) {
                if (map1.containsKey(x)) {
                    Integer v = map1.get(x);
                    if (v == null) v = 0;
                    map1.put(x, ++v);
                } else {
                    map1.put(x, 1);
                }
            }
        }
        map1.forEach((k, v) -> {
            if (v == nums.length) {
                res.add(k);
            }
        });
        res.sort(Comparator.comparing((a) -> a));
        return res;
    }

    public int[] countRectangles(int[][] rectangles, int[][] points) {
        LinkedList<Integer> listY = new LinkedList<>();
        LinkedList<Integer> listX = new LinkedList<>();

        int[] res = new int[points.length];
        for (int[] rectangle : rectangles) {
            int x = rectangle[0];
            int y = rectangle[1];
            listX.add(x);
            listY.add(y);
            // int xi = listX.indexOf(x);
            // int yi = listY.indexOf(x);
            // if (y >= py && x >= px) {
            //     res[i]++;
            // }
        }
        for (int i = 0; i < points.length; i++) {
            int px = points[i][0];
            int py = points[i][1];
            int x = listX.getFirst();
            int y = listY.getFirst();
            if (x >= px && y >= py){
                res[i] += listX.size();
            }else {
                int xi = listX.indexOf(x);
                int yi = listY.indexOf(y);

                // if (y >= py && x >= px) {
                //     res[i]++;
                // }
            }
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

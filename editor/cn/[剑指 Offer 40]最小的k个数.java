import java.util.Arrays;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * <p>
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 * <p>
 * Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 423 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        int r = arr.length - 1;
        quickSort(arr, 0, r);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[r - i];
        }
        return res;
    }


    private void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int i = l, j = r;
        int x = arr[l];
        while (i < j) {
            // 降序
            while (i < j && arr[j] <= x) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }
            while (i < j && arr[i] > x) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];
            }
        }
        arr[i] = x;
        quickSort(arr, l, i - 1);
        quickSort(arr, i + 1, r);
    }

    public static void main(String[] args) {
        // int[] arr = new int[]{
        //         90, 12, 35, 1, 23, 59
        //
        // };
        // new Solution().quickSort(arr, 0, arr.length - 1);
        // System.out.println("arr = " + Arrays.toString(arr));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

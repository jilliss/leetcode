import java.util.Arrays;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [10,2]
 * 输出: "102"
 * <p>
 * 示例 2:
 * <p>
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 0 < nums.length <= 100
 * <p>
 * <p>
 * 说明:
 * <p>
 * <p>
 * 输出结果可能非常大，所以你需要返回一个字符串而不是整数
 * 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 * <p>
 * Related Topics 贪心 字符串 排序 👍 444 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution45 {
    public String minNumber(int[] nums) {
        int length = nums.length;
        String[] strs = new String[length];
        for (int i = 0; i < length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        int l = 0;
        int r = strs.length - 1;
        quickSort(strs,l,r);
        StringBuilder builder = new StringBuilder();
        for (String str : strs) {
            builder.append(str);
        }
        return builder.toString();

    }

    private void quickSort(String[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int i = l, j = r;
        String tmp = arr[i];
        while (i < j) {
            while ((arr[j] + arr[l]).compareTo(arr[l] + arr[j]) >= 0 && i < j) {
                j--;
            }
            while ((arr[i] + arr[l]).compareTo(arr[l] + arr[i]) <= 0 && i < j) {
                i++;
            }
            tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        arr[i] = arr[l];
        arr[l] = tmp;
        quickSort(arr, l, i - 1);
        quickSort(arr, i + 1, r);
    }

    // public static void main(String[] args) {
    //     new Solution().minNumber(new int[]{
    //             3,30,34,5,9
    //     });
    // }
}
//leetcode submit region end(Prohibit modification and deletion)

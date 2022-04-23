/**
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以
 * 看成任意数字。A 不能视为 14。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: True
 * <p>
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: [0,0,1,2,5]
 * 输出: True
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * 数组长度为 5
 * <p>
 * 数组的数取值为 [0, 13] .
 * Related Topics 数组 排序 👍 232 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution61 {
    public boolean isStraight(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        quickSort(nums, l, r);
        int count = 0;
        int diff = 0;
        int f = -1;
        for (int i = 0; i <= r; i++) {
            if (nums[i] == 0) {
                count++;
            }else {
                if(nums[i]==nums[i+1]) {
                    return false;
                }
                if(nums[i]+1!=nums[i+1]){
                    diff+=nums[i+1]-nums[i]-1;
                }
            }
        }
        return count >= diff;
    }

    private void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int i = l, j = r;
        int x = arr[l];
        while (i < j) {
            // 升序
            while (i < j && arr[j] >= x) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }
            while (i < j && arr[i] < x) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = x;
        quickSort(arr, l, i - 1);
        quickSort(arr, i + 1, r);

    }


    // public static void main(String[] args) {
    //     boolean straight = new Solution().isStraight(new int[]{
    //            1,2,3,4,5
    //     });
    //     System.out.println("straight = " + straight);
    // }
}
//leetcode submit region end(Prohibit modification and deletion)

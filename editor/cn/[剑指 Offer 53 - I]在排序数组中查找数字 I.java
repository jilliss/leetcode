/**
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= nums.length <= 10⁵
 * -10⁹ <= nums[i] <= 10⁹
 * nums 是一个非递减数组
 * -10⁹ <= target <= 10⁹
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
 * position-of-element-in-sorted-array/
 * Related Topics 数组 二分查找 👍 293 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution53 {
    public int search(int[] nums, int target) {
        int left = 0;
        int rigth = nums.length - 1;
        while (left < rigth) {
            int mid = left + (rigth - left) / 2;
            int i = nums[mid];
            if (i > target) {
                rigth = mid - 1;
            } else if (i < target) {
                left = mid + 1;
            } else {
                if (nums[rigth] != target)
                    rigth--;
                else if (nums[left] != target)
                    left++;
                else
                    break;
            }
        }
        // 没找到
        if (left == rigth && nums[left] != target){
            return  0;
        }
        return rigth - left + 1;
    }

    // public static void main(String[] args) {
    //     new Solution().search(new int[]{
    //             5,7,7,8,8,10
    //     },6);
    // }
}
//leetcode submit region end(Prohibit modification and deletion)

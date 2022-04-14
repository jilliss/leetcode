import java.util.HashMap;
import java.util.Map;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个
 * 数字。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [0,1,3]
 * 输出: 2
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= 数组长度 <= 10000
 * Related Topics 位运算 数组 哈希表 数学 二分查找 👍 254 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution53tow {
    public int missingNumber(int[] nums) {
        int left = -1;
        int rigth = nums.length;
        while (left < rigth - 1) {
            int mid = left + (rigth - left) / 2;
            int i = nums[mid];
            if (i != mid) {
                rigth = mid;

            } else {
                left = mid;
            }
            // if (i > mid) {
            //     rigth = mid - 1;
            // } else if (i < mid) {
            //     left = mid + 1;
            // } else {
            //     left = mid + 1;
            // }
        }
        if (rigth == nums.length) {
            return rigth + 1;
        }
        return nums[rigth] - 1;
    }

    public static void main(String[] args) {
        // new Solution().missingNumber(new int[]{
        //         0, 1
        // });
        // new Solution().extendes(new int[]{
        //         2, 5, 8, 12, 19
        // }, 5);
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int[] nums : matrix) {
            if (nums[0] > target) {
                continue;
            }
            if (extendes(nums, target)) {
                return true;
            }
        }


        return false;
    }

    // ps
    private boolean extendes(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int i = nums[mid];
            if (i == target) {
                return true;
            } else if (i > target) {
                right = mid - 1;
            } else if (i < target) {
                left = mid + 1;
            }


        }

        return false;

    }

    public char firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 最后一次 = 第一次 那么就说明没有重复
            if (s.indexOf(c) == s.lastIndexOf(c)) {
                return c;
            }
        }

        return ' ';
    }

}
//leetcode submit region end(Prohibit modification and deletion)

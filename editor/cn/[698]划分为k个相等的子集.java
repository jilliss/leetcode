////给定一个整数数组 nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。 
////
//// 
////
//// 示例 1： 
////
//// 
////输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
////输出： True
////说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。 
////
//// 示例 2: 
////
//// 
////输入: nums = [1,2,3,4], k = 3
////输出: false 
////
//// 
////
//// 提示： 
////
//// 
//// 1 <= k <= len(nums) <= 16 
//// 0 < nums[i] < 10000 
//// 每个元素的频率在 [1,4] 范围内 
//// 
//// Related Topics 位运算 记忆化搜索 数组 动态规划 回溯 状态压缩 👍 517 👎 0
//


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k > nums.length) {
            return false;
        }
        int sum = Arrays.stream(nums).sum();
        if (k > sum) {
            return false;
        }
        if (sum % k != 0) {
            return false;
        }
        // 数字是否使用过
        boolean[] used = new boolean[nums.length];
        int target = sum / k;
        return backtrack(k, 0, nums, 0, used, target);

    }

    /**
     * 回溯
     *
     * @param k      桶的数量
     * @param bucket 桶内数字之和
     * @param nums   原数组
     * @param start  开始下标
     * @param used   数组元素使用情况
     * @param target 桶内目标的和
     * @return boolean
     * @date 2022/3/24 下午12:53
     */
    private boolean backtrack(int k, int bucket, int[] nums, int start, boolean[] used, int target) {
        if (k == 0) {
            return true;
        }
        if (bucket == target) {
            // 每次都从 nums[0] 开始
            return backtrack(k - 1, 0, nums, 0, used, target);
        }
        for (int i = start; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            int num = nums[i];
            // 这个数字放不下
            if (num + bucket > target) {
                continue;
            }
            used[i] = true;
            bucket += num;
            // 穷举下一个数字能否装入当前桶
            if (backtrack(k, bucket, nums, i + 1, used, target)) {
                return true;
            }
            used[i] = false;
            bucket -= num;
        }


        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

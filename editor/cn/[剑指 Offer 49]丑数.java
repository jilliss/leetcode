import netscape.javascript.JSObject;

/**
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * <p>
 * 说明:
 * <p>
 * <p>
 * 1 是丑数。
 * n 不超过1690。
 * <p>
 * <p>
 * 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/
 * Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 339 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution49 {
    public int nthUglyNumber(int n) {

        int[] ugly = new int[n];
        //基础丑数为1
        ugly[0] = 1;
        //初始分别指向三个有序链表第一个元素,这三个有序链表是想象出来的，分别就是ugly数组元素分别乘以2,3,5得到的
        int i = 0, j = 0, k = 0;
        for (int idx = 1; idx < n; idx++) {
            int tmp = Math.min(ugly[i] * 2, Math.min(ugly[j] * 3, ugly[k] * 5));
            //三个链表可能有相同元素，所以只要是最小的，都要移动指针
            if (tmp == ugly[i] * 2) i++;
            if (tmp == ugly[j] * 3) j++;
            if (tmp == ugly[k] * 5) k++;
            ugly[idx] = tmp;
        }

        return ugly[n - 1];
    }

    public static void main(String[] args) {
        // new Solution().nthUglyNumber(10);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

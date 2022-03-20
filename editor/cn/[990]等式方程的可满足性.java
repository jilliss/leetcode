import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=
 * b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
 * <p>
 * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：["a==b","b!=a"]
 * 输出：false
 * 解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：["b==a","a==b"]
 * 输出：true
 * 解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：["a==b","b==c","a==c"]
 * 输出：true
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * 输入：["a==b","b!=c","c==a"]
 * 输出：false
 * <p>
 * <p>
 * 示例 5：
 * <p>
 * 输入：["c==c","b==d","x!=z"]
 * 输出：true
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= equations.length <= 500
 * equations[i].length == 4
 * equations[i][0] 和 equations[i][3] 是小写字母
 * equations[i][1] 要么是 '='，要么是 '!'
 * equations[i][2] 是 '='
 * <p>
 * Related Topics 并查集 图 数组 字符串 👍 224 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution990 {
    private final int[] parent = new int[26];
    private final int[] size = new int[26];

    public boolean equationsPossible(String[] equations) {
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        List<String> chars = new ArrayList<>();

        for (String equation : equations) {
            char[] charArr = equation.toCharArray();
            int a = charArr[0] - 97;
            int b = charArr[3] - 97;
            if (charArr[1] == '=') {
                union(a, b);
            } else {
                chars.add(equation);
            }
        }
        for (String equation : chars) {
            char[] charArr = equation.toCharArray();
            int a = charArr[0] - 97;
            int b = charArr[3] - 97;
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) {
                return false;
            }
        }
        return true;
    }

    private void union(int p, int q) {
        int rootX = find(p);
        int rootY = find(q);
        // 根节点相等，则说明全是为同为子节点。
        if (rootX == rootY) {
            return;
        }
        // 两个树合并为一棵
        parent[rootX] = rootY;
        // 都行，选取一个就可以
        // parent[rootY] = rootX;
        // 平衡优化 小树 接到大树下面
        if (size[rootX] > size[rootY]) {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        } else {
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        }
    }

    private int find(int i) {
        while (parent[i] != i) {
            parent[i] = parent[parent[i]];
            i = parent[i];

        }
        return i;
    }

    // public static void main(String[] args) {
    //     // System.out.println("'a' = " + (int) 'a');
    //     String[] strings = {"a==b", "e==c", "b==c", "a!=e"};
    //     String[] strings2 = {"a==z", "a==b", "b==c", "c==d", "b==y", "c==x", "d==w", "g==h", "h==i", "i==j", "a==g", "j!=y"};
    //     String[] strings1 = {"g==c", "f!=e", "e==b", "j==b", "g!=a", "e==c", "b!=f", "d!=a", "j==g", "f!=i", "a==e"};
    //     boolean b = new Solution().equationsPossible(strings2);
    //     System.out.println("b = " + b);
    // }
}

//leetcode submit region end(Prohibit modification and deletion)

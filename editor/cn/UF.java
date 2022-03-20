public class UF {
    /**
     * 连通分量
     */
    private int count;

    /**
     * 节点x的节点是 parent[x]
     * 连接后parent[x] 记录的是上级节点
     * 如果x = parent[x] 则说明它是根节点
     */
    private int[] parent;
    /**
     * 对应节点的拥有子节点的数量
     */
    private int[] size;

    public UF(int n) {

        count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
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


        // 两棵树合并在一块，分量减少一个
        count--;

    }

    private int find(int i) {
        //
        while (parent[i] != i) {
            parent[i] = parent[parent[i]];
            i = parent[i];

        }
        return i;
    }

    private int count() {
        return count;
    }

    private boolean connected(int p, int q) {
        int x = find(p);
        int y = find(q);
        return x == y;
    }
}

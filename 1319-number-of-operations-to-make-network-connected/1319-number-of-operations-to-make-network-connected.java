
class Solution {

    public int makeConnected(int n, int[][] connections) {

        // Step 1: Check whether enough cables exist.
        if (connections.length < n - 1) {
            return -1;
        }

        // Step 2: Initialize DSU.
        DSU dsu = new DSU(n);

        // Step 3: Process every connection.
        for (int[] connection : connections) {

            int u = connection[0];
            int v = connection[1];

            dsu.union(u, v);
        }

        // Step 4: Connect all remaining components.
        return dsu.components - 1;
    }

    static class DSU {

        int[] parent;
        int[] size;
        int components;

        DSU(int n) {

            parent = new int[n];
            size = new int[n];

            components = n;

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        // Find the representative of a component.
        int find(int x) {

            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }

        // Merge two components.
        void union(int a, int b) {

            int rootA = find(a);
            int rootB = find(b);

            // Already in the same component.
            if (rootA == rootB) {
                return;
            }

            // Attach the smaller tree under the larger tree.
            if (size[rootA] < size[rootB]) {
                int temp = rootA;
                rootA = rootB;
                rootB = temp;
            }

            parent[rootB] = rootA;

            size[rootA] += size[rootB];

            // Two components have become one.
            components--;
        }
    }
}

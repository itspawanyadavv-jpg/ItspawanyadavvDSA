
class Solution {

    int[] parent;
    int[] rank;

    int find(int x) {

        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    void union(int u, int v) {

        int rootU = find(u);
        int rootV = find(v);

        if (rootU == rootV) {
            return;
        }

        // Union by rank
        if (rank[rootU] < rank[rootV]) {
            parent[rootU] = rootV;
        }
        else if (rank[rootU] > rank[rootV]) {
            parent[rootV] = rootU;
        }
        else {
            parent[rootV] = rootU;
            rank[rootU]++;
        }
    }

    public boolean equationsPossible(String[] equations) {

        parent = new int[26];
        rank = new int[26];

        // Step 1: Initialize DSU
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        // Step 2: Process all equality equations
        for (String eq : equations) {

            if (eq.charAt(1) == '=') {

                int u = eq.charAt(0) - 'a';
                int v = eq.charAt(3) - 'a';

                union(u, v);
            }
        }

        // Step 3: Check inequality equations
        for (String eq : equations) {

            if (eq.charAt(1) == '!') {

                int u = eq.charAt(0) - 'a';
                int v = eq.charAt(3) - 'a';

                if (find(u) == find(v)) {
                    return false;
                }
            }
        }

        return true;
    }
}

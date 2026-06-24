class Solution {
    public int leastBricks(List<List<Integer>> wall) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int maxEdges = 0;

        for (List<Integer> row : wall) {

            int prefixSum = 0;

            // Skip the last brick
            for (int i = 0; i < row.size() - 1; i++) {

                prefixSum += row.get(i);

                map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);

                maxEdges = Math.max(maxEdges, map.get(prefixSum));
            }
        }

        return wall.size() - maxEdges;
    }
}
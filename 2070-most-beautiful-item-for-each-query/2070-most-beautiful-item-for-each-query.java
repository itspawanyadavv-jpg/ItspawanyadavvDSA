class Solution {

    public int[] maximumBeauty(int[][] items, int[] queries) {

        Arrays.sort(items, (a, b) -> a[0] - b[0]);

        // Prefix maximum beauty
        for (int i = 1; i < items.length; i++) {
            items[i][1] = Math.max(items[i][1], items[i - 1][1]);
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int idx = search(items, queries[i]);

            if (idx != -1)
                ans[i] = items[idx][1];
            else
                ans[i] = 0;
        }

        return ans;
    }

    private int search(int[][] items, int target) {

        int left = 0;
        int right = items.length - 1;
        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (items[mid][0] <= target) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}
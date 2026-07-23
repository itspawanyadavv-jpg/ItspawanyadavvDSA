class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {

        List<Integer> ans = new ArrayList<>();

        // Tomatoes must be even
        if (tomatoSlices % 2 != 0)
            return ans;

        // Not enough or too many tomatoes
        if (tomatoSlices < 2 * cheeseSlices ||
            tomatoSlices > 4 * cheeseSlices)
            return ans;

        // Number of Jumbo burgers
        int jumbo = (tomatoSlices - 2 * cheeseSlices) / 2;

        // Number of Small burgers
        int small = cheeseSlices - jumbo;

        ans.add(jumbo);
        ans.add(small);

        return ans;
    }
}
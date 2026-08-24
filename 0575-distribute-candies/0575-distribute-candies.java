import java.util.*;

public class Solution {
    public int distributeCandies(int[] candies) {
        int half = candies.length / 2;

        HashSet<Integer> set = new HashSet<>();

        for (int candy : candies) {
            set.add(candy);
        }

        return  Math.min(set.size(),half);
    }
}
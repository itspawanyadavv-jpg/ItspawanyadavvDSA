class Solution {
    public int totalFruit(int[] fruits) {

        Map<Integer, Integer> basket = new HashMap<>();
        int left = 0;
        int answer = 0;

        for (int right = 0; right < fruits.length; right++) {

            // Add the current fruit to the window.
            int currFruit = fruits[right];

            basket.put(
                currFruit,
                basket.getOrDefault(currFruit, 0) + 1
            );

            // Shrink the window while there are more
            // than two distinct fruit types.
            while (basket.size() > 2) {

                int outgoingFruit = fruits[left];

                // Remove one occurrence from the window.
                basket.put(
                    outgoingFruit,
                    basket.get(outgoingFruit) - 1
                );

                // Remove the type if its frequency becomes zero.
                if (basket.get(outgoingFruit) == 0) {
                    basket.remove(outgoingFruit);
                }

                left++;
            }

            // Calculate the current valid window length.
            int windowLength = right - left + 1;

            // Update the maximum length.
            answer = Math.max(answer, windowLength);
        }

        return answer;
    }
}


class Solution {

    public String intToRoman(int num) {

        // Roman values in descending order.
        int[] values = {
            1000, 900, 500, 400,
            100, 90, 50, 40,
            10, 9, 5, 4, 1
        };

        // Corresponding Roman symbols.
        String[] symbols = {
            "M", "CM", "D", "CD",
            "C", "XC", "L", "XL",
            "X", "IX", "V", "IV", "I"
        };

        StringBuilder result = new StringBuilder();

        // Process every Roman denomination.
        for (int i = 0; i < values.length; i++) {

            // Use the current denomination as many
            // times as possible.
            while (num >= values[i]) {

                result.append(symbols[i]);

                num -= values[i];
            }
        }

        return result.toString();
    }
}

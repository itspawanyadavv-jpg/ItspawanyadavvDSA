
class Solution {

    private static final String[] BELOW_20 = {
        "", "One", "Two", "Three", "Four", "Five",
        "Six", "Seven", "Eight", "Nine", "Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen",
        "Fifteen", "Sixteen", "Seventeen", "Eighteen",
        "Nineteen"
    };

    private static final String[] TENS = {
        "", "", "Twenty", "Thirty", "Forty", "Fifty",
        "Sixty", "Seventy", "Eighty", "Ninety"
    };

    // Convert a number from 1 to 999.
    private String below1000(int num) {
        StringBuilder words = new StringBuilder();

        if (num >= 100) {
            words.append(BELOW_20[num / 100])
                 .append(" Hundred");
            num %= 100;

            if (num > 0) {
                words.append(" ");
            }
        }

        if (num >= 20) {
            words.append(TENS[num / 10]);
            num %= 10;

            if (num > 0) {
                words.append(" ");
            }
        }

        if (num > 0) {
            words.append(BELOW_20[num]);
        }

        return words.toString();
    }

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        StringBuilder result = new StringBuilder();

        // Explicitly handle the billions portion.
        if (num >= 1_000_000_000) {
            result.append(below1000(num / 1_000_000_000))
                  .append(" Billion");
            num %= 1_000_000_000;
        }

        // Explicitly handle the millions portion.
        if (num >= 1_000_000) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(below1000(num / 1_000_000))
                  .append(" Million");
            num %= 1_000_000;
        }

        // Explicitly handle the thousands portion.
        if (num >= 1_000) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(below1000(num / 1_000))
                  .append(" Thousand");
            num %= 1_000;
        }

        // Handle the remaining hundreds, tens, and ones.
        if (num > 0) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(below1000(num));
        }

        return result.toString();
    }
}

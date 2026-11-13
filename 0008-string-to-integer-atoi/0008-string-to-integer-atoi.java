
class Solution {

    public int myAtoi(String s) {

        int n = s.length();
        int i = 0;

        // Step 1: Skip leading spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Step 2: Determine the sign
        int sign = 1;

        if (i < n && s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (i < n && s.charAt(i) == '+') {
            i++;
        }

        // Step 3: Select the appropriate limit
        long limit = (sign == 1)
                ? Integer.MAX_VALUE
                : 2147483648L;

        // Step 4: Initialize the number
        long number = 0;

        // Step 5: Process consecutive digits
        while (i < n) {

            char ch = s.charAt(i);

            // Stop if the character is not a digit
            if (ch < '0' || ch > '9') {
                break;
            }

            // Convert character into its numeric value
            int digit = ch - '0';

            // Step 6: Check overflow BEFORE updating
            if (number > (limit - digit) / 10) {

                return (sign == 1)
                        ? Integer.MAX_VALUE
                        : Integer.MIN_VALUE;
            }

            // Step 7: Build the number
            number = number * 10 + digit;

            i++;
        }

        // Step 8: Apply sign and return
        return (int) (number * sign);
    }
}

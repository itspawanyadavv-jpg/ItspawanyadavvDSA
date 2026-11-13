
import java.math.BigInteger;

class Solution {
    public int myAtoi(String s) {

        int i = 0;
        int n = s.length();

        // Step 1: Skip leading spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Step 2: Determine sign
        int sign = 1;

        if (i < n && s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (i < n && s.charAt(i) == '+') {
            i++;
        }

        // Step 3: Build number safely
        BigInteger number = BigInteger.ZERO;

        while (i < n &&
               s.charAt(i) >= '0' &&
               s.charAt(i) <= '9') {

            int digit = s.charAt(i) - '0';

            number = number.multiply(BigInteger.TEN)
                           .add(BigInteger.valueOf(digit));

            i++;
        }

        // Apply sign
        number = number.multiply(BigInteger.valueOf(sign));

        // Step 4: Clamp to int range
        BigInteger min = BigInteger.valueOf(Integer.MIN_VALUE);
        BigInteger max = BigInteger.valueOf(Integer.MAX_VALUE);

        if (number.compareTo(max) > 0) {
            return Integer.MAX_VALUE;
        }

        if (number.compareTo(min) < 0) {
            return Integer.MIN_VALUE;
        }

        return number.intValue();
    }
}

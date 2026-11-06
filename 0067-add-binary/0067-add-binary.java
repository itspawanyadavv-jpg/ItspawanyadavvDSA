class Solution {

    public String addBinary(String a, String b) {

        int i = a.length() - 1;
        int j = b.length() - 1;

        int carry = 0;

        StringBuilder result = new StringBuilder();

        while (i >= 0 || j >= 0 || carry > 0) {

            int sum = carry;

            // Add bit from a
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }

            // Add bit from b
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            // Calculate current binary digit
            int bit = sum % 2;

            // Calculate carry for next position
            carry = sum / 2;

            result.append(bit);
        }

        return result.reverse().toString();
    }
}
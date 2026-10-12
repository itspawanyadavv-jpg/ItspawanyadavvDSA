class Solution {
    public int myAtoi(String s) {

        int i = 0;
        int n = s.length();

        while( i < n && s.charAt(i) == ' '){
            i ++;
        }

        int sign = 1;

        if( i < n && (s.charAt(i) =='+' || s.charAt(i) == '-')){
            if(s.charAt(i) == '-'){
                sign = -1;
            }
            i++;
        }
        long result = 0;
         long limit = (sign == 1)
         ? Integer.MAX_VALUE
         : 2147483648L;

         while( i< n){
            char ch = s.charAt(i);
            if(ch < '0' || ch > '9'){
                break;
            }
            int digit = ch - '0';
             // Step 4: Check for overflow BEFORE multiplying
            if (result > limit / 10 ||
                (result == limit / 10 && digit > limit % 10)) {

                return (sign == 1)
                        ? Integer.MAX_VALUE
                        : Integer.MIN_VALUE;
            }

            // Append the digit
            result = result * 10 + digit;
            i++;
        }

        return (int) (sign * result);
        }

                                                                     
        
}

class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder stack = new StringBuilder();

        for(char digit : num.toCharArray()){

            while(k > 0 && stack.length() > 0 && stack.charAt(stack.length() -1)  > digit){
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }

            //Add current digit
            stack.append(digit);
        }
        //agar increasing order me hi ho toh.
        while( k > 0){
            stack.deleteCharAt(stack.length() -1);
            k--;
        }

        //Remove leading zeroes . 
        int start = 0;

        while(start < stack.length() && stack.charAt(start) == '0'){
            start ++;
        }

        if(start == stack.length()){
            return "0";
        }
        return stack.substring(start);


        
    }
}
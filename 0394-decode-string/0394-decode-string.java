class Solution {
    public String decodeString(String s) {

    Stack<Integer> countStack = new Stack<>();
    Stack<String> stringStack = new Stack<>();

    StringBuilder currentString = new StringBuilder();
    int num = 0;

    for(char ch : s.toCharArray()){
        //Build the number 

        if(Character.isDigit(ch)){
            num = num * 10 +(ch - '0');
        }
        //Start a new nested expression.
        else if(ch == '['){

            //save the repeat count 
            countStack.push(num);

            //save the string before [
            stringStack.push(currentString.toString());

            currentString = new StringBuilder();

            //reset number.
            num = 0;
        }
        //Add A normal ch

        else if(ch == ']'){

            //Get repeat count.
            int count = countStack.pop();

            //Get String before [
             String prevString = stringStack.pop();

             //repeat curr String 
             StringBuilder decoded = new StringBuilder();

             for(int i = 0; i < count; i++){
                decoded.append(currentString);
             }

             //combine prev plusdecoded
             currentString  = new StringBuilder(prevString).append(decoded);
        }
        // Normal letter. 
        else{
            currentString.append(ch);
        }
    }
    return currentString.toString();

        
    }
}
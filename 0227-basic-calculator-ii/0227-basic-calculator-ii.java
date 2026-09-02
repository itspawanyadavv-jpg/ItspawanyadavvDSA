class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();

        int number = 0;
        char operation = '+';
        for(int i = 0; i < s.length(); i++){

            char ch = s.charAt(i);

            //Build the number.
            if(Character.isDigit(ch)){
                number = number * 10 +(ch - '0');
            }
            //if we reach the operator.
            if((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1){


                if (operation == '+') {
                    stack.push(number);
                }
                else if (operation == '-') {
                    stack.push(-number);
                }
                else if (operation == '*') {
                    stack.push(stack.pop() * number);
                }
                else if (operation == '/') {
                    stack.push(stack.pop() / number);
                }

                operation = ch;
                number = 0;
            }
        }
        int result = 0;

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
        
    }
}
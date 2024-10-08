package String.MediumQuestions;

/*
Given a string s which represents an expression, evaluate this expression and return its value. 
The integer division should truncate toward zero. You may assume that the given expression is 
always valid. All intermediate results will be in the range of [-231, 231 - 1].
Note: You are not allowed to use any built-in function which evaluates strings as mathematical 
expressions, such as eval().

Example 1:
Input: s = "3+2*2"
Output: 7

Example 2:
Input: s = " 3/2 "
Output: 1

Example 3:
Input: s = " 3+5 / 2 "
Output: 5
*/

public class Q227BasicCalculatorII {

    public int calculate(String s) {
        
        int num = 0, last = 0, sum = 0;
        char operator = '+';

        for (int i = 0; i < s.length(); i++) 
        {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if (isOperator(c) || i == s.length() - 1) 
            {
                if (operator == '+') {
                    sum += last;
                    last = num;
                } 
                else if (operator == '-') {
                    sum += last;
                    last = -num;
                } 
                else if (operator == '*')
                    last *= num;
                else if (operator == '/')
                    last /= num;

                num = 0;
                operator = c;
            }
        }
        return sum += last;
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}
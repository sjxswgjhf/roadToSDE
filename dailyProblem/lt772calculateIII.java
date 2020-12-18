package dailyProblem;

import java.util.Stack;

public class lt772calculateIII {
    class Solution {
        int i = 0;
        public int calculate(String s) {
            Stack<Integer> stack = new Stack<>();
            char operation = '+';
            int num = 0;
            while(i < s.length()){
                char c = s.charAt(i++);
                if(Character.isDigit(c)){
                    num = num * 10 + (c-'0');
                }
                if(c == '('){
                    num = calculate(s);
                }
                if(i == s.length() || c == '+' || c == '-' || c == '*' || c == '/' || c == ')'){
                    if(operation == '+'){
                        stack.push(num);
                    }
                    else if(operation == '-'){
                        stack.push(-num);
                    }
                    else if(operation == '*'){
                        stack.push(stack.pop() * num);
                    }
                    else if(operation == '/'){
                        stack.push(stack.pop() / num);
                    }
                    operation = c;
                    num = 0;
                }
                if(c == ')'){
                    break;
                }
            }
            int res = 0 ;
            while(!stack.isEmpty()){
                res += stack.pop();
            }
            return res;
        }
    }
}

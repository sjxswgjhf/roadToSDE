package Bloomberg;

import java.util.Stack;

public class lt20isValid {

    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for(char c : s.toCharArray()){
                if(c == '(' || c == '[' || c == '{'){
                    stack.push(c);
                }
                else{
                    if(c == ']'){
                        if(stack.isEmpty() || stack.peek() != '['){
                            return false;
                        }else{
                            stack.pop();
                        }
                    }
                    if(c == '}'){
                        if(stack.isEmpty() || stack.peek() != '{'){
                            return false;
                        }else{
                            stack.pop();
                        }
                    }
                    if(c == ')'){
                        if(stack.isEmpty() || stack.peek() != '('){
                            return false;
                        }else{
                            stack.pop();
                        }
                    }
                }
            }
            return stack.isEmpty();
        }
    }
}

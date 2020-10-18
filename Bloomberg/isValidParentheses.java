package Bloomberg;

import java.util.Stack;

public class isValidParentheses {

    class Solution {
        public boolean isValid(String s) {
            if(s == null || s.length() == 0){
                return true;
            }
            if(s.length() % 2 == 1){
                return false;
            }
            Stack<Character> stack = new Stack<>();
            for(char c : s.toCharArray()){
                if(c == '(' || c == '{' || c == '['){
                    stack.push(c);
                }
                else if(c == ')'){
                    if(!stack.isEmpty() && stack.pop() == '('){
                        continue;
                    }else{
                        return false;
                    }
                }
                else if(c == ']'){
                    if(!stack.isEmpty() && stack.pop() == '['){
                        continue;
                    }else{
                        return false;
                    }
                }
                else if(c == '}'){
                    if(!stack.isEmpty() && stack.pop() == '{'){
                        continue;
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }
            return stack.isEmpty();
        }
    }

}

package BloombergOnsite;

import java.util.Stack;

public class lt394decodeString {

    class Solution {
        public String decodeString(String s) {
            Stack<Object> stack = new Stack<>();
            int num = 0;
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(Character.isDigit(c)){
                    num = num * 10 + (c-'0');
                }
                else if(c == '['){
                    stack.push(num);
                    num = 0;
                }
                else if(c == ']'){
                    String tmp = buildStr(stack);
                    Integer freq = (Integer)stack.pop();
                    String str = "";
                    for(int k = 0; k < freq; k++){
                        str = str + tmp;
                    }
                    stack.push(str);
                }
                else{
                    stack.push(String.valueOf(c));
                }
            }
            String res = "";
            while(!stack.isEmpty()){
                res = stack.pop() + res;
            }
            return res;
        }

        private String buildStr(Stack<Object> stack){
            String res = "";
            //pop all the character
            while(!stack.isEmpty() && stack.peek() instanceof String){
                res = stack.pop() + res;
            }
            return res;
        }
    }
}

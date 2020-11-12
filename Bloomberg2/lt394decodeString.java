package Bloomberg2;

import java.util.Stack;

public class lt394decodeString {
    class Solution {
        /*

        Stack<Object>

        meet digit 累积，直到遇到[,放到stack
        meet char, put into stack
        meet ], build str 加入到stack
        */
        public String decodeString(String s) {
            Stack<Object> stack = new Stack<>();
            int num = 0;
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(Character.isDigit(c)){
                    num = num * 10 + (c - '0');
                }
                else if(c == '['){
                    stack.push(Integer.valueOf(num));
                    num = 0;
                }
                else if(c == ']'){
                    String str = findString(stack);
                    int freq = (Integer)stack.pop();
                    String tmp = "";
                    for(int j = 0; j < freq; j++){
                        tmp += str;
                    }
                    stack.push(tmp);
                }else{
                    stack.push(String.valueOf(c));
                }
            }
            String res = "";
            while(!stack.isEmpty()){
                res = stack.pop() + res;
            }
            return res;

        }
        private String findString(Stack<Object> stack){
            StringBuffer sb = new StringBuffer();
            while(!stack.isEmpty()){
                if(stack.peek() instanceof Integer){
                    sb.insert(0, stack.pop());
                }else{
                    break;
                }
            }
            return sb.toString();
        }
    }
}

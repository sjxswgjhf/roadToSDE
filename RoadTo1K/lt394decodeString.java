package RoadTo1K;

import java.util.Stack;

public class lt394decodeString {

    class Solution {
        /*
        做了好多遍了，比较熟练了，一种是单个stack用object跟instanceof来区分，
        另一种是two stack一个str，一个count来实现
        */
        public String decodeString(String s) {
            Stack<Object> stack = new Stack<>();
            int num = 0;
            int r = 0;
            while(r < s.length()){
                if(Character.isDigit(s.charAt(r))){
                    num = num * 10 + (int)(s.charAt(r) - '0');
                }
                else if(s.charAt(r) == '['){
                    stack.push(Integer.valueOf(num));
                    num = 0;
                }
                else if(s.charAt(r) == ']'){
                    String str = getString(stack);
                    Integer freq = (Integer)stack.pop();
                    String tmp = "";
                    for(int i = 0; i < freq; i++){
                        tmp = tmp + str;
                    }
                    stack.push(tmp);
                }
                else{
                    stack.push(String.valueOf(s.charAt(r)));
                }
                r++;
            }
            String res = "";
            while(!stack.isEmpty()){
                res = stack.pop() + res;
            }
            return res;
        }

        private String getString(Stack<Object> stack){
            String res = "";
            while(!stack.isEmpty() && stack.peek() instanceof String){
                res = stack.pop() + res;
            }
            return res;
        }
    }

    class SolutionSecond {
        //注意pop出来的要塞到前面去
        public String decodeString(String s) {
            Stack<Object> stack = new Stack<>();
            int num = 0;

            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(Character.isDigit(c)){
                    num = num * 10 + (c - '0');
                }
                else if(c == '['){
                    stack.push(num);
                    num = 0;
                }
                else if(c == ']'){
                    String str = buildStr(stack);
                    int freq = (Integer)(stack.pop());
                    String tmp = "";
                    for(int j = 0; j < freq; j++){
                        tmp = tmp + str;
                    }
                    stack.push(tmp);
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
            while(!stack.isEmpty() && stack.peek() instanceof String){
                res = stack.pop() + res;
            }
            return res;
        }
    }
}

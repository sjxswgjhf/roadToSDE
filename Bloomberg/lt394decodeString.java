package Bloomberg;

import java.util.Stack;

public class lt394decodeString {

    class SolutionTwoStacks {
        /*
        遇到digit直接处理，遇到char append，遇到[，把累积的str放到stack，重置str，遇到]把stack的pop出来，然后按freq append上当前的，
        但是不要重置。。把临时的str更新到当前的str
        */
        public String decodeString(String s) {
            Stack<Integer> nums = new Stack<>();
            Stack<String> strs = new Stack<>();
            int num = 0;
            int r = 0;
            StringBuffer cur = new StringBuffer();
            while(r < s.length()){
                if(Character.isDigit(s.charAt(r))){
                    while(Character.isDigit(s.charAt(r))){
                        num = num * 10 + (s.charAt(r) - '0');
                        r++;
                    }
                    nums.push(num);
                    num = 0;
                }
                else if(s.charAt(r) == '['){
                    strs.push(cur.toString());
                    cur = new StringBuffer();
                    r++;
                }
            /*
            a2[ab]
            aabab
            */
                else if(s.charAt(r) == ']'){
                    StringBuffer tmp = new StringBuffer();
                    int count = nums.pop();
                    tmp.append(strs.pop());
                    for(int i = 0; i < count; i++){
                        tmp.append(cur);
                    }
                    cur = tmp;
                    r++;
                }else{
                    cur.append(s.charAt(r));
                    r++;
                }
            }
            return cur.toString();
        }
    }

    /*
    利用Object的type来处理，遇到char直接变成str丢到stack，遇到num累积，遇到[把num丢上去，遇到]，去把strs都丢出来直到遇到Integer
    变成一个返回，然后按freq去累积，再放回stack，
     */
    class Solution {
        public String decodeString(String s) {
            Stack<Object> stack = new Stack<>();
            Integer num = 0;
            for(int i =0 ; i < s.length(); i++){
                char c = s.charAt(i);
                if(Character.isDigit(c)){
                    num = num * 10 + (Integer)(c - '0');
                }
                else if(c == '['){
                    stack.push(num);
                    num = 0;
                }else if(c == ']'){
                    String newStr = helper(stack);
                    Integer count = (Integer)stack.pop();
                    String str = "";
                    for(int k = 0; k < count; k++){
                        str += newStr;
                    }
                    stack.push(str);
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

        private String helper(Stack<Object> stack){
            StringBuffer sb = new StringBuffer();
            while(!stack.isEmpty() && stack.peek() instanceof String){
                sb.insert(0, stack.pop());
            }
            return sb.toString();
        }
    }
}

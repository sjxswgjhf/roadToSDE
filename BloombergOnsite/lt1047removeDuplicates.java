package BloombergOnsite;

import java.util.Stack;

public class lt1047removeDuplicates {

    class Solution {
        public String removeDuplicates(String S) {
            Stack<Character> stack = new Stack<>();
            for(char c : S.toCharArray()){
                if(stack.isEmpty() || stack.peek() != c){
                    stack.push(c);
                }else{
                    while(!stack.isEmpty() && stack.peek() == c){
                        stack.pop();
                    }
                }
            }
            String res = "";
            while(!stack.isEmpty()){
                res = stack.pop() + res;
            }
            return res;
        }
    }

}

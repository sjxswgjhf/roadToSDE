package Bloomberg;

import java.util.Stack;

public class lt1249minRemoveToMakeValid {

    class Solution {
        public String minRemoveToMakeValid(String s) {
            Stack<Integer> stack = new Stack<>();
            int idx = 0;
            for(char c : s.toCharArray()){
                if(c == '('){
                    stack.push(idx);
                }
                else if(c == ')'){
                    if(stack.isEmpty() || s.charAt(stack.peek()) != '('){
                        stack.push(idx);
                    }else{
                        stack.pop();
                    }
                }
                idx++;
            }
            String res = "";
            int end = s.length()-1;
            while(!stack.isEmpty()){
                int index = stack.pop();
                // while(end > index){
                //     res = s.charAt(end) + res;
                //     end--;
                // }
                if(end > index){
                    res = s.substring(index + 1, end + 1) + res;
                }
                end = index - 1;
            }
            if(end >= 0){
                res = s.substring(0, end + 1) + res;
            }
            return res;
        }
    }
}

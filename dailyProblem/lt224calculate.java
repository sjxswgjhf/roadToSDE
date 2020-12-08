package dailyProblem;

import java.util.Stack;

public class lt224calculate {

    class Solution {
        public int calculate(String s) {
            int r = 0;
            int n = s.length();
            int res = 0;
            Stack<Object> stack = new Stack<>();
            Integer num = 0;
            while(r < n){
                if(Character.isDigit(s.charAt(r))){
                    while(Character.isDigit(s.charAt(r))){
                        num = num * 10 + Integer.valueOf(s.charAt(r));
                        r++;
                    }
                    stack.push(num);
                    num = 0;
                }
                else if(s.charAt(r) == '('){
                    stack.push("(");
                }


            }
        }
    }
}

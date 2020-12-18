package dailyProblem;

import java.util.Stack;

public class lt224calculate {

    class Solution {
        /*
        从后往前，

        遇到sign就放到stack上
        遇到空格的话跳过
        遇到数字继续累积，
        遇到)的话直接push
        遇到(的话，直接evaluate stack直到遇到)
        */
        public int calculate(String s) {
            int num = 0;
            int n = s.length();
            int power = 0;
            Stack<Object> stack = new Stack<>();
            for(int i = n - 1; i >= 0; i--){
                char c = s.charAt(i);
                if(c == ' '){
                    continue;
                }
                else if(c == '+' || c == '-'){
                    int sign = c == '+' ? 1 : -1;
                    stack.push(num * sign);
                    num = 0;
                    power = 0;
                }
                else if(c == '('){
                    //先把当前累积的数push上去
                    stack.push(num);
                    int val = evalute(stack);
                    num = val;      //"1-(5)"
                }
                else if(c == ')'){
                    stack.push(String.valueOf(c));
                }
                else{
                    num = (int)((c -'0') * Math.pow(10, power)) + num;
                    power++;
                }
            }
            //注意结束loop的时候第一个数还没push上去
            if(num != 0){
                stack.push(num);
            }
            int res = 0;
            while(!stack.isEmpty()){
                res += (Integer)stack.pop();
            }
            return res;
        }

        private int evalute(Stack<Object> stack){
            int res = 0;
            while(!stack.isEmpty() && stack.peek() instanceof Integer){
                res += (Integer)stack.pop();
            }
            //pop )
            stack.pop();
            return res;
        }

    }

}

package dailyProblem;

import java.util.Stack;

public class lt227calculateII {
    class Solution {
        /*
        运用错误一个运算符号来操作,第一个的运算符号肯定是+
        例如7*8，
        我们先把符号设成+,当我们遇到*的时候，我们直接把+7push上去，然后把operation更新，直到我们遇到结束或者下一格符号的时候，
        我们可以再运算*,这样就可以实现错位运算，一般做法的话，会卡在*,/这里，我们需要找下一个数，比较麻烦
        */
        public int calculate(String s) {
            Stack<Integer> stack = new Stack<>();
            int num = 0;
            char operation = '+';
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(Character.isDigit(c)){
                    num = num * 10 + (c-'0');
                }
                if(i == s.length() - 1 || (!Character.isDigit(c) && c != ' ')){
                    if(operation == '-'){
                        stack.push(-num);
                    }
                    else if(operation == '+'){
                        stack.push(num);
                    }
                    else if(operation =='*'){
                        stack.push(stack.pop() * num);
                    }
                    else if(operation =='/'){
                        stack.push(stack.pop() / num);
                    }
                    operation = c;
                    num = 0;
                }
            }
            int res = 0;
            while(!stack.isEmpty()){
                res += (Integer)stack.pop();
            }
            return res;
        }
    }
}

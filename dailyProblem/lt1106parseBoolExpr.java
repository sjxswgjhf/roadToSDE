package dailyProblem;

import java.util.Stack;

public class lt1106parseBoolExpr {
    class Solution {
        /*
        这题的基本型是除了直接的t,f，别的特殊符号都会有()包围着，然后用,分割开，那么我们可以把()直接看做是一个val，
        这样我们用两个Stack来做，一个记录所有的值，一个记录所有的operation，我们遇到)的时候就计算之前()的值，
        那么我们要知道我们什么时候要停止，即什么时候遇到(,所以我们遇到(要特殊处理
        遇到t，f，直接丢进去
        遇到(，因为val的stack是boolean type，我们可以用null来当做特殊的值，即(
        遇到)，我们先pop一个operation，开始pop val，然后根据operation来，这里有个难点就是怎么初始化值，
        我们有&,!,|这三种，如果初始化true的话，会对|造成影响，用false的话，我们会对&造成影响，所以我们要用op == &的判断，&我们希望是true，|我们希望是false，!无所谓
        遇到,，直接忽略,
        遇到!,&,|的话直接push到op的stack
        */
        public boolean parseBoolExpr(String expression) {
            Stack<Boolean> valsStack = new Stack<>();
            Stack<Character> opStack = new Stack<>();
            for(int i = 0; i < expression.length(); i++){
                char c = expression.charAt(i);
                if(c == 't'){
                    valsStack.push(true);
                }
                else if(c == 'f'){
                    valsStack.push(false);
                }
                else if(c == '('){
                    valsStack.push(null);
                }
                //valuate
                else if(c == ')'){
                    char op = opStack.pop();
                    boolean res = op == '&';
                    while(!valsStack.isEmpty() && valsStack.peek() != null){
                        if(op == '&'){
                            res = res & valsStack.pop();
                        }
                        else if(op == '|'){
                            res = res | valsStack.pop();
                        }
                        else if(op == '!'){
                            res = !(valsStack.pop());
                        }
                    }
                    valsStack.pop();
                    valsStack.push(res);
                }
                else if(c == ','){
                    continue;
                }else{
                    // |, &, !
                    opStack.push(c);
                }
            }
            return valsStack.peek();
        }
    }
}

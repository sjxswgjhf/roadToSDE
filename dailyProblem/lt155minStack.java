package dailyProblem;

import java.util.Stack;

public class lt155minStack {

    class MinStack {

        Stack<Integer> stack;
        Stack<Integer> minStack;
        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if(minStack.isEmpty()){
                minStack.push(x);
            }else{
                int top = minStack.peek();
                if(top < x){
                    minStack.push(top);
                }
                else{
                    minStack.push(x);
                }
            }
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

}

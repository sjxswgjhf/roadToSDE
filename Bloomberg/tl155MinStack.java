package Bloomberg;

import java.util.Stack;

public class tl155MinStack {
    class MinStack {

    /*
    stack存的正常的数，
    minstack是一个monotonic stack,如果当前push的数比stack大的话，就把stack。top再放入一遍

    stack: -2 0 -3
    minstack:
    */

        Stack<Integer> minStack;
        Stack<Integer> stack;
        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if(minStack.isEmpty() || minStack.peek() > x){
                minStack.push(x);
            }else{
                int top = minStack.peek();
                minStack.push(top);
            }
        }

        public void pop() {
            int res = stack.pop();
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

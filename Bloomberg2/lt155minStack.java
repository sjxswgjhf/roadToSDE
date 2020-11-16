package Bloomberg2;

import java.util.Stack;

public class lt155minStack {

    class MinStack {

        Stack<Integer> stack;
    /*
    minstack 记录了当前stack的最小值，如果当前push值小于minstack顶部，直接放入，
    如果大于顶部，则再放一次顶部
    */

        Stack<Integer> minStack;

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

package RoadTo1K;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lt225MyStack {

    class MyStack {

        Queue<Integer> queue;
        List<Integer> list;
        /** Initialize your data structure here. */
        public MyStack() {
            queue = new LinkedList<>();
            list = new ArrayList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue.offer(x);
            list.add(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            int size = queue.size();
            while(size > 1){
                int val = queue.poll();
                queue.offer(val);
                size--;
            }
            list.remove(list.size() - 1);
            return queue.poll();
        }

        /** Get the top element. */
        public int top() {
            return list.get(list.size() - 1);
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty();
        }
    }

}

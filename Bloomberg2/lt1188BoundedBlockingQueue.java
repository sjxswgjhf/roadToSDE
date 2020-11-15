package Bloomberg2;

import java.util.Deque;
import java.util.LinkedList;

public class lt1188BoundedBlockingQueue {

    class BoundedBlockingQueue {

        Object monitor;
        Deque<Integer> deque;
        int capacity;

        public BoundedBlockingQueue(int capacity) {
            monitor = new Object();
            deque = new LinkedList<>();
            this.capacity = capacity;
        }


        public void enqueue(int element) throws InterruptedException {
            synchronized(monitor){
                while(deque.size() == capacity){
                    monitor.wait();
                }
                deque.add(element);
                monitor.notifyAll();
            }
        }

        public int dequeue() throws InterruptedException {
            int res = 0;
            synchronized(monitor){
                //check condition is avaiable or not
                while(deque.size() == 0){
                    monitor.wait();
                }
                //走到这里表示进入到了monitor，然后修改share resource，再释放monitor
                res = deque.poll();
                monitor.notifyAll();
            }
            return res;
        }

        public int size() {
            return deque.size();
        }
    }
}

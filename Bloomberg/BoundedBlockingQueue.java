package Bloomberg;

import java.util.LinkedList;
import java.util.Queue;

public class BoundedBlockingQueue {

    Object monitor = new Object();
    int capacity;
    Queue<Integer> queue;
    public BoundedBlockingQueue(int capacity) {
        queue = new LinkedList<>();
        this.capacity = capacity;
    }

    public void enqueue(int element) throws InterruptedException {
        synchronized(monitor){
            //记得用while是因为thread被notify之后，还要再次确认自己是不是进到了monitor里面，不然的话直接往后走了就会报错
            while(queue.size() >= capacity){
                monitor.wait();
            }
            queue.add(element);
            monitor.notifyAll();
        }
    }

    public int dequeue() throws InterruptedException {
        int res = 0;
        synchronized(monitor){
            while(queue.isEmpty()){
                monitor.wait();
            }
            res = queue.poll();
            monitor.notifyAll();
        }
        return res;
    }

    public int size() {
        return queue.size();
    }

}

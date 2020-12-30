package BloombergOnsite;

import java.util.HashMap;

public class lt460LFUCache {
    class LFUCache {

    /*
    两个hashmap，一个对应的是freq跟dll，一个对应的是key跟node
    dll里面需要remove，sethead，跟removeLast，加入head跟tail的padding处理起来更舒服，
    然后我们还要一个临时变量去记录当前最小的freq，因为当capacity满了，我们需要去最小的freq里面
    删除最后一个node，而不是从1开始往上遍历freq，然后update的时候也要去维护这个最小变量，因为可能
    只有一个个node但被put了两次，那么freq就是2了不是1
    */

        class Node{
            int key;
            int val;
            int freq;
            Node prev;
            Node next;
            public Node(int k, int v, int f){
                this.key = k;
                this.val = v;
                this.freq = f;
            }
        }

        class DLL{
            Node head;
            Node tail;
            int size;

            public DLL(){
                head = new Node(0, 0, 1);
                tail = new Node(0, 0, 1);
                head.next = tail;
                tail.prev = head;
            }

            public void add(Node node){
                node.next = head.next;
                head.next.prev = node;
                node.prev = head;
                head.next = node;
                size++;
            }

            public void remove(Node node){
                node.prev.next = node.next;
                node.next.prev = node.prev;
                size--;
            }

            public Node removeLast(){
                if(size > 0){
                    Node node = tail.prev;
                    remove(node);
                    return node;
                }else{
                    return null;
                }
            }
        }

        HashMap<Integer, DLL> freqMap;
        HashMap<Integer, Node> nodeMap;
        int capacity;
        int curMinFreq = 0;
        public LFUCache(int capacity) {
            this.capacity = capacity;
            freqMap = new HashMap<>();
            nodeMap = new HashMap<>();
        }

        public int get(int key) {
            if(!nodeMap.containsKey(key)){
                return -1;
            }else{
                Node node = nodeMap.get(key);
                update(node);
                return node.val;
            }
        }

        public void update(Node node){
            DLL old = freqMap.get(node.freq);
            old.remove(node);
            //维护当前最小的freq
            if(node.freq == curMinFreq && old.size == 0){
                curMinFreq++;
            }
            node.freq++;
            DLL next = freqMap.getOrDefault(node.freq, new DLL());
            next.add(node);
            freqMap.put(node.freq, next);
        }

        public void put(int key, int value) {
            if(capacity == 0){
                return;
            }
            if(nodeMap.containsKey(key)){
                Node node = nodeMap.get(key);
                node.val = value;
                update(node);
            }else{
                Node node = new Node(key, value, 1);
                if(nodeMap.size() == capacity){
                    //这里需要一个local去记录现在的最小freq是多少
                    DLL dll = freqMap.get(curMinFreq);
                    Node lastNode = dll.removeLast();
                    nodeMap.remove(lastNode.key);
                }
                nodeMap.put(key, node);
                curMinFreq = 1;
                DLL list = freqMap.getOrDefault(node.freq, new DLL());
                list.add(node);
                freqMap.put(node.freq, list);
            }
        }
    }

}

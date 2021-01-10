package binarysearch;


import java.util.*;

public class bs772LFU {

    class Node{
        int key;
        int val;
        int freq;
        Node prev;
        Node next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }

    class LLNode{
        Node head;
        Node tail;
        int size;
        public LLNode(){
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        //we have head and tail padding, no worry about null
        void remove(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        void add(Node node){
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        Node removeLast(){
            Node node = tail.prev;
            node.prev.next = tail;
            tail.prev = node.prev;
            size--;
            return node;
        }
    }

    class LFUCache {

        //key: key  val: node
        HashMap<Integer, Node> map;
        //key: freq val: llnode
        HashMap<Integer, LLNode> freqmap;
        int curMinFreq;
        int capacity;
        public LFUCache(int capacity) {
            this.capacity = capacity;
            curMinFreq = 0;
            map = new HashMap<>();
            freqmap = new HashMap<>();
        }

        public int get(int key) {
            if(!map.containsKey(key)){
                return -1;
            }
            else{
                Node node = map.get(key);
                update(node);
                return node.val;
            }
        }

        private void update(Node node){
            int oldfreq = node.freq;
            LLNode oldLLNode = freqmap.get(oldfreq);
            oldLLNode.remove(node);
            if(oldfreq == curMinFreq && oldLLNode.size == 0){
                curMinFreq++;
            }
            freqmap.put(oldfreq, oldLLNode);
            node.freq++;
            LLNode newLLNode = freqmap.getOrDefault(node.freq, new LLNode());
            newLLNode.add(node);
            freqmap.put(node.freq, newLLNode);
        }

        public void set(int key, int val) {
            if(capacity == 0){
                return;
            }
            if(map.containsKey(key)){
                Node node = map.get(key);
                node.val = val;
                update(node);
            }else{
                Node node = new Node(key, val);
                if(map.size() == capacity){
                    LLNode llnode = freqmap.get(curMinFreq);
                    Node removeNode = llnode.removeLast();
                    map.remove(removeNode.key);
                }
                map.put(key, node);
                curMinFreq = 1;
                LLNode llnode = freqmap.getOrDefault(node.freq, new LLNode());
                llnode.add(node);
                freqmap.put(node.freq, llnode);
            }
        }
    }
}

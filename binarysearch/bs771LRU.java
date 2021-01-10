package binarysearch;

import java.util.HashMap;

public class bs771LRU {
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    class LRUCache {
        Node head;
        Node tail;
        int capacity;
        HashMap<Integer, Node> map;
        public LRUCache(int capacity) {
            map = new HashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            if(!map.containsKey(key)){
                return -1;
            }else{
                Node node = map.get(key);
                remove(node);
                setHead(node);
                return node.val;
            }
        }

        private void remove(Node node){
            if(node.prev != null){
                node.prev.next = node.next;
            }else{
                head = node.next;
            }
            if(node.next != null){
                node.next.prev = node.prev;
            }else{
                tail = node.prev;
            }
        }

        private void setHead(Node node){
            if(head != null){
                node.prev = null;
                node.next = head;
                head.prev = node;
                head = node;
            }else{
                head = node;
                tail = node;
            }
        }

        public void set(int key, int val) {
            if(map.containsKey(key)){
                Node node = map.get(key);
                node.val = val;
                remove(node);
                setHead(node);
            }else{
                Node node = new Node(key, val);
                map.put(key, node);
                setHead(node);
                if(map.size() > capacity){
                    map.remove(tail.key);
                    remove(tail);
                }
            }
        }
    }
}

package Bloomberg2;

import java.util.HashMap;

public class lt146LRUCache {

    class LRUCache {

        class Node{
            int val;
            int key;
            Node prev, next;
            public Node(int key, int val){
                this.key = key;
                this.val = val;
                this.prev = null;
                this.next = null;
            }
        }

        HashMap<Integer, Node> map;
        int capacity;
        Node head = null;
        Node tail = null;
        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
        }


        public int get(int key) {
            if(map.containsKey(key)){
                Node node = map.get(key);
                remove(node);
                setHead(node);
                return node.val;
            }
            return -1;
        }

        private void remove(Node node){
            // Node node = map.get(key);
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

        /*
        把node放到head
        */
        private void setHead(Node node){
            node.next = head;
            node.prev = null;
            if(head != null){
                head.prev = node;
            }
            head = node;
            if(tail == null){
                tail = node;
            }
        }


        public void put(int key, int value) {
            if(map.containsKey(key)){
                Node node = map.get(key);
                node.val = value;
                remove(node);
                setHead(node);
            }else{
                Node node = new Node(key, value);
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

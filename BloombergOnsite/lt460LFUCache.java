package BloombergOnsite;

import java.util.HashMap;

public class lt460LFUCache {
    class LFUCache {

        class Node{
            int val;
            int cnt;
            int key;
            Node next;
            Node prev;
            public Node(int key, int val){
                this.key = key;
                this.val = val;
                this.cnt = 1;
            }
        }

        class DLList{
            Node head, tail;
            int size;

            public DLList(){
                head = new Node(0, 0);
                tail = new Node(0, 0);
                head.next = tail;
                tail.prev = head;
            }

            void add(Node node){
                head.next.prev = node;
                node.next = head.next;
                node.prev = head;
                head.next = node;
                size++;
            }

            void remove(Node node){
                node.prev.next = node.next;
                node.next.prev = node.prev;
                size--;
            }

            Node removeLast(){
                if(size > 0){
                    Node node = tail.prev;
                    remove(node);
                    return node;
                }else{
                    return null;
                }
            }

        }

        // key: cnt value:dll of node
        HashMap<Integer, DLList> countMap;
        HashMap<Integer, Node> nodeMap;
        int capacity;
        int size = 0;
        int min;
        public LFUCache(int capacity) {
            this.capacity = capacity;
            countMap = new HashMap<>();
            nodeMap = new HashMap<>();
        }

        public int get(int key) {
            if(nodeMap.containsKey(key)){
                Node node = nodeMap.get(key);
                update(node);
                return node.val;
            }else{
                return -1;
            }
        }

        private void update(Node node){
            DLList oldList = countMap.get(node.cnt);
            oldList.remove(node);
            node.cnt++;
            DLList newList = countMap.get(node.cnt);
            newList.add(node);
            countMap.put(node.cnt, newList);
        }


        public void put(int key, int value) {
            if(nodeMap.containsKey(key)){
                Node node = nodeMap.get(key);
                node.val = value;
                update(node);
            }
            else{
                Node node = new Node(key, value);
                nodeMap.put(key, node);
                if(size == capacity){
                    DLList lastList = countMap.get(min);
                    nodeMap.remove(lastList.removeLast().key);
                    size--;
                }
                size++;
                min = 1;
                DLList newList = countMap.getOrDefault(node.cnt, new DLList());
                newList.add(node);
                countMap.put(node.cnt, newList);
            }
        }
    }
}

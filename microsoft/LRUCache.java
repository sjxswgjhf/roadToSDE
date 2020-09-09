package microsoft;


import java.util.HashMap;
class LRUCache {

    class Node{
        int val;
        int key;
        Node prev;
        Node next;
        public Node() {}
        public Node(int key, int val){
            this.val = val;
            this.key = key;
        }

    }


    int capacity;
    int size;
    Node head = null;
    Node tail = null;
    HashMap<Integer, Node> hashmap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        hashmap = new HashMap<>();
    }

    public int get(int key) {
        int ans = -1;
        if(hashmap.containsKey(key)){
            Node node = hashmap.get(key);
            ans = node.val;
            remove(node);
            movetoHead(node);
        }
        return ans;
    }

    private void movetoHead(Node node){
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

    public void put(int key, int value) {
        if(hashmap.containsKey(key)){
            Node node = hashmap.get(key);
            node.val = value;
            remove(node);
            movetoHead(node);
        }else{
            //check size
            Node node = new Node(key, value);
            hashmap.put(key, node);
            movetoHead(node);
            size++;
            if(size > capacity){
                hashmap.remove(tail.key);
                remove(tail);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
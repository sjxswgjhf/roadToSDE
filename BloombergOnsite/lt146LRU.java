package BloombergOnsite;

import java.util.HashMap;

public class lt146LRU {
    class LRUCache {

        /*
        这题remove的时候
        先看node的前面有没有，有的话就把前面的next连到后面，没有的话表示node是head，那么需要把head设置到下一个
        在看node的后面有没有，有的话把后面的prev连到前面，没有的话表示node是tail了，那么需要把tail设置到前一个

        setHead的时候
        先把node的前面变成null，后面连上head，然后我们看head有没有存在，有的话，就把head的prev连到node，再把head改成node，
        在看tail是不是null，是的话说明node是第一个node，tail也得变成node

        put的时候，一种是更新当前值，一种是加入新node
        更新的话直接拿到node，改值然后remove了再放到头，
        加入的话先看有没有空间，有的话，直接放入map再sethead，
        没有的话，先要把tail 从map跟list remove了，再加入node到map跟list里面
        */
        class Node{
            int key;
            int val;
            Node prev, next;
            public Node(int key, int val){
                this.key = key;
                this.val = val;
            }
        }

        HashMap<Integer, Node> map;
        Node head = null;
        Node tail = null;
        int capacity;
        public LRUCache(int capacity) {
            map = new HashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            if(!map.containsKey(key)){
                return -1;
            }else{
                Node node = map.get(key);
                int val = node.val;
                remove(node);
                setHead(node);
                return val;
            }
        }

        private void setHead(Node node){
            node.prev = null;
            node.next = head;
            //头不为空，先链接node
            if(head != null){
                head.prev = node;
            }
            head = node;
            if(tail == null){
                tail = node;
            }
        }

        private void remove(Node node){
            //前面不为空
            if(node.prev != null){
                node.prev.next = node.next;
            }else{
                //前面为空的话node就是head
                head = node.next;
            }
            //后面不为空
            if(node.next != null){
                node.next.prev = node.prev;
            }else{
                //node本来就是tail
                tail = node.prev;
            }
        }

        public void put(int key, int value) {
            if(map.containsKey(key)){
                Node node = map.get(key);
                node.val = value;
                remove(node);
                setHead(node);
            }else{
                if(map.size() < capacity){
                    Node node = new Node(key, value);
                    map.put(key, node);
                    setHead(node);
                }else{
                    Node node = new Node(key, value);
                    map.remove(tail.key);
                    map.put(key, node);
                    remove(tail);
                    setHead(node);
                }
            }

        }
    }

}

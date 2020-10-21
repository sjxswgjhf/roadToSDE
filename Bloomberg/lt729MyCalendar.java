package Bloomberg;

import java.util.TreeMap;

public class lt729MyCalendar {
    class MyCalendar {

        TreeMap<Integer, Integer> map;
        public MyCalendar() {
            map = new TreeMap<>();

        }

        public boolean book(int start, int end) {
            //找一个key<=start
            Integer fs = map.floorKey(start);
            if(fs != null && map.get(fs) > start){
                return false;
            }
            //找一个key仅大于等于start
            Integer ge = map.ceilingKey(start);
            if(ge != null && ge < end){
                return false;
            }
            map.put(start, end);
            return true;
        }
    }

    /**
     * Your MyCalendar object will be instantiated and called as such:
     * MyCalendar obj = new MyCalendar();
     * boolean param_1 = obj.book(start,end);
     */
    class MyCalendarII {

    /*
    Interval question:
    ddl
    */

        class Node{
            int start;
            int end;
            Node prev, next;
            public Node(int start, int end){
                this.start = start;
                this.end = end;
            }
        }

        Node head;

        public MyCalendarII() {
            head = new Node(0, 0);
        }

        public boolean insert(Node node){
            Node cur = head.next;
            //base case, empty list
            if(cur == null){
                head.next = node;
                node.prev = head;
                return true;
            }
            else{
                //check overlap
                Node spot = findSpot(node);
                if(spot.next == null && node.start >= spot.end){
                    spot.next = node;
                    node.prev= spot;
                    return true;
                }
                if(spot.start >= node.end){
                    node.prev = spot.prev;
                    node.next = spot;
                    spot.prev.next = node;
                    spot.prev = node;
                    return true;
                }else{
                    return false;
                }

            }

        }

        public Node findSpot(Node node){
            Node cur = head.next;
            while(cur.next != null && cur.end <= node.start){
                cur = cur.next;
            }
            return cur;
        }

        public boolean book(int start, int end) {
            Node node = new Node(start, end);
            return insert(node);
        }
    }

}

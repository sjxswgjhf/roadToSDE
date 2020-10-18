package Bloomberg;

import java.util.ArrayList;
import java.util.Arrays;

public class lt1472BrowerHisotry {

    class BrowserHistoryDD {

        class Node{
            String val;
            Node prev, next;
            public Node(String val){
                this.val = val;
                prev = null;
                next = null;
            }
        }

        Node cur;
        public BrowserHistoryDD(String homepage) {
            cur = new Node(homepage);
        }

        public void visit(String url) {
            Node node = new Node(url);
            cur.next = node;
            node.prev = cur;
            cur = cur.next;
        }

        public String back(int steps) {
            while(cur.prev != null && steps > 0){
                steps--;
                cur = cur.prev;
            }
            return cur.val;
        }

        public String forward(int steps) {
            while(cur.next != null && steps > 0){
                steps--;
                cur = cur.next;
            }
            return cur.val;
        }
    }

    class BrowserHistoryList {
        ArrayList<String> list;
        int cur;

        public BrowserHistoryList(String homepage) {
            list = new ArrayList<>();
            int cur = 0;
            list.add(homepage);
        }

        public void visit(String url) {
            while(list.size() > cur + 1){
                list.remove(list.size() - 1);
            }
            list.add(url);
            cur++;
        }

        public String back(int steps) {
            if(steps >= cur){
                cur = 0;
            }
            else{
                cur -= steps;
            }
            return list.get(cur);
        }

        public String forward(int steps) {
            if(cur + steps >= list.size()){
                cur = list.size() - 1;
            }else{
                cur += steps;
            }
            return list.get(cur);
        }
    }

}

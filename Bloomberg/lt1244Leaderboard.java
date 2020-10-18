package Bloomberg;

import java.util.HashMap;

public class lt1244Leaderboard {
    class Leaderboard {

        HashMap<Integer, Node> map;

        class Node{
            int score;
            int id;
            Node prev, next;
            public Node(int id, int score){
                this.id = id;
                this.score = score;
                this.prev = null;
                this.next = null;
            }
        }

        Node head;
        public Leaderboard() {
            map = new HashMap();
            head = new Node(0, 0);
        }

        public void addScore(int playerId, int score) {
            if(!map.containsKey(playerId)){
                Node player = new Node(playerId, score);
                map.put(playerId, player);
                //new player

                insertPlayer(player, true);
            }else{
                //old player
                int olderscore = map.get(playerId).score;
                Node player = new Node(playerId, olderscore + score);
                map.put(playerId, player);
                insertPlayer(player, false);
            }
        }

        private void insertPlayer(Node node, boolean isNew){
            if(!isNew){
                removePlayer(node);
            }
            Node tmp = head;
            while(tmp.next != null && tmp.next.score > node.score){
                tmp = tmp.next;
            }
            //tmp.next.score < node.score
            node.next = tmp.next;
            if(tmp.next != null)
                tmp.next.prev = node;
            node.prev = tmp;
            tmp.next = node;
        }

        private void removePlayer(Node node){
            int id = node.id;
            Node tmp = head.next;
            while(tmp.id != node.id){
                tmp = tmp.next;
            }
            tmp.prev.next = tmp.next;
            if(tmp.next != null)
                tmp.next.prev = tmp.prev;
        }

        public int top(int k) {
            int sum = 0;
            Node tmp = head.next;
            while(k-- > 0){
                sum += tmp.score;
                tmp = tmp.next;
            }
            return sum;
        }

        public void reset(int playerId) {
            Node player = map.get(playerId);
            map.remove(playerId);
            removePlayer(player);
        }
    }

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */
}

package weeklyContest.needtodo;

import java.util.PriorityQueue;

public class lt1633wk213 {
    class Solution {

        class Node {
            int r;
            int c;
            String s;

            public Node(int r, int c, String s) {
                this.r = r;
                this.c = c;
                this.s = s;
            }
        }

        public String kthSmallestPath(int[] destination, int k) {
            PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> b.s.compareTo(a.s));
            Node start = new Node(0, 0, new String());
            pq.add(start);
            int m = destination[0];
            int n = destination[1];
            int count = 0;
            outer:
            while (!pq.isEmpty()) {
                int size = pq.size();
                for (int i = 0; i < size; i++) {
                    Node cur = pq.poll();
                    if (cur.r == m && cur.c == n) {
                        break outer;
                    }
                    //h
                    int hnr = cur.r;
                    int hnc = cur.c + 1;
                    if (hnr <= m && hnc <= n) {
                        String nexts = cur.s + "H";
                        Node nextH = new Node(hnr, hnc, nexts);
                        pq.add(nextH);
                        if (pq.size() > k) {
                            pq.poll();
                        }
                        if (hnr == m && hnc == n) {
                            count++;
                        }
                        if (count == k) {
                            return pq.peek().s;
                        }
                    }
                    //v
                    int vnr = cur.r + 1;
                    int vnc = cur.c;
                    if (vnr <= m && vnc <= n) {
                        String nexts = cur.s + "V";
                        Node nextV = new Node(hnr, hnc, nexts);
                        pq.add(nextV);
                        if (pq.size() > k) {
                            pq.poll();
                        }
                        if (vnr == m && vnc == n) {
                            count++;
                        }
                        if (count == k) {
                            return pq.peek().s;
                        }
                    }
                }
            }
            return pq.peek().s;
        }
    }
}

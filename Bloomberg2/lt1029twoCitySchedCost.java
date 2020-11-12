package Bloomberg2;

import java.util.PriorityQueue;

public class lt1029twoCitySchedCost {

    class Solution {
    /*
    简单来说，就是这个人相比较飞a，这人飞b的收益是多少，

    [[10,20],[30,200],[400,50],[30,20]]

    -10, -170, 350, 10

    50 + 20, 10 + 30 =

    */

        class Node{
            int flya;
            int flyb;
            int dif;
            public Node(int a, int b, int d){
                this.flya = a;
                this.flyb = b;
                this.dif = d;
            }
        }
        public int twoCitySchedCost(int[][] costs) {
            PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> (b.dif - a.dif));
            for(int[] cost : costs){
                int a = cost[0];
                int b = cost[1];
                int dif = a - b;
                Node node = new Node(a, b, dif);
                pq.add(node);
            }
            int idx = 1;
            int n = costs.length / 2;
            int res = 0;
            while(!pq.isEmpty()){
                Node node = pq.poll();
                if(idx <= n){
                    res += node.flyb;
                    idx++;
                }else{
                    res += node.flya;
                }
            }
            return res;
        }
    }
}

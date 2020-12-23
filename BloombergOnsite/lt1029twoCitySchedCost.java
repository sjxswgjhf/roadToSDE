package BloombergOnsite;

import java.util.PriorityQueue;

public class lt1029twoCitySchedCost {
    class Solution {
    /*
    一半的人去a,一半的人去b

    10，20
    公司派这人去B，相比去A的收益是 -10
    30, 200
    派去b，相比去A收益是-170,
    400, 50
    派去b，相比A是350
    */

        class Node{
            int flya;
            int flyb;
            int dif;
            public Node(int a, int b, int dif){
                this.flya = a;
                this.flyb = b;
                this.dif = dif;
            }
        }
        public int twoCitySchedCost(int[][] costs) {
            int n = costs.length;
            PriorityQueue<Node> pq = new PriorityQueue<>((a, b)->b.dif-a.dif);
            for(int[] cost : costs){
                int flya = cost[0];
                int flyb = cost[1];
                int dif = flya - flyb;
                Node node = new Node(flya, flyb, dif);
                pq.add(node);
            }
            int amount = 0;
            int totalCost = 0;
            while(!pq.isEmpty()){
                Node node = pq.poll();
                if(amount < n/2){
                    totalCost += node.flyb;
                }else{
                    totalCost += node.flya;
                }
                amount++;
            }
            return totalCost;
        }
    }
}

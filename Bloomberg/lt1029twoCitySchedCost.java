package Bloomberg;

import java.util.Arrays;
import java.util.PriorityQueue;

public class lt1029twoCitySchedCost {

    class SolutionDP {
        /*
        我有i个人把j个人放到a的cost，b就有i-j的cost
        dp[i][0] = 我把i个人都放到b里面
        数据预处理，我们因为是min的，我们先把数据都初始化成max/2，
        然后dp[0][0] = 0, 即0个人放入a的话是cost = 0
        然后遍历，从第一个人开始，如果我一直把人放到b的话，cost也就是dp[i-1][0]+cost[b]
        然后j从1~i，我开始计算把里面的人放入a中的cost，两种情况取min，一种是我前i-1的人，放了j-1个人在a中，那这个人我放入a，第二种我前i-1个人放了j个进去a中了，那么我放入b中
        */
        public int twoCitySchedCost(int[][] costs) {
            int n = costs.length;
            int[][] dp = new int[n + 1][n + 1];
            for(int i = 0; i <= n; i++){
                Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
            }
            dp[0][0] = 0;
            for(int i = 1; i <= n; i++){
                dp[i][0] = dp[i-1][0] + costs[i - 1][1];
                for(int j = 1; j <= i; j++){
                    dp[i][j] = Math.min(dp[i-1][j-1] + costs[i - 1][0], dp[i-1][j] + costs[i - 1][1]);
                }
            }
            return dp[n][n/2];
        }
    }


    class SolutionGreedy {

    /*
    [[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]
    [184,139],[259,770],[448,54],[577,469],[840,118],[926,667]
    45          511         394     108        722      259
    2n = 6 => n = 3
    259 + 577 + 184
    118 + 54 + 667
    想要总和最小即想要两个city的dif最小，那么从最大的dif开始，每次从里面选一个较小值，这样的话每次我们付出的钱的损失就减少了
    */

        class Node{
            int a;
            int b;
            int dif;
            public Node(int a, int b, int dif){
                this.a = a;
                this.b = b;
                this.dif = dif;
            }
        }
        public int twoCitySchedCost(int[][] costs) {
            int res = 0;
            PriorityQueue<Node> pq = new PriorityQueue<>((a, b)->(b.dif == a.dif ? a.a - b.a : b.dif - a. dif));
            for(int[] cost : costs){
                int a = cost[0];
                int b = cost[1];
                int dif = Math.abs(a - b);
                Node node = new Node(a, b, dif);
                pq.add(node);
            }
            int counta = 0;
            int countb = 0;
            while(!pq.isEmpty()){
                Node node = pq.poll();
                if(counta >= costs.length / 2){
                    res += node.b;
                }
                else if(countb >= costs.length / 2){
                    res += node.a;
                }
                else{
                    if(node.a < node.b){
                        res+=node.a;
                        counta++;
                    }else{
                        res+=node.b;
                        countb++;
                    }
                }
            }
            return res;
        }
    }
}

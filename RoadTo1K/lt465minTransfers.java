package RoadTo1K;

import java.util.HashMap;

public class lt465minTransfers {
    class Solution {
        /*
        [[0,1,10], [2,0,5]]
        0->1 $10
        2->0 $5

        [[0,1,10], [1,0,1], [1,2,5], [2,0,5]]

        0->1 $10
        1->0 $1
        0->1 $10 - 1 = 9
        1->2 $5
        2->0 $5

        好像可以通过input来建立一个人的所有外债的合,然后通过债务归并的思想来实现，
        我们把当前债务归并给后面的任意一个人,但是要注意这个人一定是balance相反的，来看之后需要的债务的settle要多少次+1，
        然后要注意当前没有债务的人要跳过，如果当前债务人已经到最后了，返回0，表示不要再额外的settle了
        */
        public int minTransfers(int[][] transactions) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int[] transaction : transactions){
                int giver = transaction[0];
                int taker = transaction[1];
                int amount = transaction[2];
                map.put(giver, map.getOrDefault(giver, 0) + amount);
                map.put(taker, map.getOrDefault(taker, 0) - amount);
            }
            int[] debts = new int[map.size()];
            int idx = 0;
            for(int debt : map.values()){
                debts[idx++] = debt;
            }
            return getMinTransfers(debts, 0);
        }
        /*
        假设0~i-1 person的外债归并完了，对于i~n来说，getMinTransfer能求得最小的settle的次数使得balance平衡
        */
        private int getMinTransfers(int[] debts, int cur){

            //cur没外债
//            while(cur < debts.length && debts[cur] == 0){
//                cur++;
//            }
            if(cur == debts.length){
                return 0;
            }
            //cur 没外债
            if(debts[cur] == 0){
                return getMinTransfers(debts, cur + 1);
            }

            int min = Integer.MAX_VALUE;
            for(int i = cur + 1; i < debts.length; i++){
                if(debts[i] * debts[cur] < 0){           //债务相反，试着归并
                    debts[i] += debts[cur];  //把当前的债务跟后面其中的一个人归并
                    min = Math.min(min, getMinTransfers(debts, cur + 1) + 1); //然后看剩下的债务要多少归并法
                    debts[i] -= debts[cur];
                }
            }
            return min;
        }
    }


}

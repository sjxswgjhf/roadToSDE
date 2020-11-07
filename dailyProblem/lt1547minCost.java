package dailyProblem;

import java.util.*;

public class lt1547minCost {

    /*
    comparing use n, use cuts is much faster, since cuts.length << n
    memo[i][j]: means从cuts[i]~cuts[j]最小的cost，那么我们只需要关心里面的所有切法，所以需要sort，保证有序
    然后我们没有0跟n这两个cut，那么我们要加进去，因为我们最终要求的是把整个stick切了，即cut的话加入0跟n的话就是memo[0][n]
     */
    class SolutionFast {
        public int minCost(int n, int[] cuts) {
            int[] tmp = new int[cuts.length + 2];
            for(int i = 0 ; i < cuts.length; i++){
                tmp[i + 1] = cuts[i];
            }
            tmp[0] = 0;
            tmp[cuts.length + 1] = n;
            Arrays.sort(tmp);
            int[][] memo = new int[tmp.length][tmp.length];
            return cal(memo, tmp, 0, tmp.length - 1);
        }
        //memo[i][j]: 计算i~j里面切法的最小cost
        private int cal(int[][] memo, int[] cuts, int s, int e){
            if(s + 1 == e){
                return 0;
            }
            if(memo[s][e] != 0){
                return memo[s][e];
            }
            int res = Integer.MAX_VALUE;
            for(int i = s + 1; i < e; i++){
                res = Math.min(res, cal(memo, cuts, s, i) + cal( memo, cuts, i, e) + (cuts[e] - cuts[s]));
            }
            if(res == Integer.MAX_VALUE){
                memo[s][e] = 0;
            }
            else{
                memo[s][e] = res;
            }
            return memo[s][e];
        }
    }

    class SolutionSlow {
        public int minCost(int n, int[] cuts) {
            Arrays.sort(cuts);
            // int[][] memo = new int[n+1][n+1];
            HashMap<String, Integer> memo = new HashMap<>();
            return cut(n, cuts, memo, 0,  n, 0, cuts.length);
        }

        private int cut(int n, int[] cuts, HashMap<String, Integer>  memo, int s, int e, int start, int end){
            if(s + 1 == e){
                return 0;
            }
            String key = s +"-"+e;
            if(memo.containsKey(key)){
                return memo.get(key);
            }
            int sum = Integer.MAX_VALUE;
            for(int i = start;  i < end; i++){
                int cur = cuts[i];
                if(cur > s && cur < e){
                    sum = Math.min(sum, cut(n, cuts, memo, s, cur, start, i) + cut(n, cuts, memo, cur, e, i, end) + (e - s));
                }
            }
            if(sum == Integer.MAX_VALUE){
                memo.put(key, 0);
            }else{
                memo.put(key, sum);
            }
            return memo.get(key);
        }

    }



    class SolutionMemoryExceed {
        //memory excedd.... may be should use hashmap
        public int minCost(int n, int[] cuts) {
            Arrays.sort(cuts);
            int[][] memo = new int[n+1][n+1];
            return cut(n, cuts, memo, 0,  n, 0, cuts.length);
        }

        private int cut(int n, int[] cuts, int[][] memo, int s, int e, int start, int end){
            if(s + 1 == e){
                return 0;
            }
            if(memo[s][e] != 0){
                return memo[s][e];
            }
            int sum = Integer.MAX_VALUE;
            for(int i = start;  i < end; i++){
                int cur = cuts[i];
                if(cur > s && cur < e){
                    sum = Math.min(sum, cut(n, cuts, memo, s, cur, start, i) + cut(n, cuts, memo, cur, e, i, end) + (e - s));
                }
            }
            if(sum == Integer.MAX_VALUE){
                memo[s][e] = 0;
            }else{
                memo[s][e] = sum;
            }
            return memo[s][e];
        }
    }
}

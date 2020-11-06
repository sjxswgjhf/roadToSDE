package dailyProblem;

import java.util.*;

public class lt1547minCost {

    class SolutionFast {
        public int minCost(int n, int[] cuts) {
            List<Integer> c = new ArrayList<Integer>();
            for (int cut : cuts)
                c.add(cut);
            c.addAll(Arrays.asList(0, n));
            Collections.sort(c);
            int[][] dp = new int[c.size()][c.size()];
            for (int i = c.size() - 1; i >= 0; --i)
                for (int j = i + 1; j < c.size(); ++j) {
                    for (int k = i + 1; k < j; ++k)
                        dp[i][j] = Math.min(dp[i][j] == 0 ? Integer.MAX_VALUE : dp[i][j],
                                c.get(j) - c.get(i) + dp[i][k] + dp[k][j]);
                }
            return dp[0][c.size() - 1];
        }

    }

    class Solution {
        //memory excedd.... may be should use hashmap
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
            boolean findCut = false;
            for(int i = start;  i < end; i++){
                int cur = cuts[i];
                if(cur > s && cur < e){
                    findCut = true;
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

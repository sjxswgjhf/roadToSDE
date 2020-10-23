package dailyProblem;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class lt1049lastStoneWeightII {

    /*
    拆解成背包问题，一组数分两组，minimum diff
    sum是能达到最大的情况
    dp[n][sum]为用了n个数能达到的sum

    dp[i][j] 为用了i个数能达到的j的sum有哪些
    如果dp[i-1][j]是true，那么dp[i][j]就是true，因为我不包含自己就可以了
    如果nums[i] <= j，那么如果dp[i-1][j-nums[i]]是true，我包含自己也能达到
    base case:
    前i个数，和为0一直是true,dp[i][0] = true
    最后我们看我们从sum /2 往回走，哪个是能得到的sum，就是最后的dif=sum-i-i
    为什么是这样呢？这样做是等同于我们在分组，一组包含了一些数字，剩下的就给另一组，
    我们看我们这组数能到哪些sum，最大肯定是所有的sum，然后看第i个数能有哪些sum取决于前i-1到了哪些sum,
    最后我们就知道我们这组数能达到的所有sum，
    然后找dif，如果要最小的dif，肯定是尽可能的均分，记这组 = sum/2，剩下的 = sum / 2,
    那么我们从sum/2往小的走，看我们这组数到达过那个值，这个值就是我们能达到的最小的dif,怎么计算dif，这组数能达到k,那么剩下的是sum-k,
    dif = (sum - k) - k
     */
    class Solution {
        public int lastStoneWeightII(int[] stones) {
            int sum = 0;
            for(int stone : stones){
                sum += stone;
            }
            int n = stones.length;
            boolean[][] dp = new boolean[n + 1][sum + 1];
            for(int i = 0; i <= n; i++){
                dp[i][0] = true;
            }
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= sum; j++){
                    dp[i][j] = dp[i-1][j];
                    if(stones[i - 1] <= j){
                        if(dp[i - 1][j - stones[i - 1]]){
                            dp[i][j] = true;
                        }
                    }
                }
            }
            int dif = Integer.MAX_VALUE;
            for(int i = sum / 2; i >=0; i--){
                if(dp[n][i] == true){
                    dif = sum - i -i;
                    break;
                }
            }
            return dif;
        }
    }

    static class SolutionTLE {
        /*
        2 7 4 1 8 1

        对于当前i来说我需要去找一块石头去的destroy来。
        那么我需要找到一块跟我dif最小的，去尽可能的让缩减之后的石头小。


        2 7 4 1 8 1
        idx = 0:
        自己: 过
        跟7: 0 5 4 1 8 1
        跟4: 0 7 2 1 8 1
        跟1: 1 7 4 0 8 1
        跟8: 0 7 4 1 6 1
        跟1: 1 7 4 1 8 0

        idx  1：
        0 5 4 1 8 1
    get 0 1 1 1 8 1
        0 4 4 0 8 1
        0 0 4 1 3 1
        0 4 4 1 8 0


        2 7 4 8 => 2 4 7 8
        每次结果都要sort为下一次服务，这样保证了合成之后的那个0到了前面，下一个idx的值不会是0，除非是最后一位的0
        其实没必要sort，我们只要替换就好了，把dif给后面合并的idx，当前改成0就行。节省sort了！
        或者sort的话，是不是只用看下一位就好了？不用看后面的了.. greedy,证明是错的
        不 sort：
        idx: 0
        0 2 7 8
        0 4 5 8
        0 4 7 6
        idx: 1
        0 2 7 8 =>
        0 0 5 8
        0 0 7 6

        0 4 5 8 =>
        0 0 1 8
        0 0 5 4

        idx 2:
        0 0 0 3
        0 0 0 1

        0 0 0 7
        0 0 0 1

        res = 1

        这个错发为什么TLE,因为是2^n的做法
    */
        public static int lastStoneWeightII(int[] stones) {

            int res = Integer.MAX_VALUE;
            HashSet<List<Integer>> set = new HashSet<>();
            List<Integer> l = new ArrayList<>();
            for(int i : stones){
                l.add(i);
            }
            set.add(l);
            for(int i = 0; i < stones.length - 1; i++){
                System.out.println(set.size());
                HashSet<List<Integer>> tmp = new HashSet<>();
                HashSet<String> dups = new HashSet<>();
                for(List<Integer> list : set){
                    for(int j = i + 1; j < list.size(); j++){
                        int cur = list.get(i);
                        int next = list.get(j);
                        List<Integer> newList = new ArrayList<>(list);
                        if(cur >= next){
                            newList.set(i, 0);
                            newList.set(j, cur - next);
                        }else{
                            newList.set(i, 0);
                            newList.set(j, next - cur);
                        }
                        Collections.sort(newList);
                        StringBuffer sb = new StringBuffer();
                        for(int mn : newList){
                            sb.append(mn);
                        }
                        if(!dups.contains(sb.toString())){
                            tmp.add(newList);
                            dups.add(sb.toString());
                        }
                    }
                }
                set.clear();
                set.addAll(tmp);
            }
            for(List<Integer> list : set){
                res = Math.min(list.get(stones.length - 1), res);
            }
            return res;
        }

        public static void main(String[] args) {
            int[] stones = {2 ,7, 4, 1, 8, 1};
            int[] stones1 = {1,1,2,3,5,8,13,21,34,55,89,14,23,37,61,98};

            int res = lastStoneWeightII(stones1);
            System.out.println(res);
        }
    }
}

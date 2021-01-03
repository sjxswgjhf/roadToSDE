package dailyProblem;

import java.util.ArrayDeque;
import java.util.Deque;

public class lt1425constrainedSubsetSum {

    class Solution {
        /*
        deque里面存的是到那个idx的sum，如果比之前的大的话，那么之前的sum就没有意义了，直接pop掉,
        dp存的是当前idx能达到的最大的sum，而deque里面存的是最大的sum的idx对应的那个
        */
        public int constrainedSubsetSum(int[] nums, int k) {
            int n = nums.length;
            Deque<Integer> deque = new ArrayDeque<>();
            int max = Integer.MIN_VALUE;
            int[] dp = new int[nums.length];
            for(int i = 0; i < nums.length; i++){
                while(!deque.isEmpty() && i - deque.peekFirst() > k){
                    deque.pollFirst();
                }
                dp[i] = nums[i];
                if(!deque.isEmpty()){
                    dp[i] = Math.max(dp[i], nums[i] + dp[deque.peekFirst()]);
                }
                max = Math.max(max, dp[i]);
                while(!deque.isEmpty() && dp[deque.peekLast()] <= dp[i]){
                    deque.pollLast();
                }
                deque.addLast(i);
            }
            return max;
        }
    }
}

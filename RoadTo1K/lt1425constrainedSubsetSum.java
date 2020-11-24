package RoadTo1K;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class lt1425constrainedSubsetSum {

    class Solution {
        /*
        Deque,又老又小的会被pop掉

        [X X X X -1] 5
        -1没用，可以直接pop掉，因为用不到
        所以最后的deque是单调递减的
        [9 8 7 6] 5
        然后我们要加上的就是deque的头部那个值，因为他是最大的，
        然后我们还要维护即将过去的值，即到5的时候，可能9已经过期了，需要丢弃

        deque 保存的是dp的idx

        1. maintain a monotone decreasing queue by poping out tail elements smaller than nums[i]
        2. check if head element is out of date
        3. the current head element of the deque is the max of the sliding window
        */
        public int constrainedSubsetSum(int[] nums, int k) {
            Deque<Integer> deque = new LinkedList<>();
            int n = nums.length;
            int[] dp = new int[n];
            for(int i = 0; i < n; i++){
                while(!deque.isEmpty() && deque.peekFirst() < i - k){
                    deque.pollFirst();
                }
                dp[i] = nums[i];
                if(deque.size() > 0){
                    dp[i] = Math.max(dp[i], nums[i] + dp[deque.peekFirst()]);
                }
                //要注意这里是比较dp的值
                while(!deque.isEmpty() && dp[deque.peekLast()] <= dp[i]){
                    deque.pollLast();
                }
                //deque里面保存的是dp的idx，不是值
                deque.addLast(i);
            }
            int res = Integer.MIN_VALUE;
            for(int d : dp){
                res = Math.max(res, d);
            }
            return res;
        }
    }

    class SolutionPQTLE{
        /*
      [10,2,-10,5,20]   k = 2

      x x [x j x x] i

      维护一个最大堆，最大堆里面保存了dp[i]
      首先保证最大堆的size是k，怎么维护，当我们的heap的size大于k了的话，
      我们就要移除一个，移除的那个应该是不在window范围内的数值，即i-k-1
      那么我们在当前idx i的时候，我们想要知道最大的sum,
      首先是肯定是自己本身是一个，或者当前最大堆有东西的话，本身+最大堆的顶部
      之后把当前dp[i]加入到heap里面，

    */
        public int constrainedSubsetSum(int[] nums, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
            int n = nums.length;
            int[] dp = new int[n];
            for(int i = 0; i < n; i++){
                if(pq.size() > k && i-k-1 >=0){
                    pq.remove(dp[i-k-1]);   //O(N) not works, in C++, multiset works
                }
                dp[i] = nums[i];
                if(pq.size() > 0){
                    dp[i] = Math.max(dp[i], nums[i] + pq.peek());
                }
                pq.add(dp[i]);
            }
            int res = Integer.MIN_VALUE;
            for(int d : dp){
                res = Math.max(d, res);
            }
            return res;
        }
    }

    class SolutionTLE {

        /*
        maximum sum of a non-empty subsequence of that array
        nums[i], nums[j] => j - i <= k

        nums = [10,2,-10,5,20], k = 2

        10 2 5 20
        对于下一数的pick，我可以选择的范围是后面k个数..即每选择一个数，我有一个k宽度的跳板

        x x [x j x x] i

        dp[i]: maximum sum of a subsequence from array 0 ~ i

        dp[i] = nums[i] base case,不管k等于几，nonempty sum肯定是本身先

        dp[i] = max(dp[i], nums[i] + dp[j]) j = i - k, k = 1~K 从i-k到i-1里面选一个最大的subsequence sum

        O(NK)
        */
        public int constrainedSubsetSum(int[] nums, int k) {
            int n = nums.length;
            int[] dp = new int[n];
            for(int i = 0; i < n; i++){
                dp[i] = nums[i];
            }
            int res = Integer.MIN_VALUE;
            for(int i = 0; i < n; i++){
                for(int j = 1; j <= k && i - j >= 0; j++){
                    dp[i] = Math.max(dp[i], dp[i-j] + nums[i]);
                }
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }


}

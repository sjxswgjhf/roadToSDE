package dailyProblem;

import java.util.ArrayDeque;
import java.util.Deque;

public class lt1696jumpGameVI {

    class SolutionDeque {
        /*
        deque存了目前为止的分数，是从大到小的，
        我们到下一格的分数是，deque的首+当前的score，
        但是我们要看这个score能比前面的score大还是小，如果大的话，那前面的分数没有用，我们用当前的这个就好了
        所以我们从deque的后面开始往前看，把所有比它小的分数都pop了，因为他们已经用不到了，useless了，
        然后我们还要维护deque的顶部不能超过k的限制范围
        */
        public int maxResult(int[] nums, int k) {
            int n = nums.length;
            Deque<Integer> deque = new ArrayDeque<>();
            int[] dp = new int[n + 1];
            dp[1] = nums[0];
            deque.addLast(1);
            for(int i = 2; i <= n; i++){
                dp[i] = nums[i-1] + dp[deque.peekFirst()];
                while(!deque.isEmpty() && dp[deque.peekLast()] <= dp[i]){
                    deque.pollLast();
                }
                deque.addLast(i);
                if(i - deque.peekFirst() == k){
                    deque.pollFirst();
                }
            }
            return dp[n];
        }
    }
}

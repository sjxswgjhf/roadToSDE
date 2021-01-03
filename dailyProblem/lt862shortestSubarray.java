package dailyProblem;

import java.util.ArrayDeque;
import java.util.Deque;

public class lt862shortestSubarray {
    class Solution {
        public int shortestSubarray(int[] A, int K) {
            int n = A.length;
            int[] prefix = new int[n + 1];
            int res = n + 1;
            for(int i = 1; i <= n; i++){
                prefix[i] = prefix[i-1] + A[i-1];
            }
            Deque<Integer> deque = new ArrayDeque<>();
            for(int i = 0; i <= n; i++){
                //j~i的sum是大于等于k的，拿出来跟res比较长度，取小的
                while(!deque.isEmpty() && prefix[i] - prefix[deque.peekFirst()] >= K){
                    res = Math.min(res, i - deque.pollFirst());
                }
                //如果后面的数在进来，比起deque里面的，i的prefix sum小，又idx大，那么我们肯定用不到deque里面的那些了
                //他们也就不需要了
                while(!deque.isEmpty() && prefix[i] <= prefix[deque.peekLast()]){
                    deque.pollLast();
                }
                deque.addLast(i);
            }
            return res == n + 1 ? -1 : res;
        }
    }
}

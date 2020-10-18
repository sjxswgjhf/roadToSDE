package Bloomberg;

import java.util.*;

public class maxSlidingWindow {


    class Solution {
        /*
        想要缩减时间，那么势必要缩减inner for loop
        对于当前idx来说，如果有个数组能是排序好的，那么我就可以第一时间知道最大值是什么了，如果当前最大值小于我，我把数组清空放自己
        Deque: 里面放idx，为什么不是val，因为要计算区间，直到存了idx在后面我们才能计算已经走了多少个了，超没超过k
        1. 如果当前queue不为空并且超过了k，那么我们继续就popFirst
        2. 如果当前queue不为空，我要看当前数是第几个大的放到合适的位置，通过popLast把所有比当前小的pop掉之后，就能实现
        3. 加入到queue，加idx
        */
        public int[] maxSlidingWindow(int[] nums, int k) {
            if(k == 1){
                return nums;
            }
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            int[] res = new int[nums.length - k + 1];
            for(int i = 0; i < nums.length; i++){
                while(deque.size() > 0 && deque.peekFirst() <= i - k){
                    deque.pollFirst();
                }
                while(deque.size() > 0 && nums[deque.peekLast()] < nums[i]){
                    deque.pollLast();
                }
                deque.offerLast(i);
                if(i >= k - 1){
                    res[i - k + 1] = nums[deque.peekFirst()];
                }
            }
            return res;
        }
    }

    class SolutionTLE {

        List<Float> degrees = new ArrayList<>();

        public int[] maxSlidingWindow(int[] nums, int k) {
            if(k == 1){
                return nums;
            }
            int[] res = new int[nums.length - k + 1];
            for(int i = 0 ; i < nums.length - k + 1 ; i++){
                int max = Integer.MIN_VALUE;
                for(int j = i; j < i + k; j++){
                    max = Math.max(max, nums[j]);
                }
                res[i] = max;
            }
            return res;
        }
    }
}

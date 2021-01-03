package dailyProblem;

import java.util.ArrayDeque;
import java.util.Deque;

public class lt1438longestSubarray {

    class Solution {
        /*
        maxDeque 存到是递减的
        minDeque 存的是递增的
        */
        public int longestSubarray(int[] nums, int limit) {
            Deque<Integer> minD = new ArrayDeque<>();
            Deque<Integer> maxD = new ArrayDeque<>();
            int max = 0;
            int l = 0;
            for(int i = 0 ; i < nums.length; i++){
                while(!maxD.isEmpty() && nums[i] > maxD.peekLast()){
                    maxD.pollLast();
                }
                while(!minD.isEmpty() && nums[i] < minD.peekLast()){
                    minD.pollLast();
                }
                maxD.addLast(nums[i]);
                minD.addLast(nums[i]);
                while(maxD.peekFirst() - minD.peekFirst() > limit){
                    if(maxD.peekFirst() == nums[l]){
                        maxD.pollFirst();
                    }
                    if(minD.peekFirst() == nums[l]){
                        minD.pollFirst();
                    }
                    l++;
                }
                max = Math.max(max, i - l + 1);
            }
            return max;
        }
    }
}

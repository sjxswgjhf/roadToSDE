package dailyProblem;

import java.util.ArrayDeque;
import java.util.Deque;

public class lt239maxSlidingWindow {

    class Solution {
        /*
        queue里面装的是当前最大的num的idx,
        如果当前的小于queue里面的，那么放入里面，不然就把queue清空,注意维护size为k
        */
        public int[] maxSlidingWindow(int[] nums, int k) {
            Deque<Integer> deque = new ArrayDeque<>();
            int[] res = new int[nums.length - k + 1];
            for(int i = 0; i < k - 1; i++){
                if(deque.isEmpty()){
                    deque.add(i);
                }else{
                    if(nums[deque.peekLast()] > nums[i]){
                        deque.addLast(i);
                        continue;
                    }
                    while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                        deque.pollLast();
                    }
                    deque.addLast(i);
                }
            }
            int idx = 0;
            for(int i = k - 1; i < nums.length; i++){
                if(deque.isEmpty()){
                    res[idx] = nums[i];
                    deque.addLast(i);
                }else{
                    if(nums[deque.peekLast()] > nums[i]){
                        res[idx] = nums[deque.peekFirst()];
                        deque.addLast(i);
                    }else{
                        while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                            deque.pollLast();
                        }
                        if(deque.isEmpty()){
                            res[idx] = nums[i];
                        }else{

                            res[idx] = nums[deque.peekFirst()];
                        }
                        deque.addLast(i);
                    }
                }
                if(i - deque.peekFirst() >= k - 1){
                    deque.pollFirst();
                }
                idx++;
            }
            return res;
        }
    }
}

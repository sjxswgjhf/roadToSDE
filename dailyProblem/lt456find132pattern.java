package dailyProblem;

import java.util.Stack;

public class lt456find132pattern {
    class Solution {
        /*
        如果当前idx满足132pattern的话，首先对于当前idx来说，

        */
        public boolean find132pattern(int[] nums) {
            Stack<Integer> stack = new Stack<>();
            int[] min = new int[nums.length];
            min[0]=nums[0];
            for(int i = 1; i < nums.length; i++){
                min[i] = Math.min(min[i-1], nums[i]);
            }
            for(int j = nums.length - 1; j >= 0; j--){
                if(stack.isEmpty()){
                    stack.push(nums[j]);
                }else{
                    //首先看有没有一个k存在，使得大于当前的min[j]，如果后面的元素比当都小，肯定用不到了,pop
                    while(!stack.isEmpty() && stack.peek() <= min[j]){
                        stack.pop();
                    }
                    //然后再看stack顶部这个代表3的元素是不是小于当前的num，是的话就找到了i跟k了，就true
                    if(!stack.isEmpty() && stack.peek() < nums[j]){
                        return true;
                    }
                    stack.push(nums[j]);
                }
            }
            return false;
        }
    }
}

package dailyProblem;

import java.util.Stack;

public class lt503nextGreaterElements {
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int n = nums.length;
            int[] res = new int[n];
            Stack<Integer> stack = new Stack<>();
            for(int i = n * 2 - 1; i >= 0; i--){
                while(!stack.isEmpty() && nums[stack.peek()] <= nums[i % n]){
                    stack.pop();
                }
                res[i % n] = stack.isEmpty() ? -1 : nums[stack.peek()];
                stack.push(i % n);
            }
            return res;
        }
    }

    class SolutionNaive {
        /*
        naive: 每个数字都找一边
        N^2
        */
        public int[] nextGreaterElements(int[] nums) {
            int n = nums.length;
            int[] res = new int[n];
            for(int i = 0; i < n; i++){
                boolean find = false;
                for(int j = 1; j < n; j++){
                    int idx = (i + j) % n;
                    if(nums[i] < nums[idx]){
                        find = true;
                        res[i] = nums[idx];
                        break;
                    }
                }
                if(!find){
                    res[i] = -1;
                }
            }
            return res;
        }
    }
}

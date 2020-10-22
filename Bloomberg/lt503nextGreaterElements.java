package Bloomberg;

import java.util.Stack;

public class lt503nextGreaterElements {

    class Solution {

        /*
         1,3,5,2,4,1
         0 1 2 3 4 5
         单调递增 Monotone stack
        */
        public int[] nextGreaterElements(int[] nums) {
            Stack<Integer> stack = new Stack<>();
            int[] res = new int[nums.length];
            int n = nums.length;
            for(int i = 2 * n - 1; i >=0; i--){
                while(!stack.isEmpty() && nums[stack.peek()] <= nums[i % n]){
                    stack.pop();
                }
                res[i % n] = stack.empty() ? -1 : nums[stack.peek()];
                stack.push(i % n);
            }
            return res;
        }
    }

    class SolutionBF {
        public int[] nextGreaterElements(int[] nums) {
            int[] tmp = new int[nums.length * 2];
            int n = nums.length;
            for(int i = 0; i < nums.length; i++){
                tmp[i] = nums[i];
                tmp[i + n] = nums[i];
            }
            int[] res = new int[n];
            for(int i = 0; i < nums.length; i++){
                int cur = nums[i];
                int candidate = -1;
                for(int j = i + 1; j < i + n; j++){
                    if(candidate == -1){
                        if(tmp[j] > cur){
                            candidate = tmp[j];
                            break;
                        }
                    }
                }
                res[i] = candidate;
            }
            return res;
        }
    }
}

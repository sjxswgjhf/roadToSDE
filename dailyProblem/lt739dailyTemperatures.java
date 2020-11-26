package dailyProblem;

import java.util.Stack;

public class lt739dailyTemperatures {

    class Solution {
        /*
        T = [73, 74, 75, 71, 69, 72, 76, 73],
        A = [1,  1,  4,  2, 1, 1, 0, 0].

        Stack, from back to front, keep monotonic increasing
        */
        public int[] dailyTemperatures(int[] T) {
            Stack<Integer> stack = new Stack<>();
            int[] res = new int[T.length];
            for(int i = T.length - 1; i >= 0; i--){
                while(!stack.isEmpty() && T[stack.peek()] <= T[i]){
                    stack.pop();
                }
                res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
                stack.push(i);
            }
            return res;
        }
    }
}

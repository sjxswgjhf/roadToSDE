package dailyProblem;

import java.util.Stack;

public class lt946validateStackSequences {

    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Stack<Integer> stack = new Stack<>();
            int popIdx = 0;
            for(int i = 0; i < pushed.length; i++){
                stack.push(pushed[i]);
                while(!stack.isEmpty() && stack.peek() == popped[popIdx]){
                    stack.pop();
                    popIdx++;
                }
            }
            //return stack.isEmpty()&&popIdx==popped.length;
            return stack.isEmpty();
        }
    }
}

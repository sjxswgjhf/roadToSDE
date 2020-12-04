package dailyProblem;

import java.util.Stack;

public class lt946validateStackSequences {

    /*
    把push按顺序加入stack，然后同时检查pop的idx是不是遇到了push进去的value，是的话我们一路从stack
    里面pop，直到我们遇到了一个不一样的val，最后的时候，如果是有效的pop的话，那么肯定是能清空stack的

    */
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

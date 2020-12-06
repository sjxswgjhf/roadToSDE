package dailyProblem;

import java.util.Stack;

public class lt1209removeDuplicates {

    class Solution {

        class Node{
            char val;
            int freq;
            public Node(char v, int f){
                val = v;
                freq = f;
            }
        }
        public String removeDuplicates(String s, int k) {
            Stack<Node> stack = new Stack<>();
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(stack.isEmpty() || stack.peek().val != c){
                    stack.push(new Node(c, 1));
                }else{
                    if(stack.peek().freq + 1 == k){
                        int tmp = stack.peek().freq;
                        while(tmp-- > 0){
                            stack.pop();
                        }
                    }else{
                        stack.push(new Node(c, stack.peek().freq + 1));
                    }
                }
            }
            String res = new String();
            while(!stack.isEmpty()){
                res = stack.pop().val + res;
            }
            return res;
        }
    }
}

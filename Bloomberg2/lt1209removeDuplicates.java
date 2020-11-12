package Bloomberg2;

import java.util.Stack;

public class lt1209removeDuplicates {

    class Solution {

        class Node{
            char c;
            int freq;
            public Node(char c, int freq){
                this.c = c;
                this.freq = freq;
            }
        }

        public String removeDuplicates(String s, int k) {
            if(s.length() < k){
                return s;
            }
            int n = s.length();
            int r= 0;
            Stack<Node> stack = new Stack<>();
            while(r < n){
                if(stack.isEmpty() || stack.peek().c != s.charAt(r)){
                    Node node = new Node(s.charAt(r), 1);
                    stack.push(node);
                }else{
                    if(stack.peek().freq + 1 == k){
                        stack.pop();
                    }else{
                        stack.peek().freq++;
                    }
                }
                r++;
            }
            String res = "";
            while(!stack.isEmpty()){
                Node node = stack.pop();
                for(int i = 0; i < node.freq; i++){
                    res = node.c + res;
                }
            }
            return res;
        }
    }

    /*
    n^2 / k
     */
    class SolutionSlow {
        public String removeDuplicates(String s, int k) {
            if(s.length() < k){
                return s;
            }
            int n = s.length();
            int l = 0;
            int r = 0;
            String res = "";
            while(r < n){
                int count = 0;
                while(r < n && s.charAt(l) == s.charAt(r)){
                    count++;
                    r++;
                    if(count == k){
                        break;
                    }
                }
                if(count >= k){
                    l = r;
                }else{
                    res += s.substring(l, r);
                    l = r;
                }
            }
            if(!res.equals(s)){
                return removeDuplicates(res, k);
            }
            return res;
        }
    }
}

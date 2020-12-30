package BloombergOnsite;

import java.util.Stack;

public class lt1209removeDuplicates {


    class SolutionStack {

        class Node{
            char c;
            int freq;
            public Node(char c, int f){
                this.c = c;
                this.freq = f;
            }
        }

        public String removeDuplicates(String s, int k) {
            if(s == null || s.length() == 0){
                return "";
            }
            Stack<Node> stack = new Stack<>();
            for(int r = 0; r < s.length(); r++){
                char c = s.charAt(r);
                if(stack.isEmpty() || stack.peek().c != c){
                    stack.push(new Node(c, 1));
                }
                else{
                    if(stack.peek().c == c){
                        Node node = stack.pop();
                        node.freq++;
                        if(node.freq < k){
                            stack.push(node);
                        }
                    }
                }
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

    class Solution2ND {
        public String removeDuplicates(String s, int k) {
            if(s == null || s.length() == 0){
                return "";
            }
            int l = 0;
            int r = 0;
            while(r < s.length()){
                int amount = 0;
                l = r;
                while(r < s.length() && s.charAt(l) == s.charAt(r)){
                    amount++;
                    if(amount == k){
                        s = s.substring(0, l) + s.substring(r + 1);
                        return removeDuplicates(s, k);
                    }
                    r++;
                }
            }
            return s;
        }
    }

    class Solution {
        public String removeDuplicates(String s, int k) {
            if(s == null || s.length() == 0){
                return "";
            }
            int l = 0;
            int r = 0;
            int n = s.length();
            while(r < n){
                int amount = 0;
                while(r < n && s.charAt(l) == s.charAt(r)){
                    amount++;
                    r++;
                    if(amount == k){
                        s = s.substring(0, l) + s.substring(r);
                        return removeDuplicates(s, k);
                    }
                }
                l = r;
            }
            return s;
        }
    }
}

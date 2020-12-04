package dailyProblem;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class lt402removeKdigits {

    class Solution {
        public String removeKdigits(String num, int k) {
            Stack<Integer> stack = new Stack<>();
            //从前往后做，因为后面的数字再大也不会比前面的数字影响大
            for(int i = 0; i < num.length(); i++){
                int val = num.charAt(i) - '0';
                while(!stack.isEmpty() && val < stack.peek() && k > 0){
                    stack.pop();
                    k--;
                }
                stack.push(val);
            }
            while(k > 0){
                stack.pop();
                k--;
            }
            String res = "";
            while(!stack.isEmpty()){
                res = stack.pop() + res;
            }
            int idx = 0;
            for(int i = 0; i < res.length(); i++){
                if(res.charAt(i) == '0'){
                    idx++;
                }else{
                    break;
                }
            }
            res = res.substring(idx);
            return res.length() == 0 ? "0" : res;
        }
    }

    class SolutionDeque {
        /*
        Greedy: 我们需要得到尽可能小的数，也就是说我们移掉前端尽可能大的数

        1432219
            k=3     k =2    k=1  k=1    k = 0
        stack: 14 => 13 => 12 => 122 => 121
        1219
        也有可能到最后k都不为0，例如
        13221999
        k=4
               k=4   k =3   k=3   k=1    k = 1
        stack: 13 => 12 => 122 => 11 => 11999
        所以我们最后还要检查k的值，大于0的话只要把后面的移掉，因为后面的数肯定比前面的大
        */
        public String removeKdigits(String num, int k) {
            if(k >= num.length()){
                return "0";
            }
            Deque<Character> deque = new LinkedList<>();
            for(char c : num.toCharArray()){
                while(!deque.isEmpty() && k > 0 && deque.peekLast() > c){
                    deque.pollLast();
                    k--;
                }
                deque.addLast(c);
            }
            while(k > 0){
                deque.pollLast();
                k--;
            }
            StringBuffer sb = new StringBuffer();
            while(!deque.isEmpty()){
                char c = deque.pollFirst();
                if(c != '0'){
                    sb.append(c);
                }else{
                    if(sb.length() > 0){
                        sb.append(c);
                    }
                }

            }
            return sb.length() == 0 ? "0" : sb.toString();
        }
    }
}

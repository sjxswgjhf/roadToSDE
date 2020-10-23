package Bloomberg;

import java.util.Deque;
import java.util.LinkedList;

public class lt402removeKdigits {

    class Solution {
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

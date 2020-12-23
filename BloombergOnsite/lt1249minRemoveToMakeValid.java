package BloombergOnsite;

import java.util.ArrayDeque;
import java.util.Deque;

public class lt1249minRemoveToMakeValid {

    class Solution {
        /*
        用deque记录当前(,)的idx
        走完一遍之后，deque里面的那些就是无效的(,)
        */
        public String minRemoveToMakeValid(String s) {
            Deque<Integer> deque = new ArrayDeque<>();
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(c == '('){
                    deque.addLast(i);
                }
                else if(c == ')'){
                    if(deque.isEmpty()){
                        deque.addLast(i);
                    }
                    else{
                        if(s.charAt(deque.peekLast()) == '('){
                            deque.pollLast();
                        }else{
                            deque.addLast(i);
                        }
                    }
                }
            }
            if(deque.isEmpty()){
                return s;
            }
            int idx = 0;
            StringBuffer sb = new StringBuffer();
            int invalid = deque.pollFirst();
            for(int i = 0; i < s.length(); i++){
                if(i != invalid){
                    sb.append(s.charAt(i));
                }else{
                    invalid = deque.isEmpty() ? s.length() : deque.pollFirst();
                }
            }
            return sb.toString();
        }
    }
}

package Bloomberg;

import java.util.Stack;

public class lt1209removeDuplicates {



    class Solution {
        public String removeDuplicates(String s, int k) {
            StringBuffer sb = new StringBuffer(s);
            Stack<Integer> stack = new Stack<>();
            for(int i = 0; i < sb.length(); i++){
                if(i == 0 || sb.charAt(i) != sb.charAt(i - 1)){
                    stack.push(1);
                }
                else{
                    int incremented = stack.pop() + 1;
                    if(incremented == k){
                        sb.delete(i - k + 1, i + 1);
                        i = i - k;
                    }
                    else{
                        stack.push(incremented);
                    }
                }
            }
            return sb.toString();
        }
    }

    class SolutionSlow {
        public String removeDuplicates(String s, int k) {
            if (s.length() < k) {
                return s;
            }
            String res = new String();
            int l = 0, r = 0;
            while (r < s.length()) {
                int count = 0;
                while (r < s.length() && s.charAt(l) == s.charAt(r)) {
                    r++;
                    count++;
                    if(count == k){
                        break;
                    }
                }
                if (count >= k) {
                    l = r;
                } else {
                    res += s.substring(l, r);
                    l = r;
                }
            }
            System.out.println(res);
            if (!res.equals(s)) {
                return removeDuplicates(res, k);
            }
            return res;
        }
    }
}

package Bloomberg;

import java.util.ArrayList;
import java.util.List;

public class lt22generateParanthesis {

    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            helper(res, new StringBuffer(), n, 0, 0);
            return res;
        }

        private void helper(List<String> res, StringBuffer sb, int n, int l, int r){
            if(sb.length() == n * 2){
                res.add(new String(sb));
                return;
            }
            if(r > l){
                return;
            }
            if(l < n){
                helper(res, sb.append("("), n, l + 1, r);
                sb.deleteCharAt(sb.length() - 1);
            }
            if(r < l){
                helper(res, sb.append(")"), n, l, r + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}

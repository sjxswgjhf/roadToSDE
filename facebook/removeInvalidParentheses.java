package facebook;

import java.util.ArrayList;
import java.util.List;

public class removeInvalidParentheses {


    class Solution {
    /*
        1. 计算要删除几个(和)
        2. 检查当前input string是不是valid
        3. 先移除右括号，再移除左括号
    首先计算当前要删掉的左右括号都是多少，可以用stack，也可以用左右count来记录，解下来就是dfs，需要用到input，当前idx，左右count，跟res

    递归终止条件是左右count为0，然后判断当前的string是不是有效，是的话加到res
    如果左右count还不是0，继续for loop，从idx开始，首先查看当前char跟前面的是不是一样的，为了避免重复，我们当一样的时候，我们只取第一个，
    接下来把当前char移除，但是要看当前char是不是左右括号先，移除之后，然后看是左还是右，减去相应的count继续递归

    */

        public List<String> removeInvalidParentheses(String s) {
            int[] tmp = compute(s);
            int l = tmp[0];
            int r = tmp[1];
            List<String> ans = new ArrayList<>();
            dfs(s, 0, l, r, ans);
            return ans;
        }

        private void dfs(String s, int start, int l, int r, List<String> res){
            if(l == 0 && r == 0){
                if(isValid(s)){
                    res.add(s);
                    return;
                }
            }
            for(int i = start; i < s.length(); i++){
                //avoid dup
                if(i != start && s.charAt(i) == s.charAt(i - 1)){
                    continue;
                }
                if(s.charAt(i) == '(' || s.charAt(i) == ')'){
                    String cur = s.substring(0, i) + s.substring(i + 1);
                    if(r > 0 && s.charAt(i) == ')'){
                        dfs(cur, i, l, r - 1, res);
                    }
                    else if(l > 0 && s.charAt(i) == '('){
                        dfs(cur, i, l - 1, r, res);
                    }
                }
            }
        }

        private boolean isValid(String s){
            int count = 0;
            for(char c : s.toCharArray()){
                if(c == '('){
                    count++;
                }
                if(c == ')'){
                    count--;
                }
                if(count < 0){
                    return false;
                }
            }
            return count == 0;
        }

        private int[] compute(String s){
            int l = 0;  // (
            int r = 0;  // )
            for(char c : s.toCharArray()){
                if(c == '('){
                    l++;
                }
                else if(l == 0 && c == ')'){
                    r++;
                }
                else{
                    if(c == ')'){
                        l--;
                    }
                }
            }
            int[] res = new int[2];
            res[0] = l;
            res[1] = r;
            return res;
        }
    }

}

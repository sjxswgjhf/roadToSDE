package BloombergOnsite;

import java.util.ArrayList;
import java.util.List;

public class lt301removeInvalidParentheses {

    class Solution {
        public List<String> removeInvalidParentheses(String s) {
            List<String> res = new ArrayList<>();
            //calculate # of l && r to delete
            int[] tmp = compute(s);
            helper(s, 0, tmp[0], tmp[1], res);
            return res;
        }

        private void helper(String s, int idx, int l, int r, List<String> res){
            if(l == 0 && r == 0){
                if(isValid(s)){
                    res.add(s);
                    return;
                }
            }
            for(int i = idx; i < s.length(); i++){
                //avoid dup, (() = > (X), X()
                if(i != idx && s.charAt(i) == s.charAt(i - 1)){
                    continue;
                }
                else{
                    String str = s.substring(0, i) + s.substring(i + 1);
                    //尝试删除当前的(
                    if(l > 0 && s.charAt(i) == '('){
                        helper(str, i, l - 1, r, res);
                    }
                    //尝试删除当前的)
                    else if(r > 0 && s.charAt(i) == ')'){
                        helper(str, i, l, r - 1, res);
                    }
                }
            }
        }

        private boolean isValid(String s){
            int count = 0;
            for(int i = 0 ; i < s.length(); i++){
                if(s.charAt(i) == '('){
                    count++;
                }
                else if(s.charAt(i) == ')'){
                    count--;
                }
                if(count < 0){
                    return false;
                }
            }
            return true;
        }




        private int[] compute(String s){
            char[] cs = s.toCharArray();
            int l = 0;
            int r = 0;
            for(int i = 0; i < cs.length; i++){
                if(cs[i] == '('){
                    l++;
                }
                else if(l == 0 && cs[i] == ')'){
                    r++;
                }else{
                    if(cs[i] == ')')
                        l--;
                }
            }
            return new int[]{l,r};
        }
    }



/*
"()())()"
这题没有很好的方法，只能先计算要删除左右括号的数量，然后去dfs/bfs的删除括号再看当前的str是不是一个有效解，
但是这里面有一个问题就是我们有大量的duplicate,比如((), 我们删掉第一个左括号跟删掉第二个左括号的答案是一样的，
我们要避免重复计算，那么在同一层的loop下有多个连续相同的，我们只计算删掉第一个的情况，后面相同的我们就跳过,
当l跟r都是0了，就检查当前形成的str是不是有效的解


1. 先计算我们要删几个左括号跟几个右括号
2. 怎么避免重复计算, (() => () x(), (x)都行，那么我们计算了一种就要避免计算第二种，



*/
}

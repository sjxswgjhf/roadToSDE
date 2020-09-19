package facebook;

import java.util.ArrayList;
import java.util.List;

public class addOperators {

    class Solution {
        /*
        123   6
        1+2+3 1*2*3
        1021
        这题难点很多,首先可以确定的时候要做DFS,
        DFS：
        终止条件是走完整个num，然后看当前的val是不是target，是的话就把当前的str加到res
        要有个for loop去找substring，这里需要传个idx去表示下一层的for loop哪里开始
        然后首先要确认当前的val是不是一个有效的val，即首个digit不能是0，i!=pos，不能是初始位置，然后c[pos]=0就break，无效
        接下来我们把当前str变成long，然后看pos是不是0，
        1. 如果是第一个位置的时候，我们直接继续增加digit
        2. 如果不是，那么三种情况，+-*
        +,-: 直接append str，然后prev替换成当前的，+为正，-为负，然后sum就是累计当前的val
            *的话，我们要用到prev这个值，先把sum-prev的值，得到上层累计之前的值，然后再跟（当前层的值*上层的值）累计
        */
        public List<String> addOperators(String num, int target) {
            List<String> res = new ArrayList<>();
            helper(num, target, res, "", 0, 0, 0);
            return res;
        }

        private void helper(String num, int target, List<String> res, String str, int pos, long prev, long sum){
            if(pos == num.length()){
                if(sum == target){
                    res.add(str);
                }
                return;
            }
            for(int i = pos; i < num.length(); i++){
                // 考虑 0x 0xx invalid
                if(i != pos && num.charAt(pos) == '0'){
                    break;
                }
                //把当前str变成long避免overflow
                long val = Long.parseLong(num.substring(pos, i + 1));
                //当第一个idx的时候，
                if(pos == 0){
                    helper(num, target, res, str + val, i + 1, val, val);
                }
                else{
                    //这里要处理+-跟*的优先级问题，所以需要一个prev的val去记录上一层的值，那么当我们遇到处理*的时候
                    //我们就可以先把累计值减去先前的值,即1+2*3的时候，先前是2，累计值为3，我们3-2=1,然后先前的值乘当前的值+累计的值2*3+1
                    helper(num, target, res, str + "+" + val, i + 1, val, sum + val);
                    helper(num, target, res, str + "-"+val, i + 1, -val, sum -val);
                    helper(num, target, res, str + "*" + val, i + 1, prev * val,sum - prev + prev * val);
                }
            }

        }
    }
}

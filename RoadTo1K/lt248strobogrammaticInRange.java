package RoadTo1K;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lt248strobogrammaticInRange {

    class Solution{

        /*
        backtracking 求出所有的low~high的长度内的number，然后比较bound，然后count

        HashMap<Integer, List<String>> map;这里不能用，因为hashmap记录的是有效的解，我们去掉了00开头的解之后，subans里面也没有了，所以新构成的也没有，少case了
        */
        public int strobogrammaticInRange(String low, String high){
            int count = 0;
            List<String> rst = new ArrayList<String>();
            for(int i = low.length(); i <= high.length(); i++){
                rst.addAll(helper(i, i));
            }
            for(String num : rst){
                if((num.length() == low.length()&&num.compareTo(low) < 0 ) ||(num.length() == high.length() && num.compareTo(high) > 0)) {
                    continue;
                }
                count++;
            }
            return count;
        }

        private List<String> helper(int cur, int len){
            if(cur == 0) return new ArrayList<String>(Arrays.asList(""));
            if(cur == 1) return new ArrayList<String>(Arrays.asList("1", "8", "0"));

            List<String> res = new ArrayList<>();
            List<String> middle = helper(cur - 2, len);
            for(String tmp : middle){
                if(cur != len){
                    res.add("0" + tmp +"0");
                }
                res.add("1" + tmp + "1");
                res.add("8" + tmp + "8");
                res.add("6" + tmp + "9");
                res.add("9" + tmp + "6");
            }
            return res;
        }
    }
}

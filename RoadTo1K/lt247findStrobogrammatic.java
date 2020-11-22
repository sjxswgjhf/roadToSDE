package RoadTo1K;

import java.util.ArrayList;
import java.util.List;

public class lt247findStrobogrammatic {

    class Solution {
        /*
        0 0
        1 1
        6 9
        8 8

        find all combination
        分成前后两部分做，前面往后append，后面往前insert，然后注意了0的时候要避免leading 0，
        front跟end用StringBuffer来做，每次循环结束需要删除各自的尾部跟头部的char，然后塞入下一种情况
        */
        public List<String> findStrobogrammatic(int n) {
            List<String> res = new ArrayList<>();
            helper(res, new StringBuffer(), new StringBuffer(), 0, n - 1);
            return res;
        }

        private void helper(List<String> res, StringBuffer front, StringBuffer end, int l , int r){
            if(l > r){
                res.add(front.toString() + end.toString());
                return;
            }
            if(l == r){
                String f = front.toString();
                String e = end.toString();
                res.add(f + "0" + e);
                res.add(f + "1" + e);
                res.add(f + "8" + e);
                return;
            }
            if(l < r){
                helper(res, front.append("1"), end.insert(0, "1"), l + 1, r - 1);
                front.deleteCharAt(front.length() - 1);
                end.deleteCharAt(0);
                helper(res, front.append("8"), end.insert(0, "8"), l + 1, r - 1);
                front.deleteCharAt(front.length() - 1);
                end.deleteCharAt(0);
                helper(res, front.append("6"), end.insert(0, "9"), l + 1, r - 1);
                front.deleteCharAt(front.length() - 1);
                end.deleteCharAt(0);
                helper(res, front.append("9"), end.insert(0, "6"), l + 1, r - 1);
                front.deleteCharAt(front.length() - 1);
                end.deleteCharAt(0);
                if(l > 0){
                    helper(res, front.append("0"), end.insert(0, "0"), l + 1, r - 1);
                    front.deleteCharAt(front.length() - 1);
                    end.deleteCharAt(0);
                }
            }
        }
    }
}

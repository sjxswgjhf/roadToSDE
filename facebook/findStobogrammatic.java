package facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findStobogrammatic {

    class SolutionClean{
        public List<String> findStrobogrammatic(int n) {
            return helper(n, n);
        }

        List<String> helper(int n, int m) {
            if (n == 0) return new ArrayList<String>(Arrays.asList(""));
            if (n == 1) return new ArrayList<String>(Arrays.asList("0", "1", "8"));
            List<String> list = helper(n - 2, m);

            List<String> res = new ArrayList<String>();

            for (int i = 0; i < list.size(); i++) {
                String s = list.get(i);

                if (n != m) res.add("0" + s + "0");

                res.add("1" + s + "1");
                res.add("6" + s + "9");
                res.add("8" + s + "8");
                res.add("9" + s + "6");
            }

            return res;
        }
    }


    class Solution {
        /*
        1. 前面放6后面放9，前面放1后面放1，前面放8后面放8，然后最后左等右的时候只能放1或8
        */
        public List<String> findStrobogrammatic(int n) {
            List<String> res = new ArrayList<>();
            helper(res, new StringBuffer(), new StringBuffer(), 0, n - 1);
            return res;
        }

        private void helper(List<String> res, StringBuffer front, StringBuffer back, int l, int r){
            if(l > r){
                res.add(front.toString()+back.toString());
                return;
            }
            if(l >= r){
                String tmp1 = front.toString() + "1" + back.toString();
                String tmp2 = front.toString() + "8" + back.toString();
                String tmp3 = front.toString() + "0" + back.toString();
                res.add(tmp1);
                res.add(tmp2);
                res.add(tmp3);
                return;
            }
            else{
                helper(res, front.append("6"), back.insert(0,"9"), l+1, r-1);
                front.deleteCharAt(front.length() - 1);
                back.deleteCharAt(0);
                helper(res, front.append("9"), back.insert(0,"6"), l+1, r-1);
                front.deleteCharAt(front.length() - 1);
                back.deleteCharAt(0);
                helper(res, front.append("8"), back.insert(0,"8"), l+1, r-1);
                front.deleteCharAt(front.length() - 1);
                back.deleteCharAt(0);
                helper(res, front.append("1"), back.insert(0,"1"), l+1, r-1);
                front.deleteCharAt(front.length() - 1);
                back.deleteCharAt(0);
                if(l > 0){
                    helper(res, front.append("0"), back.insert(0,"0"), l+1, r-1);
                    front.deleteCharAt(front.length() - 1);
                    back.deleteCharAt(0);
                }
            }
        }
    }
}

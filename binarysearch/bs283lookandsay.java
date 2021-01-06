package binarysearch;

public class bs283lookandsay {


    class Solution {
        public String solve(int n) {
            String res = "1";
            if(n <= 1){
                return res;
            }
            int cur = 1;
            while(cur != n){
                StringBuffer tmp = new StringBuffer();
                int r = 0;
                int l = 0;
                while(r < res.length()){
                    int count = 0;
                    l = r;
                    while(r < res.length() && res.charAt(r) == res.charAt(l)){
                        count++;
                        r++;
                    }
                    tmp.append(count);
                    tmp.append(res.charAt(l));
                }
                res = tmp.toString();
                cur++;
            }
            return res;
        }
    }
}

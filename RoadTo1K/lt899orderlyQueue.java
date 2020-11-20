package RoadTo1K;

import java.util.Arrays;

public class lt899orderlyQueue {

    class Solution {
        /*
        X[12345]
        如果k==1的话，那么我们只能rotate这个string
        如果K>=2的话，那么这个STRING的所有permutation的情况都能去构成了。
        为什么呢，因为我们保持第一位不懂，第二位去一直放到尾巴。这样就是X不动，[12345]在rotate，我们也可以用任意个数
        跟x替换了去塞，所以任何可能都能构成了。即所有permutation
        直接sort之后return，
        */
        public String orderlyQueue(String S, int K) {
            String res = S;
            if(K == 1){
                //rotate the string find smallest
                for(int i = 0; i < S.length(); i++){
                    String newstr = S.substring(i) + S.substring(0, i);
                    if(newstr.compareTo(res) < 0){
                        res = newstr;
                    }
                }
            }else{
                char[] cs = S.toCharArray();
                Arrays.sort(cs);
                res = new String(cs);
            }
            return res;
        }
    }
}

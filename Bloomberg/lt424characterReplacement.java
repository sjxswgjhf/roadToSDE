package Bloomberg;

import java.util.HashMap;

public class lt424characterReplacement {

    class Solution {
        /*
        sliding window:从左往右，如果左端的char跟右端不同，就消耗一次，k-1，当k=0，我们需要移动左端点
        难点：移动左端点怎么样去更新k
        如果我们知道每个char的count，那么我们去记录最大的char的count，那么通过idx就可以知道需要修改的次数，
        即r-l+1是现在的所有char的长度，我最多的那么char的count为5的话，剩下的r-l+1-count就是需要修改的次数，
        大于k的话就要移动左端点了。
        */
        public int characterReplacement(String s, int k) {
            int len = s.length();
            int l = 0, r = 0;
            int[] counts = new int[26];
            int maxCount = 0;
            int res = 0;
            while(r < s.length()){
                maxCount = Math.max(maxCount, ++counts[s.charAt(r) - 'A']);
                while(r - l + 1 - maxCount > k){
                    counts[s.charAt(l) - 'A']--;
                    l++;
                }
                //res每次移动都会更新，上面的while不会影响到res
                res = Math.max(res, r - l + 1 );
                r++;
            }
            return res;
        }
    }
}

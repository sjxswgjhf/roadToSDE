package RoadTo1K;

import java.util.HashSet;

public class lt1461hasAllCodes {

    class Solution {
        /*

        k = 2 => 4 cases
        k = 3 => 8 cases

        Naive approach TLE,  5 * 10^5
        O(NK)
        */
        public boolean hasAllCodes(String s, int k) {
            int l = 0;
            int r = 0;
            int n = s.length();
            HashSet<String> set = new HashSet<>();
            for(int i = 0; i < n - k + 1; i++){
                String str = s.substring(i, i + k);
                set.add(str);
                if(set.size() == (1<<k)){
                    return true;
                }
            }
            return set.size() == (1<<k);
        }
    }
}

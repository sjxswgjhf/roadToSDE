package goldmansachs;

import java.util.TreeSet;

public class lastSubstring {

    //https://leetcode.com/problems/last-substring-in-lexicographical-order/discuss/362387/JavaPython-3-Two-short-O(n)-codes-language%3A-2-pointers-and-encoding.
    //1163
    class SolutionDiscussion{
        public String lastSubstring(String s) {
            int i = 0, j = 1, offset = 0, len = s.length();
            while (i + offset < len && j + offset < len) {
                char c = s.charAt(i + offset), d = s.charAt(j + offset);
                if (c == d) {
                    ++offset;
                }else {
                    if (c < d)  { i += offset + 1; } // chars in [i, ..., i + offset] <= charAt(i) == charAt(j)
                    else { j += offset + 1; } // c > d, chars in [j, ..., j + offset] <= charAt(i) == charAt(j)
                    if (i == j) { ++j; } // avoid duplicate start indices.
                    offset = 0; // reset offset to 0.
                }
            }
            return s.substring(i);
        }
    }

    public String lastSubstring(String s) {
        TreeSet<Character> ts = new TreeSet<>();
        for (int i = 0; i < s.length(); ++i)
            ts.add(s.charAt(i));
        int radix = ts.size(), lo = 0;
        double max = 0d, cur = 0d;
        for (int i = s.length() - 1; i >= 0; --i) {
            cur = ts.headSet(s.charAt(i)).size() + cur / radix;
            if (max <= cur) {
                max = cur;
                lo = i;
            }
        }
        return s.substring(lo);
    }

    class Solution {
        //24/24 TLE
        public String lastSubstring(String s) {
            int n = s.length();
            String res = s;
            int[] counts = new int[26];
            //n
            for(int i= 0; i < s.length(); i++){
                counts[s.charAt(i) - 'a']++;
            }

            int idx = 0;
            for(int i = 25; i >= 0; i--){
                if(counts[i] == s.length()){
                    return s;
                }
                if(counts[i] != 0){
                    idx = i;
                    break;
                }
            }
            char target = (char)(idx+'a');
            //8 3
            for(int i = 0 ; i < s.length(); i++){
                if(s.charAt(i) == target){
                    String substr = s.substring(i);
                    if(substr.compareTo(res) > 0){
                        res = substr;
                    }
                }
            }
            return res;
        }
    }
}

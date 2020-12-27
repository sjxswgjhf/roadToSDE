package dailyProblem;

import java.util.HashMap;

public class lt395longestSubstring {

    class Solution {
        public int longestSubstring(String s, int k) {
            int res = 0;
            for(int m = 1; m <= 26; m++){
                res = Math.max(res, helper(s, k, m));
            }
            return res;
        }

        //substring要有m个字母，并且所有字母的频率大于k,即map.size() == m && count == m
        private int helper(String s, int k, int m){
            HashMap<Character, Integer> map = new HashMap<>();
            int res = 0;
            int count = 0;
            int l = 0;
            for(int r = 0; r < s.length(); r++){
                char c = s.charAt(r);
                if(map.size() < m || (map.size() == m && map.containsKey(c))){
                    map.put(c, map.getOrDefault(c, 0) + 1);
                    if(map.get(c) == k){
                        count++;
                    }
                    if(map.size() == m && count == m){
                        res = Math.max(res, r - l + 1);
                    }
                }else{
                    while(map.size() == m){
                        char old = s.charAt(l);
                        map.put(old, map.get(old) - 1);
                        if(map.get(old) == k - 1){
                            count--;
                        }
                        if(map.get(old) == 0){
                            map.remove(old);
                        }
                        l++;
                    }
                    map.put(c, 1);
                    if(map.get(c) == k){
                        count++;
                    }
                }
            }
            return res;
        }
    }


/*
我们移动右指针的时候，无法判断出当前进来的char是不是构成了k，或者说我们不知道什么时候能停下右指针，
所以我们加个限制，规定只能contain最多m个char，所以我们重复26次。从1~26
那么我们是不是可以precount所有的char的freq,如果遇到一个char的count是大于等于k的，
From wisdompeak:
本题其实确实有双指针的方法，但是比较特殊。那就是固定“滑窗里不同字母的个数”，这个数目m可以从1遍历到26。只要固定了左指针和区间不同字母的个数，那么我们就可以确定右指针最远的位置，然后查看区间内是否每个字母出现的频次都大于k。最后的答案就是遍历所有m时能够得到的最大滑窗长度。这种算法的时间复杂度是o(26N).
*/
}

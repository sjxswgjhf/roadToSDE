package dailyProblem;

import java.util.HashMap;

public class lt1371findTheLongestSubstring {
    class Solution {
        /*
        eleetminicoworoep
        用bit 表示aeiou的状态
        首先
        a e i o u
        0 0 0 0 0
        表示了偶数的状态
        如果是1的话就表示odd次
        那么相同的状态的话，如果想减，肯定都是even次数了
        0 1 0 0 1 - 0 1 0 0 1 = 0 0 0 0 0
        用这个思维，我们就可以做这道题目了
        我们还要用hashmap记录之前出现过这个状态的idx，这样之后出现了同样的状态我们就可以取得len了，
        注意的是这里的len是i+1~j的，不是i~j，还有个base case是0 0 0 0 0，如果从头开始到一个idx的所有vowels是event的话
        长度应该是0~j，即j+1，所以我们初始化map的时候，需要先放个(0, -1)进去，0指的是state的值，我们的state是0~31
        */
        public int findTheLongestSubstring(String s) {
            int n = s.length();
            int state = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            //如果全部是0的话表示到现在的vowels都是even times，所以是0~j，那么应该j+1的长度，所以设成-1
            map.put(0, -1);
            int res = 0;
            String vowels = "aeiou";
            for(int i = 0; i < s.length(); i++){
                for(int j = 0; j < 5; j++){
                    if(s.charAt(i) == vowels.charAt(j)){
                        state ^= 1 << j;    //对应的position做xor
                    }
                }
                if(map.containsKey(state)){
                    res = Math.max(res, i - map.get(state));    //这里要的是i+1~j的长度，因为这才是有效的candidate solution，所以不+1
                }else{
                    map.put(state, i);
                }
            }
            return res;
        }
    }

}

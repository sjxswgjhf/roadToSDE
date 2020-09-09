package microsoft;

import java.util.HashMap;

public class romanToInt {

    class Solution {
        /*
        Symbol       Value
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
        */

        HashMap<Character, Integer> hashmap = new HashMap<>();

        public int romanToInt(String s) {
            if(s == null || s.length() == 0){
                return 0;
            }
            hashmap.put('I', 1);
            hashmap.put('V', 5);
            hashmap.put('X', 10);
            hashmap.put('L', 50);
            hashmap.put('C', 100);
            hashmap.put('D', 500);
            hashmap.put('M', 1000);
            int ans = 0;
            if(s.length() == 1){
                return hashmap.get(s.charAt(0));
            }
            for(int i = 0; i < s.length() - 1; ){
                char cur = s.charAt(i);
                char next = s.charAt(i+1);
                if(check(cur, next)){
                    int val1 = hashmap.get(cur);
                    int val2 = hashmap.get(next);
                    ans += (val2 - val1);
                    i += 2;
                    if(i == s.length() - 1){
                        ans += hashmap.get(s.charAt(i));
                    }
                }else{
                    int val1 = hashmap.get(cur);
                    ans = ans + val1;
                    if(i == s.length() - 2){
                        ans += hashmap.get(s.charAt(i + 1));
                    }
                    i++;
                }
            }
            return ans;
        }

        private boolean check(char cur, char next){
            int val1 = hashmap.get(cur);
            int val2 = hashmap.get(next);
            if(val1 < val2){
                return true;
            }
            else{
                return false;
            }
        }
    }

}

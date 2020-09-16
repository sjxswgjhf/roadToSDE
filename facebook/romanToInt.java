package facebook;

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

        HashMap<Character, Integer> map = new HashMap<>();
        public int romanToInt(String s) {
            if(s == null || s.length() == 0){
                return 0;
            }
            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M', 1000);
            int n = s.length();
            int res = 0;
            if(n == 1){
                return map.get(s.charAt(0));
            }
            for(int i = 0; i < n - 1;){
                if(check(s.charAt(i), s.charAt(i + 1))){
                    res += map.get(s.charAt(i+1)) - map.get(s.charAt(i));
                    i+=2;
                }else{
                    res += map.get(s.charAt(i));
                    i++;
                }
                if(i == n - 1){
                    res += map.get(s.charAt(i));
                }
            }
            return res;
        }

        private boolean check(char c1, char c2){
            if(map.get(c1) < map.get(c2)){
                return true;
            }
            return false;
        }
    }

}

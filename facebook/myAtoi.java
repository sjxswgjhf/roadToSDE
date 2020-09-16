package facebook;

public class myAtoi {

    class Solution {
        public int myAtoi(String input) {
            String str = input.trim();
            if(str == null || str.length() == 0){
                return 0;
            }
            int sign = 1;
            int pointer = 0;
            int n = str.length();
            if(str.charAt(pointer) == '+' || str.charAt(pointer) == '-'){
                sign = str.charAt(pointer) == '-' ? -1 : 1;
                pointer++;
            }
            int res = 0;
            while(pointer < n){
                char c = str.charAt(pointer);
                if(Character.isDigit(c) && res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (c-'0') > Integer.MAX_VALUE % 10)){
                    return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                if(Character.isDigit(c)){
                    res = res * 10 + (c-'0');
                }else{
                    return res * sign;
                }
                pointer++;
            }
            return res*sign;
        }
    }

}

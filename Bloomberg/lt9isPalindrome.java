package Bloomberg;

public class lt9isPalindrome {

    class Solution {
        public boolean isPalindrome(int x) {
            if(x < 0){
                return false;
            }
            //edge case, it won't work for 10, 110...
            if(x != 0 && x % 10 == 0){
                return false;
            }
            int half = 0;
            //12321 => half = 123 x = 12
            while(x > half){
                half = half * 10 + x % 10;
                x /= 10;
            }
            return x == half || x == half / 10;
        }
    }
}

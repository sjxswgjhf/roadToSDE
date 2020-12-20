package BloombergOnsite;

public class lt9isPlaindrome {
    class Solution {
        public boolean isPalindrome(int x) {
            if(x < 0){
                return false;
            }
            if(x == 0){
                return true;
            }
            if(x % 10 == 0){
                return false;
            }
            int right = 0;
            int power = 0;
            while(x > right){
                right = right * 10 + x % 10;;
                x /= 10;
            }
            //右半边在odd length的时候会大于左半边
            return x == right || x == right / 10;
        }
    }
}

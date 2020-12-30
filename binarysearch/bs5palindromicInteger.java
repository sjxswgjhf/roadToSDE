package binarysearch;

public class bs5palindromicInteger {

    class Solution {
        public boolean solve(int num) {
            int right = 0;
            if(num == 0){
                return true;
            }
            if(num % 10 == 0 || num < 0){
                return false;
            }
            while(right < num){
                right = right * 10 + num % 10;
                num /= 10;
            }
            return right == num || right/10 == num;
        }
    }
}

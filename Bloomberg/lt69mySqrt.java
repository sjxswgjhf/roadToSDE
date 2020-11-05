package Bloomberg;

public class lt69mySqrt {

    class Solution {
        /*

        bianry search
        */
        public int mySqrt(int x) {
            if(x < 2){
                return x;
            }
            int l = 2;
            int r = x / 2;
            while(l <= r){
                int mid = l + (r - l) / 2;
                long product = mid * mid;
                if(product == x){
                    return mid;
                }
                else{
                    if(product > x){
                        r = mid - 1;
                    }else{
                        l = mid + 1;
                    }
                }
            }
            //错位的时候要返回小的那个，即r
            return r;
        }
    }
}

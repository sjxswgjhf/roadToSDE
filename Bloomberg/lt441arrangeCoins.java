package Bloomberg;

public class lt441arrangeCoins {

    class Solution {
        /*
        1+..+n = n * (n + 1) / 2

        */
        public int arrangeCoins(int n) {
            if(n == 0){
                return 0;
            }
            if(n == 1){
                return 1;
            }
            long l = 1;
            long r = n/2 + 1;
        /*
        0, 2,
        1 => 1 < n => l = mid
        */
            while(l < r){
                long mid = l + (r - l) / 2;
                long product = mid * (mid + 1) / 2;
                if(product <= n && n - product <= mid){
                    return (int)mid;
                }
                if(product > n){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
            return (int)l;
        }
    }
}

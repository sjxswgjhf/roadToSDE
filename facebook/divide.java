package facebook;

public class divide {

    class Solution {
        public int divide(int dividend, int divisor) {
            if(divisor == 0){
                return Integer.MAX_VALUE;
            }
            if(dividend == Integer.MIN_VALUE){
                if(divisor == -1){
                    return Integer.MAX_VALUE;
                }
                else if(divisor == 1){
                    return Integer.MIN_VALUE;
                }
            }
            long a = (long)(dividend);
            long b = (long)(divisor);
            //MIN = -2^31, MAX = 2^31 - 1
            a = Math.abs(a);
            b = Math.abs(b);
            int res = 0;
            while(a - b >= 0){            int shift = 0;
                while(a >= b << shift << 1){
                    shift++;
                }
                res += 1 << shift;
                a -= b << shift;
            }

            return (dividend > 0) == (divisor > 0) ? res : -res;
        }
    }
}

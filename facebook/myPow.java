package facebook;

public class myPow {

    class Solution {
        public double myPow(double x, int n) {
            double ans = 1;
            //这里因为有个int_min存在的关系，要用到long
            long N = n;
            //先处理power是负的情况
            if(N < 0){
                N = -N;
                x = 1/x;
            }
            double cur = x;
        /*
        一个是loop变量，一个是结果,
        当i是奇数的时候，我们要把loop变量乘结果，再去相乘
        2^7 = 2^ 4 * 2^3 = 16 * 4 * 2
        ans = 1, cur = 2, n = 7
        7%2 = 1 -> ans = ans * cur = 2, cur = cur * cur = 4
        3%2 = 1 -> ans = ans * cur = 8, cur = cur * cur = 16
        1%2 = 1 -> ans = ans * cur = 128, cur = cur * cur = 256
        return ans

        ans = 1, cur = 2, n = 8
        8 % 2 = 0 -> ans = 1 cur = cur * cur = 4;
        4 % 2 = 0 -> ans = 1 cur = cur * cur = 16;
        2 % 2 = 0 -> ans = 1 cur = cur * cur = 256;
        1 % 2 = 0 -> ans = ans * cur = 1 * 256 = 256, cur = cur * cur
        return ans

        */
            for(long i = N; i > 0; i /= 2){
                if(i%2 == 1){
                    ans = ans * cur;
                }
                cur = cur * cur;
            }
            return ans;
        }
    }
}

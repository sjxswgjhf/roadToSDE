package RoadTo1K;

public class lt1175numPrimeArrangements {

    class Solution {
        /*
        1~n,重新排列每个数，只要pn在pn的位置上
        即1~n有多少个prime number，把这些prime number放到prime idx放，剩下的放别的idx有多少中放法

        1 2 3 4 5 6 7 8 9
          * *   *   *
        即m个pn有m!个方法，不是pn的有n-m个，有(n-m)!的放法
        m ! * (m-n)!
        */
        int mod = (int)1e9+7;
        public int numPrimeArrangements(int n) {
            int count = 0;
            for(int i = 2; i <= n; i++){
                boolean isprime = true;
                for(int j = 2; j * j <= i; j++){
                    if(i % j == 0){
                        isprime = false;
                        break;
                    }
                }
                if(isprime){
                    count++;
                }
            }
            return (int)(factorial(count) * factorial(n - count) % mod);
        }

        private long factorial(int x){
            long res = 1;
            for(int i = 1; i <= x; i++){
                res = (res * i) % mod;
            }
            return res;
        }

    }

    /*
    随机到了第二遍
     */
    class SolutionSecond {
        /*
        N numbers:

        x prime, y not prime = x!*y!

        */
        int mod = (int)1e9 + 7;
        public int numPrimeArrangements(int n) {
            int primes = countPrimes(n);
            return (int)(fac(primes) * fac(n - primes) % mod);
        }

        private long fac(int n){
            long res = 1;
            while(n >= 2){
                res = (res * n) % mod;
                n--;
            }
            return (res % mod);
        }

        private int countPrimes(int n){
            int count = 0;  //include 1
            for(int i = 2; i <= n; i++){
                if(isPrime(i)){
                    count++;
                }
            }
            return count;
        }

        private boolean isPrime(int num){
            for(int i = 2; i * i <= num; i++){
                if(num % i == 0){
                    return false;
                }
            }
            return true;
        }
    }
}

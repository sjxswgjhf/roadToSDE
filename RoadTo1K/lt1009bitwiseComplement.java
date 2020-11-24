package RoadTo1K;

public class lt1009bitwiseComplement {

    class Solution {
        /*
        我们的目的是保留0去掉1，那么我们可以做xor，
        我们知道当前N的长度，我们一堆同样长度的1，然后做xor就可以保留所有的0
        */
        public int bitwiseComplement(int N) {
            if(N == 0){
                return 1;
            }
            int len = 0;
            int cur = N;
            while(cur > 0){
                len++;
                cur = cur >> 1;
            }
        /*
        1 << 3 = 1000 - 1 = 0111
        */
            int bitmask = (1 << len) - 1;
            return bitmask^N;
        }
    }
}

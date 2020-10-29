package Bloomberg;

public class lt172trailingZeroes {

    class Solution {
        /*

        数5的倍数有几个。。如果是5的平方那就算两个，3次方算3个。。

        */
        public int trailingZeroes(int n) {

            int zeroCount = 0;
            for (int i = 5; i <= n; i += 5) {
                int currentFactor = i;
                while (currentFactor % 5 == 0) {
                    zeroCount++;
                    currentFactor /= 5;
                }
            }
            return zeroCount;
        }
    }

}

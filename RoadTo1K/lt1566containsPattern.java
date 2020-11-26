package RoadTo1K;

import java.util.LinkedList;

public class lt1566containsPattern {

    class Solution {
        /*
        m * k 表示了我们需要m*k个总共的值相同

        */
        public boolean containsPattern(int[] arr, int m, int k) {
            int count = 0;
            for (int i = 0; i + m < arr.length; i++) {
                count = arr[i] == arr[i + m] ? count + 1 : 0;
                if (count == (k - 1) * m)
                    return true;
            }
            return false;
        }
    }
}

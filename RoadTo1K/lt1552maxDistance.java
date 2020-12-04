package RoadTo1K;

import java.util.Arrays;

public class lt1552maxDistance {

    class Solution {
        /*
        n baskest, m balls, force = |i-j|
        target:使得最小的force最大
        1 2 3 4 7
        m = 3

        1 2 3 4 7
        greedy

        首先是sort之后首尾放两个，
        然后就是找中间点binary search放，
        1 3 4 100 150 200
        m = 4
        1 100 150 2000
        这样的binary search很难做到。
        那我们换个思路，我们猜最小的最大的值，然后看能不能实现
        猜了一个数表示间距k，我们先放第一个，然后往后找最少为k的basket
        */
        public int maxDistance(int[] position, int m) {
            Arrays.sort(position);
            int n = position.length;
            //最小最大间距
            int left = 1, right = position[n-1]-position[0];

            while(left < right){
            /*
            int mid = left + (right - left ) / 2;
            会造成循环，left = 0， right = 1
            left = mid = 0

            mid = right - （right - left）/ 2
            left = 0 , right = 1
            left = mid = 1
            */
                int mid = right - (right - left ) / 2;
                if(isOK(mid, position, m)){
                    left = mid;
                }else{
                    right = mid - 1;
                }
            }

            return left;
        }

        private boolean isOK(int k, int[] position, int m){
            int count = 1;
            for(int i = 0; i < position.length;){
                int j = i;
                while(j < position.length && position[j] - position[i] < k){
                    j++;
                }
                //越界了，没找到
                if(j == position.length){
                    return false;
                }
                else{
                    //找到了，然后记得把i更新到j的位置，继续往后找
                    count++;
                    i = j;
                    if(count == m){
                        return true;
                    }
                }
            }
            return false;
        }
    }
}

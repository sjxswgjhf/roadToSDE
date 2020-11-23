package RoadTo1K;

import java.util.Arrays;
import java.util.List;

public class lt315countSmaller {

    class Solution {
        /*

        divide and conquer:

        A: [Y Y Y Y Y X X X X X]
        B: [Y Y Y Y Y]  C: [X X X X X]
        如果求得了B跟C的smaller number after self，当apply A的时候，C部分已经解决，但是B部分来说，还要到C去看有多少个比他小
        那么如果Z返回的时候排序好了，B就可以用更少的时间完成搜索
        所以这个方法叫分治归并排序


        */
        public List<Integer> countSmaller(int[] nums) {
            int n = nums.length;
            return null;
        }
    }
}

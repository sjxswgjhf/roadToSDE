package dailyProblem;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;

public class lt1499findMaxValueOfEquation {
    class Solution {
        /*
        deque,但是这题有个问题是x会影响到最终的比较值，不能单纯的pop last什么的，
        要转换下
        Because xi < xj,
        yi + yj + |xi - xj| = (yi - xi) + (yj + xj)

        So for each pair of (xj, yj),
        we have xj + yj, and we only need to find out the maximum yi - xi.
        */
        public int findMaxValueOfEquation(int[][] points, int k) {
            Deque<Pair<Integer, Integer>> ms = new ArrayDeque<>();
            int res = Integer.MIN_VALUE;
            for (int[] point : points) {
                while (!ms.isEmpty() && point[0] - ms.peekFirst().getValue() > k) {
                    ms.pollFirst();
                }
                if (!ms.isEmpty()) {
                    res = Math.max(res, ms.peekFirst().getKey() + point[0] + point[1]);
                }
                while (!ms.isEmpty() && point[1] - point[0] > ms.peekLast().getKey()) {
                    ms.pollLast();
                }
                ms.offerLast(new Pair<>(point[1] - point[0], point[0]));
            }
            return res;
        }
    }

}

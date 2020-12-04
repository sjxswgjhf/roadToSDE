package RoadTo1K;

import java.util.ArrayList;
import java.util.List;

public class lt1569numOfWays {

    class Solution {

        /*
        当root固定后，左右子树的长度可以确定，
        可以确定的是左为3右为2的时候，我们可以选完左子树的位置，右子树的位置就固定了。所以是C(5,3),
        但是我们还要想到当左子树里面还可以修改位置，当左子树的root固定，左右tree可以修改位置，不会影响结果，这个是跟上一层一个意思
        C(2,1)=2,所以最后就是C(5,3)*C(2,1)*C(1，1) = 20
        这题另一个问题是java没有comb的buildin，我们需要用Pascal Triangle来做，即C(5,3)=triangle[4][2]
        */
        private static final long MOD = 1000000007;
        public int numOfWays(int[] nums) {
            int len = nums.length;
            List<Integer> arr = new ArrayList<>();
            for (int n : nums) {
                arr.add(n);
            }
            return (int)getCombs(arr, getTriangle(len + 1)) - 1;
        }

        private long getCombs(List<Integer> nums, long[][] combs) {
            if (nums.size() <= 2) {
                return 1;
            }
            int root = nums.get(0);
            List<Integer> left = new ArrayList<>();
            List<Integer> right = new ArrayList<>();
            for (int n : nums) {
                if (n < root) {
                    left.add(n);
                } else if (n > root) {
                    right.add(n);
                }
            }
            // mod every number to avoid overflow
            return (combs[left.size() + right.size()][left.size()] * (getCombs(left, combs) % MOD) % MOD) * getCombs(right, combs) % MOD;
        }

        private long[][] getTriangle(int n) {
            // Yang Hui (Pascle) triangle
            // 4C2 = triangle[4][2] = 6
            long[][] triangle = new long[n][n];
            for (int i = 0; i < n; i++) {
                triangle[i][0] = triangle[i][i] = 1;
            }
            for (int i = 2; i < n; i++) {
                for (int j = 1; j < i; j++) {
                    triangle[i][j] = (triangle[i - 1][j] + triangle[i - 1][j - 1]) % MOD;
                }
            }
            return triangle;
        }
    }
}

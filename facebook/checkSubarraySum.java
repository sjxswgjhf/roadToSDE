package facebook;

import java.util.HashMap;

public class checkSubarraySum {

    class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return false;
            }
            /*
            HashMap: key:
            key是被k除的余数，value：是idx
            如果两个数被k除的余数相同的话,那么他们的差值就是k的倍数
            3 % 2 = 1
            5 % 2 = 1
            7 % 2 = 1
            7 - 3 = 4 % 2 = 0
            5 - 3 = 2 % 2 = 0
             */
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);     // 0是特殊情况，-1是为了保证我们的size 至少为2
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (k != 0) {
                    sum = sum % k;
                }
                if (map.containsKey(sum)) {
                    if (i - map.get(sum) >= 2) {
                        return true;
                    }
                } else {
                    map.put(sum, i);
                }
            }
            return false;
        }
    }

    /*
    corner case恶心任，要注意k是0的时候，而且subarray长度要大于等于2
     */
    class SolutionDP {
        public boolean checkSubarraySum(int[] nums, int k) {
            int n = nums.length;
            int[] sums = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                sums[i] = sums[i - 1] + nums[i - 1];
                for (int j = 0; j < i; j++) {
                    int tmp = sums[i] - sums[j];
                    if (i - j >= 2) {
                        if (tmp == k || (k != 0 && tmp % k == 0)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }
}

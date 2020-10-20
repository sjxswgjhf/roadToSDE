package Bloomberg;

public class lt1060missingElement {

    class SolutionBS {
        /*
        binary search:
        因为是sort的，如果我知道了两个idx跟值，那么我就计算出中间少了几个
        edge case是k缺失的不在array范围里面
        */
        public int missingElement(int[] nums, int k) {
            int n = nums.length;
            int l = 0;
            int h = n - 1;
            int missingNum = nums[n - 1] - nums[0] + 1 - n;

            if (missingNum < k) {
                return nums[n - 1] + k - missingNum;
            }

            while (l < h - 1) {
                int m = l + (h - l) / 2;
                int missing = nums[m] - nums[l] - (m - l);

                if (missing >= k) {
                    // when the number is larger than k, then the index won't be located in (m, h]
                    h = m;
                } else {
                    // when the number is smaller than k, then the index won't be located in [l, m), update k -= missing
                    k -= missing;
                    l = m;
                }
            }

            return nums[l] + k;
        }



    }

    class Solution {
        public int missingElement(int[] nums, int k) {
            int idx = 0;
            int res = nums[0];
            while(idx + 1 < nums.length){
                int dif = nums[idx + 1] - nums[idx];
                if(dif != 1){
                    if(dif - 1 >= k){
                        return res + k;
                    }else{
                        k -= (dif - 1);
                    }
                }
                idx++;
                res = nums[idx];
            }
            if(k != 0){
                res = nums[nums.length - 1] + k;
            }
            return res;
        }
    }
}

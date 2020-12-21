package dailyProblem;

public class lt1658minOperations {
    class Solution {
        /*
        这题看着像dp，其实是sliding window，
        我们要找前后的可以让x变成0的，这样很难想，选了前面那么下一步不work了怎么办，选了后面又怎么办，
        所以转换下思路，我们就是要找一段sum-x的subarray，存在的话我们就能做到x=0，反正不能，那么就变成了
        sliding window了

        每次移动右端点，如果遇到了当前累计值大于target的情况，我们就移动左端点，直到累计值小于等于target，如果累计值等于target，我们
        计算长度
        */
        public int minOperations(int[] nums, int x) {
            int sum = 0;
            for(int num : nums){
                sum += num;
            }
            int n = nums.length;
            int l = 0;
            int target = sum - x;
            int tmp = 0;
            int res = n + 1;

            if(x > sum){
                return -1;
            }
            for(int r = 0; r < n; r++){
                tmp += nums[r];
                while(l <= r && tmp > target){
                    tmp -= nums[l];
                    l++;
                }
                if(tmp == target){
                    res = Math.min(res, n - (r - l + 1));
                }
            }
            return res == n + 1 ? -1 : res;
        }
    }
}

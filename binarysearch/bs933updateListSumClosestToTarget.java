package binarysearch;

public class bs933updateListSumClosestToTarget {

    /*
    这题转换下思路如果我能找到一个e是的sum是最近于target的，那么result肯定就在e跟e-1之间了。
    然后这个题没什么适合的构思，那么找一个target就想到了binary search，
     */

    class Solution {
        public int solve(int[] nums, int target) {
            int l = 0;
            int r = target;
            int max = nums[0];
            int tmp = 0;
            for(int num : nums){
                tmp += num;
                max = Math.max(max, num);
            }
            if(tmp <= target){
                return max;
            }
            //while 找一个大于target的num
            while(l < r){
                int mid = (l + r) / 2;
                int sum = getSum(mid, nums);
                if(sum == target){
                    return mid;
                }
                else if(sum > target){
                    //为什么不是r-1，因为r可能是一个possible solution
                    r = mid;
                }else{
                    l = mid + 1;
                }
            }
            int sum1 = getSum(l, nums);
            int sum2 = getSum(l - 1, nums);
            if(Math.abs(target - sum1) >= Math.abs(target - sum2)){
                return l-1;
            }else{
                return l;
            }
        }

        private int getSum(int e, int[] nums){
            int sum = 0;
            for(int num : nums){
                if(num > e){
                    sum += e;
                }else{
                    sum += num;
                }
            }
            return sum;
        }
    }
}

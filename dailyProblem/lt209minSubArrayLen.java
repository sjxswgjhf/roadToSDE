package dailyProblem;

public class lt209minSubArrayLen {

    class Solution {
    /*
    滚动两个pointer，当window里面的sum不够的时候，移动右边，够了就开始缩减到最小的window
    */

        public int minSubArrayLen(int s, int[] nums) {
            int l = 0, r = 0;
            int sum = 0;
            int min = nums.length + 1;
            while(r < nums.length){
                while(r < nums.length && sum < s){
                    sum += nums[r];
                    r++;
                }
                while(l <= r && sum >= s){
                    //这里为什么是r-l，因为我们的r已经是越界了的, 1 4 4的时候，r第一次停止已经是第二个4了，不是第一个4
                    min = Math.min(min, r - l);
                    sum -= nums[l];
                    l++;
                }
            }
            return min == nums.length + 1 ? 0 : min;
        }
    }

    class SolutionBad {
        /*
      0 1 2 3 4 5 6
        2 3 1 2 4 3
      0 2 5 6 8 12 15
        */
        public int minSubArrayLen(int s, int[] nums) {
            int n = nums.length;
            int[] prefix = new int[n + 1];
            for(int i = 1; i <= n; i++){
                prefix[i] = prefix[i-1] + nums[i-1];
            }
            if(prefix[n] < s){
                return 0;
            }
            int min = n;
            for(int i = 0; i <= n; i++){
                if(prefix[i] < s){
                    continue;
                }else{
                    int j = i - 1;
                    while(j >= 0 && (i - j) < min){
                        if(prefix[i] - prefix[j] >= s){
                            min = Math.min(min, i - j);
                            break;
                        }
                        else{
                            j--;
                        }
                    }
                }
            }
            return min;
        }
    }
}

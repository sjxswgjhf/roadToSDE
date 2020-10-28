package Bloomberg;

public class lt283moveZeros {

    /*
    [0,1,0,3,12]
    [1,2,0,0,3,12]
    每次当r不是0就swap，这样不会被一开始是不是0所影响，一开始不是0就swap，一起increase，等于没有swap
    */

    class Solution {
        public void moveZeroes(int[] nums) {
            int l = 0;
            int r = 0;
            while(r < nums.length){
                if(nums[r] != 0){
                    int tmp = nums[l];
                    nums[l] = nums[r];
                    nums[r] = tmp;
                    l++;
                }
                r++;
            }
        }
    }
}

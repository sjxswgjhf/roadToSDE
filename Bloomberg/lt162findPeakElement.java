package Bloomberg;

public class lt162findPeakElement {

    class Solution {
        /*
        0 1 2 3 4 5 6
        1 2 1 3 5 6 4


        什么是peak。 num[mid] > num[mid + 1]
        mid = 3 num[3] > num[4] ? false => l = 3 + 1 = 4
        r = 6, l = 4
        mid = 5 num[5] > num[6] ? true => r = mid since this idx is a potiential solution
        r = 5, l = 4
        mid = 4, num[4] > num[5] ? false => l = mid + 1
        l = 5, r = 5 停止
        首先整个逻辑是判断当前的mid是不是可能的peak，是的话，我们保留它，即r=mid，我们继续往前找找，因为我们看的是num[mid] > nums[mid+1],这说明当前是的decreasing，peak会在前面
        如果num[mid] < nums[mid+1]的话，我们l = mid +1，这里是mid+1不是mid，因为我们知道了这个mid不可能是potiential solution，那么自然要移除掉
        */
        public int findPeakElement(int[] nums) {
            int l = 0;
            int r = nums.length - 1;
            while(l < r){
                int mid = l + (r - l) / 2;
                if(nums[mid] > nums[mid + 1]){
                    r = mid;
                }else{
                    l = mid + 1;
                }
            }
            return l;
        }
    }
}

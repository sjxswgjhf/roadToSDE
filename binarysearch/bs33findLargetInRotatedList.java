package binarysearch;

public class bs33findLargetInRotatedList {

    class Solution {
        public int solve(int[] arr) {
            int n = arr.length;
            int l = 0;
            int r = n - 1;
            while(l < r){
                int mid = l + (r-l)/2;
                // find the decreasing point
                if(arr[mid] > arr[mid + 1]){
                    return arr[mid];
                }
                // 如果mid比左边大，但是mid又比小一位小，说明mid不是最大的
                else if(arr[mid] > arr[l]){
                    l = mid + 1;
                }else{
                    // mid小于等于左边，那么mid可能是2，0这种极端情况，r移动到mid，但是不能到mid左边
                    // 因为mid可能是最大的而且在最左边
                    r = mid;
                }
            }
            return arr[n - 1];
        }
    }
}

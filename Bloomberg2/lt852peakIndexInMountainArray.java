package Bloomberg2;

public class lt852peakIndexInMountainArray {
    class Solution {
        public int peakIndexInMountainArray(int[] arr) {
            int l = 0;
            int r = arr.length - 1;
            int peak = 0;
            while(l < r){
                int mid = (l + r) /2;
                //这样有效避免了mid-1超界的情况
                if(arr[mid] < arr[mid + 1]){
                    l = peak = mid + 1;
                }else{
                    r = mid;
                }
            }
            return peak;
        }
    }
}

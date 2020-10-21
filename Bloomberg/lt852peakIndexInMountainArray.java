package Bloomberg;

public class lt852peakIndexInMountainArray {

    class Solution {
        /*
        basic: 我们就是要找到第一个decrease的点
        3 5 3 2 0
        mid = 2
        l = 0 r = 1
        mid = 1
        */
        public int peakIndexInMountainArray(int[] arr) {
            int l = 0;
            int r = arr.length - 1;
            int peak = 0;
            while(l < r){
                int mid = (r + l) / 2;
                if(arr[mid] > arr[mid - 1]){
                    l = peak = mid + 1;
                }else{
                    r = mid;
                }
            }
            return peak - 1;
        }
    }
}

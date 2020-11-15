package Bloomberg2;

public class lt1095findInMountainArray {

    /**
     * // This is MountainArray's API interface.
     * // You should not implement it, or speculate about its implementation
     * interface MountainArray {
     *     public int get(int index) {}
     *     public int length() {}
     * }
     */

    interface MountainArray {
        public int get(int index);
        public int length();
    }
/*
首先这个题目里只有一个peak，那么我们找到这个peak后就可以分开前后，根据bs的特性去找target了
*/
    class Solution {
        public int findInMountainArray(int target, MountainArray mountainArr) {
            int len = mountainArr.length();
            int l = 0;
            int r = len - 1;
            int peak = 0;
            //find peak
            while(l < r){
                int mid = l + (r - l) / 2;
                if(mid == 0){
                    break;
                }
                //still increasing
                if(mountainArr.get(mid - 1) < mountainArr.get(mid)){
                    l = mid + 1;
                    peak = mid + 1;
                }else{
                    r = mid;
                }
            }
            System.out.println(peak);
            //try to find target in left part
            l = 0;
            r = peak - 1;
            while(l <= r){
                int mid = l + (r-l)/2;
                if(mountainArr.get(mid) == target){
                    return mid;
                }
                else if(mountainArr.get(mid) > target){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
            //左边没找到，找右边
            l = peak;
            r = len - 1;
            while(l <= r){
                int mid = l + (r - l) / 2;
                if(mountainArr.get(mid) == target){
                    return mid;
                }
                else if(mountainArr.get(mid) < target){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
            return -1;
        }
    }
}

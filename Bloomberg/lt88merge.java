package Bloomberg;

public class lt88merge {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int l = m - 1, r = n - 1;
            int idx = m + n - 1;
            while(l >= 0 && r >= 0){
                if(nums1[l] > nums2[r]){
                    nums1[idx] = nums1[l];
                    idx--;
                    l--;
                }
                else{
                    nums1[idx] = nums2[r];
                    idx--;
                    r--;
                }
            }
            idx = 0;
            while(idx <= r){
                nums1[idx] = nums2[idx];
                idx++;
            }
        }
    }
}

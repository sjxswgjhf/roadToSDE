package Bloomberg;

public class mergeTwoSortArray {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int l = m - 1, r = n - 1, end = m + n - 1;
            while(l >= 0 && r >= 0){
                if(nums1[l] > nums2[r]){
                    nums1[end--] = nums1[l--];
                }
                else if(nums1[l] <= nums2[r]){
                    nums1[end--] = nums2[r--];
                }
            }
            int idx = 0;
            while(idx <= r){
                nums1[idx] = nums2[idx];
                idx++;
            }

        }
    }
}

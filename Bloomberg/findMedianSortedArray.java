package Bloomberg;

public class findMedianSortedArray {

    /*
    找median的话，我们需要第k个元素，即nums1用了第m1个,nums2用了第m2个
    先定义k的idx，可以取高位也可以取低位，
    然后定义nums1的startIdx, num2的startIdx
    l = 0, r = len(num1),
    然后binary search，先用num1里面的x个元素，那么num2里面就要用k - x个，
    然后比较num1[x]跟num2[k-x],如果num1小，那么我们移动l到mid +1，说明num1要用更多的，反之移动r = mid.
    最后我们要取数的时候，这时候虽然我们有了m1=l，m2=k-l的idx的值，但是我们只知道要用这些
    odd的时候，我们只要看nums1里面的大，还是nums2里面的大，
    even的时候，我们还要看后一位的两个数，取小的那个
     */

    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len1 = nums1.length;
            int len2 = nums2.length;
            int sum = len1 + len2;
            if(len1 > len2){
                return findMedianSortedArrays(nums2, nums1);
            }
            int k = (len1 + len2 + 1) / 2;
            int l = 0;      //num1 startIdx
            int r = len1;   //num2 startIdx
            while(l < r){
                int m1 = l + (r - l ) / 2;
                int m2 = k - m1;
                if(nums1[m1] < nums2[m2 - 1]){
                    l = m1 + 1;
                }else{
                    r = m1;
                }
            }
            int m1 = l;
            int m2 = k - l;
            int c1 = Math.max(m1 <= 0 ? Integer.MIN_VALUE : nums1[m1 - 1], m2 <= 0 ? Integer.MIN_VALUE : nums2[m2 - 1]);
            if(sum % 2 == 1){
                return c1;
            }
            int c2 = Math.min(m1 >= len1 ? Integer.MAX_VALUE : nums1[m1], m2 >= len2 ? Integer.MAX_VALUE : nums2[m2]);
            return (c1 + c2) * 0.5;
        }
    }
}

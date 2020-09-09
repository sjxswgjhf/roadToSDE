package microsoft;

public class findMedianSortedArrays {

    public class findMedianSortedArray4 {


    /*
    binary search: O(log(min(n1,n2))
    因为最终构成的合并数组中，一定满足 max(num1[m1-1],num2[m2-1]) <= min(num1[m1],num2[m2])
    （意思是在num1中取出m1个数+num2中取出m2个数组成的最终数组的左半部分，他们的最大值小于等于最终数组右半数组的最小值）
    ，因此如果出现num1[m1]>num2[m2-1]则不满足这样的情况，因此需要挑战m1的选择，下标要往小了选，对应的sorted数组值就会变小。
     二分搜索的操作方式就是，减少右边界的值。
     */

        public double findMedianSortedArraysBS(int[] nums1, int[] nums2) {
            int len1 = nums1.length;
            int len2 = nums2.length;
            int sum = len1 + len2;
            if(len1 > len2){
                return findMedianSortedArraysBS(nums2, nums1);
            }
            int k = (len1 + len2 + 1) / 2;
            int l = 0;
            int r = len1;
            while(l < r){
                int m1 = l + (r-l) / 2;
                int m2 = k - m1;
                if(nums1[m1] < nums2[m2 - 1]){
                    l = m1 + 1;
                }else{
                    r = m1;
                }
            }
            int m1 = l;
            int m2 = k - l;
            int c1 = Math.max( m1 <= 0 ? Integer.MIN_VALUE : nums1[m1 - 1], m2 <= 0 ? Integer.MIN_VALUE : nums2[m2 - 1]);
            if(sum % 2 == 1){
                return c1;
            }
            int c2 = Math.min( m1 >= len1 ? Integer.MAX_VALUE : nums1[m1], m2 >= len2 ? Integer.MAX_VALUE : nums2[m2]);
            return (c1 + c2) * 0.5;
        }

    /*
    combine two array by two pointer : O(m+n)
     */


        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len1=nums1.length;
            int len2=nums2.length;
            int[] nums=new int[len1+len2];
            combine(nums,nums1, nums2);
            int sum=len1+len2;
            double res=0;
            if(sum%2==0){
                res=(nums[sum/2]+nums[sum/2-1])/2.0;
            }else{
                res=nums[sum/2];
            }
            return res;
        }

        private int[] combine(int[] nums, int[] nums1, int[] nums2){
            for(int i=0, j=0, offset=0; i<nums1.length || j<nums2.length;){
                if(i==nums1.length){
                    //i readch end
                    nums[offset++]=nums2[j++];
                }
                else if(j==nums2.length){        //j reach end
                    nums[offset++]=nums1[i++];
                }else{          //i,j in range
                    if(nums1[i]<=nums2[j]){
                        nums[offset++]=nums1[i++];
                    }else{
                        nums[offset++]=nums2[j++];
                    }
                }
            }
            return nums;
        }
    }

}

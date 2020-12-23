package BloombergOnsite;

import java.util.Arrays;

public class lt1300findBestValue {

    class Solution1 {
        public int findBestValue(int[] arr, int target) {
            int sum = 0;
            int max = arr[0];
            int n = arr.length;
            for(int a : arr){
                sum += a;
                max = Math.max(a, max);
            }
            if(sum <= target){
                return max;
            }
            int l = 0;
            int r = 100000;
            // int candidate = 0;
            while(l < r){
                int mid = l + (r - l) / 2;
                int midSum = checkSum(arr, mid);
                if(midSum == target){
                    return mid;
                }
                else if(midSum < target){
                    // candidate = mid;
                    l = mid + 1;
                }
                else{
                    r = mid;
                }
            }
            int sum1 = checkSum(arr, l);
            int sum2 = checkSum(arr, l - 1);
            if(Math.abs(sum1 - target) < Math.abs(sum2 - target)){
                return l;
            }else{
                return l-1;
            }

        }

        private int checkSum(int[] arr, int limit){
            int sum = 0;
            for(int n : arr){
                if(n > limit){
                    sum += limit;
                }else{
                    sum += n;
                }
            }
            return sum;
        }
    }

    class SolutionLee{
        public int findBestValue(int[] A, int target) {
            Arrays.sort(A);
            int n = A.length, i = 0;
            while (i < n && target > A[i] * (n - i)) {
                target -= A[i++];
            }
            if (i == n) return A[n - 1];
            int res = target / (n - i);
            if (target - res * (n - i) > (res + 1) * (n - i) - target)
                res++;
            return res;
        }
    }

}

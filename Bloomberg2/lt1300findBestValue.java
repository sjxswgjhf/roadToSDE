package Bloomberg2;

public class lt1300findBestValue {

    class Solution {

    /*
    2分搜索threshold value，然后看用这个值构建的sum，跟target的大小，大的话，移动r，小的话移动l，但是我们移动的时候要注意保留一端
    保留左端的话，就是最后的value的sum小于target，我们要再看+1的值的sum，做比较
    保留右端的话，最后的value的sum大于target，我们再看-1值的sum
    */

        public int findBestValue(int[] arr, int target) {
            int sum = 0;
            int max = 0;
            for(int i : arr){
                sum += i;
                max = Math.max(max, i);
            }
            if(sum <= target){
                return max;
            }
            int l = 0;
            int r = 100000;
            while(l < r){
                int mid = l + (r - l) / 2;
                int midsum = checkSum(mid, arr);
                if(midsum == target){
                    return mid;
                }
                else if(midsum > target){
                    r = mid;
                }else{
                    l = mid + 1;
                }
            }

            int sum1 = checkSum(l, arr);
            int sum2 = checkSum(l - 1, arr);
            //等差情况下，返回小的那个
            if(Math.abs(sum1 - target) < Math.abs(sum2 - target)){
                return l;
            }else{
                return l - 1;
            }

        }

        private int checkSum(int v, int[] arr){
            int sum = 0;
            for(int i = 0; i < arr.length; i++){
                if(arr[i] > v){
                    sum += v;
                }else{
                    sum += arr[i];
                }
            }
            return sum;
        }
    }
}

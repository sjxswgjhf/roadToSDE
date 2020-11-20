package RoadTo1K;

public class lt1228missingNumber {

    /*
    有个坑就是dif是0的情况，
    dif是负数的时候稍微要注意下
     */
    class Solution {
        public int missingNumber(int[] arr) {
            int dif1 = arr[1] - arr[0];
            int dif2 = arr[2] - arr[1];
            if(dif1 != dif2){
                if(Math.abs(dif1) > Math.abs(dif2)){
                    return arr[0] + dif2;
                }else{
                    return arr[1] + dif1;
                }
            }
            for(int i = 3; i < arr.length; i++){
                if(arr[i] - arr[i-1] != dif1){
                    return arr[i-1] + dif1;
                }
            }
            return arr[0];
        }
    }
}

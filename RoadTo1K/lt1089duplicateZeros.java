package RoadTo1K;

public class lt1089duplicateZeros {
    /*
    这个one pass的太难了
     */
    class Solution {
        public void duplicateZeros(int[] arr) {
            if(arr.length == 1){
                return;
            }
            int countZero = 0;
            for(int i : arr){
                if(i == 0){
                    countZero++;
                }
            }
            int paddingSize = countZero + arr.length;
            for(int i = arr.length-1, j = paddingSize - 1; i < j; i--, j--){
                if(arr[i] != 0){
                    if(j < arr.length){
                        arr[j] = arr[i];
                    }
                }else{
                    if(j < arr.length){
                        arr[j] = 0;
                    }
                    j--;
                    if(j < arr.length){
                        arr[j] = 0;
                    }
                }
            }
        }
    }

    class SolutionNN {
        public void duplicateZeros(int[] arr) {
            int n = arr.length;
            for(int i = 0; i < n - 1; i++){
                if(arr[i] == 0){
                    for(int j = n - 1; j > i + 1; j--){
                        arr[j] = arr[j-1];
                    }
                    if(i < n - 1)
                        arr[i + 1] = 0;
                    i++;
                }
            }
        }
    }
}

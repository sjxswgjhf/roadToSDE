package goldmansachs;

import java.util.Arrays;

public class MeanderingArray {

    public int[] rearrangeArray(int[] arr, int n){
        Arrays.sort(arr);
        int[] res = new int[n];
        int idx = 0;
        for(int l = 0, r = n - 1; l < r;){
            res[idx++] = arr[l++];
            res[idx++] = arr[r--];
        }
        return res;
    }
}

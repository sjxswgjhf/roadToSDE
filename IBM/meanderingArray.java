package IBM;

import java.util.Arrays;

public class meanderingArray {

    public static int[] meanderingArray(int[] input){
        Arrays.sort(input);
        int[] res = new int[input.length];
        int l = 0, r = input.length - 1;
        int idx = 0;
        while(l <= r){
            res[idx++] = input[r--];
            if(idx == input.length){
                break;
            }
            res[idx++] = input[l++];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = {-1, 1, 2, 3, -5};
        int[] res = meanderingArray(input);
        for(int n : res){
            System.out.print(n + " ");
        }
    }
}

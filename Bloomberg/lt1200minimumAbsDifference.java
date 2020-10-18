package Bloomberg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lt1200minimumAbsDifference {

    class Solution {
        public List<List<Integer>> minimumAbsDifference(int[] arr) {
            Arrays.sort(arr);
            int minDif = Integer.MAX_VALUE;
            for(int i = 1; i < arr.length; i++){
                minDif = Math.min(minDif, arr[i] - arr[i - 1]);
            }
            int l = 0, r = 1;
            System.out.println(minDif);
            List<List<Integer>> res = new ArrayList<>();
            while(r < arr.length){
                int dif = arr[r] - arr[l];
                if(dif == minDif){
                    List<Integer> list = new ArrayList<>();
                    list.add(arr[l]);
                    list.add(arr[r]);
                    res.add(list);
                }
                r++;
                l++;
            }
            return res;
        }
    }
}

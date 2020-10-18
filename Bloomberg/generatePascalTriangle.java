package Bloomberg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class generatePascalTriangle {

    class Solution {
        /*
        [1]
        [1,1]
        [1,2,1]
        [1,3,3,1]
        [1,4,6,4,1]
        */
        public List<List<Integer>> generate(int num) {
            List<List<Integer>> res = new ArrayList<>();
            if(num == 0){
                return res;
            }
            res.add(Arrays.asList(1));
            for(int i = 1 ; i < num; i++){
                List<Integer> list = new ArrayList<>();
                for(int j = 0; j <= i; j++){
                    if(j == 0){
                        list.add(1);
                    }
                    else if(j == i){
                        list.add(1);
                    }
                    else{
                        int val = res.get(i-1).get(j-1) + res.get(i-1).get(j);
                        list.add(val);
                    }
                }
                res.add(list);
            }
            return res;
        }
    }
}

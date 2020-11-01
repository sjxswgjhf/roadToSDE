package Bloomberg;

import java.util.ArrayList;
import java.util.List;

public class lt118generatePascalTriangle {

    class Solution {
        /*

    [1],
    [1,1],
    [1,2,1],
    [1,3,3,1],
    [1,4,6,4,1]

     */
        public List<List<Integer>> generate(int numRows) {

            List<List<Integer>> res = new ArrayList<>();
            for(int i = 1; i <= numRows; i++){
                List<Integer> list = new ArrayList<>();
                for(int j = 1; j <= i; j++){
                    if(j == 1){
                        list.add(1);
                    }
                    else if(j == i){
                        list.add(1);
                    }else{
                        list.add(res.get(i - 2).get(j - 2) + res.get(i - 2).get(j - 1));
                    }
                }
                res.add(list);
            }

            return res;
        }
    }
}

package RoadTo1K;

import java.util.ArrayList;
import java.util.List;

public class lt119getRow {

    class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> list = new ArrayList<>();
            if(rowIndex < 0){
                return list;
            }
            for(int i = 0; i <= rowIndex; i++){
                list.add(0, 1);     //add front 1
                //solve middle part, mid part = j + (j+1), why not j - 1 + j, since we add 1 into front, all shift to right 1 position
                for(int j = 1; j < list.size() - 1; j++){
                    list.set(j, list.get(j) + list.get(j + 1));
                }
            }
            return list;
        }
    }
}

package RoadTo1K;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class lt170TwoSum {

    /*
    这题用本来的hashset可以做，也是O(N)时间，map的话可以优化大量重复的值，通过map.entry来实现key跟value的获得
     */

    class TwoSumMap {

        HashMap<Integer, Integer> map;
        /** Initialize your data structure here. */
        public TwoSumMap() {
            map = new HashMap<>();
        }

        /** Add the number to an internal data structure.. */
        public void add(int number) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        /** Find if there exists any pair of numbers which sum is equal to the value. */
        public boolean find(int value) {

            for(HashMap.Entry<Integer, Integer> entry : map.entrySet()){
                int key = entry.getKey();
                int target = value - key;
                if(target == key){
                    if(map.get(key) > 1){
                        return true;
                    }
                }else{
                    if(map.containsKey(target)){
                        return true;
                    }
                }
            }
            return false;
        }
    }

    class TwoSum {

        /** Initialize your data structure here. */
        List<Integer> list;
        public TwoSum() {
            list = new ArrayList<>();
        }

        /** Add the number to an internal data structure.. */
        public void add(int number) {
            list.add(number);
        }

        /** Find if there exists any pair of numbers which sum is equal to the value. */
        public boolean find(int value) {
            HashSet<Integer> set = new HashSet<>();
            for(int num : list){
                if(set.contains(value - num)){
                    return true;
                }else{
                    set.add(num);
                }
            }
            return false;
        }
    }

}

package Bloomberg;
import java.util.*;

public class lt380RandomizedSet {

    /*
    这题通过记录idx来实现list里面值的替换，注意替换的时候当前tail值是不是跟remove的值一样，一样的话不需要替换，直接remove，不然的话就要替换
     */

    class RandomizedSet {

        HashMap<Integer, Integer> map;
        List<Integer> list;
        Random rand;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
            rand = new Random();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(map.containsKey(val)){
                return false;
            }else{
                int idx = list.size();
                map.put(val, idx);
                list.add(val);
                return true;
            }
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if(!map.containsKey(val)){
                return false;
            }
            else{
                int idx = map.get(val);
                map.remove(val);
                int tailval = list.get(list.size() - 1);
                if(val != tailval){
                    map.put(tailval, idx);
                    list.set(idx, tailval);
                }
                list.remove(list.size() - 1);
                return true;
            }

        }

        /** Get a random element from the set. */
        public int getRandom() {
            int idx = rand.nextInt(list.size());
            return list.get(idx);
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}

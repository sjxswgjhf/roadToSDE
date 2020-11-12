package Bloomberg2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class lt380RandomizedSet {

    class RandomizedSet {

        HashMap<Integer, Integer> map;
        List<Integer> list;
        Random rand;
        /** Initialize your data structure here. */
        public RandomizedSet() {
            rand = new Random();
            map = new HashMap<>();
            list = new ArrayList<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(map.containsKey(val)){
                return false;
            }else{
                int idx = list.size();
                list.add(val);
                map.put(val, idx);
                return true;
            }
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if(!map.containsKey(val)){
                return false;
            }else{
                //整道题目的核心，怎么降低时间复杂度，我们可以改变list tail的值放到对应的idx，然后把去掉tail
                //同时需要更新map里面tail对应值的对应的idx
                int idx = map.get(val);
                map.remove(val);
                int tail = list.get(list.size() - 1);
                if(tail != val){
                    list.set(idx, tail);
                    map.put(tail, idx);
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

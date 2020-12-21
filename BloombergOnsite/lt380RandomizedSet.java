package BloombergOnsite;

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
            list = new ArrayList<>();
            map = new HashMap<>();
            rand = new Random();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(map.containsKey(val)){
                return false;
            }else{
                map.put(val, list.size());
                list.add(val);
                return true;
            }
        }

    /*
    这题难点是怎么降低remove的complexity，我们知道移除中间一个element，后面的整个list需要往前移动，
    worst会变成O(N)，那么我们每次都是移除最后一个的话会降低时间，然后利用知道idx的特性，我们用swap来实现,
    swap之后我们要更新map里面的idx值，然后remove掉尾部的值
    */
        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if(map.containsKey(val)){
                int size = list.size();
                int idx = map.get(val);
                map.remove(val);
                int lastVal = list.get(size - 1);
                if(lastVal != val){     //注意一定不能是lastval
                    list.set(idx, lastVal);
                    map.put(lastVal, idx);
                }
                list.remove(size - 1);
                return true;
            }else{
                return false;
            }
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int idx = rand.nextInt(list.size());
            return list.get(idx);
        }
    }

}

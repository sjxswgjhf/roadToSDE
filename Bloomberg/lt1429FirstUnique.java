package Bloomberg;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class lt1429FirstUnique {


    Queue<Integer> queue;
    HashMap<Integer, Integer> map;

    public lt1429FirstUnique(int[] nums) {
        queue = new LinkedList<>();
        map = new HashMap<>();
        for(int num : nums){
            queue.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
    }

    public int showFirstUnique() {
        while(!queue.isEmpty()){
            int num = queue.peek();
            if(map.get(num) != 1){
                queue.poll();
            }else{
                return num;
            }
        }
        return -1;
    }

    public void add(int value) {
        queue.add(value);
        map.put(value, map.getOrDefault(value, 0) + 1);
    }


}

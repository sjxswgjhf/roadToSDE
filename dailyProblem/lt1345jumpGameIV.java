package dailyProblem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class lt1345jumpGameIV {

    class Solution {
        public int minJumps(int[] arr) {
            int n = arr.length;
            int steps = 0;
            HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
            for(int i = 0; i < arr.length; i++){
                if(!map.containsKey(arr[i])){
                    map.put(arr[i], new HashSet<>());
                }
                HashSet<Integer> set = map.get(arr[i]);
                set.add(i);
                map.put(arr[i], set);
            }

            HashSet<Integer> visited = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    int idx = queue.poll();
                    if(idx == n - 1){
                        return steps;
                    }
                    visited.add(idx);
                    int next = idx + 1 >= n ? n - 1 : idx + 1;
                    int back = idx - 1 < 0 ? 0 : idx - 1;
                    if(!visited.contains(next)){
                        queue.add(next);
                    }
                    if(!visited.contains(back)){
                        queue.add(back);
                    }
                    HashSet<Integer> sameList = map.get(arr[idx]);
                    for(int j : sameList){
                        if(idx != j && !visited.contains(j)){
                            queue.add(j);
                        }
                    }
                    sameList.clear();   //清理set，对于其他idx到这个位置的我们不需要处理了，因为这些idx已经被处理过一次了
                }
                steps++;
            }
            return -1;
        }
    }
}

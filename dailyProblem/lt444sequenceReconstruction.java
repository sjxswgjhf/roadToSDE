package dailyProblem;

import java.util.*;

public class lt444sequenceReconstruction {

    /*
    题目描述的很不清楚，很烂的一道题
     */
    class Solution {
        public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
            HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
            HashMap<Integer, Integer> degrees = new HashMap<>();
            for(List<Integer> seq : seqs){
                if(seq.size() == 1){
                    if(!map.containsKey(seq.get(0))){
                        map.put(seq.get(0), new HashSet<>());
                        degrees.put(seq.get(0), 0);
                    }
                }else{
                    for(int i = 0; i < seq.size() - 1; i++){
                        int parent = seq.get(i);
                        int child = seq.get(i+1);
                        HashSet<Integer> set = map.getOrDefault(parent, new HashSet<>());
                        if(set.contains(child)){
                            continue;
                        }
                        set.add(child);
                        map.put(parent, set);
                        if(!map.containsKey(child)){
                            map.put(child, new HashSet<>());
                        }
                        if(!degrees.containsKey(parent)){
                            degrees.put(parent, 0);
                        }
                        degrees.put(child, degrees.getOrDefault(child, 0) + 1);
                    }
                }
            }
            Queue<Integer> queue = new LinkedList<>();
            for(int key : degrees.keySet()){
                if(degrees.get(key) == 0){
                    queue.add(key);
                }
            }
            int idx = 0;
            while(!queue.isEmpty()){
                int size = queue.size();
                if(size > 1){
                    return false;
                }
                for(int i = 0; i < size; i++){
                    int cur = queue.poll();
                    if(idx == org.length || org[idx++] != cur){
                        return false;
                    }
                    HashSet<Integer> children = map.getOrDefault(cur, new HashSet<>());
                    for(int child : children){
                        degrees.put(child, degrees.get(child) - 1);
                        if(degrees.get(child) == 0){
                            queue.add(child);
                            degrees.remove(child);
                        }
                    }
                }
            }
            return idx == org.length && idx == map.size();
        }
    }
}

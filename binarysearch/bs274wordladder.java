package binarysearch;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class bs274wordladder {

    class Solution {
        public int solve(String[] dictionary, String start, String end) {
            HashSet<String> set = new HashSet<>();
            for(String d : dictionary){
                set.add(d);
            }
            if(start.equals(end)){
                return 0;
            }
            if(!set.contains(end)){
                return -1;
            }
            Queue<String> queue = new LinkedList<>();
            queue.add(start);
            int steps = 0;
            while(!queue.isEmpty()){
                steps++;
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    String cur = queue.poll();
                    if(cur.equals(end)){
                        return steps;
                    }
                    char[] cs = cur.toCharArray();
                    for(int j = 0; j < cs.length; j++){
                        char old = cs[j];
                        for(char c = 'a'; c <= 'z'; c++){
                            cs[j] = c;
                            String tmp = new String(cs);
                            if(set.contains(tmp)){
                                queue.add(tmp);
                                set.remove(tmp);
                            }
                        }
                        cs[j] = old;
                    }
                }
            }
            return -1;
        }
    }
}

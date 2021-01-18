package dailyProblem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class lt752openLock {

    class Solution {
        public int openLock(String[] deadends, String target) {
            char[] starts = {'0','0','0','0'};
            HashSet<String> deadendTable = new HashSet<>();
            for(String deadend : deadends){
                if(deadend.equals("0000")){
                    return -1;
                }
                deadendTable.add(deadend);
            }
            if(String.valueOf(starts).equals(target)){
                return 0;
            }
            Queue<char[]> queue = new LinkedList<>();
            queue.add(starts);
            HashSet<String> seen = new HashSet<>();
            int steps = 0;
            boolean found = false;
            while(!queue.isEmpty()){
                steps++;
                int size = queue.size();
                while(size-- > 0){
                    char[] cur = queue.poll();
                    if(seen.contains(new String(cur))){
                        continue;
                    }else{
                        if(deadendTable.contains(new String(cur))){
                            continue;
                        }
                        seen.add(new String(cur));
                        for(int i = 0; i < 4; i++){
                            char[] inc = Arrays.copyOf(cur, cur.length);
                            if(cur[i] == '9'){
                                inc[i] = '0';
                            }else{
                                inc[i] = (char)(cur[i] + 1);
                            }
                            if(target.equals(new String(inc))){
                                return steps;
                            }
                            queue.add(inc);
                            char[] des = Arrays.copyOf(cur, cur.length);
                            if(cur[i] == '0'){
                                des[i] = '9';
                            }else{
                                des[i] = (char)(cur[i] - 1);
                            }
                            if(target.equals(new String(des))){
                                return steps;
                            }
                            queue.add(des);
                        }
                    }

                }
            }
            return found == false ? -1 : steps;
        }
    }
}

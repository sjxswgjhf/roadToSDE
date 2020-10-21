package Bloomberg;

import java.util.*;

public class lt621leastInterval {

    class Solution {

        class Task{
            int freq;
            int lastUsed = -1;
            public Task(int f){
                freq = f;
            }
        }

        public int leastInterval(char[] tasks, int n) {
            if(n == 0){
                return tasks.length;
            }
            HashMap<Character, Task> map = new HashMap<>();
            for(char c : tasks){
                map.putIfAbsent(c, new Task(0));
                map.get(c).freq++;
            }
            PriorityQueue<Task> pq = new PriorityQueue<>((a,b) -> b.freq - a.freq);
            pq.addAll(map.values());
            int count = 0;
            while(!pq.isEmpty()){
                int k = n + 1;
                List<Task> cooling = new LinkedList<>();
                //form one group with size n + 1
                //k是初始要用的group size，然后通过往里加东西，当我们pq里面任务不足的的时候或我们加满了一个group，我们就停止，k > 0就是剩下填的idle的位置，count就是累积的任务处理
                while(k > 0 && !pq.isEmpty()){
                    Task t = pq.poll();
                    t.freq--;
                    cooling.add(t);
                    k--;
                    count++;
                }
                //当我们完成一组group之后，我们把在冷却的加回pq
                for(Task t : cooling){
                    if(t.freq > 0){
                        pq.add(t);
                    }
                }
                //所有任务处理完了，就停止，这里再count计算之前是因为最后一次的时候，我们不需要idle了，所以提前break，不累积idle
                if(pq.isEmpty()){
                    break;
                }
                //累积count，k是剩下的idle要加进去
                count = count + k;
            }
            return count;
        }
    }

    class SolutionGreedy {
        /*
        A A A A A B B B n = 2

        we have enough task to satisfy
        */
        public int leastInterval(char[] tasks, int n) {

            int[] freq = new int[26];
            for(int i = 0; i < tasks.length; i++){
                freq[tasks[i]-'A']++;
            }
            Arrays.sort(freq);
            int max = freq[25] - 1;
            int idles = max * n;
            for(int i = 24; i >=0; i--){
                idles -= Math.min(freq[i], max);
            }
            return idles > 0 ? idles + tasks.length : tasks.length;
        }
    }
}

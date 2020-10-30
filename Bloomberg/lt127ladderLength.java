package Bloomberg;

import java.util.*;
public class lt127ladderLength {

    class Solution {
        /*
        BFS
        */
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            HashSet<String> set = new HashSet<>();
            for(String word : wordList){
                set.add(word);
            }
            if (!set.contains(endWord)) return 0;
            Queue<String> queue = new LinkedList<>();
            int steps = 1;
            queue.add(beginWord);
            while(!queue.isEmpty()){
                int size = queue.size();
                steps++;
                for(int i = 0; i < size; i++){
                    String cur = queue.poll();
                    char[] cs = cur.toCharArray();
                    for(int j = 0; j < cs.length; j++){
                        char c = cs[j];
                        for(char z = 'a'; z <= 'z'; z++){
                            if(c == z){
                                continue;
                            }
                            cs[j] = z;
                            String tmp = new String(cs);
                            if(tmp.equals(endWord)){
                                return steps;
                            }
                            if(!set.contains(tmp)){
                                continue;
                            }
                            queue.add(tmp);
                            set.remove(tmp);

                        }
                        cs[j] = c;
                    }
                }
            }

            return 0;
        }
    }
}

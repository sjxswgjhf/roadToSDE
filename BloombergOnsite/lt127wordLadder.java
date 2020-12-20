package BloombergOnsite;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lt127wordLadder {

    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            HashSet<String> set = new HashSet<>();
            for(String word : wordList){
                set.add(word);
            }
            if(!set.contains(endWord)){
                return 0;
            }
            Queue<String> queue = new LinkedList<>();
            queue.add(beginWord);
            int steps = 1;
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0 ; i < size; i++){
                    String word = queue.poll();
                    // visited.add(word);
                    if(word.equals(endWord)){
                        return steps;
                    }
                    char[] cs = word.toCharArray();
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
                steps++;
            }
            return 0;
        }
    }
}

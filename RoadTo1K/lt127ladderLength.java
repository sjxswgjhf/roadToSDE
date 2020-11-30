package RoadTo1K;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lt127ladderLength {

    class Solution {
        /*
        典型的BFS，需要几个强剪枝，
        首先是用hashset当dict来实现快速查找
        判断下end是不是在dict里面，不在就直接返回
        然后做BFS，在next是没有遇到过，并且还在dict的时候加入queue，
        同时要删除对应dict里面的str，为什么呢，因为我在这一步遇到了，以后就不需要这个词了，即使其他str能到这个
        str，也是比我慢的，当我删掉之后，这也是给其他str起到了剪枝作用,最后time complexity大幅度缩短

        time complexity: O(m*n*m*26)
        M是单词长度，N是input数量
         */
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Queue<String> queue = new LinkedList<>();
            HashSet<String> dict = new HashSet<>();
            for(String word : wordList){
                dict.add(word);
            }
            if(!dict.contains(endWord)){
                return 0;
            }
            HashSet<String> visited = new HashSet<>();
            queue.add(beginWord);
            int steps = 0;
            //最坏情况就是N个单词都用到了
            while(!queue.isEmpty()){
                int size = queue.size();
                steps++;
                for(int i = 0; i < size; i++){
                    String cur = queue.poll();
                    if(cur.equals(endWord)){
                        return steps;
                    }
                    visited.add(cur);
                    char[] cs = cur.toCharArray();
                    //m
                    for(int j = 0; j < cur.length(); j++){
                        char old = cs[j];
                        //26
                        for(char c = 'a'; c <= 'z'; c++){
                            cs[j] = c;
                            //m
                            String next = new String(cs);
                            if(!visited.contains(next) && dict.contains(next)){
                                queue.add(next);
                                //这里是个强剪枝，我们已经使用了的路径就从dict里面删除，避免后来又走到这边
                                dict.remove(next);
                            }
                        }
                        cs[j] = old;
                    }
                }
            }
            return 0;
        }
    }

    class SolutionSecond {
        /*
        做BFS,把list转换成hashset，如果当前set没有end直接return 0，不然就做bfs，
        但是要注意遇到了list里面的word之后，要把这个word删掉，避免以后bfs的时候遇到，
        降低复杂度
        */
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            HashSet<String> set = new HashSet<>();
            for(String word : wordList){
                set.add(word);
            }
            if(!set.contains(endWord)){
                return 0;
            }
            Queue<String> queue = new LinkedList<>();
            int steps = 1;
            queue.add(beginWord);
            while(!queue.isEmpty()){
                int size = queue.size();
                steps++;
                for(int i = 0; i < size; i++){
                    String cur = queue.poll();
                    char[] cs = cur.toCharArray();
                    for(int j = 0; j < cur.length(); j++){
                        char old = cs[j];
                        for(char k = 'a'; k <= 'z'; k++){
                            cs[j] = k;
                            String tmp = new String(cs);
                            if(tmp.equals(endWord)){
                                return steps;
                            }
                            if(set.contains(tmp)){
                                System.out.println(tmp);
                                queue.add(tmp);
                                set.remove(tmp);
                            }
                        }
                        cs[j] = old;
                    }
                }
            }
            return 0;
        }
    }
}

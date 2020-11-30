package RoadTo1K;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lt245shortestWordDistance {

    class Solution {
        /*
        one pass:
        用idx记录遇到的word1或者word2的位置，当当前的i的word是word1或者word2的时候
        我们先判断idx不是-1，表示遇到过了，之后再看word1跟word2是不是一样的，是一样我们直接计算distance，
        如果不是一样的，那么idx的word不能跟当前word一样，不然就不对了。

        */
        public int shortestWordDistance(String[] words, String word1, String word2) {
            int res = words.length;
            int idx = -1;
            for(int i = 0; i < words.length; i++){
                if(words[i].equals(word1) || words[i].equals(word2)){
                    if(idx != -1 && (word1.equals(word2) || !words[idx].equals(words[i]))){
                        res = Math.min(res, i - idx);
                    }
                    idx = i;
                }
            }
            return res;
        }
    }

    class SolutionNaive {
        public int shortestWordDistance(String[] words, String word1, String word2) {
            HashMap<String, List<Integer>> map = new HashMap<>();
            for(int i = 0; i < words.length; i++){
                List<Integer> list = map.getOrDefault(words[i], new ArrayList<>());
                list.add(i);
                map.put(words[i], list);
            }
            int res = Integer.MAX_VALUE;
            List<Integer> l1 = map.get(word1);
            List<Integer> l2 = map.get(word2);
            for(int d1 : l1){
                for(int d2 : l2){
                    if(d1 == d2){
                        continue;
                    }else{
                        res = Math.min(res, Math.abs(d1 - d2));
                    }
                }
            }
            return res;
        }
    }
}

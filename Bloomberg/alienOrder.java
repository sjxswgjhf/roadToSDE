package Bloomberg;

import java.util.*;

public class alienOrder {
    class Solution {
        /*
         1. build graph
            1.1 care invalid case
         2. topological sort
        */
        public String alienOrder(String[] words) {
            HashMap<Character, Integer> degrees = new HashMap<>();
            HashMap<Character, List<Character>> graph = new HashMap<>();
            //precreate empty list for each character
            for(String word : words){
                for(char c : word.toCharArray()){
                    if(!graph.containsKey(c)){
                        graph.put(c, new ArrayList<>());
                        degrees.put(c, 0);
                    }
                }
            }
            for(int i = 1; i < words.length; i++){
                String word1 = words[i - 1];
                String word2 = words[i];
                if(word1.length() > word2.length() && word1.startsWith(word2)){
                    return "";
                }
                for(int j = 0; j < Math.min(word1.length(), word2.length()); j++){
                    char c1 = word1.charAt(j);
                    char c2 = word2.charAt(j);
                    if(c1 != c2){
                        degrees.put(c2, degrees.get(c2)+1);
//                        graph.put(c1, graph.get(c1).add(c2));
                        graph.get(c1).add(c2);
                        break;
                    }
                }
            }
            Queue<Character> queue = new LinkedList<>();
            for(Character c : degrees.keySet()){
                if(degrees.get(c) == 0){
                    queue.add(c);
                }
            }
            String res = "";
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    char c = queue.poll();
                    res += c;
                    List<Character> children = graph.get(c);
                    for(Character child : children){
                        degrees.put(child, degrees.get(child) - 1);
                        if(degrees.get(child) == 0){
                            queue.add(child);
                        }
                    }
                }
            }
            if(res.length() != degrees.size()){
                return "";      //there is a cycle
            }
            return res;
        }
    }

}

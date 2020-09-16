package facebook;

import java.util.*;

public class alienOrder {
    /*
    解题：
    1. 建立有向图
    2. 拓扑排序得到满足条件的有序关系

    把graph的所有vertices的income degree计算好，然后逐步的把degree为0的vertex拿掉同时把他adj的node的income degree减1
    然后计数，我们拿掉了多少个vertex，如果cnt == vertices的数量，那么就是acyclic，如果不等于，说明有环
    把所有为degree为0的vertex放入0，然后遍历

    这题用拓扑排序来做，先根据input建立图像，首先针对每个character我们要有对应的children list跟incoming degrees，然后两两取str，先看第一个str是不是包含
    了第二个str，如果是的话，就是invalid的情况，算是edge case，然后比较两个str的char，找到第一个不同的char，根据前后关系加到children，跟degrees，建完图像
    开始做拓扑排序，从degree 0开始，依次去掉，并减去children的degree，直到queue为空，然后我们要看最后的result是不是包含了所有的character，如果不是，那说明
    有cycle存在，即invalid，不然就return res

     */
    class Solution {

        public String alienOrder(String[] words) {
            HashMap<Character, List<Character>> adjList = new HashMap<>();
            HashMap<Character, Integer> counts = new HashMap<>();
            for(String word : words){
                for(char c : word.toCharArray()){
                    counts.put(c, 0);
                    adjList.put(c, new ArrayList<>());
                }
            }

            for(int i = 0; i < words.length - 1; i++){
                String word1 = words[i];
                String word2 = words[i + 1];
                //check that word2 is not a predix of word1
                if(word1.length() > word2.length() && word1.startsWith(word2)){
                    return "";
                }

                for(int j = 0; j < Math.min(word1.length(), word2.length()); j++){
                    if(word1.charAt(j) != word2.charAt(j)){
                        adjList.get(word1.charAt(j)).add(word2.charAt(j));
                        counts.put(word2.charAt(j), counts.get(word2.charAt(j)) + 1);
                        break;
                    }
                }
            }

            StringBuffer sb = new StringBuffer();
            Queue<Character> queue = new LinkedList<>();
            for(Character c : counts.keySet()){
                if(counts.get(c) == 0){
                    queue.add(c);
                }
            }

            while(!queue.isEmpty()){
                Character c = queue.poll();
                sb.append(c);
                List<Character> children = adjList.get(c);
                for(Character child : children){
                    int count = counts.get(child);
                    counts.put(child, count - 1);
                    if(count - 1 == 0){
                        queue.add(child);
                    }
                }
            }

            if(counts.size() != sb.length()){
                return "";
            }
            return sb.toString();
        }
    }
}

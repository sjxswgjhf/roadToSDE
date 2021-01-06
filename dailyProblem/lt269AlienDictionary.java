package dailyProblem;

import java.util.*;

public class lt269AlienDictionary {

    class Solution {
        public String alienOrder(String[] words) {
            HashMap<Character, List<Character>> map = new HashMap<>();
            HashMap<Character, Integer> degrees = new HashMap<>();
            for(String word : words){
                for(char c : word.toCharArray()){
                    if(!map.containsKey(c)){
                        map.put(c, new ArrayList<>());
                        degrees.put(c, 0);
                    }
                }
            }
            for(int i = 0; i < words.length - 1; i++){
                String first = words[i];
                String second = words[i + 1];
                //检查是不是符合sorted，但是我们不知道Alien的排序定义，所以我们只能比较第二个是不是第一个的subsrtring
                if(first.length() > second.length() && first.startsWith(second)){
                    return "";
                }
                else{
                    //找到对应的sort定义
                    for(int j = 0; j < Math.min(first.length(), second.length()); j++){
                        char c1 = first.charAt(j);
                        char c2 = second.charAt(j);
                        if(c1 != c2){
                            List<Character> children = map.get(c1);
                            children.add(c2);
                            map.put(c1, children);
                            degrees.put(c2, degrees.get(c2) + 1);
                            break;
                        }
                    }
                }
            }
            Queue<Character> queue = new LinkedList<>();
            StringBuffer sb = new StringBuffer();
            for(char key : degrees.keySet()){
                if(degrees.get(key) == 0){
                    queue.add(key);
                }
            }
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    char c = queue.poll();
                    sb.append(c);
                    degrees.remove(c);
                    for(char child : map.get(c)){
                        if(!degrees.containsKey(child)){
                            return "";
                        }
                        degrees.put(child, degrees.get(child) - 1);
                        if(degrees.get(child) == 0){
                            queue.add(child);
                        }
                    }
                }
            }
            return sb.length() == map.size() ? sb.toString() : "";
        }
    }
}

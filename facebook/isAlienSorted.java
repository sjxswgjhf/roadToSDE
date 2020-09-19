package facebook;

import java.util.HashMap;

public class isAlienSorted {

    class SolutionHashMap {
        //用hashmap去记录每个char对应的idx，在比较两个str的时候，当遇到不同的char，看对应的idx，前者idx要小于后者，不然就是false，如果是就继续外层loop不用继续内层
        public boolean isAlienSorted(String[] words, String order) {
            HashMap<Character, Integer> map = new HashMap<>();

            for(int i = 0; i < order.length(); i++){
                map.put(order.charAt(i), i);
            }

            outer: for(int i = 1; i < words.length; i++){
                String word1 = words[i-1];
                String word2 = words[i];
                if(word1.length() > word2.length() && word1.startsWith(word2)){
                    return false;
                }
                for(int j = 0; j < Math.min(word1.length(), word2.length()); j++){
                    char c1 = word1.charAt(j);
                    char c2 = word2.charAt(j);
                    if(c1 != c2){
                        if(map.get(c1) > map.get(c2)){
                            return false;
                        }else{
                            continue outer;
                        }
                    }
                }
            }
            return true;
        }
    }
    class Solution {
        public boolean isAlienSorted(String[] words, String order) {

            for(int i = 0; i < words.length - 1; i++){
                //words[i] > words[i + 1]
                int compare = compare(words[i], words[i+1], order);
                if(compare > 0){
                    return false;
                }
            }
            return true;
        }

        private int compare(String s1, String s2, String order){
            int l = 0, r = 0;
            while(l < s1.length() && r < s2.length()){
                char c1 = s1.charAt(l);
                char c2 = s2.charAt(r);
                if(c1 == c2){
                    l++;
                    r++;
                    continue;
                }
                else{
                    int idx1 = order.indexOf(c1);
                    int idx2 = order.indexOf(c2);
                    if(idx1 > idx2){
                        return 1;
                    }else{
                        return -1;
                    }
                }
            }
            if(l == s1.length() && r == s2.length()){
                return 0;
            }
            if(l != s1.length() && r == s2.length()){
                return 1;
            }
            return -1;
        }
    }
}

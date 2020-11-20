package RoadTo1K;

import java.util.ArrayList;
import java.util.List;

public class lt916wordSubsets {

    class Solution {
        /*
        如果一个word要包含b的所有subsets，那么这个word里面的对应的每个char都要大于等于，b里面一个char在一个str里面出现的最大的freq
         */
        public List<String> wordSubsets(String[] A, String[] B) {
            int[] counts = new int[26];
            for(String b : B){
                int[] tmp = new int[26];
                for(char c : b.toCharArray()){
                    tmp[c-'a']++;
                }
                for(int i = 0; i < 26; i++){
                    counts[i] = Math.max(counts[i], tmp[i]);
                }
            }
            List<String> res = new ArrayList<>();
            for(String a : A){
                int[] tmp = new int[26];
                for(char c : a.toCharArray()){
                    tmp[c-'a']++;
                }
                boolean issubset = true;
                for(int i = 0; i < 26; i++){
                    if(counts[i] != 0 && counts[i] > tmp[i]){
                        issubset = false;
                        break;
                    }
                }
                if(issubset){
                    res.add(a);
                }
            }
            return res;
        }
    }
}

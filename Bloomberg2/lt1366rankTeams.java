package Bloomberg2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class lt1366rankTeams {

    class Solution {

        /*
        这题的排序是根据票数来，不是根据票分来
        */
        public String rankTeams(String[] votes) {
            int n = votes[0].length();
            HashMap<Character, int[]> map = new HashMap<>();
            for(String value : votes){
                for(int i = 0; i < value.length(); i++){
                    char c = value.charAt(i);
                    map.putIfAbsent(c, new int[n]);
                    map.get(c)[i]++;    //int[]表示的是得到的排名的票数，idx 0 表示第一名的票数
                }
            }
            List<Character> list = new ArrayList<>(map.keySet());
            Collections.sort(list, (a, b) -> {
                for(int i = 0; i < n; i++){
                    if(map.get(a)[i] != map.get(b)[i]){
                        //compare votes number
                        return map.get(b)[i] - map.get(a)[i];
                    }
                }
                //alphabetically
                return a - b;
            });
            StringBuffer sb = new StringBuffer();
            for(char c : list){
                sb.append(c);
            }
            return sb.toString();
        }
    }

}

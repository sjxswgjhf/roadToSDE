package IBM;

import java.util.HashMap;

public class perfectTeam {

    public int perfectTeam(String input){
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : input.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int min = Integer.MAX_VALUE;
        for(int v : map.values()){
            min = Math.min(v, min);
        }
        return min;
    }
}

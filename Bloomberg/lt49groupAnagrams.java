package Bloomberg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class lt49groupAnagrams {

    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            if(strs == null || strs.length == 0){
                return new ArrayList<>();
            }
            HashMap<String, List<String>> map = new HashMap<>();
            for(String str : strs){
                char[] cs = str.toCharArray();
                Arrays.sort(cs);
                String tmp = new String(cs);
                if(!map.containsKey(tmp)){
                    map.put(tmp, new ArrayList<>());
                }
                List<String> list = map.get(tmp);
                list.add(str);
                map.put(tmp, list);
            }
            List<List<String>> res = new ArrayList<>();
            for(List<String> list : map.values()){
                res.add(list);
            }
            return res;
        }
    }

}

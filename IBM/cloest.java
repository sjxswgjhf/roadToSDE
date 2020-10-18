package IBM;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class cloest {

    public static List<Integer> closest(String s, List<Integer> queries) {
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.computeIfAbsent(s.charAt(i), (k) -> new ArrayList<>()).add(i);
        }
        List<Integer> result = new ArrayList<>(queries.size());
        for (int query : queries) {
            List<Integer> indexes = map.getOrDefault(s.charAt(query), Collections.emptyList());
            result.add(binarySearch(indexes, query));
        }
        return result;
    }

    private static int binarySearch(List<Integer> list, int query){
        int left = 0;
        int right = list.size() - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(list.get(mid) == query){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        int res = left;
        if(left - 1 >= 0 && query - list.get(left - 1) < list.get(left) - query){
            res = left - 1;
        }
        return Math.abs(list.get(res) - query);
    }
}

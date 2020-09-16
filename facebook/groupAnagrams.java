package facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class groupAnagrams {


    class SolutionSort{
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, List<String>> map = new HashMap<>();
            for(String str : strs){
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String key = new String(chars);
                List<String> list = map.getOrDefault(key, new ArrayList<>());
                list.add(str);
                map.put(key, list);
            }
            List<List<String>> res = new ArrayList<>(map.values());
            return res;
        }
    }

    class SolutionCount {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> res = new ArrayList<>();
            HashMap<String, List<String>> hashmap = new HashMap<>();
            for(String str : strs){
                int[] nums = new int[26];
                for(int i = 0; i < str.length(); i++){
                    nums[str.charAt(i)-'a']++;
                }
                String code = "";
                for(int i = 0; i < 26; i++){
                    code += nums[i]+".";
                }
                List<String> list = hashmap.getOrDefault(code, new ArrayList<>());
                list.add(str);
                hashmap.put(code, list);
            }
            for(List<String> list : hashmap.values()){
                res.add(list);
            }
            return res;
        }
    }
}

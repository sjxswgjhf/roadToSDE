package dailyProblem;

import java.util.*;

public class lt726countOfAtoms {

    class Solution {
        public String countOfAtoms(String formula) {
            HashMap<String, Integer> map = new HashMap<>();
            Stack<HashMap<String, Integer>> stack = new Stack<>();
            stack.push(map);
            for(int i = 0; i < formula.length(); i++){
                char c = formula.charAt(i);
                if(c == '('){
                    stack.push(new HashMap<>(map));
                    map.clear();
//                    stack.push(new HashMap<>(map));
//                    map.clear();
//                    涉及了reference，clear会清理掉reference的data，所以要copy一份新的
                }
                else if(c == ')'){
                    int j = i + 1;
                    int num = 0;
                    while(j < formula.length() && Character.isDigit(formula.charAt(j))){
                        num = num * 10 + (formula.charAt(j) - '0');
                        j++;
                    }
                    if(num == 0){
                        num = 1;
                    }
                    // System.out.println(num);
                    //拿出stack顶部的map，遇当前map的freq累加
                    HashMap<String, Integer> tmp = map;
                    map = stack.pop();
                    for(String str : tmp.keySet()){
                        // System.out.println(map.getOrDefault(str, 0) + " " + str + " " + tmp.get(str));
                        map.put(str, map.getOrDefault(str, 0) + tmp.get(str) * num);
                    }
                    i = j - 1;
                }
                else if(c >= 'A' && c <= 'Z'){
                    int j = i + 1;
                    while(j < formula.length() && formula.charAt(j) >= 'a' && formula.charAt(j) <= 'z'){
                        j++;
                    }
                    String tmp = formula.substring(i, j);
                    i = j;
                    int num = 0;
                    while(j < formula.length() && Character.isDigit(formula.charAt(j))){
                        num = num * 10 + (formula.charAt(j) - '0');
                        j++;
                    }
                    if(num == 0){
                        num = 1;
                    }
                    map.put(tmp, map.getOrDefault(tmp, 0) + num);
                    i = j - 1;
                }
            }
            String res = "";
            List<String> list= new ArrayList<>(map.keySet());
            Collections.sort(list);
            for(String key : list){
                res += key;
                if(map.get(key) > 1){
                    res += map.get(key);
                }
            }
            return res;
        }
    }
}

package facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class letterCombination {

    class Solution {
        HashMap<String, String> buttons;
        public List<String> letterCombinations(String digits) {
            buttons = new HashMap<>();
            buttons.put("2", "abc");
            buttons.put("3", "def");
            buttons.put("4", "ghi");
            buttons.put("5", "jkl");
            buttons.put("6", "mno");
            buttons.put("7", "pqrs");
            buttons.put("8", "tuv");
            buttons.put("9", "wxyz");
            List<String> res = new ArrayList<>();
            if(digits == null || digits.length() == 0){
                return res;
            }
            helper(res, "", digits);
            return res;
        }

        private void helper(List<String> res, String cur, String digits){
            if(digits.length() == 0){
                res.add(cur);
            }else{
                String str = buttons.get(digits.substring(0, 1));
                for(int i = 0; i < str.length(); i++){
                    helper(res, cur + str.charAt(i), digits.substring(1));
                }
            }
        }
    }

}

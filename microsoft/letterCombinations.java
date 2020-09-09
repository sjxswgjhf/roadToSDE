package microsoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class letterCombinations {


    HashMap<String, String> map = new HashMap<String, String>(){{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {

        if(digits == null || digits.length() == 0){
            return res;
        }
        helper("", digits);
        return res;
    }

    private void helper(String comb, String digits){
        if(digits.length() == 0){
            res.add(comb);
        }else{
            String digit = digits.substring(0,1);
            String letters = map.get(digit);
            for(int i = 0 ; i < letters.length(); i++){
                String letter = letters.substring(i, i + 1);
                helper(comb + letter, digits.substring(1));
            }
        }
    }
}

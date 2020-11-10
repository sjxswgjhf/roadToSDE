package Bloomberg;

public class lt14longestCommonPrefix {

    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if(strs == null || strs.length == 0){
                return "";
            }

            String res = "";
            outer: for(int i = 0; i < strs[0].length(); i++){
                char c = strs[0].charAt(i);
                for(int j = 1; j < strs.length; j++){
                    String str = strs[j];
                    if(i < str.length() && c == str.charAt(i)){
                        continue;
                    }else{
                        break outer;
                    }
                }
                res += c;
            }
            return res;
        }
    }
}

package RoadTo1K;

public class lt14longestCommonPrefix {

    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if(strs == null || strs.length == 0){
                return "";
            }
            String res = "";
            String str1 = strs[0];
            outer: for(int i = 0; i < str1.length() ; i++){
                char c = str1.charAt(i);
                for(int j = 1; j < strs.length; j++){
                    if(i >= strs[j].length()){
                        break outer;
                    }
                    if(c != strs[j].charAt(i)){
                        break outer;
                    }
                }
                res += c;
            }
            return res;
        }
    }
}

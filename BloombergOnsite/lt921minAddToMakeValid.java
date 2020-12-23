package BloombergOnsite;

public class lt921minAddToMakeValid {

    class Solution {
        public int minAddToMakeValid(String S) {
            int l = 0, r = 0;
            for(int i = 0 ; i < S.length(); i++){
                char c = S.charAt(i);
                if(c == '('){
                    l++;
                }
                else{
                    if(l == 0){
                        r++;
                    }else{
                        l--;
                    }
                }
            }
            return l + r;
        }
    }

}

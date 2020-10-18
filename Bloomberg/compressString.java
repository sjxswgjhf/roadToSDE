package Bloomberg;

public class compressString {
    class Solution {
        public int compress(char[] chars) {
            int l = 0, r = 0;
            while(r < chars.length){
                char c = chars[r];
                int count = 0;
                while(r < chars.length && chars[r] == c){
                    r++;
                    count++;
                }
                chars[l++] = c;
                if(count != 1){
                    for(char n : String.valueOf(count).toCharArray()){
                        chars[l++] = n;
                    }
                }
            }
            return l;
        }

    }

}

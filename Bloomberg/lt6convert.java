package Bloomberg;

public class lt6convert {
    class Solution {
        public String convert(String s, int numRows) {
            char[] cs = s.toCharArray();
            int n = s.length();
            StringBuffer[] sbs = new StringBuffer[n];
            for(int j = 0; j < n; j++){
                sbs[j] = new StringBuffer();
            }
            int i = 0;
            while(i < n){

            /*
            P
            A
            Y
            */
                for(int j = 0; j < numRows && i < n; j++){
                    sbs[j].append(cs[i++]);
                }
            /*
            one char for one col
            P
            A P
            Y
            */
                for(int j = numRows - 2; j >= 1 && i < n; j--){
                    sbs[j].append(cs[i++]);
                }
            }
            String res = "";
            for(int j = 0; j < n; j++){
                res += sbs[j].toString();
            }
            return res;
        }
    }
}

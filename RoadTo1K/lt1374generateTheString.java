package RoadTo1K;

public class lt1374generateTheString {

    class Solution {
        public String generateTheString(int n) {
            String res = "";
            if(n % 2 == 1){
                for(int i = 0; i < n; i++){
                    res += "a";
                }
            }else{
                for(int i = 0; i < n-1;i++){
                    res +="a";
                }
                res+="b";
            }
            return res;
        }
    }
}

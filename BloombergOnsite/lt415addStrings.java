package BloombergOnsite;

public class lt415addStrings {

    class Solution {
        public String addStrings(String num1, String num2) {
            String res = "";
            int l = num1.length() - 1, r = num2.length() - 1;
            int carryone = 0;
            while(l >= 0 && r >= 0){
                int v1 = (num1.charAt(l--) - '0');
                int v2 = (num2.charAt(r--) - '0');
                int sum = v1 + v2 + carryone;
                carryone = sum / 10;
                res = (sum % 10) + res;
            }
            while(l >= 0){
                int v1 = (num1.charAt(l--) - '0');
                int sum = carryone + v1;
                res = (sum % 10) + res;
                carryone = sum / 10;
            }
            while(r >= 0){
                int v2 = (num2.charAt(r--) - '0');
                int sum = carryone + v2;
                res = (sum % 10) + res;
                carryone = sum / 10;
            }
            if(carryone != 0){
                res = carryone + res;
            }
            return res;
        }
    }

}

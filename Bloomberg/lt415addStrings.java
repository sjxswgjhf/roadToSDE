package Bloomberg;

public class lt415addStrings {

    class Solution {
        public String addStrings(String num1, String num2) {
            StringBuffer sb = new StringBuffer();
            int carryone = 0;
            int idx1 = num1.length() - 1;
            int idx2 = num2.length() - 1;
            while(idx1 >= 0 || idx2 >= 0){
                int val1 = idx1 >= 0 ? (num1.charAt(idx1--) - '0') : 0;
                int val2 = idx2 >= 0 ? (num2.charAt(idx2--) - '0') : 0;
                int sum = val1 + val2 + carryone;
                carryone = sum / 10;
                sb.insert(0, sum % 10);
            }
            if(carryone == 1){
                sb.insert(0, carryone);
            }
            return sb.toString();
        }
    }
}

package facebook;

import java.util.ArrayList;
import java.util.List;

public class multiplyString {

    class SolutionDP{
        public String multiply(String num1, String num2) {
            int m = num1.length(), n = num2.length();
            int[] pos = new int[m + n];

            for(int i = m - 1; i >= 0; i--) {
                for(int j = n - 1; j >= 0; j--) {
                    int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                    int p1 = i + j, p2 = i + j + 1;
                    int sum = mul + pos[p2];

                    pos[p1] += sum / 10;
                    pos[p2] = (sum) % 10;
                }
            }

            StringBuilder sb = new StringBuilder();
            for(int p : pos){
                if(!(sb.length() == 0 && p == 0)) sb.append(p);
            }
            return sb.length() == 0 ? "0" : sb.toString();
        }
    }


    class SolutionPassed {
        /*
        123
      * 456
      ______
        738
       615
      492
      ______
      56088
        */
        public String multiply(String num1, String num2) {
            // StringBuffer sb = new StringBuffer();
            if(num1 == null || num1.length() == 0){
                return num2;
            }
            if(num2 == null || num2.length() == 0){
                return num1;
            }
            if(num1.length() == 1 && Integer.valueOf(num1) == 0){
                return "0";
            }
            if(num2.length() == 1 && Integer.valueOf(num2) == 0){
                return "0";
            }

            int m = num1.length();
            int n = num2.length();
            List<String> list = new ArrayList<>();
            for(int i = n - 1; i >= 0; i--){
                int carryone = 0;
                int val2 = (num2.charAt(i) - '0');
                StringBuffer tmp = new StringBuffer();
                for(int j = m-1; j >= 0; j--){
                    int val1 = (num1.charAt(j) -'0');
                    int product = val1 * val2 + carryone;
                    carryone = product / 10;
                    tmp.insert(0, product % 10);
                }
                if(carryone > 0){
                    tmp.insert(0, carryone);
                }
                int zeros = n - 1 - i;
                while(zeros > 0){
                    tmp.append('0');
                    zeros--;
                }
                list.add(tmp.toString());
            }
            //list: 789,6150,49200
            for(int i = 0; i < list.size() - 1; i++){
                String val1 = list.get(i);
                String val2 = list.get(i + 1);
                String res = add(val1, val2);
                list.set(i + 1, res);
            }
            return list.get(list.size() - 1);
        }
        // 990 + 90
        // 1080 + 9150
        private String add(String val1, String val2){
            int m = val1.length() - 1;
            int n = val2.length() - 1;
            int carryone = 0;
            StringBuffer sb = new StringBuffer();
            while(n >= 0){
                int v1 = m >= 0 ? val1.charAt(m) - '0' : 0;
                int v2 = val2.charAt(n) - '0';
                m--;
                n--;
                int sum = v1 + v2 + carryone;
                carryone = sum >= 10 ? 1 : 0;
                sb.insert(0, sum % 10);
            }
            if(carryone == 1){
                sb.insert(0, 1);
            }
            return sb.toString();
        }
    }
}

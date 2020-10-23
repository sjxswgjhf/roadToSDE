package Bloomberg;

import java.util.ArrayList;
import java.util.List;

public class lt412fizzBuzz {

    class Solution {
        public List<String> fizzBuzz(int n) {
            String fizz = "Fizz";
            String buzz = "Buzz";
            String fb = "FizzBuzz";
            List<String> res = new ArrayList<>();
            for(int i = 1; i <= n; i++){
                if(i % 3 == 0 && i % 5 ==0){
                    res.add(fb);
                }
                else if(i % 3 == 0){
                    res.add(fizz);
                }
                else if(i % 5 == 0){
                    res.add(buzz);
                }else{
                    res.add(String.valueOf(i));
                }
            }
            return res;
        }
    }
}

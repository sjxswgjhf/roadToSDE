package Bloomberg;

public class lt258addDigits {

    class Solution {
        /*

        10: 1
        11: 2
        12: 3
        ...
        1~9: 1~9, 10~18:1~9, 9为一轮
        special case: 9, 18, num % 9 == 0 should be 9 instead of 0
        */
        public int addDigits(int num) {
            if(num == 0){
                return 0;
            }
            return num % 9 == 0 ? 9 : num % 9;
        }
    }
}

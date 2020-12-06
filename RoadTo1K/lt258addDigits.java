package RoadTo1K;

public class lt258addDigits {


    class SolutionTricky {
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

    class Solution {
        /*
        Naive: loop直到num < 10

        0,1: 1
        2,3: 2
        4~8: 3
        9: 4
        */
        public int addDigits(int num) {
            if(num < 10){
                return num;
            }
            int tmp = 0;
            while(num > 0){
                tmp += num % 10;
                num /= 10;
            }
            return addDigits(tmp);
        }
    }
}

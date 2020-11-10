package Bloomberg;

public class lt12inttoRoman {

    class Solution {

        /*
        3999 => "MMMCMXCIX"
        58 => "LVIII"
        1994 => "MCMXCIV"
        8 => "VIII"
        4 => "IV"
        这题罗马单词因为是1~3999，而且每次都是量级递减。3000 = MMM
         */

        public String intToRoman(int num) {
            int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
            StringBuilder sb = new StringBuilder();
            int idx = 0;
            while(idx < values.length){
                int curval = values[idx];
                while(curval <= num){
                    sb.append(symbols[idx]);
                    num -= curval;
                }
                idx++;
            }
            return sb.toString();
        }
    }
}

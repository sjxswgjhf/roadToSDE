package facebook;

public class numsToWords {
    class Solution {
        private String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        private String[] TENS = {"", "TEN", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        private String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
        public String numberToWords(int num) {
            if(num == 0){
                return "Zero";
            }
            int idx = 0;
            String res = "";
            while(num > 0){
                int tmp = num % 1000;
                if(tmp != 0){
                    res = helper(tmp) + THOUSANDS[idx]+ " " + res;
                }
                idx++;
                num /= 1000;
            }
            return res.trim();
        }

        private String helper(int num){
            if(num == 0){
                return "";
            }
            else if(num < 20){
                return LESS_THAN_20[num]+ " ";
            }
            else if(num < 100){
                return TENS[num / 10] + " " + helper(num % 10);
            }else{
                return LESS_THAN_20[(num / 100)] + " Hundred " + helper(num % 100);
            }
        }
    }
}

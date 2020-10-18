package Bloomberg;

public class NumberToWords {

    class Solution {
        String[] LESS_THAN_TWENTY = {"", "One", "Two", "Three", "Four", "Five","Six","Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] TENS = {"", "Twenty", "Thirty","Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
        public String numberToWords(int num) {
            String word = "";
            int idx = 0;
            if(num == 0){
                return "Zero";
            }
            while(num > 0){
                int remainder =num % 1000;
                if(remainder != 0)
                    word = helper(remainder) + THOUSANDS[idx] + " " +word;
                num = num / 1000;
                idx++;
            }
            return word.trim();
        }

        String helper(int num){
            if(num == 0){
                return "";
            }
            else if(num > 0 && num < 20){
                return LESS_THAN_TWENTY[num] + " ";
            }
            else if(num >= 20 && num < 100){
                return TENS[num / 10 - 1] + " " + helper(num % 10);
            }
            else{
                return LESS_THAN_TWENTY[(num / 100)] + " Hundred " + helper(num % 100);
            }
        }
    }
}

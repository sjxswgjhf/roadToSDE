package microsoft;

public class numbersToWord {

    final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num){
        if(num == 0){
            return "Zero";
        }
        int i = 0;
        String word = "";
        //从后往前，所以word要加在后，新的加在前，i => 根据长度区分了单位
        while(num > 0){
            if(num % 1000 != 0){
                word = helper(num % 1000) + THOUSANDS[i] + " " + word;
            }
            num /= 1000;
            i++;
        }
        return word;
    }

    //被1000除的余数四种情况，0， 小于20， 小于100，小于1000
    //1~19直接Less20里面找
    //20~99由TENs[num/10】 + helper(num % 10) 先解决十位数再解决剩下的
    //100~99由Less20[num/100] + " Hundred " + helper(num % 100); 先解决百位数，再解决剩下的
    private String helper(int num){
        if(num == 0){
            return "";
        }
        else if(num < 20){
            return LESS_THAN_20[num] + " ";
        }
        else if(num < 100){
            return TENS[num / 10] + " " + helper(num % 10);
        }
        else{
            return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
        }
    }

}

package microsoft;

public class myAtoi {
    private int myAtoi(String str) {
        int i = 0;
        int result = 0;
        int sign = 1;
        if (str.length() == 0) {
            return 0;
        }
        //discard whitespaces in the beginning
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        //check optional sign if exists
        if (i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            sign = str.charAt(i++) == '-' ? -1 : 1;
        }
        //make sure the char is in 0~9
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            //check overflow
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }
        return result * sign;
    }
}

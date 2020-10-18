package IBM;

public class shiftStrings {

    public static String shiftString(String str, int leftShifts, int rightShifts){
        leftShifts = leftShifts % str.length();
        rightShifts = rightShifts % str.length();
        int shift = leftShifts - rightShifts;
        if(shift == 0){
            return str;
        }
        String newStr = str + str;
        if(shift > 0){
            return newStr.substring(shift, shift + str.length());
        }
        else{
            shift = Math.abs(shift);
            int idx = newStr.length() - shift - str.length();
            return newStr.substring(idx, idx + str.length());
        }
    }

    public static void main(String[] args) {
        String s = "abcd";
        int left = 1;
        int right = 2;
        System.out.println(shiftString(s, left, right));
    }
}

package microsoft;

public class isPalindrome {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        for(int i = 0, j = s.length() - 1; i < j; i++, j--){
            while(i < j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            if(i < j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                return false;
            }
        }
        return true;
    }
}

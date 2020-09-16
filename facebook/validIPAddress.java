package facebook;
import java.util.regex.Pattern;

public class validIPAddress {

    class Solution {

        /*
        regular expression
        5 possible situations:
        1. Chunk contains only one digit, from 0 to 9
        2. Chunk contains two digits. The first one 1~9 and the second one 0 ~ 9
        3. Chunk contains three digits. The first one is 1, the second and the third ones could be from 0~9
        4. Chunk contains three digits. The first one is 2, the second one is 0 ~ 4, the 3rd one is 0 ~ 9
        5. Chunk contains three digits. The first one is 2, the 2nd one is 5, the 3rd one is 0~5
        */
        String chunkIPv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
        Pattern patternIPv4 = Pattern.compile("^("+chunkIPv4+"\\.){3}"+chunkIPv4+"$");
        String chunkIPv6 = "([0-9a-fA-F]{1,4})";
        Pattern patternIPv6 = Pattern.compile("^(" + chunkIPv6 + "\\:){7}"+chunkIPv6+"$");

        public String validIPAddress(String IP) {
            if(patternIPv4.matcher(IP).matches()){
                return "IPv4";
            }
            else if(patternIPv6.matcher(IP).matches()){
                return "IPv6";
            }
            else{
                return "Neither";
            }
        }
    }

}

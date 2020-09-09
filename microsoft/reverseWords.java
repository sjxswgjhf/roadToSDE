package microsoft;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class reverseWords {

    private String reverseWords2(String s) {
        // remove leading spaces
        s = s.trim();
        // split by multiple spaces
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    private String reverseWords(String s) {
        int l = 0;
        int r = s.length() - 1;
        while(l < s.length() && s.charAt(l) == ' '){
            l++;
        }
        while(r >= 0 && s.charAt(r) == ' '){
            r--;
        }
        StringBuffer sb = new StringBuffer();
        int pointer = r;
        while(pointer >= l){
            pointer = r;
            while(pointer >= l && s.charAt(pointer) != ' '){
                pointer--;
            }
            sb.append(s, pointer + 1, r + 1);
            if(pointer > l)
                sb.append(' ');
            r = pointer;
            while(r >= l && s.charAt(r) == ' '){
                r--;
            }
        }
        return sb.toString();
    }
}

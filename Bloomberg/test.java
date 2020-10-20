package Bloomberg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;


/*
LeetCode contest时候的format文件
 */
public class test {


        public static void main(String[] args) throws IOException {
            InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
            BufferedReader in = new BufferedReader(reader);
            String line;
            while ((line = in.readLine()) != null) {
                HashMap<String, String> map = new HashMap<>();
                map.put(".-", "A");
                map.put("_...", "B");
                map.put("-.-", "C");
                map.put("-..", "D");
                map.put(".", "E");
                map.put("..--.", "F");
                map.put("--.", "G");
                map.put("....", "H");
                map.put("..", "I");
                map.put(".---", "J");
                map.put("-.-", "K");
                map.put(".-..", "L");
                map.put("--", "M");
                map.put("-.", "N");
                map.put("---", "O");
                map.put(".--.", "P");
                map.put("--.-", "Q");
                map.put(".-.", "R");
                map.put("...", "S");
                map.put("-", "T");
                map.put("..-", "U");
                map.put("...-", "V");
                map.put(".-", "W");
                map.put("-..-", "X");
                map.put("-.--", "Y");
                map.put("--..", "Z");
                map.put(".----", "1");
                map.put("..---", "2");
                map.put("...--", "3");
                map.put("....-", "4");
                map.put(".....", "5");
                map.put("-....", "6");
                map.put("--...", "7");
                map.put("---..", "8");
                map.put("----.", "9");
                map.put("-----", "0");

                StringBuffer sb = new StringBuffer();
                int r = 0;
                while(r < line.length()){
                    String tmp ="";
                    while(r < line.length() && line.charAt(r) != ' '){
                        tmp += line.charAt(r);
                        r++;
                    }
                    sb.append(map.get(tmp));
                    if(r < line.length() - 1 && line.charAt(r+1) == ' '){
                        sb.append(' ');
                        r++;
                    }
                    r++;
                }
                System.out.println(sb.toString());
            }
        }
}
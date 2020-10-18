package IBM;

public class compression {

    public static String compressString(String input){
        char[] chars = input.toCharArray();
        int r = 0;
        StringBuffer sb = new StringBuffer();
        while(r < chars.length){
            char c = chars[r];
            int count = 0;
            while(r < chars.length && chars[r] == c){
                count++;
                r++;
            }
            sb.append(c);
            if(count > 1)
                sb.append(count);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "aabbcc";
        String input2 = "aaaaaa";
        String input3 = "abbbcddaa";
        System.out.println(compressString(input3));
    }
}

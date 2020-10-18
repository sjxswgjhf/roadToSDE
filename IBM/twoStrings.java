package IBM;

import java.util.HashSet;

public class twoStrings {

    public void findCommonSubstring(String[] a, String[] b){
        for(int i = 0; i < a.length; i++){
            HashSet<Character> set = new HashSet<>();
            int len = Math.min(a[i].length(), b[i].length());
            for(int j = 0; j < len; j++) {
                set.add(a[i].charAt(j));
            }
            boolean common = false;
            for(int j = 0; j < len; j++){
                if(set.contains(b[i].charAt(j))){
                    common = true;
                    System.out.println("YES");
                    break;
                }
            }
            if(!common){
                System.out.println("NO");
            }
        }
    }
}

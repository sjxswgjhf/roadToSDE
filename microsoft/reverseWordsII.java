package microsoft;

public class reverseWordsII {
    private void reverse(int l, int r, char[] s){
        while(l < r){
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
            l++;
            r--;
        }
    }

    private void reverseWords(char[] s) {
        reverse(0, s.length - 1, s);
        int l = 0;
        int r = 0;
        while(r < s.length){
            while(r < s.length && s[r] != ' '){
                r++;
            }
            reverse(l, r - 1, s);
            r += 1;
            l = r;
        }
    }
}

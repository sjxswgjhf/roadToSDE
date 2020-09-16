package facebook;

public class addBinary {
    public String addBinary(String a, String b) {
        int carryone = 0;
        int m = a.length() - 1;
        int n = b.length() - 1;
        StringBuffer sb = new StringBuffer();
        while(m >= 0 || n >= 0){
            int v1 = m >= 0 ? a.charAt(m--) - '0' : 0;
            int v2 = n >= 0 ? b.charAt(n--) - '0' : 0;
            int sum = v1 + v2 + carryone;
            if(sum  >= 2){
                carryone = 1;
                sb.insert(0 ,sum % 2);
            }else{
                carryone = 0;
                sb.insert(0, sum % 2);
            }
        }
        if(carryone == 1){
            sb.insert(0, "1");
        }
        return sb.toString();
    }
}

package facebook;

public class read4 {

   class Reader4{
       int read4(char[] tmp){
           return 0;
       }
   }

    public class Solution extends Reader4 {
        /**
         * @param buf Destination buffer
         * @param n   Number of characters to read
         * @return    The number of actual characters read
         */
        public int read(char[] buf, int n) {
            char[] tmp = new char[4];
            boolean eof = false;
            int idx = 0;
            while(!eof && idx < n){
                int read = read4(tmp);
                if(read < 4){
                    eof = true;
                }
                if(idx + read >= n){
                    read = n - idx;
                }
                for(int i = 0; i < read; i++){
                    buf[idx++] = tmp[i];
                }
            }
            return idx;
        }
    }
}

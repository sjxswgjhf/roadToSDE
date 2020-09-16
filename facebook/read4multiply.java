package facebook;

public class read4multiply {


    int read4(char[] tmp){
        return 0;
    }



    char[] prevBuf = new char[4];
    int prevSize = 0;
    int prevIndex = 0;

    public int read(char[] buf, int n) {
        int counter = 0;

        while (counter < n) {
            if (prevIndex < prevSize) {
                buf[counter++] = prevBuf[prevIndex++];
            } else {
                prevSize = read4(prevBuf);
                prevIndex = 0;
                if (prevSize == 0) {
                    // no more data to consume from stream
                    break;
                }
            }
        }
        return counter;
    }
}

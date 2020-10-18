package IBM;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class largeResponse {

    public void largeResponse(String fileName) throws Exception{
        FileReader input = new FileReader(fileName);
        Scanner scan = new Scanner(input);
        int count = 0;
        long sum = 0;
        String outputName = "Byte_"+fileName;
        FileWriter output = new FileWriter(outputName);
        while(scan.hasNext()){
            String line = scan.nextLine();
            String[] words = line.split("\\s");
            long bytes = Long.parseLong(words[words.length - 1]);
            if(bytes > 5000L){
                count++;
                sum += bytes;
            }
        }
        output.write(count +"\n");
        output.write(sum + "\n");
        input.close();
        output.close();
    }
}

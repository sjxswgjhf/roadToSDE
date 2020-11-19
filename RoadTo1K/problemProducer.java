package RoadTo1K;

import java.util.Random;

public class problemProducer {

    public static void main(String[] args) {
        int numOfLt = 1659;
        Random rand = new Random();
//        int[] pros = new int[numOfLt + 1];
        for(int i = 0; i < 5; i++){
            int proNum = rand.nextInt(numOfLt) + 1;
            System.out.print(proNum + ", ");
//            pros[proNum]++;
        }
//        int max = 0;
//        for(int i = 0; i < numOfLt + 1; i++){
//            System.out.print(pros[i] + " ");
//            max = Math.max(pros[i], max);
//            if(i % 20 == 0){
//                System.out.println();
//            }
//        }
//        System.out.println();
//        System.out.println(max);
    }
}

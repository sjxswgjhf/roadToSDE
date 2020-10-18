package IBM;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class parkingDilemma {


    public static int parkingDilemma(List<Integer> cars, int k, int size){
        int min = Integer.MAX_VALUE;
        Collections.sort(cars);
        for(int i = 0; i < cars.size(); i++){
            if(i < k - 1){
                continue;
            }
            int curLen = cars.get(i) - cars.get(i-k+1) + 1;
            min = Math.min(curLen, min);
        }
        return min;
    }

    public static void main(String[] args) {
        List<Integer> cars = new ArrayList<>();
        cars.add(2);
        cars.add(10);
        cars.add(8);
        cars.add(17);
        int size = 4;
        int k = 3;
        System.out.println(parkingDilemma(cars, k, size));

    }
}

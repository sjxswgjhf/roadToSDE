package RoadTo1K;

import java.util.ArrayList;
import java.util.List;

public class lt1213arraysIntersection {

    class Solution {
        /*
        三指针做法的话就是同时看三个指针的数，一样的话，就加到res，
        然后三个数取min，只有跟min一样的才需要往后移动，因为都是sorted，确保了不会遗漏
        */
        public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
            List<Integer> list = new ArrayList();
            int p1 = 0, p2 = 0, p3 = 0;
            while (p1 < arr1.length && p2 < arr2.length && p3 < arr3.length) {
                int min = Math.min(arr1[p1], Math.min(arr2[p2], arr3[p3]));
                if (arr1[p1] == arr2[p2] && arr1[p1] == arr3[p3]) list.add(arr1[p1]);
                if (arr1[p1] == min) p1++;
                if (arr2[p2] == min) p2++;
                if (arr3[p3] == min) p3++;
            }
            return list;
        }
    }

    class SolutionNSpace {
        public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
            int[] count = new int[2001];
            for(int a : arr1){
                count[a]++;
            }
            for(int a : arr2){
                count[a]++;
            }
            for(int a : arr3){
                count[a]++;
            }
            List<Integer> res = new ArrayList<>();
            for(int i = 1 ; i <= 2000; i++){
                if(count[i] == 3){
                    res.add(i);
                }
            }
            return res;
        }

    }
}

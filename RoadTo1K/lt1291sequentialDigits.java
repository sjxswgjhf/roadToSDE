package RoadTo1K;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lt1291sequentialDigits {

    class Solution {
        /*
        10 <= low <= high <= 10^9

        4: 1000~9999: 1234, 2345, 3456, 4567, 5678, 6789
        5: 10000~99999: 12345, 23456, 34567, 45678, 56789
        6: 100000~999999: 123456, 234567, 345678, 456789
        7: 1234567, 2345678, 3456789
        8: 12345678, 23456789
        9: 123456789
        */
        public List<Integer> sequentialDigits(int low, int high) {
            String sample = "123456789";
            int n = 10;
            List<Integer> nums = new ArrayList();

            int lowLen = String.valueOf(low).length();
            int highLen = String.valueOf(high).length();
            for (int length = lowLen; length <= highLen; length++) {
                for (int start = 0; start < n - length; ++start) {
                    int num = Integer.parseInt(sample.substring(start, start + length));
                    if (num >= low && num <= high) nums.add(num);
                }
            }
            return nums;
        }

    }

    class SolutionHardCode {
        /*
        10 <= low <= high <= 10^9

        4: 1000~9999: 1234, 2345, 3456, 4567, 5678, 6789
        5: 10000~99999: 12345, 23456, 34567, 45678, 56789
        6: 100000~999999: 123456, 234567, 345678, 456789
        7: 1234567, 2345678, 3456789
        8: 12345678, 23456789
        9: 123456789
        */
        public List<Integer> sequentialDigits(int low, int high) {
            int[] tens = {12,23,34,45,56,67,78,89};
            int[] hunds = {123,234,345,456,567,678,789};
            int[] thous = {1234, 2345, 3456, 4567, 5678, 6789};
            int[] tenthous = {12345, 23456, 34567, 45678, 56789};
            int[] hunthous = {123456, 234567, 345678, 456789};
            int[] mill = {1234567, 2345678, 3456789};
            int[] tenmill = {12345678, 23456789};
            int[] hunmill = {123456789};
            int[] billion = {};
            HashMap<Integer, int[]> map = new HashMap<>();
            map.put(2, tens);
            map.put(3, hunds);
            map.put(4, thous);
            map.put(5, tenthous);
            map.put(6, hunthous);
            map.put(7, mill);
            map.put(8, tenmill);
            map.put(9, hunmill);
            map.put(10, billion);
            int bot = String.valueOf(low).length();
            int up = String.valueOf(high).length();
            List<Integer> res = new ArrayList<>();
            for(int i = bot; i <= up; i++){
                int[] nums = map.get(i);
                for(int num : nums){
                    if(num >= low && num <= high){
                        res.add(num);
                    }
                }
            }
            return res;
        }
    }
}

package RoadTo1K;

import java.util.ArrayList;
import java.util.List;



public class lt1428leftMostColumnWithOne {
    // This is the BinaryMatrix's API interface.
    // You should not implement it, or speculate about its implementation
    class BinaryMatrix {
        public int get(int row, int col) {
            return 0;
        }
        public List<Integer> dimensions(){
            return new ArrayList<>();
        }
    };
    class Solution {
        public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
            List<Integer> size = binaryMatrix.dimensions();
            int row = size.get(0);
            int col = size.get(1);
            int l = 0;
            int r = col - 1;
            int res = 0;
            while(l <= r){
                int mid = (l + r) / 2;
                if(containsOne(row, mid, binaryMatrix)){
                    res = mid;
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
            // System.out.println(res);
            if(!containsOne(row, res, binaryMatrix)){
                return -1;
            }
            return res;
        }

        private boolean containsOne(int row, int col, BinaryMatrix binaryMatrix){
            for(int i = 0; i < row; i++){
                if(binaryMatrix.get(i, col) == 1){
                    return true;
                }
            }
            return false;
        }
    }
}

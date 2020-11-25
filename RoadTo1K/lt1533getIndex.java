package RoadTo1K;

public class lt1533getIndex {

    /**
     * // This is ArrayReader's API interface.
     * // You should not implement it, or speculate about its implementation
     */
      class ArrayReader {
          // Compares the sum of arr[l..r] with the sum of arr[x..y]
          // return 1 if sum(arr[l..r]) > sum(arr[x..y])
          // return 0 if sum(arr[l..r]) == sum(arr[x..y])
          // return -1 if sum(arr[l..r]) < sum(arr[x..y])
          public int compareSub(int l, int r, int x, int y) {return 1;}

          // Returns the length of the array
          public int length() {return 0;}
      }


    class Solution {
        /*
        因为长度存在奇偶的情况，求sum不能直接用mid，这样的话，可能half的长度不一样，
        所以要用mid当区间去求sum
        */
        public int getIndex(ArrayReader reader) {
            int l = 0;
            int r = reader.length() - 1;

            while(l < r){
            /*
            这里的half取upper bound，不能去lower bound，不然解决不了奇偶问题
            */
                int h = (r - l + 1) / 2;
            /*
            这样保证了两边都是一样的长度，左半边为h，右半边也为h
            */
                if(reader.compareSub(l, l + h - 1, l + h, l + 2 * h - 1) != 1){         //left is smaller
                    l = l + h;
                }
                else{
                    r = l + h - 1;
                }
            }
            return l;
        }
    }
}

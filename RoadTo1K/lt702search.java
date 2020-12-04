package RoadTo1K;

public class lt702search {

      class ArrayReader {
          public int get(int index) {
              return 1;
          }
      }

    class Solution {
        public int search(ArrayReader reader, int target) {
            int l = 0;
            int r = 10000;
            while(l <= r){
                int mid = (l + r) / 2;
                //正好找到
                if(reader.get(mid) == target){
                    return mid;
                }
                //mid超范围了，压缩右边，
                else if(reader.get(mid) == Integer.MAX_VALUE){
                    r = mid - 1;
                }else{
                    //mid没超范围，但是值小了
                    if(target > reader.get(mid)){
                        l = mid + 1;
                    }else{
                        //mid没超范围，但是值大了
                        r = mid - 1;
                    }
                }
            }
            return -1;
        }
    }
}

package RoadTo1K;

import java.util.PriorityQueue;
import java.util.Random;

public class lt215findKthLargest {

    class SolutionQuickSelect {
        int[] nums;
        Random rand;
        /*
        quick select:
        1.我们要找第k大的，就是要找到n-k小的，即from left to right在n-k这个位置的
        2.用quick select，先random选择一个范围内的idx，当做pivot，然后partition这个array，
        3.partition返回当前选择的idx所处的位置，如果比要找的大，就往前做quickselect，小的话就往后做quickselect
        4.partition的时候，我们先把idx的值跟尾巴交换，然后记录一个startidx，遍历整个array每遇到一个比pivot小的，
        就跟前面的startidx的值交换然后startidx往后移动一个，这样的话，最后我们startidx前面的都是比pivot小的值，
        然后我们再把尾巴的pivot跟startidx的值换回来，保证了pivot是在正确的对应的大小的位置，最后返回这个对应的位置

        */
        public int findKthLargest(int[] nums, int k) {
            this.nums = nums;
            int n = nums.length;
            rand = new Random();
            return quickselect(0, n - 1, n - k);
        }

        //find the n-kth smallest num
        private int quickselect(int l, int r, int k){
            if(l == r){
                return nums[l];
            }
            //choose pivot, start from l, exclude r
            int idx = l + rand.nextInt(r - l);
            idx = partition(l, r, idx);
            if(idx == k){
                return nums[idx];
            }
            // 第7小 > 第6小，往前找
            else if(idx > k){
                return quickselect(l, idx - 1, k);
            }
            else{
                return quickselect(idx + 1, r, k);
            }
        }

        //partition the array by the selected idx value
        private int partition(int left, int right, int idx){
            int pivot = nums[idx];
            //put pivot into the end, this won't effect the partition
            swap(idx, right);
            int store_idx = left;
            for(int i = left; i <= right; i++){
                if(nums[i] < pivot){
                    swap(store_idx, i);
                    store_idx++;
                }
            }
            //swap pivot into correct position
            swap(store_idx, right);
            return store_idx;
        }

        private void swap(int a, int b){
            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
        }
    }

    class SolutionHeap {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int num : nums){
                pq.add(num);
                if(pq.size() > k){
                    pq.poll();
                }
            }
            return pq.peek();
        }
    }
}

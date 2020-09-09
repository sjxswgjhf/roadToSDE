package microsoft;

public class sortColors {

    class SolutionOnePass{
        public void sortColors(int[] nums) {
            //三个指针，一个当前cur指针，用来走的，一个是front，一个是end，如果cur遇到了0就跟front交换，cur跟front都往后移动
            //如果遇到了2，那么end设置为2，把cur的值换成end的,这里cur不能移动，因为换过来的值可能是0，到时候需要跟前面的换,遇到1
            //就继续往后走
            if (nums == null || nums.length == 0) {
                return;
            }
            int front = 0, end = nums.length - 1, cur = 0;
            while (cur <= end) {
                if (nums[cur] == 0) {
                    nums[cur] = nums[front];
                    nums[front] = 0;
                    cur++;
                    front++;
                } else if (nums[cur] == 2) {
                    nums[cur] = nums[end];
                    nums[end] = 2;
                    end--;
                } else {
                    cur++;
                }
            }
        }
    }

    class SolutionCountSort {
        public void sortColors(int[] nums) {
            int[] counts = new int[3];
            for(int num : nums){
                counts[num]++;
            }
            int idx = 0;
            for(int i = 0; i < 3; i++){
                int count = counts[i];
                while(count-- > 0){
                    nums[idx++] = i;
                }
            }
        }
    }
}

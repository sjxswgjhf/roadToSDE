package RoadTo1K;

public class lt1330maxValueAfterReverse {
    /*

0 -1 2 -4 1
2
2 3 1 5 4
sum = 1 + 2 + 4 + 1 = 8

2 5 1 3 4
4
0 -3 4 2 1
sum + 2

5 1 3 2 4
0 4 2 1 2
2 - 1 = 1
sum = 9
思路：i~j是我要翻转的subarray，i~j里面的sum不会变，只要看两个边界的情况，
新的收益-旧的收益就是当前翻转的收益。
*/
    static class SolutionTLE {
        public int maxValueAfterReverse(int[] nums) {
            int sum = 0;
            int max = sum;
            for(int i = 0; i < nums.length - 1; i++){
                sum += Math.abs(nums[i] - nums[i + 1]);
            }
            int[][] dp = new int[nums.length][nums.length];
            // j =  左端点， i = 右端点
            for(int i = 0; i < nums.length; i++){
                for(int j = 0; j < i; j++){
                    int num1 = nums[j];
                    int num2 = nums[i];
                    int num3 = j == 0 ? 0: nums[j - 1];
                    int num4 = i == nums.length - 1 ? 0 : nums[i + 1];
                    int oldleft = num3 - num1;
                    int oldright = num2 - num4;
                    int newleft = num3 - num2;
                    int newright = num1 - num4;
                    int dif = j == 0 ? 0 : Math.abs(newleft) - Math.abs(oldleft);
                    int dif2 = i == nums.length - 1 ? 0 : Math.abs(newright) - Math.abs(oldright);
                    max = Math.max(max, sum + dif + dif2);
                }
            }
            return max;
        }
    }

}

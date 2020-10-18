package Bloomberg;

public class trapRainWater {

    class Solution {

        /*
        这题的核心思想是知道当前idx的左右bar是多少，就可以计算了，
        先用两个一维数组先计算左右bar
        然后再遍历一遍就可以得到结果，
        优化space的话要用双指针，核心思想是对于当前idx来说，只需要看左右的挡板的高度，
        那么如果左挡板低，右挡板高，虽然右挡板离他很远，但是因为左挡板已经是最近的了，所以只用考虑左挡板就好，
        右挡板不会影响到左挡板
         */
        public int trap(int[] height) {
            if(height == null || height.length == 0){
                return 0;
            }
            int n = height.length;
            int leftMax = height[0];
            int rightMax = height[n - 1];
            int res = 0;
            int l = 1, r = n - 2;
            while(l <= r){
                if(leftMax <= rightMax){
                    res += (leftMax - height[l]) < 0 ? 0 : leftMax - height[l];
                    leftMax = Math.max(leftMax, height[l]);
                    l++;
                }
                else{
                    res += (rightMax - height[r]) < 0 ? 0 : rightMax - height[r];
                    rightMax = Math.max(rightMax, height[r]);
                    r--;
                }
            }
            return res;
        }
    }
}

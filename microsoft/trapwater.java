package microsoft;

public class trapwater {

    /*
    双指针，根据左右max来判断移动短的那边，同时累计water,
     */
    public int trapTwoPointer(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int n = height.length;
        int res = 0;
        int l = 0;
        int r = n - 1;
        int lmax = height[0];
        int rmax = height[n - 1];
        while(l < r){
            if(lmax < rmax){
                res += lmax - height[l++];
                lmax = Math.max(lmax, height[l]);
            }else{
                res += rmax - height[r--];
                rmax = Math.max(rmax, height[r]);
            }
        }
        return res;
    }

    public int trapDP(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int res = 0;
        int n = height.length;
        int[] lmaxs = new int[n];
        int[] rmaxs = new int[n];
        lmaxs[0] = height[0];
        rmaxs[n - 1] = height[n - 1];
        for(int i = 1; i < n; i++){
            lmaxs[i] = Math.max(lmaxs[i - 1], height[i]);
        }
        for(int i = n - 2; i >= 0; i--){
            rmaxs[i] = Math.max(rmaxs[i + 1], height[i]);
        }
        for(int i = 0; i < n; i++){
            res += Math.min(lmaxs[i], rmaxs[i]) - height[i];
        }
        return res;
    }

    public int trapBF(int[] height) {
        int res = 0;
        //calculate each column's water by find left and right bar
        for(int i = 0; i < height.length; i++){
            int l = i;
            int r = i;
            int lmax = height[i];
            int rmax = height[r];
            while(l >= 0){
                lmax = Math.max(lmax, height[l--]);
            }
            while(r < height.length){
                rmax = Math.max(rmax, height[r++]);
            }
            res += Math.min(lmax, rmax) - height[i];
        }
        return res;
    }

}

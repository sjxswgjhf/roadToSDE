package Bloomberg;

public class lt1266minTimeToVisitAllPoints {

    class Solution {
        public int minTimeToVisitAllPoints(int[][] points) {
            //You have to visit the points in the same order as they appear in the array.
            //想了老子半天
            int ans = 0;
            for(int i = 1; i < points.length; i++){
                int[] p1 = points[i - 1];
                int[] p2 = points[i];
                ans += Math.max(Math.abs(p1[0] - p2[0]), Math.abs(p1[1] - p2[1]));

            }
            return ans;
        }
    }

}

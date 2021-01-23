package dailyProblem;

class Solution {
    /*
    houses找最近的heater在哪
    
    */
    public int findRadius(int[] houses, int[] heaters) {
        int max = Integer.MAX_VALUE;
        int prevIdx = -1;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(heaters));
        int houseId = 0;
        while(houseId < houses.length){
            if(prevIdx == -1){
                prevIdx = queue.poll();
            }
            while(!queue.isEmpty() && Math.abs(prevIdx - houses[houseId]) > Math.abs(houses[houseId] - queue.peek())){
                prevIdx = queue.poll();
            }
            max = Math.max(Math.abs(prevIdx - house[houseId]), max);
        }
        return max;
    }
}
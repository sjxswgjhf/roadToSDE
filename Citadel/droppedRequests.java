package Citadel;

import java.util.HashMap;

public class droppedRequests {



    private static int dropRquest(int[] requests){
        if(requests == null || requests.length == 0){
            return 0;
        }

        final int MAX_PER_SECOND = 3;
        final int MAX_PER_TEN_SECONDS = 20;
        final int MAX_PER_MINUTE = 60;
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxReq = requests[requests.length - 1];
        for(int request : requests){
            map.put(request, map.getOrDefault(request, 0) + 1);
        }
        int drops = 0;
        int[] numOfReqs = new int[maxReq + 1];
        for(int i = 1; i < numOfReqs.length; i++){
            int reqs = map.getOrDefault(i, 0);
            numOfReqs[i] = numOfReqs[i-1];
            if(reqs == 0){
                continue;
            }
            //2<3 = 2, 4 > 3 = 3
            int reqsInSecond = findInSecond(reqs, MAX_PER_SECOND);
            int reqsInTenSecond = findSolveableNum(reqs, numOfReqs, i, MAX_PER_TEN_SECONDS);
            int reqsInMinute = findSolveableNum(reqs, numOfReqs, i, MAX_PER_MINUTE);
            int reqsCouldSolve = Math.min(reqsInSecond, Math.min(reqsInMinute, reqsInTenSecond));
            drops += reqs - reqsCouldSolve;
            numOfReqs[i] += reqs;
        }
        return drops;
    }

    private static int findInSecond(int reqs, int threshold){
        if(reqs > threshold){
            return 3;
        }else{
            return reqs;
        }
    }

    private static int findSolveableNum(int reqs, int[] numOfReqs, int cur, int threshold){
        int tenSecondBefore = Math.max(0, cur - 10);
        int numReqsInTenSecond = numOfReqs[cur] - numOfReqs[tenSecondBefore];
        if(numReqsInTenSecond > threshold){
            return 0;
        }
        else{
            // 20 - 10 = 10 > 3 return 3 || 20 - 18 = 2 > 3 return 2
            return threshold - numReqsInTenSecond > reqs ? reqs : threshold - numReqsInTenSecond;
        }
    }

    private static int findInMinute(int reqs, int[] numOfReqs, int cur, int threshold){
        int oneMinuteBefore = Math.max(0, cur - 60);
        int numReqsInMinute= numOfReqs[cur] - numOfReqs[oneMinuteBefore];
        if(numReqsInMinute> threshold){
            return 0;
        }
        else{
            //60 - 52 = 8 > 3 return 3 || 60 - 59 = 1 < 3 return 1;
            return threshold - numReqsInMinute > reqs ? reqs : threshold - numReqsInMinute;
        }
    }

    public static void main(String[] args) {
        int[] requestTime1 = new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 11, 11, 11};
        int[] requestTime2 = new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 11, 11, 11, 11};
        int[] requestTime3 = new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 9,
                10, 10, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 14, 14, 14, 14, 14, 16, 16, 16, 16, 16,
                16, 17, 17, 17, 18, 18, 18, 18, 18, 18, 18, 18, 19, 19, 19, 19, 19, 19, 19, 20, 20, 20, 20, 20};
        System.out.println(dropRquest(requestTime1));
        System.out.println(dropRquest(requestTime2));
        System.out.println(dropRquest(requestTime3));
    }
}

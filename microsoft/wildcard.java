package microsoft;

public class wildcard {


    class SolutionTwoPointer {
        public boolean isMatch(String s, String p) {
            int spointer = 0, ppointer = 0, match = 0, starIdx = -1;
            while(spointer < s.length()){
                /*
                当str跟pattern一样的时候，都移动一位，或者pattern是个？
                 */
                if(ppointer < p.length() && (p.charAt(ppointer) == '?' || p.charAt(ppointer) == s.charAt(spointer))){
                    spointer++;
                    ppointer++;
                }
                /*
                当str跟pattern不一样的时候，但是pattern现在的是个*,记录pattern的star idx，然后移动pattern的pointer
                用match去记录str的位置。
                两种情况：一种可能是*去cover start的char
                        另一种是*要成为空
                 */
                else if(ppointer < p.length() && p.charAt(ppointer) == '*'){
                    starIdx = ppointer;
                    ppointer++;
                    match = spointer;
                }
                /*
                这里发现str跟pattern不一样，那么要看之前有没有遇到*，需要用*去覆盖
                即starIdx != -1，把ppointer调整回star的下一位，然后移动match，把str的pointer用match只回,
                这个match记录了一开始str被 * cover的位置，然后后续如果继续被cover就去increase并保证spointer的更新，
                因为spointer是用来作char对比的指针
                 */
                else if(starIdx != -1){
                    ppointer = starIdx + 1;
                    match++;
                    spointer = match;
                }else{
                    return false;
                }
            }
            //当str走完了，那么pattern可能没走完，但是如果要是match的话，pattern里面剩下的char就要全部是*
            while(ppointer < p.length() && p.charAt(ppointer) == '*'){
                ppointer++;
            }
            return ppointer == p.length();
        }
    }
}

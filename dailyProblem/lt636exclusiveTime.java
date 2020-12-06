package dailyProblem;

import java.util.List;
import java.util.Stack;

public class lt636exclusiveTime {

    class SolutionFast {
        /*
        优化就是一段段计算时间，既然我们知道了两个log之间的time stamp的diff了，
        我们直接可以计算这个dif然后累积就好，
        但是要注意区别，首先如果两个都是start的time diff
        如例子2 - 0 = 2
        但是start 跟 end 是 5 - 2 = 3？ 不对，5 - 2 + 1 = 4
        再接下来，我们要更新time，首先start跟start之间，我们直接把0替换成2就可以，
        这样计算的时候后来计算end的时候就是正确的，
        如果是start跟end的pair，我们要time = curtime + 1，因为如果是 start 2 ~ end 5, start 6的话，不设置成+1，
        会累积之前任务的time，但是其实是不应该累积的，同里如果下一个是end，我们不+1的话会累积一个1，但是我们计算time的时候
        已经考虑进去了
        最后我们还要考虑start时候stack为空的情况，可能是start end start的组合，所以不判断为空的话会报empty的错误
        这题优化版的坑很多
        */
        public int[] exclusiveTime(int n, List<String> logs) {
            Stack<Integer> stack = new Stack<>();
            int[] res = new int[n];
            String[] log = logs.get(0).split(":");
            stack.push(Integer.parseInt(log[0]));
            int time = Integer.parseInt(log[2]);
            for(int i = 1; i < logs.size(); i++){
                log = logs.get(i).split(":");
                int curTime = Integer.parseInt(log[2]);
                if(log[1].equals("start")){
                    if(!stack.isEmpty())
                        res[stack.peek()] += curTime - time;    //2 - 0 = 2
                    time = curTime;
                    stack.push(Integer.parseInt(log[0]));
                }else{
                    res[stack.peek()] += curTime - time + 1;        //5 - 2 = 3 + 1 = 4
                    time = curTime + 1;
                    stack.pop();
                }
            }
            return res;
        }
    }

    class SolutionSlow {
        /*
        0 <= timestamp <= 109
        因为项目是跟time一格格涨的，当执行另一个task的时候即使是一样的id，前面的task也会暂停先，当后来的task结束了，
        前面的task才会继续执行，time的cost也不会累积这段暂停的时间
        利用这个性质，我们stack储存当前项目的任务，
        首先下一个项目进来了，我们先while的increase 当前项目的time cost到下一个进来项目的时间之前，
        然后我们在看判断当前是end还是start，如果是end的话，我们就再增长到该时间，然后pop掉当前项目，继续移动logs，
        如果是另一个start，我们把这个start的项目放到stack顶部，这样我们下个log进来的时候增长的就是这个项目，
        而不是之前那个项目了，那个项目会增长
        单调Stack
        这个解法是O(T), t = 1e9
        这个解法的速度比较慢，因为while loop的增长是一次次的不是一段段的，我们完全可以做到一段段，
        可以优化
        */
        public int[] exclusiveTime(int n, List<String> logs) {
            Stack<Integer> stack = new Stack<>();
            int[] res = new int[n];
            String[] log = logs.get(0).split(":");
            stack.push(Integer.parseInt(log[0]));
            int time = Integer.parseInt(log[2]);
            for(int i = 1; i < logs.size(); i++){
                log = logs.get(i).split(":");
                int curTime = Integer.parseInt(log[2]);
                while(time < curTime){
                    res[stack.peek()]++;
                    time++;
                }
                if(log[1].equals("start")){
                    stack.push(Integer.parseInt(log[0]));
                }
                else{
                    res[stack.peek()]++;
                    time++;
                    stack.pop();
                }
            }
            return res;
        }
    }
}

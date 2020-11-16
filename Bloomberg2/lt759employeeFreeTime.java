package Bloomberg2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class lt759employeeFreeTime {


// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};


    class SolutionWrong {
        /*
        [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]

        1,3 6,7, 9, 12
        2,4
        2,5

        5 6
        7 9


       interval overlapping
        case 1: 3 5 4 6
        case 2: 3 5 2 6
        case 3: 3 5 2 4
        case 4: 3 5 3 4

can't handle: [[[0,1],[12,19],[42,54],[78,80],[89,93]],[[5,10],[30,62],[69,73],[80,83],[90,100]],[[13,21],[23,29],[42,43],[86,91],[97,100]],[[0,11],[24,25],[30,58],[76,93],[94,97]],[[1,3],[46,50],[56,58],[71,73],[77,99]]]
        */

        /*
        扫描线算法，直接把所有interval放到一起之后，我们排序，
        然后扫面，维护curend，初始为第一个的end，当我们遇到下一格的start 大于 end的话就表示遇到gap了，然后更新curend
        如果不是的话，我们遇到了一个overlap，我们也要看curend跟next的end哪个大，可能需要更新，
        那把两个更新end合起来就是每次都take max就好
         */
        class Solution {
            public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
                List<Interval> list = new ArrayList<>();
                for(List<Interval> emp : schedule){
                    for(Interval interval : emp){
                        list.add(interval);
                    }
                }
                Collections.sort(list, (a,b)-> a.start == b.start ? a.end - b.end : a.start - b.start);
                int curend = list.get(0).end;
                List<Interval> res = new ArrayList<>();
                for(Interval next : list){
                    if(next.start > curend){
                        res.add(new Interval(curend, next.start));
                    }
                    curend = Math.max(curend, next.end);
                }
                return res;
            }
        }


        public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
            Collections.sort(schedule, (a,b) -> a.get(0).start == b.get(0).start ? a.get(0).end - b.get(0).end : a.get(0).start - b.get(0).start);
            List<int[]> list = new ArrayList<>();
            for(List<Interval> emp : schedule){
                for(int i = 0; i < emp.size(); i++){
                    boolean find = false;
                    if(list.size() == 0){
                        list.add(new int[]{emp.get(i).start, emp.get(i).end});
                        find = true;
                    }else{
                        int size = list.size();
                        for(int j = 0; j < size; j++){
                            // 3 5 4 6
                            if(list.get(j)[0] <= emp.get(i).start && list.get(j)[1] >= emp.get(i).start){
                                list.get(j)[1] = Math.max(emp.get(i).end, list.get(j)[1]);
                                find = true;
                                break;
                            }
                            // 3 5 2 6
                            else if(list.get(j)[0] >= emp.get(i).start && list.get(j)[1] <= emp.get(i).end){
                                list.get(j)[1] = emp.get(i).end;
                                list.get(j)[0] = emp.get(i).start;
                                find = true;
                                break;
                            }
                            // 3 5 2 4
                            else if(list.get(j)[0] >= emp.get(i).start && list.get(j)[1] >= emp.get(i).end){
                                list.get(j)[0] = emp.get(i).start;
                                find = true;
                                break;
                            }
                            else if(list.get(j)[0] >= emp.get(i).start && list.get(j)[1] >= emp.get(i).end){
                                find = true;
                                break;
                            }
                            else{
                                continue;
                            }
                        }
                        if(!find){
                            list.add(new int[]{emp.get(i).start, emp.get(i).end});
                        }
                    }
                }
            }
            Collections.sort(list, (a,b)->a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            List<Interval> res = new ArrayList<>();
            for(int[] v : list)
            {
                System.out.println(v[0] + " "+v[1]);
            }
            return res;
        }
    }
}

package BloombergOnsite;

import java.util.ArrayList;
import java.util.List;

public class lt1472BrowserHistory {

    class BrowserHistory {


        List<String> list;
        int idx;

        public BrowserHistory(String homepage) {
            list = new ArrayList<>();
            list.add(homepage);
            idx = 0;
        }

        public void visit(String url) {
            while(list.size() > idx + 1){
                list.remove(list.size() - 1);
            }
            list = list.subList(0, idx + 1);    //subList(from, to). from inclusive, to exclusive, 但是效率比while的remove慢很多
            list.add(url);
            idx++;
        }

        public String back(int steps) {
            //这里要用当前idx，因为back可以跟着back，用idx来track当前的变化
            if(steps >= idx + 1){
                idx = 0;
            }else{
                idx = idx - steps;
            }
            return list.get(idx);
        }

        public String forward(int steps) {
            if(steps + idx >= list.size()){
                idx = list.size() - 1;
            }else{
                idx = steps + idx;
            }
            return list.get(idx);
        }
    }


}

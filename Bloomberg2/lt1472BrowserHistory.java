package Bloomberg2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class lt1472BrowserHistory {

    class BrowserHistory {

        /*
        arryaylist: cur idx is where we are by forward and backward
        visit: clean all the thing after cur idx and add the new url to list, cur++

        */
        int cur;
        List<String> list;
        public BrowserHistory(String homepage) {
            list = new ArrayList<>();
            list.add(homepage);
            cur = 0;
        }

        public void visit(String url) {
            int size = list.size();
            for(int i = size - 1; i > cur; i++){
                list.remove(i);
            }
            list.add(url);
            cur++;
        }

        public String back(int steps) {
            if(steps >= cur + 1){
                cur = 0;
            }else{
                cur = cur - steps;
            }
            return list.get(cur);
        }

        public String forward(int steps) {
            if(steps + cur >= list.size()){
                cur = list.size() - 1;
            }else{
                cur = cur + steps;
            }
            return list.get(cur);
        }
    }


}

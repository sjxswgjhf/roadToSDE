package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class bs794webBrowser {


    class WebBrowser {


        List<String> list;
        int idx = 0;    //tracking the idx of the current page
        public WebBrowser(String homepage) {
            list = new ArrayList<>();
            list.add(homepage);
        }

        //clean all forward history
        public void visit(String page) {
            // list = list.subList(0, idx + 1);
            while(list.size() > idx + 1){
                list.remove(list.size() - 1);
            }
            list.add(page);
            idx++;
        }

        public String back(int n) {
            if(n > idx){
                idx = 0;
            }
            else{
                idx = idx - n;
            }
            return list.get(idx);
        }

        public String forward(int n) {
            if(idx + n >= list.size()){
                idx = list.size() - 1;
            }else{
                idx = idx + n;
            }
            return list.get(idx);
        }
    }

}

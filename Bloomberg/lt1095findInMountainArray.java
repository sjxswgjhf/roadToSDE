package Bloomberg;

interface MountainArray {
    public int get(int index);
    public int length();
}

public class lt1095findInMountainArray {



    class SolutionTLE {
        /*
        这题知道了peak的位置就很好做了。
        一开始想着不去找peak，通过情况分析去做，然后发现情况太多了，写的代码不能全部覆盖而且十分杂乱难懂，
        但是一旦知道peak了之后就很好去写binary search了。当然找peak是一大难点。
         */
        public int findInMountainArray(int target, MountainArray mountainArr) {

            int len = mountainArr.length();
            boolean find = false;
            //increasing
            if(mountainArr.get(len / 2 - 1) < mountainArr.get(len / 2)){
                if(target < mountainArr.get(len / 2)){
                    int l = 0;
                    int r = len / 2;
                    while(l < r){
                        int mid = (l + r) / 2;
                        int midVal = mountainArr.get(mid);
                        if(target == midVal){
                            return mid;
                        }
                        else if(target > midVal){
                            l = mid + 1;
                        }else{
                            r = mid;
                        }
                    }
                    l = len / 2;
                    r = len;
                    while(l < r){
                        int mid = (l + r) / 2;
                        int midVal = mountainArr.get(mid);
                        if(target == midVal){
                            return mid;
                        }
                        else if(target > midVal){
                            r = mid;
                        }else{
                            l = mid + 1;
                        }
                    }
                }else{
                    int l = len / 2;
                    int r = len;
                    while(l < r){
                        int mid = (l + r) / 2;
                        int midVal = mountainArr.get(mid);
                        if(target == midVal){
                            return mid;
                        }
                        else if(target > midVal){
                            r = mid;
                        }else{
                            l = mid + 1;
                        }
                    }
                    l = 0;
                    r = len / 2;
                    while(l < r){
                        int mid = (l + r) / 2;
                        int midVal = mountainArr.get(mid);
                        if(target == midVal){
                            return mid;
                        }
                        else if(target > midVal){
                            r = mid;
                        }else{
                            l = mid + 1;
                        }
                    }
                }
            }
            //decreasing
            else{
                if(target < mountainArr.get(len / 2)){
                    int l = len / 2;
                    int r = len;
                    while(l < r){
                        int mid = (l + r) / 2;
                        int midVal = mountainArr.get(mid);
                        if(target == midVal){
                            return mid;
                        }else if(target < midVal){
                            l = mid + 1;
                        }else{
                            r = mid;
                        }
                    }
                    l = 0;
                    r = len / 2;
                    while(l < r){
                        int mid = (l + r) / 2;
                        int midVal = mountainArr.get(mid);
                        if(target == midVal){
                            return mid;
                        }
                        else if(target < midVal){
                            r = mid;
                        }else{
                            l = mid + 1;
                        }
                    }
                }
                else{
                    int l = 0;
                    int r = len / 2;
                    while(l < r){
                        int mid = (l + r) / 2;
                        int midVal = mountainArr.get(mid);
                        if(target == midVal){
                            return mid;
                        }
                        else if(target < midVal){
                            r = mid;
                        }else{
                            l = mid + 1;
                        }
                    }
                    l = len / 2;
                    r = len;
                    while(l < r){
                        int mid = (l + r) / 2;
                        int midVal = mountainArr.get(mid);
                        if(target == midVal){
                            return mid;
                        }else if(target < midVal){
                            l = mid + 1;
                        }else{
                            r = mid;
                        }
                    }
                }
            }
            return -1;

        }


    }
}

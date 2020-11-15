package Bloomberg2;

import java.util.HashMap;

public class lt1583unhappyFriends {

    class Solution {
        /*
        自己写的
        这题是先看我当前的配对是不是我想要配对的，如果不是，那么我想要配对的那个人的配对的对象是不是在那个人心目中比我的优先级跟高，
        是的话，那没关系，不是的话，我就是不开心的
        */
        public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int[] pair : pairs){
                map.put(pair[0], pair[1]);
                map.put(pair[1], pair[0]);
            }
            int res = 0;
            for(int[] pair : pairs){
                if(!isHappy(pair[0], pair[1], map, preferences)){
                    res += 1;
                }
                if(!isHappy(pair[1], pair[0], map, preferences)){
                    res += 1;
                }
            }
            return res;
        }

        private boolean isHappy(int person, int mate, HashMap<Integer, Integer> map, int[][] preferences){
            for(int prefer : preferences[person]){
                if(mate == prefer){
                    return true;
                }else{
                    //我要看我当前prefer那个人的配对的对象是不是在那人的心目中更优先
                    int pair = map.get(prefer);
                    for(int pre : preferences[prefer]){
                        if(pre == person){
                            return false;
                        }else if(pre == pair){
                            break;
                        }
                    }
                }
            }
            return true;
        }
    }

    class SolutionDiscussion {
        /*
        抄的
        这题是先看我当前的配对是不是我想要配对的，如果不是，那么我想要配对的那个人的配对的对象是不是在那个人心目中比我的优先级跟高，
        是的话，那没关系，不是的话，我就是不开心的
        */
        public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int[] pair : pairs){
                map.put(pair[0], pair[1]);
                map.put(pair[1], pair[0]);
            }
            int res= 0;
            for(int[] pair : pairs){
                if(isHappy(pair[0], pair[1], preferences, map) != -1){
                    res += 1;
                }
                if(isHappy(pair[1], pair[0], preferences, map) != -1){
                    res += 1;
                }
            }
            return res;
        }

        private int isHappy(int person, int curMate, int[][] preferences, HashMap<Integer, Integer> map){
            for(int prefer : preferences[person]){
                if(prefer == curMate){
                    return -1;
                }else{
                    //查看我想配对的那个人是不是好的配对
                    int matesOfprefer = map.get(prefer);
                    for(int matesMate : preferences[prefer]){
                        //如果person是优先的，那么那个人不开心
                        if(matesMate == person){
                            return prefer;
                            //如果person在想要配对的人的配对的人的后面就是happy的
                        }else if(matesMate == matesOfprefer){
                            break;
                        }
                    }
                }
            }
            return -1;
        }
    }
}
